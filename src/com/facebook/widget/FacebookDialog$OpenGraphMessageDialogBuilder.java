package com.facebook.widget;

import android.app.Activity;
import com.facebook.model.OpenGraphAction;
import java.util.EnumSet;

public class FacebookDialog$OpenGraphMessageDialogBuilder
  extends FacebookDialog.OpenGraphDialogBuilderBase<OpenGraphMessageDialogBuilder>
{
  public FacebookDialog$OpenGraphMessageDialogBuilder(Activity paramActivity, OpenGraphAction paramOpenGraphAction, String paramString)
  {
    super(paramActivity, paramOpenGraphAction, paramString);
  }
  
  protected EnumSet<? extends FacebookDialog.DialogFeature> getDialogFeatures()
  {
    return EnumSet.of(FacebookDialog.OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.OpenGraphMessageDialogBuilder
 * JD-Core Version:    0.7.0.1
 */