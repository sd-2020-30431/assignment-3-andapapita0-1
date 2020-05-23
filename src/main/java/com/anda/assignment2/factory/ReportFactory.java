package com.anda.assignment2.factory;

import com.anda.assignment2.repositories.ItemRepository;

import java.util.Calendar;
import java.util.Date;

public interface ReportFactory {
    public String generateReport(ItemRepository itemRepository);
    public Calendar getCalendarForNow();
    public void setTimeToBeginningOfDay(Calendar calendar);
    public void setTimeToEndOfDay(Calendar calendar);
    public Date getStartDay();
    public Date getEndDay();
}
