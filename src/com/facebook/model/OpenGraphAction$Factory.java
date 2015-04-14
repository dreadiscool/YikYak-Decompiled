package com.facebook.model;

public final class OpenGraphAction$Factory
{
  @Deprecated
  public static OpenGraphAction createForPost()
  {
    return createForPost(OpenGraphAction.class, null);
  }
  
  public static <T extends OpenGraphAction> T createForPost(Class<T> paramClass, String paramString)
  {
    OpenGraphAction localOpenGraphAction = (OpenGraphAction)GraphObject.Factory.create(paramClass);
    if (paramString != null) {
      localOpenGraphAction.setType(paramString);
    }
    return localOpenGraphAction;
  }
  
  public static OpenGraphAction createForPost(String paramString)
  {
    return createForPost(OpenGraphAction.class, paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.model.OpenGraphAction.Factory
 * JD-Core Version:    0.7.0.1
 */