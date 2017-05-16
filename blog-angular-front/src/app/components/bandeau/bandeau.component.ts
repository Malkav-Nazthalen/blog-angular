import { Component } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-bandeau',
  templateUrl: './bandeau.component.html',
  styleUrls: ['./bandeau.component.css']
})
export class BandeauComponent {
  // TODO: Export URL to be configurable.
  bandeauImageUrl = './assets/images/banniere.jpg';
}
