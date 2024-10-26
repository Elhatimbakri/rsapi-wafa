package ma.wafaassurance.rsapi.controller;

import ma.wafaassurance.rsapi.dto.BienRequest;
import ma.wafaassurance.rsapi.model.Bien;
import ma.wafaassurance.rsapi.model.Client;
import ma.wafaassurance.rsapi.model.Devis;
import ma.wafaassurance.rsapi.model.Formule;
import ma.wafaassurance.rsapi.model.Garantie;
import ma.wafaassurance.rsapi.repository.BienRepository;
import ma.wafaassurance.rsapi.repository.ClientRepository;
import ma.wafaassurance.rsapi.repository.DevisRepository;
import ma.wafaassurance.rsapi.repository.FormuleRepository;
import ma.wafaassurance.rsapi.repository.GarantieRepository;
import ma.wafaassurance.rsapi.service.BienService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/bien")
@CrossOrigin(origins = "*")
public class BienController {

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


    @GetMapping
    public List<Bien> getAllBiens() {
        return bienService.getAllBiens();
    }

    @GetMapping("/{id}")
    public Bien getBienById(@PathVariable Long id) {
        return bienService.getBienById(id);
    }

    @PostMapping
    public Bien saveBien(@RequestBody Bien bien) {
        return bienService.saveBien(bien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatedBien(@PathVariable Long id, @RequestBody Bien bienDetails) {
        Optional<Bien> bien = Optional.ofNullable(bienService.getBienById(id));
        if (bien.isPresent()) {
            Bien updatedBien = bien.get();
            //variable
            updatedBien.setTypeHab(bienDetails.getTypeHab());
            updatedBien.setTypeOcc(bienDetails.getTypeOcc());
            updatedBien.setTypeRes(bienDetails.getTypeRes());
            updatedBien.setDescription(bienDetails.getDescription());
            updatedBien.setValeurBien(bienDetails.getValeurBien());
            return ResponseEntity.ok(bienService.saveBien(updatedBien));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBien(@PathVariable Long id) {
        bienService.deleteBien(id);
    }
}