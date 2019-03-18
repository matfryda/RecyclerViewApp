package com.example.recyclerviewapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView textViewResult;

    Button buttonApi;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageURL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");
        initImageBitMaps();

        textViewResult = findViewById(R.id.text_view_result);
        buttonApi = (Button) findViewById(R.id.buttonAPI);

        buttonApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ApiActivity.class);
                startActivity(intent);

            }
        });


    }


    private void initImageBitMaps() {
        Log.d(TAG, "initImageBitMaps: preparing bitmaps");

        mImageURL.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Model---Sun---Gasometer---Oberhausen---%28Gentry%29.jpg/1200px-Model---Sun---Gasometer---Oberhausen---%28Gentry%29.jpg");
        mNames.add("Sun");

        mImageURL.add("https://media.istockphoto.com/photos/solar-sysytem-planet-mercury-picture-id691444480?k=6&m=691444480&s=612x612&w=0&h=Tpqze-_FN7VIhbnSuik3UUPqYGa8z0ZQWgwkt0CVRuk=");
        mNames.add("Mercury");

        mImageURL.add("https://imagazine.pl/wp-content/uploads/2017/11/Wenus.jpg");
        mNames.add("Venus");

        mImageURL.add("https://1.allegroimg.com/s512/0155d5/a630003744128db41d21ebf126c1");
        mNames.add("Earth");

        mImageURL.add("https://thumbs-prod.si-cdn.com/RrBh3asauilvISDKurUkXAttsj8=/fit-in/1600x0/filters:focal(400x300:401x301)/https://public-media.si-cdn.com/filer/2e/29/2e29166d-5af4-4184-9d90-b9e2dadedd30/pia01590_hires-web.jpg");
        mNames.add("Mars");

        mImageURL.add("https://www.sciencemag.org/sites/default/files/styles/article_main_large/public/jupiter_16x9.jpg?itok=vjqdPm4f");
        mNames.add("Jupiter");

        mImageURL.add("https://upload.wikimedia.org/wikipedia/commons/c/c7/Saturn_during_Equinox.jpg");
        mNames.add("Saturn");

        mImageURL.add("https://nationalpostcom.files.wordpress.com/2017/08/neptune-cropped.jpg");
        mNames.add("Uranus");

        mImageURL.add("https://cosmos-magazine.imgix.net/file/spina/photo/5150/270616_neptunespot_1A.jpg?fit=clip&w=835");
        mNames.add("Neptune");

        mImageURL.add("https://cdn.images.dailystar.co.uk/dynamic/33/photos/92000/620x/Nibiru-645953.jpg");
        mNames.add("Nibiru");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init RecyclerView");
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        Adapter adapter = new Adapter(this, mNames, mImageURL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
