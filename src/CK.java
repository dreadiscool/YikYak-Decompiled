import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;
import com.yik.yak.data.models.YakkerLocation;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class CK
  extends CQ
  implements Serializable
{
  public String A = "";
  public String B = "";
  public String C = "";
  public String D = "";
  public boolean E = false;
  public boolean F = true;
  public boolean G = true;
  public boolean H = true;
  private Context I = null;
  public boolean a = false;
  public String b = "0";
  public String c = "0";
  public int d = 0;
  public int e = 0;
  public int f = -1;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public double s = 0.0D;
  public double t = 0.0D;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = false;
  public boolean y = false;
  public String z = "";
  
  public CK() {}
  
  public CK(Context paramContext, String paramString)
  {
    this.G = false;
    this.F = false;
    this.H = false;
    this.I = paramContext;
    try
    {
      a(new JSONObject(paramString), 0);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        this.E = true;
      }
    }
  }
  
  /* Error */
  public CK(String paramString, Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokespecial 48	CQ:<init>	()V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 50	CK:a	Z
    //   12: aload_0
    //   13: ldc 52
    //   15: putfield 54	CK:b	Ljava/lang/String;
    //   18: aload_0
    //   19: ldc 52
    //   21: putfield 56	CK:c	Ljava/lang/String;
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 58	CK:d	I
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 60	CK:e	I
    //   34: aload_0
    //   35: bipush 255
    //   37: putfield 62	CK:f	I
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 64	CK:g	I
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 66	CK:h	I
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield 68	CK:i	I
    //   55: aload_0
    //   56: ldc 70
    //   58: putfield 72	CK:j	Ljava/lang/String;
    //   61: aload_0
    //   62: ldc 70
    //   64: putfield 74	CK:k	Ljava/lang/String;
    //   67: aload_0
    //   68: ldc 70
    //   70: putfield 76	CK:l	Ljava/lang/String;
    //   73: aload_0
    //   74: new 78	java/text/SimpleDateFormat
    //   77: dup
    //   78: ldc 80
    //   80: invokespecial 83	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   83: new 85	java/util/Date
    //   86: dup
    //   87: invokespecial 86	java/util/Date:<init>	()V
    //   90: invokevirtual 90	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   93: putfield 92	CK:m	Ljava/lang/String;
    //   96: aload_0
    //   97: ldc 70
    //   99: putfield 94	CK:n	Ljava/lang/String;
    //   102: aload_0
    //   103: ldc 70
    //   105: putfield 96	CK:o	Ljava/lang/String;
    //   108: aload_0
    //   109: ldc 70
    //   111: putfield 98	CK:p	Ljava/lang/String;
    //   114: aload_0
    //   115: ldc 70
    //   117: putfield 100	CK:q	Ljava/lang/String;
    //   120: aload_0
    //   121: ldc 70
    //   123: putfield 102	CK:r	Ljava/lang/String;
    //   126: aload_0
    //   127: dconst_0
    //   128: putfield 104	CK:s	D
    //   131: aload_0
    //   132: dconst_0
    //   133: putfield 106	CK:t	D
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 108	CK:u	Z
    //   141: aload_0
    //   142: iconst_0
    //   143: putfield 110	CK:v	Z
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 112	CK:w	Z
    //   151: aload_0
    //   152: iconst_0
    //   153: putfield 114	CK:x	Z
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 116	CK:y	Z
    //   161: aload_0
    //   162: ldc 70
    //   164: putfield 118	CK:z	Ljava/lang/String;
    //   167: aload_0
    //   168: ldc 70
    //   170: putfield 120	CK:A	Ljava/lang/String;
    //   173: aload_0
    //   174: ldc 70
    //   176: putfield 122	CK:B	Ljava/lang/String;
    //   179: aload_0
    //   180: ldc 70
    //   182: putfield 124	CK:C	Ljava/lang/String;
    //   185: aload_0
    //   186: ldc 70
    //   188: putfield 126	CK:D	Ljava/lang/String;
    //   191: aload_0
    //   192: iconst_0
    //   193: putfield 128	CK:E	Z
    //   196: aload_0
    //   197: iconst_1
    //   198: putfield 130	CK:F	Z
    //   201: aload_0
    //   202: iconst_1
    //   203: putfield 132	CK:G	Z
    //   206: aload_0
    //   207: iconst_1
    //   208: putfield 134	CK:H	Z
    //   211: aload_0
    //   212: aconst_null
    //   213: putfield 136	CK:I	Landroid/content/Context;
    //   216: aload_0
    //   217: aload_2
    //   218: putfield 136	CK:I	Landroid/content/Context;
    //   221: aload_0
    //   222: getfield 136	CK:I	Landroid/content/Context;
    //   225: invokestatic 155	CM:a	(Landroid/content/Context;)LCM;
    //   228: invokevirtual 158	CM:f	()Lcom/yik/yak/data/models/YakkerLocation;
    //   231: astore 5
    //   233: new 160	java/util/TreeMap
    //   236: dup
    //   237: invokespecial 161	java/util/TreeMap:<init>	()V
    //   240: astore 6
    //   242: aload 6
    //   244: ldc 163
    //   246: invokestatic 168	BV:b	()Ljava/lang/String;
    //   249: invokevirtual 172	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: aload 6
    //   255: ldc 174
    //   257: aload_1
    //   258: invokevirtual 172	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: new 176	android/os/StrictMode$ThreadPolicy$Builder
    //   265: dup
    //   266: invokespecial 177	android/os/StrictMode$ThreadPolicy$Builder:<init>	()V
    //   269: invokevirtual 181	android/os/StrictMode$ThreadPolicy$Builder:permitAll	()Landroid/os/StrictMode$ThreadPolicy$Builder;
    //   272: invokevirtual 185	android/os/StrictMode$ThreadPolicy$Builder:build	()Landroid/os/StrictMode$ThreadPolicy;
    //   275: invokestatic 191	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   278: new 193	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   285: astore 9
    //   287: new 196	java/net/URL
    //   290: dup
    //   291: ldc 198
    //   293: aload 6
    //   295: aload 5
    //   297: invokestatic 203	Im:a	(Ljava/lang/String;Ljava/util/TreeMap;Lcom/yik/yak/data/models/YakkerLocation;)Ljava/lang/String;
    //   300: invokespecial 204	java/net/URL:<init>	(Ljava/lang/String;)V
    //   303: invokevirtual 208	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   306: checkcast 210	java/net/HttpURLConnection
    //   309: astore 11
    //   311: new 212	java/io/InputStreamReader
    //   314: dup
    //   315: aload 11
    //   317: invokevirtual 216	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   320: invokespecial 219	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   323: astore 16
    //   325: sipush 1024
    //   328: newarray char
    //   330: astore 20
    //   332: aload 16
    //   334: aload 20
    //   336: invokevirtual 223	java/io/InputStreamReader:read	([C)I
    //   339: istore 21
    //   341: iload 21
    //   343: bipush 255
    //   345: if_icmpeq +35 -> 380
    //   348: aload 9
    //   350: aload 20
    //   352: iconst_0
    //   353: iload 21
    //   355: invokevirtual 227	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: goto -27 -> 332
    //   362: astore 19
    //   364: aload_0
    //   365: iconst_1
    //   366: putfield 128	CK:E	Z
    //   369: aload 11
    //   371: ifnull +8 -> 379
    //   374: aload 11
    //   376: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   379: return
    //   380: aload_0
    //   381: new 141	org/json/JSONObject
    //   384: dup
    //   385: aload 9
    //   387: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokespecial 142	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   393: ldc 235
    //   395: invokevirtual 239	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   398: iconst_0
    //   399: invokevirtual 245	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   402: checkcast 141	org/json/JSONObject
    //   405: iload_3
    //   406: invokevirtual 145	CK:a	(Lorg/json/JSONObject;I)V
    //   409: aload 11
    //   411: ifnull -32 -> 379
    //   414: aload 11
    //   416: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   419: goto -40 -> 379
    //   422: astore 15
    //   424: aconst_null
    //   425: astore 11
    //   427: aload_0
    //   428: iconst_1
    //   429: putfield 128	CK:E	Z
    //   432: aload 11
    //   434: ifnull -55 -> 379
    //   437: aload 11
    //   439: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   442: goto -63 -> 379
    //   445: astore 14
    //   447: aconst_null
    //   448: astore 11
    //   450: aload_0
    //   451: iconst_1
    //   452: putfield 128	CK:E	Z
    //   455: aload 11
    //   457: ifnull -78 -> 379
    //   460: aload 11
    //   462: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   465: goto -86 -> 379
    //   468: astore 13
    //   470: aload 4
    //   472: ifnull +8 -> 480
    //   475: aload 4
    //   477: invokevirtual 230	java/net/HttpURLConnection:disconnect	()V
    //   480: aload 13
    //   482: athrow
    //   483: astore 12
    //   485: aload 11
    //   487: astore 4
    //   489: aload 12
    //   491: astore 13
    //   493: goto -23 -> 470
    //   496: astore 18
    //   498: goto -48 -> 450
    //   501: astore 17
    //   503: goto -76 -> 427
    //   506: astore 10
    //   508: aconst_null
    //   509: astore 11
    //   511: goto -147 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	CK
    //   0	514	1	paramString	String
    //   0	514	2	paramContext	Context
    //   0	514	3	paramInt	int
    //   1	487	4	localObject1	java.lang.Object
    //   231	65	5	localYakkerLocation	YakkerLocation
    //   240	54	6	localTreeMap	TreeMap
    //   285	101	9	localStringBuilder	java.lang.StringBuilder
    //   506	1	10	localMalformedURLException1	java.net.MalformedURLException
    //   309	201	11	localHttpURLConnection	java.net.HttpURLConnection
    //   483	7	12	localObject2	java.lang.Object
    //   468	13	13	localObject3	java.lang.Object
    //   491	1	13	localObject4	java.lang.Object
    //   445	1	14	localJSONException1	JSONException
    //   422	1	15	localIOException1	java.io.IOException
    //   323	10	16	localInputStreamReader	java.io.InputStreamReader
    //   501	1	17	localIOException2	java.io.IOException
    //   496	1	18	localJSONException2	JSONException
    //   362	1	19	localMalformedURLException2	java.net.MalformedURLException
    //   330	21	20	arrayOfChar	char[]
    //   339	15	21	i1	int
    // Exception table:
    //   from	to	target	type
    //   311	359	362	java/net/MalformedURLException
    //   380	409	362	java/net/MalformedURLException
    //   287	311	422	java/io/IOException
    //   287	311	445	org/json/JSONException
    //   287	311	468	finally
    //   311	359	483	finally
    //   364	369	483	finally
    //   380	409	483	finally
    //   427	432	483	finally
    //   450	455	483	finally
    //   311	359	496	org/json/JSONException
    //   380	409	496	org/json/JSONException
    //   311	359	501	java/io/IOException
    //   380	409	501	java/io/IOException
    //   287	311	506	java/net/MalformedURLException
  }
  
  public CK(JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Context paramContext, int paramInt)
  {
    this.G = paramBoolean1;
    this.F = paramBoolean2;
    this.H = paramBoolean3;
    this.I = paramContext;
    a(paramJSONObject, paramInt);
  }
  
  public static String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "Normal";
    }
    for (;;)
    {
      return str;
      str = "System";
      continue;
      str = "Banned";
      continue;
      str = "Warning";
      continue;
      str = "Sponsored";
      continue;
      str = "Link";
      continue;
      str = "Photo";
    }
  }
  
  private void a(String paramString, TreeMap<String, String> paramTreeMap, YakkerLocation paramYakkerLocation)
  {
    String str = UrlHelper.calculateRequestUrl(CR.f(), paramString, paramTreeMap, paramYakkerLocation);
    zz localzz = new zB().a(str).b();
    UrlHelper.a(true).a(localzz).a(new CL(this));
  }
  
  public ContentValues a()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("comment", this.o);
    localContentValues.put("commentId", this.c);
    localContentValues.put("content", this.l);
    localContentValues.put("deliveryId", Integer.valueOf(this.i));
    localContentValues.put("hidePin", Integer.valueOf(this.e));
    localContentValues.put("isComment", Boolean.valueOf(this.v));
    localContentValues.put("latitude", Double.valueOf(this.s));
    localContentValues.put("liked", Integer.valueOf(this.g));
    localContentValues.put("linkProvider", this.C);
    localContentValues.put("linkSummary", this.B);
    localContentValues.put("linkTitle", this.A);
    localContentValues.put("linkThumbnailUrl", this.D);
    localContentValues.put("linkUrl", this.z);
    localContentValues.put("longitude", Double.valueOf(this.t));
    localContentValues.put("numberOfComments", Integer.valueOf(this.f));
    localContentValues.put("numberOfLikes", Integer.valueOf(this.d));
    localContentValues.put("posterId", this.n);
    localContentValues.put("showHandle", Boolean.valueOf(this.w));
    localContentValues.put("timePosted", this.m);
    localContentValues.put("type", Integer.valueOf(this.h));
    localContentValues.put("yakId", this.b);
    localContentValues.put("yakkerHandle", this.k);
    localContentValues.put("yakkerId", this.j);
    return localContentValues;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    double d1 = 0.0D;
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("messageID")) {
          break label987;
        }
        str1 = paramJSONObject.getString("messageID");
        this.b = str1;
        if (this.b.equals("10320849")) {
          this.b = "0";
        }
        if (!paramJSONObject.has("numberOfLikes")) {
          break label994;
        }
        i1 = paramJSONObject.getInt("numberOfLikes");
        this.d = i1;
        if (!paramJSONObject.has("hidePin")) {
          break label1000;
        }
        i2 = paramJSONObject.getInt("hidePin");
        this.e = i2;
        if (!paramJSONObject.has("comments")) {
          break label1006;
        }
        i3 = paramJSONObject.getInt("comments");
        this.f = i3;
        if (!paramJSONObject.has("commentID")) {
          break label1012;
        }
        str2 = paramJSONObject.getString("commentID");
        this.c = str2;
        if (!paramJSONObject.has("liked")) {
          break label1019;
        }
        i4 = paramJSONObject.getInt("liked");
        this.g = i4;
        if (!paramJSONObject.has("type")) {
          break label1025;
        }
        i5 = paramJSONObject.getInt("type");
        this.h = i5;
        if (paramJSONObject.has("userID"))
        {
          str3 = paramJSONObject.getString("userID");
          this.j = str3;
          if (!paramJSONObject.has("handle")) {
            break label1038;
          }
          str4 = paramJSONObject.getString("handle");
          this.k = str4;
          if (!this.k.equals("null")) {
            continue;
          }
          str5 = "";
          this.k = str5;
          if (!paramJSONObject.has("showHandle")) {
            break label1045;
          }
          bool2 = paramJSONObject.getBoolean("showHandle");
          this.w = bool2;
          if (!paramJSONObject.has("message")) {
            continue;
          }
          str6 = paramJSONObject.getString("message");
          this.l = str6;
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          if (!paramJSONObject.has("time")) {
            continue;
          }
          this.m = paramJSONObject.getString("time");
        }
      }
      catch (JSONException localJSONException)
      {
        String str5;
        String str6;
        SimpleDateFormat localSimpleDateFormat;
        Date localDate;
        int i7;
        long l1;
        this.E = true;
        break label986;
        int i6 = paramInt;
        continue;
        this.m = localSimpleDateFormat.format(new Date());
        continue;
        String str9 = this.l;
        continue;
        String str17 = "";
        continue;
      }
      try
      {
        localDate = localSimpleDateFormat.parse(paramJSONObject.getString("time"));
        if (paramJSONObject.has("deliveryID"))
        {
          i7 = paramJSONObject.getInt("deliveryID");
          this.i = i7;
          if (paramJSONObject.has("deliveryID")) {
            paramInt = paramJSONObject.getInt("deliveryID");
          }
          this.i = paramInt;
          if (!paramJSONObject.has("posterID")) {
            break label1051;
          }
          str7 = paramJSONObject.getString("posterID");
          this.n = str7;
          if (!paramJSONObject.has("comment")) {
            break label1058;
          }
          str8 = paramJSONObject.getString("comment");
          this.o = str8;
          if (!this.l.equals("")) {
            continue;
          }
          str9 = this.o;
          this.l = str9;
          if (this.c.equals("0")) {
            break label1065;
          }
          bool3 = true;
          this.v = bool3;
          if (!paramJSONObject.has("isDeleted")) {
            break label1077;
          }
          if (paramJSONObject.getInt("isDeleted") != 1) {
            break label1071;
          }
          bool4 = true;
          this.x = bool4;
          if (!paramJSONObject.has("readOnly")) {
            break label1089;
          }
          if (paramJSONObject.getInt("readOnly") != 1) {
            break label1083;
          }
          bool5 = true;
          this.y = bool5;
          if (!paramJSONObject.has("latitude")) {
            break label1095;
          }
          d2 = paramJSONObject.getDouble("latitude");
          this.s = d2;
          if (paramJSONObject.has("longitude")) {
            d1 = paramJSONObject.getDouble("longitude");
          }
          this.t = d1;
          if (!paramJSONObject.has("url")) {
            break label1101;
          }
          str10 = paramJSONObject.getString("url");
          this.z = str10;
          if (!paramJSONObject.has("thumbNailUrl")) {
            break label1108;
          }
          str11 = paramJSONObject.getString("thumbNailUrl");
          this.D = str11;
          if (!paramJSONObject.has("title")) {
            break label1115;
          }
          str12 = paramJSONObject.getString("title");
          this.A = str12;
          if (!paramJSONObject.has("summary")) {
            break label1122;
          }
          str13 = paramJSONObject.getString("summary");
          this.B = str13;
          if (!paramJSONObject.has("provider")) {
            break label1129;
          }
          str14 = paramJSONObject.getString("provider");
          this.C = str14;
          if (!paramJSONObject.has("overlayID")) {
            break label1136;
          }
          str15 = paramJSONObject.getString("overlayID");
          this.p = str15;
          if (!paramJSONObject.has("backID")) {
            break label1143;
          }
          str16 = paramJSONObject.getString("backID");
          this.q = str16;
          if (!paramJSONObject.has("textStyle")) {
            continue;
          }
          str17 = paramJSONObject.getString("textStyle");
          this.r = str17;
          if ((paramJSONObject.has("op")) && (paramJSONObject.getInt("op") == 1)) {
            bool1 = true;
          }
          this.u = bool1;
          break label986;
          if (!paramJSONObject.has("posterID")) {
            break label1031;
          }
          str3 = paramJSONObject.getString("posterID");
          continue;
          str5 = this.k;
          continue;
          str6 = "";
          continue;
        }
        l1 = localDate.getTime() / 10000L;
        i7 = (int)l1;
        continue;
        i6 = paramJSONObject.getInt("deliveryID");
      }
      catch (Exception localException)
      {
        if (!paramJSONObject.has("deliveryID")) {
          continue;
        }
      }
      this.i = i6;
      continue;
      label986:
      return;
      label987:
      String str1 = "0";
      continue;
      label994:
      int i1 = 0;
      continue;
      label1000:
      int i2 = 0;
      continue;
      label1006:
      int i3 = 0;
      continue;
      label1012:
      String str2 = "0";
      continue;
      label1019:
      int i4 = 0;
      continue;
      label1025:
      int i5 = 0;
      continue;
      label1031:
      String str3 = "";
      continue;
      label1038:
      String str4 = "";
      continue;
      label1045:
      boolean bool2 = false;
      continue;
      label1051:
      String str7 = "";
      continue;
      label1058:
      String str8 = "";
      continue;
      label1065:
      boolean bool3 = false;
      continue;
      label1071:
      boolean bool4 = false;
      continue;
      label1077:
      bool4 = false;
      continue;
      label1083:
      boolean bool5 = false;
      continue;
      label1089:
      bool5 = false;
      continue;
      label1095:
      double d2 = d1;
      continue;
      label1101:
      String str10 = "";
      continue;
      label1108:
      String str11 = "";
      continue;
      label1115:
      String str12 = "";
      continue;
      label1122:
      String str13 = "";
      continue;
      label1129:
      String str14 = "";
      continue;
      label1136:
      String str15 = "";
      continue;
      label1143:
      String str16 = "";
    }
  }
  
  public boolean b()
  {
    boolean bool1 = false;
    if (!this.G)
    {
      Toast.makeText(this.I, 2131230966, 0).show();
      return bool1;
    }
    boolean bool2 = CR.a("voting", "enableVoteChanging", false);
    TreeMap localTreeMap = new TreeMap();
    YakkerLocation localYakkerLocation = CM.a(this.I).f();
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    String str;
    label90:
    boolean bool3;
    if (this.v)
    {
      str = "likeComment";
      localTreeMap.put("commentID", this.c);
      if ((this.g != -1) || (!bool2)) {
        break label155;
      }
      this.g = 1;
      this.d = (2 + this.d);
      a(str, localTreeMap, localYakkerLocation);
      bool3 = true;
    }
    for (;;)
    {
      bool1 = bool3;
      break;
      str = "likeMessage";
      localTreeMap.put("messageID", this.b);
      break label90;
      label155:
      if (this.g == 0)
      {
        this.g = 1;
        this.d = (1 + this.d);
        a(str, localTreeMap, localYakkerLocation);
        If.a().a(Ih.a, this, "Tap");
        bool3 = true;
      }
      else if ((this.g == 1) && (bool2))
      {
        this.g = 0;
        this.d = (-1 + this.d);
        a(str, localTreeMap, localYakkerLocation);
        bool3 = true;
      }
      else
      {
        Toast.makeText(this.I, 2131231023, 0).show();
        bool3 = false;
      }
    }
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    if (!this.G)
    {
      Toast.makeText(this.I, 2131230966, 0).show();
      return bool1;
    }
    boolean bool2 = CR.a("voting", "enableVoteChanging", false);
    TreeMap localTreeMap = new TreeMap();
    YakkerLocation localYakkerLocation = CM.a(this.I).f();
    localTreeMap.put("messageID", String.valueOf(this.b));
    localTreeMap.put("userID", ApplicationConfig.getYakkerID());
    String str;
    label104:
    boolean bool3;
    if (this.v)
    {
      str = "downvoteComment";
      localTreeMap.put("commentID", this.c);
      if ((this.g != -1) || (!bool2)) {
        break label169;
      }
      this.g = 0;
      this.d = (1 + this.d);
      a(str, localTreeMap, localYakkerLocation);
      bool3 = true;
    }
    for (;;)
    {
      bool1 = bool3;
      break;
      str = "downvoteMessage";
      localTreeMap.put("messageID", this.b);
      break label104;
      label169:
      if (this.g == 0)
      {
        this.g = -1;
        this.d = (-1 + this.d);
        a(str, localTreeMap, localYakkerLocation);
        If.a().a(Ih.b, this, "Tap");
        bool3 = true;
      }
      else if ((this.g == 1) && (bool2))
      {
        this.g = -1;
        this.d = (-2 + this.d);
        a(str, localTreeMap, localYakkerLocation);
        bool3 = true;
      }
      else
      {
        Toast.makeText(this.I, 2131231023, 0).show();
        bool3 = false;
      }
    }
  }
  
  public JSONObject d()
  {
    int i1 = 1;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("messageID", this.b);
      localJSONObject.put("message", this.l);
      localJSONObject.put("latitude", this.s);
      localJSONObject.put("longitude", this.t);
      localJSONObject.put("time", this.m);
      localJSONObject.put("numberOfLikes", this.d);
      localJSONObject.put("type", this.h);
      localJSONObject.put("posterID", this.j);
      localJSONObject.put("handle", this.k);
      localJSONObject.put("showHandle", this.w);
      localJSONObject.put("liked", this.g);
      localJSONObject.put("reyaked", 0);
      if (this.i > 0) {
        localJSONObject.put("deliveryID", this.i);
      }
      int i2;
      if (this.x)
      {
        i2 = i1;
        localJSONObject.put("isDeleted", i2);
        if (!this.y) {
          break label321;
        }
      }
      for (;;)
      {
        localJSONObject.put("readOnly", i1);
        localJSONObject.put("provider", this.C);
        localJSONObject.put("summary", this.B);
        localJSONObject.put("thumbNailUrl", this.D);
        localJSONObject.put("title", this.A);
        localJSONObject.put("url", this.z);
        localJSONObject.put("comments", this.f);
        localJSONObject.put("overlayID", this.p);
        localJSONObject.put("backID", this.q);
        localJSONObject.put("textStyle", this.r);
        return localJSONObject;
        i2 = 0;
        break;
        label321:
        i1 = 0;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject = null;
      }
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     CK

 * JD-Core Version:    0.7.0.1

 */