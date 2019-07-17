package com.example.paginglib;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import java.util.List;

public class CouponsDAtaSource extends PageKeyedDataSource<Integer, Coupon> {
    private CouponLocalDAO couponLocalDAO;

    public CouponsDAtaSource (Context ctx){
        couponLocalDAO = LocalRepository.getCouponsDB(ctx).couponLocalDAO();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Coupon> callback) {
        List<Coupon> cpns = couponLocalDAO.getCouponsBySize(0, params.requestedLoadSize);
        int noOfTries = 0;
        while(cpns.size() == 0){
            cpns = couponLocalDAO.getCouponsBySize(0, params.requestedLoadSize);
            noOfTries++;
            if(noOfTries == 6)
                break;
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){

            }
        }
        callback.onResult(cpns, null, cpns.size()+1);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Coupon> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Coupon> callback) {
        List<Coupon> cpns = couponLocalDAO.getCouponsBySize(params.key, params.requestedLoadSize);
        int nextKey = params.key + cpns.size();
        callback.onResult(cpns, nextKey);
    }
}
