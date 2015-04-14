package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;

class DocumentsContractApi21
{
  private static final String TAG = "DocumentFile";
  
  private static void closeQuietly(AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      paramAutoCloseable.close();
      label10:
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      break label10;
    }
  }
  
  public static Uri createDirectory(Context paramContext, Uri paramUri, String paramString)
  {
    return createFile(paramContext, paramUri, "vnd.android.document/directory", paramString);
  }
  
  public static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    return DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
  }
  
  /* Error */
  public static Uri[] listFiles(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 37	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: aload_1
    //   6: aload_1
    //   7: invokestatic 49	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   10: invokestatic 53	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_3
    //   14: new 55	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 56	java/util/ArrayList:<init>	()V
    //   21: astore 4
    //   23: iconst_1
    //   24: anewarray 58	java/lang/String
    //   27: astore 9
    //   29: aload 9
    //   31: iconst_0
    //   32: ldc 60
    //   34: aastore
    //   35: aload_2
    //   36: aload_3
    //   37: aload 9
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 10
    //   47: aload 10
    //   49: astore 6
    //   51: aload 6
    //   53: invokeinterface 72 1 0
    //   58: ifeq +69 -> 127
    //   61: aload 4
    //   63: aload_1
    //   64: aload 6
    //   66: iconst_0
    //   67: invokeinterface 76 2 0
    //   72: invokestatic 79	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   75: invokevirtual 83	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   78: pop
    //   79: goto -28 -> 51
    //   82: astore 5
    //   84: new 85	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   91: ldc 88
    //   93: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload 5
    //   98: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: pop
    //   105: aload 6
    //   107: invokestatic 101	android/support/v4/provider/DocumentsContractApi21:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   110: aload 4
    //   112: aload 4
    //   114: invokevirtual 105	java/util/ArrayList:size	()I
    //   117: anewarray 107	android/net/Uri
    //   120: invokevirtual 111	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   123: checkcast 113	[Landroid/net/Uri;
    //   126: areturn
    //   127: aload 6
    //   129: invokestatic 101	android/support/v4/provider/DocumentsContractApi21:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   132: goto -22 -> 110
    //   135: astore 7
    //   137: aconst_null
    //   138: astore 6
    //   140: aload 6
    //   142: invokestatic 101	android/support/v4/provider/DocumentsContractApi21:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   145: aload 7
    //   147: athrow
    //   148: astore 7
    //   150: goto -10 -> 140
    //   153: astore 5
    //   155: aconst_null
    //   156: astore 6
    //   158: goto -74 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramContext	Context
    //   0	161	1	paramUri	Uri
    //   4	32	2	localContentResolver	android.content.ContentResolver
    //   13	24	3	localUri	Uri
    //   21	92	4	localArrayList	java.util.ArrayList
    //   82	15	5	localException1	Exception
    //   153	1	5	localException2	Exception
    //   49	108	6	localCursor1	android.database.Cursor
    //   135	11	7	localObject1	Object
    //   148	1	7	localObject2	Object
    //   27	11	9	arrayOfString	String[]
    //   45	3	10	localCursor2	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   51	79	82	java/lang/Exception
    //   23	47	135	finally
    //   51	79	148	finally
    //   84	105	148	finally
    //   23	47	153	java/lang/Exception
  }
  
  public static Uri prepareTreeUri(Uri paramUri)
  {
    return DocumentsContract.buildDocumentUriUsingTree(paramUri, DocumentsContract.getTreeDocumentId(paramUri));
  }
  
  public static Uri renameTo(Context paramContext, Uri paramUri, String paramString)
  {
    return DocumentsContract.renameDocument(paramContext.getContentResolver(), paramUri, paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.provider.DocumentsContractApi21
 * JD-Core Version:    0.7.0.1
 */