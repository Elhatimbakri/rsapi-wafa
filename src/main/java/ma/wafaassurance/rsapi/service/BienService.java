package ma.wafaassurance.rsapi.service;

import ma.wafaassurance.rsapi.model.Bien;
import ma.wafaassurance.rsapi.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    public List<Bien> getAllBiens() {
        return bienRepository.findAll();
    }

    public Bien getBienById(Long id) {
        Optional<Bien> bien = bienRepository.findById(id);
        return bien.orElse(null);
    }

    public Bien saveBien(Bien bien) {
        return bienRepository.save(bien);
    }

    public void deleteBien(Long id) {
        bienRepository.deleteById(id);
    }
}