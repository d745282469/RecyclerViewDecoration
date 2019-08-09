package org.dstm.recyclerviewdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by AndroidStudio
 * Author: pd
 * Time: 2019/8/9 14:16
 */
public class TimeDecoration extends RecyclerView.ItemDecoration {
    private int screenWidth;
    private int radius = 20;
    private Paint paint;

    public TimeDecoration() {
        paint = new Paint();
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
//        c.drawColor(Color.RED);

        //循环当前所有显示出来的ItemView
        int len = parent.getChildCount();
        View childView, nextChildView = null;
        float centerX = screenWidth / 2f - radius;//圆心X坐标
        float centerY;
        int lineWidth = 10;//线宽

        for (int i = 0; i < len; i++) {
            childView = parent.getChildAt(i);
            centerY = childView.getY() + radius;//圆心Y坐标

            //画线
            float rect_left = centerX - (lineWidth / 2f);
            float rect_top = centerY + radius;
            float rect_right = rect_left + lineWidth;
            float rect_bottom;
            if (i < len - 1) {
                //不是最后一项，则线的高度默认为当前项到下一项之间的高度
                nextChildView = parent.getChildAt(i + 1);
                rect_bottom = nextChildView.getY();
            }else {
                //最后一项由于没有下一项，所以线的高度需要自己定义一个
                rect_bottom = centerY + radius + 50;
            }
            paint.setColor(Color.BLUE);
            c.drawRect(rect_left, rect_top, rect_right, rect_bottom, paint);

            //画圆
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            c.drawCircle(centerX, centerY, radius, paint);
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        screenWidth = CommonUtil.getScreenWH(parent.getContext())[0];
        int marginLeft = 50;//itemView和时间轴之间的外边距
        int left = screenWidth / 2 + radius + marginLeft;
        int bottom = 50;
        outRect.set(left, 0, 0, bottom);
    }
}
