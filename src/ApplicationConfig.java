import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.yik.yak.YikYak;

public class ApplicationConfig
{
  private static SharedPreferences sharedPreferences;
  
  // public static String a(String, String)
  public static String getString(String paramString1, String paramString2)
  {
    return ApplicationConfig.getSharedPreferences().getString(paramString1, paramString2);
  }
  
  // public static void a(String)
  public static void setYakkerId(String paramString)
  {
    ApplicationConfig.getPreferencesString("yakkerId", paramString);
  }
  
  // public static void a(boolean)
  public static void setAudibleNotifications(boolean paramBoolean)
  {
    ApplicationConfig.getPreferencesBoolean("audibleNotifications", paramBoolean);
  }
  
  // public static boolean a()
  public static boolean getAudibleNotifications()
  {
    return ApplicationConfig.getBoolean("audibleNotifications", true);
  }
  
  // public static boolean a(int)
  public static boolean hasReadMessage(int paramInt)
  {
    return ApplicationConfig.getBoolean("Message." + paramInt, false);
  }
  
  // public static boolean a(String, boolean)
  public static boolean getBoolean(String option, boolean defaultResponse)
  {
    return ApplicationConfig.getSharedPreferences().getBoolean(option, defaultResponse);
  }
  
  // public static String b()
  public static String getYakkerId()
  {
    return ApplicationConfig.getString("yakkerId", "");
  }
  
  // public static void b(int)
  public static void setMessageTrue(int paramInt)
  {
    b("Message." + paramInt, true);
  }
  
  // public static void b(String)
  public static void setHandle(String paramString)
  {
    ApplicationConfig.setPreferenceString("handle", paramString);
  }
  
  // *public static void b(String, String)
  public static void setPreferenceString(String paramString1, String paramString2)
  {
    ApplicationConfig.getSharedPreferences().edit().putString(paramString1, paramString2).commit();
  }
  
  // *public static void b(String, boolean)
  public static void setPreferenceBoolean(String paramString, boolean paramBoolean)
  {
    ApplicationConfig.getSharedPreferences().edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  // *public static void b(boolean)
  public static void setChannelStatus(boolean paramBoolean)
  {
    ApplicationConfig.setPreferenceBoolean("isChannelSet", paramBoolean);
  }
  
  // *public static void c(String)
  public static void setKarmaLevel(String paramString)
  {
    ApplicationConfig.setPreferenceBoolean("karma", paramString);
    If.a().a(Integer.parseInt(paramString));
  }
  
  public static void c(boolean paramBoolean)
  {
    b(5);
  }
  
  // *public static boolean c()
  public static boolean isChannelSet()
  {
    return ApplicationConfig.getBoolean("isChannelSet", false);
  }
  
  // *public static String d()
  public static String getOptionHandle()
  {
    return ApplicationConfig.getString("handle", "");
  }
  
  // *public static void d(String)
  public static void setAccessPin(String paramString)
  {
    ApplicationConfig.setPreferenceString("pin", paramString);
  }
  
  // *public static void d(boolean)
  public static void setPushNotificationsEnabled(boolean paramBoolean)
  {
    ApplicationConfig.setPreferenceBoolean("pushNotificationsEnabled", paramBoolean);
  }
  
  // *public static void e()
  public static String setKarmaTo100()
  {
    return ApplicationConfig.getString("karma", "100");
  }
  
  // *public static void e(String)
  public static void setVotingLayout(String paramString)
  {
    ApplicationConfig.setPreferenceString("votingLayout", paramString);
  }
  
  // *public static void e(boolean)
  public static void setSecureYakStatus(boolean paramBoolean)
  {
    ApplicationConfig.setPreferenceBoolean("secureMyYaks", paramBoolean);
  }
  
  // *public static int f()
  public static int getYakkerKarma()
  {
    int i = 100;
    try
    {
      i = Integer.valueOf(ApplicationConfig.getString("karma", "100")).intValue();
    }
    catch (Exception localException) { }
    return i;
  }
  
  // *public static void f(boolean)
  public static void setShowUnreadNotificationsOnly(boolean paramBoolean)
  {
    ApplicationConfig.setPreferenceBoolean("showUnreadNotificationsOnly", paramBoolean);
  }
  
  // *public static void g(boolean)
  public static void setDoubleTapToVote(boolean paramBoolean)
  {
    ApplicationConfig.setPreferenceBoolean("doubleTapToVote", paramBoolean);
  }
  
  public static boolean g()
  {
    return a(5);
  }
  
  // *public static String h()
  public static String getAccessPin()
  {
    return ApplicationConfig.getString("pin", "");
  }
  
  // *public static void h(boolean)
  public static void setUseAnalytics(boolean paramBoolean)
  {
    ApplicationConfig.setPreferenceBoolean("analytics", paramBoolean);
  }
  
  // *public static boolean i()
  public static boolean getPushNotificationsEnabled()
  {
    return ApplicationConfig.getBoolean("pushNotificationsEnabled", true);
  }
  
  // *public static boolean j()
  public static boolean getSecureYakStatus()
  {
    return ApplicationConfig.getBoolean("secureMyYaks", false);
  }
  
  // *public static boolean k()
  public static boolean getShowUnreadNotificationsOnly()
  {
    return ApplicationConfig.getBoolean("showUnreadNotificationsOnly", false);
  }
  
  // *public static boolean l()
  public static boolean getDoubleTapToVote()
  {
    return ApplicationConfig.getBoolean("doubleTapToVote", true);
  }
  
  // *public static String m()
  public static String getVotingLayout()
  {
    return ApplicationConfig.getString("votingLayout", "right");
  }
  
  // *public static boolean n()
  public static boolean getUseAnalytics()
  {
    return ApplicationConfig.getBoolean("analytics", true);
  }
  
  // public static SharedPreferences o()
  public static SharedPreferences getSharedPreferences()
  {
    if (sharedPreferences == null)
    {
      sharedPreferences = YikYak.getInstance().getSharedPreferences("YikYak", 0);
      if (b().isEmpty()) {
        sharedPreferences = YikYak.getInstance().getSharedPreferences("com.yik.yak_preferences", 0);
      }
    }
    return a;
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     BV

 * JD-Core Version:    0.7.0.1

 */