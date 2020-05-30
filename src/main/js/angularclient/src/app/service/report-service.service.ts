import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ReportService {

  private Url: string;
  private nrUrl: string;
  private mUrl: string;
  private mnrUrl: string;
 
  constructor(private http: HttpClient) {
    this.Url = 'http://localhost:8080/report';
    this.nrUrl = 'http://localhost:8080/nr';
    this.mUrl = 'http://localhost:8080/monthlyreport';
    this.mnrUrl = 'http://localhost:8080/monthlynr';
  }
  
  public getWeeklyReport(): Observable<any> {
	  return this.http.get<any>(this.Url);
  }

  public getWeeklyWastedItems(): Observable<any> {
	  return this.http.get<any>(this.nrUrl);
  }

  public getMonthlyReport(): Observable<any> {
	  return this.http.get<any>(this.mUrl);
  }

  public getMonthlyWastedItems(): Observable<any> {
	  return this.http.get<any>(this.mnrUrl);
  }

}
