package com.example.practicat32;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_anime);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://nataly.free.beeceptor.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service service = retrofit.create(service.class);

        Call<List<anime>> listGetAnime = service.getAllAnimes();
        listGetAnime.enqueue(new Callback<List<anime>>() {
            @Override
            public void onResponse(Call<List<anime>> call, Response<List<anime>> response) {

                String code = String.valueOf(response.code());
                if (code.equals("200")) {
                    Toast.makeText(getApplicationContext(), "HAY LISTA", Toast.LENGTH_SHORT).show();
                    List<anime> myList = response.body();
                    adapterAnime adapterList = new adapterAnime(myList);
                    recyclerView.setAdapter(adapterList);
                } else {
                    Toast.makeText(getApplicationContext(), "NO HAY LISTA", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<anime>> call, Throwable t) {

            }
        });
    }
}