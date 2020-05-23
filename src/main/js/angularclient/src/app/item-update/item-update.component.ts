import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item';
import { ItemService } from '../service/item-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-item-update',
  templateUrl: './item-update.component.html',
  styleUrls: ['./item-update.component.css']
})
export class ItemUpdateComponent implements OnInit {
	
  id: number; 
  item: Item;

  constructor(private route: ActivatedRoute, 
      private router: Router, 
        private itemService: ItemService) {}

  ngOnInit() {
	this.item = new Item();
	this.id = this.route.snapshot.params['id'];
	this.itemService.getItem(this.id)
      .subscribe(data => {
        console.log(data)
        this.item = data;
    }, error => console.log(error));
  }
	 
  updateItem() {
    this.itemService.updateItem(this.id, this.item).subscribe(data => 
		console.log(data), error => console.log(error));
    this.item = new Item();
    this.gotoList();
  }
  
  onSubmit() {
    this.updateItem();    
  }

  gotoList() {
    this.router.navigate(['/groceries']);
  }
}
