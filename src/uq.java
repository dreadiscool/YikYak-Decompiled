import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.mpmetrics.InAppNotification;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

class uq
{
  private static final JSONArray d = new JSONArray();
  private final uJ a;
  private final Context b;
  private final List<ut> c;
  
  public uq(Context paramContext, uJ paramuJ)
  {
    this.b = paramContext;
    this.a = paramuJ;
    this.c = new LinkedList();
  }
  
  @SuppressLint({"NewApi"})
  private static int a(Display paramDisplay)
  {
    if (Build.VERSION.SDK_INT < 13) {}
    Point localPoint;
    for (int i = paramDisplay.getWidth();; i = localPoint.x)
    {
      return i;
      localPoint = new Point();
      paramDisplay.getSize(localPoint);
    }
  }
  
  private static Bitmap a(InAppNotification paramInAppNotification, Context paramContext, vh paramvh)
  {
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = paramInAppNotification.g();
    int i = a(((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay());
    String[] arrayOfString2;
    if ((paramInAppNotification.d() == uF.c) && (i >= 720))
    {
      arrayOfString2 = new String[2];
      arrayOfString2[0] = paramInAppNotification.h();
      arrayOfString2[1] = paramInAppNotification.g();
    }
    for (;;)
    {
      byte[] arrayOfByte = paramvh.a(paramContext, arrayOfString2);
      if (arrayOfByte != null) {}
      for (Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);; localBitmap = null)
      {
        return localBitmap;
        new StringBuilder().append("Failed to download images from ").append(Arrays.toString(arrayOfString2)).toString();
      }
      arrayOfString2 = arrayOfString1;
    }
  }
  
  /* Error */
  static ur a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 133	ur
    //   5: dup
    //   6: invokespecial 134	ur:<init>	()V
    //   9: astore_2
    //   10: new 136	org/json/JSONObject
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc 141
    //   22: invokevirtual 145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   25: ifeq +120 -> 145
    //   28: aload_3
    //   29: ldc 141
    //   31: invokevirtual 149	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   34: astore 29
    //   36: aload 29
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +167 -> 209
    //   45: iconst_0
    //   46: istore 20
    //   48: iload 20
    //   50: aload 4
    //   52: invokevirtual 152	org/json/JSONArray:length	()I
    //   55: if_icmpge +154 -> 209
    //   58: new 154	com/mixpanel/android/mpmetrics/Survey
    //   61: dup
    //   62: aload 4
    //   64: iload 20
    //   66: invokevirtual 158	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   69: invokespecial 161	com/mixpanel/android/mpmetrics/Survey:<init>	(Lorg/json/JSONObject;)V
    //   72: astore 21
    //   74: aload_2
    //   75: getfield 163	ur:a	Ljava/util/List;
    //   78: aload 21
    //   80: invokeinterface 169 2 0
    //   85: pop
    //   86: iinc 20 1
    //   89: goto -41 -> 48
    //   92: astore 30
    //   94: new 171	us
    //   97: dup
    //   98: new 108	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   105: ldc 173
    //   107: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aload 30
    //   119: invokespecial 176	us:<init>	(Ljava/lang/String;Lorg/json/JSONException;)V
    //   122: athrow
    //   123: astore 27
    //   125: new 108	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   132: ldc 178
    //   134: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_3
    //   138: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: pop
    //   145: aconst_null
    //   146: astore 4
    //   148: goto -108 -> 40
    //   151: astore 24
    //   153: new 108	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   160: ldc 183
    //   162: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 4
    //   167: invokevirtual 184	org/json/JSONArray:toString	()Ljava/lang/String;
    //   170: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: pop
    //   177: goto -91 -> 86
    //   180: astore 22
    //   182: new 108	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   189: ldc 183
    //   191: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 4
    //   196: invokevirtual 184	org/json/JSONArray:toString	()Ljava/lang/String;
    //   199: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: pop
    //   206: goto -120 -> 86
    //   209: aload_3
    //   210: ldc 186
    //   212: invokevirtual 145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   215: ifeq +92 -> 307
    //   218: aload_3
    //   219: ldc 186
    //   221: invokevirtual 149	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   224: astore 19
    //   226: aload 19
    //   228: astore 5
    //   230: aload 5
    //   232: ifnull +168 -> 400
    //   235: aload 5
    //   237: invokevirtual 152	org/json/JSONArray:length	()I
    //   240: iconst_2
    //   241: invokestatic 192	java/lang/Math:min	(II)I
    //   244: istore 8
    //   246: iload_1
    //   247: iload 8
    //   249: if_icmpge +151 -> 400
    //   252: new 64	com/mixpanel/android/mpmetrics/InAppNotification
    //   255: dup
    //   256: aload 5
    //   258: iload_1
    //   259: invokevirtual 158	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   262: invokespecial 193	com/mixpanel/android/mpmetrics/InAppNotification:<init>	(Lorg/json/JSONObject;)V
    //   265: astore 9
    //   267: aload_2
    //   268: getfield 195	ur:b	Ljava/util/List;
    //   271: aload 9
    //   273: invokeinterface 169 2 0
    //   278: pop
    //   279: iinc 1 1
    //   282: goto -36 -> 246
    //   285: astore 17
    //   287: new 108	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   294: ldc 197
    //   296: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_3
    //   300: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: pop
    //   307: aconst_null
    //   308: astore 5
    //   310: goto -80 -> 230
    //   313: astore 14
    //   315: new 108	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   322: ldc 199
    //   324: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 5
    //   329: invokevirtual 184	org/json/JSONArray:toString	()Ljava/lang/String;
    //   332: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: pop
    //   339: goto -60 -> 279
    //   342: astore 12
    //   344: new 108	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   351: ldc 199
    //   353: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 5
    //   358: invokevirtual 184	org/json/JSONArray:toString	()Ljava/lang/String;
    //   361: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: pop
    //   368: goto -89 -> 279
    //   371: astore 10
    //   373: new 108	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   380: ldc 201
    //   382: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 5
    //   387: invokevirtual 184	org/json/JSONArray:toString	()Ljava/lang/String;
    //   390: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: pop
    //   397: goto -118 -> 279
    //   400: aload_3
    //   401: ldc 203
    //   403: invokevirtual 145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   406: ifeq +13 -> 419
    //   409: aload_2
    //   410: aload_3
    //   411: ldc 203
    //   413: invokevirtual 149	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   416: putfield 205	ur:c	Lorg/json/JSONArray;
    //   419: aload_2
    //   420: areturn
    //   421: astore 6
    //   423: new 108	java/lang/StringBuilder
    //   426: dup
    //   427: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   430: ldc 207
    //   432: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_3
    //   436: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: pop
    //   443: goto -24 -> 419
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	paramString	String
    //   1	279	1	i	int
    //   9	411	2	localur	ur
    //   18	418	3	localJSONObject	org.json.JSONObject
    //   38	157	4	localJSONArray1	JSONArray
    //   228	158	5	localJSONArray2	JSONArray
    //   421	1	6	localJSONException1	org.json.JSONException
    //   244	6	8	j	int
    //   265	7	9	localInAppNotification	InAppNotification
    //   371	1	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   342	1	12	localuo1	uo
    //   313	1	14	localJSONException2	org.json.JSONException
    //   285	1	17	localJSONException3	org.json.JSONException
    //   224	3	19	localJSONArray3	JSONArray
    //   46	41	20	k	int
    //   72	7	21	localSurvey	com.mixpanel.android.mpmetrics.Survey
    //   180	1	22	localuo2	uo
    //   151	1	24	localJSONException4	org.json.JSONException
    //   123	1	27	localJSONException5	org.json.JSONException
    //   34	3	29	localJSONArray4	JSONArray
    //   92	26	30	localJSONException6	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   10	19	92	org/json/JSONException
    //   28	36	123	org/json/JSONException
    //   58	86	151	org/json/JSONException
    //   58	86	180	uo
    //   218	226	285	org/json/JSONException
    //   252	279	313	org/json/JSONException
    //   252	279	342	uo
    //   252	279	371	java/lang/OutOfMemoryError
    //   409	419	421	org/json/JSONException
  }
  
