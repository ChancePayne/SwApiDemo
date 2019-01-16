package com.lambdaschool.swapi;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.util.Log;
import android.widget.ImageView;
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
    public void onSwApiObjectListFragmentInteraction(SwApiObject item, ImageView view) {
        if (getResources().getBoolean(R.bool.is_tablet)) {
            // fragment_holder_detail
            final DetailFragment detailFragment = DetailFragment.newInstance(item);

            TransitionSet enterTransitionSet = new TransitionSet();
            enterTransitionSet.addTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.move));
            detailFragment.setSharedElementEnterTransition(enterTransitionSet);

            Fade enterFade = new Fade();
            /*enterFade.setStartDelay(MOVE_DEFAULT_TIME + FADE_DEFAULT_TIME);
            enterFade.setDuration(FADE_DEFAULT_TIME);*/
            detailFragment.setEnterTransition(enterFade);

            final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addSharedElement(view, ViewCompat.getTransitionName(view))
                                       .addToBackStack(null)
                                       .replace(R.id.fragment_holder_detail, detailFragment).commit();
        } else {
            Intent intent = new Intent(context, PhoneDetailActivity.class);
            intent.putExtra("swapi_item", item);
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) context, view, ViewCompat.getTransitionName(view));
            startActivity(intent, options.toBundle());
        }
    }
}
