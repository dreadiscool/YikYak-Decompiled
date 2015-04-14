package android.support.v7.internal.widget;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class AdapterViewCompat$AdapterContextMenuInfo
  implements ContextMenu.ContextMenuInfo
{
  public long id;
  public int position;
  public View targetView;
  
  public AdapterViewCompat$AdapterContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    this.targetView = paramView;
    this.position = paramInt;
    this.id = paramLong;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewCompat.AdapterContextMenuInfo
 * JD-Core Version:    0.7.0.1
 */