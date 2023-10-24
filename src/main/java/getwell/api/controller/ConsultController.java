package getwell.api.controller;

import getwell.api.domain.consult.ConsultBookData;
import getwell.api.domain.consult.ConsultDetailData;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consults")
public class ConsultController {

    @PostMapping
    @Transactional
    public ResponseEntity bookConsult (@RequestBody @Valid ConsultBookData data) {
        System.out.println(data);
        return ResponseEntity.ok(new ConsultDetailData(null, null, null, null));
    }


}
