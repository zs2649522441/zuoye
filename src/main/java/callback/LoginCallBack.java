package callback;

public interface LoginCallBack<T> {
    void  onSuccess(T t);
    void onError(String str);

}
