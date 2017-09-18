package com.albert.flickrrecents.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.albert.flickrrecents.R;
import com.albert.flickrrecents.models.FlickrImageModel;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * Created by albert on 9/17/17.
 *
 * public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

 public static class PersonViewHolder extends RecyclerView.ViewHolder {
 CardView cv;
 TextView personName;
 TextView personAge;
 ImageView personPhoto;

 PersonViewHolder(View itemView) {
 super(itemView);
 cv = (CardView)itemView.findViewById(R.id.cv);
 personName = (TextView)itemView.findViewById(R.id.person_name);
 personAge = (TextView)itemView.findViewById(R.id.person_age);
 personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
 }
 }

 }
 */

public class FlickrImageAdapter extends RecyclerView.Adapter<FlickrImageAdapter.PersonViewHolder>{
    private List<FlickrImageModel> images;
    private ImageLoader imageLoader;

    public FlickrImageAdapter(List<FlickrImageModel> images) {
        this.images = images;
        imageLoader= AppController.getInstance().getImageLoader();

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {

        personViewHolder.fl_imageView.setImageUrl(images.get(i).getId(),imageLoader);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        NetworkImageView fl_imageView;

        PersonViewHolder(View itemView) {
            super(itemView);

            fl_imageView = (NetworkImageView)itemView.findViewById(R.id.fl_imageView);
        }
    }

   /* private List<FlickrImageModel> images;
    private ImageLoader imageLoader;

    public FlickrImageAdapter(List<FlickrImageModel> catList) {
        this.images = catList;

    }


    @Override
    public int getItemCount() {
        return images.size();
    }


    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        FlickrImageModel image = images.get(position);


                holder.fl_imageView.setImageUrl("", imageLoader);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder imageViewHolder, int position) {

        FlickrImageModel image = images.get(position);



        imageViewHolder.fl_imageView.setImageUrl("", imageLoader);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public NetworkImageView fl_imageView;


        public ViewHolder(View itemView) {

            super(itemView);

            fl_imageView = (NetworkImageView) itemView.findViewById(R.id.image);

        }

    }


    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.image_item, viewGroup, false);
        return new NewsViewHolder(itemView);
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        protected NetworkImageView fl_imageView;



        public NewsViewHolder(View v) {
            super(v);

            fl_imageView = (NetworkImageView) v.findViewById(R.id.fl_imageView);

        }


    }*/
}
