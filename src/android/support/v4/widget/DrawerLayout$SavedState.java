package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class DrawerLayout$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new DrawerLayout.SavedState.1();
  int lockModeLeft = 0;
  int lockModeRight = 0;
  int openDrawerGravity = 0;
  
  public DrawerLayout$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.openDrawerGravity = paramParcel.readInt();
  }
  
  public DrawerLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.openDrawerGravity);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.SavedState
 * JD-Core Version:    0.7.0.1
 */