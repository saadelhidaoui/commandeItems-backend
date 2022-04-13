package com.store.commande.service.ampl;


import com.store.commande.bean.Commande;
import com.store.commande.bean.CommandeItems;

import com.store.commande.bean.Paiement;
import com.store.commande.bean.Produit;
import com.store.commande.dao.CommandeDao;
import com.store.commande.service.facade.CommandeItemsService;
import com.store.commande.service.facade.CommandeService;
import com.store.commande.service.facade.PaiementService;
import com.store.commande.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeImpl implements CommandeService {
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private PaiementService paiementService;
    @Autowired
    private CommandeItemsService commandeItemsService;
    @Autowired
    private ProduitService produitService;


    public int save(Commande commande) {
        prepareSave(commande);
        int res = validateSave(commande);
        if (res < 0) {
            return res;
        } else {
            handleProcess(commande);
            return 1;

        }

    }

    private void handleProcess(Commande commande){
        CalcTotal(commande);
        /*List<CommandeItems> commandeItems = new ArrayList<>(commande.getCommandeItems());
        commande.setCommandeItems(null);*/
        List<CommandeItems> commandeItems =commande.getCommandeItems();
        commandeDao.save(commande);
        for (CommandeItems ci : commandeItems){

            ci.setCommande(commande);
            commandeItemsService.save(ci);
        }
    }

    private void prepareSave(Commande commande){
        List<CommandeItems>commandeItems=commande.getCommandeItems();
        for (CommandeItems e : commandeItems) {
            Produit produit = produitService.findByCode(e.getProduit().getCode());
            e.setProduit(produit);
        }
        commande.setCommandeItems(commandeItems);
       /* for(CommandeItems ci : commande.getCommandeItems()){
            Produit produit = produitService.findByCode(ci.getProduit().getCode());
            ci.setProduit(produit);
        }*/
    }

    private int validateSave(Commande commande) {
        if (findByCode(commande.getCode()) != null) {
            return -1;
        }else if (commande.getCommandeItems() == null && commande.getCommandeItems().isEmpty()) {
                return -2;
            } else {
                return 1;
        }
    }

    private void CalcTotal(Commande commande) {
        /*Double total = commande.getCommandeItems().stream().mapToDouble(
                e -> e.getQte() * e.getProduit().getPrix()
        ).sum();
        commande.setTotal(total);*/
        double index = 0;
        for (CommandeItems ci : commande.getCommandeItems()){
            index+= ci.getProduit().getPrix() * ci.getQte();
        }
        commande.setTotal(index);
    }

    @Override
    public void update(Commande commande) {
        if (findByCode(commande.getCode()) != null) {
            commandeDao.save(commande);
        }
    }

    @Override
    public Commande findByCode(String code) {
        return commandeDao.findByCode(code);
    }

    private void preparDelete(Commande commande){
        List<Paiement> paiements = paiementService.findByCommandeCode(commande.getCode());
        commande.setPaiements(paiements);
    }
    private int validateDelete(Commande commande){
        if(findByCode(commande.getCode()) != null)
            return -1;
        else if (commande.getPaiements() == null && commande.getPaiements().isEmpty())
            return -2;
        else return 1;
    }
    private int handleDeleteProcess(Commande commande){
        int res1 = paiementService.deleteByCommandeCode(commande.getCode());
        int res2 = commandeItemsService.deleteByCommmandeCode(commande.getCode());
        int res3 = commandeDao.deleteByCode(commande.getCode());
        return res1 + res2 + res3;
    }
    public int execDelete(Commande commande){
        preparDelete(commande);
        int res = validateDelete(commande);
        if (res > 0)
            handleDeleteProcess(commande);
        return res;
    }
    @Override
    @Transactional
    public int deleteWithAssociatePaiement(String code) {
        int res1 = paiementService.deleteByCommandeCode(code);
        int res2 = commandeItemsService.deleteByCommmandeCode(code);
        int res3 = commandeDao.deleteByCode(code);
        return res1 + res2 + res3;
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return commandeDao.deleteByCode(code);
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
}
