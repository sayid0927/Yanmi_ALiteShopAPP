package com.aliteshopapp.ui.activity;


import com.aliteshopapp.R;
import com.aliteshopapp.base.activity.BaseActivity;
import com.aliteshopapp.entity.LoginBean;
import com.aliteshopapp.http.BaseResponse;
import com.aliteshopapp.injector.http.LoginHttpModule;
import com.aliteshopapp.injector.http.component.activity.DaggerRegisterComponent;
import com.aliteshopapp.presenter.LoginPresenter;
import com.aliteshopapp.presenter.impl.LoginPresenterImpl;

public class RegisterActivity  extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void setStatusBar() {

    }

    @Override
    public void initView() {

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
}
