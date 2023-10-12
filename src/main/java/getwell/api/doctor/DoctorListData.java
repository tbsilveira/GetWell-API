package getwell.api.doctor;

public record DoctorListData(Long id, String name, String email, String registerNumber, Speciality speciality, Boolean active) {

    public DoctorListData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getRegisterNumber(), doctor.getSpeciality(), doctor.getActive());
    }
}
