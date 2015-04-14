package com.parse;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import k;

public class ParseQueryAdapter<T extends ParseObject>
  extends BaseAdapter
{
  private static final int VIEW_TYPE_ITEM = 0;
  private static final int VIEW_TYPE_NEXT_PAGE = 1;
  private boolean autoload = true;
  private Context context;
  private int currentPage = 0;
  private WeakHashMap<DataSetObserver, Void> dataSetObservers = new WeakHashMap();
  private boolean hasNextPage = true;
  private String imageKey;
  private WeakHashMap<ParseImageView, Void> imageViewSet = new WeakHashMap();
  private Integer itemResourceId;
  private List<List<T>> objectPages = new ArrayList();
  private List<T> objects = new ArrayList();
  private int objectsPerPage = 25;
  private List<ParseQueryAdapter.OnQueryLoadListener<T>> onQueryLoadListeners = new ArrayList();
  private boolean paginationEnabled = true;
  private Drawable placeholder;
  private ParseQueryAdapter.QueryFactory<T> queryFactory;
  private String textKey;
  
  public ParseQueryAdapter(Context paramContext, ParseQueryAdapter.QueryFactory<T> paramQueryFactory)
  {
    this(paramContext, paramQueryFactory, null);
  }
  
  public ParseQueryAdapter(Context paramContext, ParseQueryAdapter.QueryFactory<T> paramQueryFactory, int paramInt)
  {
    this(paramContext, paramQueryFactory, Integer.valueOf(paramInt));
  }
  
  private ParseQueryAdapter(Context paramContext, ParseQueryAdapter.QueryFactory<T> paramQueryFactory, Integer paramInteger)
  {
    this.context = paramContext;
    this.queryFactory = paramQueryFactory;
    this.itemResourceId = paramInteger;
  }
  
  public ParseQueryAdapter(Context paramContext, Class<? extends ParseObject> paramClass)
  {
    this(paramContext, ParseObject.getClassName(paramClass));
  }
  
  public ParseQueryAdapter(Context paramContext, Class<? extends ParseObject> paramClass, int paramInt)
  {
    this(paramContext, ParseObject.getClassName(paramClass), paramInt);
  }
  
  public ParseQueryAdapter(Context paramContext, String paramString)
  {
    this(paramContext, new ParseQueryAdapter.1(paramString));
    if (paramString == null) {
      throw new RuntimeException("You need to specify a className for the ParseQueryAdapter");
    }
  }
  
  public ParseQueryAdapter(Context paramContext, String paramString, int paramInt)
  {
    this(paramContext, new ParseQueryAdapter.2(paramString), paramInt);
    if (paramString == null) {
      throw new RuntimeException("You need to specify a className for the ParseQueryAdapter");
    }
  }
  
  private View getDefaultView(Context paramContext)
  {
    Object localObject;
    if (this.itemResourceId != null) {
      localObject = View.inflate(paramContext, this.itemResourceId.intValue(), null);
    }
    for (;;)
    {
      return localObject;
      localObject = new LinearLayout(paramContext);
      ((LinearLayout)localObject).setPadding(8, 4, 8, 4);
      ParseImageView localParseImageView = new ParseImageView(paramContext);
      localParseImageView.setId(16908294);
      localParseImageView.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
      ((LinearLayout)localObject).addView(localParseImageView);
      TextView localTextView = new TextView(paramContext);
      localTextView.setId(16908308);
      localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localTextView.setPadding(8, 0, 0, 0);
      ((LinearLayout)localObject).addView(localTextView);
    }
  }
  
  private int getPaginationCellRow()
  {
    return this.objects.size();
  }
  
  private void loadObjects(int paramInt, boolean paramBoolean)
  {
    ParseQuery localParseQuery = this.queryFactory.create();
    if ((this.objectsPerPage > 0) && (this.paginationEnabled)) {
      setPageOnQuery(paramInt, localParseQuery);
    }
    notifyOnLoadingListeners();
    if (paramInt >= this.objectPages.size()) {
      this.objectPages.add(paramInt, new ArrayList());
    }
    localParseQuery.findInBackground(new ParseQueryAdapter.3(this, localParseQuery, paramBoolean, new k(Boolean.valueOf(true)), paramInt));
  }
  
  private void notifyOnLoadedListeners(List<T> paramList, Exception paramException)
  {
    Iterator localIterator = this.onQueryLoadListeners.iterator();
    while (localIterator.hasNext()) {
      ((ParseQueryAdapter.OnQueryLoadListener)localIterator.next()).onLoaded(paramList, paramException);
    }
  }
  
  private void notifyOnLoadingListeners()
  {
    Iterator localIterator = this.onQueryLoadListeners.iterator();
    while (localIterator.hasNext()) {
      ((ParseQueryAdapter.OnQueryLoadListener)localIterator.next()).onLoading();
    }
  }
  
  private boolean shouldShowPaginationCell()
  {
    if ((this.paginationEnabled) && (this.objects.size() > 0) && (this.hasNextPage)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void syncObjectsWithPages()
  {
    this.objects.clear();
    Iterator localIterator = this.objectPages.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      this.objects.addAll(localList);
    }
  }
  
  public void addOnQueryLoadListener(ParseQueryAdapter.OnQueryLoadListener<T> paramOnQueryLoadListener)
  {
    this.onQueryLoadListeners.add(paramOnQueryLoadListener);
  }
  
  public void clear()
  {
    this.objectPages.clear();
    syncObjectsWithPages();
    notifyDataSetChanged();
    this.currentPage = 0;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public int getCount()
  {
    int i = this.objects.size();
    if (shouldShowPaginationCell()) {
      i++;
    }
    return i;
  }
  
  public T getItem(int paramInt)
  {
    if (paramInt == getPaginationCellRow()) {}
    for (Object localObject = null;; localObject = (ParseObject)this.objects.get(paramInt)) {
      return localObject;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getItemView(T paramT, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = getDefaultView(this.context);
    }
    ParseImageView localParseImageView;
    for (;;)
    {
      try
      {
        localTextView = (TextView)paramView.findViewById(16908308);
        if (localTextView != null)
        {
          if (this.textKey == null) {
            localTextView.setText(paramT.getObjectId());
          }
        }
        else if (this.imageKey == null) {
          return paramView;
        }
        if (paramT.get(this.textKey) == null) {
          break label124;
        }
      }
      catch (ClassCastException localClassCastException1)
      {
        try
        {
          localParseImageView = (ParseImageView)paramView.findViewById(16908294);
          if (localParseImageView != null) {
            break;
          }
          throw new IllegalStateException("Your object views must have a ParseImageView whose id attribute is 'android.R.id.icon' if an imageKey is specified");
        }
        catch (ClassCastException localClassCastException2)
        {
          TextView localTextView;
          throw new IllegalStateException("Your object views must have a ParseImageView whose id attribute is 'android.R.id.icon'", localClassCastException2);
        }
        localClassCastException1 = localClassCastException1;
        throw new IllegalStateException("Your object views must have a TextView whose id attribute is 'android.R.id.text1'", localClassCastException1);
      }
      localTextView.setText(paramT.get(this.textKey).toString());
      continue;
      label124:
      localTextView.setText(null);
    }
    if (!this.imageViewSet.containsKey(localParseImageView)) {
      this.imageViewSet.put(localParseImageView, null);
    }
    localParseImageView.setPlaceholder(this.placeholder);
    localParseImageView.setParseFile((ParseFile)paramT.get(this.imageKey));
    localParseImageView.loadInBackground();
    return paramView;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getPaginationCellRow()) {}
    for (int i = 1;; i = 0) {
      return i;
    }
  }
  
  public View getNextPageView(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = getDefaultView(this.context);
    }
    ((TextView)paramView.findViewById(16908308)).setText("Load more...");
    return paramView;
  }
  
  public int getObjectsPerPage()
  {
    return this.objectsPerPage;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (getItemViewType(paramInt) == 1)
    {
      localView = getNextPageView(paramView, paramViewGroup);
      localView.setOnClickListener(new ParseQueryAdapter.4(this));
    }
    for (;;)
    {
      return localView;
      localView = getItemView(getItem(paramInt), paramView, paramViewGroup);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void loadNextPage()
  {
    loadObjects(1 + this.currentPage, false);
  }
  
  public void loadObjects()
  {
    loadObjects(0, true);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    super.registerDataSetObserver(paramDataSetObserver);
    this.dataSetObservers.put(paramDataSetObserver, null);
    if (this.autoload) {
      loadObjects();
    }
  }
  
  public void removeOnQueryLoadListener(ParseQueryAdapter.OnQueryLoadListener<T> paramOnQueryLoadListener)
  {
    this.onQueryLoadListeners.remove(paramOnQueryLoadListener);
  }
  
  public void setAutoload(boolean paramBoolean)
  {
    if (this.autoload == paramBoolean) {}
    for (;;)
    {
      return;
      this.autoload = paramBoolean;
      if ((this.autoload) && (!this.dataSetObservers.isEmpty()) && (this.objects.isEmpty())) {
        loadObjects();
      }
    }
  }
  
  public void setImageKey(String paramString)
  {
    this.imageKey = paramString;
  }
  
  public void setObjectsPerPage(int paramInt)
  {
    this.objectsPerPage = paramInt;
  }
  
  protected void setPageOnQuery(int paramInt, ParseQuery<T> paramParseQuery)
  {
    paramParseQuery.setLimit(1 + this.objectsPerPage);
    paramParseQuery.setSkip(paramInt * this.objectsPerPage);
  }
  
  public void setPaginationEnabled(boolean paramBoolean)
  {
    this.paginationEnabled = paramBoolean;
  }
  
  public void setPlaceholder(Drawable paramDrawable)
  {
    if (this.placeholder == paramDrawable) {}
    for (;;)
    {
      return;
      this.placeholder = paramDrawable;
      Iterator localIterator = this.imageViewSet.keySet().iterator();
      while (localIterator.hasNext())
      {
        ParseImageView localParseImageView = (ParseImageView)localIterator.next();
        if (localParseImageView != null) {
          localParseImageView.setPlaceholder(this.placeholder);
        }
      }
    }
  }
  
  public void setTextKey(String paramString)
  {
    this.textKey = paramString;
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    super.unregisterDataSetObserver(paramDataSetObserver);
    this.dataSetObservers.remove(paramDataSetObserver);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQueryAdapter
 * JD-Core Version:    0.7.0.1
 */