package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import java.util.ArrayList;

public class ShareCompat$IntentReader
{
  private static final String TAG = "IntentReader";
  private Activity mActivity;
  private ComponentName mCallingActivity;
  private String mCallingPackage;
  private Intent mIntent;
  private ArrayList<Uri> mStreams;
  
  private ShareCompat$IntentReader(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mIntent = paramActivity.getIntent();
    this.mCallingPackage = ShareCompat.getCallingPackage(paramActivity);
    this.mCallingActivity = ShareCompat.getCallingActivity(paramActivity);
  }
  
  public static IntentReader from(Activity paramActivity)
  {
    return new IntentReader(paramActivity);
  }
  
  public ComponentName getCallingActivity()
  {
    return this.mCallingActivity;
  }
  
  public Drawable getCallingActivityIcon()
  {
    Object localObject = null;
    if (this.mCallingActivity == null) {}
    for (;;)
    {
      return localObject;
      PackageManager localPackageManager = this.mActivity.getPackageManager();
      try
      {
        Drawable localDrawable = localPackageManager.getActivityIcon(this.mCallingActivity);
        localObject = localDrawable;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  public Drawable getCallingApplicationIcon()
  {
    Object localObject = null;
    if (this.mCallingPackage == null) {}
    for (;;)
    {
      return localObject;
      PackageManager localPackageManager = this.mActivity.getPackageManager();
      try
      {
        Drawable localDrawable = localPackageManager.getApplicationIcon(this.mCallingPackage);
        localObject = localDrawable;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  public CharSequence getCallingApplicationLabel()
  {
    Object localObject = null;
    if (this.mCallingPackage == null) {}
    for (;;)
    {
      return localObject;
      PackageManager localPackageManager = this.mActivity.getPackageManager();
      try
      {
        CharSequence localCharSequence = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(this.mCallingPackage, 0));
        localObject = localCharSequence;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  public String getCallingPackage()
  {
    return this.mCallingPackage;
  }
  
  public String[] getEmailBcc()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
  }
  
  public String[] getEmailCc()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
  }
  
  public String[] getEmailTo()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
  }
  
  public String getHtmlText()
  {
    String str1 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
    CharSequence localCharSequence;
    String str2;
    if (str1 == null)
    {
      localCharSequence = getText();
      if ((localCharSequence instanceof Spanned)) {
        str2 = Html.toHtml((Spanned)localCharSequence);
      }
    }
    for (;;)
    {
      return str2;
      if (localCharSequence != null) {
        str2 = ShareCompat.access$000().escapeHtml(localCharSequence);
      } else {
        str2 = str1;
      }
    }
  }
  
  public Uri getStream()
  {
    return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
  }
  
  public Uri getStream(int paramInt)
  {
    if ((this.mStreams == null) && (isMultipleShare())) {
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    }
    if (this.mStreams != null) {}
    for (Uri localUri = (Uri)this.mStreams.get(paramInt);; localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM"))
    {
      return localUri;
      if (paramInt != 0) {
        break;
      }
    }
    throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + paramInt);
  }
  
  public int getStreamCount()
  {
    if ((this.mStreams == null) && (isMultipleShare())) {
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    }
    int i;
    if (this.mStreams != null) {
      i = this.mStreams.size();
    }
    for (;;)
    {
      return i;
      if (this.mIntent.hasExtra("android.intent.extra.STREAM")) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public String getSubject()
  {
    return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
  }
  
  public CharSequence getText()
  {
    return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
  }
  
  public String getType()
  {
    return this.mIntent.getType();
  }
  
  public boolean isMultipleShare()
  {
    return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
  }
  
  public boolean isShareIntent()
  {
    String str = this.mIntent.getAction();
    if (("android.intent.action.SEND".equals(str)) || ("android.intent.action.SEND_MULTIPLE".equals(str))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isSingleShare()
  {
    return "android.intent.action.SEND".equals(this.mIntent.getAction());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.ShareCompat.IntentReader
 * JD-Core Version:    0.7.0.1
 */