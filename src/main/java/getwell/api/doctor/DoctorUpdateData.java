package getwell.api.doctor;

import getwell.api.address.UserAddressData;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String email,
        String phoneNumber,
        UserAddressData address) {
}
