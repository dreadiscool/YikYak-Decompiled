import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;

public final class jG
{
  private final kg a;
  private jZ b;
  
  public jG(kg paramkg)
  {
    this.a = ((kg)hZ.a(paramkg));
  }
  
  public kg a()
  {
    return this.a;
  }
  
  /* Error */
  public final mc a(com.google.android.gms.maps.model.MarkerOptions paramMarkerOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	jG:a	Lkg;
    //   4: aload_1
    //   5: invokeinterface 29 2 0
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +16 -> 28
    //   15: new 31	mc
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 34	mc:<init>	(LmI;)V
    //   23: astore 4
    //   25: aload 4
    //   27: areturn
    //   28: aconst_null
    //   29: astore 4
    //   31: goto -6 -> 25
    //   34: astore_2
    //   35: new 36	md
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 39	md:<init>	(Landroid/os/RemoteException;)V
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	jG
    //   0	44	1	paramMarkerOptions	com.google.android.gms.maps.model.MarkerOptions
    //   34	6	2	localRemoteException	RemoteException
    //   10	10	3	localmI	mI
    //   23	7	4	localmc	mc
    // Exception table:
    //   from	to	target	type
    //   0	25	34	android/os/RemoteException
  }
  
  public final void a(jE paramjE)
  {
    try
    {
      this.a.a(paramjE.a());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public final void a(jI paramjI)
  {
    if (paramjI == null) {}
    try
    {
      this.a.a(null);
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
    this.a.a(new jH(this, paramjI));
  }
  
  public final CameraPosition b()
  {
    try
    {
      CameraPosition localCameraPosition = this.a.a();
      return localCameraPosition;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public final void c()
  {
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
  
  public final jZ d()
  {
    try
    {
      if (this.b == null) {
        this.b = new jZ(this.a.k());
      }
      jZ localjZ = this.b;
      return localjZ;
    }
    catch (RemoteException localRemoteException)
    {
      throw new md(localRemoteException);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jG
 * JD-Core Version:    0.7.0.1
 */