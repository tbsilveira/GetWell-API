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

    public Doctor(DoctorCreateData data) {
        this.name = data.name();
        this.email = data.email();
        this.phoneNumber = data.phoneNumber();
        this.registerNumber = data.registerNumber();
        this.speciality = data.speciality();
        this.address = new UserAddress(data.address());
    }
}
