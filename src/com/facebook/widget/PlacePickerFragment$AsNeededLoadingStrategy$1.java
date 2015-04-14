package com.facebook.widget;

class PlacePickerFragment$AsNeededLoadingStrategy$1
  implements GraphObjectAdapter.DataNeededListener
{
  PlacePickerFragment$AsNeededLoadingStrategy$1(PlacePickerFragment.AsNeededLoadingStrategy paramAsNeededLoadingStrategy) {}
  
  public void onDataNeeded()
  {
    if (!this.this$1.loader.isLoading()) {
      this.this$1.loader.followNextLink();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PlacePickerFragment.AsNeededLoadingStrategy.1
 * JD-Core Version:    0.7.0.1
 */