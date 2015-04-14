package com.facebook.widget;

import com.facebook.FacebookException;

class PickerFragment$LoadingStrategy$3
  implements GraphObjectAdapter.OnErrorListener
{
  PickerFragment$LoadingStrategy$3(PickerFragment.LoadingStrategy paramLoadingStrategy) {}
  
  public void onError(GraphObjectAdapter<?> paramGraphObjectAdapter, FacebookException paramFacebookException)
  {
    if (PickerFragment.access$500(this.this$1.this$0) != null) {
      PickerFragment.access$500(this.this$1.this$0).onError(this.this$1.this$0, paramFacebookException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PickerFragment.LoadingStrategy.3
 * JD-Core Version:    0.7.0.1
 */