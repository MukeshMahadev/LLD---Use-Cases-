package org.example.models;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Seller extends User{
    // Auction that the seller has participated in
    private List<Auction> auctionList;

    public Seller() {
        this.auctionList = new ArrayList<>();
    }

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void addToAuctionList(Auction auction) {
        this.auctionList.add(auction);
    }
}
