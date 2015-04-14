package com.parse.gdata;

public final class Preconditions
{
  public static void checkArgument(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException();
    }
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(String.valueOf(paramObject));
    }
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(format(paramString, paramVarArgs));
    }
  }
  
  public static void checkElementIndex(int paramInt1, int paramInt2)
  {
    checkElementIndex(paramInt1, paramInt2, "index");
  }
  
  public static void checkElementIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt2);
      checkArgument(bool, "negative size: %s", arrayOfObject1);
      if (paramInt1 >= 0) {
        break;
      }
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = paramString;
      arrayOfObject3[1] = Integer.valueOf(paramInt1);
      throw new IndexOutOfBoundsException(format("%s (%s) must not be negative", arrayOfObject3));
    }
    if (paramInt1 >= paramInt2)
    {
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(paramInt1);
      arrayOfObject2[2] = Integer.valueOf(paramInt2);
      throw new IndexOutOfBoundsException(format("%s (%s) must be less than size (%s)", arrayOfObject2));
    }
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, String paramString, Object... paramVarArgs)
  {
    if (paramT == null) {
      throw new NullPointerException(format(paramString, paramVarArgs));
    }
    return paramT;
  }
  
  public static void checkPositionIndex(int paramInt1, int paramInt2)
  {
    checkPositionIndex(paramInt1, paramInt2, "index");
  }
  
  public static void checkPositionIndex(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt2 >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(paramInt2);
      checkArgument(bool, "negative size: %s", arrayOfObject1);
      if (paramInt1 >= 0) {
        break;
      }
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = paramString;
      arrayOfObject3[1] = Integer.valueOf(paramInt1);
      throw new IndexOutOfBoundsException(format("%s (%s) must not be negative", arrayOfObject3));
    }
    if (paramInt1 > paramInt2)
    {
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = paramString;
      arrayOfObject2[1] = Integer.valueOf(paramInt1);
      arrayOfObject2[2] = Integer.valueOf(paramInt2);
      throw new IndexOutOfBoundsException(format("%s (%s) must not be greater than size (%s)", arrayOfObject2));
    }
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3)
  {
    checkPositionIndex(paramInt1, paramInt3, "start index");
    checkPositionIndex(paramInt2, paramInt3, "end index");
    if (paramInt2 < paramInt1)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt2);
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      throw new IndexOutOfBoundsException(format("end index (%s) must not be less than start index (%s)", arrayOfObject));
    }
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(String.valueOf(paramObject));
    }
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(format(paramString, paramVarArgs));
    }
  }
  
  static String format(String paramString, Object... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 16 * paramVarArgs.length);
    int j = 0;
    for (;;)
    {
      int i1;
      if (i < paramVarArgs.length)
      {
        i1 = paramString.indexOf("%s", j);
        if (i1 != -1) {}
      }
      else
      {
        localStringBuilder.append(paramString.substring(j));
        if (i >= paramVarArgs.length) {
          break label168;
        }
        localStringBuilder.append(" [");
        int k = i + 1;
        localStringBuilder.append(paramVarArgs[i]);
        int n;
        for (int m = k; m < paramVarArgs.length; m = n)
        {
          localStringBuilder.append(", ");
          n = m + 1;
          localStringBuilder.append(paramVarArgs[m]);
        }
      }
      localStringBuilder.append(paramString.substring(j, i1));
      int i2 = i + 1;
      localStringBuilder.append(paramVarArgs[i]);
      j = i1 + 2;
      i = i2;
    }
    localStringBuilder.append("]");
    label168:
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.gdata.Preconditions
 * JD-Core Version:    0.7.0.1
 */