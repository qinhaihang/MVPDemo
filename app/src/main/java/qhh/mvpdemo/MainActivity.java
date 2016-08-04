package qhh.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import qhh.mvpdemo.bean.User;
import qhh.mvpdemo.presenter.LoginPresenter;
import qhh.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText et_account;
    private EditText et_password;
    private Button btn_login;
    private Button btn_clear;
    private LoginPresenter mLoginPresenter;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        mLoginPresenter = new LoginPresenter(this);

        btn_clear.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }

    @Override
    public String getAccount() {
        return et_account.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        mProgressDialog = ProgressDialog.show(this,"","正在登录");
    }

    @Override
    public void hideLoading() {
        if(null != mProgressDialog){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void toActivity(User user) {
        Toast.makeText(this,user.getAccount()+"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailure() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearAccount() {
        et_account.setText("");
    }

    @Override
    public void clearPassword() {
        et_password.setText("");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_login:
                mLoginPresenter.login();
                break;
            case R.id.btn_clear:
                mLoginPresenter.clear();
                break;
        }

    }
}
