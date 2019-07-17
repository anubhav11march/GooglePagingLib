package com.example.paginglib;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CouponLocalDAO {
    @Query("SELECT * FROM Coupon WHERE _id >= :id LIMIT :size")
    public List<Coupon> getCouponsBySize(int id, int size);

    @Insert
    public void insertCoupons(List<Coupon> coupons);
}
