package ma.wafaassurance.rsapi.controller;

import ma.wafaassurance.rsapi.model.Bien;
import ma.wafaassurance.rsapi.model.Devis;
import ma.wafaassurance.rsapi.model.Formule;
import ma.wafaassurance.rsapi.service.DevisService;
import ma.wafaassurance.rsapi.service.FormuleService;
import ma.wafaassurance.rsapi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devis")
@CrossOrigin(origins = "*")
public class DevisController {

    @Autowired
    private DevisService devisService;

    @Autowired
    private FormuleService formuleService;

    @Autowired
    private BienService bienService;

    @GetMapping
    public List<Devis> getAllDevis() {
        return devisService.getAllDevis();
    }

    @GetMapping("/{id}")
    public Devis getDevisById(@PathVariable Long id) {
        return devisService.getDevisById(id);
    }

    @PostMapping
    public Devis saveDevis(@RequestBody Devis devis) {
        return devisService.saveDevis(devis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDevis(@PathVariable Long id, @RequestBody Devis devisDetails) {
        Optional<Devis> optionalDevis = Optional.ofNullable(devisService.getDevisById(id));
        if (optionalDevis.isPresent()) {
            Devis updatedDevis = optionalDevis.get();

            // Set basic details only if they are not null in devisDetails
            if (devisDetails.getDateCreation() != null) {
                updatedDevis.setDateCreation(devisDetails.getDateCreation());
            }
            if (devisDetails.getEstValide() != null) {
                updatedDevis.setEstValide(devisDetails.getEstValide());
            }
            if (devisDetails.getEstPaye() != null) {
                updatedDevis.setEstPaye(devisDetails.getEstPaye());
            }
            if (devisDetails.getClient() != null) {
                updatedDevis.setClient(devisDetails.getClient());
            }
            if (devisDetails.getBien() != null) {
                updatedDevis.setBien(devisDetails.getBien());
            }
            if (devisDetails.getGaranties() != null) {
                updatedDevis.setGaranties(devisDetails.getGaranties());
            }
            if (devisDetails.getEstPromo() != null) {
                updatedDevis.setEstPromo(devisDetails.getEstPromo());
            }
            if (devisDetails.getDateEffet() != null) {
                updatedDevis.setDateEffet(devisDetails.getDateEffet());

                // Calculate dateExp only if dateEffet is updated
                LocalDate dateEffetLocal = devisDetails.getDateEffet().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate dateExpLocal = dateEffetLocal.plus(365, ChronoUnit.DAYS);
                Date dateExp = Date.from(dateExpLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
                updatedDevis.setDateExp(dateExp);
            }

            // Update formule and recalculate montantTotal if formule is updated
            if (devisDetails.getFormule() != null && devisDetails.getFormule().getId() != null) {
                Formule formule = formuleService.getFormuleById(devisDetails.getFormule().getId());
                if (formule != null) {
                    updatedDevis.setFormule(formule);
                    updatedDevis.setMontantTotal(calculateMontantTotal(updatedDevis.getBien(), formule));

                    // Apply discount if estPromo is true
                    if (updatedDevis.getEstPromo()) {
                        updatedDevis.setMontantPaye(updatedDevis.getMontantTotal() - (updatedDevis.getMontantTotal() * 0.1));
                    } else {
                        updatedDevis.setMontantPaye(updatedDevis.getMontantTotal());
                    }
                }
            }

            return ResponseEntity.ok(devisService.saveDevis(updatedDevis));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public void deleteDevis(@PathVariable Long id) {
        devisService.deleteDevis(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Devis> getAllDevisByClientId(@PathVariable Long clientId) {
        return devisService.getAllDevisByClientId(clientId);
    }

    @GetMapping("/count")
    public long getDevisCount() {
        return devisService.getDevisCount();
    }

    @GetMapping("/total")
    public double getTotalMontant() {
        return devisService.getTotalMontant();
    }


    private double calculateMontantTotal(Bien bien, Formule formule) {
        double coefficient = formule.getCoefficient();
        double e = 0.3;
        double tax = bien.getValeurBien() * 0.004;
        return coefficient * Math.pow(bien.getValeurBien(), e) + tax;
    }
}
