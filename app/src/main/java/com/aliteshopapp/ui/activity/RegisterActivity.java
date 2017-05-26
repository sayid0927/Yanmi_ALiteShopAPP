package com.aliteshopapp.ui.activity;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aliteshopapp.R;
import com.aliteshopapp.base.activity.BaseActivity;
import com.aliteshopapp.entity.LoginBean;
import com.aliteshopapp.http.BaseResponse;
import com.aliteshopapp.injector.http.LoginHttpModule;
import com.aliteshopapp.injector.http.component.activity.DaggerRegisterComponent;
import com.aliteshopapp.presenter.LoginPresenter;
import com.aliteshopapp.presenter.impl.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {


    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar_base)
    Toolbar toolbarBase;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void setToolBar() {

    }

    @Override
    public void initView() {

//        tvToolbar.setText("HHHHHHH");
//        setToolBar(toolbarBase);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initInject() {
//        DaggerLoginComponent.builder().loginHttpModule(new LoginHttpModule()).build().injectLogin(this);
        DaggerRegisterComponent.builder().loginHttpModule(new LoginHttpModule()).build().injectLogin(this);
    }

    @Override
    public void onSuccessView(BaseResponse<LoginBean> mData) {

    }

    @Override
    public void onFailView(String errorMsg) {

    }

    @Override
    public void setState(int state) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
