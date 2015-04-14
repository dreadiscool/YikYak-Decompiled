package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;

class DocumentsContractApi19
{
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    boolean bool = false;
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {}
    for (;;)
    {
      return bool;
      if (!TextUtils.isEmpty(getRawType(paramContext, paramUri))) {
        bool = true;
      }
    }
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    boolean bool = false;
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {}
    for (;;)
    {
      return bool;
      String str = getRawType(paramContext, paramUri);
      int i = queryForInt(paramContext, paramUri, "flags", 0);
      if (!TextUtils.isEmpty(str)) {
        if ((i & 0x4) != 0) {
          bool = true;
        } else if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0)) {
          bool = true;
        } else if ((!TextUtils.isEmpty(str)) && ((i & 0x2) != 0)) {
          bool = true;
        }
      }
    }
  }
  
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
  
  public static boolean delete(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.deleteDocument(paramContext.getContentResolver(), paramUri);
  }
  
  /* Error */
  public static boolean exists(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 61	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_2
    //   5: iconst_1
    //   6: anewarray 41	java/lang/String
    //   9: astore 8
    //   11: aload 8
    //   13: iconst_0
    //   14: ldc 70
    //   16: aastore
    //   17: aload_2
    //   18: aload_1
    //   19: aload 8
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 9
    //   29: aload 9
    //   31: astore 4
    //   33: aload 4
    //   35: invokeinterface 82 1 0
    //   40: istore 10
    //   42: iload 10
    //   44: ifle +14 -> 58
    //   47: iconst_1
    //   48: istore 7
    //   50: aload 4
    //   52: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   55: iload 7
    //   57: ireturn
    //   58: iconst_0
    //   59: istore 7
    //   61: goto -11 -> 50
    //   64: astore 5
    //   66: aconst_null
    //   67: astore 4
    //   69: new 86	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   76: ldc 89
    //   78: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 5
    //   83: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: pop
    //   90: aload 4
    //   92: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   95: iconst_0
    //   96: istore 7
    //   98: goto -43 -> 55
    //   101: astore_3
    //   102: aconst_null
    //   103: astore 4
    //   105: aload 4
    //   107: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   110: aload_3
    //   111: athrow
    //   112: astore_3
    //   113: goto -8 -> 105
    //   116: astore 5
    //   118: goto -49 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   0	121	1	paramUri	Uri
    //   4	14	2	localContentResolver	android.content.ContentResolver
    //   101	10	3	localObject1	Object
    //   112	1	3	localObject2	Object
    //   31	75	4	localCursor1	android.database.Cursor
    //   64	18	5	localException1	Exception
    //   116	1	5	localException2	Exception
    //   48	49	7	bool	boolean
    //   9	11	8	arrayOfString	String[]
    //   27	3	9	localCursor2	android.database.Cursor
    //   40	3	10	i	int
    // Exception table:
    //   from	to	target	type
    //   5	29	64	java/lang/Exception
    //   5	29	101	finally
    //   33	42	112	finally
    //   69	90	112	finally
    //   33	42	116	java/lang/Exception
  }
  
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  public static String getType(Context paramContext, Uri paramUri)
  {
    String str = getRawType(paramContext, paramUri);
    if ("vnd.android.document/directory".equals(str)) {
      str = null;
    }
    return str;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isDocumentUri(Context paramContext, Uri paramUri)
  {
    return DocumentsContract.isDocumentUri(paramContext, paramUri);
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    String str = getRawType(paramContext, paramUri);
    if (("vnd.android.document/directory".equals(str)) || (TextUtils.isEmpty(str))) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static long lastModified(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt)
  {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  /* Error */
  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 61	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: iconst_1
    //   7: anewarray 41	java/lang/String
    //   10: astore 10
    //   12: aload 10
    //   14: iconst_0
    //   15: aload_2
    //   16: aastore
    //   17: aload 5
    //   19: aload_1
    //   20: aload 10
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore 11
    //   30: aload 11
    //   32: astore 7
    //   34: aload 7
    //   36: invokeinterface 130 1 0
    //   41: ifeq +34 -> 75
    //   44: aload 7
    //   46: iconst_0
    //   47: invokeinterface 134 2 0
    //   52: ifne +23 -> 75
    //   55: aload 7
    //   57: iconst_0
    //   58: invokeinterface 138 2 0
    //   63: lstore 12
    //   65: lload 12
    //   67: lstore_3
    //   68: aload 7
    //   70: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   73: lload_3
    //   74: lreturn
    //   75: aload 7
    //   77: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   80: goto -7 -> 73
    //   83: astore 8
    //   85: aconst_null
    //   86: astore 7
    //   88: new 86	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   95: ldc 89
    //   97: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 8
    //   102: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: pop
    //   109: aload 7
    //   111: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   114: goto -41 -> 73
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 7
    //   122: aload 7
    //   124: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   127: aload 6
    //   129: athrow
    //   130: astore 6
    //   132: goto -10 -> 122
    //   135: astore 8
    //   137: goto -49 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramContext	Context
    //   0	140	1	paramUri	Uri
    //   0	140	2	paramString	String
    //   0	140	3	paramLong	long
    //   4	14	5	localContentResolver	android.content.ContentResolver
    //   117	11	6	localObject1	Object
    //   130	1	6	localObject2	Object
    //   32	91	7	localCursor1	android.database.Cursor
    //   83	18	8	localException1	Exception
    //   135	1	8	localException2	Exception
    //   10	11	10	arrayOfString	String[]
    //   28	3	11	localCursor2	android.database.Cursor
    //   63	3	12	l	long
    // Exception table:
    //   from	to	target	type
    //   6	30	83	java/lang/Exception
    //   6	30	117	finally
    //   34	65	130	finally
    //   88	109	130	finally
    //   34	65	135	java/lang/Exception
  }
  
  /* Error */
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 61	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 4
    //   6: iconst_1
    //   7: anewarray 41	java/lang/String
    //   10: astore 9
    //   12: aload 9
    //   14: iconst_0
    //   15: aload_2
    //   16: aastore
    //   17: aload 4
    //   19: aload_1
    //   20: aload 9
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 76	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore 10
    //   30: aload 10
    //   32: astore 6
    //   34: aload 6
    //   36: invokeinterface 130 1 0
    //   41: ifeq +34 -> 75
    //   44: aload 6
    //   46: iconst_0
    //   47: invokeinterface 134 2 0
    //   52: ifne +23 -> 75
    //   55: aload 6
    //   57: iconst_0
    //   58: invokeinterface 142 2 0
    //   63: astore 11
    //   65: aload 11
    //   67: astore_3
    //   68: aload 6
    //   70: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   73: aload_3
    //   74: areturn
    //   75: aload 6
    //   77: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   80: goto -7 -> 73
    //   83: astore 7
    //   85: aconst_null
    //   86: astore 6
    //   88: new 86	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   95: ldc 89
    //   97: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 7
    //   102: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: pop
    //   109: aload 6
    //   111: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   114: goto -41 -> 73
    //   117: astore 5
    //   119: aconst_null
    //   120: astore 6
    //   122: aload 6
    //   124: invokestatic 84	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   127: aload 5
    //   129: athrow
    //   130: astore 5
    //   132: goto -10 -> 122
    //   135: astore 7
    //   137: goto -49 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramContext	Context
    //   0	140	1	paramUri	Uri
    //   0	140	2	paramString1	String
    //   0	140	3	paramString2	String
    //   4	14	4	localContentResolver	android.content.ContentResolver
    //   117	11	5	localObject1	Object
    //   130	1	5	localObject2	Object
    //   32	91	6	localCursor1	android.database.Cursor
    //   83	18	7	localException1	Exception
    //   135	1	7	localException2	Exception
    //   10	11	9	arrayOfString	String[]
    //   28	3	10	localCursor2	android.database.Cursor
    //   63	3	11	str	String
    // Exception table:
    //   from	to	target	type
    //   6	30	83	java/lang/Exception
    //   6	30	117	finally
    //   34	65	130	finally
    //   88	109	130	finally
    //   34	65	135	java/lang/Exception
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.provider.DocumentsContractApi19
 * JD-Core Version:    0.7.0.1
 */