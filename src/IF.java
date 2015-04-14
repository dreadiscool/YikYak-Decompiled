import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.Map;

public class IF
{
  private final Context a;
  private IM[] b;
  private Ka c;
  private Handler d;
  private IO e;
  private boolean f;
  private String g;
  private String h;
  private IH<IC> i;
  
  public IF(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null.");
    }
    this.a = paramContext.getApplicationContext();
  }
  
  public IC a()
  {
    if (this.b == null) {
      throw new IllegalStateException("Kits must not be null.");
    }
    if (this.c == null) {
      this.c = Ka.a();
    }
    if (this.d == null) {
      this.d = new Handler(Looper.getMainLooper());
    }
    if (this.e == null) {
      if (!this.f) {
        break label181;
      }
    }
    label181:
    for (this.e = new IB(3);; this.e = new IB())
    {
      if (this.h == null) {
        this.h = this.a.getPackageName();
      }
      if (this.i == null) {
        this.i = IH.d;
      }
      Map localMap = IC.a(Arrays.asList(this.b));
      Js localJs = new Js(this.a, this.h, this.g, localMap.values());
      return new IC(this.a, localMap, this.c, this.d, this.e, this.f, this.i, localJs);
    }
  }
  
  public IF a(IM... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("Kits must not be null.");
    }
    if (paramVarArgs.length == 0) {
      throw new IllegalArgumentException("Kits must not be empty.");
    }
    if (this.b != null) {
      throw new IllegalStateException("Kits already set.");
    }
    this.b = paramVarArgs;
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IF
 * JD-Core Version:    0.7.0.1
 */