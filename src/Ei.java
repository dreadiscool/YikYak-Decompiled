import com.yik.yak.ui.activity.SendAYak;
import java.io.File;
import java.io.IOException;

public class Ei
  extends BX<SendAYak, Void, Void, Void>
{
  private boolean a = false;
  private File b;
  private String c;
  
  private Ei(SendAYak paramSendAYak)
  {
    super(paramSendAYak);
  }
  
  protected Void a(SendAYak paramSendAYak, Void... paramVarArgs)
  {
    if ((!this.a) || (this.b == null)) {}
    for (;;)
    {
      return null;
      try
      {
        zC localzC = zC.a(null, this.b);
        zz localzz = new zB().b(localzC).a(this.c).b();
        zF localzF = UrlHelper.a(false).a(localzz).a();
        if (!localzF.d()) {
          throw new IOException("Unexpected code " + localzF);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void a(SendAYak paramSendAYak, Void paramVoid)
  {
    SendAYak.a(paramSendAYak, Ii.b(SendAYak.f(paramSendAYak)));
    SendAYak.h(paramSendAYak);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    try
    {
      File localFile = new File(paramString3);
      if (localFile.exists())
      {
        Ii.a(paramString3);
        this.b = localFile;
        this.c = paramString1;
        this.a = true;
        bool = true;
      }
    }
    catch (Exception localException) {}
    return bool;
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     Ei

 * JD-Core Version:    0.7.0.1

 */