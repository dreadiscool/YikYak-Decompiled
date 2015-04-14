package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hV;
import hX;

public final class Status
  implements Result, SafeParcelable
{
  public static final StatusCreator CREATOR = new StatusCreator();
  public static final Status KA;
  public static final Status Kw = new Status(0);
  public static final Status Kx = new Status(14);
  public static final Status Ky = new Status(8);
  public static final Status Kz = new Status(15);
  private final int CK;
  private final int Iv;
  private final String KB;
  private final PendingIntent mPendingIntent;
  
  static
  {
    KA = new Status(16);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.CK = paramInt1;
    this.Iv = paramInt2;
    this.KB = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String gt()
  {
    if (this.KB != null) {}
    for (String str = this.KB;; str = CommonStatusCodes.getStatusCodeString(this.Iv)) {
      return str;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (!(paramObject instanceof Status)) {}
    for (;;)
    {
      return bool;
      Status localStatus = (Status)paramObject;
      if ((this.CK == localStatus.CK) && (this.Iv == localStatus.Iv) && (hV.a(this.KB, localStatus.KB)) && (hV.a(this.mPendingIntent, localStatus.mPendingIntent))) {
        bool = true;
      }
    }
  }
  
  PendingIntent gP()
  {
    return this.mPendingIntent;
  }
  
  @Deprecated
  public ConnectionResult gQ()
  {
    return new ConnectionResult(this.Iv, this.mPendingIntent);
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.Iv;
  }
  
  public String getStatusMessage()
  {
    return this.KB;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean hasResolution()
  {
    if (this.mPendingIntent != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.CK);
    arrayOfObject[1] = Integer.valueOf(this.Iv);
    arrayOfObject[2] = this.KB;
    arrayOfObject[3] = this.mPendingIntent;
    return hV.a(arrayOfObject);
  }
  
  public boolean isCanceled()
  {
    if (this.Iv == 16) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isInterrupted()
  {
    if (this.Iv == 14) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isSuccess()
  {
    if (this.Iv <= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
  {
    if (!hasResolution()) {}
    for (;;)
    {
      return;
      paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
    }
  }
  
  public String toString()
  {
    return hV.a(this).a("statusCode", gt()).a("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StatusCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.7.0.1
 */