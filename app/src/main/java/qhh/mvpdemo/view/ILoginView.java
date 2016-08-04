package qhh.mvpdemo.view;

import qhh.mvpdemo.bean.User;

/**
 * Created by qinhh on 16/8/4.
 * UI展示变更，获取UI数据，用户页面交互接口
 */
public interface ILoginView {

    //获取数据
    String getAccount();
    String getPassword();

    //页面展示进度
    void showLoading();
    void hideLoading();

    //业务逻辑完成之后下一步动作
    void toActivity(User user);
    void showFailure();

    //更新页面数据
    void clearAccount();
    void clearPassword();
}
