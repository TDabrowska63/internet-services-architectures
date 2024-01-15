package com.aui.Laboratorium5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriesApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(@Value("${character.app.url}") String baseUrl)
	{
		System.out.println("character.app.url: " + baseUrl);
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}
}
