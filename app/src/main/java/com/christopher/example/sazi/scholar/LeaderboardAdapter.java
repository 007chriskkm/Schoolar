package com.christopher.example.sazi.scholar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {

    //Declare a List and a context
    List<learner> learners;
    private Context mcontext;

    //you can create a different method this the one below but i prefer user to use this one
    public void SetData(List<learner> learners) {
        this.learners = learners;
        notifyDataSetChanged();

    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext = parent.getContext();
        //declare a view and create an inflate with custom view layout
        View view = LayoutInflater.from(mcontext).inflate(R.layout.custom_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final learner user_learner = learners.get(position);

        holder.name.setText(user_learner.getName());
        holder.country. setText(user_learner.getCountry());

        //i used picasso library to get the image from the url
        Picasso.get().load(user_learner.getBadgeUrl()).into(holder.badgeUrl);
    }




    @Override
    public int getItemCount() {
        return learners.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView country;
        public ImageView badgeUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.tv_name);
            country = itemView.findViewById(R.id.tv_country);
            badgeUrl = itemView.findViewById(R.id.imageUrl);
        }

    }
}
