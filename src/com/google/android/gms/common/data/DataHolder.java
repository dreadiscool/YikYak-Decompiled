package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import hZ;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataHolder
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  private static final DataHolder.a Ll = new DataHolder.1(new String[0], null);
  private final int CK;
  private final int Iv;
  private final String[] Ld;
  Bundle Le;
  private final CursorWindow[] Lf;
  private final Bundle Lg;
  int[] Lh;
  int Li;
  private Object Lj;
  private boolean Lk = true;
  boolean mClosed = false;
  
  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    this.CK = paramInt1;
    this.Ld = paramArrayOfString;
    this.Lf = paramArrayOfCursorWindow;
    this.Iv = paramInt2;
    this.Lg = paramBundle;
  }
  
  private DataHolder(DataHolder.a parama, int paramInt, Bundle paramBundle)
  {
    this(DataHolder.a.a(parama), a(parama, -1), paramInt, paramBundle);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    this.CK = 1;
    this.Ld = ((String[])hZ.a(paramArrayOfString));
    this.Lf = ((CursorWindow[])hZ.a(paramArrayOfCursorWindow));
    this.Iv = paramInt;
    this.Lg = paramBundle;
    gX();
  }
  
  public static DataHolder a(int paramInt, Bundle paramBundle)
  {
    return new DataHolder(Ll, paramInt, paramBundle);
  }
  
  private static CursorWindow[] a(DataHolder.a parama, int paramInt)
  {
    int i = 0;
    CursorWindow[] arrayOfCursorWindow;
    if (DataHolder.a.a(parama).length == 0)
    {
      arrayOfCursorWindow = new CursorWindow[0];
      return arrayOfCursorWindow;
    }
    Object localObject1;
    label39:
    Object localObject2;
    ArrayList localArrayList;
    int k;
    int m;
    if ((paramInt < 0) || (paramInt >= DataHolder.a.b(parama).size()))
    {
      localObject1 = DataHolder.a.b(parama);
      int j = ((List)localObject1).size();
      localObject2 = new CursorWindow(false);
      localArrayList = new ArrayList();
      localArrayList.add(localObject2);
      ((CursorWindow)localObject2).setNumColumns(DataHolder.a.a(parama).length);
      k = 0;
      m = 0;
      label91:
      if (k >= j) {
        break label717;
      }
    }
    for (;;)
    {
      int i1;
      try
      {
        if (!((CursorWindow)localObject2).allocRow())
        {
          new StringBuilder().append("Allocating additional cursor window for large data set (row ").append(k).append(")").toString();
          localObject2 = new CursorWindow(false);
          ((CursorWindow)localObject2).setStartPosition(k);
          ((CursorWindow)localObject2).setNumColumns(DataHolder.a.a(parama).length);
          localArrayList.add(localObject2);
          if (!((CursorWindow)localObject2).allocRow())
          {
            localArrayList.remove(localObject2);
            arrayOfCursorWindow = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
            break;
            localObject1 = DataHolder.a.b(parama).subList(0, paramInt);
            break label39;
          }
        }
        Map localMap = (Map)((List)localObject1).get(k);
        i1 = 0;
        bool = true;
        if ((i1 < DataHolder.a.a(parama).length) && (bool))
        {
          String str = DataHolder.a.a(parama)[i1];
          Object localObject4 = localMap.get(str);
          if (localObject4 == null)
          {
            bool = ((CursorWindow)localObject2).putNull(k, i1);
            break label738;
          }
          if ((localObject4 instanceof String))
          {
            bool = ((CursorWindow)localObject2).putString((String)localObject4, k, i1);
            break label738;
          }
          if ((localObject4 instanceof Long))
          {
            bool = ((CursorWindow)localObject2).putLong(((Long)localObject4).longValue(), k, i1);
            break label738;
          }
          if ((localObject4 instanceof Integer))
          {
            bool = ((CursorWindow)localObject2).putLong(((Integer)localObject4).intValue(), k, i1);
            break label738;
          }
          if ((localObject4 instanceof Boolean))
          {
            if (!((Boolean)localObject4).booleanValue()) {
              break label744;
            }
            l = 1L;
            bool = ((CursorWindow)localObject2).putLong(l, k, i1);
            break label738;
          }
          if ((localObject4 instanceof byte[]))
          {
            bool = ((CursorWindow)localObject2).putBlob((byte[])localObject4, k, i1);
            break label738;
          }
          if ((localObject4 instanceof Double))
          {
            bool = ((CursorWindow)localObject2).putDouble(((Double)localObject4).doubleValue(), k, i1);
            break label738;
          }
          if ((localObject4 instanceof Float))
          {
            bool = ((CursorWindow)localObject2).putDouble(((Float)localObject4).floatValue(), k, i1);
            break label738;
          }
          throw new IllegalArgumentException("Unsupported object for column " + str + ": " + localObject4);
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        boolean bool;
        int n = localArrayList.size();
        if (i < n)
        {
          ((CursorWindow)localArrayList.get(i)).close();
          i++;
          continue;
          if (!bool)
          {
            if (m != 0) {
              throw new DataHolder.b("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
            }
            new StringBuilder().append("Couldn't populate window data for row ").append(k).append(" - allocating new window.").toString();
            ((CursorWindow)localObject2).freeLastRow();
            CursorWindow localCursorWindow = new CursorWindow(false);
            localCursorWindow.setStartPosition(k);
            localCursorWindow.setNumColumns(DataHolder.a.a(parama).length);
            localArrayList.add(localCursorWindow);
            i2 = k - 1;
            localObject3 = localCursorWindow;
            i3 = 1;
            int i4 = i2 + 1;
            m = i3;
            localObject2 = localObject3;
            k = i4;
            break label91;
          }
          int i2 = k;
          int i3 = 0;
          Object localObject3 = localObject2;
          continue;
        }
        throw localRuntimeException;
      }
      label717:
      arrayOfCursorWindow = (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      break;
      label738:
      i1++;
      continue;
      label744:
      long l = 0L;
    }
  }
  
  public static DataHolder av(int paramInt)
  {
    return a(paramInt, null);
  }
  
  private void g(String paramString, int paramInt)
  {
    if ((this.Le == null) || (!this.Le.containsKey(paramString))) {
      throw new IllegalArgumentException("No such column: " + paramString);
    }
    if (isClosed()) {
      throw new IllegalArgumentException("Buffer is closed.");
    }
    if ((paramInt < 0) || (paramInt >= this.Li)) {
      throw new CursorIndexOutOfBoundsException(paramInt, this.Li);
    }
  }
  
  public long a(String paramString, int paramInt1, int paramInt2)
  {
    g(paramString, paramInt1);
    return this.Lf[paramInt2].getLong(paramInt1, this.Le.getInt(paramString));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    g(paramString, paramInt1);
    this.Lf[paramInt2].copyStringToBuffer(paramInt1, this.Le.getInt(paramString), paramCharArrayBuffer);
  }
  
  public boolean aQ(String paramString)
  {
    return this.Le.containsKey(paramString);
  }
  
  public int au(int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.Li))
    {
      bool = true;
      hZ.a(bool);
    }
    for (;;)
    {
      if (i < this.Lh.length)
      {
        if (paramInt < this.Lh[i]) {
          i--;
        }
      }
      else
      {
        if (i == this.Lh.length) {
          i--;
        }
        return i;
        bool = false;
        break;
      }
      i++;
    }
  }
  
  public int b(String paramString, int paramInt1, int paramInt2)
  {
    g(paramString, paramInt1);
    return this.Lf[paramInt2].getInt(paramInt1, this.Le.getInt(paramString));
  }
  
  public String c(String paramString, int paramInt1, int paramInt2)
  {
    g(paramString, paramInt1);
    return this.Lf[paramInt2].getString(paramInt1, this.Le.getInt(paramString));
  }
  
  public void close()
  {
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        for (int i = 0; i < this.Lf.length; i++) {
          this.Lf[i].close();
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d(String paramString, int paramInt1, int paramInt2)
  {
    g(paramString, paramInt1);
    if (Long.valueOf(this.Lf[paramInt2].getLong(paramInt1, this.Le.getInt(paramString))).longValue() == 1L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float e(String paramString, int paramInt1, int paramInt2)
  {
    g(paramString, paramInt1);
    return this.Lf[paramInt2].getFloat(paramInt1, this.Le.getInt(paramString));
  }
  
  public void e(Object paramObject)
  {
    this.Lj = paramObject;
  }
  
  public byte[] f(String paramString, int paramInt1, int paramInt2)
  {
    g(paramString, paramInt1);
    return this.Lf[paramInt2].getBlob(paramInt1, this.Le.getInt(paramString));
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/google/android/gms/common/data/DataHolder:Lk	Z
    //   4: ifeq +79 -> 83
    //   7: aload_0
    //   8: getfield 58	com/google/android/gms/common/data/DataHolder:Lf	[Landroid/database/CursorWindow;
    //   11: arraylength
    //   12: ifle +71 -> 83
    //   15: aload_0
    //   16: invokevirtual 259	com/google/android/gms/common/data/DataHolder:isClosed	()Z
    //   19: ifne +64 -> 83
    //   22: aload_0
    //   23: getfield 316	com/google/android/gms/common/data/DataHolder:Lj	Ljava/lang/Object;
    //   26: ifnonnull +62 -> 88
    //   29: new 123	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 325
    //   39: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 326	java/lang/Object:toString	()Ljava/lang/String;
    //   46: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_3
    //   53: new 123	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 328
    //   63: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_3
    //   67: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 135
    //   72: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 329	com/google/android/gms/common/data/DataHolder:close	()V
    //   83: aload_0
    //   84: invokespecial 331	java/lang/Object:finalize	()V
    //   87: return
    //   88: aload_0
    //   89: getfield 316	com/google/android/gms/common/data/DataHolder:Lj	Ljava/lang/Object;
    //   92: invokevirtual 326	java/lang/Object:toString	()Ljava/lang/String;
    //   95: astore_2
    //   96: aload_2
    //   97: astore_3
    //   98: goto -45 -> 53
    //   101: astore_1
    //   102: aload_0
    //   103: invokespecial 331	java/lang/Object:finalize	()V
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	DataHolder
    //   101	6	1	localObject1	Object
    //   95	2	2	str	String
    //   52	46	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	83	101	finally
    //   88	96	101	finally
  }
  
  public Uri g(String paramString, int paramInt1, int paramInt2)
  {
    String str = c(paramString, paramInt1, paramInt2);
    if (str == null) {}
    for (Uri localUri = null;; localUri = Uri.parse(str)) {
      return localUri;
    }
  }
  
  public Bundle gV()
  {
    return this.Lg;
  }
  
  public void gX()
  {
    int i = 0;
    this.Le = new Bundle();
    for (int j = 0; j < this.Ld.length; j++) {
      this.Le.putInt(this.Ld[j], j);
    }
    this.Lh = new int[this.Lf.length];
    int k = 0;
    while (i < this.Lf.length)
    {
      this.Lh[i] = k;
      int m = k - this.Lf[i].getStartPosition();
      k += this.Lf[i].getNumRows() - m;
      i++;
    }
    this.Li = k;
  }
  
  String[] gY()
  {
    return this.Ld;
  }
  
  CursorWindow[] gZ()
  {
    return this.Lf;
  }
  
  public int getCount()
  {
    return this.Li;
  }
  
  public int getStatusCode()
  {
    return this.Iv;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean h(String paramString, int paramInt1, int paramInt2)
  {
    g(paramString, paramInt1);
    return this.Lf[paramInt2].isNull(paramInt1, this.Le.getInt(paramString));
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolder
 * JD-Core Version:    0.7.0.1
 */