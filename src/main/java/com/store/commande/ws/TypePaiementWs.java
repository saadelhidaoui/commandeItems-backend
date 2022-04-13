package com.store.commande.ws;

import com.store.commande.bean.TypePaiement;
import com.store.commande.service.facade.TypePaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/typePaiement")
public class TypePaiementWs {

    @Autowired
    private TypePaiementService typePaiementService;

    @GetMapping("/ref/{ref}")
    public TypePaiement findByRef(String ref) {
        return typePaiementService.findByRef(ref);
    }


}
