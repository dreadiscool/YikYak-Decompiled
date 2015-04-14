package com.facebook.widget;

import com.facebook.FacebookException;

class PickerFragment$LoadingStrategy$2
  implements GraphObjectPagingLoader.OnErrorListener
{
  PickerFragment$LoadingStrategy$2(PickerFragment.LoadingStrategy paramLoadingStrategy) {}
  
  public void onError(FacebookException paramFacebookException, GraphObjectPagingLoader<?> paramGraphObjectPagingLoader)
  {
    this.this$1.this$0.hideActivityCircle();
    if (PickerFragment.access$500(this.this$1.this$0) != null) {
      PickerFragment.access$500(this.this$1.this$0).onError(this.this$1.this$0, paramFacebookException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PickerFragment.LoadingStrategy.2
 * JD-Core Version:    0.7.0.1
 */