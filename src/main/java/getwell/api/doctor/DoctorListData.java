package getwell.api.doctor;

public record DoctorListData(String name, String email, String registerNumber, Speciality speciality) {

    public DoctorListData(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getRegisterNumber(), doctor.getSpeciality());
    }
}
