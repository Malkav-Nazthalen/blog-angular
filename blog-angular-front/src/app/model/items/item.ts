import { ItemLite } from './item-lite';
import { User } from '.././user';
import { Category } from '../categories/category';

export class Item extends ItemLite {

  content: string;

  constructor(id: number, name: string, category: Category, creator: User, imageHeadUrl: string, commentaire: string, content: string) {
    super(id, name, category, creator, imageHeadUrl, commentaire);
    this.content = content;
  }
}
