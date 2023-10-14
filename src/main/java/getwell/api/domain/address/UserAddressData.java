package getwell.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserAddressData(
        @NotBlank
        String street,
        @NotBlank
        String neighbourhood,
        @NotBlank
        @Pattern(regexp = "\\d{9}")
        String postcode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String number,
        String complement) {
}
