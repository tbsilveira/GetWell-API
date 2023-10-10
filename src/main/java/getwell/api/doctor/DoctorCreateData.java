package getwell.api.doctor;

import getwell.api.address.UserAddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorCreateData(
        @NotBlank
        String name,
        @Email
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
