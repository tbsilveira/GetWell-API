package getwell.api.domain.patient;

import getwell.api.domain.address.UserAddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientCreateData(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotNull
        String phoneNumber,
        @NotBlank @Pattern(regexp = "\\d{6}")
        String taxNumber,
        @NotNull @Valid
        UserAddressData address) {
}
