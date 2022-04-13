package com.store.commande.bean;

import javax.persistence.*;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Double montant;

    @ManyToOne
    private Commande commande;
    @ManyToOne
    private TypePaiement typePaiement;

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Long getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public Double getMontant() {
        return montant;
    }

    public Commande getCommande() {
        return commande;
    }
}
