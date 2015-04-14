package com.parse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineQueryLogic
{
  private final OfflineStore store;
  
  OfflineQueryLogic(OfflineStore paramOfflineStore)
  {
    this.store = paramOfflineStore;
  }
  
  private static boolean compare(Object paramObject1, Object paramObject2, OfflineQueryLogic.Decider paramDecider)
  {
    boolean bool;
    if ((paramObject2 instanceof List)) {
      bool = compareList(paramObject1, (List)paramObject2, paramDecider);
    }
    for (;;)
    {
      return bool;
      if ((paramObject2 instanceof JSONArray)) {
        bool = compareArray(paramObject1, (JSONArray)paramObject2, paramDecider);
      } else {
        bool = paramDecider.decide(paramObject1, paramObject2);
      }
    }
  }
  
  private static boolean compareArray(Object paramObject, JSONArray paramJSONArray, OfflineQueryLogic.Decider paramDecider)
  {
    boolean bool1 = false;
    for (int i = 0;; i++)
    {
      if (i < paramJSONArray.length()) {}
      try
      {
        boolean bool2 = paramDecider.decide(paramObject, paramJSONArray.get(i));
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException);
      }
    }
  }
  
  private static boolean compareList(Object paramObject, List<?> paramList, OfflineQueryLogic.Decider paramDecider)
  {
    Iterator localIterator = paramList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!paramDecider.decide(paramObject, localIterator.next()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int compareTo(Object paramObject1, Object paramObject2)
  {
    int i;
    if ((paramObject1 instanceof Date)) {
      i = ((Date)paramObject1).compareTo((Date)paramObject2);
    }
    for (;;)
    {
      return i;
      if ((paramObject1 instanceof String))
      {
        i = ((String)paramObject1).compareTo((String)paramObject2);
      }
      else
      {
        if (!(paramObject1 instanceof Number)) {
          break;
        }
        i = Parse.compareNumbers((Number)paramObject1, (Number)paramObject2);
      }
    }
    throw new IllegalArgumentException("Cannot compare against " + paramObject1);
  }
  
  private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createDontSelectMatcher(Object paramObject, String paramString)
  {
    return new OfflineQueryLogic.9(this, createSelectMatcher(paramObject, paramString));
  }
  
  private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createInQueryMatcher(Object paramObject, String paramString)
  {
    return new OfflineQueryLogic.6(this, (ParseQuery)paramObject, paramString);
  }
  
  private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createMatcher(ParseQuery.QueryConstraints paramQueryConstraints)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramQueryConstraints.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Object localObject = paramQueryConstraints.get(str1);
      if (str1.equals("$or"))
      {
        localArrayList.add(createOrMatcher((ArrayList)localObject));
      }
      else if ((localObject instanceof ParseQuery.KeyConstraints))
      {
        ParseQuery.KeyConstraints localKeyConstraints = (ParseQuery.KeyConstraints)localObject;
        Iterator localIterator2 = localKeyConstraints.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          localArrayList.add(createMatcher(str2, localKeyConstraints.get(str2), str1, localKeyConstraints));
        }
      }
      else if ((localObject instanceof ParseQuery.RelationConstraint))
      {
        localArrayList.add(new OfflineQueryLogic.12(this, (ParseQuery.RelationConstraint)localObject));
      }
      else
      {
        localArrayList.add(new OfflineQueryLogic.13(this, str1, localObject));
      }
    }
    return new OfflineQueryLogic.14(this, localArrayList);
  }
  
  private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createMatcher(String paramString1, Object paramObject, String paramString2, ParseQuery.KeyConstraints paramKeyConstraints)
  {
    Object localObject;
    if (paramString1.equals("$inQuery")) {
      localObject = createInQueryMatcher(paramObject, paramString2);
    }
    for (;;)
    {
      return localObject;
      if (paramString1.equals("$notInQuery")) {
        localObject = createNotInQueryMatcher(paramObject, paramString2);
      } else if (paramString1.equals("$select")) {
        localObject = createSelectMatcher(paramObject, paramString2);
      } else if (paramString1.equals("$dontSelect")) {
        localObject = createDontSelectMatcher(paramObject, paramString2);
      } else {
        localObject = new OfflineQueryLogic.10(this, paramString2, paramString1, paramObject, paramKeyConstraints);
      }
    }
  }
  
  private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createNotInQueryMatcher(Object paramObject, String paramString)
  {
    return new OfflineQueryLogic.7(this, createInQueryMatcher(paramObject, paramString));
  }
  
  private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createOrMatcher(ArrayList<ParseQuery.QueryConstraints> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(createMatcher((ParseQuery.QueryConstraints)localIterator.next()));
    }
    return new OfflineQueryLogic.11(this, localArrayList);
  }
  
  private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createSelectMatcher(Object paramObject, String paramString)
  {
    JSONObject localJSONObject = (JSONObject)paramObject;
    return new OfflineQueryLogic.8(this, (ParseQuery)localJSONObject.opt("query"), paramString, localJSONObject.optString("key", null));
  }
  
  private m<Void> fetchIncludeAsync(Object paramObject, String paramString, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    int i = 0;
    Object localObject;
    if (paramObject == null) {
      localObject = m.a(null);
    }
    for (;;)
    {
      return localObject;
      if ((paramObject instanceof JSONArray))
      {
        JSONArray localJSONArray = (JSONArray)paramObject;
        m localm2;
        for (localObject = m.a(null); i < localJSONArray.length(); localObject = localm2)
        {
          localm2 = ((m)localObject).d(new OfflineQueryLogic.17(this, localJSONArray, i, paramString, paramParseSQLiteDatabase));
          i++;
        }
      }
      else if ((paramObject instanceof List))
      {
        List localList = (List)paramObject;
        m localm1 = m.a(null);
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          localm1 = localm1.d(new OfflineQueryLogic.18(this, localIterator.next(), paramString, paramParseSQLiteDatabase));
        }
        localObject = localm1;
      }
      else
      {
        if (paramString != null) {
          break;
        }
        if (!(paramObject instanceof ParseObject))
        {
          localObject = m.a(new ParseException(121, "include is invalid for non-ParseObjects"));
        }
        else
        {
          ParseObject localParseObject = (ParseObject)paramObject;
          localObject = this.store.fetchLocallyAsync(localParseObject, paramParseSQLiteDatabase).j();
        }
      }
    }
    String[] arrayOfString = paramString.split("\\.", 2);
    String str1 = arrayOfString[0];
    if (arrayOfString.length > 1) {}
    for (String str2 = arrayOfString[1];; str2 = null)
    {
      localObject = m.a(null).b(new OfflineQueryLogic.20(this, paramObject, paramParseSQLiteDatabase, str1)).d(new OfflineQueryLogic.19(this, str2, paramParseSQLiteDatabase));
      break;
    }
  }
  
  private Object getValue(Object paramObject, String paramString)
  {
    return getValue(paramObject, paramString, 0);
  }
  
  private Object getValue(Object paramObject, String paramString, int paramInt)
  {
    Object localObject1 = null;
    String[] arrayOfString;
    Object localObject2;
    if (paramString.contains("."))
    {
      arrayOfString = paramString.split("\\.", 2);
      localObject2 = getValue(paramObject, arrayOfString[0], paramInt + 1);
      if ((localObject2 != null) && (localObject2 != JSONObject.NULL) && (!(localObject2 instanceof Map)) && (!(localObject2 instanceof JSONObject)) && (paramInt <= 0)) {}
    }
    try
    {
      Object localObject3 = Parse.encode(localObject2, PointerEncodingStrategy.get());
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      label84:
      Object[] arrayOfObject1;
      break label84;
    }
    if ((localObject1 instanceof JSONObject)) {
      localObject1 = getValue(localObject1, arrayOfString[1], paramInt + 1);
    }
    do
    {
      for (;;)
      {
        return localObject1;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = paramString;
        throw new ParseException(102, String.format("Key %s is invalid.", arrayOfObject3));
        localObject1 = getValue(localObject2, arrayOfString[1], paramInt + 1);
        continue;
        if ((paramObject instanceof ParseObject))
        {
          ParseObject localParseObject = (ParseObject)paramObject;
          if (!localParseObject.isDataAvailable())
          {
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = paramString;
            throw new ParseException(121, String.format("Bad key: %s", arrayOfObject2));
          }
          if (paramString.equals("objectId")) {
            localObject1 = localParseObject.getObjectId();
          } else if ((paramString.equals("createdAt")) || (paramString.equals("_created_at"))) {
            localObject1 = localParseObject.getCreatedAt();
          } else if ((paramString.equals("updatedAt")) || (paramString.equals("_updated_at"))) {
            localObject1 = localParseObject.getUpdatedAt();
          } else {
            localObject1 = localParseObject.get(paramString);
          }
        }
        else if ((paramObject instanceof JSONObject))
        {
          localObject1 = ((JSONObject)paramObject).opt(paramString);
        }
        else
        {
          if (!(paramObject instanceof Map)) {
            break;
          }
          localObject1 = ((Map)paramObject).get(paramString);
        }
      }
    } while ((paramObject == JSONObject.NULL) || (paramObject == null));
    arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = paramString;
    throw new ParseException(121, String.format("Bad key: %s", arrayOfObject1));
  }
  
  static <T extends ParseObject> boolean hasReadAccess(ParseUser paramParseUser, T paramT)
  {
    boolean bool = true;
    if (paramParseUser == paramT) {}
    for (;;)
    {
      return bool;
      ParseACL localParseACL = paramT.getACL();
      if ((localParseACL != null) && (!localParseACL.getPublicReadAccess()) && ((paramParseUser == null) || (!localParseACL.getReadAccess(paramParseUser)))) {
        bool = false;
      }
    }
  }
  
  static <T extends ParseObject> boolean hasWriteAccess(ParseUser paramParseUser, T paramT)
  {
    boolean bool = true;
    if (paramParseUser == paramT) {}
    for (;;)
    {
      return bool;
      ParseACL localParseACL = paramT.getACL();
      if ((localParseACL != null) && (!localParseACL.getPublicWriteAccess()) && ((paramParseUser == null) || (!localParseACL.getWriteAccess(paramParseUser)))) {
        bool = false;
      }
    }
  }
  
  private static boolean matchesAllConstraint(Object paramObject1, Object paramObject2)
  {
    boolean bool = false;
    if ((paramObject1 instanceof List))
    {
      Iterator localIterator = ((List)paramObject1).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (matchesInConstraint(paramObject2, localIterator.next()));
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      if (!(paramObject1 instanceof JSONArray)) {
        break;
      }
      for (int i = 0;; i++)
      {
        if (i >= ((JSONArray)paramObject1).length()) {
          break label92;
        }
        if (!matchesInConstraint(paramObject2, ((JSONArray)paramObject1).opt(i))) {
          break;
        }
      }
      label92:
      bool = true;
    }
    throw new IllegalArgumentException("Value type not supported for $all queries.");
  }
  
  private static boolean matchesEqualConstraint(Object paramObject1, Object paramObject2)
  {
    boolean bool = true;
    if ((paramObject1 == null) || (paramObject2 == null)) {
      if (paramObject1 != paramObject2) {}
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (((paramObject1 instanceof Number)) && ((paramObject2 instanceof Number)))
      {
        if (compareTo(paramObject1, paramObject2) != 0) {
          bool = false;
        }
      }
      else {
        bool = compare(paramObject1, paramObject2, new OfflineQueryLogic.1());
      }
    }
  }
  
  private static boolean matchesExistsConstraint(Object paramObject1, Object paramObject2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if ((paramObject1 != null) && (((Boolean)paramObject1).booleanValue())) {
      if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {}
    }
    for (;;)
    {
      return bool1;
      bool1 = false;
      continue;
      if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {
        bool2 = bool1;
      }
      bool1 = bool2;
    }
  }
  
  private static boolean matchesGreaterThanConstraint(Object paramObject1, Object paramObject2)
  {
    return compare(paramObject1, paramObject2, new OfflineQueryLogic.4());
  }
  
  private static boolean matchesGreaterThanOrEqualToConstraint(Object paramObject1, Object paramObject2)
  {
    return compare(paramObject1, paramObject2, new OfflineQueryLogic.5());
  }
  
  private static boolean matchesInConstraint(Object paramObject1, Object paramObject2)
  {
    boolean bool = false;
    if ((paramObject1 instanceof List)) {
      bool = ((List)paramObject1).contains(paramObject2);
    }
    label66:
    do
    {
      for (;;)
      {
        return bool;
        if (!(paramObject1 instanceof JSONArray)) {
          break;
        }
        for (int i = 0;; i++)
        {
          if (i >= ((JSONArray)paramObject1).length()) {
            break label66;
          }
          if (((JSONArray)paramObject1).opt(i).equals(paramObject2))
          {
            bool = true;
            break;
          }
        }
      }
    } while ((paramObject1 == JSONObject.NULL) || (paramObject1 == null));
    throw new IllegalArgumentException("Value type not supported for $in queries.");
  }
  
  private static boolean matchesLessThanConstraint(Object paramObject1, Object paramObject2)
  {
    return compare(paramObject1, paramObject2, new OfflineQueryLogic.2());
  }
  
  private static boolean matchesLessThanOrEqualToConstraint(Object paramObject1, Object paramObject2)
  {
    return compare(paramObject1, paramObject2, new OfflineQueryLogic.3());
  }
  
  private static boolean matchesNearSphereConstraint(Object paramObject1, Object paramObject2, Double paramDouble)
  {
    boolean bool = true;
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {}
    for (bool = false;; bool = false) {
      do
      {
        return bool;
      } while ((paramDouble == null) || (((ParseGeoPoint)paramObject1).distanceInRadiansTo((ParseGeoPoint)paramObject2) <= paramDouble.doubleValue()));
    }
  }
  
  private static boolean matchesNotEqualConstraint(Object paramObject1, Object paramObject2)
  {
    if (!matchesEqualConstraint(paramObject1, paramObject2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean matchesNotInConstraint(Object paramObject1, Object paramObject2)
  {
    if (!matchesInConstraint(paramObject1, paramObject2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean matchesRegexConstraint(Object paramObject1, Object paramObject2, String paramString)
  {
    boolean bool1 = false;
    if ((paramObject2 == null) || (paramObject2 == JSONObject.NULL)) {}
    for (;;)
    {
      return bool1;
      if (paramString == null) {
        paramString = "";
      }
      if (!paramString.matches("^[imxs]*$"))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[bool1] = paramString;
        throw new ParseException(102, String.format("Invalid regex options: %s", arrayOfObject));
      }
      int i;
      if (paramString.contains("i")) {
        i = 2;
      }
      if (paramString.contains("m")) {
        i |= 0x8;
      }
      if (paramString.contains("x")) {
        i |= 0x4;
      }
      if (paramString.contains("s")) {
        i |= 0x20;
      }
      boolean bool2 = Pattern.compile((String)paramObject1, i).matcher((String)paramObject2).find();
    }
  }
  
  private static boolean matchesStatelessConstraint(String paramString, Object paramObject1, Object paramObject2, ParseQuery.KeyConstraints paramKeyConstraints)
  {
    boolean bool = true;
    if (paramString.equals("$ne")) {
      bool = matchesNotEqualConstraint(paramObject1, paramObject2);
    }
    for (;;)
    {
      return bool;
      if (paramString.equals("$lt")) {
        bool = matchesLessThanConstraint(paramObject1, paramObject2);
      } else if (paramString.equals("$lte")) {
        bool = matchesLessThanOrEqualToConstraint(paramObject1, paramObject2);
      } else if (paramString.equals("$gt")) {
        bool = matchesGreaterThanConstraint(paramObject1, paramObject2);
      } else if (paramString.equals("$gte")) {
        bool = matchesGreaterThanOrEqualToConstraint(paramObject1, paramObject2);
      } else if (paramString.equals("$in")) {
        bool = matchesInConstraint(paramObject1, paramObject2);
      } else if (paramString.equals("$nin")) {
        bool = matchesNotInConstraint(paramObject1, paramObject2);
      } else if (paramString.equals("$all")) {
        bool = matchesAllConstraint(paramObject1, paramObject2);
      } else if (paramString.equals("$regex")) {
        bool = matchesRegexConstraint(paramObject1, paramObject2, (String)paramKeyConstraints.get("$options"));
      } else if (!paramString.equals("$options")) {
        if (paramString.equals("$exists"))
        {
          bool = matchesExistsConstraint(paramObject1, paramObject2);
        }
        else if (paramString.equals("$nearSphere"))
        {
          bool = matchesNearSphereConstraint(paramObject1, paramObject2, (Double)paramKeyConstraints.get("$maxDistance"));
        }
        else if (!paramString.equals("$maxDistance"))
        {
          if (!paramString.equals("$within")) {
            break;
          }
          bool = matchesWithinConstraint(paramObject1, paramObject2);
        }
      }
    }
    Object[] arrayOfObject = new Object[bool];
    arrayOfObject[0] = paramString;
    throw new UnsupportedOperationException(String.format("The offline store does not yet support the %s operator.", arrayOfObject));
  }
  
  private static boolean matchesWithinConstraint(Object paramObject1, Object paramObject2)
  {
    ArrayList localArrayList = (ArrayList)((HashMap)paramObject1).get("$box");
    ParseGeoPoint localParseGeoPoint1 = (ParseGeoPoint)localArrayList.get(0);
    ParseGeoPoint localParseGeoPoint2 = (ParseGeoPoint)localArrayList.get(1);
    ParseGeoPoint localParseGeoPoint3 = (ParseGeoPoint)paramObject2;
    if (localParseGeoPoint2.getLongitude() < localParseGeoPoint1.getLongitude()) {
      throw new ParseException(102, "whereWithinGeoBox queries cannot cross the International Date Line.");
    }
    if (localParseGeoPoint2.getLatitude() < localParseGeoPoint1.getLatitude()) {
      throw new ParseException(102, "The southwest corner of a geo box must be south of the northeast corner.");
    }
    if (localParseGeoPoint2.getLongitude() - localParseGeoPoint1.getLongitude() > 180.0D) {
      throw new ParseException(102, "Geo box queries larger than 180 degrees in longitude are not supported. Please check point order.");
    }
    if ((localParseGeoPoint3.getLatitude() >= localParseGeoPoint1.getLatitude()) && (localParseGeoPoint3.getLatitude() <= localParseGeoPoint2.getLatitude()) && (localParseGeoPoint3.getLongitude() >= localParseGeoPoint1.getLongitude()) && (localParseGeoPoint3.getLongitude() <= localParseGeoPoint2.getLongitude())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createMatcher(ParseQuery<T> paramParseQuery, ParseUser paramParseUser, boolean paramBoolean)
  {
    return new OfflineQueryLogic.15(this, paramBoolean, paramParseUser, createMatcher(paramParseQuery.getConstraints()));
  }
  
  <T extends ParseObject> m<Void> fetchIncludes(T paramT, ParseQuery<T> paramParseQuery, ParseSQLiteDatabase paramParseSQLiteDatabase)
  {
    List localList = paramParseQuery.getIncludes();
    m localm1 = m.a(null);
    Iterator localIterator = localList.iterator();
    for (m localm2 = localm1; localIterator.hasNext(); localm2 = localm2.d(new OfflineQueryLogic.21(this, paramT, (String)localIterator.next(), paramParseSQLiteDatabase))) {}
    return localm2;
  }
  
  <T extends ParseObject> void sort(List<T> paramList, ParseQuery<T> paramParseQuery)
  {
    Object localObject1 = null;
    for (String str : paramParseQuery.sortKeys()) {
      if ((!str.matches("^-?[A-Za-z][A-Za-z0-9_]*$")) && (!"_created_at".equals(str)) && (!"_updated_at".equals(str)))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = str;
        throw new ParseException(105, String.format("Invalid key name: \"%s\".", arrayOfObject));
      }
    }
    Iterator localIterator = paramParseQuery.getConstraints().keySet().iterator();
    Object localObject2 = null;
    Object localObject3;
    Object localObject5;
    if (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      Object localObject4 = paramParseQuery.getConstraints().get(localObject3);
      if (!(localObject4 instanceof ParseQuery.KeyConstraints)) {
        break label230;
      }
      ParseQuery.KeyConstraints localKeyConstraints = (ParseQuery.KeyConstraints)localObject4;
      if (!localKeyConstraints.containsKey("$nearSphere")) {
        break label230;
      }
      localObject5 = (ParseGeoPoint)localKeyConstraints.get("$nearSphere");
    }
    for (;;)
    {
      localObject1 = localObject5;
      localObject2 = localObject3;
      break;
      if ((???.length == 0) && (localObject2 == null)) {}
      for (;;)
      {
        return;
        Collections.sort(paramList, new OfflineQueryLogic.16(this, localObject2, localObject1, ???));
      }
      label230:
      localObject5 = localObject1;
      localObject3 = localObject2;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.OfflineQueryLogic
 * JD-Core Version:    0.7.0.1
 */