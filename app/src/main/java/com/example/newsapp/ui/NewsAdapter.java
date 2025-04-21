package com.example.newsapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.data.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {

    private List<Article> articles;

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged(); // Notify the RecyclerView that the data has changed
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.titleTextView.setText(article.getTitle());
        holder.sourceTextView.setText(article.getSource().getName());
        Glide.with(holder.itemView.getContext())
                .load(article.getUrlToImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView sourceTextView;
        ImageView imageView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.articleTitle);
            sourceTextView = itemView.findViewById(R.id.articleSource);
            imageView = itemView.findViewById(R.id.articleImage);
        }
    }
}