package com.anda.assignment2.factory;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.controller.ItemController;
import com.anda.assignment2.controller.ItemQueryController;
import com.anda.assignment2.repositories.ItemRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class WeeklyReport implements ReportFactory {

    @Override
    public int getWastedItems(ItemRepository itemRepository) {
        int nr = 0;
        Date start_date, end_date;
        ItemQueryController itemController = new ItemQueryController(itemRepository);
        List<Item> list = itemController.getFood();
        start_date = getStartDay();
        end_date = getEndDay();
        for(Item item:list) {
            if(item.getExpirationDate().compareTo(start_date) >= 0 &&
                    item.getExpirationDate().compareTo(end_date) <= 0) {
                if(item.waste() == true) {
                    nr++;
                }
            }
        }
        return nr;
    }

    @Override
    public String generateReport(ItemRepository itemRepository) {
        Date start_date, end_date;
        start_date = getStartDay();
        end_date = getEndDay();
        String all  = "{";
        all+= '"';
        all+="This week, from " + start_date.toString() + " to " + end_date.toString() +
                ", the following products were wasted: " ;
        int nr = getWastedItems(itemRepository);
        if(nr == 0){
            all += "NONE! Congrats! ";
        } else {
            ItemQueryController itemController = new ItemQueryController(itemRepository);
            List<Item> list = itemController.getFood();
            for (Item item : list) {
                if (item.getExpirationDate().compareTo(start_date) >= 0 && item.getExpirationDate().compareTo(end_date) <= 0) {
                    if (item.waste() == true) {
                        all += item.getName();
                        all += ", ";
                    }
                }
            }
        }
        all += ". ";
        all += "The total number of wasted products this week is:" ;
        all += '"';
        all += ':';
        all += '"';
        all+= "null";
        all += '"';
        all += '}';

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