package com.example.allensapp;

import com.parse.Parse;

import android.app.Application;


public class App extends Application {
	
	private final String APPLICATION_ID = "g5PJFvpFiwYDAThrn0cE54sObvxxDVEUzFhPag3B";
	private final String CLIENT_KEY = "JN7yGBgwQWYn3QeyrtawSbwWTm5sFDa84uLwxAuC";
	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
	}

}
