package com.anda.assignment2;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.bean.User;
import com.anda.assignment2.controller.ItemController;
import com.anda.assignment2.factory.WeeklyReport;
import com.anda.assignment2.repositories.ItemRepository;
import com.anda.assignment2.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class WastelessApplication {

	public static void main(String[] args) {

		SpringApplication.run(WastelessApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ItemRepository itemRepository) {
		return args -> {
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
			Date purchase_date = null, expiration_date = null, consumption_date = null;
			String p = "2020-05-19";
			String e = "2020-05-20";
			purchase_date = sdformat.parse(p);
			expiration_date = sdformat.parse(e);
			Item i1 = new Item("bread", 2, 500, expiration_date, purchase_date);
			Item i2 = new Item("peaches", 10, 380,
					sdformat.parse("2020-05-18"), sdformat.parse("2020-05-21"));

			itemRepository.save(i1);
			itemRepository.save(i2);
			ItemController itemController = new ItemController(itemRepository);
			itemController.getFood().forEach(System.out::println);
			//itemRepository.findAll().forEach(System.out::println);

			WeeklyReport w = new WeeklyReport();
			String s = w.generateReport(itemRepository);
			System.out.println(s);
		};
	}

	@Bean
	CommandLineRunner init2(UserRepository userRepository) {
		return args -> {
			User user = new User();
			user.setPassword("aa");
			user.setUsername("andap");
			userRepository.save(user);
			userRepository.findAll().forEach(System.out::println);
		};
	}

}