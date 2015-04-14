import org.json.JSONObject;

class bm
{
  public bl a(JSONObject paramJSONObject)
  {
    bl localbl = null;
    if (paramJSONObject == null) {}
    for (;;)
    {
      return localbl;
      String str1 = paramJSONObject.optString("url", null);
      String str2 = paramJSONObject.optString("version_string", null);
      String str3 = paramJSONObject.optString("build_version", null);
      localbl = new bl(str1, str2, paramJSONObject.optString("display_version", null), str3, paramJSONObject.optString("identifier", null), paramJSONObject.optString("instance_identifier", null));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     bm
 * JD-Core Version:    0.7.0.1
 */