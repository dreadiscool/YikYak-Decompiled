package com.parse;

import android.net.http.AndroidHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import m;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

class ParseAWSRequest
  extends ParseRequest<byte[], byte[]>
{
  private byte[] data;
  private String mimeType;
  private JSONObject postParams;
  private ProgressCallback progressCallback;
  
  public ParseAWSRequest(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public ParseAWSRequest(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  protected org.apache.http.HttpEntity newEntity()
  {
    // Byte code:
    //   0: new 28	com/parse/CountingMultipartEntity
    //   3: dup
    //   4: getstatic 34	com/parse/entity/mime/HttpMultipartMode:BROWSER_COMPATIBLE	Lcom/parse/entity/mime/HttpMultipartMode;
    //   7: aload_0
    //   8: getfield 36	com/parse/ParseAWSRequest:progressCallback	Lcom/parse/ProgressCallback;
    //   11: invokespecial 39	com/parse/CountingMultipartEntity:<init>	(Lcom/parse/entity/mime/HttpMultipartMode;Lcom/parse/ProgressCallback;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc 41
    //   18: new 43	com/parse/entity/mime/content/StringBody
    //   21: dup
    //   22: aload_0
    //   23: getfield 45	com/parse/ParseAWSRequest:mimeType	Ljava/lang/String;
    //   26: invokespecial 46	com/parse/entity/mime/content/StringBody:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 50	com/parse/CountingMultipartEntity:addPart	(Ljava/lang/String;Lcom/parse/entity/mime/content/ContentBody;)V
    //   32: aload_0
    //   33: getfield 52	com/parse/ParseAWSRequest:postParams	Lorg/json/JSONObject;
    //   36: invokevirtual 58	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   39: astore_3
    //   40: aload_3
    //   41: invokeinterface 64 1 0
    //   46: ifeq +82 -> 128
    //   49: aload_3
    //   50: invokeinterface 68 1 0
    //   55: checkcast 70	java/lang/String
    //   58: astore 4
    //   60: aload_1
    //   61: aload 4
    //   63: new 43	com/parse/entity/mime/content/StringBody
    //   66: dup
    //   67: aload_0
    //   68: getfield 52	com/parse/ParseAWSRequest:postParams	Lorg/json/JSONObject;
    //   71: aload 4
    //   73: invokevirtual 74	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: invokespecial 46	com/parse/entity/mime/content/StringBody:<init>	(Ljava/lang/String;)V
    //   79: invokevirtual 50	com/parse/CountingMultipartEntity:addPart	(Ljava/lang/String;Lcom/parse/entity/mime/content/ContentBody;)V
    //   82: goto -42 -> 40
    //   85: astore 6
    //   87: new 76	java/lang/RuntimeException
    //   90: dup
    //   91: aload 6
    //   93: invokevirtual 80	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   96: invokespecial 81	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   99: athrow
    //   100: astore_2
    //   101: new 76	java/lang/RuntimeException
    //   104: dup
    //   105: aload_2
    //   106: invokevirtual 80	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   109: invokespecial 81	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   112: athrow
    //   113: astore 5
    //   115: new 76	java/lang/RuntimeException
    //   118: dup
    //   119: aload 5
    //   121: invokevirtual 82	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   124: invokespecial 81	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: aload_1
    //   129: ldc 84
    //   131: new 86	com/parse/entity/mime/content/ByteArrayBody
    //   134: dup
    //   135: aload_0
    //   136: getfield 88	com/parse/ParseAWSRequest:data	[B
    //   139: aload_0
    //   140: getfield 45	com/parse/ParseAWSRequest:mimeType	Ljava/lang/String;
    //   143: ldc 84
    //   145: invokespecial 91	com/parse/entity/mime/content/ByteArrayBody:<init>	([BLjava/lang/String;Ljava/lang/String;)V
    //   148: invokevirtual 50	com/parse/CountingMultipartEntity:addPart	(Ljava/lang/String;Lcom/parse/entity/mime/content/ContentBody;)V
    //   151: aload_1
    //   152: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	ParseAWSRequest
    //   14	138	1	localCountingMultipartEntity	CountingMultipartEntity
    //   100	6	2	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   39	11	3	localIterator	java.util.Iterator
    //   58	14	4	str	String
    //   113	7	5	localJSONException	org.json.JSONException
    //   85	7	6	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   60	82	85	java/io/UnsupportedEncodingException
    //   15	32	100	java/io/UnsupportedEncodingException
    //   60	82	113	org/json/JSONException
  }
  
  protected byte[] onResponse(HttpResponse paramHttpResponse, ProgressCallback paramProgressCallback)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    Header[] arrayOfHeader;
    if (((i >= 200) && (i < 300)) || (i == 304))
    {
      if (this.method != 0) {
        break label246;
      }
      arrayOfHeader = paramHttpResponse.getHeaders("Content-Length");
      if (arrayOfHeader.length <= 0) {
        break label252;
      }
    }
    label246:
    label252:
    for (int j = Integer.parseInt(arrayOfHeader[0].getValue());; j = -1)
    {
      InputStream localInputStream = AndroidHttpClient.getUngzippedContent(paramHttpResponse.getEntity());
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte2 = new byte[32768];
      int k = 0;
      for (;;)
      {
        int m = localInputStream.read(arrayOfByte2, 0, arrayOfByte2.length);
        if (m == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte2, 0, m);
        k += m;
        if ((paramProgressCallback != null) && (j != -1)) {
          Parse.callbackOnMainThreadAsync(m.a(Integer.valueOf(Math.round(100.0F * (k / j)))), paramProgressCallback);
        }
      }
      if (this.method == 0) {}
      for (String str = "Download from";; str = "Upload to")
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramHttpResponse.getStatusLine().getReasonPhrase();
        throw new ParseException(100, String.format("%s S3 failed. %s", arrayOfObject));
      }
      for (byte[] arrayOfByte1 = localByteArrayOutputStream.toByteArray();; arrayOfByte1 = null) {
        return arrayOfByte1;
      }
    }
  }
  
  public void setData(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public void setMimeType(String paramString)
  {
    this.mimeType = paramString;
  }
  
  public void setPostParams(JSONObject paramJSONObject)
  {
    this.postParams = paramJSONObject;
  }
  
  public void setProgressCallback(ProgressCallback paramProgressCallback)
  {
    this.progressCallback = paramProgressCallback;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseAWSRequest
 * JD-Core Version:    0.7.0.1
 */