import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

class vh
{
  private byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting()))
        {
          bool = true;
          if (uJ.a)
          {
            StringBuilder localStringBuilder = new StringBuilder().append("ConnectivityManager says we ");
            String str;
            if (bool)
            {
              str = "are";
              localStringBuilder.append(str).append(" online").toString();
            }
            else
            {
              str = "are not";
              continue;
            }
          }
          return bool;
        }
      }
      catch (SecurityException localSecurityException)
      {
        bool = true;
      }
      boolean bool = false;
    }
  }
  
  public byte[] a(Context paramContext, String[] paramArrayOfString)
  {
    Object localObject = null;
    if (!a(paramContext)) {}
    for (;;)
    {
      return localObject;
      int i = paramArrayOfString.length;
      int j = 0;
      label19:
      if (j < i)
      {
        String str = paramArrayOfString[j];
        try
        {
          byte[] arrayOfByte = a(str, null);
          localObject = arrayOfByte;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          new StringBuilder().append("Cannot interpret ").append(str).append(" as a URL.").toString();
          j++;
          break label19;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            if (uJ.a) {
              new StringBuilder().append("Cannot get ").append(str).append(".").toString();
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          new StringBuilder().append("Out of memory when getting to ").append(str).append(".").toString();
        }
      }
    }
  }
  
  /* Error */
  public byte[] a(String paramString, java.util.List<org.apache.http.NameValuePair> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: getstatic 58	uJ:a	Z
    //   8: ifeq +23 -> 31
    //   11: new 60	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   18: ldc 103
    //   20: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: pop
    //   31: iconst_0
    //   32: istore 5
    //   34: aconst_null
    //   35: astore 6
    //   37: iload 5
    //   39: iconst_3
    //   40: if_icmpge +340 -> 380
    //   43: iload_3
    //   44: ifne +336 -> 380
    //   47: new 105	java/net/URL
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 108	java/net/URL:<init>	(Ljava/lang/String;)V
    //   55: invokevirtual 112	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   58: checkcast 114	java/net/HttpURLConnection
    //   61: astore 28
    //   63: aload 28
    //   65: sipush 2000
    //   68: invokevirtual 118	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   71: aload 28
    //   73: sipush 10000
    //   76: invokevirtual 121	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   79: aload_2
    //   80: ifnull +561 -> 641
    //   83: aload 28
    //   85: iconst_1
    //   86: invokevirtual 125	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   89: new 127	org/apache/http/client/entity/UrlEncodedFormEntity
    //   92: dup
    //   93: aload_2
    //   94: ldc 129
    //   96: invokespecial 132	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   99: astore 39
    //   101: aload 28
    //   103: ldc 134
    //   105: invokevirtual 137	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload 28
    //   110: aload 39
    //   112: invokevirtual 141	org/apache/http/client/entity/UrlEncodedFormEntity:getContentLength	()J
    //   115: l2i
    //   116: invokevirtual 144	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   119: aload 28
    //   121: invokevirtual 148	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   124: astore 40
    //   126: aload 40
    //   128: astore 10
    //   130: new 150	java/io/BufferedOutputStream
    //   133: dup
    //   134: aload 10
    //   136: invokespecial 153	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   139: astore 9
    //   141: aload 39
    //   143: aload 9
    //   145: invokevirtual 156	org/apache/http/client/entity/UrlEncodedFormEntity:writeTo	(Ljava/io/OutputStream;)V
    //   148: aload 9
    //   150: invokevirtual 159	java/io/BufferedOutputStream:close	()V
    //   153: aload 10
    //   155: invokevirtual 162	java/io/OutputStream:close	()V
    //   158: aload 28
    //   160: invokevirtual 166	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   163: astore 31
    //   165: aload_0
    //   166: aload 31
    //   168: invokespecial 168	vh:a	(Ljava/io/InputStream;)[B
    //   171: astore 34
    //   173: aload 34
    //   175: astore 18
    //   177: aload 31
    //   179: invokevirtual 169	java/io/InputStream:close	()V
    //   182: iconst_0
    //   183: ifeq +7 -> 190
    //   186: aconst_null
    //   187: invokevirtual 159	java/io/BufferedOutputStream:close	()V
    //   190: iconst_0
    //   191: ifeq +7 -> 198
    //   194: aconst_null
    //   195: invokevirtual 162	java/io/OutputStream:close	()V
    //   198: iconst_0
    //   199: ifeq +7 -> 206
    //   202: aconst_null
    //   203: invokevirtual 169	java/io/InputStream:close	()V
    //   206: aload 28
    //   208: ifnull +450 -> 658
    //   211: aload 28
    //   213: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   216: iconst_1
    //   217: istore 23
    //   219: iload 5
    //   221: istore 24
    //   223: aload 18
    //   225: astore 22
    //   227: aload 22
    //   229: astore 6
    //   231: iload 24
    //   233: istore 5
    //   235: iload 23
    //   237: istore_3
    //   238: goto -201 -> 37
    //   241: astore 15
    //   243: aconst_null
    //   244: astore 16
    //   246: aconst_null
    //   247: astore 17
    //   249: aconst_null
    //   250: astore 11
    //   252: aload 6
    //   254: astore 18
    //   256: aconst_null
    //   257: astore 19
    //   259: getstatic 58	uJ:a	Z
    //   262: pop
    //   263: iload 5
    //   265: iconst_1
    //   266: iadd
    //   267: istore 21
    //   269: aload 19
    //   271: ifnull +8 -> 279
    //   274: aload 19
    //   276: invokevirtual 159	java/io/BufferedOutputStream:close	()V
    //   279: aload 17
    //   281: ifnull +8 -> 289
    //   284: aload 17
    //   286: invokevirtual 162	java/io/OutputStream:close	()V
    //   289: aload 11
    //   291: ifnull +8 -> 299
    //   294: aload 11
    //   296: invokevirtual 169	java/io/InputStream:close	()V
    //   299: aload 16
    //   301: ifnull +343 -> 644
    //   304: aload 16
    //   306: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   309: aload 18
    //   311: astore 22
    //   313: iload_3
    //   314: istore 23
    //   316: iload 21
    //   318: istore 24
    //   320: goto -93 -> 227
    //   323: astore 8
    //   325: aload 16
    //   327: astore 4
    //   329: aload 19
    //   331: astore 9
    //   333: aload 17
    //   335: astore 10
    //   337: aload 9
    //   339: ifnull +8 -> 347
    //   342: aload 9
    //   344: invokevirtual 159	java/io/BufferedOutputStream:close	()V
    //   347: aload 10
    //   349: ifnull +8 -> 357
    //   352: aload 10
    //   354: invokevirtual 162	java/io/OutputStream:close	()V
    //   357: aload 11
    //   359: ifnull +8 -> 367
    //   362: aload 11
    //   364: invokevirtual 169	java/io/InputStream:close	()V
    //   367: aload 4
    //   369: ifnull +8 -> 377
    //   372: aload 4
    //   374: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   377: aload 8
    //   379: athrow
    //   380: getstatic 58	uJ:a	Z
    //   383: pop
    //   384: aload 6
    //   386: areturn
    //   387: astore 38
    //   389: goto -199 -> 190
    //   392: astore 37
    //   394: goto -196 -> 198
    //   397: astore 36
    //   399: goto -193 -> 206
    //   402: astore 27
    //   404: goto -125 -> 279
    //   407: astore 26
    //   409: goto -120 -> 289
    //   412: astore 25
    //   414: goto -115 -> 299
    //   417: astore 14
    //   419: goto -72 -> 347
    //   422: astore 13
    //   424: goto -67 -> 357
    //   427: astore 12
    //   429: goto -62 -> 367
    //   432: astore 8
    //   434: aconst_null
    //   435: astore 9
    //   437: aconst_null
    //   438: astore 10
    //   440: aconst_null
    //   441: astore 11
    //   443: goto -106 -> 337
    //   446: astore 30
    //   448: aconst_null
    //   449: astore 9
    //   451: aconst_null
    //   452: astore 10
    //   454: aconst_null
    //   455: astore 11
    //   457: aload 28
    //   459: astore 4
    //   461: aload 30
    //   463: astore 8
    //   465: goto -128 -> 337
    //   468: astore 45
    //   470: aconst_null
    //   471: astore 9
    //   473: aconst_null
    //   474: astore 11
    //   476: aload 28
    //   478: astore 4
    //   480: aload 45
    //   482: astore 8
    //   484: goto -147 -> 337
    //   487: astore 43
    //   489: aconst_null
    //   490: astore 11
    //   492: aload 28
    //   494: astore 4
    //   496: aload 43
    //   498: astore 8
    //   500: goto -163 -> 337
    //   503: astore 33
    //   505: aconst_null
    //   506: astore 9
    //   508: aload 31
    //   510: astore 11
    //   512: aconst_null
    //   513: astore 10
    //   515: aload 28
    //   517: astore 4
    //   519: aload 33
    //   521: astore 8
    //   523: goto -186 -> 337
    //   526: astore 29
    //   528: aload 28
    //   530: astore 16
    //   532: aconst_null
    //   533: astore 17
    //   535: aconst_null
    //   536: astore 11
    //   538: aload 6
    //   540: astore 18
    //   542: aconst_null
    //   543: astore 19
    //   545: goto -286 -> 259
    //   548: astore 44
    //   550: aload 10
    //   552: astore 17
    //   554: aconst_null
    //   555: astore 11
    //   557: aload 6
    //   559: astore 18
    //   561: aconst_null
    //   562: astore 19
    //   564: aload 28
    //   566: astore 16
    //   568: goto -309 -> 259
    //   571: astore 41
    //   573: aload 10
    //   575: astore 17
    //   577: aconst_null
    //   578: astore 11
    //   580: aload 28
    //   582: astore 16
    //   584: aload 9
    //   586: astore 42
    //   588: aload 6
    //   590: astore 18
    //   592: aload 42
    //   594: astore 19
    //   596: goto -337 -> 259
    //   599: astore 32
    //   601: aconst_null
    //   602: astore 17
    //   604: aload 31
    //   606: astore 11
    //   608: aload 6
    //   610: astore 18
    //   612: aconst_null
    //   613: astore 19
    //   615: aload 28
    //   617: astore 16
    //   619: goto -360 -> 259
    //   622: astore 35
    //   624: aconst_null
    //   625: astore 19
    //   627: aconst_null
    //   628: astore 17
    //   630: aload 31
    //   632: astore 11
    //   634: aload 28
    //   636: astore 16
    //   638: goto -379 -> 259
    //   641: goto -483 -> 158
    //   644: aload 18
    //   646: astore 22
    //   648: iload_3
    //   649: istore 23
    //   651: iload 21
    //   653: istore 24
    //   655: goto -428 -> 227
    //   658: iconst_1
    //   659: istore 23
    //   661: iload 5
    //   663: istore 24
    //   665: aload 18
    //   667: astore 22
    //   669: goto -442 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	vh
    //   0	672	1	paramString	String
    //   0	672	2	paramList	java.util.List<org.apache.http.NameValuePair>
    //   1	648	3	i	int
    //   3	515	4	localObject1	Object
    //   32	630	5	j	int
    //   35	574	6	localObject2	Object
    //   323	55	8	localObject3	Object
    //   432	1	8	localObject4	Object
    //   463	59	8	localObject5	Object
    //   139	446	9	localObject6	Object
    //   128	446	10	localObject7	Object
    //   250	383	11	localInputStream1	InputStream
    //   427	1	12	localIOException1	IOException
    //   422	1	13	localIOException2	IOException
    //   417	1	14	localIOException3	IOException
    //   241	1	15	localEOFException1	java.io.EOFException
    //   244	393	16	localHttpURLConnection1	java.net.HttpURLConnection
    //   247	382	17	localObject8	Object
    //   175	491	18	localObject9	Object
    //   257	369	19	localObject10	Object
    //   267	385	21	k	int
    //   225	443	22	localObject11	Object
    //   217	443	23	m	int
    //   221	443	24	n	int
    //   412	1	25	localIOException4	IOException
    //   407	1	26	localIOException5	IOException
    //   402	1	27	localIOException6	IOException
    //   61	574	28	localHttpURLConnection2	java.net.HttpURLConnection
    //   526	1	29	localEOFException2	java.io.EOFException
    //   446	16	30	localObject12	Object
    //   163	468	31	localInputStream2	InputStream
    //   599	1	32	localEOFException3	java.io.EOFException
    //   503	17	33	localObject13	Object
    //   171	3	34	arrayOfByte	byte[]
    //   622	1	35	localEOFException4	java.io.EOFException
    //   397	1	36	localIOException7	IOException
    //   392	1	37	localIOException8	IOException
    //   387	1	38	localIOException9	IOException
    //   99	43	39	localUrlEncodedFormEntity	org.apache.http.client.entity.UrlEncodedFormEntity
    //   124	3	40	localOutputStream	java.io.OutputStream
    //   571	1	41	localEOFException5	java.io.EOFException
    //   586	7	42	localObject14	Object
    //   487	10	43	localObject15	Object
    //   548	1	44	localEOFException6	java.io.EOFException
    //   468	13	45	localObject16	Object
    // Exception table:
    //   from	to	target	type
    //   47	63	241	java/io/EOFException
    //   259	263	323	finally
    //   186	190	387	java/io/IOException
    //   194	198	392	java/io/IOException
    //   202	206	397	java/io/IOException
    //   274	279	402	java/io/IOException
    //   284	289	407	java/io/IOException
    //   294	299	412	java/io/IOException
    //   342	347	417	java/io/IOException
    //   352	357	422	java/io/IOException
    //   362	367	427	java/io/IOException
    //   47	63	432	finally
    //   63	126	446	finally
    //   158	165	446	finally
    //   130	141	468	finally
    //   153	158	468	finally
    //   141	153	487	finally
    //   165	173	503	finally
    //   177	182	503	finally
    //   63	126	526	java/io/EOFException
    //   158	165	526	java/io/EOFException
    //   130	141	548	java/io/EOFException
    //   153	158	548	java/io/EOFException
    //   141	153	571	java/io/EOFException
    //   165	173	599	java/io/EOFException
    //   177	182	622	java/io/EOFException
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vh
 * JD-Core Version:    0.7.0.1
 */