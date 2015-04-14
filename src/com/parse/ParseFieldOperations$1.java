package com.parse;

import org.json.JSONArray;
import org.json.JSONObject;

final class ParseFieldOperations$1
  implements ParseFieldOperations.ParseFieldOperationFactory
{
  public ParseFieldOperation decode(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    ParseFieldOperation localParseFieldOperation = null;
    JSONArray localJSONArray = paramJSONObject.getJSONArray("ops");
    for (int i = 0; i < localJSONArray.length(); i++) {
      localParseFieldOperation = ParseFieldOperations.decode(localJSONArray.getJSONObject(i), paramParseDecoder).mergeWithPrevious(localParseFieldOperation);
    }
    return localParseFieldOperation;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFieldOperations.1
 * JD-Core Version:    0.7.0.1
 */