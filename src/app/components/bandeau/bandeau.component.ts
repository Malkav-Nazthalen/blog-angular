import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component( {
    selector: 'bandeau',
    templateUrl: './bandeau.component.html',
    styleUrls: ['./bandeau.component.css']
} )
export class Bandeau {
    bandeauImageUrl:string = "./assets/images/banniere.jpg";
}
