package com.lambdaschool.swapi;

import android.app.Activity;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.lambdaschool.swapi.SwApiListFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SwApiObject} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MySwApiObjectRecyclerViewAdapter extends RecyclerView.Adapter<MySwApiObjectRecyclerViewAdapter.ViewHolder> {

    private final List<SwApiObject>                   mValues; // TODO: Replace with SWAPIOBJECT
    private final OnListFragmentInteractionListener mListener;

    public MySwApiObjectRecyclerViewAdapter(List<SwApiObject> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    public void addItem(SwApiObject item) {
        mValues.add(item);
        this.notifyItemChanged(mValues.size() - 1);
    }

    public void addItem(List<SwApiObject> items) {
        for(SwApiObject item: items) {
            addItem(item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.fragment_swapiobject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mTitleView.setText(mValues.get(position).name);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final int drawableId = DrawableResolver.getDrawableId(holder.mItem.getCategory(), holder.mItem.getImageId());
                ((Activity)holder.mView.getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        holder.mItem.setDrawableResourceId(drawableId);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            holder.mImageView.setImageDrawable(holder.mView.getContext().getDrawable(drawableId));
                        }
                    }
                });
            }
        }).start();

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onSwApiObjectListFragmentInteraction(holder.mItem, holder.mImageView);
                }
            }
        });

        Animation animation = AnimationUtils.loadAnimation(holder.mView.getContext(), android.R.anim.slide_in_left);
        animation.setDuration(100L);
        holder.mView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View        mView;
        public final ImageView   mImageView;
        public final TextView    mTitleView;
        public       SwApiObject mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.swapiobject_image);
            mTitleView = (TextView) view.findViewById(R.id.swapiobject_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
