package iuh.fit.se.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import iuh.fit.se.dto.product.ProductResponseDto;
import iuh.fit.se.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	// Convert from CreateProductRequestDto to SanPham
	@Mapping(target = "productId", ignore = true) // Ignore the id field in the target entity	
	@Mapping(target = "images", ignore = true) // Ignore the images field in the target entity
	iuh.fit.se.model.Product toEntity(iuh.fit.se.dto.product.ProductCreateRequestDto dto);

	// Convert from SanPham to CreateProductRequestDto
	@Mapping(target = "images", ignore = true) // Ignore the images field in the target entity
	iuh.fit.se.dto.product.ProductCreateRequestDto toCreateProductRequestDto(iuh.fit.se.model.Product sanPham);
	
	// Convert from SanPham to ProductResponseDto
	ProductResponseDto toProductResponseDto(iuh.fit.se.model.Product sanPham);
	
	@Mapping(target = "images", ignore = true)
	Product injectProduct(@MappingTarget Product product, iuh.fit.se.dto.product.ProductCreateRequestDto dto);
}
