package qhh.mvpdemo.presenter;

import android.os.Handler;

import qhh.mvpdemo.bean.User;
import qhh.mvpdemo.biz.LoginBiz;
import qhh.mvpdemo.biz.LoginListener;
import qhh.mvpdemo.view.ILoginView;

/**
 * Created by qinhh on 16/8/4.
 * 实现 V 和 M 数据传递处理的桥梁，将 V 所获取的用户交互指令数据传入 M 中处理
 * 再将 M 中的 处理结果，返回 V中展示
 * 登录业务中，该类需要实现登录、更新Activty界面的逻辑
 */
public class LoginPresenter {

    private ILoginView mLoginView; //从Activity中传入View接口对象
    private LoginBiz mLoginBiz;    //新生成一个业务逻辑实现类，并且设置监听回调，获取处理结果

    private Handler mHandler = new Handler();

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mLoginBiz = new LoginBiz();
    }

    public void login(){

        //进度展示
        mLoginView.showLoading();

        mLoginBiz.login(mLoginView.getAccount(), mLoginView.getPassword(), new LoginListener() {
            @Override
            public void loginSuccess(final User user) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoginView.hideLoading();
                        //登录成功之后的操作
                        mLoginView.toActivity(user);
                    }
                });

            }

            @Override
            public void loginFailure() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //展示登录失败
                        mLoginView.showFailure();

                        mLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear(){
        mLoginView.clearAccount();
        mLoginView.clearPassword();
    }

}
