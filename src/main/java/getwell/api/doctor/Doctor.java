package getwell.api.doctor;

import getwell.api.address.UserAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String registerNumber;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Embedded
    private UserAddress address;
    private Boolean active;

    public Doctor(DoctorCreateData data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
        this.registerNumber = data.registerNumber();
        this.speciality = data.speciality();
        this.address = new UserAddress(data.address());
    }

    public void updateData(DoctorUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.email() != null) {
            this.email = data.email();
        }
        if (data.phoneNumber() != null) {
            this.phoneNumber = data.phoneNumber();
        }
        if (data.address() != null) {
            this.address.updateData(data.address());
        }
    }

    public void delete() {
        this.active = false;
    }
}
