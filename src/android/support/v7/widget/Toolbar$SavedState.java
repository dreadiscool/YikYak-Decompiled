package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class Toolbar$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Toolbar.SavedState.1();
  public int expandedMenuItemId;
  public boolean isOverflowOpen;
  
  public Toolbar$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.expandedMenuItemId = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isOverflowOpen = bool;
      return;
    }
  }
  
  public Toolbar$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.expandedMenuItemId);
    if (this.isOverflowOpen) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.Toolbar.SavedState
 * JD-Core Version:    0.7.0.1
 */