package getwell.api.controller;

import getwell.api.domain.doctor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DoctorCreateData data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        repository.save(doctor);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailData(doctor));

    }

    @GetMapping
    public ResponseEntity<Page<DoctorListData>> list(@PageableDefault(size = 5, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(DoctorListData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorDetailData(doctor));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateData data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
        return ResponseEntity.ok(new DoctorDetailData(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }


}
