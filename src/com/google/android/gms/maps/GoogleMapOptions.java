package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;
import fi;
import kJ;
import kK;
import ka;
import kb;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final ka CREATOR = new ka();
  private final int a;
  private Boolean b;
  private Boolean c;
  private int d = -1;
  private CameraPosition e;
  private Boolean f;
  private Boolean g;
  private Boolean h;
  private Boolean i;
  private Boolean j;
  private Boolean k;
  private Boolean l;
  private Boolean m;
  
  public GoogleMapOptions()
  {
    this.a = 1;
  }
  
  public GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, byte paramByte10)
  {
    this.a = paramInt1;
    this.b = kJ.a(paramByte1);
    this.c = kJ.a(paramByte2);
    this.d = paramInt2;
    this.e = paramCameraPosition;
    this.f = kJ.a(paramByte3);
    this.g = kJ.a(paramByte4);
    this.h = kJ.a(paramByte5);
    this.i = kJ.a(paramByte6);
    this.j = kJ.a(paramByte7);
    this.k = kJ.a(paramByte8);
    this.l = kJ.a(paramByte9);
    this.m = kJ.a(paramByte10);
  }
  
  public static GoogleMapOptions a(Context paramContext, AttributeSet paramAttributeSet)
  {
    GoogleMapOptions localGoogleMapOptions;
    if (paramAttributeSet == null) {
      localGoogleMapOptions = null;
    }
    for (;;)
    {
      return localGoogleMapOptions;
      TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, fi.MapAttrs);
      localGoogleMapOptions = new GoogleMapOptions();
      if (localTypedArray.hasValue(fi.MapAttrs_mapType)) {
        localGoogleMapOptions.a(localTypedArray.getInt(fi.MapAttrs_mapType, -1));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_zOrderOnTop)) {
        localGoogleMapOptions.a(localTypedArray.getBoolean(fi.MapAttrs_zOrderOnTop, false));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_useViewLifecycle)) {
        localGoogleMapOptions.b(localTypedArray.getBoolean(fi.MapAttrs_useViewLifecycle, false));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_uiCompass)) {
        localGoogleMapOptions.d(localTypedArray.getBoolean(fi.MapAttrs_uiCompass, true));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_uiRotateGestures)) {
        localGoogleMapOptions.h(localTypedArray.getBoolean(fi.MapAttrs_uiRotateGestures, true));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_uiScrollGestures)) {
        localGoogleMapOptions.e(localTypedArray.getBoolean(fi.MapAttrs_uiScrollGestures, true));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_uiTiltGestures)) {
        localGoogleMapOptions.g(localTypedArray.getBoolean(fi.MapAttrs_uiTiltGestures, true));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_uiZoomGestures)) {
        localGoogleMapOptions.f(localTypedArray.getBoolean(fi.MapAttrs_uiZoomGestures, true));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_uiZoomControls)) {
        localGoogleMapOptions.c(localTypedArray.getBoolean(fi.MapAttrs_uiZoomControls, true));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_liteMode)) {
        localGoogleMapOptions.i(localTypedArray.getBoolean(fi.MapAttrs_liteMode, false));
      }
      if (localTypedArray.hasValue(fi.MapAttrs_uiMapToolbar)) {
        localGoogleMapOptions.j(localTypedArray.getBoolean(fi.MapAttrs_uiMapToolbar, true));
      }
      localGoogleMapOptions.a(CameraPosition.a(paramContext, paramAttributeSet));
      localTypedArray.recycle();
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public GoogleMapOptions a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public GoogleMapOptions a(CameraPosition paramCameraPosition)
  {
    this.e = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions a(boolean paramBoolean)
  {
    this.b = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte b()
  {
    return kJ.a(this.b);
  }
  
  public GoogleMapOptions b(boolean paramBoolean)
  {
    this.c = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte c()
  {
    return kJ.a(this.c);
  }
  
  public GoogleMapOptions c(boolean paramBoolean)
  {
    this.f = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte d()
  {
    return kJ.a(this.f);
  }
  
  public GoogleMapOptions d(boolean paramBoolean)
  {
    this.g = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte e()
  {
    return kJ.a(this.g);
  }
  
  public GoogleMapOptions e(boolean paramBoolean)
  {
    this.h = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte f()
  {
    return kJ.a(this.h);
  }
  
  public GoogleMapOptions f(boolean paramBoolean)
  {
    this.i = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte g()
  {
    return kJ.a(this.i);
  }
  
  public GoogleMapOptions g(boolean paramBoolean)
  {
    this.j = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte h()
  {
    return kJ.a(this.j);
  }
  
  public GoogleMapOptions h(boolean paramBoolean)
  {
    this.k = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte i()
  {
    return kJ.a(this.k);
  }
  
  public GoogleMapOptions i(boolean paramBoolean)
  {
    this.l = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte j()
  {
    return kJ.a(this.l);
  }
  
  public GoogleMapOptions j(boolean paramBoolean)
  {
    this.m = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public byte k()
  {
    return kJ.a(this.m);
  }
  
  public int l()
  {
    return this.d;
  }
  
  public CameraPosition m()
  {
    return this.e;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      kb.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      ka.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.GoogleMapOptions
 * JD-Core Version:    0.7.0.1
 */