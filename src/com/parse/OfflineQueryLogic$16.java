package com.parse;

import java.util.Comparator;
import java.util.Date;
import org.json.JSONObject;

class OfflineQueryLogic$16
  implements Comparator<T>
{
  OfflineQueryLogic$16(OfflineQueryLogic paramOfflineQueryLogic, String paramString, ParseGeoPoint paramParseGeoPoint, String[] paramArrayOfString) {}
  
  public int compare(T paramT1, T paramT2)
  {
    int j;
    if (this.val$nearSphereKey != null) {
      for (;;)
      {
        try
        {
          ParseGeoPoint localParseGeoPoint1 = (ParseGeoPoint)OfflineQueryLogic.access$200(this.this$0, paramT1, this.val$nearSphereKey);
          ParseGeoPoint localParseGeoPoint2 = (ParseGeoPoint)OfflineQueryLogic.access$200(this.this$0, paramT2, this.val$nearSphereKey);
          double d1 = localParseGeoPoint1.distanceInRadiansTo(this.val$nearSphereValue);
          double d2 = localParseGeoPoint2.distanceInRadiansTo(this.val$nearSphereValue);
          if (d1 == d2) {
            break;
          }
          if (d1 - d2 > 0.0D)
          {
            j = 1;
            return j;
          }
        }
        catch (ParseException localParseException2)
        {
          throw new RuntimeException(localParseException2);
        }
        j = -1;
      }
    }
    int i = 0;
    label108:
    String str1;
    String str3;
    int k;
    if (i < this.val$keys.length)
    {
      str1 = this.val$keys[i];
      if (!str1.startsWith("-")) {
        break label463;
      }
      str3 = str1.substring(1);
      k = 1;
    }
    for (String str2 = str3;; str2 = str1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        try
        {
          localObject1 = OfflineQueryLogic.access$200(this.this$0, paramT1, str2);
          localObject2 = OfflineQueryLogic.access$200(this.this$0, paramT2, str2);
          if ((localObject1 == JSONObject.NULL) || (localObject1 == null))
          {
            m = 1;
            if ((localObject2 != JSONObject.NULL) && (localObject2 != null)) {
              break label255;
            }
            n = 1;
            if ((m != 0) || (n == 0)) {
              break label261;
            }
            j = 1;
            if (j == 0) {
              break label451;
            }
            if (k == 0) {
              break;
            }
            j = -j;
          }
        }
        catch (ParseException localParseException1)
        {
          throw new RuntimeException(localParseException1);
        }
        int m = 0;
        continue;
        label255:
        int n = 0;
        continue;
        label261:
        if ((m != 0) && (n == 0))
        {
          j = -1;
        }
        else if ((m != 0) && (n != 0))
        {
          j = 0;
        }
        else if ((localObject1 instanceof Date))
        {
          j = ((Date)localObject1).compareTo((Date)localObject2);
        }
        else if ((localObject1 instanceof String))
        {
          j = ((String)localObject1).compareTo((String)localObject2);
        }
        else if ((localObject1 instanceof Integer))
        {
          j = ((Integer)localObject1).compareTo((Integer)localObject2);
        }
        else if ((localObject1 instanceof Float))
        {
          j = ((Float)localObject1).compareTo((Float)localObject2);
        }
        else
        {
          if (!(localObject1 instanceof Double)) {
            break label424;
          }
          j = ((Double)localObject1).compareTo((Double)localObject2);
        }
      }
      label424:
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = str2;
      throw new IllegalArgumentException(String.format("Unable to sort by key %s.", arrayOfObject));
      label451:
      i++;
      break label108;
      j = 0;
      break;
      label463:
      k = 0;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic.16
 * JD-Core Version:    0.7.0.1
 */