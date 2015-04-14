package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

class SpinnerCompat$DropdownPopup$1
  implements AdapterView.OnItemClickListener
{
  SpinnerCompat$DropdownPopup$1(SpinnerCompat.DropdownPopup paramDropdownPopup, SpinnerCompat paramSpinnerCompat) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.this$1.this$0.setSelection(paramInt);
    if (this.this$1.this$0.mOnItemClickListener != null) {
      this.this$1.this$0.performItemClick(paramView, paramInt, SpinnerCompat.DropdownPopup.access$300(this.this$1).getItemId(paramInt));
    }
    this.this$1.dismiss();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerCompat.DropdownPopup.1
 * JD-Core Version:    0.7.0.1
 */