package android.support.v7.internal.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AdapterViewCompat$OnItemClickListenerWrapper
  implements AdapterView.OnItemClickListener
{
  private final AdapterViewCompat.OnItemClickListener mWrappedListener;
  
  public AdapterViewCompat$OnItemClickListenerWrapper(AdapterViewCompat paramAdapterViewCompat, AdapterViewCompat.OnItemClickListener paramOnItemClickListener)
  {
    this.mWrappedListener = paramOnItemClickListener;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mWrappedListener.onItemClick(this.this$0, paramView, paramInt, paramLong);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewCompat.OnItemClickListenerWrapper
 * JD-Core Version:    0.7.0.1
 */