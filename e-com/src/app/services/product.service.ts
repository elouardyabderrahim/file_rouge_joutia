/*import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { Products } from '../common/products';
//reactive java script = rxjs
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) {}
  getProductList(): Observable<Products[]> {
    return this.httpClient.get<Products[]>(`${this.baseUrl}` + '/api/products');
  }
}
interface GetResponse {
  products: Products[];
}*/
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ROUTES } from '@angular/router';
import { map, Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { Products } from '../common/products';
import { Routes } from '@angular/router';
import { AppModule } from '../app.module';
import { Category } from '../common/category';
//reactive java script = rxjs
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/api/products';
  private categoryUrl = 'http://localhost:8080/api/category';

  constructor(private httpClient: HttpClient) {}
  getProductList(theCategoryId: number): Observable<Products[]> {
    //@toDo:need build url based on categorie id ;; comeback
    const searchUrl = `${this.baseUrl}/search/findByCategory${theCategoryId}`;
    return this.httpClient
      .get<GetResponseProducts>(searchUrl)
      .pipe(map((response) => response.products));
  }

  getCategories(): Observable<Category[]> {
    return this.httpClient
      .get<GetResponseCategory>(this.categoryUrl)
      .pipe(map((response) => response.category));
  }
}
interface GetResponseProducts {
  products: Products[];
}
interface GetResponseCategory {
  category: Category[];
}
/*
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products } from '../common/products';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  private baseUrl = 'http://localhost:8080/api/products';

  constructor(private httpClient: HttpClient) {}

  getProductList(theCategoryId: number): Observable<Products[]> {
    // need to build URL based on category id
    const searchUrl = `${this.baseUrl}/search/findByCategory+id=${theCategoryId}`;

    return this.httpClient
      .get<GetResponse>(searchUrl)
      .pipe(map((response) => response.products));
  }
}

interface GetResponse {
  products: Products[];
}*/
/*
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products';

  constructor(private httpClient: HttpClient) { }

  getProductList(theCategoryId: number): Observable<Product[]> {

    // need to build URL based on category id 
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;

    return this.httpClient.get<GetResponse>(searchUrl).pipe(
      map(response => response._embedded.products)
    );
  }
}

interface GetResponse {
  _embedded: {
    products: Product[];
  }
}



*/
