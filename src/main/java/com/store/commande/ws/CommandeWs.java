package com.store.commande.ws;

import com.store.commande.bean.Commande;
import com.store.commande.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande/")
public class CommandeWs {
    @Autowired
    private CommandeService commandeService;

    @PutMapping("/")
    public void update(@RequestBody Commande commande) {
        commandeService.update(commande);
    }

    @GetMapping("/code/{code}")
    public Commande findByCode(@PathVariable String code) {
        return commandeService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @Transactional
    @DeleteMapping("/all/code/{code}")
    public int deleteWithAssociatePaiement(@PathVariable String code) {
        return commandeService.deleteWithAssociatePaiement(code);
    }

    @GetMapping("/")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return commandeService.deleteByCode(code);
    }
}
