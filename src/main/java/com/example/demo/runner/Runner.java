package com.example.demo.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		repo.save(new Product("PEN",6.8,"BLUE"));
		repo.save(new Product("PENCIL",6.8,"BLACK"));
		repo.save(new Product("Book",18,"BLUE"));
		repo.save(new Product("BOX",68,"BROWN"));
		
		//2
		
		Optional<Product> p=repo.findById(3);
		if(p.isPresent()) {
			System.out.println(p.get());
		}
		else {
			System.out.println("No Data found");
		}
		repo.findAll().forEach((System.out::println));
		
		//repo.deleteAll();
		
	//	repo.deleteAllInBatch();
	}

}
