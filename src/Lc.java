import org.json.JSONObject;

class Lc
  implements Lq
{
  private long a(Jl paramJl, long paramLong, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("expires_at")) {}
    for (long l = paramJSONObject.getLong("expires_at");; l = paramJl.a() + 1000L * paramLong) {
      return l;
    }
  }
  
  private KW b(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.getString("identifier");
    String str2 = paramJSONObject.getString("status");
    String str3 = paramJSONObject.getString("url");
    String str4 = paramJSONObject.getString("reports_url");
    boolean bool = paramJSONObject.optBoolean("update_required", false);
    KU localKU = null;
    if ((paramJSONObject.has("icon")) && (paramJSONObject.getJSONObject("icon").has("hash"))) {
      localKU = c(paramJSONObject.getJSONObject("icon"));
    }
    return new KW(str1, str2, str3, str4, bool, localKU);
  }
  
  private KU c(JSONObject paramJSONObject)
  {
    return new KU(paramJSONObject.getString("hash"), paramJSONObject.getInt("width"), paramJSONObject.getInt("height"));
  }
  
  private Le d(JSONObject paramJSONObject)
  {
    return new Le(paramJSONObject.optBoolean("prompt_enabled", false), paramJSONObject.optBoolean("collect_logged_exceptions", true), paramJSONObject.optBoolean("collect_reports", true), paramJSONObject.optBoolean("collect_analytics", false));
  }
  
  private KT e(JSONObject paramJSONObject)
  {
    return new KT(paramJSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), paramJSONObject.optInt("flush_interval_secs", 600), paramJSONObject.optInt("max_byte_size_per_file", 8000), paramJSONObject.optInt("max_file_count_per_send", 1), paramJSONObject.optInt("max_pending_send_file_count", 100));
  }
  
  private Lh f(JSONObject paramJSONObject)
  {
    return new Lh(paramJSONObject.optInt("log_buffer_size", 64000), paramJSONObject.optInt("max_chained_exception_depth", 8), paramJSONObject.optInt("max_custom_exception_events", 64), paramJSONObject.optInt("max_custom_key_value_pairs", 64), paramJSONObject.optInt("identifier_mask", 255), paramJSONObject.optBoolean("send_session_without_crash", false));
  }
  
  private Lg g(JSONObject paramJSONObject)
  {
    return new Lg(paramJSONObject.optString("title", "Send Crash Report?"), paramJSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), paramJSONObject.optString("send_button_title", "Send"), paramJSONObject.optBoolean("show_cancel_button", true), paramJSONObject.optString("cancel_button_title", "Don't Send"), paramJSONObject.optBoolean("show_always_send_button", true), paramJSONObject.optString("always_send_button_title", "Always Send"));
  }
  
  private KX h(JSONObject paramJSONObject)
  {
    return new KX(paramJSONObject.optString("update_endpoint", Lp.a), paramJSONObject.optInt("update_suspend_duration", 3600));
  }
  
  public Lo a(Jl paramJl, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("settings_version", 0);
    int j = paramJSONObject.optInt("cache_duration", 3600);
    KW localKW = b(paramJSONObject.getJSONObject("app"));
    Lh localLh = f(paramJSONObject.getJSONObject("session"));
    Lg localLg = g(paramJSONObject.getJSONObject("prompt"));
    Le localLe = d(paramJSONObject.getJSONObject("features"));
    KT localKT = e(paramJSONObject.getJSONObject("analytics"));
    KX localKX = h(paramJSONObject.getJSONObject("beta"));
    return new Lo(a(paramJl, j, paramJSONObject), localKW, localLh, localLg, localLe, localKT, localKX, i, j);
  }
  
  public JSONObject a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject(paramJSONObject.toString());
    localJSONObject.getJSONObject("features").remove("collect_analytics");
    localJSONObject.remove("analytics");
    return localJSONObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Lc
 * JD-Core Version:    0.7.0.1
 */