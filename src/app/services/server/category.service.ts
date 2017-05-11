import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { Item } from '../../model/items/item';
import { ItemName } from '../../model/items/item-name';
import { ItemLite } from '../../model/items/item-lite';
import { Category } from '../../model/categories/category';
import { User } from '../../model/user';
import { EnumUserRole } from '../../model/enum-user-role';

@Injectable()
export class CategoryService {

    cat1:Category = new Category(1, 'tombe', 'Tombes',true);
    cat2:Category = new Category(2, 'temple', 'Temples',true);
    cat3:Category = new Category(3, 'autre', 'Autres bizarreries',false);

    getCategories():Category[]{
        return [this.cat1, this.cat2, this.cat3];
    }

    getCategory(code:string):Promise<Category>{
        if(code == this.cat1.code)
        {
            return Promise.resolve(this.cat1);
        }
        else if(code == this.cat2.code)
        {
            return Promise.resolve(this.cat2);
        }
        else{
            return Promise.resolve(this.cat3);
        }
    }
}