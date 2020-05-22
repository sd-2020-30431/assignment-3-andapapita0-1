package com.anda.assignment2;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.controller.ItemController;
import com.anda.assignment2.repositories.ItemRepository;
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
			String p = "2020-03-15";
			String e = "2020-03-25";
			purchase_date = sdformat.parse(p);
			expiration_date = sdformat.parse(e);
			Item i1 = new Item("bread", 2, 500, expiration_date, purchase_date);
			Item i2 = new Item("peaches", 10, 380,
					sdformat.parse("2020-03-30"), sdformat.parse("2020-04-03"));

			itemRepository.save(i1);
			itemRepository.save(i2);
			itemRepository.findAll().forEach(System.out::println);


		};
	}
}
