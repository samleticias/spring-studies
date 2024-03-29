package io.github.samleticias.domain.repository;

import io.github.samleticias.domain.entity.Cliente;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = " select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome( @Param("nome") String name );

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByName(String nome);

    /*
    boolean existsByName(String nome);
    problema ta aqui
     */

    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    // left join: mostra clientes com pedidos ou sem pedidos
    Cliente findClienteFetchPedidos( @Param("id") Integer id);

}

