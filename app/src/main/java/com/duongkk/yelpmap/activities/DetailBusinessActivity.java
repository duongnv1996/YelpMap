package com.duongkk.yelpmap.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.duongkk.yelpmap.API.ApiConstants;
import com.duongkk.yelpmap.API.CustomCallback;
import com.duongkk.yelpmap.R;
import com.duongkk.yelpmap.adapters.AdapterReview;
import com.duongkk.yelpmap.adapters.AdapterRollpager;
import com.duongkk.yelpmap.models.Businesses;
import com.duongkk.yelpmap.models.ResponseReview;
import com.duongkk.yelpmap.models.Review;
import com.duongkk.yelpmap.utils.Constants;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.IconHintView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

public class DetailBusinessActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    RollPagerView viewPager;
    @BindView(R.id.rate_detail)
    AppCompatRatingBar rateDetail;
    @BindView(R.id.tv_categories)
    TextView tvCategories;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.rcv_review)
    RecyclerView rcvReview;
    @BindView(R.id.loading)
    ProgressBar loading;

    @BindView(R.id.tv_all_review)
    TextView tvAllReviews;


    private Businesses mbusiness;
    private AdapterReview mAdapterReview;
    private ProgressDialog progressDialog;
    private List<Review> mListReviews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_business);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLayout.setTitle("");
        rcvReview.setLayoutManager(new LinearLayoutManager(this));
        rcvReview.setHasFixedSize(true);
//        Call API to get Detail
        if (getIntent() != null) {
            String id = getIntent().getStringExtra("msg");
            if (id != null) {
                String token = new SPUtils(Constants.SP).getString(ApiConstants.ACCESSTOKEN, "");
                if (token.equals("")) {
                    Toast.makeText(this, "No AccessToken ", Toast.LENGTH_LONG).show();
                    return;
                }
                Call<Businesses> apiGetDetail = getmYelpServices().getDetailBusiness(token, id);
                apiGetDetail.enqueue(new CustomCallback<Businesses>(this, progressDialog, new CustomCallback.ICallBack<Businesses>() {
                    @Override
                    public void onResponse(Businesses response) {
                        progressDialog.dismiss();
                        if (response != null) {
                            mbusiness =response;
                            bindDataToView(toolbar);
                        }
                    }
                }));
            }
        }

    }

    private void bindDataToView(Toolbar toolbar) {
        viewPager.setAdapter(new AdapterRollpager(viewPager, mbusiness.getPhotos()));
        viewPager.setHintView(new IconHintView(getApplicationContext(), R.drawable.point_focus, R.drawable.point_normal));
//        viewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        toolbarLayout.setTitle(mbusiness.getName());
        tvPhone.setText(mbusiness.getPhone());
        tvAddress.setText(mbusiness.getLocation().getAddress1());
        String categories = "";
        for (Businesses.Categories item : mbusiness.getCategories()) {
            if (item != null && item.getTitle() != null) {
                categories += item.getTitle() + ",";
            }
        }
        tvCategories.setText(categories);
        rateDetail.setRating(mbusiness.getRating());
        getReviews();
    }

    @Override
    protected void onStop() {
        if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
        super.onStop();
    }

    private void getReviews() {
        String token = new SPUtils(Constants.SP).getString(ApiConstants.ACCESSTOKEN, "");
        if (token.equals("")) {
            Toast.makeText(this, "No AccessToken ", Toast.LENGTH_LONG).show();
            return;
        }
        Call<ResponseReview> apiReview = getmYelpServices().getReviews(token, mbusiness.getId());
        apiReview.enqueue(new CustomCallback<ResponseReview>(this, new CustomCallback.ICallBack<ResponseReview>() {
            @Override
            public void onResponse(ResponseReview response) {
                loading.setVisibility(View.GONE);
                mAdapterReview = new AdapterReview(response.getListReviews(), DetailBusinessActivity.this);
                rcvReview.setAdapter(mAdapterReview);
                rcvReview.setNestedScrollingEnabled(false);
                tvAllReviews.setText(String.format(getString(R.string.reviews),response.getTotal()));
                mListReviews = response.getListReviews();
            }
        }));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    @OnClick({R.id.ll_phone, R.id.ll_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_phone:
                break;
            case R.id.ll_address:
                break;

        }
    }
}
