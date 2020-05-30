package com.fci_zu_eng_gemy_95.facebooktest.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fci_zu_eng_gemy_95.facebooktest.data.PostsClient;
import com.fci_zu_eng_gemy_95.facebooktest.model.PostModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostModelView extends ViewModel {
     MutableLiveData<ArrayList<PostModel>> mutableLiveData = new MutableLiveData<>();

    public void getPosts(){
        PostsClient.getINSTANCE().getPosts().enqueue(new Callback<ArrayList<PostModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PostModel>> call, Response<ArrayList<PostModel>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PostModel>> call, Throwable t) {

            }
        });
    }
}
