package com.mirzahansuslu.moviebook.Listeners;

import Models.SearchApi;

public interface  OnSearchApiListener {
    void onResponse(SearchApi response);
    void onError(String message);
}
