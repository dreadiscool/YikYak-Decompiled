package com.parse;

class ParseQueryAdapter$2
  implements ParseQueryAdapter.QueryFactory<T>
{
  ParseQueryAdapter$2(String paramString) {}
  
  public ParseQuery<T> create()
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(this.val$className);
    localParseQuery.orderByDescending("createdAt");
    return localParseQuery;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQueryAdapter.2
 * JD-Core Version:    0.7.0.1
 */