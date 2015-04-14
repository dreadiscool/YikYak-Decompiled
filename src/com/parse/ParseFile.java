package com.parse;

import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import m;
import org.json.JSONException;
import org.json.JSONObject;
import y;

public class ParseFile
{
  private String contentType = null;
  private Set<m<?>.y> currentTasks = Collections.synchronizedSet(new HashSet());
  byte[] data;
  private boolean dirty = false;
  private String name = null;
  private ParseAWSRequest request;
  final TaskQueue taskQueue = new TaskQueue();
  private String url = null;
  
  ParseFile(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.url = paramString2;
  }
  
  public ParseFile(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString, paramArrayOfByte, null);
  }
  
  public ParseFile(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    if (paramArrayOfByte.length > Parse.maxParseFileSize)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(Parse.maxParseFileSize);
      throw new IllegalArgumentException(String.format("ParseFile must be less than %d bytes", arrayOfObject));
    }
    this.name = paramString1;
    this.data = paramArrayOfByte;
    this.contentType = paramString2;
    this.dirty = true;
  }
  
  ParseFile(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    this(paramJSONObject.optString("name"), paramJSONObject.optString("url"));
  }
  
  public ParseFile(byte[] paramArrayOfByte)
  {
    this(null, paramArrayOfByte, null);
  }
  
  public ParseFile(byte[] paramArrayOfByte, String paramString)
  {
    this(null, paramArrayOfByte, paramString);
  }
  
  static void clearCache()
  {
    File[] arrayOfFile = getCacheDir().listFiles();
    int i = arrayOfFile.length;
    for (int j = 0; j < i; j++) {
      ParseFileUtils.deleteQuietly(arrayOfFile[j]);
    }
  }
  
  private ParseCommand constructFileUploadCommand(String paramString)
  {
    ParseCommand localParseCommand = new ParseCommand("upload_file", paramString);
    localParseCommand.enableRetrying();
    if (this.name != null) {
      localParseCommand.put("name", this.name);
    }
    return localParseCommand;
  }
  
  static File getCacheDir()
  {
    return Parse.getParseCacheDir("files");
  }
  
  private byte[] getCachedData()
  {
    Object localObject;
    if (this.data != null) {
      localObject = this.data;
    }
    for (;;)
    {
      return localObject;
      try
      {
        File localFile2 = getCacheFile();
        if (localFile2 != null)
        {
          byte[] arrayOfByte2 = ParseFileUtils.readFileToByteArray(localFile2);
          localObject = arrayOfByte2;
        }
      }
      catch (IOException localIOException1)
      {
        try
        {
          File localFile1 = getFilesFile();
          if (localFile1 != null)
          {
            byte[] arrayOfByte1 = ParseFileUtils.readFileToByteArray(localFile1);
            localObject = arrayOfByte1;
          }
        }
        catch (IOException localIOException2)
        {
          localObject = null;
        }
      }
    }
  }
  
  private m<byte[]> getDataAsync(ProgressCallback paramProgressCallback, m<Void> paramm)
  {
    if (this.data != null) {}
    y localy;
    for (m localm = m.a(this.data);; localm = localy.a())
    {
      return localm;
      localy = m.a();
      this.currentTasks.add(localy);
      paramm.a(new ParseFile.6(this), m.a).a(new ParseFile.5(this, localy, paramProgressCallback));
    }
  }
  
  private String getFilename()
  {
    return this.name;
  }
  
  static File getFilesDir()
  {
    return Parse.getParseFilesDir("files");
  }
  
  private m<Void> handleFileUploadResultAsync(JSONObject paramJSONObject, ProgressCallback paramProgressCallback)
  {
    if (this.request == null) {
      prepareFileUploadPost(paramJSONObject, paramProgressCallback);
    }
    return this.request.executeAsync().j();
  }
  
  private void prepareFileUploadPost(JSONObject paramJSONObject, ProgressCallback paramProgressCallback)
  {
    for (String str1 = null;; str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2))
    {
      try
      {
        this.name = paramJSONObject.getString("name");
        this.url = paramJSONObject.getString("url");
        JSONObject localJSONObject = paramJSONObject.getJSONObject("post_params");
        if (this.contentType != null) {
          str1 = this.contentType;
        }
        while (this.name.lastIndexOf(".") == -1) {
          if (str1 == null) {
            str1 = "application/octet-stream";
          }
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          this.request = new ParseAWSRequest(1, paramJSONObject.getString("post_url"));
          this.request.setProgressCallback(paramProgressCallback);
          this.request.setMimeType(str1);
          this.request.setPostParams(localJSONObject);
          this.request.setData(getCachedData());
          return;
        }
        catch (JSONException localJSONException2)
        {
          String str2;
          throw new RuntimeException(localJSONException2.getMessage());
        }
        localJSONException1 = localJSONException1;
        throw new RuntimeException(localJSONException1.getMessage());
      }
      str2 = this.name.substring(1 + this.name.lastIndexOf("."));
    }
  }
  
  private void save(ProgressCallback paramProgressCallback)
  {
    Parse.waitForTask(saveInBackground(paramProgressCallback));
  }
  
  private void setPinned(boolean paramBoolean)
  {
    Parse.waitForTask(setPinnedInBackground(paramBoolean));
  }
  
  private m<Void> setPinnedInBackground(boolean paramBoolean)
  {
    return this.taskQueue.enqueue(new ParseFile.2(this)).a(new ParseFile.1(this, paramBoolean), m.a);
  }
  
  private void setPinnedInBackground(boolean paramBoolean, ParseCallback<Void> paramParseCallback)
  {
    Parse.callbackOnMainThreadAsync(setPinnedInBackground(paramBoolean), paramParseCallback);
  }
  
  public void cancel()
  {
    HashSet localHashSet = new HashSet(this.currentTasks);
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext()) {
      ((y)localIterator.next()).b();
    }
    this.currentTasks.removeAll(localHashSet);
  }
  
  JSONObject encode()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__type", "File");
    localJSONObject.put("name", getName());
    if (getUrl() == null) {
      throw new IllegalStateException("Unable to encode an unsaved ParseFile.");
    }
    localJSONObject.put("url", getUrl());
    return localJSONObject;
  }
  
  File getCacheFile()
  {
    String str = getFilename();
    if (str != null) {}
    for (File localFile = new File(getCacheDir(), str);; localFile = null) {
      return localFile;
    }
  }
  
  public byte[] getData()
  {
    return (byte[])Parse.waitForTask(getDataInBackground());
  }
  
  public m<byte[]> getDataInBackground()
  {
    return getDataInBackground((ProgressCallback)null);
  }
  
  public m<byte[]> getDataInBackground(ProgressCallback paramProgressCallback)
  {
    return this.taskQueue.enqueue(new ParseFile.7(this, paramProgressCallback));
  }
  
  public void getDataInBackground(GetDataCallback paramGetDataCallback)
  {
    Parse.callbackOnMainThreadAsync(getDataInBackground(), paramGetDataCallback);
  }
  
  public void getDataInBackground(GetDataCallback paramGetDataCallback, ProgressCallback paramProgressCallback)
  {
    Parse.callbackOnMainThreadAsync(getDataInBackground(paramProgressCallback), paramGetDataCallback);
  }
  
  File getFilesFile()
  {
    String str = getFilename();
    if (str != null) {}
    for (File localFile = new File(getFilesDir(), str);; localFile = null) {
      return localFile;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public boolean isDataAvailable()
  {
    if (this.data == null)
    {
      if (isPinned()) {
        break label28;
      }
      if (!getCacheFile().exists()) {
        break label38;
      }
    }
    label28:
    label38:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (getFilesFile().exists()) {
        break;
      }
    }
  }
  
  public boolean isDirty()
  {
    return this.dirty;
  }
  
  boolean isPinned()
  {
    File localFile = getFilesFile();
    if ((localFile != null) && (localFile.exists())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void pin()
  {
    setPinned(true);
  }
  
  m<Void> pinInBackground()
  {
    return setPinnedInBackground(true);
  }
  
  void pinInBackground(ParseCallback<Void> paramParseCallback)
  {
    setPinnedInBackground(true, paramParseCallback);
  }
  
  public void save()
  {
    Parse.waitForTask(saveInBackground());
  }
  
  m<Void> saveAsync(ProgressCallback paramProgressCallback, m<Void> paramm)
  {
    if (!isDirty()) {}
    y localy;
    for (m localm = m.a(null);; localm = localy.a())
    {
      return localm;
      localy = m.a();
      this.currentTasks.add(localy);
      paramm.a(new ParseFile.3(this, localy, paramProgressCallback));
    }
  }
  
  public m<Void> saveInBackground()
  {
    return saveInBackground((ProgressCallback)null);
  }
  
  public m<Void> saveInBackground(ProgressCallback paramProgressCallback)
  {
    return this.taskQueue.enqueue(new ParseFile.4(this, paramProgressCallback));
  }
  
  public void saveInBackground(SaveCallback paramSaveCallback)
  {
    Parse.callbackOnMainThreadAsync(saveInBackground(), paramSaveCallback);
  }
  
  public void saveInBackground(SaveCallback paramSaveCallback, ProgressCallback paramProgressCallback)
  {
    try
    {
      Parse.callbackOnMainThreadAsync(saveInBackground(paramProgressCallback), paramSaveCallback);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void unpin()
  {
    setPinned(false);
  }
  
  m<Void> unpinInBackground()
  {
    return setPinnedInBackground(false);
  }
  
  void unpinInBackground(ParseCallback<Void> paramParseCallback)
  {
    setPinnedInBackground(false, paramParseCallback);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFile
 * JD-Core Version:    0.7.0.1
 */