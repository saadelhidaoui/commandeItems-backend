package com.store.commande.service.facade;

import com.store.commande.bean.Produit;

import java.util.List;


public interface ProduitService {
    Produit findByCode(String code);
    int save(Produit produit);
    List<Produit> findAll();
    int deleteByCode(String code);
}
