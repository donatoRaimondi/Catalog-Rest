import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { finalize } from 'rxjs';
import { ProductApiService } from '../product-api.service';
import { Product } from '../product.model';

@Component({
  selector: 'app-products-page',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './products-page.component.html',
})
export class ProductsPageComponent implements OnInit {
  private api = inject(ProductApiService);

  products: Product[] = [];
  name = '';

  loading = false;
  adding = false;

  loadError: string | null = null;
  addError: string | null = null;

  ngOnInit(): void {
    this.refresh();
  }

  refresh(): void {
    this.loading = true;
    this.loadError = null;

    this.api.list()
      .pipe(finalize(() => (this.loading = false)))
      .subscribe({
        next: (items) => (this.products = items),
        error: (err) => {
          this.products = [];
          this.loadError = this.humanizeHttpError(err);
        },
      });
  }

  add(): void {
    const trimmed = this.name.trim();
    if (!trimmed) return;

    this.adding = true;
    this.addError = null;

    this.api.create({ name: trimmed })
      .pipe(finalize(() => (this.adding = false)))
      .subscribe({
        next: () => {
          this.name = '';
          this.refresh();
        },
        error: (err) => {
          this.addError = this.humanizeHttpError(err);
        },
      });
  }

  trackById(_: number, p: Product) {
    return p.id;
  }

  private humanizeHttpError(err: any): string {
    // Keep it simple; you can map status codes later
    if (err?.status) return `HTTP ${err.status} - ${err.statusText ?? 'Error'}`;
    return 'Network / server error';
  }
}
