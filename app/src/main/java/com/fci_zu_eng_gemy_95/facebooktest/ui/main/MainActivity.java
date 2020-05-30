package com.fci_zu_eng_gemy_95.facebooktest.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.fci_zu_eng_gemy_95.facebooktest.R;
import com.fci_zu_eng_gemy_95.facebooktest.adapter.PostAdapter;
import com.fci_zu_eng_gemy_95.facebooktest.databinding.ActivityMainBinding;
import com.fci_zu_eng_gemy_95.facebooktest.model.PostModel;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PostModelView postModelView ;
    ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        postModelView = new ViewModelProvider(this).get(PostModelView.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);

        postModelView.getPosts();
        final PostAdapter adapter = new PostAdapter();
        binding.recyclerView.setAdapter(adapter);

        postModelView.mutableLiveData.observe(this, new Observer<ArrayList<PostModel>>() {
            @Override
            public void onChanged(ArrayList<PostModel> posts) {
                adapter.setPostList(posts);
            }
        });

    }
}
