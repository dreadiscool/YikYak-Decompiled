package com.yik.yak.ui.adapter;

import CK;
import android.content.Context;
import com.yik.yak.ui.adapter.viewholder.YakViewHolder;
import java.util.ArrayList;

public class YakRecyclerViewAdapter
  extends DoubleClickRecyclerViewAdapter<YakViewHolder, CK>
{
  boolean mShouldShowReplierIdentities = false;
  
  public YakRecyclerViewAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public YakRecyclerViewAdapter(Context paramContext, ArrayList<CK> paramArrayList)
  {
    super(paramContext, paramArrayList);
  }
  
  protected int getLayoutId()
  {
    return 2130903121;
  }
  
  protected Class getViewHolderClass()
  {
    return YakViewHolder.class;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.YakRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */