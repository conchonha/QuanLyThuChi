package com.example.baseprojectandroid.src.adapter.revenue_expenditure_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RevenueExpenditureAdapter extends RecyclerView.Adapter<RevenueExpenditureAdapter.EvenueExpenditureViewhodler> {
    private List<RevenueExpenditureTable> mListRevenueExpenditureTable;
    private Context mContext;

    public RevenueExpenditureAdapter(List<RevenueExpenditureTable>list,Context context){
        this.mListRevenueExpenditureTable = list;
        this.mContext = context;
    }


    //private View mView;

    @NonNull
    @Override
    public EvenueExpenditureViewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext,R.layout.layout_item_evenue_expenditure,null);
        return new EvenueExpenditureViewhodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EvenueExpenditureViewhodler holder, int position) {
        RevenueExpenditureTable revenueExpenditureTable = mListRevenueExpenditureTable.get(position);
        Picasso.with(mContext).load(revenueExpenditureTable.getmImage()).into(holder.mImgAvatar);
        holder.mTxtTitle.setText(revenueExpenditureTable.getmTitle());
        holder.mTxtContent.setText(revenueExpenditureTable.getmContent());
        holder.mTxtTime.setText(revenueExpenditureTable.getmCreateTime());
        holder.mTxtPrice.setText(revenueExpenditureTable.getmPrice() + "");
    }

    @Override
    public int getItemCount() {
        return mListRevenueExpenditureTable.size();
    }

//    public void setListEvenueExpenditure(List<RevenueExpenditureTable> list) {
//        this.mListRevenueExpenditureTable = list;
//        notifyDataSetChanged();
//    }

    public class EvenueExpenditureViewhodler extends RecyclerView.ViewHolder {
        private ImageView mImgPend, mImgAvatar;
        private TextView mTxtTitle, mTxtContent, mTxtTime, mTxtPrice;

        public EvenueExpenditureViewhodler(@NonNull View itemView) {
            super(itemView);
            mImgPend = itemView.findViewById(R.id.img_pend);
            mTxtTitle = itemView.findViewById(R.id.txt_title);
            mTxtContent = itemView.findViewById(R.id.txt_content);
            mTxtTime = itemView.findViewById(R.id.txt_time);
            mTxtPrice = itemView.findViewById(R.id.txt_price);
            mImgAvatar = itemView.findViewById(R.id.img_avartar);
        }
    }
}
