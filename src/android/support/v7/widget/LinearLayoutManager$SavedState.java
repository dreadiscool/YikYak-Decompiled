package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class LinearLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new LinearLayoutManager.SavedState.1();
  boolean mAnchorLayoutFromEnd;
  int mAnchorOffset;
  int mAnchorPosition;
  
  public LinearLayoutManager$SavedState() {}
  
  LinearLayoutManager$SavedState(Parcel paramParcel)
  {
    this.mAnchorPosition = paramParcel.readInt();
    this.mAnchorOffset = paramParcel.readInt();
    if (paramParcel.readInt() == i) {}
    for (;;)
    {
      this.mAnchorLayoutFromEnd = i;
      return;
      i = 0;
    }
  }
  
  public LinearLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.mAnchorPosition = paramSavedState.mAnchorPosition;
    this.mAnchorOffset = paramSavedState.mAnchorOffset;
    this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  boolean hasValidAnchor()
  {
    if (this.mAnchorPosition >= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void invalidateAnchor()
  {
    this.mAnchorPosition = -1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mAnchorPosition);
    paramParcel.writeInt(this.mAnchorOffset);
    if (this.mAnchorLayoutFromEnd) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */