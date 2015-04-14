package com.google.android.gms.common.images;

import android.net.Uri;
import hV;

final class a$a
{
  public final Uri uri;
  
  public a$a(Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (!(paramObject instanceof a)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (this == paramObject) {
        bool = true;
      } else {
        bool = hV.a(((a)paramObject).uri, this.uri);
      }
    }
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.uri;
    return hV.a(arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.a.a
 * JD-Core Version:    0.7.0.1
 */