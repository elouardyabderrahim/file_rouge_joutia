/*import { Component, OnInit } from '@angular/core';
import { Products } from 'src/app/common/products';

import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  //templateUrl: './product-list.Component.html',
  templateUrl: './product-list-table.Component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  constructor(private productService: ProductService) {}
  'products': Products[];
  ngOnInit() {
    this.listProducts();
  }
  private listProducts() {
    this.productService.getProductList().subscribe((data) => {
      this.products = data;
    });
  }
}*/

import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Products } from 'src/app/common/products';
import { ActivatedRoute } from '@angular/router';
/*@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.Component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  products!: Products[];
  currentCategoryId!: number;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute
  ) {}
  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }
  listProducts() {
    //chick if "id" paramater is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');
    if (hasCategoryId) {
      this.currentCategoryId = Number(this.route.snapshot.paramMap.get('id'));

      //get the "id" param string. convert string to a number using the "+" symbole
    } else {
      //not available ------> default categorie
      this.currentCategoryId = 1;
    }

    this.productService
      .getProductList(this.currentCategoryId)
      .subscribe((data) => {
        this.products = data;
      });
  }
}*/
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css'],
})
export class ProductListComponent implements OnInit {
  'products': Products[];
  'currentCategoryId': number;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
  }

  listProducts() {
    // check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasCategoryId) {
      // get the "id" param string. convert string to a number using the "+" symbol
      this.currentCategoryId = Number(this.route.snapshot.paramMap.get('id'));
    } else {
      // not category id available ... default to category id 1
      this.currentCategoryId = 1;
    }

    // now get the products for the given category id
    this.productService
      .getProductList(this.currentCategoryId)
      .subscribe((data) => {
        this.products = data;
      });
  }
}
