package com.example.baseprojectandroid.src.dialog.fragment_dialog_add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.models.spinner_model.SpinnerModel;
import com.example.baseprojectandroid.src.viewmodel.revenue_viewmodel.RevenueViewmodel;

import java.util.List;

public class FragmentDialogAddRevenue extends DialogFragment {
    private View mView;
    private Spinner mSpinner;

    //variable
    private RevenueViewmodel mRevenueViewmodel;
    private SpinnerAdapter mSpinnerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_dialog_add_revenue,container,false);
        initViewModel();
        initView();
        init();
        listenerOnclicked();
        return mView;
    }

    private void listenerOnclicked() {
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerModel spinnerModel = (SpinnerModel) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), spinnerModel.getmContent(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void init() {
        //khởi tạo adapter spinner
        mSpinnerAdapter = new com.example.baseprojectandroid.src.adapter.spinner_adapter.SpinnerAdapter(getContext(),mRevenueViewmodel.getListSpinner().getValue());
        mSpinner.setAdapter(mSpinnerAdapter);
    }

    //ánh xạ view
    private void initView() {
        mSpinner = mView.findViewById(R.id.spinner_dialog);
    }

    //khởi tạo viewmodel
    private void initViewModel() {
        mRevenueViewmodel = ViewModelProviders.of(getActivity()).get(RevenueViewmodel.class);
        mRevenueViewmodel.initListSpinner();

        //lắng nghe sự thay đổi của dữ liêu
        mRevenueViewmodel.getListSpinner().observe(getViewLifecycleOwner(), new Observer<List<SpinnerModel>>() {
            @Override
            public void onChanged(List<SpinnerModel> spinnerModels) {

            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.colorPickerStyle);
    }

    @Override
    public void onResume() {
        Window window = getDialog().getWindow();
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        super.onResume();
    }
}
