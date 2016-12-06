package com.example.egguncle.ganhuo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.egguncle.ganhuo.R;
import com.example.egguncle.ganhuo.entries.GanHuoInfo;

import java.util.List;

/**
 * Created by egguncle on 16-12-6.
 */

public class HomeRcvAdapter extends RecyclerView.Adapter<HomeRcvAdapter.ViewHolder> {

    private GanHuoInfo mGanHuoInfo;
    private List<GanHuoInfo.ResultsBean> mResultsBeanList;
    private Context mContext;

    public HomeRcvAdapter(Context context,List<GanHuoInfo.ResultsBean> resultsBeanList) {
        this.mResultsBeanList = resultsBeanList;
        this.mContext = context;
    }

    @Override
    public HomeRcvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeRcvAdapter.ViewHolder holder, int position) {

        holder.tvDesc.setText(mResultsBeanList.get(position).getDesc());
        holder.tvPublished.setText(mResultsBeanList.get(position).getPublishedAt().substring(0, 10));
        holder.tvWho.setText(mResultsBeanList.get(position).getWho());

    }

    @Override
    public int getItemCount() {
        return mResultsBeanList == null ? 0 : mResultsBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDesc;
        private TextView tvPublished;
        private TextView tvWho;


        public ViewHolder(View itemView) {
            super(itemView);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            tvPublished = (TextView) itemView.findViewById(R.id.tv_published);
            tvWho = (TextView) itemView.findViewById(R.id.tv_who);
        }
    }
}
