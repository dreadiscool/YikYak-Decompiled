package com.parse;

import java.util.ArrayList;
import m;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineStore$OfflineEncodingStrategy
  implements ParseObjectEncodingStrategy
{
  private ParseSQLiteDatabase db;
  private ArrayList<m<Void>> tasks = new ArrayList();
  private final Object tasksLock = new Object();
  
  public OfflineStore$OfflineEncodingStrategy(OfflineStore paramOfflineStore, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    this.db = paramParseSQLiteDatabase;
  }
  
  public JSONObject encodeRelatedObject(ParseObject paramParseObject)
  {
    try
    {
      JSONObject localJSONObject;
      if (paramParseObject.getObjectId() != null)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("__type", "Pointer");
        localJSONObject.put("objectId", paramParseObject.getObjectId());
        localJSONObject.put("className", paramParseObject.getClassName());
      }
      else
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("__type", "OfflineObject");
        synchronized (this.tasksLock)
        {
          this.tasks.add(OfflineStore.access$200(this.this$0, paramParseObject, this.db).c(new OfflineStore.OfflineEncodingStrategy.2(this, localJSONObject)));
        }
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public m<Void> whenFinished()
  {
    return m.a(this.tasks).b(new OfflineStore.OfflineEncodingStrategy.1(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineStore.OfflineEncodingStrategy
 * JD-Core Version:    0.7.0.1
 */