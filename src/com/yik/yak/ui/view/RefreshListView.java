package com.yik.yak.ui.view;

import EN;
import Hb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.yik.yak.ui.pullrefresh.PullRefreshLayout;

public class RefreshListView
  extends RelativeLayout
{
  protected LinearLayoutManager a;
  @InjectView(2131558505)
  protected ImageView noYaksImage;
  @InjectView(2131558802)
  protected PullRefreshLayout pullToRefreshLayout;
  @InjectView(2131558506)
  protected RecyclerView recyclerView;
  @InjectView(2131558504)
  protected ImageView refreshImage;
  
  public RefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    this.noYaksImage.setVisibility(8);
  }
  
  public void b()
  {
    this.noYaksImage.setVisibility(0);
  }
  
  public LinearLayoutManager c()
  {
    return this.a;
  }
  
  public PullRefreshLayout d()
  {
    return this.pullToRefreshLayout;
  }
  
  public RecyclerView e()
  {
    return this.recyclerView;
  }
  
  public boolean f()
  {
    return this.pullToRefreshLayout.a();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = new LinearLayoutManager(getContext());
    ButterKnife.inject(this, this);
    this.recyclerView.setLayoutManager(this.a);
  }
  
  public void setAdapter(EN<?, ?> paramEN)
  {
    this.recyclerView.setAdapter(paramEN);
  }
  
  public void setAnimationBackgroundColor(int paramInt)
  {
    this.pullToRefreshLayout.setAnimationBackgroundColor(paramInt);
  }
  
  public void setOnRefreshListener(Hb paramHb)
  {
    this.pullToRefreshLayout.setOnRefreshListener(paramHb);
  }
  
  public void setOnScrollListener(RecyclerView.OnScrollListener paramOnScrollListener)
  {
    this.recyclerView.setOnScrollListener(paramOnScrollListener);
  }
  
  public void setRefreshImage(int paramInt)
  {
    this.pullToRefreshLayout.setRefreshImage(getResources().getDrawable(paramInt));
  }
  
  public void setRefreshImage(Drawable paramDrawable)
  {
    this.pullToRefreshLayout.setRefreshImage(paramDrawable);
  }
  
  public void setRefreshImageDrawable(int paramInt)
  {
    this.refreshImage.setImageDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setRefreshImageDrawable(Drawable paramDrawable)
  {
    this.refreshImage.setImageDrawable(paramDrawable);
  }
  
  public void setRefreshStyle(int paramInt)
  {
    this.pullToRefreshLayout.setRefreshStyle(paramInt);
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.pullToRefreshLayout != null) {
      this.pullToRefreshLayout.setRefreshing(paramBoolean);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.RefreshListView
 * JD-Core Version:    0.7.0.1
 */