package com.facebook.widget;

import com.facebook.model.GraphPlace;

class PlacePickerFragment$AsNeededLoadingStrategy
  extends PickerFragment<GraphPlace>.LoadingStrategy
{
  private PlacePickerFragment$AsNeededLoadingStrategy(PlacePickerFragment paramPlacePickerFragment)
  {
    super(paramPlacePickerFragment);
  }
  
  public void attach(GraphObjectAdapter<GraphPlace> paramGraphObjectAdapter)
  {
    super.attach(paramGraphObjectAdapter);
    this.adapter.setDataNeededListener(new PlacePickerFragment.AsNeededLoadingStrategy.1(this));
  }
  
  protected void onLoadFinished(GraphObjectPagingLoader<GraphPlace> paramGraphObjectPagingLoader, SimpleGraphObjectCursor<GraphPlace> paramSimpleGraphObjectCursor)
  {
    super.onLoadFinished(paramGraphObjectPagingLoader, paramSimpleGraphObjectCursor);
    if ((paramSimpleGraphObjectCursor == null) || (paramGraphObjectPagingLoader.isLoading())) {}
    do
    {
      return;
      this.this$0.hideActivityCircle();
    } while (!paramSimpleGraphObjectCursor.isFromCache());
    if (paramSimpleGraphObjectCursor.areMoreObjectsAvailable()) {}
    for (long l = 2000L;; l = 0L)
    {
      paramGraphObjectPagingLoader.refreshOriginalRequest(l);
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PlacePickerFragment.AsNeededLoadingStrategy
 * JD-Core Version:    0.7.0.1
 */