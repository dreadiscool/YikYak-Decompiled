package android.support.v4.util;

public class SparseArrayCompat<E>
  implements Cloneable
{
  private static final Object DELETED = new Object();
  private boolean mGarbage = false;
  private int[] mKeys;
  private int mSize;
  private Object[] mValues;
  
  public SparseArrayCompat()
  {
    this(10);
  }
  
  public SparseArrayCompat(int paramInt)
  {
    if (paramInt == 0) {
      this.mKeys = ContainerHelpers.EMPTY_INTS;
    }
    int i;
    for (this.mValues = ContainerHelpers.EMPTY_OBJECTS;; this.mValues = new Object[i])
    {
      this.mSize = 0;
      return;
      i = ContainerHelpers.idealIntArraySize(paramInt);
      this.mKeys = new int[i];
    }
  }
  
  private void gc()
  {
    int i = this.mSize;
    int[] arrayOfInt = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      Object localObject = arrayOfObject[j];
      if (localObject != DELETED)
      {
        if (j != k)
        {
          arrayOfInt[k] = arrayOfInt[j];
          arrayOfObject[k] = localObject;
          arrayOfObject[j] = null;
        }
        k++;
      }
      j++;
    }
    this.mGarbage = false;
    this.mSize = k;
  }
  
  public void append(int paramInt, E paramE)
  {
    if ((this.mSize != 0) && (paramInt <= this.mKeys[(-1 + this.mSize)])) {
      put(paramInt, paramE);
    }
    for (;;)
    {
      return;
      if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
        gc();
      }
      int i = this.mSize;
      if (i >= this.mKeys.length)
      {
        int j = ContainerHelpers.idealIntArraySize(i + 1);
        int[] arrayOfInt = new int[j];
        Object[] arrayOfObject = new Object[j];
        System.arraycopy(this.mKeys, 0, arrayOfInt, 0, this.mKeys.length);
        System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
        this.mKeys = arrayOfInt;
        this.mValues = arrayOfObject;
      }
      this.mKeys[i] = paramInt;
      this.mValues[i] = paramE;
      this.mSize = (i + 1);
    }
  }
  
  public void clear()
  {
    int i = this.mSize;
    Object[] arrayOfObject = this.mValues;
    for (int j = 0; j < i; j++) {
      arrayOfObject[j] = null;
    }
    this.mSize = 0;
    this.mGarbage = false;
  }
  
  /* Error */
  public SparseArrayCompat<E> clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	android/support/v4/util/SparseArrayCompat
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 36	android/support/v4/util/SparseArrayCompat:mKeys	[I
    //   13: invokevirtual 71	[I:clone	()Ljava/lang/Object;
    //   16: checkcast 70	[I
    //   19: putfield 36	android/support/v4/util/SparseArrayCompat:mKeys	[I
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 41	android/support/v4/util/SparseArrayCompat:mValues	[Ljava/lang/Object;
    //   27: invokevirtual 73	[Ljava/lang/Object;:clone	()Ljava/lang/Object;
    //   30: checkcast 72	[Ljava/lang/Object;
    //   33: putfield 41	android/support/v4/util/SparseArrayCompat:mValues	[Ljava/lang/Object;
    //   36: aload_2
    //   37: areturn
    //   38: astore_1
    //   39: aconst_null
    //   40: astore_2
    //   41: goto -5 -> 36
    //   44: astore_3
    //   45: goto -9 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	SparseArrayCompat
    //   38	1	1	localCloneNotSupportedException1	java.lang.CloneNotSupportedException
    //   7	34	2	localSparseArrayCompat	SparseArrayCompat
    //   44	1	3	localCloneNotSupportedException2	java.lang.CloneNotSupportedException
    // Exception table:
    //   from	to	target	type
    //   0	8	38	java/lang/CloneNotSupportedException
    //   8	36	44	java/lang/CloneNotSupportedException
  }
  
  public void delete(int paramInt)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
    if ((i >= 0) && (this.mValues[i] != DELETED))
    {
      this.mValues[i] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public E get(int paramInt)
  {
    return get(paramInt, null);
  }
  
  public E get(int paramInt, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
    if ((i < 0) || (this.mValues[i] == DELETED)) {}
    for (;;)
    {
      return paramE;
      paramE = this.mValues[i];
    }
  }
  
  public int indexOfKey(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
  }
  
  public int indexOfValue(E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    int i = 0;
    if (i < this.mSize) {
      if (this.mValues[i] != paramE) {}
    }
    for (;;)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }
  
  public int keyAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mKeys[paramInt];
  }
  
  public void put(int paramInt, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
    if (i >= 0) {
      this.mValues[i] = paramE;
    }
    for (;;)
    {
      return;
      int j = i ^ 0xFFFFFFFF;
      if ((j < this.mSize) && (this.mValues[j] == DELETED))
      {
        this.mKeys[j] = paramInt;
        this.mValues[j] = paramE;
      }
      else
      {
        if ((this.mGarbage) && (this.mSize >= this.mKeys.length))
        {
          gc();
          j = 0xFFFFFFFF ^ ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
        }
        if (this.mSize >= this.mKeys.length)
        {
          int k = ContainerHelpers.idealIntArraySize(1 + this.mSize);
          int[] arrayOfInt = new int[k];
          Object[] arrayOfObject = new Object[k];
          System.arraycopy(this.mKeys, 0, arrayOfInt, 0, this.mKeys.length);
          System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
          this.mKeys = arrayOfInt;
          this.mValues = arrayOfObject;
        }
        if (this.mSize - j != 0)
        {
          System.arraycopy(this.mKeys, j, this.mKeys, j + 1, this.mSize - j);
          System.arraycopy(this.mValues, j, this.mValues, j + 1, this.mSize - j);
        }
        this.mKeys[j] = paramInt;
        this.mValues[j] = paramE;
        this.mSize = (1 + this.mSize);
      }
    }
  }
  
  public void remove(int paramInt)
  {
    delete(paramInt);
  }
  
  public void removeAt(int paramInt)
  {
    if (this.mValues[paramInt] != DELETED)
    {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public void removeAtRange(int paramInt1, int paramInt2)
  {
    int i = Math.min(this.mSize, paramInt1 + paramInt2);
    while (paramInt1 < i)
    {
      removeAt(paramInt1);
      paramInt1++;
    }
  }
  
  public void setValueAt(int paramInt, E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    this.mValues[paramInt] = paramE;
  }
  
  public int size()
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mSize;
  }
  
  public String toString()
  {
    if (size() <= 0) {}
    StringBuilder localStringBuilder;
    for (String str = "{}";; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder(28 * this.mSize);
      localStringBuilder.append('{');
      int i = 0;
      if (i < this.mSize)
      {
        if (i > 0) {
          localStringBuilder.append(", ");
        }
        localStringBuilder.append(keyAt(i));
        localStringBuilder.append('=');
        Object localObject = valueAt(i);
        if (localObject != this) {
          localStringBuilder.append(localObject);
        }
        for (;;)
        {
          i++;
          break;
          localStringBuilder.append("(this Map)");
        }
      }
      localStringBuilder.append('}');
    }
  }
  
  public E valueAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mValues[paramInt];
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.SparseArrayCompat
 * JD-Core Version:    0.7.0.1
 */