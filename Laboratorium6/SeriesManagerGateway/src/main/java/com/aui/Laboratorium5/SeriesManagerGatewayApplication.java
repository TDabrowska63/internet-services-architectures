package com.aui.Laboratorium5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@SpringBootApplication
public class SeriesManagerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriesManagerGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${character.app.url}") String characterUrl,
			@Value("${series.app.url}") String seriesUrl,
			@Value("${manager.gateway.host}") String host
	){
		System.out.println("character.app.url: " + characterUrl);
		System.out.println("series.app.url: " + seriesUrl);
		System.out.println("manager.gateway.host: " + host);
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

	@Bean
	public CorsWebFilter corsWebFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedOrigin("http://localhost:8087"); // Or use `addAllowedOriginPattern("*")` for allowing all origins
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedMethod("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}
}
