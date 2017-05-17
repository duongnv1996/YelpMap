package com.duongkk.yelpmap.adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duongkk.yelpmap.R;
import com.duongkk.yelpmap.models.Review;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by DuongKK on 5/17/2017.
 */

public class AdapterReview extends RecyclerView.Adapter<AdapterReview.ViewHolder> {
        List<Review> listReview;
        Context context;

    public AdapterReview(List<Review> listReview, Context context) {
        this.listReview = listReview;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            if(holder!=null){
                Review item = listReview.get(position);
                Picasso.with(context).load(item.getUser().getImage_url()).into(holder.imgAvt);
                holder.tvName.setText(item.getUser().getName());
                holder.tvContent.setText(item.getText());
                holder.ratingBar.setRating(item.getRating());
                holder.tvTime.setText(item.getTime_created());
            }
    }

    @Override
    public int getItemCount() {
        return listReview.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgAvt;
        TextView tvName;
        TextView tvTime;
        TextView tvContent;
        AppCompatRatingBar ratingBar;
        public ViewHolder(View itemView) {
            super(itemView);
            imgAvt = (CircleImageView) itemView.findViewById(R.id.img_avt);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            ratingBar = (AppCompatRatingBar)itemView.findViewById(R.id.rate_review);
        }
    }
}
