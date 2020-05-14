package homemvp;

import java.util.List;

import bean.NewsBean;

public interface LoginView {

    void showToast(String str);
    void setBanner(List<NewsBean.DataBean.BannerListBean>bannerbean);
    void setData(List<NewsBean.DataBean.ArticleListBean>data);
}
