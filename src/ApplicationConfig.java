import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.yik.yak.YikYak;

public class ApplicationConfig
{
  private static SharedPreferences a;
  
  public static String a(String paramString1, String paramString2)
  {
    return ApplicationConfig.getSharedPreferences().getString(paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    b("yakkerId", paramString);
  }
  
  // public static void a(boolean)
  public static void setAudibleNotifications(boolean paramBoolean)
  {
    b("audibleNotifications", paramBoolean);
  }
  
  // public static boolean a()
  public static boolean getAudibleNotifications()
  {
    return a("audibleNotifications", true);
  }
  
  public static boolean a(int paramInt)
  {
    return a("Message." + paramInt, false);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return ApplicationConfig.getSharedPreferences().getBoolean(paramString, paramBoolean);
  }
  
  // public static String b()
  public static String getYakkerID()
  {
    return a("yakkerId", "");
  }
  
  public static void b(int paramInt)
  {
    b("Message." + paramInt, true);
  }
  
  public static void b(String paramString)
  {
    b("handle", paramString);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    ApplicationConfig.getSharedPreferences().edit().putString(paramString1, paramString2).commit();
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    ApplicationConfig.getSharedPreferences().edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    b("isChannelSet", paramBoolean);
  }
  
  public static void c(String paramString)
  {
    b("karma", paramString);
    If.a().a(Integer.parseInt(paramString));
  }
  
  public static void c(boolean paramBoolean)
  {
    b(5);
  }
  
  public static boolean c()
  {
    return a("isChannelSet", false);
  }
  
  public static String d()
  {
    return a("handle", "");
  }
  
  public static void d(String paramString)
  {
    b("pin", paramString);
  }
  
  public static void d(boolean paramBoolean)
  {
    b("pushNotificationsEnabled", paramBoolean);
  }
  
  public static String e()
  {
    return a("karma", "100");
  }
  
  public static void e(String paramString)
  {
    b("votingLayout", paramString);
  }
  
  public static void e(boolean paramBoolean)
  {
    b("secureMyYaks", paramBoolean);
  }
  
  public static int f()
  {
    try
    {
      int j = Integer.valueOf(a("karma", "100")).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 100;
      }
    }
    return i;
  }
  
  public static void f(boolean paramBoolean)
  {
    b("showUnreadNotificationsOnly", paramBoolean);
  }
  
  public static void g(boolean paramBoolean)
  {
    b("doubleTapToVote", paramBoolean);
  }
  
  public static boolean g()
  {
    return a(5);
  }
  
  public static String h()
  {
    return a("pin", "");
  }
  
  public static void h(boolean paramBoolean)
  {
    b("analytics", paramBoolean);
  }
  
  public static boolean i()
  {
    return a("pushNotificationsEnabled", true);
  }
  
  public static boolean j()
  {
    return a("secureMyYaks", false);
  }
  
  public static boolean k()
  {
    return a("showUnreadNotificationsOnly", false);
  }
  
  public static boolean l()
  {
    return a("doubleTapToVote", true);
  }
  
  public static String m()
  {
    return a("votingLayout", "right");
  }
  
  public static boolean n()
  {
    return a("analytics", true);
  }
  
  // public static SharedPreferences o()
  public static SharedPreferences getSharedPreferences()
  {
    if (a == null)
    {
      a = YikYak.getInstance().getSharedPreferences("YikYak", 0);
      if (b().isEmpty()) {
        a = YikYak.getInstance().getSharedPreferences("com.yik.yak_preferences", 0);
      }
    }
    return a;
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     BV

 * JD-Core Version:    0.7.0.1

 */