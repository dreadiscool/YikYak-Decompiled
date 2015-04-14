import java.io.Serializable;

public abstract class sl
  extends rS
  implements Serializable
{
  protected sl() {}
  
  protected sl(sn paramsn) {}
  
  private static <MessageType extends sE> boolean b(si<sr> paramsi, MessageType paramMessageType, sc paramsc, se paramse, sg paramsg, int paramInt)
  {
    int i = tc.a(paramInt);
    ss localss = paramsg.a(paramMessageType, tc.b(paramInt));
    int j;
    int k;
    if (localss == null)
    {
      j = 0;
      k = 1;
    }
    boolean bool;
    while (k != 0)
    {
      bool = paramsc.a(paramInt, paramse);
      return bool;
      if (i == si.a(localss.b.a(), false))
      {
        j = 0;
        k = 0;
      }
      else if ((localss.b.d) && (localss.b.c.d()) && (i == si.a(localss.b.a(), true)))
      {
        j = 1;
        k = 0;
      }
      else
      {
        j = 0;
        k = 1;
      }
    }
    if (j != 0)
    {
      int n = paramsc.c(paramsc.s());
      if (localss.b.a() == te.n) {
        for (;;)
        {
          if (paramsc.w() <= 0) {
            break label259;
          }
          int i1 = paramsc.n();
          sv localsv = localss.b.e().b(i1);
          if (localsv == null)
          {
            bool = true;
            break;
          }
          paramsi.b(localss.b, localss.a(localsv));
        }
      }
      while (paramsc.w() > 0)
      {
        Object localObject2 = si.a(paramsc, localss.b.a(), false);
        paramsi.b(localss.b, localObject2);
      }
      label259:
      paramsc.d(n);
    }
    label265:
    Object localObject1;
    for (;;)
    {
      bool = true;
      break;
      switch (sm.a[localss.b.b().ordinal()])
      {
      default: 
        localObject1 = si.a(paramsc, localss.b.a(), false);
        label323:
        if (!localss.b.c()) {
          break label505;
        }
        paramsi.b(localss.b, localss.a(localObject1));
      }
    }
    sE localsE;
    if (!localss.b.c())
    {
      localsE = (sE)paramsi.a(localss.b);
      if (localsE == null) {}
    }
    for (sF localsF = localsE.n();; localsF = null)
    {
      if (localsF == null) {
        localsF = localss.b().o();
      }
      if (localss.b.a() == te.j) {
        paramsc.a(localss.a(), localsF, paramsg);
      }
      for (;;)
      {
        localObject1 = localsF.h();
        break;
        paramsc.a(localsF, paramsg);
      }
      int m = paramsc.n();
      localObject1 = localss.b.e().b(m);
      if (localObject1 != null) {
        break label323;
      }
      paramse.d(paramInt);
      paramse.b(m);
      bool = true;
      break;
      label505:
      paramsi.a(localss.b, localss.a(localObject1));
      break label265;
    }
  }
  
  protected void R() {}
  
  protected boolean a(sc paramsc, se paramse, sg paramsg, int paramInt)
  {
    return paramsc.a(paramInt, paramse);
  }
  
  public sI<? extends sE> c()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     sl
 * JD-Core Version:    0.7.0.1
 */