package com.example.baseprojectandroid.src.page.login_activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.page.register_activity.RegisterActivity;
import com.example.baseprojectandroid.src.page.tabbar_activity.TabBarActivity;
import com.example.baseprojectandroid.src.viewmodel.login_viewmodel.LoginViewModel;
import com.example.baseprojectandroid.utils.Helpers;
import com.example.baseprojectandroid.utils.Validations;

public class LoginActivity extends AppCompatActivity {
    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private CheckBox mCheckBox;
    private Button mButtonLogin;
    private TextView mTextViewRegister;

    //variable
    private Dialog mDialog;
    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initViewModel();
        listenerOnclicked();
    }

    // lắng nghe sự kiện onclick view
    private void listenerOnclicked() {
        // save login remember me
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mLoginViewModel.mIsLogin = isChecked;
            }
        });

        //navigator rgister page
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
            }
        });

        //login
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginViewModel.mUserName = mEditTextUserName.getText().toString();
                mLoginViewModel.mPassword = mEditTextPassword.getText().toString();

                if (checkValidation()) {
                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            mDialog = Helpers.showLoadingDialog(LoginActivity.this);
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
                            startActivity(new Intent(getApplicationContext(), TabBarActivity.class));
                            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                            finish();
                        }
                    }.execute();
                }

            }
        });
    }

    //check validation
    private boolean checkValidation() {
        if (Validations.isValidName(mLoginViewModel.mUserName)) {
            mEditTextUserName.setError(getString(R.string.lbl_err_username));
            return false;
        }
        mEditTextUserName.setError(null);

        if (Validations.isPasswordValid(mLoginViewModel.mPassword)) {
            mEditTextPassword.setError(getString(R.string.lbl_err_password));
            return false;
        }
        mEditTextPassword.setError(null);

        return true;
    }

    //create viewmodel
    private void initViewModel() {
        mLoginViewModel = ViewModelProviders.of(LoginActivity.this).get(LoginViewModel.class);
    }

    //ánh xạ view
    private void initView() {
        mEditTextUserName = findViewById(R.id.edt_username);
        mEditTextPassword = findViewById(R.id.edt_password);
        mCheckBox = findViewById(R.id.ck_rememberme);
        mButtonLogin = findViewById(R.id.btn_login);
        mTextViewRegister = findViewById(R.id.txt_register);
    }
}