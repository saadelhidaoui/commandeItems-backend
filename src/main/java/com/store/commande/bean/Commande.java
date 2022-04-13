package com.store.commande.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Double total;
    private Double totalPaye;
    @OneToMany(mappedBy = "commande")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<CommandeItems> commandeItems;

    @OneToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Paiement> paiements;

    public void setTotalPaye(Double totalPaye) {
        this.totalPaye = totalPaye;
    }

    public Double getTotalPaye() {
        return totalPaye;
    }



    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public List<CommandeItems> getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(List<CommandeItems> commandeItems) {
        this.commandeItems = commandeItems;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Double getTotal() {
        return total;
    }

}
