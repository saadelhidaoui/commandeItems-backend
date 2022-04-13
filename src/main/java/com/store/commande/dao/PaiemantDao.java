package com.store.commande.dao;

import com.store.commande.bean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiemantDao extends JpaRepository<Paiement, Long> {
    Paiement findByRef(String ref);
    int deleteByRef(String ref);
    List<Paiement> findAll();
    int deleteByCommandeCode(String code);
    List<Paiement> findByCommandeCode(String code);
}
