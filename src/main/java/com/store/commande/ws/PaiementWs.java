package com.store.commande.ws;

import com.store.commande.bean.Paiement;
import com.store.commande.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiement")
public class PaiementWs {
    @Autowired
    private PaiementService paiementService;

    @PostMapping("/")
    public int save(@RequestBody Paiement paiement) {
        return paiementService.save(paiement);
    }

    @GetMapping("/")
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }

    @GetMapping("/ref/{ref}")
    public Paiement findByRef(@PathVariable String ref) {
        return paiementService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return paiementService.deleteByRef(ref);
    }

    @Transactional
    @DeleteMapping("/commande/ref/{ref}")
    public int deleteByCommandeRef(@PathVariable String ref) {
        return paiementService.deleteByCommandeRef(ref);
    }
}
