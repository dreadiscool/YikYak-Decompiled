package com.facebook.widget;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.Loader;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Response.PagingDirection;
import com.facebook.internal.CacheableRequestBatch;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObjectList;

class GraphObjectPagingLoader<T extends GraphObject>
  extends Loader<SimpleGraphObjectCursor<T>>
{
  private boolean appendResults = false;
  private Request currentRequest;
  private SimpleGraphObjectCursor<T> cursor;
  private final Class<T> graphObjectClass;
  private boolean loading = false;
  private Request nextRequest;
  private GraphObjectPagingLoader.OnErrorListener onErrorListener;
  private Request originalRequest;
  private boolean skipRoundtripIfCached;
  
  public GraphObjectPagingLoader(Context paramContext, Class<T> paramClass)
  {
    super(paramContext);
    this.graphObjectClass = paramClass;
  }
  
  private void addResults(Response paramResponse)
  {
    SimpleGraphObjectCursor localSimpleGraphObjectCursor;
    boolean bool;
    int i;
    if ((this.cursor == null) || (!this.appendResults))
    {
      localSimpleGraphObjectCursor = new SimpleGraphObjectCursor();
      GraphObjectPagingLoader.PagedResults localPagedResults = (GraphObjectPagingLoader.PagedResults)paramResponse.getGraphObjectAs(GraphObjectPagingLoader.PagedResults.class);
      bool = paramResponse.getIsFromCache();
      GraphObjectList localGraphObjectList = localPagedResults.getData().castToListOf(this.graphObjectClass);
      if (localGraphObjectList.size() <= 0) {
        break label156;
      }
      i = 1;
      label68:
      if (i != 0)
      {
        this.nextRequest = paramResponse.getRequestForPagedResults(Response.PagingDirection.NEXT);
        localSimpleGraphObjectCursor.addGraphObjects(localGraphObjectList, bool);
        if (this.nextRequest == null) {
          break label162;
        }
        localSimpleGraphObjectCursor.setMoreObjectsAvailable(true);
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        localSimpleGraphObjectCursor.setMoreObjectsAvailable(false);
        localSimpleGraphObjectCursor.setFromCache(bool);
        this.nextRequest = null;
      }
      if (!bool) {
        this.skipRoundtripIfCached = false;
      }
      deliverResult(localSimpleGraphObjectCursor);
      return;
      localSimpleGraphObjectCursor = new SimpleGraphObjectCursor(this.cursor);
      break;
      label156:
      i = 0;
      break label68;
      label162:
      localSimpleGraphObjectCursor.setMoreObjectsAvailable(false);
    }
  }
  
  private CacheableRequestBatch putRequestIntoBatch(Request paramRequest, boolean paramBoolean)
  {
    boolean bool = true;
    Request[] arrayOfRequest = new Request[bool];
    arrayOfRequest[0] = paramRequest;
    CacheableRequestBatch localCacheableRequestBatch = new CacheableRequestBatch(arrayOfRequest);
    if (!paramBoolean) {}
    for (;;)
    {
      localCacheableRequestBatch.setForceRoundTrip(bool);
      return localCacheableRequestBatch;
      bool = false;
    }
  }
  
  private void requestCompleted(Response paramResponse)
  {
    if (paramResponse.getRequest() != this.currentRequest) {}
    for (;;)
    {
      return;
      this.loading = false;
      this.currentRequest = null;
      FacebookRequestError localFacebookRequestError = paramResponse.getError();
      if (localFacebookRequestError == null) {}
      for (FacebookException localFacebookException = null;; localFacebookException = localFacebookRequestError.getException())
      {
        if ((paramResponse.getGraphObject() == null) && (localFacebookException == null)) {
          localFacebookException = new FacebookException("GraphObjectPagingLoader received neither a result nor an error.");
        }
        if (localFacebookException == null) {
          break label92;
        }
        this.nextRequest = null;
        if (this.onErrorListener == null) {
          break;
        }
        this.onErrorListener.onError(localFacebookException, this);
        break;
      }
      label92:
      addResults(paramResponse);
    }
  }
  
  private void startLoading(Request paramRequest, boolean paramBoolean, long paramLong)
  {
    this.skipRoundtripIfCached = paramBoolean;
    this.appendResults = false;
    this.nextRequest = null;
    this.currentRequest = paramRequest;
    this.currentRequest.setCallback(new GraphObjectPagingLoader.2(this));
    this.loading = true;
    GraphObjectPagingLoader.3 local3 = new GraphObjectPagingLoader.3(this, putRequestIntoBatch(paramRequest, paramBoolean));
    if (paramLong == 0L) {
      local3.run();
    }
    for (;;)
    {
      return;
      new Handler().postDelayed(local3, paramLong);
    }
  }
  
  public void clearResults()
  {
    this.nextRequest = null;
    this.originalRequest = null;
    this.currentRequest = null;
    deliverResult(null);
  }
  
  public void deliverResult(SimpleGraphObjectCursor<T> paramSimpleGraphObjectCursor)
  {
    SimpleGraphObjectCursor localSimpleGraphObjectCursor = this.cursor;
    this.cursor = paramSimpleGraphObjectCursor;
    if (isStarted())
    {
      super.deliverResult(paramSimpleGraphObjectCursor);
      if ((localSimpleGraphObjectCursor != null) && (localSimpleGraphObjectCursor != paramSimpleGraphObjectCursor) && (!localSimpleGraphObjectCursor.isClosed())) {
        localSimpleGraphObjectCursor.close();
      }
    }
  }
  
  public void followNextLink()
  {
    if (this.nextRequest != null)
    {
      this.appendResults = true;
      this.currentRequest = this.nextRequest;
      this.currentRequest.setCallback(new GraphObjectPagingLoader.1(this));
      this.loading = true;
      Request.executeBatchAsync(putRequestIntoBatch(this.currentRequest, this.skipRoundtripIfCached));
    }
  }
  
  public SimpleGraphObjectCursor<T> getCursor()
  {
    return this.cursor;
  }
  
  public GraphObjectPagingLoader.OnErrorListener getOnErrorListener()
  {
    return this.onErrorListener;
  }
  
  public boolean isLoading()
  {
    return this.loading;
  }
  
  protected void onStartLoading()
  {
    super.onStartLoading();
    if (this.cursor != null) {
      deliverResult(this.cursor);
    }
  }
  
  public void refreshOriginalRequest(long paramLong)
  {
    if (this.originalRequest == null) {
      throw new FacebookException("refreshOriginalRequest may not be called until after startLoading has been called.");
    }
    startLoading(this.originalRequest, false, paramLong);
  }
  
  public void setOnErrorListener(GraphObjectPagingLoader.OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  public void startLoading(Request paramRequest, boolean paramBoolean)
  {
    this.originalRequest = paramRequest;
    startLoading(paramRequest, paramBoolean, 0L);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.GraphObjectPagingLoader
 * JD-Core Version:    0.7.0.1
 */