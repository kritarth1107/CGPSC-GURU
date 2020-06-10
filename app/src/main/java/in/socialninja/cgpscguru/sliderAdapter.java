package in.socialninja.cgpscguru;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;
    public sliderAdapter(Context context) {
        this.context = context;
    }
    public int[] slide_image={R.drawable.aboutcg,R.drawable.freequiz,R.drawable.freeebooks};
    public String[] slide_header={"CGPSC GURU","CGPSC QUIZ","FREE E-BOOKS"};
    public String[] slide_desc={"Demo Desc 1","Demo Desc 2","Demo Desc 3"};
    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;

    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideimageview = (ImageView) view.findViewById(R.id.imageSlider);
        TextView slideheading = (TextView) view.findViewById(R.id.textView9);
        TextView slidedesc = (TextView) view.findViewById(R.id.textView10);

        slideimageview.setImageResource(slide_image[position]);
        slideheading.setText(slide_header[position]);
        slidedesc.setText((slide_desc[position]));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
