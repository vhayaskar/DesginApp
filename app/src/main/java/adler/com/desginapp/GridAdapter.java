package adler.com.desginapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by r.vhayaskar on 2/17/2016.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MasonryView> {
    Context context;
    ArrayList<Integer> img;
    OnItemclickListener1 onItemclickListener1;

    public GridAdapter(Context applicationContext, ArrayList<Integer> img,OnItemclickListener1 onItemclickListener1) {
        context = applicationContext;
        this.img = img;
        this.onItemclickListener1 = onItemclickListener1;
    }
    public interface OnItemclickListener1 {
       void onItemClick(int i);
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid, parent, false);
        MasonryView masonryView = new MasonryView(layoutView);

        return masonryView;

    }

    @Override
    public void onBindViewHolder(MasonryView holder, int position) {
        holder.bind(img.get(position), onItemclickListener1);
       holder.imageView.setImageResource(img.get(position));

    }

    @Override
    public int getItemCount() {
        return img.size();
    }

     class MasonryView extends RecyclerView.ViewHolder {
        ImageView imageView;
        View layoutView;
        public MasonryView(View layoutView) {
            super(layoutView);
            this.layoutView=layoutView;
            imageView = (ImageView) layoutView.findViewById(R.id.row_grid_iv);

        }

         public void bind(final Integer integer, final OnItemclickListener1 onItemclickListener1) {
            layoutView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemclickListener1.onItemClick(integer);
                }
            });
         }
     }
}
