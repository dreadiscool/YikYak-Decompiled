import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.mixpanel.android.mpmetrics.Survey;
import org.json.JSONException;
import org.json.JSONObject;

public final class vl
  implements Parcelable.Creator<Survey>
{
  public Survey a(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    try
    {
      Survey localSurvey = new Survey(new JSONObject(str));
      return localSurvey;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException("Corrupted JSON object written to survey parcel.", localJSONException);
    }
    catch (uo localuo)
    {
      throw new RuntimeException("Unexpected or incomplete object written to survey parcel.", localuo);
    }
  }
  
  public Survey[] a(int paramInt)
  {
    return new Survey[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vl
 * JD-Core Version:    0.7.0.1
 */