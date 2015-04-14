package com.adjust.sdk;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class PackageHandler
  extends HandlerThread
  implements IPackageHandler
{
  private static final String PACKAGE_QUEUE_FILENAME = "AdjustIoPackageQueue";
  private ActivityHandler activityHandler;
  private Context context;
  private boolean dropOfflineActivities;
  private final PackageHandler.InternalHandler internalHandler;
  private AtomicBoolean isSending;
  private Logger logger;
  private List<ActivityPackage> packageQueue;
  private boolean paused;
  private IRequestHandler requestHandler;
  
  public PackageHandler(ActivityHandler paramActivityHandler, Context paramContext, boolean paramBoolean)
  {
    super("Adjust", 1);
    setDaemon(true);
    start();
    this.internalHandler = new PackageHandler.InternalHandler(getLooper(), this);
    this.logger = AdjustFactory.getLogger();
    this.activityHandler = paramActivityHandler;
    this.context = paramContext;
    this.dropOfflineActivities = paramBoolean;
    Message localMessage = Message.obtain();
    localMessage.arg1 = 1;
    this.internalHandler.sendMessage(localMessage);
  }
  
  private void addInternal(ActivityPackage paramActivityPackage)
  {
    this.packageQueue.add(paramActivityPackage);
    Logger localLogger = this.logger;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.packageQueue.size());
    arrayOfObject[1] = paramActivityPackage;
    localLogger.debug("Added package %d (%s)", arrayOfObject);
    this.logger.verbose(paramActivityPackage.getExtendedString(), new Object[0]);
    writePackageQueue();
  }
  
  public static Boolean deletePackageQueue(Context paramContext)
  {
    return Boolean.valueOf(paramContext.deleteFile("AdjustIoPackageQueue"));
  }
  
  private void initInternal()
  {
    this.requestHandler = AdjustFactory.getRequestHandler(this);
    this.isSending = new AtomicBoolean();
    readPackageQueue();
  }
  
  /* Error */
  private void readPackageQueue()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/adjust/sdk/PackageHandler:dropOfflineActivities	Z
    //   4: ifeq +15 -> 19
    //   7: aload_0
    //   8: new 183	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 184	java/util/ArrayList:<init>	()V
    //   15: putfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   18: return
    //   19: new 186	java/io/ObjectInputStream
    //   22: dup
    //   23: new 188	java/io/BufferedInputStream
    //   26: dup
    //   27: aload_0
    //   28: getfield 66	com/adjust/sdk/PackageHandler:context	Landroid/content/Context;
    //   31: ldc 10
    //   33: invokevirtual 192	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   36: invokespecial 195	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   39: invokespecial 196	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 200	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   47: checkcast 105	java/util/List
    //   50: astore 9
    //   52: aload_0
    //   53: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   56: astore 10
    //   58: iconst_1
    //   59: anewarray 111	java/lang/Object
    //   62: astore 11
    //   64: aload 11
    //   66: iconst_0
    //   67: aload 9
    //   69: invokeinterface 115 1 0
    //   74: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: aload 10
    //   80: ldc 202
    //   82: aload 11
    //   84: invokeinterface 129 3 0
    //   89: aload_0
    //   90: aload 9
    //   92: putfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   95: aload_1
    //   96: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   99: goto -81 -> 18
    //   102: astore 4
    //   104: aload_0
    //   105: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   108: ldc 207
    //   110: iconst_0
    //   111: anewarray 111	java/lang/Object
    //   114: invokeinterface 138 3 0
    //   119: aload_0
    //   120: new 183	java/util/ArrayList
    //   123: dup
    //   124: invokespecial 184	java/util/ArrayList:<init>	()V
    //   127: putfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   130: goto -112 -> 18
    //   133: astore 8
    //   135: aload_0
    //   136: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   139: ldc 209
    //   141: iconst_0
    //   142: anewarray 111	java/lang/Object
    //   145: invokeinterface 212 3 0
    //   150: aload_1
    //   151: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   154: goto -35 -> 119
    //   157: astore_3
    //   158: aload_0
    //   159: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   162: ldc 214
    //   164: iconst_0
    //   165: anewarray 111	java/lang/Object
    //   168: invokeinterface 212 3 0
    //   173: goto -54 -> 119
    //   176: astore 7
    //   178: aload_1
    //   179: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   182: goto -63 -> 119
    //   185: astore 6
    //   187: aload_0
    //   188: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   191: ldc 216
    //   193: iconst_0
    //   194: anewarray 111	java/lang/Object
    //   197: invokeinterface 212 3 0
    //   202: aload_1
    //   203: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   206: goto -87 -> 119
    //   209: astore 5
    //   211: aload_0
    //   212: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   215: ldc 218
    //   217: iconst_0
    //   218: anewarray 111	java/lang/Object
    //   221: invokeinterface 212 3 0
    //   226: aload_1
    //   227: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   230: goto -111 -> 119
    //   233: astore_2
    //   234: aload_1
    //   235: invokevirtual 205	java/io/ObjectInputStream:close	()V
    //   238: aload_2
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	PackageHandler
    //   42	193	1	localObjectInputStream	java.io.ObjectInputStream
    //   233	6	2	localObject	Object
    //   157	1	3	localException	java.lang.Exception
    //   102	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   209	1	5	localClassCastException	java.lang.ClassCastException
    //   185	1	6	localIOException	java.io.IOException
    //   176	1	7	localOptionalDataException	java.io.OptionalDataException
    //   133	1	8	localClassNotFoundException	java.lang.ClassNotFoundException
    //   50	41	9	localList	List
    //   56	23	10	localLogger	Logger
    //   62	21	11	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   19	43	102	java/io/FileNotFoundException
    //   95	99	102	java/io/FileNotFoundException
    //   150	154	102	java/io/FileNotFoundException
    //   178	182	102	java/io/FileNotFoundException
    //   202	206	102	java/io/FileNotFoundException
    //   226	240	102	java/io/FileNotFoundException
    //   43	95	133	java/lang/ClassNotFoundException
    //   19	43	157	java/lang/Exception
    //   95	99	157	java/lang/Exception
    //   150	154	157	java/lang/Exception
    //   178	182	157	java/lang/Exception
    //   202	206	157	java/lang/Exception
    //   226	240	157	java/lang/Exception
    //   43	95	176	java/io/OptionalDataException
    //   43	95	185	java/io/IOException
    //   43	95	209	java/lang/ClassCastException
    //   43	95	233	finally
    //   135	150	233	finally
    //   187	202	233	finally
    //   211	226	233	finally
  }
  
  private void sendFirstInternal()
  {
    if (this.packageQueue.isEmpty()) {}
    for (;;)
    {
      return;
      if (this.paused)
      {
        this.logger.debug("Package handler is paused", new Object[0]);
      }
      else if (this.isSending.getAndSet(true))
      {
        this.logger.verbose("Package handler is already sending", new Object[0]);
      }
      else
      {
        ActivityPackage localActivityPackage = (ActivityPackage)this.packageQueue.get(0);
        this.requestHandler.sendPackage(localActivityPackage);
      }
    }
  }
  
  private void sendNextInternal()
  {
    this.packageQueue.remove(0);
    writePackageQueue();
    this.isSending.set(false);
    sendFirstInternal();
  }
  
  /* Error */
  private void writePackageQueue()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/adjust/sdk/PackageHandler:dropOfflineActivities	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 251	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 253	java/io/BufferedOutputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 66	com/adjust/sdk/PackageHandler:context	Landroid/content/Context;
    //   20: ldc 10
    //   22: iconst_0
    //   23: invokevirtual 257	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   26: invokespecial 260	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   29: invokespecial 261	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore_1
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   38: invokevirtual 265	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   41: aload_0
    //   42: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   45: astore 7
    //   47: iconst_1
    //   48: anewarray 111	java/lang/Object
    //   51: astore 8
    //   53: aload 8
    //   55: iconst_0
    //   56: aload_0
    //   57: getfield 103	com/adjust/sdk/PackageHandler:packageQueue	Ljava/util/List;
    //   60: invokeinterface 115 1 0
    //   65: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: aload 7
    //   71: ldc_w 267
    //   74: aload 8
    //   76: invokeinterface 129 3 0
    //   81: aload_1
    //   82: invokevirtual 268	java/io/ObjectOutputStream:close	()V
    //   85: goto -78 -> 7
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   93: astore 4
    //   95: iconst_1
    //   96: anewarray 111	java/lang/Object
    //   99: astore 5
    //   101: aload 5
    //   103: iconst_0
    //   104: aload_3
    //   105: invokevirtual 271	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   108: aastore
    //   109: aload 4
    //   111: ldc_w 273
    //   114: aload 5
    //   116: invokeinterface 212 3 0
    //   121: aload_3
    //   122: invokevirtual 276	java/lang/Exception:printStackTrace	()V
    //   125: goto -118 -> 7
    //   128: astore 6
    //   130: aload_0
    //   131: getfield 62	com/adjust/sdk/PackageHandler:logger	Lcom/adjust/sdk/Logger;
    //   134: ldc_w 278
    //   137: iconst_0
    //   138: anewarray 111	java/lang/Object
    //   141: invokeinterface 212 3 0
    //   146: aload_1
    //   147: invokevirtual 268	java/io/ObjectOutputStream:close	()V
    //   150: goto -143 -> 7
    //   153: astore_2
    //   154: aload_1
    //   155: invokevirtual 268	java/io/ObjectOutputStream:close	()V
    //   158: aload_2
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	PackageHandler
    //   32	123	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   153	6	2	localObject	Object
    //   88	34	3	localException	java.lang.Exception
    //   93	17	4	localLogger1	Logger
    //   99	16	5	arrayOfObject1	Object[]
    //   128	1	6	localNotSerializableException	java.io.NotSerializableException
    //   45	25	7	localLogger2	Logger
    //   51	24	8	arrayOfObject2	Object[]
    // Exception table:
    //   from	to	target	type
    //   8	33	88	java/lang/Exception
    //   81	85	88	java/lang/Exception
    //   146	160	88	java/lang/Exception
    //   33	81	128	java/io/NotSerializableException
    //   33	81	153	finally
    //   130	146	153	finally
  }
  
  public void addPackage(ActivityPackage paramActivityPackage)
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 2;
    localMessage.obj = paramActivityPackage;
    this.internalHandler.sendMessage(localMessage);
  }
  
  public void closeFirstPackage()
  {
    if (this.dropOfflineActivities) {
      sendNextPackage();
    }
    for (;;)
    {
      return;
      this.isSending.set(false);
    }
  }
  
  public boolean dropsOfflineActivities()
  {
    return this.dropOfflineActivities;
  }
  
  public void finishedTrackingActivity(ActivityPackage paramActivityPackage, ResponseData paramResponseData, JSONObject paramJSONObject)
  {
    String str = null;
    paramResponseData.setActivityKind(paramActivityPackage.getActivityKind());
    if (paramJSONObject != null) {
      str = paramJSONObject.optString("deeplink", null);
    }
    this.activityHandler.finishedTrackingActivity(paramResponseData, str);
  }
  
  public String getFailureMessage()
  {
    if (this.dropOfflineActivities) {}
    for (String str = "Dropping offline activity.";; str = "Will retry later.") {
      return str;
    }
  }
  
  public void pauseSending()
  {
    this.paused = true;
  }
  
  public void resumeSending()
  {
    this.paused = false;
  }
  
  public void sendFirstPackage()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 4;
    this.internalHandler.sendMessage(localMessage);
  }
  
  public void sendNextPackage()
  {
    Message localMessage = Message.obtain();
    localMessage.arg1 = 3;
    this.internalHandler.sendMessage(localMessage);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.adjust.sdk.PackageHandler
 * JD-Core Version:    0.7.0.1
 */