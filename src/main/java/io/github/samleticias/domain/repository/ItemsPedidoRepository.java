package io.github.samleticias.domain.repository;

import io.github.samleticias.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
