package com.techden.tdlessons;

import com.techden.tdlessons.entities.Order;
import com.techden.tdlessons.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LessonsApplication implements CommandLineRunner {
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(LessonsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Order order = new Order();

    	System.out.println("Digite o código do pedido");
		order.setCode(scanner.nextInt());

		System.out.println("Digite o valor do pedido:");
		order.setBaseValue(scanner.nextDouble());

		System.out.println("Digite o valor percentual do desconto:");
		order.setDiscountPercent(scanner.nextDouble()/100);

		double finalValue = orderService.calculateOrderFinalValue(order);

    	System.out.println("Pedido código: " + order.getCode());
    	System.out.println("Valor total: " + finalValue);

		scanner.close();
	}
}
