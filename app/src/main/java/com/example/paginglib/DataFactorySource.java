package com.example.paginglib;

import android.content.Context;

import androidx.paging.DataSource;

public class DataFactorySource extends DataSource.Factory<Integer, Coupon> {

    private Context ctx;
    private CouponsDAtaSource couponsDAtaSource;

    public DataFactorySource (Context ctx){
        this.ctx = ctx;
    }

    @Override
    public DataSource<Integer, Coupon> create() {
        if(couponsDAtaSource == null){
            couponsDAtaSource = new CouponsDAtaSource(ctx);
        }
        return couponsDAtaSource;
    }


}
