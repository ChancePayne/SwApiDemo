package com.lambdaschool.swapi;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

public class PhoneDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getWindow().setExitTransition(new Explode());
            getWindow().setEnterTransition(new Explode());
        }

        setContentView(R.layout.activity_phone_detail);

        final DetailFragment detailFragment = DetailFragment.newInstance((SwApiObject) getIntent().getSerializableExtra("swapi_item"));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder_detail, detailFragment).commit();
    }
}
