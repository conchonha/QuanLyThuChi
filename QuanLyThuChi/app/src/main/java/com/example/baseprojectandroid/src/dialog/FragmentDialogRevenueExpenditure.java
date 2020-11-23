package com.example.baseprojectandroid.src.dialog;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.cores.room.table.RevenueExpenditureTable;
import com.example.baseprojectandroid.models.callback.CallbackToRevenueExpenditure;
import com.example.baseprojectandroid.models.spinner_model.SpinnerModel;
import com.example.baseprojectandroid.src.viewmodel.revenue_expenditure_viewmodel.RevenueExpenditureViewmodel;
import com.example.baseprojectandroid.utils.Constain;
import com.example.baseprojectandroid.utils.Helpers;

public class FragmentDialogRevenueExpenditure extends DialogFragment implements CallbackToRevenueExpenditure {
    private View mView;
    private Spinner mSpinner;
    private ImageView mImageDate;
    private EditText mEdtDateTime, mEdtNode;
    private Button mBtnSave, mBtnCancal;
    private EditText mEdtPrice;

    //variable
    private RevenueExpenditureViewmodel mRevenueExpenditureViewmodel;
    private SpinnerAdapter mSpinnerAdapter;
    private SpinnerModel mSpinnerModel;
    private String mType;
    private Dialog mDialog;
    private RevenueExpenditureTable mRevenueExpenditureTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_dialog_add_revenue, container, false);
        initViewModel();
        initView();
        init();
        listenerOnclicked();
        return mView;
    }

    //lắng nghe sự kiện oclicked view
    private void listenerOnclicked() {
        //get item spinner
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mSpinnerModel = (SpinnerModel) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //date picker dialog
        mImageDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helpers.showDatePickerDialog(getContext(), FragmentDialogRevenueExpenditure.this);
            }
        });

        //save node
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {
                    final RevenueExpenditureTable model = new RevenueExpenditureTable(mType, mSpinnerModel.getmContent(),
                            mSpinnerModel.getmImageIcon(), Integer.parseInt(mEdtPrice.getText().toString()),
                            mEdtNode.getText().toString(), mEdtDateTime.getText().toString(), null);
                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            mDialog = Helpers.showLoadingDialog(getActivity());
                            mDialog.show();
                        }

                        @Override
                        protected Void doInBackground(Void... voids) {
                            if (mRevenueExpenditureTable != null) {
                                mRevenueExpenditureTable.setmTitle(mSpinnerModel.getmContent());
                                mRevenueExpenditureTable.setmImage(mSpinnerModel.getmImageIcon());
                                mRevenueExpenditureTable.setmPrice(Integer.parseInt(mEdtPrice.getText().toString()));
                                mRevenueExpenditureTable.setmContent(mEdtNode.getText().toString());
                                mRevenueExpenditureTable.setmCreateTime(mEdtDateTime.getText().toString());
                                //update
                                mRevenueExpenditureViewmodel.updateEvenueExpenditure(mRevenueExpenditureTable);
                            } else {
                                //insert
                                mRevenueExpenditureViewmodel.insertEvenueExpenditure(model);
                            }
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            mDialog.dismiss();
                            Helpers.hideFragmentDialog(FragmentDialogRevenueExpenditure.this, Constain.fragmentDialogRevenueExpenditure);
                        }
                    }.execute();
                }
            }
        });

        //thoát dialog
        mBtnCancal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helpers.hideFragmentDialog(FragmentDialogRevenueExpenditure.this, Constain.fragmentDialogRevenueExpenditure);
            }
        });
    }

    //check validation
    private boolean checkValidation() {
        if (mEdtPrice.getText().toString().equals("")) {
            mEdtPrice.setError(getString(R.string.lbl_not_null_data));
            return false;
        }
        mEdtPrice.setError(null);

        if (mEdtNode.getText().toString().equals("")) {
            mEdtNode.setError(getString(R.string.lbl_not_null_data));
            return false;
        }
        mEdtNode.setError(null);
        return true;
    }

    private void init() {
        //khởi tạo adapter spinner
        mSpinnerAdapter = new com.example.baseprojectandroid.src.adapter.spinner_adapter.SpinnerAdapter(getContext(), mRevenueExpenditureViewmodel.getListSpinner().getValue());
        mSpinner.setAdapter(mSpinnerAdapter);

        //settime
        mEdtDateTime.setText(Helpers.getTime());

        //set data edit
        if (mRevenueExpenditureTable != null) {
            mEdtPrice.setText(mRevenueExpenditureTable.getmPrice() + "");
            mEdtDateTime.setText(mRevenueExpenditureTable.getmCreateTime());
            mEdtNode.setText(mRevenueExpenditureTable.getmContent());

            SpinnerModel spinnerModel = new SpinnerModel(mRevenueExpenditureTable.getmImage(), mRevenueExpenditureTable.getmTitle());

            for (int i = 0; i < mRevenueExpenditureViewmodel.getListSpinner().getValue().size(); i++) {
                if(mRevenueExpenditureViewmodel.getListSpinner().getValue().get(i).getmContent().equals(spinnerModel.getmContent())){
                    mSpinner.setSelection(i);
                }
            }
        }
    }

    //ánh xạ view
    private void initView() {
        mSpinner = mView.findViewById(R.id.spinner_dialog);
        mImageDate = mView.findViewById(R.id.img_date);
        mEdtDateTime = mView.findViewById(R.id.edt_date_time);
        mBtnSave = mView.findViewById(R.id.btn_save);
        mBtnCancal = mView.findViewById(R.id.btn_cancel);
        mEdtPrice = mView.findViewById(R.id.edt_price);
        mEdtNode = mView.findViewById(R.id.edt_node);
    }

    //khởi tạo viewmodel
    private void initViewModel() {
        mRevenueExpenditureViewmodel = ViewModelProviders.of(getActivity()).get(RevenueExpenditureViewmodel.class);
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

    //callback
    @Override
    public void getTimePickerDialog(String time) {
        mEdtDateTime.setText(time);
    }

    @Override
    public void getTitleDialog(String title) {
        mType = title;
    }

    @Override
    public void getRevenueExpenditureObject(RevenueExpenditureTable revenueExpenditureTable) {
        mRevenueExpenditureTable = revenueExpenditureTable;
    }
}
