package com.facebook.widget;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.FacebookException;
import java.io.File;

abstract class FacebookDialog$VideoDialogBuilderBase<CONCRETE extends VideoDialogBuilderBase<?>>
  extends FacebookDialog.Builder<CONCRETE>
{
  private String place;
  private String videoAttachmentUrl;
  
  public FacebookDialog$VideoDialogBuilderBase(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public CONCRETE addVideoFile(File paramFile)
  {
    this.videoAttachmentUrl = addVideoAttachmentFile(paramFile);
    return this;
  }
  
  protected Bundle getMethodArguments()
  {
    Bundle localBundle = new Bundle();
    putExtra(localBundle, "PLACE", this.place);
    localBundle.putString("VIDEO", this.videoAttachmentUrl);
    return localBundle;
  }
  
  public CONCRETE setPlace(String paramString)
  {
    this.place = paramString;
    return this;
  }
  
  public CONCRETE setVideoUrl(String paramString)
  {
    this.videoAttachmentUrl = paramString;
    return this;
  }
  
  void validate()
  {
    super.validate();
    if ((this.videoAttachmentUrl == null) || (this.videoAttachmentUrl.isEmpty())) {
      throw new FacebookException("Must specify at least one video.");
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.VideoDialogBuilderBase
 * JD-Core Version:    0.7.0.1
 */