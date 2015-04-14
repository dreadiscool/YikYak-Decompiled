import android.graphics.BitmapFactory;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class wa
{
  private static final Class<?>[] b = new Class[0];
  private static final List<wr> c = Collections.emptyList();
  private final vd a;
  
  public wa(vd paramvd)
  {
    this.a = paramvd;
  }
  
  private Integer a(int paramInt, String paramString, vd paramvd)
  {
    Integer localInteger = null;
    int i;
    if (paramString != null) {
      if (paramvd.a(paramString))
      {
        i = paramvd.b(paramString);
        if ((-1 == i) || (-1 == paramInt) || (i == paramInt)) {
          break label83;
        }
      }
    }
    for (;;)
    {
      return localInteger;
      new StringBuilder().append("Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"").append(paramString).append("\"").toString();
      continue;
      i = -1;
      break;
      label83:
      if (-1 != i) {
        localInteger = Integer.valueOf(i);
      } else {
        localInteger = Integer.valueOf(paramInt);
      }
    }
  }
  
  private Object a(Object paramObject, String paramString)
  {
    try
    {
      if ((!"java.lang.CharSequence".equals(paramString)) && (!"boolean".equals(paramString)) && (!"java.lang.Boolean".equals(paramString))) {
        if (("int".equals(paramString)) || ("java.lang.Integer".equals(paramString)))
        {
          paramObject = Integer.valueOf(((Number)paramObject).intValue());
        }
        else if (("float".equals(paramString)) || ("java.lang.Float".equals(paramString)))
        {
          paramObject = Float.valueOf(((Number)paramObject).floatValue());
        }
        else if ("android.graphics.Bitmap".equals(paramString))
        {
          byte[] arrayOfByte = Base64.decode((String)paramObject, 0);
          paramObject = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        }
        else
        {
          throw new wb("Don't know how to interpret type " + paramString + " (arg was " + paramObject + ")");
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      throw new wb("Couldn't interpret <" + paramObject + "> as " + paramString);
    }
    return paramObject;
  }
  
  private ws a(Class<?> paramClass, JSONObject paramJSONObject)
  {
    String str1 = null;
    for (;;)
    {
      try
      {
        String str2 = paramJSONObject.getString("name");
        if (paramJSONObject.has("get"))
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject("get");
          String str3 = localJSONObject.getString("selector");
          Class localClass = Class.forName(localJSONObject.getJSONObject("result").getString("type"));
          localvU = new vU(paramClass, str3, b, localClass);
          if (paramJSONObject.has("set")) {
            str1 = paramJSONObject.getJSONObject("set").getString("selector");
          }
          ws localws = new ws(str2, paramClass, localvU, str1);
          return localws;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new wb("Can't create property reader", localNoSuchMethodException);
      }
      catch (JSONException localJSONException)
      {
        throw new wb("Can't read property JSON", localJSONException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new wb("Can't read property JSON, relevant arg/return class not found", localClassNotFoundException);
      }
      vU localvU = null;
    }
  }
  
  List<wr> a(JSONArray paramJSONArray, vd paramvd)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String str1;
    String str2;
    int j;
    String str3;
    String str5;
    int m;
    label108:
    Integer localInteger;
    Object localObject;
    if (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      str1 = vS.a(localJSONObject, "prefix");
      str2 = vS.a(localJSONObject, "view_class");
      j = localJSONObject.optInt("index", -1);
      str3 = vS.a(localJSONObject, "contentDescription");
      int k = localJSONObject.optInt("id", -1);
      String str4 = vS.a(localJSONObject, "mp_id_name");
      str5 = vS.a(localJSONObject, "tag");
      if ("shortest".equals(str1))
      {
        m = 1;
        localInteger = a(k, str4, paramvd);
        if (localInteger != null) {
          break label177;
        }
        localObject = c;
      }
    }
    for (;;)
    {
      return localObject;
      if (str1 == null)
      {
        m = 0;
        break label108;
      }
      new StringBuilder().append("Unrecognized prefix type \"").append(str1).append("\". No views will be matched").toString();
      localObject = c;
      continue;
      label177:
      localArrayList.add(new wr(m, str2, j, localInteger.intValue(), str3, str5));
      i++;
      break;
      localObject = localArrayList;
    }
  }
  
  /* Error */
  public wH a(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 244
    //   4: invokevirtual 248	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7: aload_0
    //   8: getfield 32	wa:a	Lvd;
    //   11: invokevirtual 250	wa:a	(Lorg/json/JSONArray;Lvd;)Ljava/util/List;
    //   14: astore 4
    //   16: aload 4
    //   18: invokeinterface 253 1 0
    //   23: ifne +27 -> 50
    //   26: new 255	wc
    //   29: dup
    //   30: ldc_w 257
    //   33: invokespecial 258	wc:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: astore_3
    //   38: new 116	wb
    //   41: dup
    //   42: ldc_w 260
    //   45: aload_3
    //   46: invokespecial 183	wb:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   49: athrow
    //   50: aload 4
    //   52: bipush 255
    //   54: aload 4
    //   56: invokeinterface 253 1 0
    //   61: iadd
    //   62: invokeinterface 263 2 0
    //   67: checkcast 232	wr
    //   70: getfield 266	wr:b	Ljava/lang/String;
    //   73: astore 5
    //   75: aload 5
    //   77: invokestatic 166	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   80: astore 7
    //   82: aload_0
    //   83: aload 7
    //   85: aload_1
    //   86: ldc_w 268
    //   89: invokevirtual 156	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   92: invokespecial 270	wa:a	(Ljava/lang/Class;Lorg/json/JSONObject;)Lws;
    //   95: astore 8
    //   97: aload_1
    //   98: ldc_w 272
    //   101: invokevirtual 248	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   104: astore 9
    //   106: aload 9
    //   108: invokevirtual 196	org/json/JSONArray:length	()I
    //   111: anewarray 4	java/lang/Object
    //   114: astore 10
    //   116: iconst_0
    //   117: istore 11
    //   119: iload 11
    //   121: aload 9
    //   123: invokevirtual 196	org/json/JSONArray:length	()I
    //   126: if_icmpge +85 -> 211
    //   129: aload 9
    //   131: iload 11
    //   133: invokevirtual 275	org/json/JSONArray:getJSONArray	(I)Lorg/json/JSONArray;
    //   136: astore 14
    //   138: aload 10
    //   140: iload 11
    //   142: aload_0
    //   143: aload 14
    //   145: iconst_0
    //   146: invokevirtual 276	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   149: aload 14
    //   151: iconst_1
    //   152: invokevirtual 279	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   155: invokespecial 281	wa:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   158: aastore
    //   159: iinc 11 1
    //   162: goto -43 -> 119
    //   165: astore 6
    //   167: new 116	wb
    //   170: dup
    //   171: new 43	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 283
    //   181: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 5
    //   186: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: aload 6
    //   194: invokespecial 183	wb:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   197: athrow
    //   198: astore_2
    //   199: new 116	wb
    //   202: dup
    //   203: ldc_w 285
    //   206: aload_2
    //   207: invokespecial 183	wb:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   210: athrow
    //   211: aload 8
    //   213: aload 10
    //   215: invokevirtual 288	ws:a	([Ljava/lang/Object;)LvU;
    //   218: astore 12
    //   220: aload 12
    //   222: ifnonnull +41 -> 263
    //   225: new 116	wb
    //   228: dup
    //   229: new 43	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 290
    //   239: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 8
    //   244: getfield 292	ws:a	Ljava/lang/String;
    //   247: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 294
    //   253: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokespecial 128	wb:<init>	(Ljava/lang/String;)V
    //   262: athrow
    //   263: new 296	wO
    //   266: dup
    //   267: aload 4
    //   269: aload 12
    //   271: aload 8
    //   273: getfield 299	ws:c	LvU;
    //   276: invokespecial 302	wO:<init>	(Ljava/util/List;LvU;LvU;)V
    //   279: astore 13
    //   281: aload 13
    //   283: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	wa
    //   0	284	1	paramJSONObject	JSONObject
    //   198	9	2	localJSONException	JSONException
    //   37	9	3	localNoSuchMethodException	NoSuchMethodException
    //   14	254	4	localList	List
    //   73	112	5	str	String
    //   165	28	6	localClassNotFoundException	ClassNotFoundException
    //   80	4	7	localClass	Class
    //   95	177	8	localws	ws
    //   104	26	9	localJSONArray1	JSONArray
    //   114	100	10	arrayOfObject	Object[]
    //   117	43	11	i	int
    //   218	52	12	localvU	vU
    //   279	3	13	localwO	wO
    //   136	14	14	localJSONArray2	JSONArray
    // Exception table:
    //   from	to	target	type
    //   0	37	37	java/lang/NoSuchMethodException
    //   50	75	37	java/lang/NoSuchMethodException
    //   75	82	37	java/lang/NoSuchMethodException
    //   82	198	37	java/lang/NoSuchMethodException
    //   211	281	37	java/lang/NoSuchMethodException
    //   75	82	165	java/lang/ClassNotFoundException
    //   0	37	198	org/json/JSONException
    //   50	75	198	org/json/JSONException
    //   75	82	198	org/json/JSONException
    //   82	198	198	org/json/JSONException
    //   211	281	198	org/json/JSONException
  }
  
  public wH a(JSONObject paramJSONObject, wN paramwN)
  {
    String str1;
    String str2;
    List localList;
    try
    {
      str1 = paramJSONObject.getString("event_name");
      str2 = paramJSONObject.getString("event_type");
      localList = a(paramJSONObject.getJSONArray("path"), this.a);
      if (localList.size() == 0) {
        throw new wc("event '" + str1 + "' will not be bound to any element in the UI.");
      }
    }
    catch (JSONException localJSONException)
    {
      throw new wb("Can't interpret instructions due to JSONException", localJSONException);
    }
    Object localObject;
    if ("click".equals(str2)) {
      localObject = new wI(localList, 1, str1, paramwN);
    } else if ("selected".equals(str2)) {
      localObject = new wI(localList, 4, str1, paramwN);
    } else if ("text_changed".equals(str2)) {
      localObject = new wK(localList, str1, paramwN);
    } else if ("detected".equals(str2)) {
      localObject = new wP(localList, str1, paramwN);
    } else {
      throw new wb("Mixpanel can't track event type \"" + str2 + "\"");
    }
    return localObject;
  }
  
  public wC b(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray1 = paramJSONObject.getJSONObject("config").getJSONArray("classes");
        i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = localJSONArray1.getJSONObject(i);
          Class localClass = Class.forName(localJSONObject.getString("name"));
          JSONArray localJSONArray2 = localJSONObject.getJSONArray("properties");
          int j = 0;
          if (j < localJSONArray2.length())
          {
            localArrayList.add(a(localClass, localJSONArray2.getJSONObject(j)));
            j++;
            continue;
          }
        }
        else
        {
          wC localwC = new wC(localArrayList, this.a);
          return localwC;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new wb("Can't read snapshot configuration", localJSONException);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new wb("Can't resolve types for snapshot configuration", localClassNotFoundException);
      }
      i++;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wa
 * JD-Core Version:    0.7.0.1
 */