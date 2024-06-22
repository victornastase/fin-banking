package com.victornastase.learning.fin_banking;

import org.springframework.boot.SpringApplication;

public class TestFinBankingApplication {

	public static void main(String[] args) {
		SpringApplication.from(FinBankingApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
