package ma.wafaassurance.rsapi.controller;

import ma.wafaassurance.rsapi.model.Garantie;
import ma.wafaassurance.rsapi.service.GarantieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/garanties")
@CrossOrigin(origins = "*")
public class GarantieController {

    @Autowired
    private GarantieService garantieService;

    @GetMapping
    public List<Garantie> getAllGaranties() {
        return garantieService.getAllGaranties();
    }

    @GetMapping("/{id}")
    public Garantie getGarantieById(@PathVariable Long id) {
        return garantieService.getGarantieById(id);
    }

    @PostMapping
    public Garantie saveGarantie(@RequestBody Garantie garantie) {
        return garantieService.saveGarantie(garantie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGarantie(@PathVariable Long id, @RequestBody Garantie garantieDetails) {
        Optional<Garantie> garantie = Optional.ofNullable(garantieService.getGarantieById(id));
        if (garantie.isPresent()) {
            Garantie updatedGarantie = garantie.get();
            updatedGarantie.setNom(garantieDetails.getNom());
            updatedGarantie.setDescription(garantieDetails.getDescription());
            updatedGarantie.setValue(garantieDetails.getValue());

            return ResponseEntity.ok(garantieService.saveGarantie(updatedGarantie));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteGarantie(@PathVariable Long id) {
        garantieService.deleteGarantie(id);
    }
}