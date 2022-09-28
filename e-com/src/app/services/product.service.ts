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
    const searchUrl =
      'http://localhost:8080/api/products/search/findByCategory/' +
      '${theCategoryId}';
    return this.httpClient
      .get<GetResponseProducts>(searchUrl)
      .pipe(map((response) => response.products));
  }

  getProducts() {
    return this.httpClient.get(this.baseUrl);
  }

  getCategories() {
    return this.httpClient.get(this.categoryUrl);
  }
  // getProductbyCategoryId(){
  //   return this.httpClient.get(this.categoryUrl);
  // }
  //getCategories(): Observable<Category[]> {
  // return this.httpClient
  //  .get<GetResponseCategory>(this.categoryUrl)
  // .pipe(map((response) => response.category));
} //

interface GetResponseProducts {
  products: Products[];
}
interface GetResponseCategory {
  category: Category[];
}
