package ma.wafaassurance.rsapi.service;

import ma.wafaassurance.rsapi.model.Formule;
import ma.wafaassurance.rsapi.repository.FormuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormuleService {

    @Autowired
    private FormuleRepository formuleRepository;

    public List<Formule> getAllFormules() {
        return formuleRepository.findAll();
    }

    public Formule getFormuleById(Long id) {
        Optional<Formule> formule = formuleRepository.findById(id);
        return formule.orElse(null);
    }

    public Formule saveFormule(Formule formule) {
        return formuleRepository.save(formule);
    }

    public void deleteFormule(Long id) {
        formuleRepository.deleteById(id);
    }
}