  private ur a(String paramString1, String paramString2, vh paramvh)
  {
    String str = b(paramString1, paramString2, paramvh);
    if (uJ.a) {
      new StringBuilder().append("Mixpanel decide server response was:\n").append(str).toString();
    }
    ur localur1 = new ur();
    if (str != null) {}
    for (ur localur2 = a(str);; localur2 = localur1)
    {
      Iterator localIterator = localur2.b.iterator();
      while (localIterator.hasNext())
      {
        InAppNotification localInAppNotification = (InAppNotification)localIterator.next();
        Bitmap localBitmap = a(localInAppNotification, this.b, paramvh);
        if (localBitmap == null)
        {
          new StringBuilder().append("Could not retrieve image for notification ").append(localInAppNotification.b()).append(", will not show the notification.").toString();
          localIterator.remove();
        }
        else
        {
          localInAppNotification.a(localBitmap);
        }
      }
      return localur2;
    }
  }
  
  private String b(String paramString1, String paramString2, vh paramvh)
  {
    String str1 = null;
    for (;;)
    {
      String str4;
      String[] arrayOfString;
      byte[] arrayOfByte;
      try
      {
        String str2 = URLEncoder.encode(paramString1, "utf-8");
        String str3;
        if (paramString2 != null)
        {
          String str5 = URLEncoder.encode(paramString2, "utf-8");
          str3 = str5;
          StringBuilder localStringBuilder = new StringBuilder().append("?version=1&lib=android&token=").append(str2);
          if (str3 != null) {
            localStringBuilder.append("&distinct_id=").append(str3);
          }
          str4 = localStringBuilder.toString();
          if (this.a.d())
          {
            arrayOfString = new String[1];
            arrayOfString[0] = (this.a.k() + str4);
            if (uJ.a)
            {
              new StringBuilder().append("Querying decide server at ").append(arrayOfString[0]).toString();
              new StringBuilder().append("    (with fallback ").append(arrayOfString[1]).append(")").toString();
            }
            arrayOfByte = paramvh.a(this.b, arrayOfString);
            if (arrayOfByte != null) {
              break label286;
            }
            return str1;
          }
        }
        else
        {
          str3 = null;
          continue;
        }
        arrayOfString = new String[2];
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", localUnsupportedEncodingException1);
      }
      arrayOfString[0] = (this.a.k() + str4);
      arrayOfString[1] = (this.a.n() + str4);
      continue;
      try
      {
        label286:
        str1 = new String(arrayOfByte, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        throw new RuntimeException("UTF not supported on this platform?", localUnsupportedEncodingException2);
      }
    }
  }
  
  public void a(ut paramut)
  {
    this.c.add(paramut);
  }
  
  public void a(vh paramvh)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      ut localut = (ut)localIterator.next();
      String str = localut.b();
      try
      {
        ur localur = a(localut.a(), str, paramvh);
        localut.a(localur.a, localur.b, localur.c);
      }
      catch (us localus)
      {
        localus.getMessage();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     uq
 * JD-Core Version:    0.7.0.1
 */