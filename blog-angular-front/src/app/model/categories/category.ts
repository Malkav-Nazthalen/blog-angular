import { ItemName } from '../items/item-name';

export class Category {

  id: number;
  code: string;
  name: string;
  more: boolean;
  childCategories: Category[];
  parent: Category;
  itemsName: ItemName[];

  constructor(id: number, code: string, name: string, more: boolean, childCategories: Category[], parent: Category) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.more = more;
    this.childCategories = childCategories;
    this.parent = parent;
  }
}
