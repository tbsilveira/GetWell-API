package getwell.api.controller;

import getwell.api.patient.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody PatientCreateData data) {
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListData> listPatients (@PageableDefault(size = 5, sort = {"name"}) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(PatientListData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateData data) {
        var patient = repository.getReferenceById(data.id());
        patient.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.delete();
    }
}
