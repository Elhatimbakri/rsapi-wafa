package ma.wafaassurance.rsapi.controller;

import ma.wafaassurance.rsapi.dto.BienRequest;
import ma.wafaassurance.rsapi.model.*;
import ma.wafaassurance.rsapi.repository.*;
import ma.wafaassurance.rsapi.service.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/simulation")
@CrossOrigin
public class SimulationController {

    @Autowired
    private BienRepository bienRepository;

    @Autowired
    private GarantieRepository garantieRepository;

    @Autowired
    private DevisRepository devisRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FormuleRepository formuleRepository;

    @Autowired
    private BienService bienService;

    @PostMapping("/add")
    public ResponseEntity<Devis> createDevis(@RequestBody BienRequest bienRequest) {
        // Create and save Bien
        Bien bien = new Bien();
        bien.setTypeHab(bienRequest.getTypeHab());
        bien.setTypeOcc(bienRequest.getTypeOcc());
        bien.setTypeRes(bienRequest.getTypeRes());
        bien.setDescription(bienRequest.getDescription());
        bien.setValeurBien(bienRequest.getValeurBien());

        Set<Garantie> garanties = new HashSet<>();
        for (Long id : bienRequest.getGarantieIds()) {
            Garantie garantie = garantieRepository.findById(id).orElse(null);
            if (garantie != null) {
                garanties.add(garantie);
            }
        }
        bien.setGaranties(garanties);
        bien = bienRepository.save(bien);

        // Create and save Client
        Client client = new Client();
        client.setNom(bienRequest.getClientNom());
        client.setPrenom(bienRequest.getClientPrenom());
        client.setEmail(bienRequest.getClientEmail());
        client.setPassword(bienRequest.getClientPassword());
        client.setPhone(bienRequest.getClientPhone());
        client.setCin(bienRequest.getClientCin());
        client.setAdresse(bienRequest.getClientAdresse());
        client.setVille(bienRequest.getClientVille());
        client.setCodePostal(bienRequest.getClientCodePostal());
        client = clientRepository.save(client);

        // Calculate monthly payment
        Formule formule = formuleRepository.findById(bienRequest.getFormuleId()).orElse(null);
        double coefficient = (formule != null) ? formule.getCoefficient() : 1.0;
        double tax = bien.getValeurBien() * 0.004;
        double monthlyFormule = coefficient * Math.pow(bien.getValeurBien(), 0.3) + tax;

        if (!bienRequest.getGarantieIds().isEmpty()) {
            Bien finalBien = bien;
            double garantiesTotal = garanties.stream()
                    .mapToDouble(garantie -> finalBien.getValeurBien() * garantie.getValue())
                    .sum();
            monthlyFormule += garantiesTotal;
        }

        // Set montantTotal without discount
        double montantTotal = monthlyFormule;

        // Calculate montantPaye based on discount
        double montantPaye = montantTotal;
        if (bienRequest.getEstPromo()) {
            montantPaye = montantTotal - (montantTotal * 0.1); // Apply 10% discount
        }

        // Create and save Devis
        Devis devis = new Devis();
        devis.setBien(bien);
        devis.setMontantTotal(montantTotal); // Set montantTotal
        devis.setEstValide(false);
        devis.setEstPaye(false);
        devis.setEstPromo(bienRequest.getEstPromo());
        devis.setDateCreation(new java.util.Date());

        // Set DateEffet and DateExp
        Date dateEffet = bienRequest.getDateEffet();
        devis.setDateEffet(dateEffet);

        // Convert DateEffet to LocalDate, add 365 days, and convert back to Date
        LocalDate dateEffetLocal = dateEffet.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateExpLocal = dateEffetLocal.plus(365, ChronoUnit.DAYS);
        Date dateExp = Date.from(dateExpLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        devis.setDateExp(dateExp);

        devis.setMontantPaye(montantPaye); // Set montantPaye

        devis.setClient(client);
        devis.setFormule(formule);
        devis.setGaranties(garanties);
        devis = devisRepository.save(devis);

        return ResponseEntity.ok(devis);
    }

    @PostMapping("/calculate")
    public ResponseEntity<Double> calculatePayment(@RequestBody BienRequest bienRequest) {
        // Create and save Bien
        Bien bien = new Bien();
        bien.setTypeHab(bienRequest.getTypeHab());
        bien.setTypeOcc(bienRequest.getTypeOcc());
        bien.setTypeRes(bienRequest.getTypeRes());
        bien.setValeurBien(bienRequest.getValeurBien());


        // Calculate monthly payment
        Formule formule = formuleRepository.findById(bienRequest.getFormuleId()).orElse(null);
        double coefficient = (formule != null) ? formule.getCoefficient() : 1.0;
        double tax = bien.getValeurBien() * 0.004;
        double monthlyFormule = coefficient * Math.pow(bien.getValeurBien(), 0.3) + tax;


        // Set montantTotal without discount
        double montantTotal = monthlyFormule;

        // Calculate montantPaye based on discount
        double montantPaye = montantTotal;
        if (bienRequest.getEstPromo()) {
            montantPaye = montantTotal - (montantTotal * 0.1); // Apply 10% discount
        }

        return ResponseEntity.ok(montantPaye);
    }
}