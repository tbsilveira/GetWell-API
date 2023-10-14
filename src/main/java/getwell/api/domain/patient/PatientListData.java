package getwell.api.domain.patient;

public record PatientListData(Long id, String name, String email, String phoneNumber, String taxNumber, Boolean active) {

    public PatientListData(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhoneNumber(), patient.getTaxNumber(), patient.getActive());
    }
}
