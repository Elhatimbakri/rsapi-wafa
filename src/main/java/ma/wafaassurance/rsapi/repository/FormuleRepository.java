package ma.wafaassurance.rsapi.repository;

import ma.wafaassurance.rsapi.model.Formule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormuleRepository extends JpaRepository<Formule, Long> {
}
