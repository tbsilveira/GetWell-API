package getwell.api.patient;

import getwell.api.address.UserAddressData;

public record PatientCreateData(String name, String email, String phone, String taxNumber, UserAddressData address) {
}
