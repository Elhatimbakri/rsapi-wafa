package ma.wafaassurance.rsapi.repository;

import ma.wafaassurance.rsapi.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevisRepository extends JpaRepository<Devis, Long> {
   List<Devis> findByClientId(Long clientId);
}
