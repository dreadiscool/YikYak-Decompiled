package com.yik.yak.ui.view;

import Iq;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class IdentityView
  extends RelativeLayout
{
  protected ImageView a;
  protected ImageView b;
  
  public IdentityView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IdentityView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IdentityView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ImageView a()
  {
    if (this.a == null) {
      this.a = ((ImageView)findViewById(2131558803));
    }
    return this.a;
  }
  
  public ImageView b()
  {
    if (this.b == null) {
      this.b = ((ImageView)findViewById(2131558804));
    }
    return this.b;
  }
  
  public void setUrlForBackground(String paramString)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    Iq.a(this, arrayOfObject);
    Picasso.with(getContext()).load(paramString).into(a());
  }
  
  public void setUrlForForeground(String paramString)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    Iq.a(this, arrayOfObject);
    Picasso.with(getContext()).load(paramString).into(b());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.view.IdentityView
 * JD-Core Version:    0.7.0.1
 */