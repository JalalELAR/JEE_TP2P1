package ma.emsi.tp_jpa3.web;

import ma.emsi.tp_jpa3.entities.Produit;
import ma.emsi.tp_jpa3.properties.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProduitRestController {
    @Autowired
    private ProduitRepository produitRepository ;
    @GetMapping("/produits")
    public List<Produit> produitList(){
        return produitRepository.findAll();
    }
    @PostMapping
    public Produit addProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }
    @GetMapping("/produits/{id}") // Endpoint pour consulter un produit par son ID
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        return produit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/produits/{id}") // Endpoint pour mettre à jour un produit par son ID
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
        Optional<Produit> existingProduitOptional = produitRepository.findById(id);
        if (existingProduitOptional.isPresent()) {
            Produit existingProduit = existingProduitOptional.get();
            existingProduit.setName(produitDetails.getName());
            existingProduit.setPrice(produitDetails.getPrice());
            existingProduit.setQuantity(produitDetails.getQuantity());
            produitRepository.save(existingProduit);
            return ResponseEntity.ok(existingProduit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/produits/{id}") // Endpoint pour supprimer un produit par son ID
    public ResponseEntity<?> deleteProduit(@PathVariable Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        if (produit.isPresent()) {
            produitRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
