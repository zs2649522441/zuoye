package home.presenter;


import callback.LoginCallBack;
import home.bean.NewsBean;
import home.model.NewsModel;
import home.view.NewsView;

public class NewsPresenter  {
    NewsView newsView;
    NewsModel newsModel;

    public NewsPresenter(NewsView newsView) {
        this.newsView = newsView;
        this.newsModel = new NewsModel();
    }

    public void banner() {
        newsModel.getbanner(new LoginCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                newsView.bannerdata(newsBean.getData().getBanner_list());
            }

            @Override
            public void onError(String str) {
                newsView.showToast(str);
            }
        });
    }

    public void setData() {
        newsModel.setData(new LoginCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                newsView.setdata(newsBean.getData().getArticle_list());
            }

            @Override
            public void onError(String str) {
                newsView.showToast(str);
            }
        });
    }
}
