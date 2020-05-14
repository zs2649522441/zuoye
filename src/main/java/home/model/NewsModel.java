package home.model;


import android.util.AndroidException;
import android.util.Log;

import callback.LoginCallBack;
import home.bean.NewsBean;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import next.api.NetApi;
import next.api.URLConstants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsModel {
    // implements NewsFragmentContract.INewsMode
  /*  @Override
    public <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("id",tabID);
        commonParams.put("start","0");
        commonParams.put("number ","0");
        commonParams.put("point_time","0");
*//*
        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }*//*
        NetWorkFactory.getInstance().getNetWork().get(URLConstants.RECOMMEND_LIST,commonParams,iNetCallBack);

    }*/

    public void getbanner(final LoginCallBack<NewsBean> callBack) {

        Retrofit build = new Retrofit.Builder()
                .baseUrl(NetApi.RECOMMEND_LIST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        NetApi netApi = build.create(NetApi.class);
        netApi.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        callBack.onSuccess(newsBean);
                        Log.d("tag", "onNext: "+newsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void setData(final LoginCallBack<NewsBean> callBack) {

        Retrofit build = new Retrofit.Builder()
                .baseUrl(NetApi.RECOMMEND_LIST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        NetApi netApi = build.create(NetApi.class);
        netApi.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        callBack.onSuccess(newsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
