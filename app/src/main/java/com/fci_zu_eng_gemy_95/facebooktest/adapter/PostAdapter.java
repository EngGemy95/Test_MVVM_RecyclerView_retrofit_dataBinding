package com.fci_zu_eng_gemy_95.facebooktest.adapter;

;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fci_zu_eng_gemy_95.facebooktest.R;
import com.fci_zu_eng_gemy_95.facebooktest.databinding.PostItemBinding;
import com.fci_zu_eng_gemy_95.facebooktest.model.PostModel;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private ArrayList<PostModel> postList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.post_item, parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.postItemBinding.titleTV.setText("Title: "+postList.get(position).getTitle());
        holder.postItemBinding.userIdTV.setText("UserId: "+postList.get(position).getUserId());
        holder.postItemBinding.bodyTV.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setPostList(ArrayList<PostModel> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        PostItemBinding postItemBinding ;

        public PostViewHolder(@NonNull PostItemBinding itemView) {
            super(itemView.getRoot());
            postItemBinding = itemView;
        }
    }
}
