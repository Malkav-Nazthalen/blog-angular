import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import { Item } from '../model/items/item';
import { ItemName } from '../model/items/item-name';
import { ItemLite } from '../model/items/item-lite';
import { Category } from '../model/categories/category';
import { User } from '../model/user';
import { EnumUserRole } from '../model/enum-user-role';

@Injectable()
export class ItemService {

    cat1:Category = new Category(1, 'tombe', 'Tombes',true);
    cat2:Category = new Category(2, 'temple', 'Temples',true);
    cat3:Category = new Category(3, 'autre', 'Autres bizarreries',false);
    creator:User = new User("test1", "test1", 'ADMIN');

    tomb1 : Item = new Item(1, "tombe1", this.cat1, this.creator, "../../../../assets/images/imageTombe1.jpg", "La tombe 1 est blablabla", "Test de contenu tombe1", );
    tomb2 : Item = new Item(2, "tombe2", this.cat1, this.creator, "../../../../assets/images/imageTombe2.jpg", "La tombe 2 est encore mieux", "Test de contenu tombe2");
    tomb3 : Item = new Item(3, "tombe3", this.cat1, this.creator, "../../../../assets/images/imageTombe3.jpg", "La tombe 3 oulala", "Test de contenu tombe3");
    temp1 : Item = new Item(4, "temple1", this.cat2, this.creator, "../../../../assets/images/imageTombe3.jpg", "Le temple 1 trop beau", "Test de contenu temple 1");
    temp2 : Item = new Item(5, "temple2", this.cat2, this.creator, "../../../../assets/images/imageTombe3.jpg", "Le temple 2 pas mal", "Test de contenu temple2");
    temp3 : Item = new Item(6, "temple3", this.cat2, this.creator, "../../../../assets/images/imageTombe3.jpg", "Ah ? c'est un temple3 ça ?", "Test de contenu temple3");
    dive1 : Item = new Item(7, "Divers1", this.cat3, this.creator, "../../../../assets/images/imageTombe3.jpg", "Heu, c'est quoi ça ?", "Test de contenu divers");

    tombs : Item[] = [this.tomb1,this.tomb2,this.tomb3];
    temples : Item[] = [this.temp1,this.temp2,this.temp3];
    divers : Item[] = [this.dive1];

    constructor( private http: Http ) {}

    getItemsNameForCategorie(categorie:Category): ItemName[] {
        if(categorie.id == 1)
        {
            let t1  = new ItemName(this.tombs[0].id, this.tombs[0].name, this.cat1);
            let t2  = new ItemName(this.tombs[1].id, this.tombs[1].name, this.cat1);
            let t3  = new ItemName(this.tombs[2].id, this.tombs[2].name, this.cat1);
            return [t1, t2, t3];
        }
        else if(categorie.id == 2)
        {
            let t1  = new ItemName(this.temples[0].id, this.temples[0].name, this.cat2);
            let t2  = new ItemName(this.temples[1].id, this.temples[1].name, this.cat2);
            let t3  = new ItemName(this.temples[2].id, this.temples[2].name, this.cat2);
            return [t1, t2, t3];
        }
        else{
            let t1  = new ItemName(this.divers[0].id, this.divers[0].name, this.cat3);
            return [t1];
        }
    }

    getItemsLite(categorie:Category):ItemLite[] {
        if(categorie.id == 1)
        {
            let t1  = new ItemLite(this.tombs[0].id, this.tombs[0].name, this.tombs[0].category, this.tombs[0].creator, this.tombs[0].imageHeadUrl, this.tombs[0].commentaire);
            let t2  = new ItemLite(this.tombs[1].id, this.tombs[1].name, this.tombs[1].category, this.tombs[1].creator, this.tombs[1].imageHeadUrl, this.tombs[1].commentaire);
            let t3  = new ItemLite(this.tombs[2].id, this.tombs[2].name, this.tombs[2].category, this.tombs[2].creator, this.tombs[2].imageHeadUrl, this.tombs[2].commentaire);
            return [t1, t2, t3];
        }
        else if(categorie.id == 2)
        {
            let t1  = new ItemLite(this.temples[0].id, this.temples[0].name, this.temples[0].category, this.temples[0].creator, this.temples[0].imageHeadUrl, this.temples[0].commentaire);
            let t2  = new ItemLite(this.temples[1].id, this.temples[1].name, this.temples[1].category, this.temples[1].creator, this.temples[1].imageHeadUrl, this.temples[1].commentaire);
            let t3  = new ItemLite(this.temples[2].id, this.temples[2].name, this.temples[2].category, this.temples[2].creator, this.temples[2].imageHeadUrl, this.temples[2].commentaire);
            return [t1, t2, t3];
        }
        else{
            let t1  = new ItemLite(this.divers[0].id, this.divers[0].name, this.divers[0].category, this.divers[0].creator, this.divers[0].imageHeadUrl, this.divers[0].commentaire);
            return [t1];
        }
    }

    getItem(id: number): Promise<Item> {
        for(let tomb of this.tombs){
            if(tomb.id == id)
            {
                return Promise.resolve(tomb);
            }
        }
        for(let temple of this.temples){
            if(temple.id == id)
            {
                return Promise.resolve(temple);
            }
        }
        for(let dive of this.divers){
            if(dive.id == id)
            {
                return Promise.resolve(dive);
            }
        }
    }

    saveItem(item: Item):void{
        for(let tomb of this.tombs){
            if(tomb.id == item.id)
            {
                tomb = item;
            }
        }
        for(let temple of this.temples){
            if(temple.id == item.id)
            {
                temple = item;
            }
        }
        for(let dive of this.divers){
            if(dive.id == item.id)
            {
                dive = item;
            }
        }
    }
}