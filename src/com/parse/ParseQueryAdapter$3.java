package com.parse;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;
import k;

class ParseQueryAdapter$3
  extends FindCallback<T>
{
  ParseQueryAdapter$3(ParseQueryAdapter paramParseQueryAdapter, ParseQuery paramParseQuery, boolean paramBoolean, k paramk, int paramInt) {}
  
  @SuppressLint({"ShowToast"})
  public void done(List<T> paramList, ParseException paramParseException)
  {
    if ((!OfflineStore.isEnabled()) && (this.val$query.getCachePolicy() == ParseQuery.CachePolicy.CACHE_ONLY) && (paramParseException != null) && (paramParseException.getCode() == 120)) {
      return;
    }
    if ((paramParseException != null) && ((paramParseException.getCode() == 100) || (paramParseException.getCode() != 120))) {
      ParseQueryAdapter.access$002(this.this$0, true);
    }
    while (paramList == null)
    {
      ParseQueryAdapter.access$600(this.this$0, paramList, paramParseException);
      break;
    }
    if ((this.val$shouldClear) && (((Boolean)this.val$firstCallBack.a()).booleanValue()))
    {
      ParseQueryAdapter.access$100(this.this$0).clear();
      ParseQueryAdapter.access$100(this.this$0).add(new ArrayList());
      ParseQueryAdapter.access$202(this.this$0, this.val$page);
      this.val$firstCallBack.a(Boolean.valueOf(false));
    }
    ParseQueryAdapter localParseQueryAdapter;
    if (this.val$page >= ParseQueryAdapter.access$200(this.this$0))
    {
      ParseQueryAdapter.access$202(this.this$0, this.val$page);
      localParseQueryAdapter = this.this$0;
      if (paramList.size() <= ParseQueryAdapter.access$300(this.this$0)) {
        break label308;
      }
    }
    label308:
    for (boolean bool = true;; bool = false)
    {
      ParseQueryAdapter.access$002(localParseQueryAdapter, bool);
      if ((ParseQueryAdapter.access$400(this.this$0)) && (paramList.size() > ParseQueryAdapter.access$300(this.this$0))) {
        paramList.remove(ParseQueryAdapter.access$300(this.this$0));
      }
      List localList = (List)ParseQueryAdapter.access$100(this.this$0).get(this.val$page);
      localList.clear();
      localList.addAll(paramList);
      ParseQueryAdapter.access$500(this.this$0);
      this.this$0.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQueryAdapter.3
 * JD-Core Version:    0.7.0.1
 */