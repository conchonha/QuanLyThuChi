package com.example.baseprojectandroid.src.fragment.fragment_statistical;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.compoments.OnItemSelectedListenner;
import com.example.baseprojectandroid.compoments.OntabSelected;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel.RevenueExpenditureViewmodel;
import com.example.baseprojectandroid.utils.Constain;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Map;

public class FragmentStatistical extends Fragment{
    private View mView;
    private TextView mTxtTotalRevenue,mTxtTotalExpendises,mTxtTotalSymmetrical;
    private TabLayout mTabLayout;
    private Spinner mSpinnerMounth,mSpinneryear;
    private RelativeLayout mRelativeLayoutStatistical;
    private LinearLayout mLinearLayoutMounth;
    //variable

    private RevenueExpenditureViewmodel mRevenueExpenditureViewmodel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_statistical,container,false);
        initViewModel();
        initView();
        init();
        listenerOnclicked();
        return mView;
    }

    private void init() {
        mSpinnerMounth.setAdapter(new ArrayAdapter<String>(mView.getContext(),android.R.layout.simple_spinner_item,mRevenueExpenditureViewmodel.getListMounthSpinner().getValue()));
        mSpinneryear.setAdapter(new ArrayAdapter<String>(mView.getContext(),android.R.layout.simple_spinner_item,mRevenueExpenditureViewmodel.getListYearthSpinner().getValue()));

        //set all toal
        Map<String,String> map = mRevenueExpenditureViewmodel.getTotalAllStatistical();
        setTextView(map.get(Constain.totalRevenue),map.get(Constain.totalExpenditure),map.get(Constain.totalSymmetrical));
    }

    //khởi tạo viewmodel
    private void initViewModel() {
        mRevenueExpenditureViewmodel = ViewModelProviders.of(getActivity()).get(RevenueExpenditureViewmodel.class);

        //lắng nghe và quan sát sự thay đổi dữ liệu
        mRevenueExpenditureViewmodel.getAllListRevenueExpenditure().observe(getViewLifecycleOwner(), new Observer<List<RevenueExpenditureTable>>() {
            @Override
            public void onChanged(List<RevenueExpenditureTable> list) {
                mRevenueExpenditureViewmodel.setmListAllRevenueExpenditureTable(list);
            }
        });
    }

    private void listenerOnclicked() {
        mTabLayout.addOnTabSelectedListener(new OntabSelected() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        mRelativeLayoutStatistical.setVisibility(View.GONE);
                        break;
                    case 1:
                        mRelativeLayoutStatistical.setVisibility(View.VISIBLE);
                        mLinearLayoutMounth.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mRelativeLayoutStatistical.setVisibility(View.VISIBLE);
                        mLinearLayoutMounth.setVisibility(View.GONE);
                        break;
                }
            }
        });

        mSpinnerMounth.setOnItemSelectedListener(new OnItemSelectedListenner() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                super.onItemSelected(parent, view, position, id);
                mRevenueExpenditureViewmodel.setmMounth(mRevenueExpenditureViewmodel.getListMounthSpinner().getValue().get(position));
                Map<String,String>map1 = mRevenueExpenditureViewmodel.getTotalMounthYearStatistical();
                setTextView(map1.get(Constain.totalRevenue),map1.get(Constain.totalExpenditure),map1.get(Constain.totalSymmetrical));
            }
        });

        mSpinneryear.setOnItemSelectedListener(new OnItemSelectedListenner() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                super.onItemSelected(parent, view, position, id);
                mRevenueExpenditureViewmodel.setmYear(mRevenueExpenditureViewmodel.getListYearthSpinner().getValue().get(position));
                Map<String,String>map2 = mRevenueExpenditureViewmodel.getTotalYearStatistical();
                setTextView(map2.get(Constain.totalRevenue),map2.get(Constain.totalExpenditure),map2.get(Constain.totalSymmetrical));
            }
        });
    }

    //ánh xạ view
    private void initView() {
        mTxtTotalRevenue = mView.findViewById(R.id.txt_total_revenue);
        mTxtTotalExpendises = mView.findViewById(R.id.txt_total_expenses);
        mTxtTotalSymmetrical = mView.findViewById(R.id.txt_symmetrical);
        mTabLayout = mView.findViewById(R.id.tab_layout);
        mSpinnerMounth = mView.findViewById(R.id.spinner_mounth);
        mSpinneryear = mView.findViewById(R.id.spinner_year);
        mRelativeLayoutStatistical = mView.findViewById(R.id.relative_statistical);
        mLinearLayoutMounth = mView.findViewById(R.id.linear_mounth);
    }

    private void setTextView(String totalRevenue,String totalExpenditure,String totalSymmetrical){
        mTxtTotalRevenue.setText(totalRevenue);
        mTxtTotalExpendises.setText(totalExpenditure);
        mTxtTotalSymmetrical.setText(totalSymmetrical);
    }
}
