package getwell.api.domain.patient;

import getwell.api.domain.address.UserAddressData;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateData(
        @NotNull
        Long id,
        String name,
        String email,
        String phoneNumber,
        UserAddressData address) {
}
