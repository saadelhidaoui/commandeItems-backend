package com.store.commande.service.ampl;

import com.store.commande.bean.CommandeItems;
import com.store.commande.dao.CommandeItemsDao;
import com.store.commande.service.facade.CommandeItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeItemsImpl implements CommandeItemsService {

    @Autowired
    private CommandeItemsDao commandeItemsDao;
    @Override
    public List<CommandeItems> findByCommandeCode(String code) {
        return commandeItemsDao.findByCommandeCode(code);
    }

    @Override
    public int deleteByCommmandeCode(String code) {
        return commandeItemsDao.deleteByCommandeCode(code);
    }

    @Override
    public void save(CommandeItems commandeItems) {
        commandeItemsDao.save(commandeItems);
    }
}
