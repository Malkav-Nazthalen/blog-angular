import { ItemName } from '../items/item-name';

export class Category {

  id: number;
  code: string;
  name: string;
  more: boolean;
  itemsName: ItemName[];

  constructor(id: number, code: string, name: string, more: boolean) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.more = more;
  }
}
