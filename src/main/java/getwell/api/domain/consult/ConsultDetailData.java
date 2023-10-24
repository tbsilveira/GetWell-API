package getwell.api.domain.consult;

import java.time.LocalDateTime;

public record ConsultDetailData(Long id, Long idDoctor, Long idPatient, LocalDateTime consultDate) {
}
