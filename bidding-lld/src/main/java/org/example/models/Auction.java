package org.example.models;

import org.example.exceptions.PriceException;
import org.example.models.enums.EventType;

public class Auction {
    private String id ;
    private Product product;
    private Publisher publisher;
    private Seller seller;
    private Buyer buyer;
    private int currentPrice;
    private int minimumPrice;
    private int minimumIncrement;

    public void register(Buyer buyer){
        this.publisher.subscribe(buyer);
    }

    public void unRegister(Buyer buyer){
        this.publisher.unsubscribe(buyer);
    }


    public void bid(Buyer buyer, int price) throws PriceException {
        // Check if the price is > current price + minimumIncrement
        this.buyer = buyer;
        if (this.currentPrice == 0 && price >= minimumPrice){
            this.currentPrice = price;
        }else {
            // Assign only if the price is greater than current price + increment
            if (price >= currentPrice+minimumIncrement){
                this.currentPrice = price;
            }
            else {
                throw new PriceException("Price needs to be >= "+ this.currentPrice + " + " + this.minimumIncrement);
            }
        }
        this.publisher.notifyObservers(new Event(EventType.BID_NOTIFICATION,"New bid, Price: "+
                this.currentPrice + " buyer: "+ buyer.getName()));
    }

    public void close(){
        if (this.currentPrice >= this.minimumPrice) {
            this.publisher.notifyObservers(new Event(EventType.BID_NOTIFICATION, "New bid, Price: " +
                    this.currentPrice + " buyer: " + buyer.getName()));
        }
        else{
            this.publisher.notifyObservers(new Event(EventType.AUCTION_CLOSE, "No Buyers"));

        }
    }

    public Auction(String id, Product product, Publisher publisher, Seller seller, int minimumPrice, int minimumIncrement) {
        this.id = id;
        this.product = product;
        this.publisher = publisher;
        this.seller = seller;
        this.currentPrice = 0;
        this.minimumPrice = minimumPrice;
        this.minimumIncrement = minimumIncrement;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getMinimumIncrement() {
        return minimumIncrement;
    }

    public void setMinimumIncrement(int minimumIncrement) {
        this.minimumIncrement = minimumIncrement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
