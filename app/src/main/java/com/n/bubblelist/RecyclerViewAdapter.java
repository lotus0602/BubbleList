package com.n.bubblelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by N on 2015-10-12.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<RecyclerItem> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public ImageButton imageBtn;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.item_image);
            imageBtn = (ImageButton) itemView.findViewById(R.id.item_like);
            textView = (TextView) itemView.findViewById(R.id.item_count);
        }
    }

    public RecyclerViewAdapter(ArrayList list) {
        items = list;
        sortList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new RecyclerViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(items.get(position) != null){
            holder.imageView.setImageResource(items.get(position).getResource_ID());
            ViewGroup.LayoutParams params = holder.imageView.getLayoutParams();
            switch (position){
                case 0:
                    params.width = 140;
                    params.height = 140;
                    holder.imageView.setLayoutParams(params);
                    break;
                case 1:
                    params.width = 120;
                    params.height = 120;
                    holder.imageView.setLayoutParams(params);
                    break;
                case 2:
                    params.width = 100;
                    params.height = 100;
                    holder.imageView.setLayoutParams(params);
                    break;
                case 3:
                    params.width = 80;
                    params.height = 80;
                    holder.imageView.setLayoutParams(params);
                    break;
                case 4:
                    params.width = 60;
                    params.height = 60;
                    holder.imageView.setLayoutParams(params);
                    break;
            }
            holder.textView.setText(items.get(position).getCount() + "");
            holder.imageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    items.get(position).upCount();
                    sortList();
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void sortList(){
        Collections.sort(items, new Comparator<RecyclerItem>() {
            @Override
            public int compare(RecyclerItem lhs, RecyclerItem rhs) {
                if (lhs.getCount() > rhs.getCount()) { return -1; }
                else if (lhs.getCount() < rhs.getCount()) { return 1; }

                return 0;
            }
        });
    }

}
