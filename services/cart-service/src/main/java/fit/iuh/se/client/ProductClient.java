package fit.iuh.se.client;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import fit.iuh.se.dto.product.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ProductClient {
	private final WebClient webClient;
	
	public ProductClient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://product-service").build();
	}
	
	public Mono<ProductResponseDto> getProductById(String productId) {
	    return webClient.get()
	        .uri("/api/products/{productId}", productId)
	        .accept(MediaType.APPLICATION_JSON)
	        .retrieve()
	        .bodyToMono(ProductResponseDto.class)
	        .doOnError(error -> log.error("Error fetching product with ID {}: {}", productId, error.getMessage()));
	}
}

