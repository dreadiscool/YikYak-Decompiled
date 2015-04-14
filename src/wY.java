import java.util.Date;
import java.util.UUID;

final class wY
{
  private static wW a;
  
  public static String a()
  {
    try
    {
      a = wW.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("connection_type=" + a.l());
      a(localStringBuilder, "age", a.e());
      a(localStringBuilder, "altitude", a.g());
      a(localStringBuilder, "android_id", a.h());
      a(localStringBuilder, "app_ad_tracking", a.i());
      a(localStringBuilder, "app_name", a.j());
      a(localStringBuilder, "app_version", a.k());
      a(localStringBuilder, "country_code", a.m());
      a(localStringBuilder, "currency_code", a.n());
      a(localStringBuilder, "device_brand", a.o());
      a(localStringBuilder, "device_carrier", a.p());
      a(localStringBuilder, "device_cpu_type", a.q());
      a(localStringBuilder, "device_cpu_subtype", a.r());
      a(localStringBuilder, "device_model", a.t());
      a(localStringBuilder, "device_id", a.s());
      a(localStringBuilder, "attribute_sub1", a.u());
      a(localStringBuilder, "attribute_sub2", a.v());
      a(localStringBuilder, "attribute_sub3", a.w());
      a(localStringBuilder, "attribute_sub4", a.x());
      a(localStringBuilder, "attribute_sub5", a.y());
      a(localStringBuilder, "content_id", a.z());
      a(localStringBuilder, "content_type", a.A());
      a(localStringBuilder, "date1", a.B());
      a(localStringBuilder, "date2", a.C());
      a(localStringBuilder, "level", a.E());
      a(localStringBuilder, "quantity", a.G());
      a(localStringBuilder, "rating", a.H());
      a(localStringBuilder, "search_string", a.I());
      a(localStringBuilder, "existing_user", a.J());
      a(localStringBuilder, "facebook_user_id", a.K());
      a(localStringBuilder, "gender", a.L());
      a(localStringBuilder, "google_aid", a.M());
      a(localStringBuilder, "google_ad_tracking_disabled", a.N());
      a(localStringBuilder, "google_user_id", a.O());
      a(localStringBuilder, "insdate", a.P());
      a(localStringBuilder, "installer", a.Q());
      a(localStringBuilder, "install_log_id", a.R());
      a(localStringBuilder, "install_referrer", a.S());
      a(localStringBuilder, "is_paying_user", a.T());
      a(localStringBuilder, "language", a.U());
      a(localStringBuilder, "last_open_log_id", a.V());
      a(localStringBuilder, "latitude", a.W());
      a(localStringBuilder, "longitude", a.X());
      a(localStringBuilder, "mac_address", a.Y());
      a(localStringBuilder, "mat_id", a.Z());
      a(localStringBuilder, "mobile_country_code", a.aa());
      a(localStringBuilder, "mobile_network_code", a.ab());
      a(localStringBuilder, "open_log_id", a.ac());
      a(localStringBuilder, "os_version", a.ad());
      a(localStringBuilder, "sdk_plugin", a.af());
      a(localStringBuilder, "android_purchase_status", a.ag());
      a(localStringBuilder, "advertiser_ref_id", a.aj());
      a(localStringBuilder, "revenue", a.ak());
      a(localStringBuilder, "screen_density", a.al());
      a(localStringBuilder, "screen_layout_size", a.an() + "x" + a.am());
      a(localStringBuilder, "sdk_version", a.ao());
      a(localStringBuilder, "truste_tpid", a.ar());
      a(localStringBuilder, "twitter_user_id", a.as());
      a(localStringBuilder, "update_log_id", a.at());
      a(localStringBuilder, "conversion_user_agent", a.au());
      a(localStringBuilder, "user_email", a.av());
      a(localStringBuilder, "user_id", a.aw());
      a(localStringBuilder, "user_name", a.ax());
      String str = localStringBuilder.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String a(String paramString, wQ paramwQ)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      wW localwW = wW.a();
      a = localwW;
      if (localwW != null)
      {
        String str3 = a.M();
        if ((str3 != null) && (!paramString.contains("&google_aid=")))
        {
          a(localStringBuilder, "google_aid", str3);
          a(localStringBuilder, "google_ad_tracking_disabled", a.N());
        }
        String str4 = a.S();
        if ((str4 != null) && (!paramString.contains("&install_referrer="))) {
          a(localStringBuilder, "install_referrer", str4);
        }
      }
      if (!paramString.contains("&system_date=")) {
        a(localStringBuilder, "system_date", Long.toString(new Date().getTime() / 1000L));
      }
      String str1 = localStringBuilder.toString();
      Object localObject2 = str1;
      try
      {
        String str2 = wQ.a(paramwQ.a((String)localObject2));
        localObject2 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return localObject2;
    }
    finally {}
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a = wW.a();
    StringBuilder localStringBuilder = new StringBuilder("https://").append(a.d()).append(".");
    if (paramBoolean1) {
      localStringBuilder.append("debug.engine.mobileapptracking.com");
    }
    for (;;)
    {
      localStringBuilder.append("/serve?ver=").append(a.ao());
      localStringBuilder.append("&transaction_id=").append(UUID.randomUUID().toString());
      a(localStringBuilder, "sdk", "android");
      a(localStringBuilder, "action", a.c());
      a(localStringBuilder, "advertiser_id", a.d());
      a(localStringBuilder, "site_event_id", a.D());
      a(localStringBuilder, "site_event_name", a.F());
      a(localStringBuilder, "package_name", a.ae());
      a(localStringBuilder, "referral_source", a.ah());
      a(localStringBuilder, "referral_url", a.ai());
      a(localStringBuilder, "site_id", a.ap());
      a(localStringBuilder, "tracking_id", a.aq());
      if (paramBoolean2) {
        localStringBuilder.append("&attr_set=1");
      }
      a(localStringBuilder, "publisher_id", a.az());
      a(localStringBuilder, "offer_id", a.ay());
      a(localStringBuilder, "publisher_ref_id", a.aA());
      a(localStringBuilder, "publisher_sub_publisher", a.aH());
      a(localStringBuilder, "publisher_sub_site", a.aI());
      a(localStringBuilder, "publisher_sub_campaign", a.aJ());
      a(localStringBuilder, "publisher_sub_adgroup", a.aK());
      a(localStringBuilder, "publisher_sub_ad", a.aL());
      a(localStringBuilder, "publisher_sub_keyword", a.aM());
      a(localStringBuilder, "advertiser_sub_publisher", a.aB());
      a(localStringBuilder, "advertiser_sub_site", a.aC());
      a(localStringBuilder, "advertiser_sub_campaign", a.aD());
      a(localStringBuilder, "advertiser_sub_adgroup", a.aE());
      a(localStringBuilder, "advertiser_sub_ad", a.aF());
      a(localStringBuilder, "advertiser_sub_keyword", a.aG());
      a(localStringBuilder, "publisher_sub1", a.aN());
      a(localStringBuilder, "publisher_sub2", a.aO());
      a(localStringBuilder, "publisher_sub3", a.aP());
      a(localStringBuilder, "publisher_sub4", a.aQ());
      a(localStringBuilder, "publisher_sub5", a.aR());
      String str = a.f();
      if ((str != null) && (Integer.parseInt(str) == 1)) {
        localStringBuilder.append("&skip_dup=1");
      }
      if (paramBoolean1) {
        localStringBuilder.append("&debug=1");
      }
      return localStringBuilder.toString();
      localStringBuilder.append("engine.mobileapptracking.com");
    }
  }
  
  /* Error */
  public static org.json.JSONObject a(org.json.JSONArray paramJSONArray, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 587	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 588	org/json/JSONObject:<init>	()V
    //   10: astore_3
    //   11: aload_0
    //   12: ifnull +12 -> 24
    //   15: aload_3
    //   16: ldc_w 590
    //   19: aload_0
    //   20: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   23: pop
    //   24: aload_1
    //   25: ifnull +12 -> 37
    //   28: aload_3
    //   29: ldc_w 596
    //   32: aload_1
    //   33: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   36: pop
    //   37: aload_2
    //   38: ifnull +12 -> 50
    //   41: aload_3
    //   42: ldc_w 598
    //   45: aload_2
    //   46: invokevirtual 594	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   49: pop
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_3
    //   54: areturn
    //   55: astore 5
    //   57: aload 5
    //   59: invokevirtual 599	org/json/JSONException:printStackTrace	()V
    //   62: goto -12 -> 50
    //   65: astore 4
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload 4
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramJSONArray	org.json.JSONArray
    //   0	73	1	paramString1	String
    //   0	73	2	paramString2	String
    //   10	44	3	localJSONObject	org.json.JSONObject
    //   65	6	4	localObject	Object
    //   55	3	5	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   15	50	55	org/json/JSONException
    //   3	11	65	finally
    //   15	50	65	finally
    //   57	62	65	finally
  }
  
  /* Error */
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull +55 -> 59
    //   7: aload_2
    //   8: ldc_w 603
    //   11: invokevirtual 607	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: istore 4
    //   16: iload 4
    //   18: ifne +41 -> 59
    //   21: aload_0
    //   22: new 16	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 609
    //   29: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc_w 611
    //   39: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_2
    //   43: ldc_w 613
    //   46: invokestatic 619	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   49: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 2
    //   61: monitorexit
    //   62: return
    //   63: astore 5
    //   65: new 16	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 621
    //   72: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload_2
    //   76: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 623
    //   82: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: pop
    //   93: aload 5
    //   95: invokevirtual 624	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   98: goto -39 -> 59
    //   101: astore_3
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_3
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramStringBuilder	StringBuilder
    //   0	107	1	paramString1	String
    //   0	107	2	paramString2	String
    //   101	5	3	localObject	Object
    //   14	3	4	bool	boolean
    //   63	31	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   21	59	63	java/io/UnsupportedEncodingException
    //   7	16	101	finally
    //   21	59	101	finally
    //   65	98	101	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wY
 * JD-Core Version:    0.7.0.1
 */