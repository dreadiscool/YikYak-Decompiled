package android.support.v4.app;

import android.app.Notification;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

public class NotificationCompat
{
  public static final String CATEGORY_ALARM = "alarm";
  public static final String CATEGORY_CALL = "call";
  public static final String CATEGORY_EMAIL = "email";
  public static final String CATEGORY_ERROR = "err";
  public static final String CATEGORY_EVENT = "event";
  public static final String CATEGORY_MESSAGE = "msg";
  public static final String CATEGORY_PROGRESS = "progress";
  public static final String CATEGORY_PROMO = "promo";
  public static final String CATEGORY_RECOMMENDATION = "recommendation";
  public static final String CATEGORY_SERVICE = "service";
  public static final String CATEGORY_SOCIAL = "social";
  public static final String CATEGORY_STATUS = "status";
  public static final String CATEGORY_SYSTEM = "sys";
  public static final String CATEGORY_TRANSPORT = "transport";
  public static final int COLOR_DEFAULT = 0;
  public static final int DEFAULT_ALL = -1;
  public static final int DEFAULT_LIGHTS = 4;
  public static final int DEFAULT_SOUND = 1;
  public static final int DEFAULT_VIBRATE = 2;
  public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
  public static final String EXTRA_BIG_TEXT = "android.bigText";
  public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
  public static final String EXTRA_INFO_TEXT = "android.infoText";
  public static final String EXTRA_LARGE_ICON = "android.largeIcon";
  public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
  public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
  public static final String EXTRA_PEOPLE = "android.people";
  public static final String EXTRA_PICTURE = "android.picture";
  public static final String EXTRA_PROGRESS = "android.progress";
  public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
  public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
  public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
  public static final String EXTRA_SHOW_WHEN = "android.showWhen";
  public static final String EXTRA_SMALL_ICON = "android.icon";
  public static final String EXTRA_SUB_TEXT = "android.subText";
  public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
  public static final String EXTRA_TEMPLATE = "android.template";
  public static final String EXTRA_TEXT = "android.text";
  public static final String EXTRA_TEXT_LINES = "android.textLines";
  public static final String EXTRA_TITLE = "android.title";
  public static final String EXTRA_TITLE_BIG = "android.title.big";
  public static final int FLAG_AUTO_CANCEL = 16;
  public static final int FLAG_FOREGROUND_SERVICE = 64;
  public static final int FLAG_GROUP_SUMMARY = 512;
  public static final int FLAG_HIGH_PRIORITY = 128;
  public static final int FLAG_INSISTENT = 4;
  public static final int FLAG_LOCAL_ONLY = 256;
  public static final int FLAG_NO_CLEAR = 32;
  public static final int FLAG_ONGOING_EVENT = 2;
  public static final int FLAG_ONLY_ALERT_ONCE = 8;
  public static final int FLAG_SHOW_LIGHTS = 1;
  private static final NotificationCompat.NotificationCompatImpl IMPL;
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  public static final int STREAM_DEFAULT = -1;
  public static final int VISIBILITY_PRIVATE = 0;
  public static final int VISIBILITY_PUBLIC = 1;
  public static final int VISIBILITY_SECRET = -1;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new NotificationCompat.NotificationCompatImplApi21();
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 20) {
        IMPL = new NotificationCompat.NotificationCompatImplApi20();
      } else if (Build.VERSION.SDK_INT >= 19) {
        IMPL = new NotificationCompat.NotificationCompatImplKitKat();
      } else if (Build.VERSION.SDK_INT >= 16) {
        IMPL = new NotificationCompat.NotificationCompatImplJellybean();
      } else if (Build.VERSION.SDK_INT >= 14) {
        IMPL = new NotificationCompat.NotificationCompatImplIceCreamSandwich();
      } else if (Build.VERSION.SDK_INT >= 11) {
        IMPL = new NotificationCompat.NotificationCompatImplHoneycomb();
      } else if (Build.VERSION.SDK_INT >= 9) {
        IMPL = new NotificationCompat.NotificationCompatImplGingerbread();
      } else {
        IMPL = new NotificationCompat.NotificationCompatImplBase();
      }
    }
  }
  
  private static void addActionsToBuilder(NotificationBuilderWithActions paramNotificationBuilderWithActions, ArrayList<NotificationCompat.Action> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      paramNotificationBuilderWithActions.addAction((NotificationCompat.Action)localIterator.next());
    }
  }
  
  private static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor, NotificationCompat.Style paramStyle)
  {
    if (paramStyle != null)
    {
      if (!(paramStyle instanceof NotificationCompat.BigTextStyle)) {
        break label42;
      }
      NotificationCompat.BigTextStyle localBigTextStyle = (NotificationCompat.BigTextStyle)paramStyle;
      NotificationCompatJellybean.addBigTextStyle(paramNotificationBuilderWithBuilderAccessor, localBigTextStyle.mBigContentTitle, localBigTextStyle.mSummaryTextSet, localBigTextStyle.mSummaryText, localBigTextStyle.mBigText);
    }
    for (;;)
    {
      return;
      label42:
      if ((paramStyle instanceof NotificationCompat.InboxStyle))
      {
        NotificationCompat.InboxStyle localInboxStyle = (NotificationCompat.InboxStyle)paramStyle;
        NotificationCompatJellybean.addInboxStyle(paramNotificationBuilderWithBuilderAccessor, localInboxStyle.mBigContentTitle, localInboxStyle.mSummaryTextSet, localInboxStyle.mSummaryText, localInboxStyle.mTexts);
      }
      else if ((paramStyle instanceof NotificationCompat.BigPictureStyle))
      {
        NotificationCompat.BigPictureStyle localBigPictureStyle = (NotificationCompat.BigPictureStyle)paramStyle;
        NotificationCompatJellybean.addBigPictureStyle(paramNotificationBuilderWithBuilderAccessor, localBigPictureStyle.mBigContentTitle, localBigPictureStyle.mSummaryTextSet, localBigPictureStyle.mSummaryText, localBigPictureStyle.mPicture, localBigPictureStyle.mBigLargeIcon, localBigPictureStyle.mBigLargeIconSet);
      }
    }
  }
  
  public static NotificationCompat.Action getAction(Notification paramNotification, int paramInt)
  {
    return IMPL.getAction(paramNotification, paramInt);
  }
  
  public static int getActionCount(Notification paramNotification)
  {
    return IMPL.getActionCount(paramNotification);
  }
  
  public static String getCategory(Notification paramNotification)
  {
    return IMPL.getCategory(paramNotification);
  }
  
  public static Bundle getExtras(Notification paramNotification)
  {
    return IMPL.getExtras(paramNotification);
  }
  
  public static String getGroup(Notification paramNotification)
  {
    return IMPL.getGroup(paramNotification);
  }
  
  public static boolean getLocalOnly(Notification paramNotification)
  {
    return IMPL.getLocalOnly(paramNotification);
  }
  
  private static Notification[] getNotificationArrayFromBundle(Bundle paramBundle, String paramString)
  {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (((arrayOfParcelable instanceof Notification[])) || (arrayOfParcelable == null)) {}
    Notification[] arrayOfNotification;
    for (Object localObject = (Notification[])arrayOfParcelable;; localObject = arrayOfNotification)
    {
      return localObject;
      arrayOfNotification = new Notification[arrayOfParcelable.length];
      for (int i = 0; i < arrayOfParcelable.length; i++) {
        arrayOfNotification[i] = ((Notification)arrayOfParcelable[i]);
      }
      paramBundle.putParcelableArray(paramString, arrayOfNotification);
    }
  }
  
  public static String getSortKey(Notification paramNotification)
  {
    return IMPL.getSortKey(paramNotification);
  }
  
  public static boolean isGroupSummary(Notification paramNotification)
  {
    return IMPL.isGroupSummary(paramNotification);
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     android.support.v4.app.NotificationCompat

 * JD-Core Version:    0.7.0.1

 */