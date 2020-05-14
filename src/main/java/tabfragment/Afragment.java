package tabfragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangnmu.R;

import java.util.ArrayList;
import java.util.List;

import home.adapter.HomeAdapter;
import home.bean.NewsBean;
import home.presenter.NewsPresenter;
import home.view.NewsView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Afragment extends Fragment implements NewsView {


    private RecyclerView mRecycler;
    private NewsPresenter presenter;
    private List<NewsBean.DataBean.BannerListBean> beans;
    private HomeAdapter adapter;

    public Afragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_afragment2, container, false);
       // initView(inflate);
        presenter = new NewsPresenter(this);
        return inflate;
    }

    private void initView(View inflate) {
        mRecycler = inflate.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        presenter.banner();
        presenter.setData();
        beans = new ArrayList<>();

        adapter = new HomeAdapter(getActivity(), beans);
    }

    @Override
    public void showToast(String str) {

    }

    @Override
    public void bannerdata(List<NewsBean.DataBean.BannerListBean> bannerListBeans) {

        beans.addAll(bannerListBeans);
        adapter.notifyDataSetChanged();;
    }

    @Override
    public void setdata(List<NewsBean.DataBean.ArticleListBean> articleListBeans) {

    }
}
