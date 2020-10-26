package com.vymo.vymoassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.VisitorViewHolder> {

private Context mCtx;
private List<singleRow> VisitorList;

public ListViewAdapter(Context mCtx, List<singleRow> artistList) {
        this.mCtx = mCtx;
        this.VisitorList = artistList;
        }
@NonNull
@Override
public VisitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.singlecardlayout, parent, false);

        return new VisitorViewHolder(view);
        }



@Override
public void onBindViewHolder(@NonNull VisitorViewHolder holder, int position) {
        singleRow visitor = VisitorList.get(position);
        holder.title.setText(visitor.getPull_title());
        holder.pr_number.setText(visitor.getPr_number());
        holder.url.setText(visitor.getPatch_url());
        holder.status.setText(visitor.getStatus());
        }

@Override
public int getItemCount() {
        return VisitorList.size();
        }

class VisitorViewHolder extends RecyclerView.ViewHolder {

    TextView title, pr_number,
    status, url;

    public  VisitorViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        status = itemView.findViewById(R.id.state);
        url = itemView.findViewById(R.id.url);
        pr_number = itemView.findViewById(R.id.number);
    }


}
}
