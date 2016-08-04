package qhh.mvpdemo.biz;

/**
 * Created by qinhh on 16/8/4.
 * 登录业务接口，实现登录业务逻辑操作
 */
public interface IUserLogin {
    void login(String account,String pwd,LoginListener loginListener);
}
