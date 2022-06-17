package com.mirzahansuslu.moviebook.Listeners;

import Models.DetailApi;

public interface OnDetailsListener {
    void onResponse(DetailApi response);
    void onError(String message);
}
