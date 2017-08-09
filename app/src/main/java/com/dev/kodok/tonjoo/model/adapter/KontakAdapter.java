package com.dev.kodok.tonjoo.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.kodok.tonjoo.R;
import com.dev.kodok.tonjoo.model.pojo.Kontak;
import com.dev.kodok.tonjoo.model.utility.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by root on 08/08/17.
 */

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.Holder>{

    private List<Kontak> kontaks;
    private Context context;

    public void addKontak(Kontak kontak){
        kontaks.add(kontak);
        notifyDataSetChanged();
    }

    public KontakAdapter(List<Kontak> kontaks, Context context) {
        this.kontaks = kontaks;
        this.context = context;
    }

    @Override
    public KontakAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kontak, parent, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(KontakAdapter.Holder holder, int position) {
        Kontak kontak = kontaks.get(position);
        holder.tvFirstName.setText(kontak.fist_name);
        holder.tvLastName.setText(kontak.last_name);
        holder.tvGender.setText(kontak.gender);
        holder.tvEmail.setText(kontak.email);

        Picasso.with(context).load(kontak.avatar)
                .fit().centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return kontaks.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView tvFirstName, tvLastName, tvGender, tvEmail;
        public ImageView ivAvatar;
        public Holder(View itemView) {
            super(itemView);
            ivAvatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
            tvFirstName = (TextView) itemView.findViewById(R.id.tvFirstName);
            tvLastName = (TextView) itemView.findViewById(R.id.tvLastName);
            tvGender = (TextView) itemView.findViewById(R.id.tvGender);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }
}
