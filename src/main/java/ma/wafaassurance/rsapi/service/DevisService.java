package ma.wafaassurance.rsapi.service;

import ma.wafaassurance.rsapi.model.Devis;
import ma.wafaassurance.rsapi.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevisService {

    @Autowired
    private DevisRepository devisRepository;

    public List<Devis> getAllDevis() {
        return devisRepository.findAll();
    }

    public Devis getDevisById(Long id) {
        Optional<Devis> devis = devisRepository.findById(id);
        return devis.orElse(null);
    }

    public Devis saveDevis(Devis devis) {
        return devisRepository.save(devis);
    }

    public void deleteDevis(Long id) {
        devisRepository.deleteById(id);
    }

    public List<Devis> getAllDevisByClientId(Long clientId) {
        return devisRepository.findByClientId(clientId);
    }

    public long getDevisCount() {
        return devisRepository.count();
    }

    public double getTotalMontant() {
        return devisRepository.findAll().stream()
                .mapToDouble(Devis::getMontantTotal)
                .sum();
    }
}
