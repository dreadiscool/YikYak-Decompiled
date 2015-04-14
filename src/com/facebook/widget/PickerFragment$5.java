package com.facebook.widget;

import android.view.View;
import android.view.View.OnClickListener;

class PickerFragment$5
  implements View.OnClickListener
{
  PickerFragment$5(PickerFragment paramPickerFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.logAppEvents(true);
    PickerFragment.access$202(this.this$0, true);
    if (PickerFragment.access$300(this.this$0) != null) {
      PickerFragment.access$300(this.this$0).onDoneButtonClicked(this.this$0);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PickerFragment.5
 * JD-Core Version:    0.7.0.1
 */