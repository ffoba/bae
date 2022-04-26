package com.example.bae_cloud_disk.nettest;

import com.example.bae_cloud_disk.task.bean.TaskParams;

import java.util.ArrayList;

public interface ITaskListData{
    void onGetTaskListSuccess(ArrayList<TaskParams> params);
}