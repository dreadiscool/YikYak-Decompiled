package android.support.v7.internal.text;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod
  implements TransformationMethod
{
  private Locale mLocale;
  
  public AllCapsTransformationMethod(Context paramContext)
  {
    this.mLocale = paramContext.getResources().getConfiguration().locale;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (paramCharSequence != null) {}
    for (String str = paramCharSequence.toString().toUpperCase(this.mLocale);; str = null) {
      return str;
    }
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.text.AllCapsTransformationMethod
 * JD-Core Version:    0.7.0.1
 */