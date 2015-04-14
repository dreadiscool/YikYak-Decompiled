package android.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ActionBarActivityDelegateBase$PanelFeatureState$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new ActionBarActivityDelegateBase.PanelFeatureState.SavedState.1();
  int featureId;
  boolean isOpen;
  Bundle menuState;
  
  private static SavedState readFromParcel(Parcel paramParcel)
  {
    int i = 1;
    SavedState localSavedState = new SavedState();
    localSavedState.featureId = paramParcel.readInt();
    if (paramParcel.readInt() == i) {}
    for (;;)
    {
      localSavedState.isOpen = i;
      if (localSavedState.isOpen) {
        localSavedState.menuState = paramParcel.readBundle();
      }
      return localSavedState;
      i = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.featureId);
    if (this.isOpen) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.isOpen) {
        paramParcel.writeBundle(this.menuState);
      }
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState.SavedState
 * JD-Core Version:    0.7.0.1
 */