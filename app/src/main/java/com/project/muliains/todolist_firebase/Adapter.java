package com.project.muliains.todolist_firebase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;
    List<Todo> todolist;

    public Adapter(Context context, List<Todo> todolist) {
        this.context = context;
        this.todolist = todolist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlist, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nama.setText(todolist.get(position).getNama());
        holder.desc.setText(todolist.get(position).getDesc());
//        Picasso picasso = Picasso.with(context);
//        picasso.setIndicatorsEnabled(true);
//        picasso.load("http://image.tmdb.org/t/p/w500/"+img.get(position).getBackdropPath()) //Load the image
//                    .placeholder(R.drawable.ic_placeholder) //Image resource that act as placeholder
//                    .error(R.drawable.ic_error) //Image resource for error
//                    .resize(300, 500)  // Post processing - Resizing the image
//                .into(holder.image); // View where image is loaded.
    }

    @Override
    public int getItemCount() {
        return todolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nama,desc;
        public ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tvnama);
            desc = itemView.findViewById(R.id.tvdesc);
            img = itemView.findViewById(R.id.iv);
        }
    }
}
