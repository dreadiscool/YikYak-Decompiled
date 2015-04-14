import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class sL
{
  private final Deque<rZ> a = new ArrayDeque(sJ.b().length);
  
  private int a(int paramInt)
  {
    int i = Arrays.binarySearch(sJ.b(), paramInt);
    if (i < 0) {
      i = -1 + -(i + 1);
    }
    return i;
  }
  
  private rZ a(rZ paramrZ1, rZ paramrZ2)
  {
    a(paramrZ1);
    a(paramrZ2);
    for (Object localObject = (rZ)this.a.pop(); !this.a.isEmpty(); localObject = new sJ((rZ)this.a.pop(), (rZ)localObject, null)) {}
    return localObject;
  }
  
  private void a(rZ paramrZ)
  {
    if (paramrZ.k()) {
      b(paramrZ);
    }
    for (;;)
    {
      return;
      if (!(paramrZ instanceof sJ)) {
        break;
      }
      sJ localsJ = (sJ)paramrZ;
      a(sJ.a(localsJ));
      a(sJ.b(localsJ));
    }
    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + paramrZ.getClass());
  }
  
  private void b(rZ paramrZ)
  {
    int i = a(paramrZ.a());
    int j = sJ.b()[(i + 1)];
    if ((this.a.isEmpty()) || (((rZ)this.a.peek()).a() >= j)) {
      this.a.push(paramrZ);
    }
    for (;;)
    {
      return;
      int k = sJ.b()[i];
      for (Object localObject = (rZ)this.a.pop(); (!this.a.isEmpty()) && (((rZ)this.a.peek()).a() < k); localObject = new sJ((rZ)this.a.pop(), (rZ)localObject, null)) {}
      for (sJ localsJ = new sJ((rZ)localObject, paramrZ, null); !this.a.isEmpty(); localsJ = new sJ((rZ)this.a.pop(), localsJ, null))
      {
        int m = a(localsJ.a());
        int n = sJ.b()[(m + 1)];
        if (((rZ)this.a.peek()).a() >= n) {
          break;
        }
      }
      this.a.push(localsJ);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sL
 * JD-Core Version:    0.7.0.1
 */