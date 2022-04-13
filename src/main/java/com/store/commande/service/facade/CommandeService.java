package com.store.commande.service.facade;

import com.store.commande.bean.Commande;

import java.util.List;

public interface CommandeService {
    void update(Commande commande);
    Commande findByCode(String code);
    int save(Commande commande);
    int deleteWithAssociatePaiement(String code);
    int deleteByCode(String code);
    List<Commande> findAll();
}
