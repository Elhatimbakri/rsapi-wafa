package ma.wafaassurance.rsapi.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Formule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    @Column(columnDefinition="TEXT")
    private String description;
    private double coefficient;

    @OneToMany(mappedBy = "formule")
    private Set<Devis> devis;

    @ManyToMany
    @JoinTable(
            name = "formule_garantie",
            joinColumns = @JoinColumn(name = "formule_id"),
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
    }

    /*public Set<Devis> getDevis() {
        return devis;
    }

    public void setDevis(Set<Devis> devis) {
        this.devis = devis;
    }
*/
    public Set<Garantie> getGaranties() {
        return garanties;
    }

    public void setGaranties(Set<Garantie> garanties) {
        this.garanties = garanties;
    }
}