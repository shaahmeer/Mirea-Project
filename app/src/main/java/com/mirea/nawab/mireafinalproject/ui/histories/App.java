package com.mirea.nawab.mireafinalproject.ui.histories;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static com.mirea.nawab.mireafinalproject.ui.histories.App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static com.mirea.nawab.mireafinalproject.ui.histories.App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
