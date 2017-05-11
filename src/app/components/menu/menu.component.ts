import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { MdMenuTrigger } from '@angular/material';

import { User } from '../../model/user';
import { Category } from '../../model/categories/category';
import { EnumUserRole } from '../../model/enum-user-role';
import { ItemName } from '../../model/items/item-name';

import { ItemService } from '../../services/server/item.service';
import { CategoryService } from '../../services/server/category.service';
import { UserFormService } from '../../services/client/user.form.service';

@Component( {
    selector: 'menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css']
} )
export class Menu implements OnInit  {

    categories:Category[];
    user:User;

    constructor(private itemService : ItemService,
                private categoryService : CategoryService,
                private router : Router,
                private userFormService : UserFormService) {
                    this.userFormService.userConnexionEvent$.subscribe(user => this.user = user);
                    this.userFormService.userDisconnexionEvent$.subscribe(none => this.user = null);
                }

    ngOnInit():void
    {
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if(currentUser != null)
        {
            this.user = new User(currentUser.login, currentUser.password,EnumUserRole[EnumUserRole[currentUser.role]]);
        }
        this.categories = this.categoryService.getCategories();
        for(let category of this.categories)
        {
            category.itemsName = this.itemService.getItemsNameForCategorie(category);
        }
    }

    navigateToItem(item: ItemName): void{
        this.router.navigate(['/get', item.id])
    }

    navigateToCategory(category: Category):void{
        this.router.navigate(['/show', category.code]);
    }
}