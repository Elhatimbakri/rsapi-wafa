package ma.wafaassurance.rsapi.controller;

import ma.wafaassurance.rsapi.model.Formule;
import ma.wafaassurance.rsapi.service.FormuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/formules")
@CrossOrigin(origins = "*")
public class FormuleController {

    @Autowired
    private FormuleService formuleService;

    @GetMapping
    public List<Formule> getAllFormules() {
        return formuleService.getAllFormules();
    }

    @GetMapping("/{id}")
    public Formule getFormuleById(@PathVariable Long id) {
        return formuleService.getFormuleById(id);
    }

    @PostMapping
    public Formule saveFormule(@RequestBody Formule formule) {
        return formuleService.saveFormule(formule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatedFormule(@PathVariable Long id, @RequestBody Formule formuleDetails) {
        Optional<Formule> formule = Optional.ofNullable(formuleService.getFormuleById(id));
        if (formule.isPresent()) {
            Formule updatedFormule = formule.get();
            //variable
            updatedFormule.setNom(formuleDetails.getNom());
            updatedFormule.setDescription(updatedFormule.getDescription());
            updatedFormule.setCoefficient(updatedFormule.getCoefficient());
            updatedFormule.setGaranties(updatedFormule.getGaranties());

            return ResponseEntity.ok(formuleService.saveFormule(updatedFormule));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFormule(@PathVariable Long id) {
        formuleService.deleteFormule(id);
    }
}
