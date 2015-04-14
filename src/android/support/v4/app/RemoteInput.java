package android.support.v4.app;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public class RemoteInput
  extends RemoteInputCompatBase.RemoteInput
{
  public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
  public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY;
  private static final RemoteInput.Impl IMPL;
  public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
  private static final String TAG = "RemoteInput";
  private final boolean mAllowFreeFormInput;
  private final CharSequence[] mChoices;
  private final Bundle mExtras;
  private final CharSequence mLabel;
  private final String mResultKey;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 20) {
      IMPL = new RemoteInput.ImplApi20();
    }
    for (;;)
    {
      FACTORY = new RemoteInput.1();
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        IMPL = new RemoteInput.ImplJellybean();
      } else {
        IMPL = new RemoteInput.ImplBase();
      }
    }
  }
  
  RemoteInput(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle)
  {
    this.mResultKey = paramString;
    this.mLabel = paramCharSequence;
    this.mChoices = paramArrayOfCharSequence;
    this.mAllowFreeFormInput = paramBoolean;
    this.mExtras = paramBundle;
  }
  
  public static void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle)
  {
    IMPL.addResultsToIntent(paramArrayOfRemoteInput, paramIntent, paramBundle);
  }
  
  public static Bundle getResultsFromIntent(Intent paramIntent)
  {
    return IMPL.getResultsFromIntent(paramIntent);
  }
  
  public boolean getAllowFreeFormInput()
  {
    return this.mAllowFreeFormInput;
  }
  
  public CharSequence[] getChoices()
  {
    return this.mChoices;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public CharSequence getLabel()
  {
    return this.mLabel;
  }
  
  public String getResultKey()
  {
    return this.mResultKey;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.app.RemoteInput
 * JD-Core Version:    0.7.0.1
 */