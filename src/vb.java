import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"CommitPrefEdits"})
public class vb
{
  private static boolean j = true;
  private static final Object k = new Object();
  private final Future<SharedPreferences> a;
  private final Future<SharedPreferences> b;
  private final SharedPreferences.OnSharedPreferenceChangeListener c;
  private JSONObject d;
  private Map<String, String> e;
  private boolean f;
  private String g;
  private String h;
  private JSONArray i;
  
  public vb(Future<SharedPreferences> paramFuture1, Future<SharedPreferences> paramFuture2)
  {
    this.b = paramFuture1;
    this.a = paramFuture2;
    this.d = null;
    this.e = null;
    this.f = false;
    this.c = new vc(this);
  }
  
  public static JSONArray a(SharedPreferences paramSharedPreferences)
  {
    Object localObject = null;
    String str1 = paramSharedPreferences.getString("people_distinct_id", null);
    String str2 = paramSharedPreferences.getString("waiting_array", null);
    if ((str2 != null) && (str1 != null)) {}
    for (;;)
    {
      try
      {
        localJSONArray1 = new JSONArray(str2);
        localJSONArray2 = new JSONArray();
        m = 0;
        if (m >= localJSONArray1.length()) {}
      }
      catch (JSONException localJSONException2)
      {
        JSONArray localJSONArray1;
        JSONArray localJSONArray2;
        int m;
        JSONObject localJSONObject;
        SharedPreferences.Editor localEditor;
        continue;
      }
      try
      {
        localJSONObject = localJSONArray1.getJSONObject(m);
        localJSONObject.put("$distinct_id", str1);
        localJSONArray2.put(localJSONObject);
        m++;
        continue;
        localEditor = paramSharedPreferences.edit();
        localEditor.remove("waiting_array");
        a(localEditor);
        localObject = localJSONArray2;
        return localObject;
      }
      catch (JSONException localJSONException1) {}
    }
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: getstatic 37	vb:k	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: aload_0
    //   7: aload_1
    //   8: iconst_0
    //   9: invokevirtual 113	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   12: invokeinterface 97 1 0
    //   17: astore 5
    //   19: aload 5
    //   21: invokeinterface 116 1 0
    //   26: pop
    //   27: aload_2
    //   28: invokeinterface 122 1 0
    //   33: invokeinterface 128 1 0
    //   38: astore 7
    //   40: aload 7
    //   42: invokeinterface 134 1 0
    //   47: ifeq +53 -> 100
    //   50: aload 7
    //   52: invokeinterface 138 1 0
    //   57: checkcast 140	java/util/Map$Entry
    //   60: astore 8
    //   62: aload 5
    //   64: aload 8
    //   66: invokeinterface 143 1 0
    //   71: checkcast 145	java/lang/String
    //   74: aload 8
    //   76: invokeinterface 148 1 0
    //   81: checkcast 145	java/lang/String
    //   84: invokeinterface 152 3 0
    //   89: pop
    //   90: goto -50 -> 40
    //   93: astore 4
    //   95: aload_3
    //   96: monitorexit
    //   97: aload 4
    //   99: athrow
    //   100: aload 5
    //   102: invokestatic 106	vb:a	(Landroid/content/SharedPreferences$Editor;)V
    //   105: iconst_1
    //   106: putstatic 32	vb:j	Z
    //   109: aload_3
    //   110: monitorexit
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramContext	android.content.Context
    //   0	112	1	paramString	String
    //   0	112	2	paramMap	Map<String, String>
    //   3	107	3	localObject1	Object
    //   93	5	4	localObject2	Object
    //   17	84	5	localEditor	SharedPreferences.Editor
    //   38	13	7	localIterator	Iterator
    //   60	15	8	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   6	97	93	finally
    //   100	111	93	finally
  }
  
