package com.parse;

import java.util.List;
import m;

@ParseClassName("_Pin")
class ParsePin
  extends ParseObject
{
  private static final String KEY_NAME = "_name";
  private static final String KEY_OBJECTS = "_objects";
  
  static m<ParsePin> getParsePin(String paramString)
  {
    ParseQuery localParseQuery = ParseQuery.getQuery(ParsePin.class).whereEqualTo("_name", paramString);
    return OfflineStore.getCurrent().findAsync(localParseQuery, null, null, false, false).c(new ParsePin.1(paramString));
  }
  
  static <T extends ParseObject> m<Void> pinAllObjectsAsync(String paramString, List<T> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (m localm = m.a(null);; localm = getParsePin(paramString).d(new ParsePin.2(paramList))) {
      return localm;
    }
  }
  
  static m<Void> unpinAllObjectsAsync(String paramString)
  {
    return getParsePin(paramString).b(new ParsePin.4());
  }
  
  static <T extends ParseObject> m<Void> unpinAllObjectsAsync(String paramString, List<T> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (m localm = m.a(null);; localm = getParsePin(paramString).d(new ParsePin.3(paramList))) {
      return localm;
    }
  }
  
  public String getName()
  {
    return getString("_name");
  }
  
  public List<ParseObject> getObjects()
  {
    return getList("_objects");
  }
  
  boolean needsDefaultACL()
  {
    return false;
  }
  
  public void setName(String paramString)
  {
    put("_name", paramString);
  }
  
  public void setObjects(List<ParseObject> paramList)
  {
    put("_objects", paramList);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePin
 * JD-Core Version:    0.7.0.1
 */