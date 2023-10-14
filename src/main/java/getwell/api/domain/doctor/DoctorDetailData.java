package getwell.api.domain.doctor;

import getwell.api.domain.address.UserAddress;

public record DoctorDetailData(Long id, String name, String email, String phoneNumber, String registerNumber, Speciality speciality, UserAddress address, Boolean active) {

    public DoctorDetailData(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhoneNumber(), doctor.getRegisterNumber(), doctor.getSpeciality(), doctor.getAddress(), doctor.getActive());
    }
}
