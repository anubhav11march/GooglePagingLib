package com.example.paginglib;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Coupon.class}, version = 1)
public abstract class CouponsDB extends RoomDatabase {
    public abstract CouponLocalDAO couponLocalDAO();
}
