package com.example.attack.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.attack.R;
import java.util.List;

/**
 * Created by jb on 2018/2/6.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {

    private final Context context;
    private List<String> list;
    public OnItemClickListener onItemClickListener;

    @SuppressLint("CheckResult")
    public ResultAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    //设置回调监听
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void updata(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //        //实例化展示的view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        //实例化viewHolder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tv_time.setText("===第" + (position + 1) + "次注册结果===");
        holder.tv_result.setText(list.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder.itemView, position);
                }
            }
        });

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_result, tv_time;

        public ViewHolder(View view) {
            super(view);
            tv_result = view.findViewById(R.id.tv_result);
            tv_time = view.findViewById(R.id.tv_time);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, int position);

    }
}
