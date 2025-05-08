package fit.edu.se.client;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import fit.edu.se.dto.product.ProductResponseDto;
import reactor.core.publisher.Mono;

@Component
public class ProductClient {
	private final WebClient webClient;
	
	public ProductClient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://product-service").build();
		
	}
	
	public Mono<ProductResponseDto> getProductById(String productId) {
		return webClient.get()
				.uri("/api/products/{productId}", productId)
				.retrieve()
				.bodyToMono(ProductResponseDto.class);
	}
	
	public Mono<Void> increaseProductQuantity(String productId, Integer quantity) {
		return webClient.put()
				.uri("/api/products/{productId}/increase-stock", productId)
				.bodyValue(Map.of("quantity", quantity))
				.retrieve()
				.bodyToMono(Void.class);
	}
}
