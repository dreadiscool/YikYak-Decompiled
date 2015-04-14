package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import vu;

public class UpdateDisplayState$AnswerMap
  implements Parcelable
{
  public static final Parcelable.Creator<AnswerMap> CREATOR = new vu();
  private final HashMap<Integer, String> a = new HashMap();
  
  public String a(Integer paramInteger)
  {
    return (String)this.a.get(paramInteger);
  }
  
  public void a(Integer paramInteger, String paramString)
  {
    this.a.put(paramInteger, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putString(Integer.toString(((Integer)localEntry.getKey()).intValue()), (String)localEntry.getValue());
    }
    paramParcel.writeBundle(localBundle);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.UpdateDisplayState.AnswerMap
 * JD-Core Version:    0.7.0.1
 */