package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List <RecyclerViewData> userList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerview=findViewById(R.id.recyvler_view);

        //createMockList();
        apiCall();
        setUpRecyclerView();
    }

    /*
    private void createMockList()
    {
    RecyclerViewData data;
    data = new RecyclerViewData("https://bit.ly/2NT7svr","Srajan","7607115158");
    mockDataList.add(data);

    data = new RecyclerViewData("https://bit.ly/2NT7svr","Hello","7607115158");
    mockDataList.add(data);

    data = new RecyclerViewData("https://bit.ly/2NT7svr","Welcome","7607115158");
    mockDataList.add(data);

    data = new RecyclerViewData("https://bit.ly/2NT7svr","To","7607115158");
    mockDataList.add(data);

    data = new RecyclerViewData("https://bit.ly/2NT7svr","new_world","7607115158");
    mockDataList.add(data);
    }
    */

    private void setUpRecyclerView()
    {
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(recyclerViewAdapter);
        Log.i("Api call data reached", String.valueOf(userList));
        Log.i("Api call data reached", String.valueOf(userList));
        recyclerViewAdapter.setRecyclerViewDataList(userList);
        recyclerViewAdapter.notifyDataSetChanged();
    }


    private void apiCall()
    {
        ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
        Call<UserWrapper> call= apiServices.getUserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if(response.isSuccessful())
                {
                    if(response.body() != null)
                        userList.addAll(response.body().getRecyclerViewData());
                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });

    }
}