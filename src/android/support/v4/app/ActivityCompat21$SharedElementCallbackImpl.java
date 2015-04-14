package android.support.v4.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

class ActivityCompat21$SharedElementCallbackImpl
  extends SharedElementCallback
{
  private ActivityCompat21.SharedElementCallback21 mCallback;
  
  public ActivityCompat21$SharedElementCallbackImpl(ActivityCompat21.SharedElementCallback21 paramSharedElementCallback21)
  {
    this.mCallback = paramSharedElementCallback21;
  }
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    return this.mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    return this.mCallback.onCreateSnapshotView(paramContext, paramParcelable);
  }
  
  public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap)
  {
    this.mCallback.onMapSharedElements(paramList, paramMap);
  }
  
  public void onRejectSharedElements(List<View> paramList)
  {
    this.mCallback.onRejectSharedElements(paramList);
  }
  
  public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2)
  {
    this.mCallback.onSharedElementEnd(paramList, paramList1, paramList2);
  }
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
  {
    this.mCallback.onSharedElementStart(paramList, paramList1, paramList2);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat21.SharedElementCallbackImpl
 * JD-Core Version:    0.7.0.1
 */