package fit.edu.se.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import fit.edu.se.dto.product.ProductResponseDto;
import fit.edu.se.dto.voucher.VoucherEnum;
import fit.edu.se.dto.voucher.VoucherResponseDto;
import jakarta.ws.rs.core.UriBuilder;
import reactor.core.publisher.Mono;

@Component
public class VoucherClient {
	private final WebClient webClient;
	
	public VoucherClient(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://voucher-service").build();
		
	}
	
//	public Mono<ProductResponseDto> getProductById(String productId) {
//		return webClient.get()
//				.uri("/api/products/{productId}", productId)
//				.retrieve()
//				.bodyToMono(ProductResponseDto.class);
//	}
	
	public Mono<VoucherResponseDto> getVoucherById(String voucherId) {
		return webClient.get()
				.uri("/api/vouchers/{voucherId}", voucherId)
				.retrieve()
				.bodyToMono(VoucherResponseDto.class);
//		return Mono.just(
//					VoucherResponseDto.builder()
//						.voucherId(voucherId)
//						.voucherType(VoucherEnum.VALUE)
//						.minPriceRequired(1000.0)
//						.valueDiscount(1000.0)
//					.build()
//				);
	}
	public Mono<VoucherResponseDto> decrementUsesCount(String voucherId) {
		return webClient.put()
				.uri(UriBuilder -> UriBuilder.path("/api/vouchers/{voucherId}/increase-uses-count")
						.queryParam("usesCount", -1)
						.build(voucherId))
				.retrieve()
				.bodyToMono(VoucherResponseDto.class);
	}
	
}
