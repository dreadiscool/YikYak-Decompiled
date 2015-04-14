import android.os.RemoteException;

public final class jZ
{
  private final kE a;
  
  jZ(kE paramkE)
  {
    this.a = paramkE;
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.a.a(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      this.a.h(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jZ
 * JD-Core Version:    0.7.0.1
 */