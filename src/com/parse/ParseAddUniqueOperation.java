package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseAddUniqueOperation
  implements ParseFieldOperation
{
  protected LinkedHashSet<Object> objects = new LinkedHashSet();
  
  public ParseAddUniqueOperation(Object paramObject)
  {
    if ((paramObject instanceof Collection)) {
      this.objects.addAll((Collection)paramObject);
    }
    for (;;)
    {
      return;
      this.objects.add(paramObject);
    }
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    Object localObject1;
    if (paramObject == null) {
      localObject1 = new ArrayList(this.objects);
    }
    for (;;)
    {
      return localObject1;
      if ((paramObject instanceof JSONArray))
      {
        localObject1 = new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)paramObject), paramParseObject, paramString));
      }
      else
      {
        if (!(paramObject instanceof List)) {
          break;
        }
        ArrayList localArrayList = new ArrayList((List)paramObject);
        HashMap localHashMap = new HashMap();
        for (int i = 0; i < localArrayList.size(); i++) {
          if ((localArrayList.get(i) instanceof ParseObject)) {
            localHashMap.put(((ParseObject)localArrayList.get(i)).getObjectId(), Integer.valueOf(i));
          }
        }
        Iterator localIterator = this.objects.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          if ((localObject2 instanceof ParseObject))
          {
            String str = ((ParseObject)localObject2).getObjectId();
            if ((str != null) && (localHashMap.containsKey(str))) {
              localArrayList.set(((Integer)localHashMap.get(str)).intValue(), localObject2);
            } else if (!localArrayList.contains(localObject2)) {
              localArrayList.add(localObject2);
            }
          }
          else if (!localArrayList.contains(localObject2))
          {
            localArrayList.add(localObject2);
          }
        }
        localObject1 = localArrayList;
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
  
  public JSONObject encode(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__op", "AddUnique");
    localJSONObject.put("objects", Parse.encode(new ArrayList(this.objects), paramParseObjectEncodingStrategy));
    return localJSONObject;
  }
  
  public ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation)
  {
    if (paramParseFieldOperation == null) {}
    for (;;)
    {
      return this;
      if ((paramParseFieldOperation instanceof ParseDeleteOperation))
      {
        this = new ParseSetOperation(this.objects);
      }
      else if ((paramParseFieldOperation instanceof ParseSetOperation))
      {
        Object localObject = ((ParseSetOperation)paramParseFieldOperation).getValue();
        if (((localObject instanceof JSONArray)) || ((localObject instanceof List))) {
          this = new ParseSetOperation(apply(localObject, null, null));
        } else {
          throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
        }
      }
      else
      {
        if (!(paramParseFieldOperation instanceof ParseAddUniqueOperation)) {
          break;
        }
        this = new ParseAddUniqueOperation((List)apply(new ArrayList(((ParseAddUniqueOperation)paramParseFieldOperation).objects), null, null));
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseAddUniqueOperation
 * JD-Core Version:    0.7.0.1
 */