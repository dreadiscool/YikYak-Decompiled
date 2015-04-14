package com.parse;

import org.json.JSONObject;

final class ParseFieldOperations$4
  implements ParseFieldOperations.ParseFieldOperationFactory
{
  public ParseFieldOperation decode(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    return new ParseAddOperation(paramJSONObject.opt("objects"));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFieldOperations.4
 * JD-Core Version:    0.7.0.1
 */