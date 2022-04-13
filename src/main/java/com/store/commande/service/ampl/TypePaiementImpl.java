package com.store.commande.service.ampl;

import com.store.commande.bean.TypePaiement;
import com.store.commande.dao.TypePaiementDao;
import com.store.commande.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypePaiementImpl implements TypePaiementService {
    @Autowired
    private TypePaiementDao typePaiementDao;
    @Override
    public TypePaiement findByRef(String ref) {
        return typePaiementDao.findByRef(ref);
    }


}
