package com.store.commande.dao;

import com.store.commande.bean.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypePaiementDao extends JpaRepository<TypePaiement, Long> {
    TypePaiement findByRef(String ref);
    int deleteByRef(String ref);
}
