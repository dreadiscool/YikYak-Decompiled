package com.facebook.internal;

import com.facebook.LoggingBehavior;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

final class FileLruCache$StreamHeader
{
  private static final int HEADER_VERSION;
  
  static JSONObject readHeader(InputStream paramInputStream)
  {
    int i = 0;
    JSONObject localJSONObject;
    if (paramInputStream.read() != 0) {
      localJSONObject = null;
    }
    for (;;)
    {
      return localJSONObject;
      int j = 0;
      int k = 0;
      for (;;)
      {
        if (j >= 3) {
          break label72;
        }
        int n = paramInputStream.read();
        if (n == -1)
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
          localJSONObject = null;
          break;
        }
        k = (k << 8) + (n & 0xFF);
        j++;
      }
      label72:
      byte[] arrayOfByte = new byte[k];
      for (;;)
      {
        if (i >= arrayOfByte.length) {
          break label160;
        }
        int m = paramInputStream.read(arrayOfByte, i, arrayOfByte.length - i);
        if (m < 1)
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + arrayOfByte.length);
          localJSONObject = null;
          break;
        }
        i += m;
      }
      label160:
      JSONTokener localJSONTokener = new JSONTokener(new String(arrayOfByte));
      try
      {
        Object localObject = localJSONTokener.nextValue();
        if (!(localObject instanceof JSONObject))
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + localObject.getClass().getCanonicalName());
          localJSONObject = null;
          continue;
        }
        localJSONObject = (JSONObject)localObject;
      }
      catch (JSONException localJSONException)
      {
        throw new IOException(localJSONException.getMessage());
      }
    }
  }
  
  static void writeHeader(OutputStream paramOutputStream, JSONObject paramJSONObject)
  {
    byte[] arrayOfByte = paramJSONObject.toString().getBytes();
    paramOutputStream.write(0);
    paramOutputStream.write(0xFF & arrayOfByte.length >> 16);
    paramOutputStream.write(0xFF & arrayOfByte.length >> 8);
    paramOutputStream.write(0xFF & arrayOfByte.length >> 0);
    paramOutputStream.write(arrayOfByte);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.StreamHeader
 * JD-Core Version:    0.7.0.1
 */