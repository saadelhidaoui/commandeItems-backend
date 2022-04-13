package com.store.commande.dao;

import com.store.commande.bean.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Long> {
    Produit findByCode(String code);
    List<Produit> findAll();
    int deleteByCode(String code);

}
