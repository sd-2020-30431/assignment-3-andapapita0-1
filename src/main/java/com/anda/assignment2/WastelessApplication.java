package com.anda.assignment2;

import com.anda.assignment2.bean.Item;
import com.anda.assignment2.bean.User;
import com.anda.assignment2.controller.ItemCommandController;
import com.anda.assignment2.controller.ItemQueryController;
import com.anda.assignment2.mediator.Mediator;
import com.anda.assignment2.mediator.handler.AddFoodCommandHandler;
import com.anda.assignment2.mediator.request.AddFoodCommand;
import com.anda.assignment2.mediator.response.AddFoodCommandResponse;
import com.anda.assignment2.repositories.ItemRepository;
import com.anda.assignment2.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

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
			String p = "2020-05-28";
			String e = "2020-05-31";
			purchase_date = sdformat.parse(p);
			expiration_date = sdformat.parse(e);
			Item i1 = new Item("bread", 2, 500, expiration_date, purchase_date);
			Item i2 = new Item("peaches", 10, 380,
					sdformat.parse("2020-05-28"), sdformat.parse("2020-05-26"));
			Item i3 = new Item("cherries", 200, 600,
					sdformat.parse("2020-05-15"), sdformat.parse("2020-05-10"));


			ItemQueryController itemController = new ItemQueryController(itemRepository);
			ItemCommandController itemCommandController = new ItemCommandController(itemRepository);

			Mediator mediator = new Mediator();
			AddFoodCommand request = new AddFoodCommand(i1);


			AddFoodCommandHandler handler = (AddFoodCommandHandler)
					mediator.<AddFoodCommand, AddFoodCommandResponse>getHandler(request);
			AddFoodCommandResponse response = handler.handle(request);




					//itemRepository.save(i1);
			itemRepository.save(i2);
			itemRepository.save(i3);


			itemController.getFood().forEach(System.out::println);
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
