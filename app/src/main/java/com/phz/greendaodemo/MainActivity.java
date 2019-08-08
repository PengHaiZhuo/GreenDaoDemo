package com.phz.greendaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.phz.greendaodemo.database.greenDao.SimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_bt_simple)
    Button main_bt_simple;
    @BindView(R.id.main_bt_relation)
    Button main_bt_relation;

    private Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder= ButterKnife.bind(this);
    }

    @OnClick({R.id.main_bt_simple,R.id.main_bt_relation})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.main_bt_simple:
                startActivity(new Intent(MainActivity.this, SimpleActivity.class));
                break;
            case R.id.main_bt_relation:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
