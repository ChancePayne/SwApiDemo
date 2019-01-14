package com.lambdaschool.swapi;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity implements SwApiListFragment.OnListFragmentInteractionListener {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Fragment fragment = new SwApiListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, fragment).commit();
    }

    @Override
    public void onSwApiObjectListFragmentInteraction(SwApiObject item) {
        if (getResources().getBoolean(R.bool.is_tablet)) {
            // fragment_holder_detail
            final DetailFragment detailFragment = DetailFragment.newInstance(item);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder_detail, detailFragment).commit();
        } else {
            Intent intent = new Intent(context, PhoneDetailActivity.class);
            intent.putExtra("swapi_item", item);
            startActivity(intent);
        }
    }
}
