import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs/Observable';
 
@Injectable()
export class UserService {
 
  private usersUrl: string;
 
  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/user';
  }
 
  public getUser(id: number): Observable<any> {
	  return this.http.get(`${this.usersUrl}/${id}`);
  }
}
