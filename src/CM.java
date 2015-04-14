import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationRequest;
import com.yik.yak.YikYak;
import com.yik.yak.data.models.YakkerLocation;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;
import java.util.UUID;

public class CM
  implements LocationListener, ju
{
  private static CM a;
  private String b;
  private boolean c = false;
  private boolean d;
  private Handler.Callback e;
  private GoogleApiClient.OnConnectionFailedListener f = new CN(this);
  private Context g;
  private GoogleApiClient h;
  private Location i;
  private GoogleApiClient.ConnectionCallbacks j = new CO(this);
  private LocationRequest k;
  private YakkerLocation l = null;
  
  private CM(Context paramContext)
  {
    this.g = paramContext;
    j();
  }
  
  public static CM a()
  {
    try
    {
      CM localCM = a;
      return localCM;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static CM a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new CM(paramContext);
      }
      CM localCM = a;
      return localCM;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private GoogleApiClient k()
  {
    return new GoogleApiClient.Builder(this.g).addApi(jv.a).addConnectionCallbacks(this.j).addOnConnectionFailedListener(this.f).build();
  }
  
  public void a(Handler.Callback paramCallback)
  {
    if (this.h == null) {
      this.h = k();
    }
    this.e = paramCallback;
    if (!this.h.isConnected()) {
      this.h.connect();
    }
    for (;;)
    {
      return;
      if (this.e != null)
      {
        Message localMessage = new Message();
        localMessage.arg1 = 1;
        this.e.handleMessage(localMessage);
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    String str = Ik.a(this.g, "reported." + paramString1.toLowerCase());
    if (str == null) {
      str = "";
    }
    return str.contains(paramString2);
  }
  
  public String b()
  {
    return ApplicationConfig.getYakkerID();
  }
  
  public void b(Handler.Callback paramCallback)
  {
    String str1 = e();
    YakkerLocation localYakkerLocation = f();
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("userID", str1);
    localTreeMap.put("lat", localYakkerLocation.getLatitude());
    localTreeMap.put("long", localYakkerLocation.getLongitude());
    localTreeMap.put("deviceID", e());
    localTreeMap.put("token", this.b);
    String str2 = Im.a(CR.f(), "registerUser", localTreeMap, localYakkerLocation);
    zz localzz = new zB().a(str2).b();
    Im.a(true).a(localzz).a(new CP(this, paramCallback, str1));
  }
  
  public void b(String paramString1, String paramString2)
  {
    try
    {
      this.l = new YakkerLocation("C");
      this.l.setLatitude(Double.parseDouble(paramString1));
      this.l.setLongitude(Double.parseDouble(paramString2));
      this.l.setAccuracy(0.0F);
      this.d = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.d = false;
      }
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    String str1 = Ik.a(this.g, "reported." + paramString1.toLowerCase());
    if (str1 == null) {
      str1 = "";
    }
    if (!str1.contains(paramString2))
    {
      String str2 = str1 + paramString2 + ",";
      Ik.a(this.g, str2, "reported." + paramString1.toLowerCase());
    }
  }
  
  public boolean c()
  {
    try
    {
      boolean bool2 = ((LocationManager)this.g.getSystemService("location")).isProviderEnabled("network");
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean d()
  {
    for (;;)
    {
      try
      {
        LocationManager localLocationManager = (LocationManager)this.g.getSystemService("location");
        if (!localLocationManager.isProviderEnabled("gps"))
        {
          boolean bool2 = localLocationManager.isProviderEnabled("network");
          if (!bool2) {
            continue;
          }
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        boolean bool1 = false;
        continue;
      }
      return bool1;
      bool1 = false;
    }
  }
  
  public String e()
  {
    try
    {
      String str9 = ((TelephonyManager)this.g.getSystemService("phone")).getDeviceId();
      str1 = str9;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str8;
        label43:
        Class localClass;
        Class[] arrayOfClass;
        Method localMethod;
        Object[] arrayOfObject;
        String str7;
        label113:
        String str6;
        label138:
        label224:
        str1 = "";
      }
    }
    try
    {
      str8 = ((TelephonyManager)this.g.getSystemService("phone")).getSimSerialNumber();
      str2 = str8;
    }
    catch (Exception localException2)
    {
      str2 = "";
      break label43;
    }
    try
    {
      this.b = CR.g();
      localClass = Class.forName("android.os.SystemProperties");
      arrayOfClass = new Class[1];
      arrayOfClass[0] = String.class;
      localMethod = localClass.getMethod("get", arrayOfClass);
      arrayOfObject = new Object[1];
      arrayOfObject[0] = "ro.serialno";
      str7 = (String)localMethod.invoke(localClass, arrayOfObject);
      str3 = str7;
    }
    catch (Exception localException3)
    {
      str3 = "";
      break label113;
    }
    try
    {
      str6 = ((WifiManager)this.g.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      str4 = str6;
    }
    catch (Exception localException4)
    {
      str4 = "";
      break label138;
      str5 = Ik.c(str1 + "." + str2 + "." + str4 + "." + str3);
      break label224;
    }
    Ip.a(str1 + "." + str2 + "." + str4 + "." + str3);
    if ((Ik.a(str1)) || (Ik.a(str3)) || (str1.equals("000000000000000")))
    {
      str5 = Ik.c(UUID.randomUUID().toString());
      return str5.substring(0, 6) + str5.substring(5, -1 + str5.length());
    }
  }
  
  public YakkerLocation f()
  {
    if ((this.d) && (this.l != null)) {}
    Object localObject;
    for (YakkerLocation localYakkerLocation = this.l;; localYakkerLocation = new YakkerLocation((Location)localObject))
    {
      return localYakkerLocation;
      localObject = null;
      if (d())
      {
        if (this.h == null) {
          this.h = k();
        }
        if (!this.h.isConnected()) {
          g();
        }
      }
      try
      {
        Location localLocation = jv.b.a(this.h);
        localObject = localLocation;
      }
      catch (Exception localException)
      {
        label78:
        break label78;
      }
      if (localObject == null) {
        localObject = this.i;
      }
      if (localObject == null)
      {
        localObject = new Location("null");
        ((Location)localObject).setLatitude(0.0D);
        ((Location)localObject).setLongitude(0.0D);
      }
      If.a().a((Location)localObject);
    }
  }
  
  public void g()
  {
    if (this.h == null) {
      this.h = k();
    }
    if (!this.h.isConnected()) {
      this.h.connect();
    }
  }
  
  public void h()
  {
    try
    {
      this.k = new LocationRequest();
      this.k.a(120000L);
      jv.b.a(this.h, this.k, this);
      label40:
      return;
    }
    catch (Exception localException)
    {
      break label40;
    }
  }
  
  public boolean i()
  {
    return this.c;
  }
  
  public void j()
  {
    int m = 0;
    this.c = false;
    try
    {
      Signature[] arrayOfSignature = this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 64).signatures;
      int n = arrayOfSignature.length;
      for (;;)
      {
        if (m < n)
        {
          Signature localSignature = arrayOfSignature[m];
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          localMessageDigest.update(localSignature.toByteArray());
          if (new BigInteger(1, localMessageDigest.digest()).toString(16).toUpperCase().startsWith("54")) {
            this.c = true;
          }
        }
        else
        {
          return;
        }
        m++;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
    }
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    if ((this.i == null) || (paramLocation.distanceTo(this.i) > 5000.0F))
    {
      YakkerLocation localYakkerLocation = a().f();
      CZ.a(this.g, "https://content.yikyakapi.net/refreshers/locate?latitude=" + localYakkerLocation.c() + "&longitude=" + localYakkerLocation.d() + "&device=android&version=" + YikYak.getVersion());
    }
    this.i = paramLocation;
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CM

 * JD-Core Version:    0.7.0.1

 */