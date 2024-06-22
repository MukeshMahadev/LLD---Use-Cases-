package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends User{
    // extends abstract user and declare the list of auctions the user is part of
    private List<Auction> auctionList;

    public List<Event> getNotificationList() {
        return notificationList;
    }

    public void addToNotificationList(Event notification) {
        this.notificationList.add(notification);
    }

    private List<Event> notificationList;

    public List<Auction> getAuctionList() {
        return auctionList;
    }

    public void addToAuctionList(Auction auction) {
        this.auctionList.add(auction);
    }

    public Buyer() {
        this.auctionList = new ArrayList<>();
    }
}
