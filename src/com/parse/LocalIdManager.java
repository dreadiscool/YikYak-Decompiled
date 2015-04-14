package com.parse;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

class LocalIdManager
{
  private static LocalIdManager defaultInstance;
  private File diskPath = new File(Parse.getParseDir(), "LocalId");
  private Random random;
  
  private LocalIdManager()
  {
    this.diskPath.mkdirs();
    this.random = new Random();
  }
  
  public static LocalIdManager getDefaultInstance()
  {
    try
    {
      if (defaultInstance == null) {
        defaultInstance = new LocalIdManager();
      }
      LocalIdManager localLocalIdManager = defaultInstance;
      return localLocalIdManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private LocalIdManager.MapEntry getMapEntry(String paramString)
  {
    try
    {
      if (!isLocalId(paramString)) {
        throw new IllegalStateException("Tried to get invalid local id: \"" + paramString + "\".");
      }
    }
    finally {}
    File localFile = new File(this.diskPath, paramString);
    LocalIdManager.MapEntry localMapEntry;
    if (!localFile.exists()) {
      localMapEntry = new LocalIdManager.MapEntry(this, null);
    }
    for (;;)
    {
      return localMapEntry;
      JSONObject localJSONObject = Parse.getDiskObject(localFile);
      localMapEntry = new LocalIdManager.MapEntry(this, null);
      localMapEntry.retainCount = localJSONObject.optInt("retainCount", 0);
      localMapEntry.objectId = localJSONObject.optString("objectId", null);
    }
  }
  
  private boolean isLocalId(String paramString)
  {
    boolean bool;
    if (!paramString.startsWith("local_")) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      for (int i = 6;; i++)
      {
        if (i >= paramString.length()) {
          break label70;
        }
        int j = paramString.charAt(i);
        if (((j < 48) || (j > 57)) && ((j < 97) || (j > 102)))
        {
          bool = false;
          break;
        }
      }
      label70:
      bool = true;
    }
  }
  
  private void putMapEntry(String paramString, LocalIdManager.MapEntry paramMapEntry)
  {
    try
    {
      if (!isLocalId(paramString)) {
        throw new IllegalStateException("Tried to get invalid local id: \"" + paramString + "\".");
      }
    }
    finally {}
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retainCount", paramMapEntry.retainCount);
      if (paramMapEntry.objectId != null) {
        localJSONObject.put("objectId", paramMapEntry.objectId);
      }
      File localFile = new File(this.diskPath, paramString);
      if (!this.diskPath.exists()) {
        this.diskPath.mkdirs();
      }
      Parse.saveDiskObject(localFile, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException("Error creating local id map entry.", localJSONException);
    }
  }
  
  private void removeMapEntry(String paramString)
  {
    try
    {
      if (!isLocalId(paramString)) {
        throw new IllegalStateException("Tried to get invalid local id: \"" + paramString + "\".");
      }
    }
    finally {}
    new File(this.diskPath, paramString).delete();
  }
  
  boolean clear()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        String[] arrayOfString = this.diskPath.list();
        if (arrayOfString == null) {
          return i;
        }
        if (arrayOfString.length == 0) {
          continue;
        }
        int k = arrayOfString.length;
        if (i >= k) {
          break label104;
        }
        String str = arrayOfString[i];
        if (!new File(this.diskPath, str).delete()) {
          throw new IOException("Unable to delete file " + str + " in localId cache.");
        }
      }
      finally {}
      i += 1;
      continue;
      label104:
      int j = 1;
    }
  }
  
  String createLocalId()
  {
    String str;
    try
    {
      long l = this.random.nextLong();
      str = "local_" + Long.toHexString(l);
      if (!isLocalId(str)) {
        throw new IllegalStateException("Generated an invalid local id: \"" + str + "\". " + "This should never happen. Contact us at https://parse.com/help");
      }
    }
    finally {}
    return str;
  }
  
  String getObjectId(String paramString)
  {
    try
    {
      String str = getMapEntry(paramString).objectId;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void releaseLocalIdOnDisk(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 174	com/parse/LocalIdManager:getMapEntry	(Ljava/lang/String;)Lcom/parse/LocalIdManager$MapEntry;
    //   7: astore_3
    //   8: aload_3
    //   9: bipush 255
    //   11: aload_3
    //   12: getfield 92	com/parse/LocalIdManager$MapEntry:retainCount	I
    //   15: iadd
    //   16: putfield 92	com/parse/LocalIdManager$MapEntry:retainCount	I
    //   19: aload_3
    //   20: getfield 92	com/parse/LocalIdManager$MapEntry:retainCount	I
    //   23: ifle +12 -> 35
    //   26: aload_0
    //   27: aload_1
    //   28: aload_3
    //   29: invokespecial 177	com/parse/LocalIdManager:putMapEntry	(Ljava/lang/String;Lcom/parse/LocalIdManager$MapEntry;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 179	com/parse/LocalIdManager:removeMapEntry	(Ljava/lang/String;)V
    //   40: goto -8 -> 32
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	LocalIdManager
    //   0	48	1	paramString	String
    //   43	4	2	localObject	Object
    //   7	22	3	localMapEntry	LocalIdManager.MapEntry
    // Exception table:
    //   from	to	target	type
    //   2	32	43	finally
    //   35	40	43	finally
  }
  
  void retainLocalIdOnDisk(String paramString)
  {
    try
    {
      LocalIdManager.MapEntry localMapEntry = getMapEntry(paramString);
      localMapEntry.retainCount = (1 + localMapEntry.retainCount);
      putMapEntry(paramString, localMapEntry);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void setObjectId(String paramString1, String paramString2)
  {
    LocalIdManager.MapEntry localMapEntry;
    try
    {
      localMapEntry = getMapEntry(paramString1);
      if (localMapEntry.retainCount <= 0) {
        break label53;
      }
      if (localMapEntry.objectId != null) {
        throw new IllegalStateException("Tried to set an objectId for a localId that already has one.");
      }
    }
    finally {}
    localMapEntry.objectId = paramString2;
    putMapEntry(paramString1, localMapEntry);
    label53:
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.LocalIdManager
 * JD-Core Version:    0.7.0.1
 */