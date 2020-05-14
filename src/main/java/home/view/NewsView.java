package home.view;

import java.util.List;

import home.bean.NewsBean;

public interface NewsView {
    void showToast(String str);
    void bannerdata(List<NewsBean.DataBean.BannerListBean>bannerListBeans);
    void setdata(List<NewsBean.DataBean.ArticleListBean>articleListBeans);
}
