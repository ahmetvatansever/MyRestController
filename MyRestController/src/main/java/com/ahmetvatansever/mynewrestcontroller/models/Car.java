package com.ahmetvatansever.mynewrestcontroller.models;

public class Car {
    private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double price;

    public Car() {
    }

    public Car(Long id, String model, String brand, Integer horses, Double price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.horses = horses;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getHorses() {
        return horses;
    }

    public void setHorses(Integer horses) {
        this.horses = horses;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
