package com.phz.greendaodemo.ui.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.text.TextUtilsCompat;
import android.util.AttributeSet;
import android.util.LayoutDirection;
import android.view.View;
import android.view.ViewGroup;

import com.phz.greendaodemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FlowLayout extends ViewGroup {
    private static final int LEFT = -1;
    private static final int CENTER = 0;
    private static final int RIGHT = 1;
    protected List<List<View>> mAllViews = new ArrayList<List<View>>();
    protected List<Integer> mLineHeight = new ArrayList<Integer>();
    protected List<Integer> mLineWidth = new ArrayList<Integer>();
    private int mGravity;
    private List<View> lineViews = new ArrayList<>();
    public FlowLayout(Context context) {
        this(context,null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        mGravity = ta.getInt(R.styleable.FlowLayout_tag_gravity, LEFT);
        int layoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault());
        if (layoutDirection == LayoutDirection.RTL) {
            if (mGravity == LEFT) {
                mGravity = RIGHT;
            } else {
                mGravity = LEFT;
            }
        }
        ta.recycle();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout);
        mGravity = ta.getInt(R.styleable.FlowLayout_tag_gravity, LEFT);
        int layoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault());
        if (layoutDirection == LayoutDirection.RTL) {
            if (mGravity == LEFT) {
                mGravity = RIGHT;
            } else {
                mGravity = LEFT;
            }
        }
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //获取父布局宽度
        int sizeWidth=MeasureSpec.getSize(widthMeasureSpec);
        //获取父布局高度
        int sizeHeight=MeasureSpec.getSize(heightMeasureSpec);
        //获取父布局宽度模式
        int modeWidth=MeasureSpec.getMode(widthMeasureSpec);
        //获取父布局高度模式
        int modeHeight=MeasureSpec.getMode(heightMeasureSpec);

        //父布局最终宽度
        int width=0;
        //父布局最终高度
        int height=0;

        //当前测量的宽度
        int lineWidth=0;
        //当前测量高度
        int lineHeight=0;

        //当前孩子布局数据
        int cCount=getChildCount();

        //for循环依次测量孩子布局
        for (int i=0;i<cCount;i++){
            View child=getChildAt(i);

            //如果为GONE就跳过本次循环执行下一次循环，我们知道invisible还是会占位置
            if (child.getVisibility()==View.GONE){
                continue;
            }

            //测量孩子布局
            measureChild(child,widthMeasureSpec,heightMeasureSpec);
            /**
             * 调用方法需要子view的布局参数返回MarginLayoutParams而不是默认LayoutParams
             * widthUsed 父级水平占用额外（可能由其他子集占用）heightUsed同理
             */
            /*measureChildWithMargins(child,widthMeasureSpec,0,heightMeasureSpec,0);*/

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            //注意啊，getWidth方法你是拿不到的值的，在没有onLayout定位之前
            int childWidth=child.getMeasuredWidth();
            int childHeight=child.getMeasuredHeight();

            //如果需要占用的宽度超过了父布局能提供的宽度，我们就下一行
            if (lineWidth+childWidth>sizeWidth-getPaddingLeft()-getPaddingRight()){
                //比较测量宽度和最终宽度变量，取大的
                width=Math.max(width,lineWidth);
                lineWidth=childWidth;
                height+=lineHeight;
                lineHeight=childHeight;
            }
            else {
                //没超过，就继续累加测量宽度
                lineWidth+=childWidth;
                lineHeight=Math.max(height,lineHeight);
            }
        }

        /**
         * 这里值得一提的是，我没有调用用onMeasure的super.onMeasure(widthMeasureSpec,heightMeasureSpec)
         * 所以需要调用setMeasuredDimension方法，自己去存储测量宽高。
         * 如果是特定模式，就直接使用父亲获取的尺寸
         */
        setMeasuredDimension(modeWidth==MeasureSpec.EXACTLY?sizeWidth:width,modeHeight==MeasureSpec.EXACTLY?sizeHeight:height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    /**
     * default:LayoutParams
     * @param p
     * @return
     */
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    /**
     * default:new LayoutParams(getContext(), attrs);
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /**
     * default：new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
     * @return
     */
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
}
