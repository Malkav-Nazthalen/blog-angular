import {Category} from '../categories/category';

export class ItemName {

    id:number;
    category:Category;
    name:string;

    constructor(id:number, name:string, category:Category)
    {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}