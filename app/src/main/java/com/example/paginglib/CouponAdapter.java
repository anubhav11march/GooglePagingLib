package com.example.paginglib;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class CouponAdapter extends PagedListAdapter<Coupon, CouponAdapter.CouponViewHolder> {

    protected CouponAdapter(){
        super(DIFF_CALLBACK);
    }

    public static DiffUtil.ItemCallback<Coupon> DIFF_CALLBACK= new DiffUtil.ItemCallback<Coupon>() {
        @Override
        public boolean areItemsTheSame(@NonNull Coupon oldItem, @NonNull Coupon newItem) {
            return oldItem.get_id()== newItem.get_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Coupon oldItem, @NonNull Coupon newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public CouponViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view = li.inflate(R.layout.coupon_item, parent, false);
        return new CouponViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CouponViewHolder holder, int position) {
        Coupon coupon = getItem(position);
        if(coupon!= null){
            holder.bindTo(coupon);
        }
    }

    public class CouponViewHolder extends RecyclerView.ViewHolder {
        public TextView storeName,couponTv;

        public CouponViewHolder(View view){
            super(view);
            storeName = view.findViewById(R.id.coupon_store);
            couponTv = view.findViewById(R.id.coupon_tv);
        }

        public void bindTo(Coupon coupon){
            storeName.setText(coupon.getStore());
            couponTv.setText(coupon.getOffer());
        }
    }
}
