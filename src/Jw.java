import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jw
  implements Closeable
{
  private static final Logger b = Logger.getLogger(Jw.class.getName());
  int a;
  private final RandomAccessFile c;
  private int d;
  private Jy e;
  private Jy f;
  private final byte[] g = new byte[16];
  
  public Jw(File paramFile)
  {
    if (!paramFile.exists()) {
      a(paramFile);
    }
    this.c = b(paramFile);
    e();
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return ((0xFF & paramArrayOfByte[paramInt]) << 24) + ((0xFF & paramArrayOfByte[(paramInt + 1)]) << 16) + ((0xFF & paramArrayOfByte[(paramInt + 2)]) << 8) + (0xFF & paramArrayOfByte[(paramInt + 3)]);
  }
  
  private Jy a(int paramInt)
  {
    if (paramInt == 0) {}
    for (Jy localJy = Jy.a;; localJy = new Jy(paramInt, this.c.readInt()))
    {
      return localJy;
      this.c.seek(paramInt);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = this.g;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = paramInt1;
    arrayOfInt[1] = paramInt2;
    arrayOfInt[2] = paramInt3;
    arrayOfInt[3] = paramInt4;
    a(arrayOfByte, arrayOfInt);
    this.c.seek(0L);
    this.c.write(this.g);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = b(paramInt1);
    if (i + paramInt3 <= this.a)
    {
      this.c.seek(i);
      this.c.write(paramArrayOfByte, paramInt2, paramInt3);
    }
    for (;;)
    {
      return;
      int j = this.a - i;
      this.c.seek(i);
      this.c.write(paramArrayOfByte, paramInt2, j);
      this.c.seek(16L);
      this.c.write(paramArrayOfByte, paramInt2 + j, paramInt3 - j);
    }
  }
  
  private static void a(File paramFile)
  {
    File localFile = new File(paramFile.getPath() + ".tmp");
    RandomAccessFile localRandomAccessFile = b(localFile);
    try
    {
      localRandomAccessFile.setLength(4096L);
      localRandomAccessFile.seek(0L);
      byte[] arrayOfByte = new byte[16];
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = 4096;
      arrayOfInt[1] = 0;
      arrayOfInt[2] = 0;
      arrayOfInt[3] = 0;
      a(arrayOfByte, arrayOfInt);
      localRandomAccessFile.write(arrayOfByte);
      localRandomAccessFile.close();
      if (!localFile.renameTo(paramFile)) {
        throw new IOException("Rename failed!");
      }
    }
    finally
    {
      localRandomAccessFile.close();
    }
  }
  
  private static void a(byte[] paramArrayOfByte, int... paramVarArgs)
  {
    int i = 0;
    int j = paramVarArgs.length;
    int k = 0;
    while (i < j)
    {
      b(paramArrayOfByte, k, paramVarArgs[i]);
      k += 4;
      i++;
    }
  }
  
  private int b(int paramInt)
  {
    if (paramInt < this.a) {}
    for (;;)
    {
      return paramInt;
      paramInt = paramInt + 16 - this.a;
    }
  }
  
  private static RandomAccessFile b(File paramFile)
  {
    return new RandomAccessFile(paramFile, "rwd");
  }
  
  private static <T> T b(T paramT, String paramString)
  {
    if (paramT == null) {
      throw new NullPointerException(paramString);
    }
    return paramT;
  }
  
  private void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = b(paramInt1);
    if (i + paramInt3 <= this.a)
    {
      this.c.seek(i);
      this.c.readFully(paramArrayOfByte, paramInt2, paramInt3);
    }
    for (;;)
    {
      return;
      int j = this.a - i;
      this.c.seek(i);
      this.c.readFully(paramArrayOfByte, paramInt2, j);
      this.c.seek(16L);
      this.c.readFully(paramArrayOfByte, paramInt2 + j, paramInt3 - j);
    }
  }
  
  private static void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)(paramInt2 >> 24));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)paramInt2);
  }
  
  private void c(int paramInt)
  {
    int i = paramInt + 4;
    int j = f();
    if (j >= i) {
      return;
    }
    int k = this.a;
    do
    {
      j += k;
      k <<= 1;
    } while (j < i);
    d(k);
    int m = b(4 + this.f.b + this.f.c);
    if (m < this.e.b)
    {
      FileChannel localFileChannel = this.c.getChannel();
      localFileChannel.position(this.a);
      int i1 = m - 4;
      if (localFileChannel.transferTo(16L, i1, localFileChannel) != i1) {
        throw new AssertionError("Copied insufficient number of bytes!");
      }
    }
    if (this.f.b < this.e.b)
    {
      int n = -16 + (this.a + this.f.b);
      a(k, this.d, this.e.b, n);
      this.f = new Jy(n, this.f.c);
    }
    for (;;)
    {
      this.a = k;
      break;
      a(k, this.d, this.e.b, this.f.b);
    }
  }
  
  private void d(int paramInt)
  {
    this.c.setLength(paramInt);
    this.c.getChannel().force(true);
  }
  
  private void e()
  {
    this.c.seek(0L);
    this.c.readFully(this.g);
    this.a = a(this.g, 0);
    if (this.a > this.c.length()) {
      throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
    }
    this.d = a(this.g, 4);
    int i = a(this.g, 8);
    int j = a(this.g, 12);
    this.e = a(i);
    this.f = a(j);
  }
  
  private int f()
  {
    return this.a - a();
  }
  
  public int a()
  {
    int i;
    if (this.d == 0) {
      i = 16;
    }
    for (;;)
    {
      return i;
      if (this.f.b >= this.e.b) {
        i = 16 + (4 + (this.f.b - this.e.b) + this.f.c);
      } else {
        i = 4 + this.f.b + this.f.c + this.a - this.e.b;
      }
    }
  }
  
  public void a(JA paramJA)
  {
    try
    {
      int i = this.e.b;
      for (int j = 0; j < this.d; j++)
      {
        Jy localJy = a(i);
        paramJA.a(new Jz(this, localJy, null), localJy.c);
        int k = b(4 + localJy.b + localJy.c);
        i = k;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      b(paramArrayOfByte, "buffer");
      if (((paramInt1 | paramInt2) < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
        throw new IndexOutOfBoundsException();
      }
    }
    finally {}
    c(paramInt2);
    boolean bool = b();
    int i;
    Jy localJy;
    if (bool)
    {
      i = 16;
      localJy = new Jy(i, paramInt2);
      b(this.g, 0, paramInt2);
      a(localJy.b, this.g, 0, 4);
      a(4 + localJy.b, paramArrayOfByte, paramInt1, paramInt2);
      if (!bool) {
        break label199;
      }
    }
    label199:
    for (int j = localJy.b;; j = this.e.b)
    {
      a(this.a, 1 + this.d, j, localJy.b);
      this.f = localJy;
      this.d = (1 + this.d);
      if (bool) {
        this.e = this.f;
      }
      return;
      i = b(4 + this.f.b + this.f.c);
      break;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 + (4 + a()) <= paramInt2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 185	Jw:d	I
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +9 -> 17
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_3
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	Jw
    //   22	4	1	localObject	Object
    //   6	2	2	i	int
    //   12	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void c()
  {
    try
    {
      if (b()) {
        throw new NoSuchElementException();
      }
    }
    finally {}
    if (this.d == 1) {
      d();
    }
    for (;;)
    {
      return;
      int i = b(4 + this.e.b + this.e.c);
      b(i, this.g, 0, 4);
      int j = a(this.g, 0);
      a(this.a, -1 + this.d, i, this.f.b);
      this.d = (-1 + this.d);
      this.e = new Jy(i, j);
    }
  }
  
  public void close()
  {
    try
    {
      this.c.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    try
    {
      a(4096, 0, 0, 0);
      this.d = 0;
      this.e = Jy.a;
      this.f = Jy.a;
      if (this.a > 4096) {
        d(4096);
      }
      this.a = 4096;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName()).append('[');
    localStringBuilder.append("fileLength=").append(this.a);
    localStringBuilder.append(", size=").append(this.d);
    localStringBuilder.append(", first=").append(this.e);
    localStringBuilder.append(", last=").append(this.f);
    localStringBuilder.append(", element lengths=[");
    try
    {
      a(new Jx(this, localStringBuilder));
      localStringBuilder.append("]]");
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        b.log(Level.WARNING, "read error", localIOException);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Jw
 * JD-Core Version:    0.7.0.1
 */