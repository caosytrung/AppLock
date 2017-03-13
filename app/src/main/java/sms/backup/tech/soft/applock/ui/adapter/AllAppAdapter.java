package sms.backup.tech.soft.applock.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder;
import sms.backup.tech.soft.applock.R;
import sms.backup.tech.soft.applock.model.AppRunning;

/**
 * Created by dee on 11/03/2017.
 */

public class AllAppAdapter extends RecyclerView.Adapter<AllAppAdapter.AllAppHolder>   {
    private List<AppRunning> appRunnings;
    private Context mContext;


    public AllAppAdapter(Context context,List<AppRunning> appRunnings){
        mContext = context;
        this.appRunnings = appRunnings;
    }

    public void setAppRunnings(List<AppRunning> appRunnings) {
        this.appRunnings = appRunnings;
    }

    @Override
    public AllAppAdapter.AllAppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AllAppHolder(LayoutInflater.from(mContext).inflate(R.layout.item_all_app,parent,false));
    }

    @Override
    public void onBindViewHolder(AllAppAdapter.AllAppHolder holder, int position) {
        AppRunning appRunning = appRunnings.get(position);
        //holder.ivIcon.setImageDrawable(appRunning.getIco());
        holder.tvName.setText(appRunning.getName());
        holder.ivIcon.setImageDrawable(appRunning.getIco());

    }

    public void remove(int pos){
        appRunnings.remove(pos);
        notifyItemRemoved(pos);
    }
    public void clear() {
        int size = this.appRunnings.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.appRunnings.remove(0);
            }

            for (int i = 0; i < size; i++) {
                this.notifyItemRemoved(0);
            }



        }
    }


    @Override
    public int getItemCount() {

        Log.d("getItemCount" , " " + appRunnings.size());
        return appRunnings.size();
    }

    public class AllAppHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private ImageView ivIcon;
        public AllAppHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvItemName);
            ivIcon = (ImageView) itemView.findViewById(R.id.ivItemIcon);
        }
    }
}
