package br.com.dendeeventos.repository;

import br.com.dendeeventos.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository
        extends JpaRepository<Evento, Long> {

    List<Evento> findByNomeContaining(String nome);

    @Query(
            value = """
                    SELECT * FROM eventos
                    WHERE nome LIKE %?1%
                    """,
            nativeQuery = true
    )
    List<Evento> buscarPorNome(String nome);
}