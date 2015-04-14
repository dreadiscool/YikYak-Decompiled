package com.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

class ParseOperationSet
  extends HashMap<String, ParseFieldOperation>
{
  private static final String REST_KEY_IS_SAVE_EVENTUALLY = "__isSaveEventually";
  private static final String REST_KEY_UUID = "__uuid";
  private static final long serialVersionUID = 1L;
  private boolean isSaveEventually = false;
  private String uuid;
  
  public ParseOperationSet()
  {
    this.uuid = UUID.randomUUID().toString();
  }
  
  private ParseOperationSet(String paramString)
  {
    this.uuid = paramString;
  }
  
  public static ParseOperationSet fromRest(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    String str1 = (String)paramJSONObject.remove("__uuid");
    ParseOperationSet localParseOperationSet;
    label49:
    String str2;
    Object localObject1;
    if (str1 == null)
    {
      localParseOperationSet = new ParseOperationSet();
      boolean bool = paramJSONObject.optBoolean("__isSaveEventually");
      paramJSONObject.remove("__isSaveEventually");
      localParseOperationSet.setIsSaveEventually(bool);
      Iterator localIterator = paramJSONObject.keys();
      if (!localIterator.hasNext()) {
        return localParseOperationSet;
      }
      str2 = (String)localIterator.next();
      localObject1 = paramParseDecoder.decode(paramJSONObject.get(str2));
      if (str2.equals("ACL")) {
        localObject1 = ParseACL.createACLFromJSONObject(paramJSONObject.getJSONObject(str2), paramParseDecoder);
      }
      if (!(localObject1 instanceof ParseFieldOperation)) {
        break label144;
      }
    }
    label144:
    for (Object localObject2 = (ParseFieldOperation)localObject1;; localObject2 = new ParseSetOperation(localObject1))
    {
      localParseOperationSet.put(str2, localObject2);
      break label49;
      localParseOperationSet = new ParseOperationSet(str1);
      break;
    }
    return localParseOperationSet;
  }
  
  public String getUUID()
  {
    return this.uuid;
  }
  
  public boolean isSaveEventually()
  {
    return this.isSaveEventually;
  }
  
  public void mergeFrom(ParseOperationSet paramParseOperationSet)
  {
    Iterator localIterator = paramParseOperationSet.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ParseFieldOperation localParseFieldOperation1 = (ParseFieldOperation)paramParseOperationSet.get(str);
      ParseFieldOperation localParseFieldOperation2 = (ParseFieldOperation)get(str);
      if (localParseFieldOperation2 != null) {
        localParseFieldOperation1 = localParseFieldOperation2.mergeWithPrevious(localParseFieldOperation1);
      }
      put(str, localParseFieldOperation1);
    }
  }
  
  public void setIsSaveEventually(boolean paramBoolean)
  {
    this.isSaveEventually = paramBoolean;
  }
  
  public JSONObject toRest(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy, ArrayList<String> paramArrayList)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, ((ParseFieldOperation)get(str)).encode(paramParseObjectEncodingStrategy));
    }
    localJSONObject.put("__uuid", this.uuid);
    if (this.isSaveEventually) {
      localJSONObject.put("__isSaveEventually", true);
    }
    if (paramArrayList != null) {
      paramArrayList.add(this.uuid);
    }
    return localJSONObject;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseOperationSet
 * JD-Core Version:    0.7.0.1
 */