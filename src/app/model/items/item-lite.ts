import {ItemName} from './item-name';
import {User} from '.././user';
import {Category} from '../categories/category';

export class ItemLite extends ItemName{

    creator: User;
    imageHeadUrl: string;
    commentaire: string;

    constructor(id:number, name:string, category:Category, creator:User, imageHeadUrl:string, commentaire:string)
    {
        super(id,name,category);
        this.creator = creator;
        this.imageHeadUrl = imageHeadUrl;
        this.commentaire = commentaire;
    }
}