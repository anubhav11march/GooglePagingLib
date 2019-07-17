package com.example.paginglib;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class CouponViewModel extends ViewModel {
    public LiveData<PagedList<Coupon>> couponList;

    public CouponViewModel(Application application){
        DataFactorySource factory = new DataFactorySource(application);

        PagedList.Config config = (new PagedList.Config.Builder()).setEnablePlaceholders(true)
                .setInitialLoadSizeHint(20)
                .setPageSize(25)
                .build();

        couponList = new LivePagedListBuilder<>(factory, config).build();
    }

    public static class CouponViewModelFactory extends ViewModelProvider.NewInstanceFactory{
        private Application mapplication;
        public CouponViewModelFactory (Application application){
            mapplication = application;
        }
        @Override
        public <T extends ViewModel> T create(Class<T> viewModel){
            return (T) new CouponViewModel(mapplication);
        }
    }
}
