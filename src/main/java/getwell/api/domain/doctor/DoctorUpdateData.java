package getwell.api.domain.doctor;

import getwell.api.domain.address.UserAddressData;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateData(
        @NotNull
        Long id,
        String name,
        String email,
        String phoneNumber,
        UserAddressData address) {
}
