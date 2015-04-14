package com.facebook.widget;

import android.text.Editable;
import android.text.TextWatcher;

class PlacePickerFragment$SearchTextWatcher
  implements TextWatcher
{
  private PlacePickerFragment$SearchTextWatcher(PlacePickerFragment paramPlacePickerFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.this$0.onSearchBoxTextChanged(paramCharSequence.toString(), false);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PlacePickerFragment.SearchTextWatcher
 * JD-Core Version:    0.7.0.1
 */