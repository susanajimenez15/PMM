import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.mati.figurasaleatorias.R;

import static android.R.attr.left;

/**
 * Created by mati on 9/11/16.
 */

public class RandomShapeView extends View {

    private Integer[] mBackgrounds = {Color.CYAN, Color.GRAY, Color.LTGRAY, Color.MAGENTA, Color.YELLOW, Color.WHITE };
    private Paint[] mForegrounds = {makePaint(Color.BLACK),makePaint(Color.BLUE), makePaint(Color.GREEN), makePaint(Color.RED)};
    private Bitmap[] mPics =
            {makeBitmap(R.drawable.emo_im_angel),
                    makeBitmap(R.drawable.emo_im_cool),
                    makeBitmap(R.drawable.emo_im_crying),
                    makeBitmap(R.drawable.emo_im_happy),
                    makeBitmap(R.drawable.emo_im_yelling) };
    private String mMessage = "Android";

    public RandomShapeView(Context context) {
        super(context);
    }
    public RandomShapeView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor (RandomUtils.RandomElement(mBackgrounds));
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        int avgShapeWidth = viewWidth/5;
        for (int i=0; i<20; i++){
            drawRandomCircle(canvas, viewWidth, viewHeight, avgShapeWidth);
            drawnRandomRect(canvas, viewWidth, viewHeight, avgShapeWidth);
            drawRandomBitmap(canvas, viewWidth, viewHeight);
            drawRandomText(canvas, viewWidth, viewHeight, avgShapeWidth);
        }
    }

    private Paint makePaint(int color) {
        Paint p = new Paint();
        p.setColor(color);
        return(p);
    }

    private Bitmap makeBitmap (int bitmapId) {
        return(BitmapFactory.decodeResource(getResources(), bitmapId));
    }

    private void drawRandomCircle(Canvas canvas, int viewWidth, int viewHeight, int avgShapeWidth) {
        float x = RandomUtils.RandomFloat(viewWidth);
        float y = RandomUtils.RandomFloat(viewHeight);
        float radius = RandomUtils.RandomFloat(avgShapeWidth/2);
        Paint circleColor = RandomUtils.RandomElement(mForegrounds);
        canvas.drawCircle(x, y, radius, circleColor);
    }

    private void drawnRandomRect(Canvas canvas, int viewWidth, int viewHeight, int avgShapeWidth) {
        float top = RandomUtils.RandomFloat(viewHeight);
        float width = RandomUtils.RandomFloat(avgShapeWidth);
        float right = left + width;
        float bottom = top + width;
        Paint squareColor = RandomUtils.RandomElement(mForegrounds);
        canvas.drawRect(left, top, right, bottom, squareColor);
    }

    private void drawRandomBitmap(Canvas canvas, int viewWidth, int viewHeight) {
        float left = RandomUtils.RandomFloat(viewWidth);
        float top = RandomUtils.RandomFloat(viewHeight);
        Bitmap pic = RandomUtils.RandomElement(mPics);
        canvas.drawBitmap(pic, left, top, null);
    }

    private void drawRandomText(Canvas canvas, int viewWidth, int viewHeight, int avgShapeWidth) {
        float x = RandomUtils.RandomFloat(viewWidth);
        float y = RandomUtils.RandomFloat(viewHeight);
        float textSize = RandomUtils.RandomFloat(avgShapeWidth);
        Paint textPaint = RandomUtils.RandomElement(mForegrounds);
        textPaint.setTextSize(textSize);
        canvas.drawText(mMessage, x, y, textPaint);
    }
}
