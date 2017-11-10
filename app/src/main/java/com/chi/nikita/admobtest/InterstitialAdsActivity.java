package com.chi.nikita.admobtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialAdsActivity extends BaseActivity {

    private Button btnInterstitialAds;
    private InterstitialAd interstitial;  // The ad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ads);
        init();
        adsMethod();
    }

    @Override
    protected void init() {
        btnInterstitialAds = findViewById(R.id.btnInterstialAds);
        btnInterstitialAds.setOnClickListener(this);
    }

    @Override
    protected void adsMethod() {
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        final AdRequest adRequestInter = new AdRequest.Builder().build();
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                interstitial.show();
            }
        });
        interstitial.loadAd(adRequestInter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnInterstialAds:
                intent = new Intent(this, RewardedVideoAdsActivity.class);
                break;

        }
        startActivity(intent);
    }
}
