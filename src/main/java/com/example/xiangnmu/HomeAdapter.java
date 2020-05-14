package com.example.xiangnmu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import bean.NewsBean;

public class HomeAdapter extends RecyclerView.Adapter {
    private int TYPE_BANNER = 0;
    private int TYPE_LIST = 1;
    private int TYPE_IMG = 2;
    private int TYPE_VIDEO = 3;
    Context context;
    List<NewsBean.DataBean.BannerListBean> bannerlist;
    List<NewsBean.DataBean.ArticleListBean> list;


    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setBannerlist(List<NewsBean.DataBean.BannerListBean> bannerlist) {
        this.bannerlist = bannerlist;
    }

    public void setList(List<NewsBean.DataBean.ArticleListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);
            return new Holder_one(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            return new Holder_two(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
            return new Holder_three(inflate);
        } else if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.video_item, parent, false);
            return new Holder_fore(inflate);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == TYPE_BANNER) {
            ((Holder_one) holder).mBanner.setImages(bannerlist).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    NewsBean.DataBean.BannerListBean path1 = (NewsBean.DataBean.BannerListBean) path;
                    Glide.with(context).load(path1.getImage_url()).into(imageView);
                }
            }).start();
        }else if (type==TYPE_LIST){
            if (bannerlist.size()>0){
                position=position-1;
            }
            ((Holder_two)holder).mDesc.setText(list.get(position).getContent());
        }

    }

    @Override
    public int getItemCount() {
        if (bannerlist.size()>0){
            return list.size()+1;
        }else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        } else if (position == 1) {
            return TYPE_LIST;
        } else if (position == 2) {
            return TYPE_IMG;
        } else {
            return TYPE_VIDEO;
        }
    }

    public class Holder_one extends RecyclerView.ViewHolder {

        private Banner mBanner;

        public Holder_one(@NonNull View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.banner);

        }
    }

    public class Holder_two extends RecyclerView.ViewHolder {

        private ImageView mImg;
        private TextView mDesc;
        public Holder_two(@NonNull View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.img);
            mDesc = itemView.findViewById(R.id.desc);
        }
    }

    public class Holder_three extends RecyclerView.ViewHolder {

        public Holder_three(@NonNull View itemView) {
            super(itemView);

        }
    }

    public class Holder_fore extends RecyclerView.ViewHolder {

        public Holder_fore(@NonNull View itemView) {
            super(itemView);

        }
    }

}
