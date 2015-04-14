package com.facebook;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.ParcelFileDescriptor;
import com.facebook.internal.Logger;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class Request$Serializer
  implements Request.KeyValueSerializer
{
  private boolean firstWrite = true;
  private final Logger logger;
  private final OutputStream outputStream;
  private boolean useUrlEncode = false;
  
  public Request$Serializer(OutputStream paramOutputStream, Logger paramLogger, boolean paramBoolean)
  {
    this.outputStream = paramOutputStream;
    this.logger = paramLogger;
    this.useUrlEncode = paramBoolean;
  }
  
  public void write(String paramString, Object... paramVarArgs)
  {
    if (!this.useUrlEncode)
    {
      if (this.firstWrite)
      {
        this.outputStream.write("--".getBytes());
        this.outputStream.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
        this.outputStream.write("\r\n".getBytes());
        this.firstWrite = false;
      }
      this.outputStream.write(String.format(paramString, paramVarArgs).getBytes());
    }
    for (;;)
    {
      return;
      this.outputStream.write(URLEncoder.encode(String.format(paramString, paramVarArgs), "UTF-8").getBytes());
    }
  }
  
  public void writeBitmap(String paramString, Bitmap paramBitmap)
  {
    writeContentDisposition(paramString, paramString, "image/png");
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
    writeLine("", new Object[0]);
    writeRecordBoundary();
    if (this.logger != null) {
      this.logger.appendKeyValue("    " + paramString, "<Image>");
    }
  }
  
  public void writeBytes(String paramString, byte[] paramArrayOfByte)
  {
    writeContentDisposition(paramString, paramString, "content/unknown");
    this.outputStream.write(paramArrayOfByte);
    writeLine("", new Object[0]);
    writeRecordBoundary();
    if (this.logger != null)
    {
      Logger localLogger = this.logger;
      String str = "    " + paramString;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramArrayOfByte.length);
      localLogger.appendKeyValue(str, String.format("<Data: %d>", arrayOfObject));
    }
  }
  
  public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
  {
    if (!this.useUrlEncode)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramString1;
      write("Content-Disposition: form-data; name=\"%s\"", arrayOfObject2);
      if (paramString2 != null)
      {
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = paramString2;
        write("; filename=\"%s\"", arrayOfObject4);
      }
      writeLine("", new Object[0]);
      if (paramString3 != null)
      {
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = "Content-Type";
        arrayOfObject3[1] = paramString3;
        writeLine("%s: %s", arrayOfObject3);
      }
      writeLine("", new Object[0]);
    }
    for (;;)
    {
      return;
      OutputStream localOutputStream = this.outputStream;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramString1;
      localOutputStream.write(String.format("%s=", arrayOfObject1).getBytes());
    }
  }
  
  /* Error */
  public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_3
    //   4: ifnonnull +6 -> 10
    //   7: ldc 110
    //   9: astore_3
    //   10: aload_0
    //   11: aload_1
    //   12: aload_1
    //   13: aload_3
    //   14: invokevirtual 65	com/facebook/Request$Serializer:writeContentDisposition	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 24	com/facebook/Request$Serializer:outputStream	Ljava/io/OutputStream;
    //   21: instanceof 134
    //   24: ifeq +98 -> 122
    //   27: aload_0
    //   28: getfield 24	com/facebook/Request$Serializer:outputStream	Ljava/io/OutputStream;
    //   31: checkcast 134	com/facebook/ProgressNoopOutputStream
    //   34: aload_2
    //   35: invokevirtual 140	android/os/ParcelFileDescriptor:getStatSize	()J
    //   38: invokevirtual 144	com/facebook/ProgressNoopOutputStream:addProgress	(J)V
    //   41: iconst_0
    //   42: istore 10
    //   44: aload_0
    //   45: ldc 79
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokevirtual 82	com/facebook/Request$Serializer:writeLine	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_0
    //   55: invokevirtual 85	com/facebook/Request$Serializer:writeRecordBoundary	()V
    //   58: aload_0
    //   59: getfield 26	com/facebook/Request$Serializer:logger	Lcom/facebook/internal/Logger;
    //   62: ifnull +59 -> 121
    //   65: aload_0
    //   66: getfield 26	com/facebook/Request$Serializer:logger	Lcom/facebook/internal/Logger;
    //   69: astore 12
    //   71: new 87	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   78: ldc 90
    //   80: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 13
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: astore 14
    //   98: aload 14
    //   100: iconst_0
    //   101: iload 10
    //   103: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: aload 12
    //   109: aload 13
    //   111: ldc 118
    //   113: aload 14
    //   115: invokestatic 49	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   118: invokevirtual 106	com/facebook/internal/Logger:appendKeyValue	(Ljava/lang/String;Ljava/lang/Object;)V
    //   121: return
    //   122: new 146	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   125: dup
    //   126: aload_2
    //   127: invokespecial 149	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   130: astore 5
    //   132: new 151	java/io/BufferedInputStream
    //   135: dup
    //   136: aload 5
    //   138: invokespecial 154	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   141: astore 6
    //   143: sipush 8192
    //   146: newarray byte
    //   148: astore 9
    //   150: iconst_0
    //   151: istore 10
    //   153: aload 6
    //   155: aload 9
    //   157: invokevirtual 158	java/io/BufferedInputStream:read	([B)I
    //   160: istore 11
    //   162: iload 11
    //   164: bipush 255
    //   166: if_icmpeq +25 -> 191
    //   169: aload_0
    //   170: getfield 24	com/facebook/Request$Serializer:outputStream	Ljava/io/OutputStream;
    //   173: aload 9
    //   175: iconst_0
    //   176: iload 11
    //   178: invokevirtual 161	java/io/OutputStream:write	([BII)V
    //   181: iload 10
    //   183: iload 11
    //   185: iadd
    //   186: istore 10
    //   188: goto -35 -> 153
    //   191: aload 6
    //   193: ifnull +8 -> 201
    //   196: aload 6
    //   198: invokevirtual 164	java/io/BufferedInputStream:close	()V
    //   201: aload 5
    //   203: ifnull -159 -> 44
    //   206: aload 5
    //   208: invokevirtual 165	android/os/ParcelFileDescriptor$AutoCloseInputStream:close	()V
    //   211: goto -167 -> 44
    //   214: astore 7
    //   216: aconst_null
    //   217: astore 8
    //   219: aload 8
    //   221: ifnull +8 -> 229
    //   224: aload 8
    //   226: invokevirtual 164	java/io/BufferedInputStream:close	()V
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 165	android/os/ParcelFileDescriptor$AutoCloseInputStream:close	()V
    //   239: aload 7
    //   241: athrow
    //   242: astore 7
    //   244: aconst_null
    //   245: astore 8
    //   247: aload 5
    //   249: astore 4
    //   251: goto -32 -> 219
    //   254: astore 7
    //   256: aload 6
    //   258: astore 8
    //   260: aload 5
    //   262: astore 4
    //   264: goto -45 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	Serializer
    //   0	267	1	paramString1	String
    //   0	267	2	paramParcelFileDescriptor	ParcelFileDescriptor
    //   0	267	3	paramString2	String
    //   1	262	4	localObject1	Object
    //   130	131	5	localAutoCloseInputStream	android.os.ParcelFileDescriptor.AutoCloseInputStream
    //   141	116	6	localBufferedInputStream1	java.io.BufferedInputStream
    //   214	26	7	localObject2	Object
    //   242	1	7	localObject3	Object
    //   254	1	7	localObject4	Object
    //   217	42	8	localBufferedInputStream2	java.io.BufferedInputStream
    //   148	26	9	arrayOfByte	byte[]
    //   42	145	10	i	int
    //   160	26	11	j	int
    //   69	39	12	localLogger	Logger
    //   90	20	13	str	String
    //   96	18	14	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   122	132	214	finally
    //   132	143	242	finally
    //   143	181	254	finally
  }
  
  public void writeFile(String paramString, Request.ParcelFileDescriptorWithMimeType paramParcelFileDescriptorWithMimeType)
  {
    writeFile(paramString, paramParcelFileDescriptorWithMimeType.getFileDescriptor(), paramParcelFileDescriptorWithMimeType.getMimeType());
  }
  
  public void writeLine(String paramString, Object... paramVarArgs)
  {
    write(paramString, paramVarArgs);
    if (!this.useUrlEncode) {
      write("\r\n", new Object[0]);
    }
  }
  
  public void writeObject(String paramString, Object paramObject, Request paramRequest)
  {
    if ((this.outputStream instanceof RequestOutputStream)) {
      ((RequestOutputStream)this.outputStream).setCurrentRequest(paramRequest);
    }
    if (Request.access$100(paramObject)) {
      writeString(paramString, Request.access$200(paramObject));
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Bitmap))
      {
        writeBitmap(paramString, (Bitmap)paramObject);
      }
      else if ((paramObject instanceof byte[]))
      {
        writeBytes(paramString, (byte[])paramObject);
      }
      else if ((paramObject instanceof ParcelFileDescriptor))
      {
        writeFile(paramString, (ParcelFileDescriptor)paramObject, null);
      }
      else
      {
        if (!(paramObject instanceof Request.ParcelFileDescriptorWithMimeType)) {
          break;
        }
        writeFile(paramString, (Request.ParcelFileDescriptorWithMimeType)paramObject);
      }
    }
    throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
  }
  
  public void writeRecordBoundary()
  {
    if (!this.useUrlEncode)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
      writeLine("--%s", arrayOfObject);
    }
    for (;;)
    {
      return;
      this.outputStream.write("&".getBytes());
    }
  }
  
  public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection<Request> paramCollection)
  {
    if (!(this.outputStream instanceof RequestOutputStream)) {
      writeString(paramString, paramJSONArray.toString());
    }
    for (;;)
    {
      return;
      RequestOutputStream localRequestOutputStream = (RequestOutputStream)this.outputStream;
      writeContentDisposition(paramString, null, null);
      write("[", new Object[0]);
      Iterator localIterator = paramCollection.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Request localRequest = (Request)localIterator.next();
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localRequestOutputStream.setCurrentRequest(localRequest);
        if (i > 0)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localJSONObject.toString();
          write(",%s", arrayOfObject2);
        }
        for (;;)
        {
          i++;
          break;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = localJSONObject.toString();
          write("%s", arrayOfObject1);
        }
      }
      write("]", new Object[0]);
      if (this.logger != null) {
        this.logger.appendKeyValue("    " + paramString, paramJSONArray.toString());
      }
    }
  }
  
  public void writeString(String paramString1, String paramString2)
  {
    writeContentDisposition(paramString1, null, null);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString2;
    writeLine("%s", arrayOfObject);
    writeRecordBoundary();
    if (this.logger != null) {
      this.logger.appendKeyValue("    " + paramString1, paramString2);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.Request.Serializer
 * JD-Core Version:    0.7.0.1
 */