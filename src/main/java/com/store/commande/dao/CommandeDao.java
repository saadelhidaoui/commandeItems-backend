package com.store.commande.dao;

import com.store.commande.bean.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByCode(String code);
    int deleteByCode(String code);
    List<Commande> findAll();
}
