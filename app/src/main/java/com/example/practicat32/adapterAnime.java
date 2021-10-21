package com.example.practicat32;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class adapterAnime extends RecyclerView.Adapter<adapterAnime.viewHolderAnime> {

    private final List<anime> animeList;

    public adapterAnime(List<anime> animeList) {
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public viewHolderAnime onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.anime_lista, parent, false);
        return new viewHolderAnime(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterAnime.viewHolderAnime holder, int position) {
        anime anime = animeList.get(position);
        Picasso.get().load(anime.getImage()).into(holder.image_anime);
        holder.text_anime.setText(anime.getTitle());
        holder.text_description.setText(anime.getDescrition());

        holder.image_start.setOnClickListener(view -> {
            if (!anime.isState()) {
                holder.image_start.setImageResource(R.drawable.ic_baseline_star_rate_24);
                anime.setState(true);
            } else if (anime.isState()) {
                holder.image_start.setImageResource(R.drawable.ic_outline_star_outline_24);
                anime.setState(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class viewHolderAnime extends RecyclerView.ViewHolder {

        ImageView image_anime, image_start;
        TextView text_anime, text_description;

        public viewHolderAnime(@NonNull View itemView) {
            super(itemView);
            image_anime = itemView.findViewById(R.id.image_anime);
            image_start = itemView.findViewById(R.id.image_start);
            text_anime = itemView.findViewById(R.id.text_anime);
            text_description = itemView.findViewById(R.id.text_description);
        }
    }
}
