package android.support.v4.view;

import android.widget.TextView;

class PagerTitleStripIcs
{
  public static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new PagerTitleStripIcs.SingleLineAllCapsTransform(paramTextView.getContext()));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStripIcs
 * JD-Core Version:    0.7.0.1
 */