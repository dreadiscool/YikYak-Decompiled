package com.yik.yak.ui.adapter;

import CK;
import EN;
import EV;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import com.yik.yak.ui.adapter.viewholder.YakDetailViewHolder;
import com.yik.yak.ui.adapter.viewholder.YakReplyViewHolder;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class YakDetailAdapter
  extends HeaderViewAdapter
{
  private Fragment mFragment;
  
  public YakDetailAdapter(Context paramContext, Fragment paramFragment)
  {
    this(paramContext, null, paramFragment);
  }
  
  public YakDetailAdapter(Context paramContext, ArrayList paramArrayList, Fragment paramFragment)
  {
    super(paramContext, paramArrayList);
    this.mFragment = paramFragment;
  }
  
  public void addLoadingYak()
  {
    CK localCK = new CK();
    localCK.a = true;
    localCK.G = false;
    getData().add(localCK);
    notifyDataSetChanged();
  }
  
  protected EV buildViewHolderInstance(Constructor<? extends EV> paramConstructor, View paramView, int paramInt)
  {
    Object[] arrayOfObject;
    if (paramInt == 1)
    {
      arrayOfObject = new Object[3];
      arrayOfObject[0] = this;
      arrayOfObject[1] = paramView;
      arrayOfObject[2] = this.mFragment;
    }
    for (EV localEV = (EV)paramConstructor.newInstance(arrayOfObject);; localEV = super.buildViewHolderInstance(paramConstructor, paramView, paramInt)) {
      return localEV;
    }
  }
  
  protected int getHeaderLayoutId()
  {
    return 2130903122;
  }
  
  protected Class getHeaderViewHolderClass()
  {
    return YakDetailViewHolder.class;
  }
  
  protected Constructor<? extends EV> getHeaderViewHolderConstructor(Class<? extends EV> paramClass)
  {
    try
    {
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = EN.class;
      arrayOfClass[1] = View.class;
      arrayOfClass[2] = Fragment.class;
      Constructor localConstructor2 = paramClass.getConstructor(arrayOfClass);
      localConstructor1 = localConstructor2;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
        Constructor localConstructor1 = null;
      }
    }
    return localConstructor1;
  }
  
  protected int getLayoutId()
  {
    return 2130903123;
  }
  
  protected Class getViewHolderClass()
  {
    return YakReplyViewHolder.class;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.adapter.YakDetailAdapter
 * JD-Core Version:    0.7.0.1
 */