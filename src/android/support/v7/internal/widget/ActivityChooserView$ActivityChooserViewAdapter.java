package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ActivityChooserView$ActivityChooserViewAdapter
  extends BaseAdapter
{
  private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
  private static final int ITEM_VIEW_TYPE_COUNT = 3;
  private static final int ITEM_VIEW_TYPE_FOOTER = 1;
  public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
  public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 2147483647;
  private ActivityChooserModel mDataModel;
  private boolean mHighlightDefaultActivity;
  private int mMaxActivityCount = 4;
  private boolean mShowDefaultActivity;
  private boolean mShowFooterView;
  
  private ActivityChooserView$ActivityChooserViewAdapter(ActivityChooserView paramActivityChooserView) {}
  
  public int getActivityCount()
  {
    return this.mDataModel.getActivityCount();
  }
  
  public int getCount()
  {
    int i = this.mDataModel.getActivityCount();
    if ((!this.mShowDefaultActivity) && (this.mDataModel.getDefaultActivity() != null)) {
      i--;
    }
    int j = Math.min(i, this.mMaxActivityCount);
    if (this.mShowFooterView) {
      j++;
    }
    return j;
  }
  
  public ActivityChooserModel getDataModel()
  {
    return this.mDataModel;
  }
  
  public ResolveInfo getDefaultActivity()
  {
    return this.mDataModel.getDefaultActivity();
  }
  
  public int getHistorySize()
  {
    return this.mDataModel.getHistorySize();
  }
  
  public Object getItem(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    }
    for (Object localObject = null;; localObject = this.mDataModel.getActivity(paramInt))
    {
      return localObject;
      if ((!this.mShowDefaultActivity) && (this.mDataModel.getDefaultActivity() != null)) {
        paramInt++;
      }
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.mShowFooterView) && (paramInt == -1 + getCount())) {}
    for (int i = 1;; i = 0) {
      return i;
    }
  }
  
  public int getMaxActivityCount()
  {
    return this.mMaxActivityCount;
  }
  
  public boolean getShowDefaultActivity()
  {
    return this.mShowDefaultActivity;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      throw new IllegalArgumentException();
    case 1: 
      if ((paramView == null) || (paramView.getId() != 1))
      {
        paramView = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
        paramView.setId(1);
        ((TextView)paramView.findViewById(R.id.title)).setText(this.this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
      }
      break;
    }
    for (;;)
    {
      return paramView;
      if ((paramView == null) || (paramView.getId() != R.id.list_item)) {
        paramView = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      PackageManager localPackageManager = this.this$0.getContext().getPackageManager();
      ImageView localImageView = (ImageView)paramView.findViewById(R.id.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      localImageView.setImageDrawable(localResolveInfo.loadIcon(localPackageManager));
      ((TextView)paramView.findViewById(R.id.title)).setText(localResolveInfo.loadLabel(localPackageManager));
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public int measureContentWidth()
  {
    int i = 0;
    int j = this.mMaxActivityCount;
    this.mMaxActivityCount = 2147483647;
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    int n = getCount();
    View localView = null;
    int i1 = 0;
    while (i < n)
    {
      localView = getView(i, localView, null);
      localView.measure(k, m);
      i1 = Math.max(i1, localView.getMeasuredWidth());
      i++;
    }
    this.mMaxActivityCount = j;
    return i1;
  }
  
  public void setDataModel(ActivityChooserModel paramActivityChooserModel)
  {
    ActivityChooserModel localActivityChooserModel = ActivityChooserView.access$000(this.this$0).getDataModel();
    if ((localActivityChooserModel != null) && (this.this$0.isShown())) {
      localActivityChooserModel.unregisterObserver(ActivityChooserView.access$1100(this.this$0));
    }
    this.mDataModel = paramActivityChooserModel;
    if ((paramActivityChooserModel != null) && (this.this$0.isShown())) {
      paramActivityChooserModel.registerObserver(ActivityChooserView.access$1100(this.this$0));
    }
    notifyDataSetChanged();
  }
  
  public void setMaxActivityCount(int paramInt)
  {
    if (this.mMaxActivityCount != paramInt)
    {
      this.mMaxActivityCount = paramInt;
      notifyDataSetChanged();
    }
  }
  
  public void setShowDefaultActivity(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mShowDefaultActivity != paramBoolean1) || (this.mHighlightDefaultActivity != paramBoolean2))
    {
      this.mShowDefaultActivity = paramBoolean1;
      this.mHighlightDefaultActivity = paramBoolean2;
      notifyDataSetChanged();
    }
  }
  
  public void setShowFooterView(boolean paramBoolean)
  {
    if (this.mShowFooterView != paramBoolean)
    {
      this.mShowFooterView = paramBoolean;
      notifyDataSetChanged();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.ActivityChooserViewAdapter
 * JD-Core Version:    0.7.0.1
 */