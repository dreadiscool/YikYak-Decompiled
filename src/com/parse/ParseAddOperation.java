package com.parse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseAddOperation
  implements ParseFieldOperation
{
  protected final ArrayList<Object> objects = new ArrayList();
  
  public ParseAddOperation(Object paramObject)
  {
    this.objects.add(paramObject);
  }
  
  public ParseAddOperation(Collection<?> paramCollection)
  {
    this.objects.addAll(paramCollection);
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = this.objects;
    }
    for (;;)
    {
      return localObject;
      if ((paramObject instanceof JSONArray))
      {
        localObject = new JSONArray((ArrayList)apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)paramObject), paramParseObject, paramString));
      }
      else
      {
        if (!(paramObject instanceof List)) {
          break;
        }
        localObject = new ArrayList((List)paramObject);
        ((ArrayList)localObject).addAll(this.objects);
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
  
  public JSONObject encode(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("__op", "Add");
    localJSONObject.put("objects", Parse.encode(this.objects, paramParseObjectEncodingStrategy));
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
        if ((localObject instanceof JSONArray))
        {
          ArrayList localArrayList3 = ParseFieldOperations.jsonArrayAsArrayList((JSONArray)localObject);
          localArrayList3.addAll(this.objects);
          this = new ParseSetOperation(new JSONArray(localArrayList3));
        }
        else if ((localObject instanceof List))
        {
          ArrayList localArrayList2 = new ArrayList((List)localObject);
          localArrayList2.addAll(this.objects);
          this = new ParseSetOperation(localArrayList2);
        }
        else
        {
          throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
        }
      }
      else
      {
        if (!(paramParseFieldOperation instanceof ParseAddOperation)) {
          break;
        }
        ArrayList localArrayList1 = new ArrayList(((ParseAddOperation)paramParseFieldOperation).objects);
        localArrayList1.addAll(this.objects);
        this = new ParseAddOperation(localArrayList1);
      }
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseAddOperation
 * JD-Core Version:    0.7.0.1
 */