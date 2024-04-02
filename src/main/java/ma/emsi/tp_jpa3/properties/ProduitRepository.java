package ma.emsi.tp_jpa3.properties;

import ma.emsi.tp_jpa3.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
 Produit findByname(String name);

}
