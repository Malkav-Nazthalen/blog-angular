import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import 'rxjs/add/operator/switchMap';

import { Item } from '../../../../model/items/item';
import { ItemService } from '../../../../services/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './panel-abstract-item.component.html',
  styleUrls: ['./panel-abstract-item.component.css']
})
export class AbstractPanelItemComponent implements OnInit {
  item: Item;

  constructor(private itemService: ItemService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.route.params
      .switchMap((params: Params) => this.itemService.getItem(params['id']))
      .subscribe(item => this.item = item);
  }
}
