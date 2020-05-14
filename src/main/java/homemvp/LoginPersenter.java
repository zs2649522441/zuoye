package homemvp;

import android.view.View;

import bean.NewsBean;
import callback.LoginCallBack;

public class LoginPersenter {

    LoginView loginView;
    LoginMolder loginMolder;

    public LoginPersenter(LoginView loginView) {
        this.loginView = loginView;
        loginMolder=new LoginMolder();
    }

    public void getBanner(){
        loginMolder.getBanner(new LoginCallBack<NewsBean.DataBean.BannerListBean>() {
            @Override
            public void onSuccess(NewsBean.DataBean.BannerListBean bannerListBean) {
              // loginView.setBanner(bannerListBean.getImage_url());
            }

            @Override
            public void onError(String str) {
                loginView.showToast(str);
            }
        });
    }
    public void getData(){
        loginMolder.getData(new LoginCallBack<NewsBean.DataBean.ArticleListBean>() {
            @Override
            public void onSuccess(NewsBean.DataBean.ArticleListBean articleListBean) {
              //  loginView.setData(articleListBean.getColumn_name());
            }

            @Override
            public void onError(String str) {
                loginView.showToast(str);
            }
        });
    }
}
