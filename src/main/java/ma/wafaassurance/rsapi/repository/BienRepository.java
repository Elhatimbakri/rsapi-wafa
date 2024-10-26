package ma.wafaassurance.rsapi.repository;

import ma.wafaassurance.rsapi.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {
}
