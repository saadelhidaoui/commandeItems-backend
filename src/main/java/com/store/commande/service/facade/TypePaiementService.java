package com.store.commande.service.facade;

import com.store.commande.bean.TypePaiement;


public interface TypePaiementService {
    TypePaiement findByRef(String ref);
}
