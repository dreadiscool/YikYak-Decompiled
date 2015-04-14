package com.parse;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ParseRelation<T extends ParseObject>
{
  private String key;
  private Set<ParseObject> knownObjects = new HashSet();
  private Object mutex = new Object();
  private ParseObject parent;
  private String targetClass;
  
  ParseRelation(ParseObject paramParseObject, String paramString)
  {
    this.parent = paramParseObject;
    this.key = paramString;
    this.targetClass = null;
  }
  
  ParseRelation(String paramString)
  {
    this.parent = null;
    this.key = null;
    this.targetClass = paramString;
  }
  
  ParseRelation(JSONObject paramJSONObject, ParseDecoder paramParseDecoder)
  {
    this.parent = null;
    this.targetClass = paramJSONObject.optString("className", null);
    this.key = null;
    JSONArray localJSONArray = paramJSONObject.optJSONArray("objects");
    if (localJSONArray != null) {
      for (int i = 0; i < localJSONArray.length(); i++) {
        this.knownObjects.add((ParseObject)paramParseDecoder.decode(localJSONArray.optJSONObject(i)));
      }
    }
  }
  
  public void add(T paramT)
  {
    synchronized (this.mutex)
    {
      ParseRelationOperation localParseRelationOperation = new ParseRelationOperation(Collections.singleton(paramT), null);
      this.targetClass = localParseRelationOperation.getTargetClass();
      this.parent.performOperation(this.key, localParseRelationOperation);
      this.knownObjects.add(paramT);
      return;
    }
  }
  
  void addKnownObject(ParseObject paramParseObject)
  {
    synchronized (this.mutex)
    {
      this.knownObjects.add(paramParseObject);
      return;
    }
  }
  
  JSONObject encodeToJSON(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    synchronized (this.mutex)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("__type", "Relation");
      localJSONObject.put("className", this.targetClass);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.knownObjects.iterator();
      while (localIterator.hasNext())
      {
        ParseObject localParseObject = (ParseObject)localIterator.next();
        try
        {
          localJSONArray.put(paramParseObjectEncodingStrategy.encodeRelatedObject(localParseObject));
        }
        catch (Exception localException) {}
      }
      localJSONObject.put("objects", localJSONArray);
      return localJSONObject;
    }
  }
  
  /* Error */
  void ensureParentAndKey(ParseObject paramParseObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/parse/ParseRelation:mutex	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 29	com/parse/ParseRelation:parent	Lcom/parse/ParseObject;
    //   11: ifnonnull +8 -> 19
    //   14: aload_0
    //   15: aload_1
    //   16: putfield 29	com/parse/ParseRelation:parent	Lcom/parse/ParseObject;
    //   19: aload_0
    //   20: getfield 31	com/parse/ParseRelation:key	Ljava/lang/String;
    //   23: ifnonnull +8 -> 31
    //   26: aload_0
    //   27: aload_2
    //   28: putfield 31	com/parse/ParseRelation:key	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 29	com/parse/ParseRelation:parent	Lcom/parse/ParseObject;
    //   35: aload_1
    //   36: if_acmpeq +20 -> 56
    //   39: new 134	java/lang/IllegalStateException
    //   42: dup
    //   43: ldc 136
    //   45: invokespecial 138	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: astore 4
    //   51: aload_3
    //   52: monitorexit
    //   53: aload 4
    //   55: athrow
    //   56: aload_0
    //   57: getfield 31	com/parse/ParseRelation:key	Ljava/lang/String;
    //   60: aload_2
    //   61: invokevirtual 143	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: ifne +13 -> 77
    //   67: new 134	java/lang/IllegalStateException
    //   70: dup
    //   71: ldc 145
    //   73: invokespecial 138	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: aload_3
    //   78: monitorexit
    //   79: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	ParseRelation
    //   0	80	1	paramParseObject	ParseObject
    //   0	80	2	paramString	String
    //   4	74	3	localObject1	Object
    //   49	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	53	49	finally
    //   56	79	49	finally
  }
  
  public ParseQuery<T> getQuery()
  {
    synchronized (this.mutex)
    {
      if (this.targetClass == null)
      {
        localParseQuery = ParseQuery.getQuery(this.parent.getClassName());
        localParseQuery.redirectClassNameForKey(this.key);
        localParseQuery.whereRelatedTo(this.parent, this.key);
        return localParseQuery;
      }
      ParseQuery localParseQuery = ParseQuery.getQuery(this.targetClass);
    }
  }
  
  String getTargetClass()
  {
    synchronized (this.mutex)
    {
      String str = this.targetClass;
      return str;
    }
  }
  
  boolean hasKnownObject(ParseObject paramParseObject)
  {
    synchronized (this.mutex)
    {
      boolean bool = this.knownObjects.contains(paramParseObject);
      return bool;
    }
  }
  
  public void remove(T paramT)
  {
    synchronized (this.mutex)
    {
      ParseRelationOperation localParseRelationOperation = new ParseRelationOperation(null, Collections.singleton(paramT));
      this.targetClass = localParseRelationOperation.getTargetClass();
      this.parent.performOperation(this.key, localParseRelationOperation);
      this.knownObjects.remove(paramT);
      return;
    }
  }
  
  void removeKnownObject(ParseObject paramParseObject)
  {
    synchronized (this.mutex)
    {
      this.knownObjects.remove(paramParseObject);
      return;
    }
  }
  
  void setTargetClass(String paramString)
  {
    synchronized (this.mutex)
    {
      this.targetClass = paramString;
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRelation
 * JD-Core Version:    0.7.0.1
 */