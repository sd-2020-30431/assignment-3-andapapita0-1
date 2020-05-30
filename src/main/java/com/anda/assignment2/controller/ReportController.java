package com.anda.assignment2.controller;

import com.anda.assignment2.factory.MonthlyReport;
import com.anda.assignment2.factory.WeeklyReport;
import com.anda.assignment2.repositories.ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {

    private final ItemRepository itemRepository;
    private WeeklyReport weeklyReport;
    private MonthlyReport monthlyReport;

    public ReportController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.weeklyReport = new WeeklyReport();
        this.monthlyReport = new MonthlyReport();
    }

    @GetMapping("/report")
    public ResponseEntity<String> getWeeklyReport(){
        String s = weeklyReport.generateReport(itemRepository);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/nr")
    public int getWeeklyWastedItems(){
        int nr = weeklyReport.getWastedItems(itemRepository);
        return nr;
    }

    @GetMapping("/monthlyreport")
    public ResponseEntity<String> getMonthlyReport(){
        String s = monthlyReport.generateReport(itemRepository);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/monthlynr")
    public int getMonthlyWastedItems(){
        int nr = monthlyReport.getWastedItems(itemRepository);
        return nr;
    }
}
