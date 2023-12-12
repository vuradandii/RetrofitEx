package com.example.retrofitex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.Telephony;

import com.example.retrofitex.adapter.ExampleAdapter;
import com.example.retrofitex.model.ExampleModel;
import com.example.retrofitex.model.Rating;
import com.example.retrofitex.service.GetExampleDataService;
import com.example.retrofitex.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<ExampleModel> products;
    RecyclerView recyclerView;
    private ExampleAdapter exampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetProducts();
    }
    public Object GetProducts() {
        GetExampleDataService getExampleDataService = RetrofitInstance.getService();
        Call<ExampleModel> call = getExampleDataService.getRating();
        call.enqueue(new Callback<ExampleModel>() {
            @Override
            public void onResponse(Call<ExampleModel> call, Response<ExampleModel> response) {
                ExampleModel rating = response.body();

                if(rating!= null && rating.getCategory()!= null){

                    products = (ArrayList<ExampleModel>) rating.getCategory();

                    ViewData();

                }
            }

            @Override
            public void onFailure(Call<ExampleModel> call, Throwable t) {

            }
        });
        return products;
    }
    private void ViewData(){
        recyclerView = findViewById(R.id.recyclerview);
        exampleAdapter = new ExampleAdapter(products);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exampleAdapter);

    }

}