package com.yik.yak.ui.adapter;

import Ct;
import EN;
import android.content.Context;
import com.yik.yak.ui.adapter.viewholder.ShareCardViewHolder;
import java.util.ArrayList;

public class ShareCardRecyclerViewAdapter
  extends EN<ShareCardViewHolder, Ct>
{
  public ShareCardRecyclerViewAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public ShareCardRecyclerViewAdapter(Context paramContext, ArrayList<Ct> paramArrayList)
  {
    super(paramContext, paramArrayList);
  }
  
  protected int getLayoutId()
  {
    return 2130903119;
  }
  
  protected Class getViewHolderClass()
  {
    return ShareCardViewHolder.class;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.ShareCardRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */