import java.util.Iterator;
import java.util.List;

class aM
  extends Jf
{
  private final float b;
  
  aM(aK paramaK, float paramFloat)
  {
    this.b = paramFloat;
  }
  
  private void b()
  {
    IC.g();
    new StringBuilder().append("Starting report processing in ").append(this.b).append(" second(s)...").toString();
    if (this.b > 0.0F) {}
    label407:
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        Thread.sleep((1000.0F * this.b));
        localG = G.f();
        Y localY = localG.m();
        localList1 = this.a.a();
        if (localY.a()) {
          return;
        }
      }
      catch (InterruptedException localInterruptedException2)
      {
        G localG;
        List localList1;
        Thread.currentThread().interrupt();
        continue;
        if ((!localList1.isEmpty()) && (!localG.x()))
        {
          IC.g();
          new StringBuilder().append("User declined to send. Removing ").append(localList1.size()).append(" Report(s).").toString();
          Iterator localIterator2 = localList1.iterator();
          if (!localIterator2.hasNext()) {
            continue;
          }
          ((aJ)localIterator2.next()).a();
          continue;
        }
        localObject = localList1;
        i = 0;
      }
      for (;;)
      {
        if ((((List)localObject).isEmpty()) || (G.f().m().a())) {
          break label407;
        }
        IC.g();
        new StringBuilder().append("Attempting to send ").append(((List)localObject).size()).append(" report(s)").toString();
        Iterator localIterator1 = ((List)localObject).iterator();
        while (localIterator1.hasNext())
        {
          aJ localaJ = (aJ)localIterator1.next();
          this.a.a(localaJ);
        }
        List localList2 = this.a.a();
        if (!localList2.isEmpty())
        {
          short[] arrayOfShort = aK.b();
          int j = i + 1;
          long l1 = arrayOfShort[java.lang.Math.min(i, -1 + aK.b().length)];
          IC.g();
          new StringBuilder().append("Report submisson: scheduling delayed retry in ").append(l1).append(" seconds").toString();
          long l2 = l1 * 1000L;
          try
          {
            Thread.sleep(l2);
            i = j;
            localObject = localList2;
          }
          catch (InterruptedException localInterruptedException1)
          {
            Thread.currentThread().interrupt();
          }
          break;
        }
        localObject = localList2;
      }
    }
  }
  
  public void a()
  {
    try
    {
      b();
      aK.a(this.a, null);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IC.g();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     aM
 * JD-Core Version:    0.7.0.1
 */