package getwell.api.patient;

public record PatientListData(String name, String email, String phoneNumber, String taxNumber) {

    public PatientListData(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getPhoneNumber(), patient.getTaxNumber());
    }
}
