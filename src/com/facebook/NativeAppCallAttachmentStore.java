package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

public final class NativeAppCallAttachmentStore
  implements NativeAppCallContentProvider.AttachmentDataSource
{
  static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
  private static final String TAG = NativeAppCallAttachmentStore.class.getName();
  private static File attachmentsDirectory;
  
  /* Error */
  private <T> void addAttachments(Context paramContext, UUID paramUUID, Map<String, T> paramMap, NativeAppCallAttachmentStore.ProcessAttachment<T> paramProcessAttachment)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface 38 1 0
    //   6: ifne +4 -> 10
    //   9: return
    //   10: getstatic 40	com/facebook/NativeAppCallAttachmentStore:attachmentsDirectory	Ljava/io/File;
    //   13: ifnonnull +8 -> 21
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 44	com/facebook/NativeAppCallAttachmentStore:cleanupAllAttachments	(Landroid/content/Context;)V
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 48	com/facebook/NativeAppCallAttachmentStore:ensureAttachmentsDirectoryExists	(Landroid/content/Context;)Ljava/io/File;
    //   26: pop
    //   27: new 50	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 51	java/util/ArrayList:<init>	()V
    //   34: astore 6
    //   36: aload_3
    //   37: invokeinterface 55 1 0
    //   42: invokeinterface 61 1 0
    //   47: astore 13
    //   49: aload 13
    //   51: invokeinterface 67 1 0
    //   56: ifeq -47 -> 9
    //   59: aload 13
    //   61: invokeinterface 71 1 0
    //   66: checkcast 73	java/util/Map$Entry
    //   69: astore 14
    //   71: aload 14
    //   73: invokeinterface 76 1 0
    //   78: checkcast 78	java/lang/String
    //   81: astore 15
    //   83: aload 14
    //   85: invokeinterface 81 1 0
    //   90: astore 16
    //   92: aload_0
    //   93: aload_2
    //   94: aload 15
    //   96: iconst_1
    //   97: invokevirtual 85	com/facebook/NativeAppCallAttachmentStore:getAttachmentFile	(Ljava/util/UUID;Ljava/lang/String;Z)Ljava/io/File;
    //   100: astore 17
    //   102: aload 6
    //   104: aload 17
    //   106: invokeinterface 91 2 0
    //   111: pop
    //   112: aload 4
    //   114: aload 16
    //   116: aload 17
    //   118: invokeinterface 97 3 0
    //   123: goto -74 -> 49
    //   126: astore 7
    //   128: new 99	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   135: ldc 102
    //   137: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload 7
    //   142: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: pop
    //   149: aload 6
    //   151: invokeinterface 113 1 0
    //   156: astore 9
    //   158: aload 9
    //   160: invokeinterface 67 1 0
    //   165: ifeq +29 -> 194
    //   168: aload 9
    //   170: invokeinterface 71 1 0
    //   175: checkcast 115	java/io/File
    //   178: astore 10
    //   180: aload 10
    //   182: invokevirtual 118	java/io/File:delete	()Z
    //   185: pop
    //   186: goto -28 -> 158
    //   189: astore 11
    //   191: goto -33 -> 158
    //   194: new 120	com/facebook/FacebookException
    //   197: dup
    //   198: aload 7
    //   200: invokespecial 123	com/facebook/FacebookException:<init>	(Ljava/lang/Throwable;)V
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	NativeAppCallAttachmentStore
    //   0	204	1	paramContext	Context
    //   0	204	2	paramUUID	UUID
    //   0	204	3	paramMap	Map<String, T>
    //   0	204	4	paramProcessAttachment	NativeAppCallAttachmentStore.ProcessAttachment<T>
    //   34	116	6	localArrayList	java.util.ArrayList
    //   126	73	7	localIOException	IOException
    //   156	13	9	localIterator1	java.util.Iterator
    //   178	3	10	localFile1	File
    //   189	1	11	localException	java.lang.Exception
    //   47	13	13	localIterator2	java.util.Iterator
    //   69	15	14	localEntry	java.util.Map.Entry
    //   81	14	15	str	String
    //   90	25	16	localObject	Object
    //   100	17	17	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   36	123	126	java/io/IOException
    //   180	186	189	java/lang/Exception
  }
  
  static File getAttachmentsDirectory(Context paramContext)
  {
    try
    {
      if (attachmentsDirectory == null) {
        attachmentsDirectory = new File(paramContext.getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
      }
      File localFile = attachmentsDirectory;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void addAttachmentFilesForCall(Context paramContext, UUID paramUUID, Map<String, File> paramMap)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramUUID, "callId");
    Validate.containsNoNulls(paramMap.values(), "mediaAttachmentFiles");
    Validate.containsNoNullOrEmpty(paramMap.keySet(), "mediaAttachmentFiles");
    addAttachments(paramContext, paramUUID, paramMap, new NativeAppCallAttachmentStore.2(this));
  }
  
  public void addAttachmentsForCall(Context paramContext, UUID paramUUID, Map<String, Bitmap> paramMap)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramUUID, "callId");
    Validate.containsNoNulls(paramMap.values(), "imageAttachments");
    Validate.containsNoNullOrEmpty(paramMap.keySet(), "imageAttachments");
    addAttachments(paramContext, paramUUID, paramMap, new NativeAppCallAttachmentStore.1(this));
  }
  
  void cleanupAllAttachments(Context paramContext)
  {
    Utility.deleteDirectory(getAttachmentsDirectory(paramContext));
  }
  
  public void cleanupAttachmentsForCall(Context paramContext, UUID paramUUID)
  {
    Utility.deleteDirectory(getAttachmentsDirectoryForCall(paramUUID, false));
  }
  
  File ensureAttachmentsDirectoryExists(Context paramContext)
  {
    File localFile = getAttachmentsDirectory(paramContext);
    localFile.mkdirs();
    return localFile;
  }
  
  File getAttachmentFile(UUID paramUUID, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    File localFile1 = getAttachmentsDirectoryForCall(paramUUID, paramBoolean);
    if (localFile1 == null) {}
    for (;;)
    {
      return localObject;
      try
      {
        File localFile2 = new File(localFile1, URLEncoder.encode(paramString, "UTF-8"));
        localObject = localFile2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    }
  }
  
  File getAttachmentsDirectoryForCall(UUID paramUUID, boolean paramBoolean)
  {
    File localFile;
    if (attachmentsDirectory == null) {
      localFile = null;
    }
    for (;;)
    {
      return localFile;
      localFile = new File(attachmentsDirectory, paramUUID.toString());
      if ((paramBoolean) && (!localFile.exists())) {
        localFile.mkdirs();
      }
    }
  }
  
  public File openAttachment(UUID paramUUID, String paramString)
  {
    if ((Utility.isNullOrEmpty(paramString)) || (paramUUID == null)) {
      throw new FileNotFoundException();
    }
    try
    {
      File localFile = getAttachmentFile(paramUUID, paramString, false);
      return localFile;
    }
    catch (IOException localIOException)
    {
      throw new FileNotFoundException();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.NativeAppCallAttachmentStore
 * JD-Core Version:    0.7.0.1
 */