package com.example.baseprojectandroid.src.adapter.revenue_expenditure_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.models.callback.CallbackToRevenueExpenditure;
import com.example.baseprojectandroid.src.dialog.FragmentDialogRevenueExpenditure;
import com.example.baseprojectandroid.utils.Constain;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RevenueExpenditureAdapter extends RecyclerView.Adapter<RevenueExpenditureAdapter.EvenueExpenditureViewhodler> {
    private List<RevenueExpenditureTable> mListRevenueExpenditureTable = new ArrayList<>();
    private View mView;
    private FragmentDialogRevenueExpenditure mFragmentDialogRevenueExpenditure;
    private FragmentManager mFragmentManager;

    public RevenueExpenditureAdapter(FragmentManager fragmentManager){
        this.mFragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public EvenueExpenditureViewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mView = View.inflate(parent.getContext(), R.layout.layout_item_evenue_expenditure, null);
        return new EvenueExpenditureViewhodler(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull EvenueExpenditureViewhodler holder, int position) {
        final RevenueExpenditureTable revenueExpenditureTable = mListRevenueExpenditureTable.get(position);
        Picasso.with(mView.getContext()).load(revenueExpenditureTable.getmImage()).into(holder.mImgAvatar);
        holder.mTxtTitle.setText(revenueExpenditureTable.getmTitle());
        holder.mTxtContent.setText(revenueExpenditureTable.getmContent());
        holder.mTxtTime.setText(revenueExpenditureTable.getmCreateTime());
        holder.mTxtPrice.setText(revenueExpenditureTable.getmPrice() + "");
        holder.mImgPend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentDialogRevenueExpenditure =new FragmentDialogRevenueExpenditure();
                mFragmentDialogRevenueExpenditure.setCancelable(false);
                CallbackToRevenueExpenditure callback = mFragmentDialogRevenueExpenditure;
                callback.getRevenueExpenditureObject(revenueExpenditureTable);
                mFragmentDialogRevenueExpenditure.show(mFragmentManager, Constain.fragmentDialogRevenueExpenditure);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListRevenueExpenditureTable.size();
    }

    public void setListEvenueExpenditure(List<RevenueExpenditureTable> list) {
        this.mListRevenueExpenditureTable = list;
    }

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
