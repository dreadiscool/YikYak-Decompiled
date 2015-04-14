package com.facebook.widget;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.facebook.FacebookException;

class PickerFragment$LoadingStrategy$1
  implements LoaderManager.LoaderCallbacks<SimpleGraphObjectCursor<T>>
{
  PickerFragment$LoadingStrategy$1(PickerFragment.LoadingStrategy paramLoadingStrategy) {}
  
  public Loader<SimpleGraphObjectCursor<T>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return this.this$1.onCreateLoader();
  }
  
  public void onLoadFinished(Loader<SimpleGraphObjectCursor<T>> paramLoader, SimpleGraphObjectCursor<T> paramSimpleGraphObjectCursor)
  {
    if (paramLoader != this.this$1.loader) {
      throw new FacebookException("Received callback for unknown loader.");
    }
    this.this$1.onLoadFinished((GraphObjectPagingLoader)paramLoader, paramSimpleGraphObjectCursor);
  }
  
  public void onLoaderReset(Loader<SimpleGraphObjectCursor<T>> paramLoader)
  {
    if (paramLoader != this.this$1.loader) {
      throw new FacebookException("Received callback for unknown loader.");
    }
    this.this$1.onLoadReset((GraphObjectPagingLoader)paramLoader);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PickerFragment.LoadingStrategy.1
 * JD-Core Version:    0.7.0.1
 */