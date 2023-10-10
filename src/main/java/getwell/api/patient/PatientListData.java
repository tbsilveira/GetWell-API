package getwell.api.patient;

public record PatientListData(Long id, String name, String email, String phoneNumber, String taxNumber) {

    public PatientListData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhoneNumber(), patient.getTaxNumber());
    }
}
