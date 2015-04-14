import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashSet;

final class hI
{
  private final String b;
  private final hJ c;
  private final HashSet<hy<?>.hC> d;
  private int e;
  private boolean f;
  private IBinder g;
  private ComponentName h;
  
  public hI(hH paramhH, String paramString)
  {
    this.b = paramString;
    this.c = new hJ(this);
    this.d = new HashSet();
    this.e = 2;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.b).setPackage("com.google.android.gms");
    this.f = hH.b(this.a).bindService(localIntent, this.c, 129);
    if (this.f) {
      this.e = 3;
    }
    for (;;)
    {
      return;
      hH.b(this.a).unbindService(this.c);
    }
  }
  
  public void a(hy<?>.hC paramhy)
  {
    this.d.add(paramhy);
  }
  
  public void b()
  {
    hH.b(this.a).unbindService(this.c);
    this.f = false;
    this.e = 2;
  }
  
  public void b(hy<?>.hC paramhy)
  {
    this.d.remove(paramhy);
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean c(hy<?>.hC paramhy)
  {
    return this.d.contains(paramhy);
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.d.isEmpty();
  }
  
  public IBinder g()
  {
    return this.g;
  }
  
  public ComponentName h()
  {
    return this.h;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hI
 * JD-Core Version:    0.7.0.1
 */