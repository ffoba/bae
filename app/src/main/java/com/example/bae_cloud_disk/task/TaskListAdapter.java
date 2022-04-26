package com.example.bae_cloud_disk.task;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bae_cloud_disk.R;
import com.example.bae_cloud_disk.task.bean.TaskParams;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter {

    private List<TaskParams> mTaskList = new ArrayList<TaskParams>();
    private String TAG = "TaskListAdapterYZF";
    private boolean isLoadingVisible;

    TaskListAdapter(ArrayList<TaskParams> taskList){
        Log.i(TAG, "TaskListAdapter constructing....");
        mTaskList = taskList;
    }

    /**
     * 自定义ViewHolder，获取加载的布局的View
     */
    static class TaskListViewHolder extends RecyclerView.ViewHolder{
        TextView mSkuNameTxtView;
        TextView mSkuCodeTxtView;
        TextView mTaskStatusView;
        TextView mLoadingTxtView;

        public TaskListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            Log.i("TaskListAdapterYZF", "TaskListViewHolder constructing....");
            mSkuNameTxtView = itemView.findViewById(R.id.sku_name_txt);
            mSkuCodeTxtView = itemView.findViewById(R.id.sku_code_txt);
            mTaskStatusView = itemView.findViewById(R.id.task_status_txt);
            mLoadingTxtView = itemView.findViewById(R.id.loading_txt);
        }
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder....");
        if(viewType == 0){
            View taskListItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tasklist_item,parent,false);
            return new TaskListViewHolder(taskListItem);
        }else if(viewType == 1){
            View taskListSpace = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tasklist_item_space,parent,false);
            return new TaskListViewHolder(taskListSpace);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder: " + (position == mTaskList.size()));
        if(position ==  mTaskList.size()){
            if(isLoadingVisible){
                ((TaskListViewHolder) holder).mLoadingTxtView.setVisibility(View.VISIBLE);
            }else{
                ((TaskListViewHolder) holder).mLoadingTxtView.setVisibility(View.GONE);
            }
            return;
        }
        Log.i(TAG, "onBindViewHolder....");
        TaskParams item =  mTaskList.get(position);
        Log.i(TAG, item.toString());
        ((TaskListViewHolder) holder).mSkuNameTxtView.setText(item.getSkuName());
        ((TaskListViewHolder) holder).mSkuCodeTxtView.setText(item.getSkuCode());
        ((TaskListViewHolder) holder).mTaskStatusView.setText(item.getTaskStatus());
    }

    public void setLoadingVisible(boolean visible){
        isLoadingVisible = visible;
    }

    @Override
    public int getItemViewType(int position) {
        if(position ==  mTaskList.size()){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return mTaskList.size() == 0 ? 0 : mTaskList.size()+1;
    }
}
