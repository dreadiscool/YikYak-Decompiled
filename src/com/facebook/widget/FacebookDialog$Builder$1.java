package com.facebook.widget;

import android.content.Context;
import com.facebook.NativeAppCallAttachmentStore;
import java.util.HashMap;

class FacebookDialog$Builder$1
  implements FacebookDialog.OnPresentCallback
{
  FacebookDialog$Builder$1(FacebookDialog.Builder paramBuilder) {}
  
  public void onPresent(Context paramContext)
  {
    if ((this.this$0.imageAttachments != null) && (this.this$0.imageAttachments.size() > 0)) {
      FacebookDialog.access$900().addAttachmentsForCall(paramContext, this.this$0.appCall.getCallId(), this.this$0.imageAttachments);
    }
    if ((this.this$0.mediaAttachmentFiles != null) && (this.this$0.mediaAttachmentFiles.size() > 0)) {
      FacebookDialog.access$900().addAttachmentFilesForCall(paramContext, this.this$0.appCall.getCallId(), this.this$0.mediaAttachmentFiles);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.Builder.1
 * JD-Core Version:    0.7.0.1
 */