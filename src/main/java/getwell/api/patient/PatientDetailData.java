package getwell.api.patient;

import getwell.api.address.UserAddress;

public record PatientDetailData(Long id, String name, String email, String phoneNumber, String taxNumber, UserAddress address, Boolean active) {

    public PatientDetailData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhoneNumber(), patient.getTaxNumber(), patient.getAddress(), patient.getActive());
    }
}
