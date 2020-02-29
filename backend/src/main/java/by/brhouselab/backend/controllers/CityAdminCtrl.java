package by.brhouselab.backend.controllers;

import by.brhouselab.backend.models.CityEntity;
import by.brhouselab.backend.repositories.CityRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("admin")
public class CityAdminCtrl {

    private final CityRepo cityRepo;

    public CityAdminCtrl(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    @GetMapping("city/{id}")
    public ResponseEntity<CityEntity> getCity(@PathVariable long id) {
        return cityRepo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("cities")
    public ResponseEntity<Iterable<CityEntity>> getCities() {
        return ResponseEntity.ok().body(cityRepo.findAll());
    }

    @PostMapping(value = "city/save/{id}")
    public ResponseEntity<Void> updateCity(@PathVariable long id, @RequestBody CityEntity city) {
        if (id != city.getId()) {
            return ResponseEntity.badRequest().build();
        }
        cityRepo.save(city);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "city/delete/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable long id) {
        if (!cityRepo.existsById(id)) {
            ResponseEntity.badRequest().build();
        }
        cityRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

