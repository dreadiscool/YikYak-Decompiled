package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import jO;

public class MapView
  extends FrameLayout
{
  private final jO a;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.a = new jO(this, paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new jO(this, paramContext, GoogleMapOptions.a(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new jO(this, paramContext, GoogleMapOptions.a(paramContext, paramAttributeSet));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.MapView
 * JD-Core Version:    0.7.0.1
 */