import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { Item } from '../../../../model/items/item';

import { ItemService } from '../../../../services/item.service';

@Component({
  selector: 'app-panel-edit-item',
  templateUrl: './panel-abstract-edit-item.component.html',
  styleUrls: ['./panel-abstract-edit-item.component.css']
})
export class AbstractPanelEditItemComponent implements OnInit {

  protected item: Item;

  private testcontent: String = 'TEST DE CONTENU';

  constructor(private itemService: ItemService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    this.route.params.switchMap((params: Params) => this.itemService.getItem(params['id'])).subscribe(item => this.item = item);
  }

  keyupHandler(event) {
    this.item.content = event;
  }

  save(): void {
    this.itemService.saveItem(this.item);
  }
}
