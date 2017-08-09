package com.dev.kodok.tonjoo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.dev.kodok.tonjoo.R;
import com.dev.kodok.tonjoo.controller.Controller;
import com.dev.kodok.tonjoo.model.adapter.KontakAdapter;
import com.dev.kodok.tonjoo.model.pojo.Kontak;

import java.util.ArrayList;
import java.util.List;

public class KontakActivity extends AppCompatActivity implements Controller.KontakCallbackListener{
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9";

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<Kontak> kontaks = new ArrayList<>();
    private KontakAdapter kontakAdapter;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);
        controller = new Controller(KontakActivity.this);
        configViews();
        controller.startFetching();

    }

    private void configViews() {
        recyclerView = (RecyclerView) this.findViewById(R.id.rvKontak);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(KontakActivity.this));
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setSelected(true);

        kontakAdapter = new KontakAdapter(kontaks, getApplication());
        recyclerView.setAdapter(kontakAdapter);
    }

    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Kontak kontak) {
        kontakAdapter.addKontak(kontak);
    }

    @Override
    public void onFetchProgress(List<Kontak> kontaks) {

    }

    @Override
    public void onFetchComplete() {

    }

    @Override
    public void onFetchFailed() {

    }
}
