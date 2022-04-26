package com.example.bae_cloud_disk.nettest;

import com.example.bae_cloud_disk.task.bean.TaskParams;

import java.util.ArrayList;

public class NetTest {
    /**
     * 模拟拉取任务数据列表
     */
    static public void getTaskListFromServerTest(ITaskListData taskListData){
        new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ArrayList<TaskParams> list = new ArrayList<>();
                    list.add(new TaskParams("大白菜","423354543,655345t56","待播种"));
                    list.add(new TaskParams("大白菜","423354543,655345t56","待播种"));
                    list.add(new TaskParams("大白菜","423354543,655345t56","待播种"));

                    taskListData.onGetTaskListSuccess(list);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
