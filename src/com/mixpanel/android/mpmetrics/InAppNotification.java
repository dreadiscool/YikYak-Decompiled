package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import uE;
import uF;
import uo;

public class InAppNotification
  implements Parcelable
{
  public static final Parcelable.Creator<InAppNotification> CREATOR = new uE();
  private static final Pattern k = Pattern.compile("(\\.[^./]+$)");
  private Bitmap a;
  private final JSONObject b;
  private final int c;
  private final int d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  
  public InAppNotification(Parcel paramParcel)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject2 = new JSONObject(paramParcel.readString());
      this.b = localJSONObject2;
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      this.g = paramParcel.readString();
      this.h = paramParcel.readString();
      this.i = paramParcel.readString();
      this.j = paramParcel.readString();
      this.a = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject2 = localJSONObject1;
      }
    }
  }
  
  public InAppNotification(JSONObject paramJSONObject)
  {
    try
    {
      this.b = paramJSONObject;
      this.c = paramJSONObject.getInt("id");
      this.d = paramJSONObject.getInt("message_id");
      this.e = paramJSONObject.getString("type");
      this.f = paramJSONObject.getString("title");
      this.g = paramJSONObject.getString("body");
      this.h = paramJSONObject.getString("image_url");
      this.a = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
      this.i = paramJSONObject.getString("cta");
      this.j = paramJSONObject.getString("cta_url");
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new uo("Notification JSON was unexpected or bad", localJSONException);
    }
  }
  
  static String a(String paramString1, String paramString2)
  {
    Matcher localMatcher = k.matcher(paramString1);
    if (localMatcher.find()) {
      paramString1 = localMatcher.replaceFirst(paramString2 + "$1");
    }
    return paramString1;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("campaign_id", b());
      localJSONObject.put("message_id", c());
      localJSONObject.put("message_type", "inapp");
      localJSONObject.put("message_subtype", this.e);
      label50:
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label50;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public uF d()
  {
    uF localuF;
    if (uF.b.toString().equals(this.e)) {
      localuF = uF.b;
    }
    for (;;)
    {
      return localuF;
      if (uF.c.toString().equals(this.e)) {
        localuF = uF.c;
      } else {
        localuF = uF.a;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return a(this.h, "@2x");
  }
  
  public String h()
  {
    return a(this.h, "@4x");
  }
  
  public String i()
  {
    return this.i;
  }
  
  public String j()
  {
    return this.j;
  }
  
  public Bitmap k()
  {
    return this.a;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b.toString());
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeParcelable(this.a, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.InAppNotification
 * JD-Core Version:    0.7.0.1
 */