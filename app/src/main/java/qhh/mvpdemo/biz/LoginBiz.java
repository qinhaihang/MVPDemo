package qhh.mvpdemo.biz;

import qhh.mvpdemo.bean.User;

/**
 * Created by qinhh on 16/8/4.
 * 登录业务实际操作类
 */
public class LoginBiz implements IUserLogin {

    @Override
    public void login(final String account, final String pwd, final LoginListener loginListener) {

        //登录业务实现
        new Thread(){
            @Override
            public void run() {

                try{
                    Thread.sleep(2000);
                } catch (Exception e){
                    e.printStackTrace();
                }

                if("qhh".equals(account) && "123".equals(pwd)) {
                    User user = new User();
                    user.setAccount(account);
                    user.setPassword(pwd);
                    loginListener.loginSuccess(user);
                }else{
                    loginListener.loginFailure();
                }

            }
        }.start();

    }
}
