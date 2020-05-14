package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import home.adapter.HomeAdapter;
import com.example.xiangnmu.R;
import home.adapter.ViewAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import tabfragment.Afragment;
import tabfragment.Bfragment;
import tabfragment.Cfragment;
import tabfragment.DAfragment;
import tabfragment.EAfragment;
import tabfragment.GAfragment;
import tabfragment.HAfragment;
import tabfragment.IAfragment;

public class Homefragment extends Fragment {

    private TabLayout mTab;
    private ViewPager mViewPager;
    private List<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.homefragment, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mTab = inflate.findViewById(R.id.tab);
        mViewPager = inflate.findViewById(R.id.viewpager);

        fragments = new ArrayList<>();

        fragments.add(new Afragment());
        fragments.add(new Bfragment());
        fragments.add(new Cfragment());
        fragments.add(new DAfragment());
        fragments.add(new EAfragment());
        fragments.add(new Fragment());
        fragments.add(new GAfragment());
        fragments.add(new HAfragment());
        fragments.add(new IAfragment());

        ViewAdapter viewAdapter = new ViewAdapter(getActivity().getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(viewAdapter);

        mTab.setupWithViewPager(mViewPager);

        mTab.getTabAt(0).setText("推荐");
        mTab.getTabAt(1).setText("战略");
        mTab.getTabAt(2).setText("工程");
        mTab.getTabAt(3).setText("一带一路");
        mTab.getTabAt(4).setText("机械");
        mTab.getTabAt(5).setText("特写");
        mTab.getTabAt(6).setText("社评");
        mTab.getTabAt(7).setText("即时");
        mTab.getTabAt(8).setText("传承");
    }
}
