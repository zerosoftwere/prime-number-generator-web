package me.xerosoft.repositories;

import me.xerosoft.entity.PrimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimeGeneratorRepository extends JpaRepository<PrimeEntity, Long> {
}
