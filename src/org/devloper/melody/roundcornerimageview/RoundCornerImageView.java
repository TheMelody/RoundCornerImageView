package org.devloper.melody.roundcornerimageview;

import java.util.Locale;
import org.devloper.melody.polygonimageview.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundCornerImageView extends ImageView {

	private Paint mDrawPathPaint;
	private Paint mDrawBitmapPaint;
	private int mRoundWidth = 5;
	private int mRoundHeight = 5;
	private String[] mOrientation;
	private boolean mRoundAll = true;
	
	public RoundCornerImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs);
	}

	public RoundCornerImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public RoundCornerImageView(Context context) {
		super(context);
		init(context, null);
	}
	
	private void init(Context context, AttributeSet attrs) {
		if (attrs != null) {
			TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerImageView);
			mRoundWidth = a.getDimensionPixelSize(R.styleable.RoundCornerImageView_roundWidth, mRoundWidth);
			mRoundHeight = a.getDimensionPixelSize(R.styleable.RoundCornerImageView_roundHeight, mRoundHeight);
			mRoundAll = a.getBoolean(R.styleable.RoundCornerImageView_round_all, true);
			String orientation= a.getString(R.styleable.RoundCornerImageView_round_orientation);
			if(!TextUtils.isEmpty(orientation)){
				mOrientation=orientation.split("[|+]");
			}
			a.recycle();
		} else {
			float density = context.getResources().getDisplayMetrics().density;
			mRoundWidth = (int) (mRoundWidth * density);
			mRoundHeight = (int) (mRoundHeight * density);
		}
		mDrawPathPaint = new Paint();
		mDrawPathPaint.setColor(Color.WHITE);
		mDrawPathPaint.setAntiAlias(true);
		mDrawPathPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
		
		mDrawBitmapPaint = new Paint();
		mDrawBitmapPaint.setXfermode(null);
	}
	
	@Override
	public void draw(Canvas canvas) {
		Bitmap bitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Config.ARGB_8888);
		Canvas canvas2 = new Canvas(bitmap);
		super.draw(canvas2);
		if (mRoundAll) {
			drawLeftUp(canvas2);
			drawRightUp(canvas2);
			drawLeftDown(canvas2);
			drawRightDown(canvas2);
		} else {
			boolean isLeftUp = false;
			boolean isLeftDown = false;
			boolean isRightUp = false;
			boolean isRightDown = false;
			if(null!=mOrientation && mOrientation.length>0){
				for (int i = 0; i < mOrientation.length; i++) {
					if (mOrientation[i].toUpperCase(Locale.CHINA).equals("LEFT_UP")) {
						isLeftUp = true;
					} else if (mOrientation[i].toUpperCase(Locale.CHINA).equals("LEFT_DOWN")) {
						isLeftDown = true;
					} else if (mOrientation[i].toUpperCase(Locale.CHINA).equals("RIGHT_UP")) {
						isRightUp = true;
					} else if (mOrientation[i].toUpperCase(Locale.CHINA).equals("RIGHT_DOWN")) {
						isRightDown = true;
					}
				}
			}
			if (isLeftUp) {
				drawLeftUp(canvas2);
			}
			if (isLeftDown) {
				drawLeftDown(canvas2);
			}
			if (isRightUp) {
				drawRightUp(canvas2);
			}
			if (isRightDown) {
				drawRightDown(canvas2);
			}
		}
		canvas.drawBitmap(bitmap, 0, 0, mDrawBitmapPaint);
		bitmap.recycle();
	}

	private void drawLeftUp(Canvas canvas) {
		Path path = new Path();
		path.moveTo(0, mRoundHeight);
		path.lineTo(0, 0);
		path.lineTo(mRoundWidth, 0);
		path.arcTo(new RectF(0, 0, mRoundWidth * 2, mRoundHeight * 2), -90, -90);
		path.close();
		canvas.drawPath(path, mDrawPathPaint);
	}

	private void drawLeftDown(Canvas canvas) {
		Path path = new Path();
		path.moveTo(0, getMeasuredHeight() - mRoundHeight);
		path.lineTo(0, getMeasuredHeight());
		path.lineTo(mRoundWidth, getMeasuredHeight());
		path.arcTo(new RectF(0, getMeasuredHeight() - mRoundHeight * 2, 0 + mRoundWidth * 2, getMeasuredHeight()), 90, 90);
		path.close();
		canvas.drawPath(path, mDrawPathPaint);
	}

	private void drawRightDown(Canvas canvas) {
		Path path = new Path();
		path.moveTo(getMeasuredWidth() - mRoundWidth, getMeasuredHeight());
		path.lineTo(getMeasuredWidth(), getMeasuredHeight());
		path.lineTo(getMeasuredWidth(), getMeasuredHeight() - mRoundHeight);
		path.arcTo(new RectF(getMeasuredWidth() - mRoundWidth * 2, getMeasuredHeight() - mRoundHeight * 2, getMeasuredWidth(), getMeasuredHeight()), 0,
				90);
		path.close();
		canvas.drawPath(path, mDrawPathPaint);
	}

	private void drawRightUp(Canvas canvas) {
		Path path = new Path();
		path.moveTo(getMeasuredWidth(), mRoundHeight);
		path.lineTo(getMeasuredWidth(), 0);
		path.lineTo(getMeasuredWidth() - mRoundWidth, 0);
		path.arcTo(new RectF(getMeasuredWidth() - mRoundWidth * 2, 0, getMeasuredWidth(), 0 + mRoundHeight * 2), -90, 90);
		path.close();
		canvas.drawPath(path, mDrawPathPaint);
	}
}