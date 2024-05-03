package one.proyect.Entities;

public class Report3 {
    private String brand;
    private String time_average;

    public Report3() {
        brand = "";
        time_average = "";
    }

    public Report3(String brand, String time_average) {
        this.brand = brand;
        this.time_average = time_average;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTime_average() {
        return time_average;
    }

    public void setTime_average(String time_average) {
        this.time_average = time_average;
    }
}
