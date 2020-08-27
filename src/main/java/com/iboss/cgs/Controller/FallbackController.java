package com.iboss.cgs.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	@RequestMapping("/userFallBack")
	public Mono<String> userServiceFallBack() {
		return Mono.just("User Service is taking too long to respond or is down. Please try again later");
	}

	@RequestMapping("/accountFallback")
	public Mono<String> accountServiceFallBack() {
		return Mono.just("Account Service is taking too long to respond or is down. Please try again later");
	}
}
