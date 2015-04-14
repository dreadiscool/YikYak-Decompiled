import android.content.Context;

class as
{
  private final Context a;
  private final Lg b;
  
  public as(Context paramContext, Lg paramLg)
  {
    this.a = paramContext;
    this.b = paramLg;
  }
  
  private String a(String paramString1, String paramString2)
  {
    return b(Jg.b(this.a, paramString1), paramString2);
  }
  
  private boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    if (a(paramString1)) {}
    for (;;)
    {
      return paramString2;
      paramString2 = paramString1;
    }
  }
  
  public String a()
  {
    return a("com.crashlytics.CrashSubmissionPromptTitle", this.b.a);
  }
  
  public String b()
  {
    return a("com.crashlytics.CrashSubmissionPromptMessage", this.b.b);
  }
  
  public String c()
  {
    return a("com.crashlytics.CrashSubmissionSendTitle", this.b.c);
  }
  
  public String d()
  {
    return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.b.g);
  }
  
  public String e()
  {
    return a("com.crashlytics.CrashSubmissionCancelTitle", this.b.e);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     as
 * JD-Core Version:    0.7.0.1
 */