import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class wB
  extends Handler
{
  private wg b;
  private wC c;
  private final Context d;
  private final String e;
  
  public wB(ww paramww, Context paramContext, String paramString, Looper paramLooper)
  {
    super(paramLooper);
    this.d = paramContext;
    this.e = paramString;
    this.c = null;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 34	wB:f	()Landroid/content/SharedPreferences;
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 36
    //   10: aconst_null
    //   11: invokeinterface 42 3 0
    //   16: astore_3
    //   17: aload_2
    //   18: ldc 44
    //   20: aconst_null
    //   21: invokeinterface 42 3 0
    //   26: astore 4
    //   28: aload_3
    //   29: ifnull +110 -> 139
    //   32: new 46	org/json/JSONArray
    //   35: dup
    //   36: aload_3
    //   37: invokespecial 49	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   40: astore 15
    //   42: aload_0
    //   43: getfield 18	wB:a	Lww;
    //   46: invokestatic 54	ww:d	(Lww;)Ljava/util/List;
    //   49: astore 16
    //   51: aload 16
    //   53: monitorenter
    //   54: aload_0
    //   55: getfield 18	wB:a	Lww;
    //   58: invokestatic 54	ww:d	(Lww;)Ljava/util/List;
    //   61: invokeinterface 59 1 0
    //   66: iconst_0
    //   67: istore 18
    //   69: iload 18
    //   71: aload 15
    //   73: invokevirtual 63	org/json/JSONArray:length	()I
    //   76: if_icmpge +60 -> 136
    //   79: aload 15
    //   81: iload 18
    //   83: invokevirtual 67	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   86: astore 19
    //   88: aload 19
    //   90: ldc 69
    //   92: invokestatic 74	vS:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 20
    //   97: aload 19
    //   99: ldc 76
    //   101: invokevirtual 81	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   104: astore 21
    //   106: aload_0
    //   107: getfield 18	wB:a	Lww;
    //   110: invokestatic 54	ww:d	(Lww;)Ljava/util/List;
    //   113: new 83	android/util/Pair
    //   116: dup
    //   117: aload 20
    //   119: aload 21
    //   121: invokespecial 86	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   124: invokeinterface 90 2 0
    //   129: pop
    //   130: iinc 18 1
    //   133: goto -64 -> 69
    //   136: aload 16
    //   138: monitorexit
    //   139: aload 4
    //   141: ifnull +139 -> 280
    //   144: new 46	org/json/JSONArray
    //   147: dup
    //   148: aload 4
    //   150: invokespecial 49	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   153: astore 5
    //   155: aload_0
    //   156: getfield 18	wB:a	Lww;
    //   159: invokestatic 92	ww:e	(Lww;)Ljava/util/List;
    //   162: astore 10
    //   164: aload 10
    //   166: monitorenter
    //   167: aload_0
    //   168: getfield 18	wB:a	Lww;
    //   171: invokestatic 92	ww:e	(Lww;)Ljava/util/List;
    //   174: invokeinterface 59 1 0
    //   179: iload_1
    //   180: aload 5
    //   182: invokevirtual 63	org/json/JSONArray:length	()I
    //   185: if_icmpge +100 -> 285
    //   188: aload 5
    //   190: iload_1
    //   191: invokevirtual 67	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   194: astore 12
    //   196: aload 12
    //   198: ldc 94
    //   200: invokestatic 74	vS:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   203: astore 13
    //   205: aload_0
    //   206: getfield 18	wB:a	Lww;
    //   209: invokestatic 92	ww:e	(Lww;)Ljava/util/List;
    //   212: new 83	android/util/Pair
    //   215: dup
    //   216: aload 13
    //   218: aload 12
    //   220: invokespecial 86	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   223: invokeinterface 90 2 0
    //   228: pop
    //   229: iinc 1 1
    //   232: goto -53 -> 179
    //   235: astore 17
    //   237: aload 16
    //   239: monitorexit
    //   240: aload 17
    //   242: athrow
    //   243: astore 6
    //   245: aload_2
    //   246: invokeinterface 98 1 0
    //   251: astore 7
    //   253: aload 7
    //   255: ldc 36
    //   257: invokeinterface 104 2 0
    //   262: pop
    //   263: aload 7
    //   265: ldc 44
    //   267: invokeinterface 104 2 0
    //   272: pop
    //   273: aload 7
    //   275: invokeinterface 107 1 0
    //   280: aload_0
    //   281: invokespecial 109	wB:e	()V
    //   284: return
    //   285: aload 10
    //   287: monitorexit
    //   288: goto -8 -> 280
    //   291: astore 11
    //   293: aload 10
    //   295: monitorexit
    //   296: aload 11
    //   298: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	wB
    //   1	229	1	i	int
    //   6	240	2	localSharedPreferences	SharedPreferences
    //   16	21	3	str1	String
    //   26	123	4	str2	String
    //   153	36	5	localJSONArray1	JSONArray
    //   243	1	6	localJSONException	JSONException
    //   251	23	7	localEditor	SharedPreferences.Editor
    //   291	6	11	localObject1	Object
    //   194	25	12	localJSONObject1	JSONObject
    //   203	14	13	str3	String
    //   40	40	15	localJSONArray2	JSONArray
    //   235	6	17	localObject2	Object
    //   67	64	18	j	int
    //   86	12	19	localJSONObject2	JSONObject
    //   95	23	20	str4	String
    //   104	16	21	localJSONObject3	JSONObject
    // Exception table:
    //   from	to	target	type
    //   54	139	235	finally
    //   237	240	235	finally
    //   32	54	243	org/json/JSONException
    //   144	167	243	org/json/JSONException
    //   240	243	243	org/json/JSONException
    //   296	299	243	org/json/JSONException
    //   167	229	291	finally
    //   285	296	291	finally
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: new 78	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 113	org/json/JSONObject:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 115
    //   11: aload_1
    //   12: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   15: pop
    //   16: new 121	java/io/OutputStreamWriter
    //   19: dup
    //   20: aload_0
    //   21: getfield 123	wB:b	Lwg;
    //   24: invokevirtual 128	wg:b	()Ljava/io/BufferedOutputStream;
    //   27: invokespecial 131	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 133
    //   36: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   39: aload 4
    //   41: ldc 138
    //   43: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   46: aload 4
    //   48: aload_2
    //   49: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   52: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   55: aload 4
    //   57: ldc 144
    //   59: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   62: aload 4
    //   64: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   67: return
    //   68: astore 7
    //   70: aload 4
    //   72: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   75: goto -8 -> 67
    //   78: astore 8
    //   80: goto -13 -> 67
    //   83: astore 5
    //   85: aload 4
    //   87: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   90: aload 5
    //   92: athrow
    //   93: astore 9
    //   95: goto -28 -> 67
    //   98: astore 6
    //   100: goto -10 -> 90
    //   103: astore_3
    //   104: goto -88 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	wB
    //   0	107	1	paramString	String
    //   7	42	2	localJSONObject	JSONObject
    //   103	1	3	localJSONException	JSONException
    //   30	56	4	localOutputStreamWriter	java.io.OutputStreamWriter
    //   83	8	5	localObject	Object
    //   98	1	6	localIOException1	IOException
    //   68	1	7	localIOException2	IOException
    //   78	1	8	localIOException3	IOException
    //   93	1	9	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   32	62	68	java/io/IOException
    //   70	75	78	java/io/IOException
    //   32	62	83	finally
    //   62	67	93	java/io/IOException
    //   85	90	98	java/io/IOException
    //   8	16	103	org/json/JSONException
  }
  
  private void a(JSONArray paramJSONArray)
  {
    SharedPreferences.Editor localEditor = f().edit();
    localEditor.putString("mixpanel.viewcrawler.bindings", paramJSONArray.toString());
    localEditor.apply();
    a();
  }
  
  /* Error */
  private void a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_1
    //   5: ldc 166
    //   7: invokevirtual 81	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10: astore 6
    //   12: aload 6
    //   14: ldc 168
    //   16: invokevirtual 172	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   19: ifeq +19 -> 38
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 18	wB:a	Lww;
    //   27: invokestatic 176	ww:i	(Lww;)Lwa;
    //   30: aload 6
    //   32: invokevirtual 181	wa:b	(Lorg/json/JSONObject;)LwC;
    //   35: putfield 27	wB:c	LwC;
    //   38: aload_0
    //   39: getfield 27	wB:c	LwC;
    //   42: ifnonnull +35 -> 77
    //   45: aload_0
    //   46: ldc 183
    //   48: invokespecial 185	wB:a	(Ljava/lang/String;)V
    //   51: return
    //   52: astore 5
    //   54: aload_0
    //   55: ldc 187
    //   57: invokespecial 185	wB:a	(Ljava/lang/String;)V
    //   60: goto -9 -> 51
    //   63: astore 4
    //   65: aload_0
    //   66: aload 4
    //   68: invokevirtual 190	wb:getMessage	()Ljava/lang/String;
    //   71: invokespecial 185	wB:a	(Ljava/lang/String;)V
    //   74: goto -23 -> 51
    //   77: aload_0
    //   78: getfield 123	wB:b	Lwg;
    //   81: invokevirtual 128	wg:b	()Ljava/io/BufferedOutputStream;
    //   84: astore 7
    //   86: new 121	java/io/OutputStreamWriter
    //   89: dup
    //   90: aload 7
    //   92: invokespecial 131	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   95: astore 8
    //   97: aload 8
    //   99: ldc 192
    //   101: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   104: aload 8
    //   106: ldc 194
    //   108: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   111: aload 8
    //   113: ldc 196
    //   115: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   118: aload 8
    //   120: ldc 198
    //   122: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   125: aload 8
    //   127: invokevirtual 201	java/io/OutputStreamWriter:flush	()V
    //   130: aload_0
    //   131: getfield 27	wB:c	LwC;
    //   134: aload_0
    //   135: getfield 18	wB:a	Lww;
    //   138: invokestatic 204	ww:b	(Lww;)Lwd;
    //   141: aload 7
    //   143: invokevirtual 209	wC:a	(Lwu;Ljava/io/OutputStream;)V
    //   146: invokestatic 164	java/lang/System:currentTimeMillis	()J
    //   149: lload_2
    //   150: lsub
    //   151: lstore 13
    //   153: aload 8
    //   155: ldc 211
    //   157: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   160: aload 8
    //   162: lload 13
    //   164: invokestatic 216	java/lang/Long:toString	(J)Ljava/lang/String;
    //   167: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   170: aload 8
    //   172: ldc 144
    //   174: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   177: aload 8
    //   179: ldc 144
    //   181: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   184: aload 8
    //   186: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   189: goto -138 -> 51
    //   192: astore 15
    //   194: goto -143 -> 51
    //   197: astore 11
    //   199: aload 8
    //   201: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   204: goto -153 -> 51
    //   207: astore 12
    //   209: goto -158 -> 51
    //   212: astore 9
    //   214: aload 8
    //   216: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   219: aload 9
    //   221: athrow
    //   222: astore 10
    //   224: goto -5 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	wB
    //   0	227	1	paramJSONObject	JSONObject
    //   3	147	2	l1	long
    //   63	4	4	localwb	wb
    //   52	1	5	localJSONException	JSONException
    //   10	21	6	localJSONObject	JSONObject
    //   84	58	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   95	120	8	localOutputStreamWriter	java.io.OutputStreamWriter
    //   212	8	9	localObject	Object
    //   222	1	10	localIOException1	IOException
    //   197	1	11	localIOException2	IOException
    //   207	1	12	localIOException3	IOException
    //   151	12	13	l2	long
    //   192	1	15	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   4	38	52	org/json/JSONException
    //   4	38	63	wb
    //   184	189	192	java/io/IOException
    //   97	184	197	java/io/IOException
    //   199	204	207	java/io/IOException
    //   97	184	212	finally
    //   214	219	222	java/io/IOException
  }
  
  private void b()
  {
    if ((this.b != null) && (this.b.a())) {}
    for (;;)
    {
      return;
      if (ww.f(this.a) != null)
      {
        String str = uJ.a(this.d).p() + this.e;
        try
        {
          Socket localSocket = ww.f(this.a).createSocket();
          this.b = new wg(new URI(str), new wy(this.a, null), localSocket);
        }
        catch (URISyntaxException localURISyntaxException)
        {
          new StringBuilder().append("Error parsing URI ").append(str).append(" for editor websocket").toString();
        }
        catch (wk localwk)
        {
          new StringBuilder().append("Error connecting to URI ").append(str).toString();
        }
        catch (IOException localIOException) {}
      }
    }
  }
  
  /* Error */
  private void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 123	wB:b	Lwg;
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: getfield 123	wB:b	Lwg;
    //   11: invokevirtual 228	wg:a	()Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: new 270	android/util/JsonWriter
    //   21: dup
    //   22: new 121	java/io/OutputStreamWriter
    //   25: dup
    //   26: aload_0
    //   27: getfield 123	wB:b	Lwg;
    //   30: invokevirtual 128	wg:b	()Ljava/io/BufferedOutputStream;
    //   33: invokespecial 131	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   36: invokespecial 273	android/util/JsonWriter:<init>	(Ljava/io/Writer;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 277	android/util/JsonWriter:beginObject	()Landroid/util/JsonWriter;
    //   44: pop
    //   45: aload_2
    //   46: ldc_w 279
    //   49: invokevirtual 283	android/util/JsonWriter:name	(Ljava/lang/String;)Landroid/util/JsonWriter;
    //   52: ldc_w 285
    //   55: invokevirtual 288	android/util/JsonWriter:value	(Ljava/lang/String;)Landroid/util/JsonWriter;
    //   58: pop
    //   59: aload_2
    //   60: ldc 166
    //   62: invokevirtual 283	android/util/JsonWriter:name	(Ljava/lang/String;)Landroid/util/JsonWriter;
    //   65: pop
    //   66: aload_2
    //   67: invokevirtual 277	android/util/JsonWriter:beginObject	()Landroid/util/JsonWriter;
    //   70: pop
    //   71: aload_2
    //   72: ldc_w 290
    //   75: invokevirtual 283	android/util/JsonWriter:name	(Ljava/lang/String;)Landroid/util/JsonWriter;
    //   78: aload_1
    //   79: invokevirtual 288	android/util/JsonWriter:value	(Ljava/lang/String;)Landroid/util/JsonWriter;
    //   82: pop
    //   83: aload_2
    //   84: invokevirtual 293	android/util/JsonWriter:endObject	()Landroid/util/JsonWriter;
    //   87: pop
    //   88: aload_2
    //   89: invokevirtual 293	android/util/JsonWriter:endObject	()Landroid/util/JsonWriter;
    //   92: pop
    //   93: aload_2
    //   94: invokevirtual 294	android/util/JsonWriter:flush	()V
    //   97: aload_2
    //   98: invokevirtual 295	android/util/JsonWriter:close	()V
    //   101: goto -84 -> 17
    //   104: astore 14
    //   106: goto -89 -> 17
    //   109: astore 5
    //   111: aload_2
    //   112: invokevirtual 295	android/util/JsonWriter:close	()V
    //   115: goto -98 -> 17
    //   118: astore 6
    //   120: goto -103 -> 17
    //   123: astore_3
    //   124: aload_2
    //   125: invokevirtual 295	android/util/JsonWriter:close	()V
    //   128: aload_3
    //   129: athrow
    //   130: astore 4
    //   132: goto -4 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	wB
    //   0	135	1	paramString	String
    //   39	86	2	localJsonWriter	android.util.JsonWriter
    //   123	6	3	localObject	Object
    //   130	1	4	localIOException1	IOException
    //   109	1	5	localIOException2	IOException
    //   118	1	6	localIOException3	IOException
    //   104	1	14	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   97	101	104	java/io/IOException
    //   40	97	109	java/io/IOException
    //   111	115	118	java/io/IOException
    //   40	97	123	finally
    //   124	128	130	java/io/IOException
  }
  
  private void b(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        str = vS.a(paramJSONObject, "target");
        localJSONObject = paramJSONObject.getJSONObject("change");
      }
      catch (JSONException localJSONException)
      {
        String str;
        JSONObject localJSONObject;
        continue;
      }
      synchronized (ww.j(this.a))
      {
        ww.j(this.a).add(new Pair(str, localJSONObject));
        e();
        return;
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: new 121	java/io/OutputStreamWriter
    //   3: dup
    //   4: aload_0
    //   5: getfield 123	wB:b	Lwg;
    //   8: invokevirtual 128	wg:b	()Ljava/io/BufferedOutputStream;
    //   11: invokespecial 131	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc_w 300
    //   19: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: ldc 196
    //   25: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: ldc_w 302
    //   32: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc_w 304
    //   39: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   42: aload_1
    //   43: new 233	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   50: getstatic 309	android/os/Build:BRAND	Ljava/lang/String;
    //   53: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 311
    //   59: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: getstatic 314	android/os/Build:MODEL	Ljava/lang/String;
    //   65: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 318	org/json/JSONObject:quote	(Ljava/lang/String;)Ljava/lang/String;
    //   74: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   77: aload_1
    //   78: ldc_w 320
    //   81: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc_w 322
    //   88: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: new 78	org/json/JSONObject
    //   95: dup
    //   96: aload_0
    //   97: getfield 18	wB:a	Lww;
    //   100: invokestatic 326	ww:g	(Lww;)Lvs;
    //   103: invokevirtual 331	vs:a	()Ljava/util/Map;
    //   106: invokespecial 334	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   109: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   112: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 18	wB:a	Lww;
    //   119: invokestatic 338	ww:h	(Lww;)Ljava/util/Map;
    //   122: invokeinterface 344 1 0
    //   127: invokeinterface 350 1 0
    //   132: astore 6
    //   134: aload 6
    //   136: invokeinterface 355 1 0
    //   141: ifeq +73 -> 214
    //   144: aload 6
    //   146: invokeinterface 359 1 0
    //   151: checkcast 361	java/util/Map$Entry
    //   154: astore 8
    //   156: aload_1
    //   157: ldc_w 320
    //   160: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   163: aload_1
    //   164: aload 8
    //   166: invokeinterface 364 1 0
    //   171: checkcast 366	java/lang/String
    //   174: invokestatic 318	org/json/JSONObject:quote	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   180: aload_1
    //   181: ldc_w 368
    //   184: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   187: aload_1
    //   188: aload 8
    //   190: invokeinterface 371 1 0
    //   195: checkcast 366	java/lang/String
    //   198: invokestatic 318	org/json/JSONObject:quote	(Ljava/lang/String;)Ljava/lang/String;
    //   201: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   204: goto -70 -> 134
    //   207: astore 4
    //   209: aload_1
    //   210: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   213: return
    //   214: aload_1
    //   215: ldc 144
    //   217: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   220: aload_1
    //   221: ldc 144
    //   223: invokevirtual 136	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   230: goto -17 -> 213
    //   233: astore 7
    //   235: goto -22 -> 213
    //   238: astore_2
    //   239: aload_1
    //   240: invokevirtual 147	java/io/OutputStreamWriter:close	()V
    //   243: aload_2
    //   244: athrow
    //   245: astore 5
    //   247: goto -34 -> 213
    //   250: astore_3
    //   251: goto -8 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	wB
    //   14	226	1	localOutputStreamWriter	java.io.OutputStreamWriter
    //   238	6	2	localObject	Object
    //   250	1	3	localIOException1	IOException
    //   207	1	4	localIOException2	IOException
    //   245	1	5	localIOException3	IOException
    //   132	13	6	localIterator	java.util.Iterator
    //   233	1	7	localIOException4	IOException
    //   154	35	8	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   15	204	207	java/io/IOException
    //   214	226	207	java/io/IOException
    //   226	230	233	java/io/IOException
    //   15	204	238	finally
    //   214	226	238	finally
    //   209	213	245	java/io/IOException
    //   239	243	250	java/io/IOException
  }
  
  private void c(JSONObject paramJSONObject)
  {
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONObject("payload").getJSONArray("events");
      int i = localJSONArray.length();
      synchronized (ww.k(this.a))
      {
        ww.k(this.a).clear();
        int j = 0;
        for (;;)
        {
          if (j < i) {
            try
            {
              JSONObject localJSONObject = localJSONArray.getJSONObject(j);
              String str = vS.a(localJSONObject, "target_activity");
              ww.k(this.a).add(new Pair(str, localJSONObject));
              j++;
            }
            catch (JSONException localJSONException2)
            {
              for (;;)
              {
                new StringBuilder().append("Bad event binding received from editor in ").append(localJSONArray.toString()).toString();
              }
            }
          }
        }
      }
      e();
      label144:
      return;
    }
    catch (JSONException localJSONException1)
    {
      break label144;
    }
  }
  
  private void d()
  {
    synchronized (ww.j(this.a))
    {
      ww.j(this.a).clear();
    }
    synchronized (ww.k(this.a))
    {
      ww.k(this.a).clear();
      this.c = null;
      e();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  private void e()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int k;
      Pair localPair5;
      synchronized (ww.d(this.a))
      {
        int j = ww.d(this.a).size();
        k = 0;
        if (k < j) {
          localPair5 = (Pair)ww.d(this.a).get(k);
        }
      }
      try
      {
        wH localwH4 = ww.i(this.a).a((JSONObject)localPair5.second);
        localArrayList.add(new Pair(localPair5.first, localwH4));
        label104:
        k++;
      }
      catch (wc localwc4)
      {
        for (;;)
        {
          localwc4.getMessage();
        }
        localObject1 = finally;
        throw localObject1;
        for (;;)
        {
          int n;
          Pair localPair4;
          synchronized (ww.j(this.a))
          {
            int m = ww.j(this.a).size();
            n = 0;
            if (n < m) {
              localPair4 = (Pair)ww.j(this.a).get(n);
            }
          }
          try
          {
            wH localwH3 = ww.i(this.a).a((JSONObject)localPair4.second);
            localArrayList.add(new Pair(localPair4.first, localwH3));
            n++;
          }
          catch (wc localwc3)
          {
            for (;;)
            {
              localwc3.getMessage();
            }
            localObject2 = finally;
            throw localObject2;
            for (;;)
            {
              int i2;
              Pair localPair3;
              synchronized (ww.e(this.a))
              {
                int i1 = ww.e(this.a).size();
                i2 = 0;
                if (i2 < i1) {
                  localPair3 = (Pair)ww.e(this.a).get(i2);
                }
              }
              try
              {
                wH localwH2 = ww.i(this.a).a((JSONObject)localPair3.second, ww.l(this.a));
                localArrayList.add(new Pair(localPair3.first, localwH2));
                i2++;
              }
              catch (wc localwc2)
              {
                for (;;)
                {
                  localwc2.getMessage();
                }
                localObject3 = finally;
                throw localObject3;
                for (;;)
                {
                  int i4;
                  Pair localPair2;
                  synchronized (ww.k(this.a))
                  {
                    int i3 = ww.k(this.a).size();
                    i4 = 0;
                    if (i4 < i3) {
                      localPair2 = (Pair)ww.k(this.a).get(i4);
                    }
                  }
                  try
                  {
                    wH localwH1 = ww.i(this.a).a((JSONObject)localPair2.second, ww.l(this.a));
                    localArrayList.add(new Pair(localPair2.first, localwH1));
                    i4++;
                  }
                  catch (wc localwc1)
                  {
                    for (;;)
                    {
                      localwc1.getMessage();
                    }
                    localObject4 = finally;
                    throw localObject4;
                    HashMap localHashMap = new HashMap();
                    int i5 = localArrayList.size();
                    if (i < i5)
                    {
                      Pair localPair1 = (Pair)localArrayList.get(i);
                      Object localObject5;
                      if (localHashMap.containsKey(localPair1.first)) {
                        localObject5 = (List)localHashMap.get(localPair1.first);
                      }
                      for (;;)
                      {
                        ((List)localObject5).add(localPair1.second);
                        i++;
                        break;
                        localObject5 = new ArrayList();
                        localHashMap.put(localPair1.first, localObject5);
                      }
                    }
                    ww.b(this.a).a(localHashMap);
                    return;
                  }
                  catch (wb localwb1)
                  {
                    break label488;
                  }
                }
              }
              catch (wb localwb2)
              {
                break label357;
              }
            }
          }
          catch (wb localwb3)
          {
            break label226;
          }
        }
      }
      catch (wb localwb4)
      {
        label226:
        label357:
        label488:
        break label104;
      }
    }
  }
  
  private SharedPreferences f()
  {
    String str = "mixpanel.viewcrawler.changes" + this.e;
    return this.d.getSharedPreferences(str, 0);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      a();
      continue;
      b();
      continue;
      c();
      continue;
      a((JSONObject)paramMessage.obj);
      continue;
      b((String)paramMessage.obj);
      continue;
      b((JSONObject)paramMessage.obj);
      continue;
      a((JSONArray)paramMessage.obj);
      continue;
      c((JSONObject)paramMessage.obj);
      continue;
      d();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wB
 * JD-Core Version:    0.7.0.1
 */