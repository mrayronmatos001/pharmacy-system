package br.edu.ufrn.models;

import javafx.beans.property.*;

public class Product {
    private final LongProperty id;
    private final StringProperty name;
    private final IntegerProperty bottleQty;
    private final StringProperty unit;
    private final DoubleProperty unitValue;
    private final DoubleProperty price;
    private Prescription prescription;
    private Medication medication;
    private Sale sale;
    private Inventory inventory;
    private final DoubleProperty totalPrice;

    public Product(long id, String name, int bottleQty, String unit, double unitValue, double price, double totalPrice) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.bottleQty = new SimpleIntegerProperty(bottleQty);
        this.unit = new SimpleStringProperty(unit);
        this.unitValue = new SimpleDoubleProperty(unitValue);
        this.price = new SimpleDoubleProperty(price);
        this.totalPrice = new SimpleDoubleProperty(bottleQty * price);
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getBottleQty() {
        return bottleQty.get();
    }

    public IntegerProperty bottleQtyProperty() {
        return bottleQty;
    }

    public void setBottleQty(int bottleQty) {
        this.bottleQty.set(bottleQty);
    }

    public String getUnit() {
        return unit.get();
    }

    public StringProperty unitProperty() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit.set(unit);
    }

    public double getUnitValue() {
        return unitValue.get();
    }

    public DoubleProperty unitValueProperty() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue.set(unitValue);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getTotalPrice() {
        return totalPrice.get();
    }

    public DoubleProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

