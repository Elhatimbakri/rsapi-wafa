package ma.wafaassurance.rsapi.repository;

import ma.wafaassurance.rsapi.model.Garantie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarantieRepository extends JpaRepository<Garantie, Long> {
}
