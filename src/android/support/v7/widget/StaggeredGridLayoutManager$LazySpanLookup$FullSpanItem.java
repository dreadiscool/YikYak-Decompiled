package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1();
  int mGapDir;
  int[] mGapPerSpan;
  int mPosition;
  
  public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    this.mPosition = paramParcel.readInt();
    this.mGapDir = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.mGapPerSpan = new int[i];
      paramParcel.readIntArray(this.mGapPerSpan);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getGapForSpan(int paramInt)
  {
    if (this.mGapPerSpan == null) {}
    for (int i = 0;; i = this.mGapPerSpan[paramInt]) {
      return i;
    }
  }
  
  public void invalidateSpanGaps()
  {
    this.mGapPerSpan = null;
  }
  
  public String toString()
  {
    return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mPosition);
    paramParcel.writeInt(this.mGapDir);
    if ((this.mGapPerSpan != null) && (this.mGapPerSpan.length > 0))
    {
      paramParcel.writeInt(this.mGapPerSpan.length);
      paramParcel.writeIntArray(this.mGapPerSpan);
    }
    for (;;)
    {
      return;
      paramParcel.writeInt(0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */