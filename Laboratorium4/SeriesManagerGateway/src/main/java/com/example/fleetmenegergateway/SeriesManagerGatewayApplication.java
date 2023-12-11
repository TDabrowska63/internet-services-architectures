package com.example.seriesmenegergateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeriesManagerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriesManagerGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${seriesManager.character.url}") String characterUrl,
			@Value("${seriesManager.series.url}") String seriesUrl,
			@Value("${seriesManager.gateway.host}") String host
	){
		return builder.routes()
				.route("series",route->route
						.host(host)
						.and()
						.path(
								"/api/series/{uuid}",
								"/api/series"
						)
						.uri(seriesUrl)
				)
				.route("characters",route->route
						.host(host)
						.and()
						.path(
								"/api/characters/**",
								"/api/characters",
								"/api/series/{uuid}/characters",
								"/api/series/{uuid}/characters/**"

						)
						.uri(characterUrl)
				)
				.build();
	}
}
