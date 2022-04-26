package com.example.bae_cloud_disk.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.bae_cloud_disk.R;
import com.example.bae_cloud_disk.base.BaseActivity;
import com.example.bae_cloud_disk.nettest.ITaskListData;
import com.example.bae_cloud_disk.nettest.NetTest;
import com.example.bae_cloud_disk.task.bean.TaskParams;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TaskListActivity extends BaseActivity {
    private RecyclerView mTaskList;
    private EditText mEdtTaskTxt;
    private Handler handler;
    private ArrayList<TaskParams> list = new ArrayList<>();
    private TaskListAdapter adapter;

    private String TAG = "TaskListActivityYZF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        initView();
        initHandler();

    }

    private void initView(){
        setToolBarTheme("任务列表");
        this.mEdtTaskTxt = findViewById(R.id.search_task_edt);
        this.mTaskList = findViewById(R.id.rcv_task_list);

        this.list.add(new TaskParams("大白菜","423354543,655345t56","待播种"));
        this.list.add(new TaskParams("大白菜","423354543,655345t56","待播种"));
        this.list.add(new TaskParams("大白菜","423354543,655345t56","待播种"));
        Log.i(TAG, list.toString());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.mTaskList.setLayoutManager(layoutManager);
        this.adapter = new TaskListAdapter(list);
        this.mTaskList.setAdapter(adapter);
        this.mTaskList.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    if(list.size() >= 20){
                        return;
                    }else{
                        //如果滑动到底部
                        //loading
                        adapter.setLoadingVisible(true);
                        //模拟网络请求
                        NetTest.getTaskListFromServerTest((ArrayList<TaskParams> data)->{
                            Message msg = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("list",data);
                            msg.setData(bundle);
                            handler.sendMessage(msg);
                        });
                    }
                }
            }
        });


    }

    private void initHandler(){
        this.handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                adapter.setLoadingVisible(false);
                list.addAll((ArrayList<TaskParams>)msg.getData().get("list"));
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}