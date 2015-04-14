package com.parse;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class ParseRelationOperation<T extends ParseObject>
  implements ParseFieldOperation
{
  private Set<ParseObject> relationsToAdd;
  private Set<ParseObject> relationsToRemove;
  private String targetClass;
  
  private ParseRelationOperation(String paramString, Set<ParseObject> paramSet1, Set<ParseObject> paramSet2)
  {
    this.targetClass = paramString;
    this.relationsToAdd = new HashSet(paramSet1);
    this.relationsToRemove = new HashSet(paramSet2);
  }
  
  ParseRelationOperation(Set<T> paramSet1, Set<T> paramSet2)
  {
    this.targetClass = null;
    this.relationsToAdd = new HashSet();
    this.relationsToRemove = new HashSet();
    if (paramSet1 != null)
    {
      Iterator localIterator2 = paramSet1.iterator();
      while (localIterator2.hasNext())
      {
        ParseObject localParseObject2 = (ParseObject)localIterator2.next();
        addParseObjectToSet(localParseObject2, this.relationsToAdd);
        if (this.targetClass == null) {
          this.targetClass = localParseObject2.getClassName();
        } else if (!this.targetClass.equals(localParseObject2.getClassName())) {
          throw new IllegalArgumentException("All objects in a relation must be of the same class.");
        }
      }
    }
    if (paramSet2 != null)
    {
      Iterator localIterator1 = paramSet2.iterator();
      while (localIterator1.hasNext())
      {
        ParseObject localParseObject1 = (ParseObject)localIterator1.next();
        addParseObjectToSet(localParseObject1, this.relationsToRemove);
        if (this.targetClass == null) {
          this.targetClass = localParseObject1.getClassName();
        } else if (!this.targetClass.equals(localParseObject1.getClassName())) {
          throw new IllegalArgumentException("All objects in a relation must be of the same class.");
        }
      }
    }
    if (this.targetClass == null) {
      throw new IllegalArgumentException("Cannot create a ParseRelationOperation with no objects.");
    }
  }
  
  private void addAllParseObjectsToSet(Collection<ParseObject> paramCollection, Set<ParseObject> paramSet)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      addParseObjectToSet((ParseObject)localIterator.next(), paramSet);
    }
  }
  
  private void addParseObjectToSet(ParseObject paramParseObject, Set<ParseObject> paramSet)
  {
    if ((OfflineStore.getCurrent() != null) || (paramParseObject.getObjectId() == null)) {
      paramSet.add(paramParseObject);
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        ParseObject localParseObject = (ParseObject)localIterator.next();
        if (paramParseObject.getObjectId().equals(localParseObject.getObjectId())) {
          paramSet.remove(localParseObject);
        }
      }
      paramSet.add(paramParseObject);
    }
  }
  
  private void removeAllParseObjectsFromSet(Collection<ParseObject> paramCollection, Set<ParseObject> paramSet)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext()) {
      removeParseObjectFromSet((ParseObject)localIterator.next(), paramSet);
    }
  }
  
  private void removeParseObjectFromSet(ParseObject paramParseObject, Set<ParseObject> paramSet)
  {
    if ((OfflineStore.getCurrent() != null) || (paramParseObject.getObjectId() == null)) {
      paramSet.remove(paramParseObject);
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        ParseObject localParseObject = (ParseObject)localIterator.next();
        if (paramParseObject.getObjectId().equals(localParseObject.getObjectId())) {
          paramSet.remove(localParseObject);
        }
      }
    }
  }
  
  public Object apply(Object paramObject, ParseObject paramParseObject, String paramString)
  {
    ParseRelation localParseRelation;
    if (paramObject == null)
    {
      localParseRelation = new ParseRelation(paramParseObject, paramString);
      localParseRelation.setTargetClass(this.targetClass);
    }
    do
    {
      Iterator localIterator1 = this.relationsToAdd.iterator();
      while (localIterator1.hasNext()) {
        localParseRelation.addKnownObject((ParseObject)localIterator1.next());
      }
      if (!(paramObject instanceof ParseRelation)) {
        break;
      }
      localParseRelation = (ParseRelation)paramObject;
    } while ((this.targetClass == null) || (this.targetClass.equals(localParseRelation.getTargetClass())));
    throw new IllegalArgumentException("Related object object must be of class " + localParseRelation.getTargetClass() + ", but " + this.targetClass + " was passed in.");
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
    Iterator localIterator2 = this.relationsToRemove.iterator();
    while (localIterator2.hasNext()) {
      localParseRelation.removeKnownObject((ParseObject)localIterator2.next());
    }
    return localParseRelation;
  }
  
  JSONArray convertSetToArray(Set<ParseObject> paramSet, ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(Parse.encode((ParseObject)localIterator.next(), paramParseObjectEncodingStrategy));
    }
    return localJSONArray;
  }
  
  public JSONObject encode(ParseObjectEncodingStrategy paramParseObjectEncodingStrategy)
  {
    Object localObject;
    if (this.relationsToAdd.size() > 0)
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("__op", "AddRelation");
      ((JSONObject)localObject).put("objects", convertSetToArray(this.relationsToAdd, paramParseObjectEncodingStrategy));
    }
    for (;;)
    {
      JSONObject localJSONObject1;
      if (this.relationsToRemove.size() > 0)
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("__op", "RemoveRelation");
        localJSONObject1.put("objects", convertSetToArray(this.relationsToRemove, paramParseObjectEncodingStrategy));
      }
      for (;;)
      {
        if ((localObject != null) && (localJSONObject1 != null))
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("__op", "Batch");
          JSONArray localJSONArray = new JSONArray();
          localJSONArray.put(localObject);
          localJSONArray.put(localJSONObject1);
          localJSONObject2.put("ops", localJSONArray);
          localObject = localJSONObject2;
        }
        for (;;)
        {
          return localObject;
          if (localObject == null)
          {
            if (localJSONObject1 == null) {
              break;
            }
            localObject = localJSONObject1;
          }
        }
        throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
        localJSONObject1 = null;
      }
      localObject = null;
    }
  }
  
  String getTargetClass()
  {
    return this.targetClass;
  }
  
  public ParseFieldOperation mergeWithPrevious(ParseFieldOperation paramParseFieldOperation)
  {
    if (paramParseFieldOperation == null) {}
    for (;;)
    {
      return this;
      if ((paramParseFieldOperation instanceof ParseDeleteOperation)) {
        throw new IllegalArgumentException("You can't modify a relation after deleting it.");
      }
      if (!(paramParseFieldOperation instanceof ParseRelationOperation)) {
        break;
      }
      ParseRelationOperation localParseRelationOperation = (ParseRelationOperation)paramParseFieldOperation;
      if ((localParseRelationOperation.targetClass != null) && (!localParseRelationOperation.targetClass.equals(this.targetClass))) {
        throw new IllegalArgumentException("Related object object must be of class " + localParseRelationOperation.targetClass + ", but " + this.targetClass + " was passed in.");
      }
      HashSet localHashSet1 = new HashSet(localParseRelationOperation.relationsToAdd);
      HashSet localHashSet2 = new HashSet(localParseRelationOperation.relationsToRemove);
      if (this.relationsToAdd != null)
      {
        addAllParseObjectsToSet(this.relationsToAdd, localHashSet1);
        removeAllParseObjectsFromSet(this.relationsToAdd, localHashSet2);
      }
      if (this.relationsToRemove != null)
      {
        removeAllParseObjectsFromSet(this.relationsToRemove, localHashSet1);
        addAllParseObjectsToSet(this.relationsToRemove, localHashSet2);
      }
      this = new ParseRelationOperation(this.targetClass, localHashSet1, localHashSet2);
    }
    throw new IllegalArgumentException("Operation is invalid after previous operation.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRelationOperation
 * JD-Core Version:    0.7.0.1
 */