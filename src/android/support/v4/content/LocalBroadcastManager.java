package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LocalBroadcastManager
{
  private static final boolean DEBUG = false;
  static final int MSG_EXEC_PENDING_BROADCASTS = 1;
  private static final String TAG = "LocalBroadcastManager";
  private static LocalBroadcastManager mInstance;
  private static final Object mLock = new Object();
  private final HashMap<String, ArrayList<LocalBroadcastManager.ReceiverRecord>> mActions = new HashMap();
  private final Context mAppContext;
  private final Handler mHandler;
  private final ArrayList<LocalBroadcastManager.BroadcastRecord> mPendingBroadcasts = new ArrayList();
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap();
  
  private LocalBroadcastManager(Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mHandler = new LocalBroadcastManager.1(this, paramContext.getMainLooper());
  }
  
  private void executePendingBroadcasts()
  {
    for (;;)
    {
      int j;
      synchronized (this.mReceivers)
      {
        int i = this.mPendingBroadcasts.size();
        if (i <= 0) {
          return;
        }
        LocalBroadcastManager.BroadcastRecord[] arrayOfBroadcastRecord = new LocalBroadcastManager.BroadcastRecord[i];
        this.mPendingBroadcasts.toArray(arrayOfBroadcastRecord);
        this.mPendingBroadcasts.clear();
        j = 0;
        if (j >= arrayOfBroadcastRecord.length) {
          continue;
        }
        LocalBroadcastManager.BroadcastRecord localBroadcastRecord = arrayOfBroadcastRecord[j];
        int k = 0;
        if (k < localBroadcastRecord.receivers.size())
        {
          ((LocalBroadcastManager.ReceiverRecord)localBroadcastRecord.receivers.get(k)).receiver.onReceive(this.mAppContext, localBroadcastRecord.intent);
          k++;
        }
      }
      j++;
    }
  }
  
  public static LocalBroadcastManager getInstance(Context paramContext)
  {
    synchronized (mLock)
    {
      if (mInstance == null) {
        mInstance = new LocalBroadcastManager(paramContext.getApplicationContext());
      }
      LocalBroadcastManager localLocalBroadcastManager = mInstance;
      return localLocalBroadcastManager;
    }
  }
  
  public void registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.mReceivers)
    {
      LocalBroadcastManager.ReceiverRecord localReceiverRecord = new LocalBroadcastManager.ReceiverRecord(paramIntentFilter, paramBroadcastReceiver);
      ArrayList localArrayList1 = (ArrayList)this.mReceivers.get(paramBroadcastReceiver);
      if (localArrayList1 == null)
      {
        localArrayList1 = new ArrayList(1);
        this.mReceivers.put(paramBroadcastReceiver, localArrayList1);
      }
      localArrayList1.add(paramIntentFilter);
      for (int i = 0; i < paramIntentFilter.countActions(); i++)
      {
        String str = paramIntentFilter.getAction(i);
        ArrayList localArrayList2 = (ArrayList)this.mActions.get(str);
        if (localArrayList2 == null)
        {
          localArrayList2 = new ArrayList(1);
          this.mActions.put(str, localArrayList2);
        }
        localArrayList2.add(localReceiverRecord);
      }
      return;
    }
  }
  
  public boolean sendBroadcast(Intent paramIntent)
  {
    boolean bool;
    for (;;)
    {
      int j;
      int m;
      int k;
      synchronized (this.mReceivers)
      {
        String str1 = paramIntent.getAction();
        String str2 = paramIntent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
        Uri localUri = paramIntent.getData();
        String str3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        if ((0x8 & paramIntent.getFlags()) == 0) {
          break label490;
        }
        i = 1;
        if (i != 0) {
          new StringBuilder().append("Resolving type ").append(str2).append(" scheme ").append(str3).append(" of intent ").append(paramIntent).toString();
        }
        ArrayList localArrayList = (ArrayList)this.mActions.get(paramIntent.getAction());
        if (localArrayList != null)
        {
          if (i == 0) {
            continue;
          }
          new StringBuilder().append("Action list: ").append(localArrayList).toString();
          continue;
          if (j >= localArrayList.size()) {
            break label531;
          }
          LocalBroadcastManager.ReceiverRecord localReceiverRecord = (LocalBroadcastManager.ReceiverRecord)localArrayList.get(j);
          if (i != 0) {
            new StringBuilder().append("Matching against filter ").append(localReceiverRecord.filter).toString();
          }
          if (localReceiverRecord.broadcasting)
          {
            if (i == 0) {
              break label496;
            }
            localObject3 = localObject2;
          }
          else
          {
            m = localReceiverRecord.filter.match(str1, str2, str3, localUri, localSet, "LocalBroadcastManager");
            if (m >= 0)
            {
              if (i != 0) {
                new StringBuilder().append("  Filter matched!  match=0x").append(Integer.toHexString(m)).toString();
              }
              if (localObject2 != null) {
                continue;
              }
              localObject3 = new ArrayList();
              ((ArrayList)localObject3).add(localReceiverRecord);
              localReceiverRecord.broadcasting = true;
            }
          }
        }
      }
      Object localObject2 = localObject3;
      continue;
      label490:
      int i = 0;
      continue;
      label496:
      Object localObject3 = localObject2;
      continue;
      String str4 = "action";
      continue;
      str4 = "category";
      continue;
      str4 = "data";
      continue;
      str4 = "type";
      continue;
      label531:
      if (localObject2 != null) {
        k = 0;
      }
    }
    return bool;
  }
  
  public void sendBroadcastSync(Intent paramIntent)
  {
    if (sendBroadcast(paramIntent)) {
      executePendingBroadcasts();
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    for (;;)
    {
      int j;
      synchronized (this.mReceivers)
      {
        ArrayList localArrayList1 = (ArrayList)this.mReceivers.remove(paramBroadcastReceiver);
        if (localArrayList1 != null) {
          break label179;
        }
        break label178;
        if (i < localArrayList1.size())
        {
          IntentFilter localIntentFilter = (IntentFilter)localArrayList1.get(i);
          j = 0;
          if (j >= localIntentFilter.countActions()) {
            break label200;
          }
          String str = localIntentFilter.getAction(j);
          ArrayList localArrayList2 = (ArrayList)this.mActions.get(str);
          if (localArrayList2 == null) {
            break label194;
          }
          k = 0;
          if (k < localArrayList2.size())
          {
            if (((LocalBroadcastManager.ReceiverRecord)localArrayList2.get(k)).receiver != paramBroadcastReceiver) {
              break label171;
            }
            localArrayList2.remove(k);
            m = k - 1;
            break label185;
          }
          if (localArrayList2.size() > 0) {
            break label194;
          }
          this.mActions.remove(str);
          break label194;
        }
      }
      label171:
      int m = k;
      break label185;
      label178:
      return;
      label179:
      int i = 0;
      continue;
      label185:
      int k = m + 1;
      continue;
      label194:
      j++;
      continue;
      label200:
      i++;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.LocalBroadcastManager
 * JD-Core Version:    0.7.0.1
 */