package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.internal.jg;
import hZ;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GoogleApiClient$Builder
{
  private String DZ;
  private Looper JF;
  private final Set<String> JH = new HashSet();
  private int JI;
  private View JJ;
  private String JK;
  private final Map<Api<?>, Api.ApiOptions> JL = new HashMap();
  private FragmentActivity JM;
  private int JN = -1;
  private GoogleApiClient.OnConnectionFailedListener JO;
  private final Set<GoogleApiClient.ConnectionCallbacks> JP = new HashSet();
  private final Set<GoogleApiClient.OnConnectionFailedListener> JQ = new HashSet();
  private final Context mContext;
  
  public GoogleApiClient$Builder(Context paramContext)
  {
    this.mContext = paramContext;
    this.JF = paramContext.getMainLooper();
    this.JK = paramContext.getPackageName();
  }
  
  public GoogleApiClient$Builder(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext);
    hZ.a(paramConnectionCallbacks, "Must provide a connected listener");
    this.JP.add(paramConnectionCallbacks);
    hZ.a(paramOnConnectionFailedListener, "Must provide a connection failed listener");
    this.JQ.add(paramOnConnectionFailedListener);
  }
  
  private GoogleApiClient gI()
  {
    g localg = g.a(this.JM);
    Object localObject = localg.an(this.JN);
    if (localObject == null) {
      localObject = new c(this.mContext.getApplicationContext(), this.JF, gH(), this.JL, this.JP, this.JQ, this.JN);
    }
    localg.a(this.JN, (GoogleApiClient)localObject, this.JO);
    return localObject;
  }
  
  public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> paramApi)
  {
    this.JL.put(paramApi, null);
    List localList = paramApi.gy();
    int i = localList.size();
    for (int j = 0; j < i; j++) {
      this.JH.add(((Scope)localList.get(j)).gO());
    }
    return this;
  }
  
  public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> paramApi, O paramO)
  {
    hZ.a(paramO, "Null options are not permitted for this Api");
    this.JL.put(paramApi, paramO);
    List localList = paramApi.gy();
    int i = localList.size();
    for (int j = 0; j < i; j++) {
      this.JH.add(((Scope)localList.get(j)).gO());
    }
    return this;
  }
  
  public Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.JP.add(paramConnectionCallbacks);
    return this;
  }
  
  public Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.JQ.add(paramOnConnectionFailedListener);
    return this;
  }
  
  public Builder addScope(Scope paramScope)
  {
    this.JH.add(paramScope.gO());
    return this;
  }
  
  public GoogleApiClient build()
  {
    boolean bool;
    if (!this.JL.isEmpty())
    {
      bool = true;
      hZ.b(bool, "must call addApi() to add at least one API");
      if (this.JN < 0) {
        break label39;
      }
    }
    label39:
    for (Object localObject = gI();; localObject = new c(this.mContext, this.JF, gH(), this.JL, this.JP, this.JQ, -1))
    {
      return localObject;
      bool = false;
      break;
    }
  }
  
  public Builder enableAutoManage(FragmentActivity paramFragmentActivity, int paramInt, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.b(bool, "clientId must be non-negative");
      this.JN = paramInt;
      this.JM = ((FragmentActivity)hZ.a(paramFragmentActivity, "Null activity is not permitted."));
      this.JO = paramOnConnectionFailedListener;
      return this;
    }
  }
  
  public jg gH()
  {
    return new jg(this.DZ, this.JH, this.JI, this.JJ, this.JK);
  }
  
  public Builder setAccountName(String paramString)
  {
    this.DZ = paramString;
    return this;
  }
  
  public Builder setGravityForPopups(int paramInt)
  {
    this.JI = paramInt;
    return this;
  }
  
  public Builder setHandler(Handler paramHandler)
  {
    hZ.a(paramHandler, "Handler must not be null");
    this.JF = paramHandler.getLooper();
    return this;
  }
  
  public Builder setViewForPopups(View paramView)
  {
    this.JJ = paramView;
    return this;
  }
  
  public Builder useDefaultAccount()
  {
    return setAccountName("<<default account>>");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.GoogleApiClient.Builder
 * JD-Core Version:    0.7.0.1
 */