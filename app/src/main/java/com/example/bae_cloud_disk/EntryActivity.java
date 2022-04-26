package com.example.bae_cloud_disk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.bae_cloud_disk.base.BaseActivity;
import com.example.bae_cloud_disk.task.TaskListActivity;

public class EntryActivity extends BaseActivity {
    private Button mEntryBut;
    private Button mLoginBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.layout_toolbar);
        setContentView(R.layout.activity_entry);

        initView();
    }

    private void initView(){
        mEntryBut = findViewById(R.id.entry_test_but);
        mLoginBut = findViewById(R.id.entry_login_but);

        mEntryBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntryActivity.this, TaskListActivity.class);
                startActivity(intent);
            }
        });

        mLoginBut.setOnClickListener((View v)->{
            Intent intent = new Intent(getApplicationContext(), TaskListActivity.class);
            startActivity(intent);
        });

    }
}