package fit.edu.se.dto;

import java.time.LocalDate;

import fit.edu.se.entity.VoucherType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VoucherUpdateRequestDto(
		
		@NotNull
		@NotBlank(message = "Voucher name cannot be blank")
		String voucherName,
		String vendorId,
		@NotBlank
		LocalDate startDate,
		@NotBlank
		LocalDate endDate,
		@Min(value =0, message = "Minimum price required must be greater than 0")
		Double minPriceRequired,
		@Min(value = 0, message = "Uses count must be greater than 0")
		Integer usesCount,
		@NotNull
		VoucherType voucherType,
		Double percentDiscount,
		Double valueDiscount
) {
	
}
