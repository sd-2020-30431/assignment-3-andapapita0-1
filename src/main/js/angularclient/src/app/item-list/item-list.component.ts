import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { ItemService } from '../service/item-service.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
	
  items: Item[];

  constructor(private itemService: ItemService) { }

  ngOnInit() {
	  this.itemService.findAll().subscribe(data => {
		  this.items = data;
	  });
  }

}
