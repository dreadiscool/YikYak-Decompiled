import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.AnswerMap;
import java.util.Iterator;
import java.util.Set;

public final class vu
  implements Parcelable.Creator<UpdateDisplayState.AnswerMap>
{
  public UpdateDisplayState.AnswerMap a(Parcel paramParcel)
  {
    Bundle localBundle = new Bundle(UpdateDisplayState.AnswerMap.class.getClassLoader());
    UpdateDisplayState.AnswerMap localAnswerMap = new UpdateDisplayState.AnswerMap();
    localBundle.readFromParcel(paramParcel);
    Iterator localIterator = localBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localAnswerMap.a(Integer.valueOf(str), localBundle.getString(str));
    }
    return localAnswerMap;
  }
  
  public UpdateDisplayState.AnswerMap[] a(int paramInt)
  {
    return new UpdateDisplayState.AnswerMap[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vu
 * JD-Core Version:    0.7.0.1
 */