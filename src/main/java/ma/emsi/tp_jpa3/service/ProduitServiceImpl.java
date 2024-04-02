package ma.emsi.tp_jpa3.service;

import jakarta.transaction.Transactional;
import ma.emsi.tp_jpa3.entities.Produit;
import ma.emsi.tp_jpa3.properties.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProduitServiceImpl implements IProduitService {
    private ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }
}
