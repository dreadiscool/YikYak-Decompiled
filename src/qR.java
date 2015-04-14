import java.util.BitSet;

final class qR
  extends pm<BitSet>
{
  public BitSet a(ro paramro)
  {
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    BitSet localBitSet;
    for (Object localObject = null;; localObject = localBitSet)
    {
      return localObject;
      localBitSet = new BitSet();
      paramro.a();
      rq localrq = paramro.f();
      int i = 0;
      if (localrq != rq.b)
      {
        boolean bool;
        switch (rf.a[localrq.ordinal()])
        {
        default: 
          throw new pi("Invalid bitset value type: " + localrq);
        case 1: 
          if (paramro.m() != 0) {
            bool = true;
          }
          break;
        }
        for (;;)
        {
          if (bool) {
            localBitSet.set(i);
          }
          i++;
          localrq = paramro.f();
          break;
          bool = false;
          continue;
          bool = paramro.i();
          continue;
          String str = paramro.h();
          try
          {
            int j = Integer.parseInt(str);
            if (j != 0) {
              bool = true;
            } else {
              bool = false;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            throw new pi("Error: Expecting: bitset number value (1, 0), Found: " + str);
          }
        }
      }
      paramro.b();
    }
  }
  
  public void a(rr paramrr, BitSet paramBitSet)
  {
    if (paramBitSet == null) {
      paramrr.f();
    }
    for (;;)
    {
      return;
      paramrr.b();
      int i = 0;
      if (i < paramBitSet.length())
      {
        if (paramBitSet.get(i)) {}
        for (int j = 1;; j = 0)
        {
          paramrr.a(j);
          i++;
          break;
        }
      }
      paramrr.c();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qR
 * JD-Core Version:    0.7.0.1
 */