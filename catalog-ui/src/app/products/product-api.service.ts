import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product, CreateProductRequest } from './product.model';

@Injectable({ providedIn: 'root' })
export class ProductApiService {
  private http = inject(HttpClient);

  // If you use Angular proxy, keep it relative:
  private baseUrl = '/api/products';

  list(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl);
  }

  create(req: CreateProductRequest): Observable<Product> {
    return this.http.post<Product>(this.baseUrl, req);
  }
}
