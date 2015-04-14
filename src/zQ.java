import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

final class zQ
{
  private final String b;
  private final long[] c;
  private final File[] d;
  private final File[] e;
  private boolean f;
  private zO g;
  private long h;
  
  private zQ(zL paramzL, String paramString)
  {
    this.b = paramString;
    this.c = new long[zL.e(paramzL)];
    this.d = new File[zL.e(paramzL)];
    this.e = new File[zL.e(paramzL)];
    StringBuilder localStringBuilder = new StringBuilder(paramString).append('.');
    int i = localStringBuilder.length();
    for (int j = 0; j < zL.e(paramzL); j++)
    {
      localStringBuilder.append(j);
      this.d[j] = new File(zL.f(paramzL), localStringBuilder.toString());
      localStringBuilder.append(".tmp");
      this.e[j] = new File(zL.f(paramzL), localStringBuilder.toString());
      localStringBuilder.setLength(i);
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != zL.e(this.a)) {
      throw b(paramArrayOfString);
    }
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.c[i] = Long.parseLong(paramArrayOfString[i]);
        i++;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw b(paramArrayOfString);
    }
  }
  
  private IOException b(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  zR a()
  {
    int i = 0;
    if (!Thread.holdsLock(this.a)) {
      throw new AssertionError();
    }
    LV[] arrayOfLV = new LV[zL.e(this.a)];
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < zL.e(this.a))
        {
          arrayOfLV[j] = LK.a(this.d[j]);
          j++;
          continue;
        }
        localzR = new zR(this.a, this.b, this.h, arrayOfLV, this.c, null);
        return localzR;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        zR localzR;
        continue;
      }
      if ((i < zL.e(this.a)) && (arrayOfLV[i] != null))
      {
        Ae.a(arrayOfLV[i]);
        i++;
      }
      else
      {
        localzR = null;
      }
    }
  }
  
  void a(LC paramLC)
  {
    for (long l : this.c) {
      paramLC.g(32).b(Long.toString(l));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     zQ
 * JD-Core Version:    0.7.0.1
 */