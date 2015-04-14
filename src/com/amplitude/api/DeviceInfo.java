package com.amplitude.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class DeviceInfo
{
  public static final String TAG = "com.amplitude.api.DeviceInfo";
  private String advertisingId;
  private Context context;
  private String country;
  private boolean locationListening = true;
  
  public DeviceInfo(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private String getCountryFromLocale()
  {
    return Locale.getDefault().getCountry();
  }
  
  private String getCountryFromLocation()
  {
    if (!isLocationListening()) {}
    for (Object localObject = null;; localObject = null) {
      for (;;)
      {
        return localObject;
        Location localLocation = getMostRecentLocation();
        if (localLocation != null) {
          try
          {
            List localList = getGeocoder().getFromLocation(localLocation.getLatitude(), localLocation.getLongitude(), 1);
            if (localList != null)
            {
              Iterator localIterator = localList.iterator();
              while (localIterator.hasNext())
              {
                Address localAddress = (Address)localIterator.next();
                if (localAddress != null)
                {
                  String str = localAddress.getCountryCode();
                  localObject = str;
                }
              }
            }
          }
          catch (IOException localIOException) {}
        }
      }
    }
  }
  
  private String getCountryFromNetwork()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.context.getSystemService("phone");
    String str2;
    if (localTelephonyManager.getPhoneType() != 2)
    {
      str2 = localTelephonyManager.getNetworkCountryIso();
      if (str2 == null) {}
    }
    for (String str1 = str2.toUpperCase(Locale.US);; str1 = null) {
      return str1;
    }
  }
  
  private String getCountryUncached()
  {
    String str = getCountryFromLocation();
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      return str;
      str = getCountryFromNetwork();
      if (TextUtils.isEmpty(str)) {
        str = getCountryFromLocale();
      }
    }
  }
  
  public String generateUUID()
  {
    return UUID.randomUUID().toString();
  }
  
  public String getAdvertisingId()
  {
    if (this.advertisingId == null) {}
    String str;
    try
    {
      Class localClass = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Context.class;
      Method localMethod = localClass.getMethod("getAdvertisingIdInfo", arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.context;
      Object localObject = localMethod.invoke(null, arrayOfObject);
      if (((Boolean)localObject.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(localObject, new Object[0])).booleanValue())
      {
        str = null;
      }
      else
      {
        this.advertisingId = ((String)localObject.getClass().getMethod("getId", new Class[0]).invoke(localObject, new Object[0]));
        label128:
        str = this.advertisingId;
      }
    }
    catch (Exception localException)
    {
      break label128;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label128;
    }
    return str;
  }
  
  public String getBrand()
  {
    return Build.BRAND;
  }
  
  public String getCarrier()
  {
    return ((TelephonyManager)this.context.getSystemService("phone")).getNetworkOperatorName();
  }
  
  public String getCountry()
  {
    if (this.country == null) {
      this.country = getCountryUncached();
    }
    return this.country;
  }
  
  protected Geocoder getGeocoder()
  {
    return new Geocoder(this.context, Locale.ENGLISH);
  }
  
  public String getLanguage()
  {
    return Locale.getDefault().getLanguage();
  }
  
  public String getManufacturer()
  {
    return Build.MANUFACTURER;
  }
  
  public String getModel()
  {
    return Build.MODEL;
  }
  
  public Location getMostRecentLocation()
  {
    Object localObject1 = null;
    if (!isLocationListening()) {}
    LocationManager localLocationManager;
    List localList;
    do
    {
      do
      {
        return localObject1;
        localLocationManager = (LocationManager)this.context.getSystemService("location");
      } while (localLocationManager == null);
      localList = localLocationManager.getProviders(true);
    } while (localList == null);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      Location localLocation = localLocationManager.getLastKnownLocation((String)localIterator1.next());
      if (localLocation != null) {
        localArrayList.add(localLocation);
      }
    }
    Iterator localIterator2 = localArrayList.iterator();
    long l = -1L;
    Object localObject2 = null;
    label116:
    Object localObject3;
    if (localIterator2.hasNext())
    {
      localObject3 = (Location)localIterator2.next();
      if (((Location)localObject3).getTime() <= l) {
        break label169;
      }
      l = ((Location)localObject3).getTime();
    }
    for (;;)
    {
      localObject2 = localObject3;
      break label116;
      localObject1 = localObject2;
      break;
      label169:
      localObject3 = localObject2;
    }
  }
  
  public String getOSName()
  {
    return "android";
  }
  
  public String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public String getVersionName()
  {
    try
    {
      str = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        String str = null;
      }
    }
  }
  
  public boolean isLocationListening()
  {
    return this.locationListening;
  }
  
  public void setLocationListening(boolean paramBoolean)
  {
    this.locationListening = paramBoolean;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.amplitude.api.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */