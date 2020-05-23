import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user-service.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  id: number;
  user: User;
  
  constructor(private route: ActivatedRoute, 
      private router: Router, 
        private userService: UserService) {}

  
  authenticate() {
	  this.user = new User();
	this.id = 1;
	if (this.user.username === "andap" && this.user.passwordd === "aa")
		this.gotoList();
	else this.stay();
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
