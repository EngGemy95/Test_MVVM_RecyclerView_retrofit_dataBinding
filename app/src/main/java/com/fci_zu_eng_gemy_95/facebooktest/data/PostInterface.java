package com.fci_zu_eng_gemy_95.facebooktest.data;

import com.fci_zu_eng_gemy_95.facebooktest.model.PostModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Call<ArrayList<PostModel>> getPosts();
}
