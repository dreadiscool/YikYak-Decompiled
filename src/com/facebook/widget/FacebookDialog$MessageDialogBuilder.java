package com.facebook.widget;

import android.app.Activity;
import java.util.EnumSet;
import java.util.List;

public class FacebookDialog$MessageDialogBuilder
  extends FacebookDialog.ShareDialogBuilderBase<MessageDialogBuilder>
{
  public FacebookDialog$MessageDialogBuilder(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  protected EnumSet<? extends FacebookDialog.DialogFeature> getDialogFeatures()
  {
    return EnumSet.of(FacebookDialog.MessageDialogFeature.MESSAGE_DIALOG);
  }
  
  public MessageDialogBuilder setFriends(List<String> paramList)
  {
    return this;
  }
  
  public MessageDialogBuilder setPlace(String paramString)
  {
    return this;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.MessageDialogBuilder
 * JD-Core Version:    0.7.0.1
 */