package one.proyect.Entities;

public class Report2 {
    private String name_type_repair;
    private String total_reparations;
    private String total_mount;

    public Report2(String name_type_repair, String total_reparations, String total_mount) {
        this.name_type_repair = name_type_repair;
        this.total_reparations = total_reparations;
        this.total_mount = total_mount;
    }

    public String getName_type_repair() {
        return name_type_repair;
    }

    public void setName_type_repair(String name_type_repair) {
        this.name_type_repair = name_type_repair;
    }

    public String getTotal_reparations() {
        return total_reparations;
    }

    public void setTotal_reparations(String total_reparations) {
        this.total_reparations = total_reparations;
    }

    public String getTotal_mount() {
        return total_mount;
    }

    public void setTotal_mount(String total_mount) {
        this.total_mount = total_mount;
    }

}
