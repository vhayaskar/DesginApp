package adler.com.desginapp;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by r.vhayaskar on 2/17/2016.
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    int space;

    public SpacesItemDecoration(int i) {
        space = i;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildAdapterPosition(view) == 0)
            outRect.top = space;
    }
}
