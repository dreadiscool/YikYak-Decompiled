package android.support.v4.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

class ActivityCompat$SharedElementCallback21Impl
  extends ActivityCompat21.SharedElementCallback21
{
  private SharedElementCallback mCallback;
  
  public ActivityCompat$SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
  {
    this.mCallback = paramSharedElementCallback;
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
 * Qualified Name:     android.support.v4.app.ActivityCompat.SharedElementCallback21Impl
 * JD-Core Version:    0.7.0.1
 */