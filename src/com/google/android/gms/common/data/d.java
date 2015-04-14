package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import hV;
import hZ;

public abstract class d
{
  protected final DataHolder JG;
  protected int KZ;
  private int La;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this.JG = ((DataHolder)hZ.a(paramDataHolder));
    as(paramInt);
  }
  
  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.JG.a(paramString, this.KZ, this.La, paramCharArrayBuffer);
  }
  
  public boolean aQ(String paramString)
  {
    return this.JG.aQ(paramString);
  }
  
  protected Uri aR(String paramString)
  {
    return this.JG.g(paramString, this.KZ, this.La);
  }
  
  protected boolean aS(String paramString)
  {
    return this.JG.h(paramString, this.KZ, this.La);
  }
  
  protected void as(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.JG.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      hZ.a(bool);
      this.KZ = paramInt;
      this.La = this.JG.au(this.KZ);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof d))
    {
      d locald = (d)paramObject;
      if ((hV.a(Integer.valueOf(locald.KZ), Integer.valueOf(this.KZ))) && (hV.a(Integer.valueOf(locald.La), Integer.valueOf(this.La))) && (locald.JG == this.JG)) {
        bool = true;
      }
    }
    return bool;
  }
  
  protected int gW()
  {
    return this.KZ;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.JG.d(paramString, this.KZ, this.La);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.JG.f(paramString, this.KZ, this.La);
  }
  
  protected float getFloat(String paramString)
  {
    return this.JG.e(paramString, this.KZ, this.La);
  }
  
  protected int getInteger(String paramString)
  {
    return this.JG.b(paramString, this.KZ, this.La);
  }
  
  protected long getLong(String paramString)
  {
    return this.JG.a(paramString, this.KZ, this.La);
  }
  
  protected String getString(String paramString)
  {
    return this.JG.c(paramString, this.KZ, this.La);
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.KZ);
    arrayOfObject[1] = Integer.valueOf(this.La);
    arrayOfObject[2] = this.JG;
    return hV.a(arrayOfObject);
  }
  
  public boolean isDataValid()
  {
    if (!this.JG.isClosed()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.d
 * JD-Core Version:    0.7.0.1
 */