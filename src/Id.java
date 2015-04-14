import android.content.Context;
import android.os.Build.VERSION;

public final class Id
{
  public static HL a(Context paramContext, HS paramHS)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject;
    if (i < 5) {
      localObject = new HG(paramContext);
    }
    for (;;)
    {
      ((HL)localObject).a(paramHS);
      return localObject;
      if (i < 8) {
        localObject = new HI(paramContext);
      } else {
        localObject = new HJ(paramContext);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Id
 * JD-Core Version:    0.7.0.1
 */