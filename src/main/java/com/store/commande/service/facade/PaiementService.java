package com.store.commande.service.facade;

import com.store.commande.bean.Paiement;

import java.util.List;

public interface PaiementService {
    int save(Paiement paiement);
    List<Paiement> findAll();
    Paiement findByRef(String ref);
    int deleteByRef(String ref);
    int deleteByCommandeCode(String code);
    List<Paiement> findByCommandeCode(String code);

    int deleteByCommandeRef(String ref);
}
