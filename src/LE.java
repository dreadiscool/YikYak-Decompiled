import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public final class LE
  implements Serializable
{
  public static final LE a = a(new byte[0]);
  private static final char[] c;
  final byte[] b;
  private transient int d;
  private transient String e;
  
  static
  {
    char[] arrayOfChar = new char[16];
    arrayOfChar[0] = 48;
    arrayOfChar[1] = 49;
    arrayOfChar[2] = 50;
    arrayOfChar[3] = 51;
    arrayOfChar[4] = 52;
    arrayOfChar[5] = 53;
    arrayOfChar[6] = 54;
    arrayOfChar[7] = 55;
    arrayOfChar[8] = 56;
    arrayOfChar[9] = 57;
    arrayOfChar[10] = 97;
    arrayOfChar[11] = 98;
    arrayOfChar[12] = 99;
    arrayOfChar[13] = 100;
    arrayOfChar[14] = 101;
    arrayOfChar[15] = 102;
    c = arrayOfChar;
  }
  
  LE(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public static LE a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("s == null");
    }
    LE localLE = new LE(paramString.getBytes(LY.a));
    localLE.e = paramString;
    return localLE;
  }
  
  public static LE a(byte... paramVarArgs)
  {
    if (paramVarArgs == null) {
      throw new IllegalArgumentException("data == null");
    }
    return new LE((byte[])paramVarArgs.clone());
  }
  
  public static LE b(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("base64 == null");
    }
    byte[] arrayOfByte = Ly.a(paramString);
    if (arrayOfByte != null) {}
    for (LE localLE = new LE(arrayOfByte);; localLE = null) {
      return localLE;
    }
  }
  
  public byte a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public String a()
  {
    String str = this.e;
    if (str != null) {}
    for (;;)
    {
      return str;
      str = new String(this.b, LY.a);
      this.e = str;
    }
  }
  
  public String b()
  {
    return Ly.a(this.b);
  }
  
  public String c()
  {
    int i = 0;
    char[] arrayOfChar = new char[2 * this.b.length];
    byte[] arrayOfByte = this.b;
    int j = arrayOfByte.length;
    int k = 0;
    while (i < j)
    {
      int m = arrayOfByte[i];
      int n = k + 1;
      arrayOfChar[k] = c[(0xF & m >> 4)];
      k = n + 1;
      arrayOfChar[n] = c[(m & 0xF)];
      i++;
    }
    return new String(arrayOfChar);
  }
  
  public LE d()
  {
    int i = 0;
    while (i < this.b.length)
    {
      int j = this.b[i];
      if ((j < 65) || (j > 90))
      {
        i++;
      }
      else
      {
        byte[] arrayOfByte = (byte[])this.b.clone();
        int k = i + 1;
        arrayOfByte[i] = ((byte)(j + 32));
        int m = k;
        if (m < arrayOfByte.length)
        {
          int n = arrayOfByte[m];
          if ((n < 65) || (n > 90)) {}
          for (;;)
          {
            m++;
            break;
            arrayOfByte[m] = ((byte)(n + 32));
          }
        }
        this = new LE(arrayOfByte);
      }
    }
    return this;
  }
  
  public int e()
  {
    return this.b.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (((paramObject instanceof LE)) && (Arrays.equals(((LE)paramObject).b, this.b)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public byte[] f()
  {
    return (byte[])this.b.clone();
  }
  
  public int hashCode()
  {
    int i = this.d;
    if (i != 0) {}
    for (;;)
    {
      return i;
      i = Arrays.hashCode(this.b);
      this.d = i;
    }
  }
  
  public String toString()
  {
    Object localObject;
    if (this.b.length == 0) {
      localObject = "ByteString[size=0]";
    }
    for (;;)
    {
      return localObject;
      if (this.b.length <= 16)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Integer.valueOf(this.b.length);
        arrayOfObject2[1] = c();
        localObject = String.format("ByteString[size=%s data=%s]", arrayOfObject2);
        continue;
      }
      try
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = Integer.valueOf(this.b.length);
        arrayOfObject1[1] = a(MessageDigest.getInstance("MD5").digest(this.b)).c();
        String str = String.format("ByteString[size=%s md5=%s]", arrayOfObject1);
        localObject = str;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new AssertionError();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     LE
 * JD-Core Version:    0.7.0.1
 */