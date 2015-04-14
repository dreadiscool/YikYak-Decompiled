package com.yik.yak.ui.adapter;

import CQ;
import EV;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class HeaderViewAdapter
  extends DoubleClickRecyclerViewAdapter<EV, CQ>
{
  protected static final int HEADER_TYPE = 1;
  private CQ headerData;
  
  public HeaderViewAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeaderViewAdapter(Context paramContext, ArrayList paramArrayList)
  {
    super(paramContext, paramArrayList);
  }
  
  public CQ getHeaderItem()
  {
    return this.headerData;
  }
  
  protected abstract int getHeaderLayoutId();
  
  protected abstract Class getHeaderViewHolderClass();
  
  protected Constructor<? extends EV> getHeaderViewHolderConstructor(Class<? extends EV> paramClass)
  {
    return super.getConstructor(paramClass);
  }
  
  public CQ getItem(int paramInt)
  {
    if (paramInt == 0) {}
    for (CQ localCQ = getHeaderItem();; localCQ = (CQ)super.getItem(paramInt - 1)) {
      return localCQ;
    }
  }
  
  public int getItemCount()
  {
    return 1 + super.getItemCount();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {}
    for (int i = 1;; i = super.getItemViewType(paramInt)) {
      return i;
    }
  }
  
  public void onBindViewHolder(EV paramEV, int paramInt)
  {
    if (paramInt == 0)
    {
      assignClickListener(paramEV, paramEV.getView(), paramInt);
      paramEV.bindView(getHeaderItem());
    }
    for (;;)
    {
      return;
      super.onBindViewHolder(paramEV, paramInt);
    }
  }
  
  public EV onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Constructor localConstructor;
    if (paramInt == 1) {
      localConstructor = getHeaderViewHolderConstructor(getHeaderViewHolderClass());
    }
    for (View localView = this.layoutInflater.inflate(getHeaderLayoutId(), paramViewGroup, false);; localView = this.layoutInflater.inflate(getLayoutId(), paramViewGroup, false))
    {
      try
      {
        EV localEV2 = buildViewHolderInstance(localConstructor, localView, paramInt);
        localEV1 = localEV2;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
          EV localEV1 = null;
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          localInvocationTargetException.printStackTrace();
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          localInstantiationException.printStackTrace();
        }
      }
      return localEV1;
      localConstructor = getConstructor(getViewHolderClass());
    }
  }
  
  public void setHeaderData(CQ paramCQ)
  {
    this.headerData = paramCQ;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.HeaderViewAdapter
 * JD-Core Version:    0.7.0.1
 */