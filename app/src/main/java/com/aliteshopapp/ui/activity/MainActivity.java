package com.aliteshopapp.ui.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aliteshopapp.R;
import com.aliteshopapp.base.activity.BaseActivity;
import com.aliteshopapp.entity.LoginBean;
import com.aliteshopapp.http.BaseResponse;
import com.aliteshopapp.injector.http.LoginHttpModule;
import com.aliteshopapp.injector.http.component.activity.DaggerLoginComponent;
import com.aliteshopapp.presenter.LoginPresenter;
import com.aliteshopapp.presenter.impl.LoginPresenterImpl;
import com.blankj.utilcode.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {


    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.ll_ohter_login)
    LinearLayout llOhterLogin;
    @BindView(R.id.layout_login)
    LinearLayout layoutLogin;
    @BindView(R.id.btn_forget_pwd)
    Button btnForgetPwd;
    @BindView(R.id.btn_register)
    Button btnNewUser;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.toolbar_base_activity)
    Toolbar toolbarBaseActivity;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.name_icon)
    ImageView nameIcon;
    @BindView(R.id.name_layout)
    RelativeLayout nameLayout;
    @BindView(R.id.password_icon)
    ImageView passwordIcon;
    @BindView(R.id.password_layout)
    RelativeLayout passwordLayout;
    @BindView(R.id.iv_wechat_login)
    ImageView ivWechatLogin;
    @BindView(R.id.iv_qq_login)
    ImageView ivQqLogin;
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;

    private long mExitTime = 0;
    private InputMethodManager manager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setToolBar() {

        setSupportActionBar(toolbarBaseActivity);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvToolbar.setText("登录");

    }

    @Override
    public void initView() {

        ButterKnife.bind(this);
        getSwipeBackLayout().setEnableGesture(false);
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {

        DaggerLoginComponent.builder().loginHttpModule(new LoginHttpModule()).build().injectLogin(this);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(this.getResources().getString(R.string.out_app));
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setState(int state) {


    }

    @Override
    public void onSuccessView(BaseResponse<LoginBean> mData) {
        LoginBean login = mData.getData();
        Logger.t("TAG").d(login);
    }

    @Override
    public void onFailView(String errorMsg) {
        ToastUtils.showShortToast(errorMsg);
    }

    @OnClick({R.id.btn_forget_pwd, R.id.btn_register, R.id.btn_login, R.id.edit_name, R.id.edit_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_forget_pwd:
                break;
            case R.id.btn_register:
                startActivityIn(new Intent(MainActivity.this, RegisterActivity.class), this);
                break;
            case R.id.btn_login:
                break;
            case R.id.edit_name:
                break;
            case R.id.edit_password:
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
