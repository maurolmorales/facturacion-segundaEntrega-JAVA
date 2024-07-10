package com.comercio.facturacion.services;
import com.comercio.facturacion.entities.Cart;
import com.comercio.facturacion.entities.Client;
import com.comercio.facturacion.entities.Invoice;
import com.comercio.facturacion.repositories.CartRepository;
import com.comercio.facturacion.repositories.ClientRepository;
import com.comercio.facturacion.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InvoiceService {
  @Autowired private InvoiceRepository invoiceRepository;
  @Autowired private ClientRepository clientRepository;
  @Autowired private CartRepository cartRepository;

  public Invoice generateInvoice(Client clientId) throws Exception{
    // Busca el cliente por su ID en el repositorio de clientes:
    Optional<Client> clientOptional = clientRepository.findById(clientId.getClientId());

    // Verifica si el cliente existe y se obtiene la instancia del cliente encontrado:
    if(clientOptional.isEmpty()){ throw new Exception("Client Not Found with id: "+clientId);}
    Client clientFound = clientOptional.get();

    // Busca los ítems del carrito asociados al cliente encontrado y verifica si hay ítems en el carrito del cliente:
    List<Cart> cartItems = cartRepository.findByClientCart(clientFound);
    if (cartItems.isEmpty()){ throw new Exception("No Items in cart for cliente with id: "+clientId); }

    // Calcula el total a pagar sumando el precio por la cantidad de cada ítem en el carrito:
    double total = cartItems.stream().mapToDouble(item -> item.getAmount() * item.getPrice()).sum();

    // Crea una nueva instancia de Invoice (factura):
    Invoice invoice = new Invoice();
    invoice.setClientInvoice(clientFound);
    invoice.setCreate_at(LocalDateTime.now());
    invoice.setTotal(total);
    invoice.setStatus("Paid");
    invoice = invoiceRepository.save(invoice);

    // Asigna la factura a cada ítem del carrito y guarda todos los ítems del carrito con la referencia a la factura:
    for (Cart cartItem : cartItems) { cartItem.setInvoiceCart(invoice); }
    cartRepository.saveAll(cartItems);

    return invoice;
  }

  public List<Invoice> readAllInvoices(){
    return invoiceRepository.findAll();
  }

  public Optional<Invoice> findOneInvoice(Long id){
    return invoiceRepository.findById(id);
  }

  public Invoice updatePartial(Long invoiceId, Map<String, Object> updates) throws Exception{
    Optional<Invoice> invoiceFound = invoiceRepository.findById(invoiceId);
    if(invoiceFound.isEmpty()){throw new Exception("Invoice not found");}
    else {
      Invoice invoice = invoiceFound.get();
      updates.forEach((key, value) -> {
        switch (key) {
          case "name":
            invoice.setCreate_at((LocalDateTime) value);
            break;
          case "stock":
            invoice.setTotal((double) value);
            break;
        }
      });
      return invoiceRepository.save(invoice);
    }
  }

  public void deleteOneInvoice(Long id){
    invoiceRepository.deleteById(id);
  }

}