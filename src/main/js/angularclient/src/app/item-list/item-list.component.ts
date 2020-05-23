import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { ItemService } from '../service/item-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
	
  items: any;

  constructor(private itemService: ItemService, private router: Router) { }

  ngOnInit() {
	this.itemService.findAll().subscribe(data => {
		  this.items = data;
	  });
  }

    deleteItem(item: Item) {
		let resp = this.itemService.deleteItem(item);
		resp.subscribe(data=>{
			console.log(data);
			this.ngOnInit();
		},
		error => console.log(error));
    }
	
	updateItem(id: number) {
		this.router.navigate(['updateitem', id]);
	}

}
