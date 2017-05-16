import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MdMenuTrigger } from '@angular/material';

import { User } from '../../model/user';
import { Category } from '../../model/categories/category';
import { EnumUserRole } from '../../model/enum-user-role';
import { ItemName } from '../../model/items/item-name';

import { ItemService } from '../../services/item.service';
import { CategoryService } from '../../services/category.service';
import { Auth } from '../../services/auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  categories: Category[];
  user: User;

  constructor(private itemService: ItemService,
    private categoryService: CategoryService,
    private router: Router,
    protected auth: Auth) { }

  ngOnInit(): void {
    this.categoryService.getCategories().then(categories => this.initCategories(categories));
  }

  private initCategories(categories): void {
    this.categories = categories;
    for (const category of this.categories) {
      category.itemsName = this.itemService.getItemsNameForCategorie(category);
    }
  }

  navigateToItem(item: ItemName): void {
    this.router.navigate(['/get', item.id]);
  }

  navigateToCategory(category: Category): void {
    this.router.navigate(['/show', category.code]);
  }
}
