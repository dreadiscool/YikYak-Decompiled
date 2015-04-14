package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback
{
  private Matrix mTempMatrix;
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    int i = Math.round(paramRectF.width());
    int j = Math.round(paramRectF.height());
    Bitmap localBitmap = null;
    if ((i > 0) && (j > 0))
    {
      if (this.mTempMatrix == null) {
        this.mTempMatrix = new Matrix();
      }
      this.mTempMatrix.set(paramMatrix);
      this.mTempMatrix.postTranslate(-paramRectF.left, -paramRectF.top);
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.concat(this.mTempMatrix);
      paramView.draw(localCanvas);
    }
    return localBitmap;
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    ImageView localImageView = null;
    if ((paramParcelable instanceof Bitmap))
    {
      Bitmap localBitmap = (Bitmap)paramParcelable;
      localImageView = new ImageView(paramContext);
      localImageView.setImageBitmap(localBitmap);
    }
    return localImageView;
  }
  
  public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
  
  public void onRejectSharedElements(List<View> paramList) {}
  
  public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.SharedElementCallback
 * JD-Core Version:    0.7.0.1
 */