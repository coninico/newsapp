package com.example.newsapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.data.Article;
import com.example.newsapp.data.NewsRepository;

import java.util.List;

public class NewsViewModel extends ViewModel {
    private NewsRepository repository;
    private MutableLiveData<List<Article>> newsArticles;

    public NewsViewModel() {
        repository = new NewsRepository();
        newsArticles = new MutableLiveData<>();
    }

    public LiveData<List<Article>> getNewsArticles() {
        return newsArticles;
    }

    public void fetchNews(String category) {
        repository.getTopHeadlines(category, newsArticles);
    }
}