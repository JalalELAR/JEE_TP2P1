package ma.emsi.tp_jpa3;

import ma.emsi.tp_jpa3.entities.Produit;
import ma.emsi.tp_jpa3.properties.ProduitRepository;
import ma.emsi.tp_jpa3.service.IProduitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class TpJpa3Application {

    public static void main(String[] args) {
        SpringApplication.run(TpJpa3Application.class, args);
    }
    @Bean
    CommandLineRunner start(IProduitService produitService, ProduitRepository produitRepository){
        return args -> {
            Stream.of("telephone","tablette","pc").forEach(name -> {
                Produit produit = new Produit();
                produit.setName(name);
                produit.setPrice(6000);
                produit.setQuantity(20);
                produitService.saveProduit(produit);
            });

            // Move this line inside the CommandLineRunner implementation
            Produit produit = produitRepository.findByname("pc");
        };
    }
}
