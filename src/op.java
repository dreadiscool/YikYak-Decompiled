import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class op
{
  static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(paramString1, 0).edit();
    localEditor.putString(paramString2, paramString3);
    a(localEditor);
  }
  
  static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramEditor.apply();
    }
    for (;;)
    {
      return;
      new Thread(new oq(paramEditor)).start();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     op
 * JD-Core Version:    0.7.0.1
 */