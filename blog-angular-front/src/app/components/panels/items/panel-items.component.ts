import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ItemLite } from '../../../model/items/item-lite';
import { Category } from '../../../model/categories/category';
import { User } from '../../../model/user';
import { EnumUserRole } from '../../../model/enum-user-role';
import { ItemService } from '../../../services/item.service';
import { CategoryService } from '../../../services/category.service';
import { Auth } from '../../../services/auth.service';

@Component({
  selector: 'app-panel-items',
  templateUrl: './panel-items.component.html',
  styleUrls: ['./panel-items.component.css']
})
export class PanelItemsComponent implements OnInit {

  private category: Category;

  protected items: ItemLite[];

  private user: User;

  constructor(private itemService: ItemService,
    private categoryService: CategoryService,
    protected auth: Auth,
    private route: ActivatedRoute,
    private location: Location,
    private router: Router) { }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.categoryService.getCategory(params['code']))
      .subscribe(category => this.itemService.getItemsLite(category).then(items => this.items = items));
  }

  editItem(item: ItemLite): void {
    this.router.navigate(['/edit', item.id]);
  }

  readItem(item: ItemLite): void {
    this.router.navigate(['/get', item.id]);
  }
}
