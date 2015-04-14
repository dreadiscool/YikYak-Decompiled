package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.support.v4.os.AsyncTaskCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityChooserModel
  extends DataSetObservable
{
  private static final String ATTRIBUTE_ACTIVITY = "activity";
  private static final String ATTRIBUTE_TIME = "time";
  private static final String ATTRIBUTE_WEIGHT = "weight";
  private static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final String TAG_HISTORICAL_RECORD = "historical-record";
  private static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap();
  private static final Object sRegistryLock = new Object();
  private final List<ActivityChooserModel.ActivityResolveInfo> mActivities = new ArrayList();
  private ActivityChooserModel.OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivityChooserModel.ActivitySorter mActivitySorter = new ActivityChooserModel.DefaultSorter(this, null);
  private boolean mCanReadHistoricalData = true;
  private final Context mContext;
  private final List<ActivityChooserModel.HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  private final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  private boolean mReloadActivities = false;
  
  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml"))) {}
    for (this.mHistoryFileName = (paramString + ".xml");; this.mHistoryFileName = paramString) {
      return;
    }
  }
  
  private boolean addHisoricalRecord(ActivityChooserModel.HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
    if (bool)
    {
      this.mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      persistHistoricalDataIfNeeded();
      sortActivitiesIfNeeded();
      notifyChanged();
    }
    return bool;
  }
  
  private void ensureConsistentState()
  {
    boolean bool = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
    pruneExcessiveHistoricalRecordsIfNeeded();
    if (bool)
    {
      sortActivitiesIfNeeded();
      notifyChanged();
    }
  }
  
  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      if (localActivityChooserModel == null)
      {
        localActivityChooserModel = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel);
      }
      return localActivityChooserModel;
    }
  }
  
  private boolean loadActivitiesIfNeeded()
  {
    boolean bool = false;
    if ((this.mReloadActivities) && (this.mIntent != null))
    {
      this.mReloadActivities = false;
      this.mActivities.clear();
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(j);
        this.mActivities.add(new ActivityChooserModel.ActivityResolveInfo(this, localResolveInfo));
      }
      bool = true;
    }
    return bool;
  }
  
  private void persistHistoricalDataIfNeeded()
  {
    if (!this.mReadShareHistoryCalled) {
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.mHistoricalRecordsChanged) {}
    for (;;)
    {
      return;
      this.mHistoricalRecordsChanged = false;
      if (!TextUtils.isEmpty(this.mHistoryFileName))
      {
        ActivityChooserModel.PersistHistoryAsyncTask localPersistHistoryAsyncTask = new ActivityChooserModel.PersistHistoryAsyncTask(this, null);
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.mHistoricalRecords;
        arrayOfObject[1] = this.mHistoryFileName;
        AsyncTaskCompat.executeParallel(localPersistHistoryAsyncTask, arrayOfObject);
      }
    }
  }
  
  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int i = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
    if (i <= 0) {}
    for (;;)
    {
      return;
      this.mHistoricalRecordsChanged = true;
      for (int j = 0; j < i; j++) {
        this.mHistoricalRecords.remove(0);
      }
    }
  }
  
  private boolean readHistoricalDataIfNeeded()
  {
    boolean bool = true;
    if ((this.mCanReadHistoricalData) && (this.mHistoricalRecordsChanged) && (!TextUtils.isEmpty(this.mHistoryFileName)))
    {
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = bool;
      readHistoricalDataImpl();
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  private void readHistoricalDataImpl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	android/support/v7/internal/widget/ActivityChooserModel:mContext	Landroid/content/Context;
    //   4: aload_0
    //   5: getfield 147	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   8: invokevirtual 256	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   11: astore_2
    //   12: invokestatic 262	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   15: astore 11
    //   17: aload 11
    //   19: aload_2
    //   20: aconst_null
    //   21: invokeinterface 268 3 0
    //   26: iconst_0
    //   27: istore 12
    //   29: iload 12
    //   31: iconst_1
    //   32: if_icmpeq +21 -> 53
    //   35: iload 12
    //   37: iconst_2
    //   38: if_icmpeq +15 -> 53
    //   41: aload 11
    //   43: invokeinterface 271 1 0
    //   48: istore 12
    //   50: goto -21 -> 29
    //   53: ldc 40
    //   55: aload 11
    //   57: invokeinterface 274 1 0
    //   62: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifne +49 -> 114
    //   68: new 250	org/xmlpull/v1/XmlPullParserException
    //   71: dup
    //   72: ldc_w 279
    //   75: invokespecial 280	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: astore 8
    //   81: new 137	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 282
    //   91: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_0
    //   95: getfield 147	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   98: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: pop
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 287	java/io/FileInputStream:close	()V
    //   113: return
    //   114: aload_0
    //   115: getfield 98	android/support/v7/internal/widget/ActivityChooserModel:mHistoricalRecords	Ljava/util/List;
    //   118: astore 13
    //   120: aload 13
    //   122: invokeinterface 200 1 0
    //   127: aload 11
    //   129: invokeinterface 271 1 0
    //   134: istore 14
    //   136: iload 14
    //   138: iconst_1
    //   139: if_icmpne +19 -> 158
    //   142: aload_2
    //   143: ifnull -30 -> 113
    //   146: aload_2
    //   147: invokevirtual 287	java/io/FileInputStream:close	()V
    //   150: goto -37 -> 113
    //   153: astore 16
    //   155: goto -42 -> 113
    //   158: iload 14
    //   160: iconst_3
    //   161: if_icmpeq -34 -> 127
    //   164: iload 14
    //   166: iconst_4
    //   167: if_icmpeq -40 -> 127
    //   170: ldc 37
    //   172: aload 11
    //   174: invokeinterface 274 1 0
    //   179: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifne +56 -> 238
    //   185: new 250	org/xmlpull/v1/XmlPullParserException
    //   188: dup
    //   189: ldc_w 289
    //   192: invokespecial 280	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
    //   195: athrow
    //   196: astore 5
    //   198: new 137	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 282
    //   208: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_0
    //   212: getfield 147	android/support/v7/internal/widget/ActivityChooserModel:mHistoryFileName	Ljava/lang/String;
    //   215: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: pop
    //   222: aload_2
    //   223: ifnull -110 -> 113
    //   226: aload_2
    //   227: invokevirtual 287	java/io/FileInputStream:close	()V
    //   230: goto -117 -> 113
    //   233: astore 7
    //   235: goto -122 -> 113
    //   238: aload 13
    //   240: new 291	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord
    //   243: dup
    //   244: aload 11
    //   246: aconst_null
    //   247: ldc 8
    //   249: invokeinterface 295 3 0
    //   254: aload 11
    //   256: aconst_null
    //   257: ldc 11
    //   259: invokeinterface 295 3 0
    //   264: invokestatic 301	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   267: aload 11
    //   269: aconst_null
    //   270: ldc 14
    //   272: invokeinterface 295 3 0
    //   277: invokestatic 307	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   280: invokespecial 310	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
    //   283: invokeinterface 162 2 0
    //   288: pop
    //   289: goto -162 -> 127
    //   292: astore_3
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 287	java/io/FileInputStream:close	()V
    //   301: aload_3
    //   302: athrow
    //   303: astore 10
    //   305: goto -192 -> 113
    //   308: astore 4
    //   310: goto -9 -> 301
    //   313: astore_1
    //   314: goto -201 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	ActivityChooserModel
    //   313	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   11	287	2	localFileInputStream	java.io.FileInputStream
    //   292	10	3	localObject	Object
    //   308	1	4	localIOException1	java.io.IOException
    //   196	1	5	localIOException2	java.io.IOException
    //   233	1	7	localIOException3	java.io.IOException
    //   79	1	8	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   303	1	10	localIOException4	java.io.IOException
    //   15	253	11	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   27	22	12	i	int
    //   118	121	13	localList	List
    //   134	34	14	j	int
    //   153	1	16	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   12	79	79	org/xmlpull/v1/XmlPullParserException
    //   114	136	79	org/xmlpull/v1/XmlPullParserException
    //   170	196	79	org/xmlpull/v1/XmlPullParserException
    //   238	289	79	org/xmlpull/v1/XmlPullParserException
    //   146	150	153	java/io/IOException
    //   12	79	196	java/io/IOException
    //   114	136	196	java/io/IOException
    //   170	196	196	java/io/IOException
    //   238	289	196	java/io/IOException
    //   226	230	233	java/io/IOException
    //   12	79	292	finally
    //   81	105	292	finally
    //   114	136	292	finally
    //   170	196	292	finally
    //   198	222	292	finally
    //   238	289	292	finally
    //   109	113	303	java/io/IOException
    //   297	301	308	java/io/IOException
    //   0	12	313	java/io/FileNotFoundException
  }
  
  private boolean sortActivitiesIfNeeded()
  {
    if ((this.mActivitySorter != null) && (this.mIntent != null) && (!this.mActivities.isEmpty()) && (!this.mHistoricalRecords.isEmpty())) {
      this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Intent chooseActivity(int paramInt)
  {
    Intent localIntent1;
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == null)
      {
        localIntent1 = null;
      }
      else
      {
        ensureConsistentState();
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt);
        ComponentName localComponentName = new ComponentName(localActivityResolveInfo.resolveInfo.activityInfo.packageName, localActivityResolveInfo.resolveInfo.activityInfo.name);
        localIntent1 = new Intent(this.mIntent);
        localIntent1.setComponent(localComponentName);
        if (this.mActivityChoserModelPolicy != null)
        {
          Intent localIntent2 = new Intent(localIntent1);
          if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent2))
          {
            localIntent1 = null;
            break label162;
          }
        }
        addHisoricalRecord(new ActivityChooserModel.HistoricalRecord(localComponentName, System.currentTimeMillis(), 1.0F));
      }
    }
    label162:
    return localIntent1;
  }
  
  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }
  
  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mActivities.size();
      return i;
    }
  }
  
  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    for (;;)
    {
      int j;
      int k;
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        List localList = this.mActivities;
        int i = localList.size();
        j = 0;
        if (j < i)
        {
          if (((ActivityChooserModel.ActivityResolveInfo)localList.get(j)).resolveInfo != paramResolveInfo) {
            break label81;
          }
          k = j;
        }
        else
        {
          k = -1;
        }
      }
      return k;
      label81:
      j++;
    }
  }
  
  public ResolveInfo getDefaultActivity()
  {
    ResolveInfo localResolveInfo;
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      if (!this.mActivities.isEmpty()) {
        localResolveInfo = ((ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(0)).resolveInfo;
      } else {
        localResolveInfo = null;
      }
    }
    return localResolveInfo;
  }
  
  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }
  
  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }
  
  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }
  
  public void setActivitySorter(ActivityChooserModel.ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter != paramActivitySorter)
      {
        this.mActivitySorter = paramActivitySorter;
        if (sortActivitiesIfNeeded()) {
          notifyChanged();
        }
      }
    }
  }
  
  public void setDefaultActivity(int paramInt)
  {
    for (;;)
    {
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(paramInt);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)this.mActivities.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f = 5.0F + (localActivityResolveInfo2.weight - localActivityResolveInfo1.weight);
          addHisoricalRecord(new ActivityChooserModel.HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
  }
  
  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize != paramInt)
      {
        this.mHistoryMaxSize = paramInt;
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (sortActivitiesIfNeeded()) {
          notifyChanged();
        }
      }
    }
  }
  
  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent != paramIntent)
      {
        this.mIntent = paramIntent;
        this.mReloadActivities = true;
        ensureConsistentState();
      }
    }
  }
  
  public void setOnChooseActivityListener(ActivityChooserModel.OnChooseActivityListener paramOnChooseActivityListener)
  {
    synchronized (this.mInstanceLock)
    {
      this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel
 * JD-Core Version:    0.7.0.1
 */