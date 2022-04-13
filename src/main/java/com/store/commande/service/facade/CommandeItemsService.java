package com.store.commande.service.facade;

import com.store.commande.bean.CommandeItems;

import java.util.List;


public interface CommandeItemsService {
    List<CommandeItems> findByCommandeCode(String code);
    int deleteByCommmandeCode(String code);
    void save(CommandeItems commandeItems);
}