  @TargetApi(9)
  private static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramEditor.apply();
    }
    for (;;)
    {
      return;
      paramEditor.commit();
    }
  }
  
  private void j()
  {
    try
    {
      String str = ((SharedPreferences)this.a.get()).getString("super_properties", "{}");
      if (uJ.a) {
        new StringBuilder().append("Loading Super Properties ").append(str).toString();
      }
      this.d = new JSONObject(str);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;)
      {
        localExecutionException.getCause();
        if (this.d == null) {
          this.d = new JSONObject();
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        if (this.d == null) {
          this.d = new JSONObject();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        l();
        if (this.d == null) {
          this.d = new JSONObject();
        }
      }
    }
    finally
    {
      if (this.d == null) {
        this.d = new JSONObject();
      }
    }
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 210	java/util/HashMap
    //   4: dup
    //   5: invokespecial 211	java/util/HashMap:<init>	()V
    //   8: putfield 46	vb:e	Ljava/util/Map;
    //   11: aload_0
    //   12: getfield 40	vb:b	Ljava/util/concurrent/Future;
    //   15: invokeinterface 178 1 0
    //   20: checkcast 62	android/content/SharedPreferences
    //   23: astore 4
    //   25: aload 4
    //   27: aload_0
    //   28: getfield 55	vb:c	Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;
    //   31: invokeinterface 215 2 0
    //   36: aload 4
    //   38: aload_0
    //   39: getfield 55	vb:c	Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;
    //   42: invokeinterface 218 2 0
    //   47: aload 4
    //   49: invokeinterface 222 1 0
    //   54: invokeinterface 122 1 0
    //   59: invokeinterface 128 1 0
    //   64: astore 5
    //   66: aload 5
    //   68: invokeinterface 134 1 0
    //   73: ifeq +62 -> 135
    //   76: aload 5
    //   78: invokeinterface 138 1 0
    //   83: checkcast 140	java/util/Map$Entry
    //   86: astore 6
    //   88: aload 6
    //   90: invokeinterface 143 1 0
    //   95: checkcast 145	java/lang/String
    //   98: astore 7
    //   100: aload 6
    //   102: invokeinterface 148 1 0
    //   107: astore 8
    //   109: aload_0
    //   110: getfield 46	vb:e	Ljava/util/Map;
    //   113: aload 7
    //   115: aload 8
    //   117: invokevirtual 223	java/lang/Object:toString	()Ljava/lang/String;
    //   120: invokeinterface 226 3 0
    //   125: pop
    //   126: goto -60 -> 66
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 205	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   134: pop
    //   135: return
    //   136: astore_1
    //   137: goto -2 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	vb
    //   136	1	1	localInterruptedException	InterruptedException
    //   129	2	2	localExecutionException	ExecutionException
    //   23	25	4	localSharedPreferences	SharedPreferences
    //   64	13	5	localIterator	Iterator
    //   86	15	6	localEntry	java.util.Map.Entry
    //   98	16	7	str	String
    //   107	9	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	126	129	java/util/concurrent/ExecutionException
    //   11	126	136	java/lang/InterruptedException
  }
  
  private void l()
  {
    if (this.d == null) {}
    for (;;)
    {
      return;
      String str = this.d.toString();
      if (uJ.a) {
        new StringBuilder().append("Storing Super Properties ").append(str).toString();
      }
      try
      {
        SharedPreferences.Editor localEditor = ((SharedPreferences)this.a.get()).edit();
        localEditor.putString("super_properties", str);
        a(localEditor);
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.getCause();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  private void m()
  {
    for (;;)
    {
      String str;
      try
      {
        localSharedPreferences = (SharedPreferences)this.a.get();
        if (localSharedPreferences == null) {
          return;
        }
      }
      catch (ExecutionException localExecutionException)
      {
        localExecutionException.getCause();
        localSharedPreferences = null;
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        SharedPreferences localSharedPreferences = null;
        continue;
        this.g = localSharedPreferences.getString("events_distinct_id", null);
        this.h = localSharedPreferences.getString("people_distinct_id", null);
        this.i = null;
        str = localSharedPreferences.getString("waiting_array", null);
        if (str == null) {}
      }
      try
      {
        this.i = new JSONArray(str);
        if (this.g == null)
        {
          this.g = UUID.randomUUID().toString();
          n();
        }
        this.f = true;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          new StringBuilder().append("Could not interpret waiting people JSON record ").append(str).toString();
        }
      }
    }
  }
  
  private void n()
  {
    try
    {
      SharedPreferences.Editor localEditor = ((SharedPreferences)this.a.get()).edit();
      localEditor.putString("events_distinct_id", this.g);
      localEditor.putString("people_distinct_id", this.h);
      if (this.i == null) {
        localEditor.remove("waiting_array");
      }
      for (;;)
      {
        a(localEditor);
        break;
        localEditor.putString("waiting_array", this.i.toString());
      }
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      localExecutionException.getCause();
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public JSONObject a()
  {
    try
    {
      if (this.d == null) {
        j();
      }
      JSONObject localJSONObject = this.d;
      return localJSONObject;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if (!this.f) {
        m();
      }
      this.g = paramString;
      n();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      if (!this.f) {
        m();
      }
      if (this.i == null) {
        this.i = new JSONArray();
      }
      this.i.put(paramJSONObject);
      n();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Map<String, String> b()
  {
    synchronized (k)
    {
      if ((j) || (this.e == null))
      {
        k();
        j = false;
      }
      return this.e;
    }
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	vb:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 178 1 0
    //   11: checkcast 62	android/content/SharedPreferences
    //   14: invokeinterface 97 1 0
    //   19: astore 6
    //   21: aload 6
    //   23: ldc_w 259
    //   26: aload_1
    //   27: invokeinterface 152 3 0
    //   32: pop
    //   33: aload 6
    //   35: invokestatic 106	vb:a	(Landroid/content/SharedPreferences$Editor;)V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 205	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   48: pop
    //   49: goto -11 -> 38
    //   52: astore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: athrow
    //   57: astore_2
    //   58: goto -20 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	vb
    //   0	61	1	paramString	String
    //   57	1	2	localInterruptedException	InterruptedException
    //   52	4	3	localObject	Object
    //   41	3	4	localExecutionException	ExecutionException
    //   19	15	6	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   2	38	41	java/util/concurrent/ExecutionException
    //   2	38	52	finally
    //   43	49	52	finally
    //   2	38	57	java/lang/InterruptedException
  }
  
  public void b(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = a();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          localJSONObject.put(str, paramJSONObject.get(str));
        }
        catch (JSONException localJSONException) {}
      }
      l();
      return;
    }
    finally {}
  }
  
  public String c()
  {
    try
    {
      if (!this.f) {
        m();
      }
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      a().remove(paramString);
      l();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = a();
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        boolean bool = localJSONObject.has(str);
        if (!bool) {
          try
          {
            localJSONObject.put(str, paramJSONObject.get(str));
          }
          catch (JSONException localJSONException) {}
        }
      }
      l();
      return;
    }
    finally {}
  }
  
  public String d()
  {
    try
    {
      if (!this.f) {
        m();
      }
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public JSONArray e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	vb:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 178 1 0
    //   11: checkcast 62	android/content/SharedPreferences
    //   14: invokestatic 276	vb:a	(Landroid/content/SharedPreferences;)Lorg/json/JSONArray;
    //   17: astore 7
    //   19: aload 7
    //   21: astore_2
    //   22: aload_0
    //   23: invokespecial 256	vb:m	()V
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: astore 4
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 4
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 205	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   43: pop
    //   44: goto -18 -> 26
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: athrow
    //   52: astore_1
    //   53: aconst_null
    //   54: astore_2
    //   55: goto -29 -> 26
    //   58: astore 8
    //   60: goto -34 -> 26
    //   63: astore 5
    //   65: goto -27 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	vb
    //   52	1	1	localInterruptedException1	InterruptedException
    //   21	34	2	localJSONArray1	JSONArray
    //   47	4	3	localObject	Object
    //   30	5	4	localExecutionException1	ExecutionException
    //   36	3	5	localExecutionException2	ExecutionException
    //   63	1	5	localExecutionException3	ExecutionException
    //   17	3	7	localJSONArray2	JSONArray
    //   58	1	8	localInterruptedException2	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	19	30	java/util/concurrent/ExecutionException
    //   2	19	47	finally
    //   22	26	47	finally
    //   38	44	47	finally
    //   2	19	52	java/lang/InterruptedException
    //   22	26	58	java/lang/InterruptedException
    //   22	26	63	java/util/concurrent/ExecutionException
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	vb:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 178 1 0
    //   11: checkcast 62	android/content/SharedPreferences
    //   14: invokeinterface 97 1 0
    //   19: astore 4
    //   21: aload 4
    //   23: invokeinterface 116 1 0
    //   28: pop
    //   29: aload 4
    //   31: invokestatic 106	vb:a	(Landroid/content/SharedPreferences$Editor;)V
    //   34: aload_0
    //   35: invokespecial 254	vb:j	()V
    //   38: aload_0
    //   39: invokespecial 256	vb:m	()V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_3
    //   46: new 278	java/lang/RuntimeException
    //   49: dup
    //   50: aload_3
    //   51: invokevirtual 205	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   54: invokespecial 281	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   57: athrow
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    //   63: astore_1
    //   64: new 278	java/lang/RuntimeException
    //   67: dup
    //   68: aload_1
    //   69: invokevirtual 282	java/lang/InterruptedException:getCause	()Ljava/lang/Throwable;
    //   72: invokespecial 281	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	vb
    //   63	6	1	localInterruptedException	InterruptedException
    //   58	4	2	localObject	Object
    //   45	6	3	localExecutionException	ExecutionException
    //   19	11	4	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   2	42	45	java/util/concurrent/ExecutionException
    //   2	42	58	finally
    //   46	58	58	finally
    //   64	76	58	finally
    //   2	42	63	java/lang/InterruptedException
  }
  
  /* Error */
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	vb:a	Ljava/util/concurrent/Future;
    //   6: invokeinterface 178 1 0
    //   11: checkcast 62	android/content/SharedPreferences
    //   14: invokeinterface 97 1 0
    //   19: astore 5
    //   21: aload 5
    //   23: ldc_w 259
    //   26: invokeinterface 103 2 0
    //   31: pop
    //   32: aload 5
    //   34: invokestatic 106	vb:a	(Landroid/content/SharedPreferences$Editor;)V
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_3
    //   41: aload_3
    //   42: invokevirtual 205	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   45: pop
    //   46: goto -9 -> 37
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    //   54: astore_1
    //   55: goto -18 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	vb
    //   54	1	1	localInterruptedException	InterruptedException
    //   49	4	2	localObject	Object
    //   40	2	3	localExecutionException	ExecutionException
    //   19	14	5	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   2	37	40	java/util/concurrent/ExecutionException
    //   2	37	49	finally
    //   41	46	49	finally
    //   2	37	54	java/lang/InterruptedException
  }
  
  public void h()
  {
    try
    {
      this.d = new JSONObject();
      l();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vb
 * JD-Core Version:    0.7.0.1
 */