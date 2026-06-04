package br.com.dendeeventos.repository;

import br.com.dendeeventos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeContaining(String nome);

    @Query(
            value = """
                    SELECT * FROM usuarios
                    WHERE email LIKE %?1%
                    """,
            nativeQuery = true
    )
    List<Usuario> buscarPorEmail(String email);
}