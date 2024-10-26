package ma.wafaassurance.rsapi.service;

import ma.wafaassurance.rsapi.model.Garantie;
import ma.wafaassurance.rsapi.repository.GarantieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarantieService {

    @Autowired
    private GarantieRepository garantieRepository;

    public List<Garantie> getAllGaranties() {
        return garantieRepository.findAll();
    }

    public Garantie getGarantieById(Long id) {
        Optional<Garantie> garantie = garantieRepository.findById(id);
        return garantie.orElse(null);
    }

    public Garantie saveGarantie(Garantie garantie) {
        return garantieRepository.save(garantie);
    }

    public void deleteGarantie(Long id) {
        garantieRepository.deleteById(id);
    }
}