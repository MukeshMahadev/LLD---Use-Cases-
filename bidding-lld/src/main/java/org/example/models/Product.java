package org.example.models;

public class Product {
    // Declare constructors
    private String product_id;
    private String name;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Product(String product_id, String name) {
        this.product_id = product_id;
        this.name = name;
    }
}
