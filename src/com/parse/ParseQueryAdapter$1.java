package com.parse;

class ParseQueryAdapter$1
  implements ParseQueryAdapter.QueryFactory<T>
{
  ParseQueryAdapter$1(String paramString) {}
  
  public ParseQuery<T> create()
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(this.val$className);
    localParseQuery.orderByDescending("createdAt");
    return localParseQuery;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseQueryAdapter.1
 * JD-Core Version:    0.7.0.1
 */