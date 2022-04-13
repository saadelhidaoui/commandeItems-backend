package com.store.commande.service.ampl;

import com.store.commande.bean.Produit;
import com.store.commande.dao.ProduitDao;
import com.store.commande.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitImpl implements ProduitService {

    @Autowired
    private ProduitDao produitDao;
    @Override
    public Produit findByCode(String code) {
        return produitDao.findByCode(code);
    }

    @Override
    public int save(Produit produit) {
        if(findByCode(produit.getCode()) != null){
            return -1;
        }else{
            produitDao.save(produit);
            return 1;
        }
    }

    @Override
    public List<Produit> findAll() {
        return produitDao.findAll();
    }

    @Override
    public int deleteByCode(String code) {
        return produitDao.deleteByCode(code);
    }
}
