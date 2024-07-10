package com.comercio.facturacion.services;
import com.comercio.facturacion.entities.Product;
import com.comercio.facturacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
  @Autowired private ProductRepository productRepository;

 public Product saveProduct(Product product){
   return productRepository.save(product);
 }

 public List<Product> readAllProduct(){
   return productRepository.findAll();
 }

 public Optional<Product> readOneProduct(Long id){
   return productRepository.findById(id);
 }

 public Product updatePartial (Long productId, Map<String, Object> updates) throws Exception {
   Optional<Product> productFound = productRepository.findById(productId);
   if(productFound.isEmpty()){ throw new Exception("Product Not Found"); }
   else{
     Product product = productFound.get();
     updates.forEach((key, value)->{
       switch(key){
         case "name": product.setName((String) value);
          break;
         case "stock": product.setStock((Integer) value);
          break;
         case "price": product.setPrice((double) value);
          break;
       }
     });
     return productRepository.save(product);
   }
 }

 public void deleteOneProduct(Long id){
   productRepository.deleteById(id);
 }

}