package com.example.randylaptop.clase1av;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.prof.rssparser.Article;

import java.util.List;

public class FeedAdapter extends ArrayAdapter<Article> {

    public FeedAdapter(@NonNull Context context, @NonNull List<Article> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Article article = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_contenido,parent,false);
        }
        TextView textTitulo = convertView.findViewById(R.id.tv);
        TextView tImagen = convertView.findViewById(R.id.img);
        ImageView imagen = convertView.findViewById(R.id.image);
        textTitulo.setText(article.getTitle());
        tImagen.setText(article.getPubDate().toString());
        Glide.with(getContext()).load(article.getImage()).into(imagen);

        return  convertView;
    }


}
