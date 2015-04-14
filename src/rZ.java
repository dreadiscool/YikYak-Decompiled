import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class rZ
  implements Iterable<Byte>
{
  public static final rZ a;
  
  static
  {
    if (!rZ.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      a = new sB(new byte[0]);
      return;
    }
  }
  
  public static rZ a(Iterable<rZ> paramIterable)
  {
    Object localObject;
    if (!(paramIterable instanceof Collection))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((rZ)localIterator.next());
      }
      localObject = localArrayList;
      if (!((Collection)localObject).isEmpty()) {
        break label77;
      }
    }
    label77:
    for (rZ localrZ = a;; localrZ = a(((Collection)localObject).iterator(), ((Collection)localObject).size()))
    {
      return localrZ;
      localObject = (Collection)paramIterable;
      break;
    }
  }
  
  private static rZ a(Iterator<rZ> paramIterator, int paramInt)
  {
    if ((!b) && (paramInt < 1)) {
      throw new AssertionError();
    }
    if (paramInt == 1) {}
    int i;
    for (rZ localrZ = (rZ)paramIterator.next();; localrZ = a(paramIterator, i).a(a(paramIterator, paramInt - i)))
    {
      return localrZ;
      i = paramInt >>> 1;
    }
  }
  
  public static rZ a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new sB(arrayOfByte);
  }
  
  public static sb i()
  {
    return new sb(128);
  }
  
  public abstract int a();
  
  protected abstract int a(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract String a(String paramString);
  
  public rZ a(rZ paramrZ)
  {
    int i = a();
    int j = paramrZ.a();
    if (i + j >= 2147483647L) {
      throw new IllegalArgumentException("ByteString would be too long: " + i + "+" + j);
    }
    return sJ.a(this, paramrZ);
  }
  
  void a(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("Length < 0: " + paramInt2);
    }
    if (paramInt1 + paramInt2 > a()) {
      throw new IndexOutOfBoundsException("Source end offset exceeded: " + (paramInt1 + paramInt2));
    }
    if (paramInt2 > 0) {
      b(paramOutputStream, paramInt1, paramInt2);
    }
  }
  
  protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int b(int paramInt1, int paramInt2, int paramInt3);
  
  abstract void b(OutputStream paramOutputStream, int paramInt1, int paramInt2);
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Source offset < 0: " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IndexOutOfBoundsException("Target offset < 0: " + paramInt2);
    }
    if (paramInt3 < 0) {
      throw new IndexOutOfBoundsException("Length < 0: " + paramInt3);
    }
    if (paramInt1 + paramInt3 > a()) {
      throw new IndexOutOfBoundsException("Source end offset < 0: " + (paramInt1 + paramInt3));
    }
    if (paramInt2 + paramInt3 > paramArrayOfByte.length) {
      throw new IndexOutOfBoundsException("Target end offset < 0: " + (paramInt2 + paramInt3));
    }
    if (paramInt3 > 0) {
      a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public abstract sa c();
  
  public boolean d()
  {
    if (a() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public byte[] e()
  {
    int i = a();
    byte[] arrayOfByte;
    if (i == 0) {
      arrayOfByte = su.a;
    }
    for (;;)
    {
      return arrayOfByte;
      arrayOfByte = new byte[i];
      a(arrayOfByte, 0, 0, i);
    }
  }
  
  public String f()
  {
    try
    {
      String str = a("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
  
  public abstract boolean g();
  
  public abstract sc h();
  
  public abstract int hashCode();
  
  protected abstract int j();
  
  protected abstract boolean k();
  
  protected abstract int l();
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.toHexString(System.identityHashCode(this));
    arrayOfObject[1] = Integer.valueOf(a());
    return String.format("<ByteString@%s size=%d>", arrayOfObject);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     rZ
 * JD-Core Version:    0.7.0.1
 */