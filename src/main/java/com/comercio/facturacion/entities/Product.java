package com.comercio.facturacion.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter private Long productId;
  @Getter @Setter private String name;
  @Getter @Setter private Integer stock;
  @Getter @Setter private double price;

  @OneToMany(mappedBy = "productCart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonIgnore
  @Getter @Setter private List<Cart> carts;

  // Se tuvo que agregar el decorador "@JsonIgnore" para que no se generara en una concatenación exponencial.
}