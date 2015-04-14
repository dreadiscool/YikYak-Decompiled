package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import fi;
import hV;
import hX;
import hZ;
import kK;
import mb;
import mh;
import mi;

public final class CameraPosition
  implements SafeParcelable
{
  public static final mh CREATOR = new mh();
  public final LatLng a;
  public final float b;
  public final float c;
  public final float d;
  private final int e;
  
  public CameraPosition(int paramInt, LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    hZ.a(paramLatLng, "null camera target");
    if ((0.0F <= paramFloat2) && (paramFloat2 <= 90.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.b(bool, "Tilt needs to be between 0 and 90 inclusive");
      this.e = paramInt;
      this.a = paramLatLng;
      this.b = paramFloat1;
      this.c = (paramFloat2 + 0.0F);
      if (paramFloat3 <= 0.0D) {
        paramFloat3 = 360.0F + paramFloat3 % 360.0F;
      }
      this.d = (paramFloat3 % 360.0F);
      return;
    }
  }
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramLatLng, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static CameraPosition a(Context paramContext, AttributeSet paramAttributeSet)
  {
    CameraPosition localCameraPosition;
    if (paramAttributeSet == null)
    {
      localCameraPosition = null;
      return localCameraPosition;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, fi.MapAttrs);
    if (localTypedArray.hasValue(fi.MapAttrs_cameraTargetLat)) {}
    for (float f1 = localTypedArray.getFloat(fi.MapAttrs_cameraTargetLat, 0.0F);; f1 = 0.0F)
    {
      if (localTypedArray.hasValue(fi.MapAttrs_cameraTargetLng)) {}
      for (float f2 = localTypedArray.getFloat(fi.MapAttrs_cameraTargetLng, 0.0F);; f2 = 0.0F)
      {
        LatLng localLatLng = new LatLng(f1, f2);
        mb localmb = b();
        localmb.a(localLatLng);
        if (localTypedArray.hasValue(fi.MapAttrs_cameraZoom)) {
          localmb.a(localTypedArray.getFloat(fi.MapAttrs_cameraZoom, 0.0F));
        }
        if (localTypedArray.hasValue(fi.MapAttrs_cameraBearing)) {
          localmb.c(localTypedArray.getFloat(fi.MapAttrs_cameraBearing, 0.0F));
        }
        if (localTypedArray.hasValue(fi.MapAttrs_cameraTilt)) {
          localmb.b(localTypedArray.getFloat(fi.MapAttrs_cameraTilt, 0.0F));
        }
        localCameraPosition = localmb.a();
        break;
      }
    }
  }
  
  public static mb b()
  {
    return new mb();
  }
  
  public int a()
  {
    return this.e;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (!(paramObject instanceof CameraPosition))
      {
        bool = false;
      }
      else
      {
        CameraPosition localCameraPosition = (CameraPosition)paramObject;
        if ((!this.a.equals(localCameraPosition.a)) || (Float.floatToIntBits(this.b) != Float.floatToIntBits(localCameraPosition.b)) || (Float.floatToIntBits(this.c) != Float.floatToIntBits(localCameraPosition.c)) || (Float.floatToIntBits(this.d) != Float.floatToIntBits(localCameraPosition.d))) {
          bool = false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = Float.valueOf(this.b);
    arrayOfObject[2] = Float.valueOf(this.c);
    arrayOfObject[3] = Float.valueOf(this.d);
    return hV.a(arrayOfObject);
  }
  
  public String toString()
  {
    return hV.a(this).a("target", this.a).a("zoom", Float.valueOf(this.b)).a("tilt", Float.valueOf(this.c)).a("bearing", Float.valueOf(this.d)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (kK.a()) {
      mi.a(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      mh.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */