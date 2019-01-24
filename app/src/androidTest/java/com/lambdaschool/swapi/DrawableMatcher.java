package com.lambdaschool.swapi;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class DrawableMatcher extends TypeSafeMatcher<View> {

    private final int expectedId;

    public DrawableMatcher(int expectedId) {
        super(View.class);
        this.expectedId = expectedId;
    }

    /**
     * Subclasses should implement this. The item will already have been checked for
     * the specific type and will never be null.
     *
     * @param item
     */
    @Override
    protected boolean matchesSafely(View item) {
        if(!(item instanceof ImageView)) {
            return false;
        }

        ImageView imageView = (ImageView)item;
        Resources resources = item.getContext().getResources();
        Drawable expectedDrawable = resources.getDrawable(expectedId);
        if(expectedDrawable == null) {
            return false;
        }

        // drawable objects not comparing as expected
//        return imageView.getDrawable() == expectedDrawable;
        Bitmap actualBitmap = getBitmap(imageView.getDrawable());
        Bitmap expectedBitmap = getBitmap(expectedDrawable);
        return actualBitmap.sameAs(expectedBitmap);
    }

    private Bitmap getBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Generates a description of the object.  The description may be part of a
     * a description of a larger object of which this is just a component, so it
     * should be worded appropriately.
     *
     * @param description The description to be built or appended to.
     */
    @Override
    public void describeTo(Description description) {
        description.appendText("with drawable from resource id: ");
        description.appendValue(expectedId);
    }
}
