import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class Lf
{
  public final String a;
  public final int b;
  public final int c;
  public final int d;
  
  public Lf(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  public static Lf a(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        int i = Jg.l(paramContext);
        IC.g();
        new StringBuilder().append("App icon resource ID is ").append(i).toString();
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramContext.getResources(), i, localOptions);
        localLf = new Lf(paramString, i, localOptions.outWidth, localOptions.outHeight);
        return localLf;
      }
      catch (Exception localException)
      {
        IC.g();
      }
      Lf localLf = null;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lf
 * JD-Core Version:    0.7.0.1
 */