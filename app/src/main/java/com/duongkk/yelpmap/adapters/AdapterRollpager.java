package com.duongkk.yelpmap.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by DuongKK on 5/17/2017.
 */

public class AdapterRollpager extends StaticPagerAdapter {
    List<String> imgPaths;

    public AdapterRollpager(RollPagerView viewPager, List<String> imgPaths) {

//        super(viewPager);
        this.imgPaths = imgPaths;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
//        view.setImageResource(imgs[0]);
        Picasso.with(container.getContext()).load(imgPaths.get(position)).into(view);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }
//
//    @Override
//    protected int getRealCount() {
//        return imgPaths.size();
//    }

    @Override
    public int getCount() {
        return imgPaths.size();
    }
}
