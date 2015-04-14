package com.parse;

abstract interface ParseFieldOperation
{
  public abstract Object apply(Object paramObject, ParseObject paramParseObject, String paramString);
  
  public abstract Object encode(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy);
  
  public abstract ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFieldOperation
 * JD-Core Version:    0.7.0.1
 */