package ma.wafaassurance.rsapi.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeHab;
    private String typeOcc;
    private String typeRes;
    private String description;
    private Double valeurBien;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeHab() {
        return typeHab;
    }

    public void setTypeHab(String typeHab) {
        this.typeHab = typeHab;
    }

    public String getTypeOcc() {
        return typeOcc;
    }

    public void setTypeOcc(String typeOcc) {
        this.typeOcc = typeOcc;
    }

    public String getTypeRes() {
        return typeRes;
    }

    public void setTypeRes(String typeRes) {
        this.typeRes = typeRes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValeurBien() {
        return valeurBien;
    }

    public void setValeurBien(Double valeurBien) {
        this.valeurBien = valeurBien;
    }

    public void setGaranties(Set<Garantie> garanties) {
    }
}