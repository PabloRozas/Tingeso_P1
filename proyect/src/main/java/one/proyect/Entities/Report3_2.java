package one.proyect.Entities;

import java.util.Date;

public class Report3_2 {
    String id_brand;
    String brand;
    Date dateAdmission;
    Date departureDate;

    public Report3_2(String id_brand, String brand, Date dateAdmission, Date departureDate) {
        this.id_brand = id_brand;
        this.brand = brand;
        this.dateAdmission = dateAdmission;
        this.departureDate = departureDate;
    }

    // public Long getId_brand() {
    // return id_brand;
    // }

    // public void setId_brand(Long id_brand) {
    // this.id_brand = id_brand;
    // }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
