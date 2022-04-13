package com.store.commande.dao;

import com.store.commande.bean.CommandeItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeItemsDao extends JpaRepository<CommandeItems, Long> {
    List<CommandeItems> findByCommandeCode(String code);
    int deleteByCommandeCode(String code);
    
}
