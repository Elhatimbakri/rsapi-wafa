package ma.wafaassurance.rsapi.dto;

import java.util.Date;
import java.util.List;

public class BienRequest {

    private String typeHab;
    private String typeOcc;
    private String typeRes;
    private String description;
    private Double valeurBien;

    // Client details
    private String clientCin; // National ID
    private String clientNom; // Last Name
    private String clientPrenom; // First Name
    private String clientPhone; // Phone Number
    private String clientAdresse; // Address
    private String clientVille; // City
    private String clientCodePostal; // Postal Code
    private String clientEmail; // Email
    private String clientPassword; // Password

    // Formule ID if applicable
    private Long formuleId;

    // List of Garantie IDs
    private List<Long> garantieIds;



    //Devis
    private Date dateEffet;
    private Boolean estPromo;

    // Getters and Setters
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

    public String getClientCin() {
        return clientCin;
    }

    public void setClientCin(String clientCin) {
        this.clientCin = clientCin;
    }


    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClientPrenom() {
        return clientPrenom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAdresse() {
        return clientAdresse;
    }

    public void setClientAdresse(String clientAdresse) {
        this.clientAdresse = clientAdresse;
    }

    public String getClientVille() {
        return clientVille;
    }

    public void setClientVille(String clientVille) {
        this.clientVille = clientVille;
    }

    public String getClientCodePostal() {
        return clientCodePostal;
    }

    public void setClientCodePostal(String clientCodePostal) {
        this.clientCodePostal = clientCodePostal;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public Long getFormuleId() {
        return formuleId;
    }

    public void setFormuleId(Long formuleId) {
        this.formuleId = formuleId;
    }

    public List<Long> getGarantieIds() {
        return garantieIds;
    }

    public void setGarantieIds(List<Long> garantieIds) {
        this.garantieIds = garantieIds;
    }

    public Boolean getEstPromo() {
        return estPromo;
    }

    public void setEstPromo(Boolean estPromo) {
        this.estPromo = estPromo;
    }

    public Date getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

}