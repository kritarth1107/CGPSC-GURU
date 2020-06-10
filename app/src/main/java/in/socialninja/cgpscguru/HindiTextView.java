package in.socialninja.cgpscguru;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class HindiTextView extends android.support.v7.widget.AppCompatTextView {
    public HindiTextView(Context context) {
        super(context);
        initTypeface(context);
    }

    public HindiTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeface(context);
    }

    public HindiTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeface(context);
    }
    private void initTypeface (Context context)
    {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"kruti-dev-021.ttf");
        this.setTypeface(typeface);
    }
}
