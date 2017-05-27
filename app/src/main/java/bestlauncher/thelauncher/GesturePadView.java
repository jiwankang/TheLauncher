package bestlauncher.thelauncher;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Jiwan Kang on 2017-05-27.
 */

public class GesturePadView extends View {
    private Rect rectangle;
    private Paint paint;

    public GesturePadView(Context context) {
        super(context);
        rectangle = new Rect(10, 700, 1400, 2000);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(rectangle, paint);
    }

}
