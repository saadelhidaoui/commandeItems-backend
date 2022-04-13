package com.store.commande.ws;

import com.store.commande.bean.CommandeItems;
import com.store.commande.service.facade.CommandeItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commandeItems")
public class CommandeItemsWs {
    @Autowired
    private CommandeItemsService commandeItemsService;

    public List<CommandeItems> findByCommandeCode(String code) {
        return commandeItemsService.findByCommandeCode(code);
    }

    public int deleteByCommmandeCode(String code) {
        return commandeItemsService.deleteByCommmandeCode(code);
    }

    public void save(CommandeItems commandeItems) {
        commandeItemsService.save(commandeItems);
    }
}
