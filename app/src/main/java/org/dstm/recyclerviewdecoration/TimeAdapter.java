package org.dstm.recyclerviewdecoration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Create by AndroidStudio
 * Author: pd
 * Time: 2019/8/9 14:46
 */
public class TimeAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<String> itemList;

    public TimeAdapter(Context context, List<String> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setText(R.id.tv,itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
