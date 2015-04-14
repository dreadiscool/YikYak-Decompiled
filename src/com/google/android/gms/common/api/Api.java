package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends Api.ApiOptions>
{
  private final Api.b<?, O> Jm;
  private final Api.c<?> Jn;
  private final ArrayList<Scope> Jo;
  
  public <C extends Api.a> Api(Api.b<C, O> paramb, Api.c<C> paramc, Scope... paramVarArgs)
  {
    this.Jm = paramb;
    this.Jn = paramc;
    this.Jo = new ArrayList(Arrays.asList(paramVarArgs));
  }
  
  public Api.b<?, O> gx()
  {
    return this.Jm;
  }
  
  public List<Scope> gy()
  {
    return this.Jo;
  }
  
  public Api.c<?> gz()
  {
    return this.Jn;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Api
 * JD-Core Version:    0.7.0.1
 */