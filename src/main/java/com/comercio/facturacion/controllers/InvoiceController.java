package com.comercio.facturacion.controllers;
import com.comercio.facturacion.entities.Client;
import com.comercio.facturacion.entities.Invoice;
import com.comercio.facturacion.entities.Product;
import com.comercio.facturacion.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/invoices")
public class InvoiceController {
  @Autowired private InvoiceService invoiceService;

  @PostMapping
  public ResponseEntity<Invoice> generateInvoice(@RequestBody Client clientId){
    try{
      return new ResponseEntity<>(invoiceService.generateInvoice(clientId), HttpStatus.CREATED);
    }catch (Exception error){
      System.out.println(error.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }



}
