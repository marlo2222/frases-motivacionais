package bot.motivacionais.frases.repository;

import bot.motivacionais.frases.model.Frase;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FraseRepository extends JpaRepository<Frase, Long> {

    void deleteFraseById(Long id);

    Optional<Frase> findFraseById(Long id);

}
