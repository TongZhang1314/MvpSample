package mvpsample.tongzhang.com.mvpsample.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import mvpsample.tongzhang.com.mvpsample.R;


/**
 * Created by Joson on 2019/6/128.
 */
public class RoundCornerLayout extends RelativeLayout {
    private float roundLayoutRadius = 14f;
    private Path roundPath;
    private RectF rectF;
    public RoundCornerLayout(Context context) {
        this(context, null);
    }

    public RoundCornerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerLayout);
        roundLayoutRadius = typedArray.getDimension(R.styleable.RoundCornerLayout_roundLayoutRadius, (int) roundLayoutRadius);
        typedArray.recycle();

        init();
    }

    private void init() {
        setWillNotDraw(false);
        roundPath = new Path();
        rectF = new RectF();
    }

    private void setRoundPath() {
        //添加一个圆角矩形到path中, 如果要实现任意形状的View, 只需要手动添加path就行
        roundPath.addRoundRect(rectF, roundLayoutRadius, roundLayoutRadius, Path.Direction.CW);
    }


    public void setRoundLayoutRadius(float roundLayoutRadius) {
        this.roundLayoutRadius = roundLayoutRadius;
        setRoundPath();
        postInvalidate();
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        rectF.set(0f, 0f, getMeasuredWidth(), getMeasuredHeight());
        setRoundPath();
    }


    @Override
    public void draw(Canvas canvas) {
        if (roundLayoutRadius > 0f) {
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG));
            canvas.clipPath(roundPath);
        }
        super.draw(canvas);
    }
}
