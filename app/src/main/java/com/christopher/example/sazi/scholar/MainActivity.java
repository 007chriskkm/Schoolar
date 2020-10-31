package com.christopher.example.sazi.scholar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    LeaderboardAdapter leaderboardAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public List<learner> learners;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_item);

        leaderboardAdapter = new LeaderboardAdapter();

        getData();


    }

    private void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<learner>> call = api.getlearner();
        call.enqueue(new Callback<List<learner>>() {
            @Override
            public void onResponse(Call<List<learner>> call, Response<List<learner>> response) {
                Log.d("tag","Api is working");

                if (response.isSuccessful()){
                    List<learner> learners = response.body();
                    leaderboardAdapter.SetData(learners);
                    recyclerView.setAdapter(leaderboardAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                }


            }

            @Override
            public void onFailure(Call<List<learner>> call, Throwable tr) {

                Toast.makeText(getApplicationContext(),tr.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Tag Api error", tr.getLocalizedMessage());

            }

        });

    }


}