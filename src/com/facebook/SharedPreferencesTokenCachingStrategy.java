package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SharedPreferencesTokenCachingStrategy
  extends TokenCachingStrategy
{
  private static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
  private static final String JSON_VALUE = "value";
  private static final String JSON_VALUE_ENUM_TYPE = "enumType";
  private static final String JSON_VALUE_TYPE = "valueType";
  private static final String TAG = SharedPreferencesTokenCachingStrategy.class.getSimpleName();
  private static final String TYPE_BOOLEAN = "bool";
  private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
  private static final String TYPE_BYTE = "byte";
  private static final String TYPE_BYTE_ARRAY = "byte[]";
  private static final String TYPE_CHAR = "char";
  private static final String TYPE_CHAR_ARRAY = "char[]";
  private static final String TYPE_DOUBLE = "double";
  private static final String TYPE_DOUBLE_ARRAY = "double[]";
  private static final String TYPE_ENUM = "enum";
  private static final String TYPE_FLOAT = "float";
  private static final String TYPE_FLOAT_ARRAY = "float[]";
  private static final String TYPE_INTEGER = "int";
  private static final String TYPE_INTEGER_ARRAY = "int[]";
  private static final String TYPE_LONG = "long";
  private static final String TYPE_LONG_ARRAY = "long[]";
  private static final String TYPE_SHORT = "short";
  private static final String TYPE_SHORT_ARRAY = "short[]";
  private static final String TYPE_STRING = "string";
  private static final String TYPE_STRING_LIST = "stringList";
  private SharedPreferences cache;
  private String cacheKey;
  
  public SharedPreferencesTokenCachingStrategy(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SharedPreferencesTokenCachingStrategy(Context paramContext, String paramString)
  {
    Validate.notNull(paramContext, "context");
    if (Utility.isNullOrEmpty(paramString)) {
      paramString = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    }
    this.cacheKey = paramString;
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      paramContext = localContext;
    }
    this.cache = paramContext.getSharedPreferences(this.cacheKey, 0);
  }
  
  private void deserializeKey(String paramString, Bundle paramBundle)
  {
    int i = 0;
    JSONObject localJSONObject = new JSONObject(this.cache.getString(paramString, "{}"));
    String str1 = localJSONObject.getString("valueType");
    if (str1.equals("bool")) {
      paramBundle.putBoolean(paramString, localJSONObject.getBoolean("value"));
    }
    for (;;)
    {
      return;
      if (str1.equals("bool[]"))
      {
        JSONArray localJSONArray9 = localJSONObject.getJSONArray("value");
        boolean[] arrayOfBoolean = new boolean[localJSONArray9.length()];
        while (i < arrayOfBoolean.length)
        {
          arrayOfBoolean[i] = localJSONArray9.getBoolean(i);
          i++;
        }
        paramBundle.putBooleanArray(paramString, arrayOfBoolean);
      }
      else if (str1.equals("byte"))
      {
        paramBundle.putByte(paramString, (byte)localJSONObject.getInt("value"));
      }
      else if (str1.equals("byte[]"))
      {
        JSONArray localJSONArray8 = localJSONObject.getJSONArray("value");
        byte[] arrayOfByte = new byte[localJSONArray8.length()];
        while (i < arrayOfByte.length)
        {
          arrayOfByte[i] = ((byte)localJSONArray8.getInt(i));
          i++;
        }
        paramBundle.putByteArray(paramString, arrayOfByte);
      }
      else if (str1.equals("short"))
      {
        paramBundle.putShort(paramString, (short)localJSONObject.getInt("value"));
      }
      else if (str1.equals("short[]"))
      {
        JSONArray localJSONArray7 = localJSONObject.getJSONArray("value");
        short[] arrayOfShort = new short[localJSONArray7.length()];
        while (i < arrayOfShort.length)
        {
          arrayOfShort[i] = ((short)localJSONArray7.getInt(i));
          i++;
        }
        paramBundle.putShortArray(paramString, arrayOfShort);
      }
      else if (str1.equals("int"))
      {
        paramBundle.putInt(paramString, localJSONObject.getInt("value"));
      }
      else if (str1.equals("int[]"))
      {
        JSONArray localJSONArray6 = localJSONObject.getJSONArray("value");
        int[] arrayOfInt = new int[localJSONArray6.length()];
        while (i < arrayOfInt.length)
        {
          arrayOfInt[i] = localJSONArray6.getInt(i);
          i++;
        }
        paramBundle.putIntArray(paramString, arrayOfInt);
      }
      else if (str1.equals("long"))
      {
        paramBundle.putLong(paramString, localJSONObject.getLong("value"));
      }
      else if (str1.equals("long[]"))
      {
        JSONArray localJSONArray5 = localJSONObject.getJSONArray("value");
        long[] arrayOfLong = new long[localJSONArray5.length()];
        while (i < arrayOfLong.length)
        {
          arrayOfLong[i] = localJSONArray5.getLong(i);
          i++;
        }
        paramBundle.putLongArray(paramString, arrayOfLong);
      }
      else if (str1.equals("float"))
      {
        paramBundle.putFloat(paramString, (float)localJSONObject.getDouble("value"));
      }
      else if (str1.equals("float[]"))
      {
        JSONArray localJSONArray4 = localJSONObject.getJSONArray("value");
        float[] arrayOfFloat = new float[localJSONArray4.length()];
        while (i < arrayOfFloat.length)
        {
          arrayOfFloat[i] = ((float)localJSONArray4.getDouble(i));
          i++;
        }
        paramBundle.putFloatArray(paramString, arrayOfFloat);
      }
      else if (str1.equals("double"))
      {
        paramBundle.putDouble(paramString, localJSONObject.getDouble("value"));
      }
      else if (str1.equals("double[]"))
      {
        JSONArray localJSONArray3 = localJSONObject.getJSONArray("value");
        double[] arrayOfDouble = new double[localJSONArray3.length()];
        while (i < arrayOfDouble.length)
        {
          arrayOfDouble[i] = localJSONArray3.getDouble(i);
          i++;
        }
        paramBundle.putDoubleArray(paramString, arrayOfDouble);
      }
      else if (str1.equals("char"))
      {
        String str3 = localJSONObject.getString("value");
        if ((str3 != null) && (str3.length() == 1)) {
          paramBundle.putChar(paramString, str3.charAt(0));
        }
      }
      else if (str1.equals("char[]"))
      {
        JSONArray localJSONArray2 = localJSONObject.getJSONArray("value");
        char[] arrayOfChar = new char[localJSONArray2.length()];
        for (int m = 0; m < arrayOfChar.length; m++)
        {
          String str2 = localJSONArray2.getString(m);
          if ((str2 != null) && (str2.length() == 1)) {
            arrayOfChar[m] = str2.charAt(0);
          }
        }
        paramBundle.putCharArray(paramString, arrayOfChar);
      }
      else if (str1.equals("string"))
      {
        paramBundle.putString(paramString, localJSONObject.getString("value"));
      }
      else if (str1.equals("stringList"))
      {
        JSONArray localJSONArray1 = localJSONObject.getJSONArray("value");
        int j = localJSONArray1.length();
        ArrayList localArrayList = new ArrayList(j);
        int k = 0;
        if (k < j)
        {
          Object localObject1 = localJSONArray1.get(k);
          if (localObject1 == JSONObject.NULL) {}
          for (Object localObject2 = null;; localObject2 = (String)localObject1)
          {
            localArrayList.add(k, localObject2);
            k++;
            break;
          }
        }
        paramBundle.putStringArrayList(paramString, localArrayList);
      }
      else if (str1.equals("enum"))
      {
        try
        {
          paramBundle.putSerializable(paramString, Enum.valueOf(Class.forName(localJSONObject.getString("enumType")), localJSONObject.getString("value")));
        }
        catch (ClassNotFoundException localClassNotFoundException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
      }
    }
  }
  
  private void serializeKey(String paramString, Bundle paramBundle, SharedPreferences.Editor paramEditor)
  {
    String str = null;
    int i = 0;
    Object localObject1 = paramBundle.get(paramString);
    if (localObject1 == null) {}
    label973:
    for (;;)
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      Object localObject2;
      if ((localObject1 instanceof Byte))
      {
        localJSONObject.put("value", ((Byte)localObject1).intValue());
        localObject2 = null;
        str = "byte";
      }
      for (;;)
      {
        if (str == null) {
          break label973;
        }
        localJSONObject.put("valueType", str);
        if (localObject2 != null) {
          localJSONObject.putOpt("value", localObject2);
        }
        paramEditor.putString(paramString, localJSONObject.toString());
        break;
        if ((localObject1 instanceof Short))
        {
          localJSONObject.put("value", ((Short)localObject1).intValue());
          localObject2 = null;
          str = "short";
        }
        else if ((localObject1 instanceof Integer))
        {
          localJSONObject.put("value", ((Integer)localObject1).intValue());
          localObject2 = null;
          str = "int";
        }
        else if ((localObject1 instanceof Long))
        {
          localJSONObject.put("value", ((Long)localObject1).longValue());
          localObject2 = null;
          str = "long";
        }
        else if ((localObject1 instanceof Float))
        {
          localJSONObject.put("value", ((Float)localObject1).doubleValue());
          localObject2 = null;
          str = "float";
        }
        else if ((localObject1 instanceof Double))
        {
          localJSONObject.put("value", ((Double)localObject1).doubleValue());
          localObject2 = null;
          str = "double";
        }
        else if ((localObject1 instanceof Boolean))
        {
          localJSONObject.put("value", ((Boolean)localObject1).booleanValue());
          localObject2 = null;
          str = "bool";
        }
        else if ((localObject1 instanceof Character))
        {
          localJSONObject.put("value", localObject1.toString());
          localObject2 = null;
          str = "char";
        }
        else if ((localObject1 instanceof String))
        {
          localJSONObject.put("value", (String)localObject1);
          localObject2 = null;
          str = "string";
        }
        else if ((localObject1 instanceof Enum))
        {
          localJSONObject.put("value", localObject1.toString());
          localJSONObject.put("enumType", localObject1.getClass().getName());
          localObject2 = null;
          str = "enum";
        }
        else
        {
          JSONArray localJSONArray = new JSONArray();
          if ((localObject1 instanceof byte[]))
          {
            str = "byte[]";
            byte[] arrayOfByte = (byte[])localObject1;
            int i4 = arrayOfByte.length;
            while (i < i4)
            {
              localJSONArray.put(arrayOfByte[i]);
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof short[]))
          {
            str = "short[]";
            short[] arrayOfShort = (short[])localObject1;
            int i3 = arrayOfShort.length;
            while (i < i3)
            {
              localJSONArray.put(arrayOfShort[i]);
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof int[]))
          {
            str = "int[]";
            int[] arrayOfInt = (int[])localObject1;
            int i2 = arrayOfInt.length;
            while (i < i2)
            {
              localJSONArray.put(arrayOfInt[i]);
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof long[]))
          {
            str = "long[]";
            long[] arrayOfLong = (long[])localObject1;
            int i1 = arrayOfLong.length;
            while (i < i1)
            {
              localJSONArray.put(arrayOfLong[i]);
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof float[]))
          {
            str = "float[]";
            float[] arrayOfFloat = (float[])localObject1;
            int n = arrayOfFloat.length;
            while (i < n)
            {
              localJSONArray.put(arrayOfFloat[i]);
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof double[]))
          {
            str = "double[]";
            double[] arrayOfDouble = (double[])localObject1;
            int m = arrayOfDouble.length;
            while (i < m)
            {
              localJSONArray.put(arrayOfDouble[i]);
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof boolean[]))
          {
            str = "bool[]";
            boolean[] arrayOfBoolean = (boolean[])localObject1;
            int k = arrayOfBoolean.length;
            while (i < k)
            {
              localJSONArray.put(arrayOfBoolean[i]);
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof char[]))
          {
            str = "char[]";
            char[] arrayOfChar = (char[])localObject1;
            int j = arrayOfChar.length;
            while (i < j)
            {
              localJSONArray.put(String.valueOf(arrayOfChar[i]));
              i++;
            }
            localObject2 = localJSONArray;
          }
          else if ((localObject1 instanceof List))
          {
            str = "stringList";
            Iterator localIterator = ((List)localObject1).iterator();
            while (localIterator.hasNext())
            {
              Object localObject3 = (String)localIterator.next();
              if (localObject3 == null) {
                localObject3 = JSONObject.NULL;
              }
              localJSONArray.put(localObject3);
            }
            localObject2 = localJSONArray;
          }
          else
          {
            localObject2 = null;
          }
        }
      }
    }
  }
  
  public void clear()
  {
    this.cache.edit().clear().apply();
  }
  
  public Bundle load()
  {
    Bundle localBundle1 = new Bundle();
    Iterator localIterator = this.cache.getAll().keySet().iterator();
    Bundle localBundle2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          deserializeKey(str, localBundle1);
        }
        catch (JSONException localJSONException)
        {
          Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + str + "' -- " + localJSONException);
          localBundle2 = null;
        }
      }
    }
    for (;;)
    {
      return localBundle2;
      localBundle2 = localBundle1;
    }
  }
  
  public void save(Bundle paramBundle)
  {
    Validate.notNull(paramBundle, "bundle");
    SharedPreferences.Editor localEditor = this.cache.edit();
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          serializeKey(str, paramBundle, localEditor);
        }
        catch (JSONException localJSONException)
        {
          Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + str + "' -- " + localJSONException);
        }
      }
    }
    for (;;)
    {
      return;
      localEditor.apply();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.SharedPreferencesTokenCachingStrategy
 * JD-Core Version:    0.7.0.1
 */