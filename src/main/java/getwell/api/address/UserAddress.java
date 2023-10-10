package getwell.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {

    private String street;
    private String neighbourhood;
    private String postcode;
    private String number;
    private String complement;
    private String city;
    private String state;

    public UserAddress(UserAddressData data) {
        this.street = data.street();
        this.neighbourhood = data.neighbourhood();
        this.postcode = data.postcode();
        this.number = data.number();
        this.complement = data.complement();
        this.city = data.city();
        this.state = data.state();
    }
}
