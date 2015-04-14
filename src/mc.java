import android.os.RemoteException;

public final class mc
{
  private final mI a;
  
  public mc(mI parammI)
  {
    this.a = ((mI)hZ.a(parammI));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (!(paramObject instanceof mc)) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      try
      {
        boolean bool1 = this.a.a(((mc)paramObject).a);
        bool2 = bool1;
      }
      catch (RemoteException localRemoteException)
      {
        throw new md(localRemoteException);
      }
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = this.a.k();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     mc
 * JD-Core Version:    0.7.0.1
 */