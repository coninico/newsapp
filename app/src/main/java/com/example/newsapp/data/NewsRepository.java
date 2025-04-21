package com.example.newsapp.data;

import androidx.lifecycle.MutableLiveData;

import com.example.newsapp.network.NewsApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private NewsApiService apiService;

    public NewsRepository() {
        apiService = RetrofitInstance.getApiService();
    }

    public void getTopHeadlines(String category, MutableLiveData<List<Article>> newsArticles) {
        retrofit2.Call<NewsResponse> call = apiService.getTopHeadlines("us", category, "YOUR_API_KEY"); // Replace with your API key
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(retrofit2.Call<NewsResponse> call, Response<NewsResponse> response) {
                // ...
            }

            @Override
            public void onFailure(retrofit2.Call<NewsResponse> call, Throwable t) {
                // ...
            }
        });
    }
}