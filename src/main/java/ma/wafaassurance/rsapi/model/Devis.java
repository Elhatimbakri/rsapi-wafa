package ma.wafaassurance.rsapi.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private Date dateEffet;
    private Date dateExp;
    private Double montantTotal;
    private Double montantReduction;
    private Double montantPaye;
    private Boolean estValide;
    private Boolean estPromo;
    private Boolean estPaye;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "bien_id")
    private Bien bien;

    @ManyToOne
    @JoinColumn(name = "formule_id")
    private Formule formule;

    @ManyToMany
    @JoinTable(
            name = "devis_garantie",
            joinColumns = @JoinColumn(name = "devis_id"),
            inverseJoinColumns = @JoinColumn(name = "garantie_id")
    )
    private Set<Garantie> garanties;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Date getDateExp() {
        return dateExp;
    }

    public void setDateExp(Date dateExp) {
        this.dateExp = dateExp;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Double getMontantReduction() {
        return montantReduction;
    }

    public void setMontantReduction(Double montantReduction) {
        this.montantReduction = montantReduction;
    }

    public Double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(Double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Boolean getEstValide() {
        return estValide;
    }

    public void setEstValide(Boolean estValide) {
        this.estValide = estValide;
    }

    public Boolean getEstPaye() {
        return estPaye;
    }

    public void setEstPaye(Boolean estPaye) {
        this.estPaye = estPaye;
    }

    public Boolean getEstPromo() {
        return estPromo;
    }

    public void setEstPromo(Boolean estPromo) {
        this.estPromo = estPromo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Set<Garantie> getGaranties() {
        return garanties;
    }

    public void setGaranties(Set<Garantie> garanties) {
        this.garanties = garanties;
    }

    public Formule getFormule() {
        return formule;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
    }
}