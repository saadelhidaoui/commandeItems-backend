package com.store.commande.ws;

import com.store.commande.bean.Produit;
import com.store.commande.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
public class ProduitWs {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/code/{code}")
    public Produit findByCode(@PathVariable String code) {
        return produitService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return produitService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<Produit> findAll() {
        return produitService.findAll();
    }
}
