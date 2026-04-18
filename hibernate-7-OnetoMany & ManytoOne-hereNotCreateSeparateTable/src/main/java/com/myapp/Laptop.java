package com.myapp;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @Column(name = "lap_id", length = 10, nullable = false, unique = true)
    private int lid;

    @Column(name = "brand_name")
    private String brand;

    @Column(name = "model_name")
    private String model;

    @Column(name = "ram_capacity")
    private String ram;

    @ManyToOne()
    private Employee employee;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram='" + ram +
                '}';
    }
}
