package br.com.dendeeventos.repository;

import br.com.dendeeventos.entity.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizadorRepository
        extends JpaRepository<Organizador, Long> {

    List<Organizador> findByNomeContaining(String nome);

    @Query(
            value = """
                    SELECT * FROM organizadores
                    WHERE nome LIKE %?1%
                    """,
            nativeQuery = true
    )
    List<Organizador> buscarPorNome(String nome);
}