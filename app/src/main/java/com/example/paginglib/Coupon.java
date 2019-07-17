package com.example.paginglib;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Coupon {

    @PrimaryKey(autoGenerate = true)
    private int _id;
    private String store;
    private String offer;

    public Coupon(){

    }

    public Coupon(String store, String coupons){
        this.offer = coupons;
        this.store = store;
    }

    public String getOffer() {
        return offer;
    }

    public String getStore() {
        return store;
    }

    public int get_id() {
        return _id;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        Coupon coupon = (Coupon) obj;
        return coupon.get_id() == this.get_id() &&
                coupon.getStore() == coupon.getStore() &&
                coupon.getOffer() == coupon.getOffer();
    }
}
