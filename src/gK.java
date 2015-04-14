class gK
  implements gj<fw>
{
  private final fw a = new fw();
  
  public void a(String paramString, int paramInt)
  {
    if ("ga_dispatchPeriod".equals(paramString)) {
      this.a.d = paramInt;
    }
    for (;;)
    {
      return;
      fA.d("int configuration name not recognized:  " + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ("ga_appName".equals(paramString1)) {
      this.a.a = paramString2;
    }
    for (;;)
    {
      return;
      if ("ga_appVersion".equals(paramString1)) {
        this.a.b = paramString2;
      } else if ("ga_logLevel".equals(paramString1)) {
        this.a.c = paramString2;
      } else {
        fA.d("string configuration name not recognized:  " + paramString1);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i;
    if ("ga_dryRun".equals(paramString))
    {
      fw localfw = this.a;
      if (paramBoolean)
      {
        i = 1;
        localfw.e = i;
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      fA.d("bool configuration name not recognized:  " + paramString);
    }
  }
  
  public fw b()
  {
    return this.a;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gK
 * JD-Core Version:    0.7.0.1
 */