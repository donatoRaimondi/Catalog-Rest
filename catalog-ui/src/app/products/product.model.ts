export interface Product {
  id: string;
  name: string;
  active: boolean;
}

export interface CreateProductRequest {
  name: string;
}
