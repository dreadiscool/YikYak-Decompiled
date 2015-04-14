package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

class StaggeredGridLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new StaggeredGridLayoutManager.SavedState.1();
  boolean mAnchorLayoutFromEnd;
  int mAnchorPosition;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
  boolean mLastLayoutRTL;
  boolean mReverseLayout;
  int[] mSpanLookup;
  int mSpanLookupSize;
  int[] mSpanOffsets;
  int mSpanOffsetsSize;
  int mVisibleAnchorPosition;
  
  public StaggeredGridLayoutManager$SavedState() {}
  
  StaggeredGridLayoutManager$SavedState(Parcel paramParcel)
  {
    this.mAnchorPosition = paramParcel.readInt();
    this.mVisibleAnchorPosition = paramParcel.readInt();
    this.mSpanOffsetsSize = paramParcel.readInt();
    if (this.mSpanOffsetsSize > 0)
    {
      this.mSpanOffsets = new int[this.mSpanOffsetsSize];
      paramParcel.readIntArray(this.mSpanOffsets);
    }
    this.mSpanLookupSize = paramParcel.readInt();
    if (this.mSpanLookupSize > 0)
    {
      this.mSpanLookup = new int[this.mSpanLookupSize];
      paramParcel.readIntArray(this.mSpanLookup);
    }
    int j;
    int k;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.mReverseLayout = j;
      if (paramParcel.readInt() != i) {
        break label152;
      }
      k = i;
      label114:
      this.mAnchorLayoutFromEnd = k;
      if (paramParcel.readInt() != i) {
        break label158;
      }
    }
    for (;;)
    {
      this.mLastLayoutRTL = i;
      this.mFullSpanItems = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      return;
      j = 0;
      break;
      label152:
      k = 0;
      break label114;
      label158:
      i = 0;
    }
  }
  
  public StaggeredGridLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.mSpanOffsetsSize = paramSavedState.mSpanOffsetsSize;
    this.mAnchorPosition = paramSavedState.mAnchorPosition;
    this.mVisibleAnchorPosition = paramSavedState.mVisibleAnchorPosition;
    this.mSpanOffsets = paramSavedState.mSpanOffsets;
    this.mSpanLookupSize = paramSavedState.mSpanLookupSize;
    this.mSpanLookup = paramSavedState.mSpanLookup;
    this.mReverseLayout = paramSavedState.mReverseLayout;
    this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
    this.mLastLayoutRTL = paramSavedState.mLastLayoutRTL;
    this.mFullSpanItems = paramSavedState.mFullSpanItems;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  void invalidateAnchorPositionInfo()
  {
    this.mSpanOffsets = null;
    this.mSpanOffsetsSize = 0;
    this.mAnchorPosition = -1;
    this.mVisibleAnchorPosition = -1;
  }
  
  void invalidateSpanInfo()
  {
    this.mSpanOffsets = null;
    this.mSpanOffsetsSize = 0;
    this.mSpanLookupSize = 0;
    this.mSpanLookup = null;
    this.mFullSpanItems = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.mAnchorPosition);
    paramParcel.writeInt(this.mVisibleAnchorPosition);
    paramParcel.writeInt(this.mSpanOffsetsSize);
    if (this.mSpanOffsetsSize > 0) {
      paramParcel.writeIntArray(this.mSpanOffsets);
    }
    paramParcel.writeInt(this.mSpanLookupSize);
    if (this.mSpanLookupSize > 0) {
      paramParcel.writeIntArray(this.mSpanLookup);
    }
    int j;
    int k;
    if (this.mReverseLayout)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.mAnchorLayoutFromEnd) {
        break label123;
      }
      k = i;
      label90:
      paramParcel.writeInt(k);
      if (!this.mLastLayoutRTL) {
        break label129;
      }
    }
    for (;;)
    {
      paramParcel.writeInt(i);
      paramParcel.writeList(this.mFullSpanItems);
      return;
      j = 0;
      break;
      label123:
      k = 0;
      break label90;
      label129:
      i = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */