import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/common/category';
import { Products } from 'src/app/common/products';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-categoty-menu',
  templateUrl: './categoty-menu.component.html',
  styleUrls: ['./categoty-menu.component.css'],
})
export class CategotyMenuComponent implements OnInit {
  categories: any = [];
  listproduct!: Products[];
  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.listCategories();
  }

  listCategories() {
    this.productService.getCategories().subscribe((data) => {
      this.categories = data;
    });
  }

  bypid(id: number) {
    this.productService.getProductList(id).subscribe((data) => {
      this.listproduct = data;
    });
  }
}
