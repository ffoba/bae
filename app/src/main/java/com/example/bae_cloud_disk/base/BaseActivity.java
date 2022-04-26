package com.example.bae_cloud_disk.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.bae_cloud_disk.R;

public class BaseActivity extends AppCompatActivity {
    private ViewGroup content_container;
    private FrameLayout toolBar_container;
    private View mToolbar;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(R.layout.layout_base_container);

        initViewContainer();
    }

    protected void initViewContainer() {
        toolBar_container = findViewById(R.id.base_toolbar_container);
        content_container = findViewById(R.id.base_content_container);
        View mBaseToolbar = LayoutInflater.from(this).inflate(R.layout.layout_toolbar,null);
        setToolBar(mBaseToolbar);

    }

    public void setContentView(int layoutId) {
        View content = this.getLayoutInflater().inflate(layoutId, content_container, false);
        content_container.removeAllViews();
        content_container.addView(content);
    }

    protected void setToolBar(View toolBar){
        this.mToolbar = toolBar;
        toolBar_container.removeAllViews();
        toolBar_container.addView(toolBar);
    }

    protected void setToolBarRight(String mTBRightTxt){
        TextView right = findViewById(R.id.back_txt);
        right.setText(mTBRightTxt);
    }

    protected void setToolBarTheme(String mTBThemeTxt){
        TextView theme = findViewById(R.id.scheme_txt);
        theme.setText(mTBThemeTxt);
    }

    protected void clearToolbar(){
        this.mToolbar = null;
        toolBar_container.removeAllViews();
    }

}
