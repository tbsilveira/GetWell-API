package getwell.api.patient;

import getwell.api.address.UserAddressData;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String email,
        String phoneNumber,
        UserAddressData address) {
}
