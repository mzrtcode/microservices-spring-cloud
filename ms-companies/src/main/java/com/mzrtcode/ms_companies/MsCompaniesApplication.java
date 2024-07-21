package com.mzrtcode.ms_companies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCompaniesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCompaniesApplication.class, args);
	}

}
