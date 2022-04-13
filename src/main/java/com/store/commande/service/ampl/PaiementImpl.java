package com.store.commande.service.ampl;

import com.store.commande.bean.Commande;
import com.store.commande.bean.Paiement;
import com.store.commande.bean.TypePaiement;
import com.store.commande.dao.PaiemantDao;
import com.store.commande.service.facade.CommandeService;
import com.store.commande.service.facade.PaiementService;
import com.store.commande.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementImpl implements PaiementService {
    @Autowired
    private PaiemantDao paiemantDao;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private TypePaiementService typePaiementService;

    @Override
    public int save(Paiement paiement) {
        Commande commande  = commandeService.findByCode(paiement.getCommande().getCode());
        paiement.setCommande(commande);
        TypePaiement typePaiement = typePaiementService.findByRef(paiement.getTypePaiement().getRef());
        paiement.setTypePaiement(typePaiement);

        if(commande == null){
            return -1;
        }else if (typePaiement == null ){
            return -2;
        }else if (findByRef(paiement.getRef()) != null ){
            return -3;
        }else if (commande.getTotalPaye() + paiement.getMontant() > commande.getTotal() ){
            return -4;
        }else{
            paiemantDao.save(paiement);
            commande.setTotalPaye(commande.getTotalPaye() + paiement.getMontant());
            commandeService.update(commande);
            return 1;
        }

    }

    @Override
    public List<Paiement> findAll() {
        return paiemantDao.findAll();
    }

    @Override
    public Paiement findByRef(String ref) {
        return paiemantDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        return paiemantDao.deleteByRef(ref);
    }

    @Override
    public int deleteByCommandeCode(String code) {
        return paiemantDao.deleteByCommandeCode(code);
    }

    @Override
    public List<Paiement> findByCommandeCode(String code) {
        return paiemantDao.findByCommandeCode(code);
    }

    @Override
    public int deleteByCommandeRef(String ref) {
        return paiemantDao.deleteByRef(ref);
    }

    public TypePaiementService getTypePaiementService() {
        return typePaiementService;
    }
}
