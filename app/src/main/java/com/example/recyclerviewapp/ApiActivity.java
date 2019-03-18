package com.example.recyclerviewapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        button = (Button) findViewById(R.id.buttonBack); //tworzymy przycisk i przypisujemy mu id. R ->resources, dzięki temu możemy się odwołać do wszystkich

        textViewResult = findViewById(R.id.text_view_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApiActivity.this, MainActivity.class);//dzięki intentowi przechodzimy do następnego activity
                startActivity(intent);
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();//wzorzec builder, tworzymy obiekt Retrofit, podajemy odnośnik URL, format Gson

        Api api = retrofit.create(Api.class);

        Call<List<EmployersAPI>> call = api.getEmployeers(); //za pomocą interface Call tworzymy listę obiektów

        call.enqueue(new Callback<List<EmployersAPI>>() {
            @Override
            public void onResponse(Call<List<EmployersAPI>> call, Response<List<EmployersAPI>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<EmployersAPI> employersAPIS = response.body();

                for (EmployersAPI employee : employersAPIS) {
                    String content = "";
                    content += "\n\n\n";
                    content += "Id: " + employee.getId() + "\n";
                    content += "Employee name: " + employee.getEmployee_name() + "\n";
                    content += "Employee age: " + employee.getEmployee_age() + "\n";
                    content += "Salary: " + employee.getSalary() + "\n";
                    content += "Profile image: " + employee.getProfile_image() + "\n";
                    content += "--------------------------------------------------------------------------" + "\n\n";

                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<EmployersAPI>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
