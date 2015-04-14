package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;

public class RequestAsyncTask
  extends AsyncTask<Void, Void, List<Response>>
{
  private static final String TAG = RequestAsyncTask.class.getCanonicalName();
  private static Method executeOnExecutorMethod;
  private final HttpURLConnection connection;
  private Exception exception;
  private final RequestBatch requests;
  
  static
  {
    Method[] arrayOfMethod = AsyncTask.class.getMethods();
    int i = arrayOfMethod.length;
    for (int j = 0;; j++) {
      if (j < i)
      {
        Method localMethod = arrayOfMethod[j];
        if ("executeOnExecutor".equals(localMethod.getName()))
        {
          Class[] arrayOfClass = localMethod.getParameterTypes();
          if ((arrayOfClass.length == 2) && (arrayOfClass[0] == Executor.class) && (arrayOfClass[1].isArray())) {
            executeOnExecutorMethod = localMethod;
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public RequestAsyncTask(RequestBatch paramRequestBatch)
  {
    this(null, paramRequestBatch);
  }
  
  public RequestAsyncTask(HttpURLConnection paramHttpURLConnection, RequestBatch paramRequestBatch)
  {
    this.requests = paramRequestBatch;
    this.connection = paramHttpURLConnection;
  }
  
  public RequestAsyncTask(HttpURLConnection paramHttpURLConnection, Collection<Request> paramCollection)
  {
    this(paramHttpURLConnection, new RequestBatch(paramCollection));
  }
  
  public RequestAsyncTask(HttpURLConnection paramHttpURLConnection, Request... paramVarArgs)
  {
    this(paramHttpURLConnection, new RequestBatch(paramVarArgs));
  }
  
  public RequestAsyncTask(Collection<Request> paramCollection)
  {
    this(null, new RequestBatch(paramCollection));
  }
  
  public RequestAsyncTask(Request... paramVarArgs)
  {
    this(null, new RequestBatch(paramVarArgs));
  }
  
  protected List<Response> doInBackground(Void... paramVarArgs)
  {
    Object localObject;
    try
    {
      if (this.connection == null)
      {
        localObject = this.requests.executeAndWait();
      }
      else
      {
        List localList = Request.executeConnectionAndWait(this.connection, this.requests);
        localObject = localList;
      }
    }
    catch (Exception localException)
    {
      this.exception = localException;
      localObject = null;
    }
    return localObject;
  }
  
  RequestAsyncTask executeOnSettingsExecutor()
  {
    if (executeOnExecutorMethod != null) {}
    try
    {
      Method localMethod = executeOnExecutorMethod;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Settings.getExecutor();
      arrayOfObject[1] = null;
      localMethod.invoke(this, arrayOfObject);
      for (;;)
      {
        label38:
        return this;
        execute(new Void[0]);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label38;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label38;
    }
  }
  
  protected final Exception getException()
  {
    return this.exception;
  }
  
  protected final RequestBatch getRequests()
  {
    return this.requests;
  }
  
  protected void onPostExecute(List<Response> paramList)
  {
    super.onPostExecute(paramList);
    if (this.exception != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.exception.getMessage();
      String.format("onPostExecute: exception encountered during request: %s", arrayOfObject);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.requests.getCallbackHandler() == null) {
      this.requests.setCallbackHandler(new Handler());
    }
  }
  
  public String toString()
  {
    return "{RequestAsyncTask: " + " connection: " + this.connection + ", requests: " + this.requests + "}";
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.RequestAsyncTask
 * JD-Core Version:    0.7.0.1
 */