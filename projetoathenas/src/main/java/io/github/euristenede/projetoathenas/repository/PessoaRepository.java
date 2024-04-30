package io.github.euristenede.projetoathenas.repository;

import io.github.euristenede.projetoathenas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Euristenede Santos
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
