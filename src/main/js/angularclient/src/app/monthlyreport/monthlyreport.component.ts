import { Component, OnInit } from '@angular/core';
import { ReportService } from '../service/report-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-monthlyreport',
  templateUrl: './monthlyreport.component.html',
  styleUrls: ['./monthlyreport.component.css']
})
export class MonthlyreportComponent implements OnInit {

  report: any;
  nr: any;

  constructor(private reportService: ReportService, private router: Router) { }

  ngOnInit() {
    this.reportService.getMonthlyWastedItems().subscribe(data=>{
      console.log(data);
      this.nr = data;
      console.log(this.nr);
    });

	  this.reportService.getMonthlyReport().subscribe(data=>{
      console.log(data);
      
			this.report = JSON.stringify(data);
      this.report = this.report.substring(2, this.report.length-9);
      console.log(this.report);
	  });
  }

}
