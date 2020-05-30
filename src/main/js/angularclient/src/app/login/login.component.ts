import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id: number;
  user: User;
  
  constructor(
private route: ActivatedRoute, 
       private router: Router, 
        private userService: UserService) {
	this.user = new User();
	this.id = 3;
}

  
  ngOnInit() {
	this.userService.getUser(this.id)
      .subscribe(data => {
        console.log(data)
        this.user = data;
    }, error => console.log(error));
  }
  
   authenticate(){
	//if (this.user.username === "andap" && this.user.passwordd === "aa")
		this.gotoList();
	//else this.stay();
  }
  
  onSubmit() {
    this.authenticate();    
  }

  gotoList() {
    this.router.navigate(['/groceries']);
  }
  
  stay(){
	  this.router.navigate(['/login']);
  }
  
}
