package com.comercio.facturacion.services;
import com.comercio.facturacion.entities.Client;
import com.comercio.facturacion.entities.Cart;
import com.comercio.facturacion.entities.Product;
import com.comercio.facturacion.repositories.ClientRepository;
import com.comercio.facturacion.repositories.CartRepository;
import com.comercio.facturacion.repositories.InvoiceRepository;
import com.comercio.facturacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
  @Autowired private CartRepository cartRepository;
  @Autowired private InvoiceRepository invoiceRepository;
  @Autowired private ProductRepository productRepository;
  @Autowired private ClientRepository clientRepository;

  public void addToCart(Long clientId, Long productId, Integer amount) throws Exception {
    Optional<Client> clientOptional = clientRepository.findById(clientId);
    Optional<Product> productOptional = productRepository.findById(productId);
    if (clientOptional.isEmpty()) { throw new Exception("Client not found with id: " + clientId); }
    if (productOptional.isEmpty()) { throw new Exception("Product not found with id: " + productId); }
    Client client = clientOptional.get();
    Product product = productOptional.get();
    Cart cartNew = new Cart();
    cartNew.setClientCart(client);
    cartNew.setProductCart(product);
    cartNew.setAmount(amount);
    cartNew.setPrice(product.getPrice());
    cartRepository.save(cartNew);
  }

  public void removeFromCart(Long cartId, Long productId) throws Exception {
    Optional<Cart> cartOptional = cartRepository.findById(cartId);
    Optional<Product> productOptional = productRepository.findById(productId);
    if (cartOptional.isEmpty()) { throw new Exception("Client not found with id: " + cartId); }
    if (productOptional.isEmpty()) { throw new Exception("Product not found with id: " + productId); }
    Cart cart = cartOptional.get();
    Product product = productOptional.get();
    System.out.println(cart);
  }




/*
    Invoice invoice = invoiceRepository.findOpenInvoiceByClientId(clientId)
            .orElseGet(()->{
              Invoice invoiceNew = new Invoice();
              invoiceNew.setClient(client);
              invoiceNew.setCreate_at(LocalDateTime.now());
              invoiceNew.setTotal(0.0);
              return invoiceRepository.save(invoiceNew);
            });

    InvoiceDetail cart = new InvoiceDetail();
    cart.setAmount(amount);
    cart.setPrice(product.getPrice());
    cart.setProduct(product);
    cart.setInvoice(invoice);
    invoiceDetailRepository.save(cart);

    invoice.setTotal(invoice.getTotal()+(product.getPrice() * amount));
    invoiceRepository.save(invoice);
  }

  public List<InvoiceDetail> readAllCart(){

 */







  public List<Cart> readAllCart(){
    return cartRepository.findAll();
  }

  public Optional<Cart> findOneCart(Long id){
    return cartRepository.findById(id);
  }

  public void deleteOneCart(Long id){
    cartRepository.deleteById(id);
  }


}
