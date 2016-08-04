package qhh.mvpdemo.biz;

import qhh.mvpdemo.bean.User;

/**
 * Created by qinhh on 16/8/4.
 * 登录结果监听，presenter 通过该接口对登录业务结果进行监听回调
 */
public interface LoginListener {
    void loginSuccess(User user);
    void loginFailure();
}
