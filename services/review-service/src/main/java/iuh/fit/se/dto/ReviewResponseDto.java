package iuh.fit.se.dto;

public record ReviewResponseDto(String reviewId, Integer rating, String comment, String productId, String customerId) {}
