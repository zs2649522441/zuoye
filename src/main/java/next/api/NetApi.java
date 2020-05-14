package next.api;

import java.util.HashMap;

import home.bean.NewsBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 这个代码不用动了
 */
public interface NetApi {

    public static String BASE_URL = "https://www.seetao.com/";


    //推荐列表
    public static String RECOMMEND_LIST= "app/v_1_3/article/recommendlist";
    @GET("app/v_1_3/article/recommendlist")
    Observable<NewsBean>getData();

    //栏目列表
    public static String COLUM_LIST = "api/column/columnlist";

    //  视频列表
    public static  String VEDIO_LIST = "app/v_1_3/article/videolist";












   /* @GET
    Observable<ResponseBody> get(@Url String url);

    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap HashMap<String, String> queryMap);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> post(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> post(@Url String url, @FieldMap HashMap<String, String> queryMap);*/

}
