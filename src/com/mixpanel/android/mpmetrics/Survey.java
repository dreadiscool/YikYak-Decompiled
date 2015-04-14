package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uo;
import vl;
import vm;

public class Survey
  implements Parcelable
{
  public static Parcelable.Creator<Survey> CREATOR = new vl();
  private final JSONObject a;
  private final int b;
  private final int c;
  private final List<vm> d;
  
  public Survey(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray;
    try
    {
      this.a = paramJSONObject;
      this.b = paramJSONObject.getInt("id");
      this.c = paramJSONObject.getJSONArray("collections").getJSONObject(0).getInt("id");
      localJSONArray = paramJSONObject.getJSONArray("questions");
      if (localJSONArray.length() == 0) {
        throw new uo("Survey has no questions.");
      }
    }
    catch (JSONException localJSONException)
    {
      throw new uo("Survey JSON was unexpected or bad", localJSONException);
    }
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    while (i < localJSONArray.length())
    {
      localArrayList.add(new vm(this, localJSONArray.getJSONObject(i), null));
      i++;
    }
    this.d = Collections.unmodifiableList(localArrayList);
  }
  
  String a()
  {
    return this.a.toString();
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public List<vm> d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.Survey
 * JD-Core Version:    0.7.0.1
 */