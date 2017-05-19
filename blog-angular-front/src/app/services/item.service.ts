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
export class ItemService {

  private resourceUrl = 'http://localhost:8082/api/items';

  constructor(private http: Http) { }

  getItemsNameForCategorie(categorie: Category): Promise<ItemName[]> {
    return this.http.get(`${this.resourceUrl}/names/${categorie.id}`).toPromise().then(res => res.json() as ItemName[]);
  }

  getItemsLite(categorie: Category): Promise<ItemLite[]> {
    return this.http.get(`${this.resourceUrl}/lite/${categorie.id}`).toPromise().then(res => res.json() as ItemName[]);
  }

  getItem(id: number): Promise<Item> {
    return this.http.get(`${this.resourceUrl}/${id}`).toPromise().then(res => res.json() as Item);
  }

  saveItem(item: Item): Promise<Item> {
    return this.http.put(this.resourceUrl, item).toPromise().then(res => res.json());
  }
}
