package com.example.baseprojectandroid.src.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.viewmodel.register_viewmodel.RegisterViewmodel;
import com.example.baseprojectandroid.utils.Helpers;
import com.example.baseprojectandroid.utils.Validations;

public class RegisterActivity extends AppCompatActivity {
    private EditText mEditTextUserName,mEditTextPassword,mEditTextEmail,mEditTextPhone,mEditTextRoles;
    private ImageView mImageViewRoles,mImageViewBack;
    private Button mBtnRegister;
    //variable
    private RegisterViewmodel mRegisterViewmodel;
    private Dialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initViewModel();
        listenerOnclicked();
    }

    // create viewmodel
    private void initViewModel() {
        mRegisterViewmodel = ViewModelProviders.of(RegisterActivity.this).get(RegisterViewmodel.class);
    }

    //lắng nghe sự kiện onclick view
    private void listenerOnclicked() {
        //phân quyền roles
        mImageViewRoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),mImageViewRoles);
                popupMenu.inflate(R.menu.menu_type_register);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.teacher :
                                mEditTextRoles.setText(getString(R.string.lbl_teacher));
                                break;
                            case  R.id.student:
                                mEditTextRoles.setText(getString(R.string.lbl_student));
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        //back ve login
        mImageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //register
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRegisterViewmodel.mUserName = mEditTextUserName.getText().toString();
                mRegisterViewmodel.mPassword = mEditTextPassword.getText().toString();
                mRegisterViewmodel.mEmail = mEditTextEmail.getText().toString();
                mRegisterViewmodel.mPhone = mEditTextPhone.getText().toString();
                mRegisterViewmodel.mRoles = mEditTextRoles.getText().toString();

                if(checkValidation()){
                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            mDialog = Helpers.showLoadingDialog(RegisterActivity.this);
                            mDialog.show();
                        }

                        @Override
                        protected Void doInBackground(Void... voids) {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            mDialog.dismiss();
                            finish();
                        }
                    }.execute();
                }
            }
        });
    }

    //check validation
    private boolean checkValidation(){
        if(Validations.isValidName(mRegisterViewmodel.mUserName)){
            mEditTextUserName.setError(getString(R.string.lbl_err_username));
            return false;
        }
        mEditTextUserName.setError(null);

        if (Validations.isPasswordValid(mRegisterViewmodel.mPassword)){
            mEditTextPassword.setError(getString(R.string.lbl_err_password));
            return false;
        }
        mEditTextPassword.setError(null);

        if(Validations.isEmailValid(mRegisterViewmodel.mEmail)){
            mEditTextEmail.setError(getString(R.string.lbl_err_email));
            return false;
        }
        mEditTextEmail.setError(null);

        if(!Validations.isValidPhoneNumber(mRegisterViewmodel.mPhone)){
            mEditTextPhone.setError(getString(R.string.lbl_err_phone));
            return false;
        }
        mEditTextPhone.setError(null);

        return true;
    }

    //ánh xạ view
    private void initView() {
        mEditTextUserName = findViewById(R.id.edt_username);
        mEditTextPassword = findViewById(R.id.edt_password);
        mEditTextEmail = findViewById(R.id.edt_email);
        mEditTextPhone = findViewById(R.id.edt_phone);
        mEditTextRoles = findViewById(R.id.edt_roles);
        mBtnRegister = findViewById(R.id.btn_register);
        mImageViewRoles = findViewById(R.id.img_roles);
        mImageViewBack = findViewById(R.id.img_back);
    }
}