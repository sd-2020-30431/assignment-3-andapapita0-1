package com.anda.assignment2.factory;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.controller.ItemController;
import com.anda.assignment2.repositories.ItemRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WeeklyReport implements ReportFactory {

    @Override
    public String generateReport(ItemRepository itemRepository) {
        Date start_date, end_date;
        start_date = getStartDay();
        end_date = getEndDay();
        int nr = 0;
        String all="This week, from " + start_date.toString() + " to " + end_date.toString() +
                ", the following products were wasted:<br>";
        ItemController itemController = new ItemController(itemRepository);
        List<Item> list = itemController.getFood();
        for(Item item:list) {
            if(item.getExpirationDate().compareTo(start_date) >= 0 && item.getExpirationDate().compareTo(end_date) <= 0) {
                if(item.waste() == true) {
                    all+="	-> " + item.getName() + "<br>";
                    nr++;
                }
            }
        }
        all += "<br><br> The total number of wasted products this week is: " + nr;
        return all;
    }

    @Override
    public Calendar getCalendarForNow() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        return calendar;
    }

    @Override
    public void setTimeToBeginningOfDay(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMinimum(Calendar.DAY_OF_WEEK));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    @Override
    public void setTimeToEndOfDay(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_WEEK, calendar.getActualMaximum(Calendar.DAY_OF_WEEK));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
    }

    @Override
    public Date getStartDay() {
        Date beginning;
        Calendar calendar = getCalendarForNow();
        setTimeToBeginningOfDay(calendar);
        beginning = calendar.getTime();
        return beginning;
    }

    @Override
    public Date getEndDay() {
        Date end;
        Calendar calendar = getCalendarForNow();
        setTimeToEndOfDay(calendar);
        end = calendar.getTime();
        return end;
    }

}