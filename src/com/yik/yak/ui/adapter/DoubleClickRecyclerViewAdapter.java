package com.yik.yak.ui.adapter;

import CQ;
import EC;
import ED;
import EN;
import EV;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;

public abstract class DoubleClickRecyclerViewAdapter<T extends EV, K extends CQ>
  extends EN<T, K>
{
  public DoubleClickRecyclerViewAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public DoubleClickRecyclerViewAdapter(Context paramContext, ArrayList paramArrayList)
  {
    super(paramContext, paramArrayList);
  }
  
  protected void assignClickListener(T paramT, View paramView, int paramInt)
  {
    paramView.setOnClickListener(new EC(this, this, paramView, paramInt, paramT));
  }
  
  public void broadcastDoubleClick(T paramT, View paramView, int paramInt)
  {
    if ((!paramT.onDoubleClick(paramView)) && (getListener() != null) && ((getListener() instanceof ED))) {
      getListener();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.DoubleClickRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */