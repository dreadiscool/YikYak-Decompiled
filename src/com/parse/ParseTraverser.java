package com.parse;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class ParseTraverser
{
  private boolean traverseParseObjects = false;
  private boolean yieldRoot = false;
  
  private void traverseInternal(Object paramObject, boolean paramBoolean, IdentityHashMap<Object, Object> paramIdentityHashMap)
  {
    if ((paramObject == null) || (paramIdentityHashMap.containsKey(paramObject))) {}
    for (;;)
    {
      return;
      if ((!paramBoolean) || (visit(paramObject)))
      {
        paramIdentityHashMap.put(paramObject, paramObject);
        if ((paramObject instanceof JSONObject))
        {
          JSONObject localJSONObject = (JSONObject)paramObject;
          Iterator localIterator4 = localJSONObject.keys();
          while (localIterator4.hasNext())
          {
            String str = (String)localIterator4.next();
            try
            {
              traverseInternal(localJSONObject.get(str), true, paramIdentityHashMap);
            }
            catch (JSONException localJSONException2)
            {
              throw new RuntimeException(localJSONException2);
            }
          }
        }
        if ((paramObject instanceof JSONArray))
        {
          JSONArray localJSONArray = (JSONArray)paramObject;
          int i = 0;
          while (i < localJSONArray.length()) {
            try
            {
              traverseInternal(localJSONArray.get(i), true, paramIdentityHashMap);
              i++;
            }
            catch (JSONException localJSONException1)
            {
              throw new RuntimeException(localJSONException1);
            }
          }
        }
        if ((paramObject instanceof Map))
        {
          Iterator localIterator3 = ((Map)paramObject).values().iterator();
          while (localIterator3.hasNext()) {
            traverseInternal(localIterator3.next(), true, paramIdentityHashMap);
          }
        }
        else if ((paramObject instanceof List))
        {
          Iterator localIterator2 = ((List)paramObject).iterator();
          while (localIterator2.hasNext()) {
            traverseInternal(localIterator2.next(), true, paramIdentityHashMap);
          }
        }
        else if ((paramObject instanceof ParseObject))
        {
          if (this.traverseParseObjects)
          {
            ParseObject localParseObject = (ParseObject)paramObject;
            Iterator localIterator1 = localParseObject.keySet().iterator();
            while (localIterator1.hasNext()) {
              traverseInternal(localParseObject.get((String)localIterator1.next()), true, paramIdentityHashMap);
            }
          }
        }
        else if (((paramObject instanceof ParseACL)) && (((ParseACL)paramObject).hasUnresolvedUser()))
        {
          traverseInternal(ParseUser.getCurrentUser(), true, paramIdentityHashMap);
        }
      }
    }
  }
  
  public ParseTraverser setTraverseParseObjects(boolean paramBoolean)
  {
    this.traverseParseObjects = paramBoolean;
    return this;
  }
  
  public ParseTraverser setYieldRoot(boolean paramBoolean)
  {
    this.yieldRoot = paramBoolean;
    return this;
  }
  
  public void traverse(Object paramObject)
  {
    IdentityHashMap localIdentityHashMap = new IdentityHashMap();
    traverseInternal(paramObject, this.yieldRoot, localIdentityHashMap);
  }
  
  protected abstract boolean visit(Object paramObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseTraverser
 * JD-Core Version:    0.7.0.1
 */