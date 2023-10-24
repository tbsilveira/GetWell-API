package getwell.api.domain.consult;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultBookData(
        Long idDoctor,
        @NotNull
        Long idPatient,
        @NotNull  @Future
        LocalDateTime consultDate) {
}
