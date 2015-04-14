package com.parse;

import org.json.JSONObject;

final class ParseFieldOperations$3
  implements ParseFieldOperations.ParseFieldOperationFactory
{
  public ParseFieldOperation decode(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    return new ParseIncrementOperation((Number)paramJSONObject.opt("amount"));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFieldOperations.3
 * JD-Core Version:    0.7.0.1
 */