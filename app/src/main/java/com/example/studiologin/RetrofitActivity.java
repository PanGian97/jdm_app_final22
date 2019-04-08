package com.example.studiologin;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "RetrofitActivity";//for debugging

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    ApiInterface apiInterface;//instance of API interface
    public void getTodos(View view){
        Call<List<Todo>> call = apiInterface.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.d(TAG, "onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }
    public void getTodoUsingRouteParameter(View view){
        Call<Todo> todoCall = apiInterface.getTodoUsingRouteParameter(3);
        todoCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.d(TAG, "onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });
    }
    public void getTodosUsingQuery(View view){
        Call<List<Todo>> listCall = apiInterface.getTodosUsingQuery(3,false);
        listCall.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.d(TAG, "onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });

    }
    public void postTodo(View view){
        Todo todo = new Todo(3,"Get me data",false);
        Call<Todo> todoPostCall  = apiInterface.postTodo(todo);
        todoPostCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.d(TAG, "onResponse: "+ response.body());
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.d(TAG, "onFailure: "+ t.getLocalizedMessage());
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        Log.d(TAG,"onCreate: started");

        button1 = (Button) findViewById(R.id.Button1);
        button2 = (Button) findViewById(R.id.Button2);
        button3 = (Button) findViewById(R.id.Button3);
        button4 = (Button) findViewById(R.id.Button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);




        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.Button1:getTodos(v);break;
            case R.id.Button2:getTodoUsingRouteParameter(v);break;
            case R.id.Button3:getTodosUsingQuery(v);break;
            case R.id.Button4:postTodo(v);break;



        }}
}
