package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class NotificationCompat$WearableExtender
  implements NotificationCompat.Extender
{
  private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
  private static final int DEFAULT_FLAGS = 1;
  private static final int DEFAULT_GRAVITY = 80;
  private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
  private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
  private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
  private static final int FLAG_HINT_HIDE_ICON = 2;
  private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
  private static final int FLAG_START_SCROLL_BOTTOM = 8;
  private static final String KEY_ACTIONS = "actions";
  private static final String KEY_BACKGROUND = "background";
  private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
  private static final String KEY_CONTENT_ICON = "contentIcon";
  private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
  private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
  private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
  private static final String KEY_DISPLAY_INTENT = "displayIntent";
  private static final String KEY_FLAGS = "flags";
  private static final String KEY_GRAVITY = "gravity";
  private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
  private static final String KEY_PAGES = "pages";
  public static final int SCREEN_TIMEOUT_LONG = -1;
  public static final int SCREEN_TIMEOUT_SHORT = 0;
  public static final int SIZE_DEFAULT = 0;
  public static final int SIZE_FULL_SCREEN = 5;
  public static final int SIZE_LARGE = 4;
  public static final int SIZE_MEDIUM = 3;
  public static final int SIZE_SMALL = 2;
  public static final int SIZE_XSMALL = 1;
  public static final int UNSET_ACTION_INDEX = -1;
  private ArrayList<NotificationCompat.Action> mActions = new ArrayList();
  private Bitmap mBackground;
  private int mContentActionIndex = -1;
  private int mContentIcon;
  private int mContentIconGravity = 8388613;
  private int mCustomContentHeight;
  private int mCustomSizePreset = 0;
  private PendingIntent mDisplayIntent;
  private int mFlags = 1;
  private int mGravity = 80;
  private int mHintScreenTimeout;
  private ArrayList<Notification> mPages = new ArrayList();
  
  public NotificationCompat$WearableExtender() {}
  
  public NotificationCompat$WearableExtender(Notification paramNotification)
  {
    Bundle localBundle1 = NotificationCompat.getExtras(paramNotification);
    if (localBundle1 != null) {}
    for (Bundle localBundle2 = localBundle1.getBundle("android.wearable.EXTENSIONS");; localBundle2 = null)
    {
      if (localBundle2 != null)
      {
        NotificationCompat.Action[] arrayOfAction = NotificationCompat.access$200().getActionsFromParcelableArrayList(localBundle2.getParcelableArrayList("actions"));
        if (arrayOfAction != null) {
          Collections.addAll(this.mActions, arrayOfAction);
        }
        this.mFlags = localBundle2.getInt("flags", 1);
        this.mDisplayIntent = ((PendingIntent)localBundle2.getParcelable("displayIntent"));
        Notification[] arrayOfNotification = NotificationCompat.access$500(localBundle2, "pages");
        if (arrayOfNotification != null) {
          Collections.addAll(this.mPages, arrayOfNotification);
        }
        this.mBackground = ((Bitmap)localBundle2.getParcelable("background"));
        this.mContentIcon = localBundle2.getInt("contentIcon");
        this.mContentIconGravity = localBundle2.getInt("contentIconGravity", 8388613);
        this.mContentActionIndex = localBundle2.getInt("contentActionIndex", -1);
        this.mCustomSizePreset = localBundle2.getInt("customSizePreset", 0);
        this.mCustomContentHeight = localBundle2.getInt("customContentHeight");
        this.mGravity = localBundle2.getInt("gravity", 80);
        this.mHintScreenTimeout = localBundle2.getInt("hintScreenTimeout");
      }
      return;
    }
  }
  
  private void setFlag(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.mFlags = (paramInt | this.mFlags);; this.mFlags &= (paramInt ^ 0xFFFFFFFF)) {
      return;
    }
  }
  
  public WearableExtender addAction(NotificationCompat.Action paramAction)
  {
    this.mActions.add(paramAction);
    return this;
  }
  
  public WearableExtender addActions(List<NotificationCompat.Action> paramList)
  {
    this.mActions.addAll(paramList);
    return this;
  }
  
  public WearableExtender addPage(Notification paramNotification)
  {
    this.mPages.add(paramNotification);
    return this;
  }
  
  public WearableExtender addPages(List<Notification> paramList)
  {
    this.mPages.addAll(paramList);
    return this;
  }
  
  public WearableExtender clearActions()
  {
    this.mActions.clear();
    return this;
  }
  
  public WearableExtender clearPages()
  {
    this.mPages.clear();
    return this;
  }
  
  public WearableExtender clone()
  {
    WearableExtender localWearableExtender = new WearableExtender();
    localWearableExtender.mActions = new ArrayList(this.mActions);
    localWearableExtender.mFlags = this.mFlags;
    localWearableExtender.mDisplayIntent = this.mDisplayIntent;
    localWearableExtender.mPages = new ArrayList(this.mPages);
    localWearableExtender.mBackground = this.mBackground;
    localWearableExtender.mContentIcon = this.mContentIcon;
    localWearableExtender.mContentIconGravity = this.mContentIconGravity;
    localWearableExtender.mContentActionIndex = this.mContentActionIndex;
    localWearableExtender.mCustomSizePreset = this.mCustomSizePreset;
    localWearableExtender.mCustomContentHeight = this.mCustomContentHeight;
    localWearableExtender.mGravity = this.mGravity;
    localWearableExtender.mHintScreenTimeout = this.mHintScreenTimeout;
    return localWearableExtender;
  }
  
  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    Bundle localBundle = new Bundle();
    if (!this.mActions.isEmpty()) {
      localBundle.putParcelableArrayList("actions", NotificationCompat.access$200().getParcelableArrayListForActions((NotificationCompat.Action[])this.mActions.toArray(new NotificationCompat.Action[this.mActions.size()])));
    }
    if (this.mFlags != 1) {
      localBundle.putInt("flags", this.mFlags);
    }
    if (this.mDisplayIntent != null) {
      localBundle.putParcelable("displayIntent", this.mDisplayIntent);
    }
    if (!this.mPages.isEmpty()) {
      localBundle.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
    }
    if (this.mBackground != null) {
      localBundle.putParcelable("background", this.mBackground);
    }
    if (this.mContentIcon != 0) {
      localBundle.putInt("contentIcon", this.mContentIcon);
    }
    if (this.mContentIconGravity != 8388613) {
      localBundle.putInt("contentIconGravity", this.mContentIconGravity);
    }
    if (this.mContentActionIndex != -1) {
      localBundle.putInt("contentActionIndex", this.mContentActionIndex);
    }
    if (this.mCustomSizePreset != 0) {
      localBundle.putInt("customSizePreset", this.mCustomSizePreset);
    }
    if (this.mCustomContentHeight != 0) {
      localBundle.putInt("customContentHeight", this.mCustomContentHeight);
    }
    if (this.mGravity != 80) {
      localBundle.putInt("gravity", this.mGravity);
    }
    if (this.mHintScreenTimeout != 0) {
      localBundle.putInt("hintScreenTimeout", this.mHintScreenTimeout);
    }
    paramBuilder.getExtras().putBundle("android.wearable.EXTENSIONS", localBundle);
    return paramBuilder;
  }
  
  public List<NotificationCompat.Action> getActions()
  {
    return this.mActions;
  }
  
  public Bitmap getBackground()
  {
    return this.mBackground;
  }
  
  public int getContentAction()
  {
    return this.mContentActionIndex;
  }
  
  public int getContentIcon()
  {
    return this.mContentIcon;
  }
  
  public int getContentIconGravity()
  {
    return this.mContentIconGravity;
  }
  
  public boolean getContentIntentAvailableOffline()
  {
    if ((0x1 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getCustomContentHeight()
  {
    return this.mCustomContentHeight;
  }
  
  public int getCustomSizePreset()
  {
    return this.mCustomSizePreset;
  }
  
  public PendingIntent getDisplayIntent()
  {
    return this.mDisplayIntent;
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  public boolean getHintAvoidBackgroundClipping()
  {
    if ((0x10 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean getHintHideIcon()
  {
    if ((0x2 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getHintScreenTimeout()
  {
    return this.mHintScreenTimeout;
  }
  
  public boolean getHintShowBackgroundOnly()
  {
    if ((0x4 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public List<Notification> getPages()
  {
    return this.mPages;
  }
  
  public boolean getStartScrollBottom()
  {
    if ((0x8 & this.mFlags) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public WearableExtender setBackground(Bitmap paramBitmap)
  {
    this.mBackground = paramBitmap;
    return this;
  }
  
  public WearableExtender setContentAction(int paramInt)
  {
    this.mContentActionIndex = paramInt;
    return this;
  }
  
  public WearableExtender setContentIcon(int paramInt)
  {
    this.mContentIcon = paramInt;
    return this;
  }
  
  public WearableExtender setContentIconGravity(int paramInt)
  {
    this.mContentIconGravity = paramInt;
    return this;
  }
  
  public WearableExtender setContentIntentAvailableOffline(boolean paramBoolean)
  {
    setFlag(1, paramBoolean);
    return this;
  }
  
  public WearableExtender setCustomContentHeight(int paramInt)
  {
    this.mCustomContentHeight = paramInt;
    return this;
  }
  
  public WearableExtender setCustomSizePreset(int paramInt)
  {
    this.mCustomSizePreset = paramInt;
    return this;
  }
  
  public WearableExtender setDisplayIntent(PendingIntent paramPendingIntent)
  {
    this.mDisplayIntent = paramPendingIntent;
    return this;
  }
  
  public WearableExtender setGravity(int paramInt)
  {
    this.mGravity = paramInt;
    return this;
  }
  
  public WearableExtender setHintAvoidBackgroundClipping(boolean paramBoolean)
  {
    setFlag(16, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintHideIcon(boolean paramBoolean)
  {
    setFlag(2, paramBoolean);
    return this;
  }
  
  public WearableExtender setHintScreenTimeout(int paramInt)
  {
    this.mHintScreenTimeout = paramInt;
    return this;
  }
  
  public WearableExtender setHintShowBackgroundOnly(boolean paramBoolean)
  {
    setFlag(4, paramBoolean);
    return this;
  }
  
  public WearableExtender setStartScrollBottom(boolean paramBoolean)
  {
    setFlag(8, paramBoolean);
    return this;
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     android.support.v4.app.NotificationCompat.WearableExtender

 * JD-Core Version:    0.7.0.1

 */