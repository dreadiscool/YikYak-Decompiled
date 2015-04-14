package com.facebook.internal;

import java.util.Map;

public class Utility$FetchedAppSettings
{
  private Map<String, Map<String, Utility.DialogFeatureConfig>> dialogConfigMap;
  private String nuxContent;
  private boolean nuxEnabled;
  private boolean supportsImplicitLogging;
  
  private Utility$FetchedAppSettings(boolean paramBoolean1, String paramString, boolean paramBoolean2, Map<String, Map<String, Utility.DialogFeatureConfig>> paramMap)
  {
    this.supportsImplicitLogging = paramBoolean1;
    this.nuxContent = paramString;
    this.nuxEnabled = paramBoolean2;
    this.dialogConfigMap = paramMap;
  }
  
  public Map<String, Map<String, Utility.DialogFeatureConfig>> getDialogConfigurations()
  {
    return this.dialogConfigMap;
  }
  
  public String getNuxContent()
  {
    return this.nuxContent;
  }
  
  public boolean getNuxEnabled()
  {
    return this.nuxEnabled;
  }
  
  public boolean supportsImplicitLogging()
  {
    return this.supportsImplicitLogging;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.Utility.FetchedAppSettings
 * JD-Core Version:    0.7.0.1
 */