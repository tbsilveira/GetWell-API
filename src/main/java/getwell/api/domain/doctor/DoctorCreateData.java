package getwell.api.domain.doctor;

import getwell.api.domain.address.UserAddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorCreateData(
        @NotBlank
        String name,
        @NotBlank @Email
        String email,
        @NotNull
        String phoneNumber,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String registerNumber,
        @NotNull
        Speciality speciality,
        @NotNull @Valid
        UserAddressData address) {
}
