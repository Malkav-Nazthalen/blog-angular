import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Item } from '../model/items/item';
import { ItemName } from '../model/items/item-name';
import { ItemLite } from '../model/items/item-lite';
import { Category } from '../model/categories/category';
import { User } from '../model/user';
import { EnumUserRole } from '../model/enum-user-role';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class CategoryService {

  private resourceUrl = 'http://localhost:8082/api/categories';

  private cachedCategories: Category[];

  constructor(private http: Http) { }

  getCategories(): Promise<Category[]> {
    return this.http.get(this.resourceUrl)
      .toPromise()
      .then(response => {
        this.cachedCategories = response.json() as Category[];
        return this.cachedCategories;
      })
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    // TODO : Handle error.
    console.error('Une erreur est survenue', error);
    return Promise.reject(error.message || error);
  }

  getCategory(code: string): Promise<Category> {
    // XXX : Refresh cache when create a new category ?
    for (const category of this.cachedCategories) {
      if (code === category.code) {
        return Promise.resolve(category);
      }
    }
  }
}
