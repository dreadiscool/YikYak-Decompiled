package com.facebook.widget;

import android.os.Bundle;
import java.util.Collection;

abstract class PickerFragment$SelectionStrategy
{
  PickerFragment$SelectionStrategy(PickerFragment paramPickerFragment) {}
  
  abstract void clear();
  
  abstract Collection<String> getSelectedIds();
  
  abstract boolean isEmpty();
  
  abstract boolean isSelected(String paramString);
  
  abstract void readSelectionFromBundle(Bundle paramBundle, String paramString);
  
  abstract void saveSelectionToBundle(Bundle paramBundle, String paramString);
  
  abstract boolean shouldShowCheckBoxIfUnselected();
  
  abstract void toggleSelection(String paramString);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PickerFragment.SelectionStrategy
 * JD-Core Version:    0.7.0.1
 */