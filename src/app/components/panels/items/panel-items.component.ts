import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute, Params } from '@angular/router';
import { Location }               from '@angular/common';

import {ItemLite} from '../../../model/items/item-lite';
import {Category} from '../../../model/categories/category';
import {User} from '../../../model/user';
import {EnumUserRole} from '../../../model/enum-user-role';
import {ItemService} from '../../../services/server/item.service';
import {CategoryService} from '../../../services/server/category.service';
import {UserFormService} from '../../../services/client/user.form.service';

@Component({
  selector: 'panel-items',
  templateUrl: './panel-items.component.html',
  styleUrls : ['./panel-items.component.css']
})
export class PanelItems implements OnInit{

  private category:Category;

  private items:ItemLite[];

  private user:User;

  constructor(private itemService : ItemService,
              private categoryService : CategoryService,
              private userFormService : UserFormService,
              private route: ActivatedRoute,
              private location: Location,
              private router : Router)
        {
            this.userFormService.userConnexionEvent$.subscribe(user => this.user = user);
            this.userFormService.userDisconnexionEvent$.subscribe(none => this.user = null);
        }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.categoryService.getCategory(params['code']))
            .subscribe(category => this.items = this.itemService.getItemsLite(category));
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if(currentUser != null)
        {
            this.user = new User(currentUser.login, currentUser.password,EnumUserRole[EnumUserRole[currentUser.role]]);
        }
    }

    editItem(item: ItemLite): void{
        this.router.navigate(['/edit', item.id]);
    }

    readItem(item: ItemLite): void{
        this.router.navigate(['/get', item.id])
    }
}