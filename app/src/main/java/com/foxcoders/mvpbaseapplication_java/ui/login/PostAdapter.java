package com.foxcoders.mvpbaseapplication_java.ui.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.foxcoders.mvpbaseapplication_java.R;
import com.foxcoders.mvpbaseapplication_java.data.network.models.PostModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<PostModel> mPostModels = new ArrayList<>();

    @Inject
    public PostAdapter() {
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item_layout,parent,false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel temp = mPostModels.get(position);
        holder.tvTitle.setText(temp.getTitle());
        holder.tvBody.setText(temp.getPostBody());
    }

    @Override
    public int getItemCount() {
        return mPostModels.size();
    }

    public void setPostModels(List<PostModel> postModels) {
        mPostModels.clear();
        mPostModels.addAll(postModels);
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvBody;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvBody = itemView.findViewById(R.id.tv_body);
        }
    }

}
