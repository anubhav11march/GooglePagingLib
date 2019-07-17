package com.example.paginglib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.coupons_rv);
        CouponViewModel viewModel = ViewModelProviders.of(this,
                new CouponViewModel.CouponViewModelFactory(this.getApplication())).get(CouponViewModel.class);
        final CouponAdapter couponAdapter = new CouponAdapter();
        recyclerView.setAdapter(couponAdapter);

        viewModel.couponList.observe(this, pagedList -> {couponAdapter.submitList(pagedList);});

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
