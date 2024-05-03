package one.proyect.Entities;

public class Report1 {
    private String patent_vehicle;
    private String id_reparation;
    private String descount1;
    private String descount2;
    private String descount3;
    private String surcharge1;
    private String surcharge2;
    private String surcharge3;
    private String total_reparation;
    private String mount;

    public Report1() {
    }

    public Report1(String patent_vehicle, String id_reparation, String descount1, String descount2, String surcharge1,
            String surcharge2, String total_reparation, String mount) {
        this.patent_vehicle = patent_vehicle;
        this.id_reparation = id_reparation;
        this.descount1 = descount1;
        this.descount2 = descount2;
        this.surcharge1 = surcharge1;
        this.surcharge2 = surcharge2;
        this.total_reparation = total_reparation;
        this.mount = mount;
    }

    public String getPatent_vehicle() {
        return patent_vehicle;
    }

    public void setPatent_vehicle(String patent_vehicle) {
        this.patent_vehicle = patent_vehicle;
    }

    public String getId_reparation() {
        return id_reparation;
    }

    public void setId_reparation(String id_reparation) {
        this.id_reparation = id_reparation;
    }

    public String getDescount1() {
        return descount1;
    }

    public void setDescount1(String descount1) {
        this.descount1 = descount1;
    }

    public String getDescount2() {
        return descount2;
    }

    public void setDescount2(String descount2) {
        this.descount2 = descount2;
    }

    public String getSurcharge1() {
        return surcharge1;
    }

    public void setSurcharge1(String surcharge1) {
        this.surcharge1 = surcharge1;
    }

    public String getSurcharge2() {
        return surcharge2;
    }

    public void setSurcharge2(String surcharge2) {
        this.surcharge2 = surcharge2;
    }

    public String getTotal_reparation() {
        return total_reparation;
    }

    public void setTotal_reparation(String total_reparation) {
        this.total_reparation = total_reparation;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    public String getDescount3() {
        return descount3;
    }

    public void setDescount3(String descount3) {
        this.descount3 = descount3;
    }

    public String getSurcharge3() {
        return surcharge3;
    }

    public void setSurcharge3(String surcharge3) {
        this.surcharge3 = surcharge3;
    }
}
