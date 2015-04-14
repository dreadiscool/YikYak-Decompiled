package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseRemoveOperation
  implements ParseFieldOperation
{
  protected HashSet<Object> objects = new HashSet();
  
  public ParseRemoveOperation(Object paramObject)
  {
    this.objects.add(paramObject);
  }
  
  public ParseRemoveOperation(Collection<?> paramCollection)
  {
    this.objects.addAll(paramCollection);
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    Object localObject1;
    if (paramObject == null) {
      localObject1 = new ArrayList();
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
        ArrayList localArrayList1 = new ArrayList((List)paramObject);
        localArrayList1.removeAll(this.objects);
        ArrayList localArrayList2 = new ArrayList(this.objects);
        localArrayList2.removeAll(localArrayList1);
        HashSet localHashSet = new HashSet();
        Iterator localIterator1 = localArrayList2.iterator();
        while (localIterator1.hasNext())
        {
          Object localObject3 = localIterator1.next();
          if ((localObject3 instanceof ParseObject)) {
            localHashSet.add(((ParseObject)localObject3).getObjectId());
          }
        }
        Iterator localIterator2 = localArrayList1.iterator();
        while (localIterator2.hasNext())
        {
          Object localObject2 = localIterator2.next();
          if (((localObject2 instanceof ParseObject)) && (localHashSet.contains(((ParseObject)localObject2).getObjectId()))) {
            localIterator2.remove();
          }
        }
        localObject1 = localArrayList1;
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
  
  public JSONObject encode(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__op", "Remove");
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
        if (!(paramParseFieldOperation instanceof ParseRemoveOperation)) {
          break;
        }
        HashSet localHashSet = new HashSet(((ParseRemoveOperation)paramParseFieldOperation).objects);
        localHashSet.addAll(this.objects);
        this = new ParseRemoveOperation(localHashSet);
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRemoveOperation
 * JD-Core Version:    0.7.0.1
 */