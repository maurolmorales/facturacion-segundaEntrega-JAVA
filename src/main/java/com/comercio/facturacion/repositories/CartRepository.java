package com.comercio.facturacion.repositories;
import com.comercio.facturacion.entities.Cart;
import com.comercio.facturacion.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  @Query("SELECT c FROM Cart c WHERE c.clientCart = :client")
  List<Cart> findByClientCart(@Param("client") Client client);
}
