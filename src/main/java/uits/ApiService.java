package uits;

import bean.NewsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    String HOME_URL="https://www.seetao.com";
    @GET("/app/v_1_3/article/recommendlist")
    Observable<NewsBean>getData();
}
