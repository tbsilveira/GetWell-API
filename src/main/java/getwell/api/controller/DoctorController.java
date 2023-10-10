package getwell.api.controller;

import getwell.api.doctor.Doctor;
import getwell.api.doctor.DoctorCreateData;
import getwell.api.doctor.DoctorListData;
import getwell.api.doctor.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid DoctorCreateData data) {
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DoctorListData> listDoctors(@PageableDefault(size = 5, sort = {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(DoctorListData::new);
    }

}
