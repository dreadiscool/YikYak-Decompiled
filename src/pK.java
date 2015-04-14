import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class pK
  implements Cloneable, pn
{
  public static final pK a = new pK();
  private double b = -1.0D;
  private int c = 136;
  private boolean d = true;
  private boolean e;
  private List<oI> f = Collections.emptyList();
  private List<oI> g = Collections.emptyList();
  
  private boolean a(Class<?> paramClass)
  {
    if ((!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(pq parampq)
  {
    if ((parampq != null) && (parampq.a() > this.b)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private boolean a(pq parampq, pr parampr)
  {
    if ((a(parampq)) && (a(parampr))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(pr parampr)
  {
    if ((parampr != null) && (parampr.a() <= this.b)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private boolean b(Class<?> paramClass)
  {
    if ((paramClass.isMemberClass()) && (!c(paramClass))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean c(Class<?> paramClass)
  {
    if ((0x8 & paramClass.getModifiers()) != 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected pK a()
  {
    try
    {
      pK localpK = (pK)super.clone();
      return localpK;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError();
    }
  }
  
  public <T> pm<T> a(oR paramoR, rn<T> paramrn)
  {
    Class localClass = paramrn.a();
    boolean bool1 = a(localClass, true);
    boolean bool2 = a(localClass, false);
    if ((!bool1) && (!bool2)) {}
    for (Object localObject = null;; localObject = new pL(this, bool2, bool1, paramoR, paramrn)) {
      return localObject;
    }
  }
  
  public boolean a(Class<?> paramClass, boolean paramBoolean)
  {
    boolean bool;
    if ((this.b != -1.0D) && (!a((pq)paramClass.getAnnotation(pq.class), (pr)paramClass.getAnnotation(pr.class)))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((!this.d) && (b(paramClass)))
      {
        bool = true;
      }
      else if (a(paramClass))
      {
        bool = true;
      }
      else
      {
        if (paramBoolean) {}
        for (List localList = this.f;; localList = this.g)
        {
          Iterator localIterator = localList.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!((oI)localIterator.next()).a(paramClass));
          bool = true;
          break;
        }
        bool = false;
      }
    }
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    boolean bool;
    if ((this.c & paramField.getModifiers()) != 0) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((this.b != -1.0D) && (!a((pq)paramField.getAnnotation(pq.class), (pr)paramField.getAnnotation(pr.class)))) {
        bool = true;
      } else {
        label116:
        label247:
        if (paramField.isSynthetic())
        {
          bool = true;
        }
        else
        {
          if (this.e)
          {
            po localpo = (po)paramField.getAnnotation(po.class);
            if (localpo != null)
            {
              if (!paramBoolean) {
                break label116;
              }
              if (localpo.a()) {
                break label126;
              }
            }
            while (!localpo.b())
            {
              bool = true;
              break;
            }
          }
          label126:
          if ((!this.d) && (b(paramField.getType())))
          {
            bool = true;
          }
          else if (a(paramField.getType()))
          {
            bool = true;
          }
          else
          {
            if (paramBoolean) {}
            for (List localList = this.f;; localList = this.g)
            {
              if (localList.isEmpty()) {
                break label247;
              }
              oJ localoJ = new oJ(paramField);
              Iterator localIterator = localList.iterator();
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
              } while (!((oI)localIterator.next()).a(localoJ));
              bool = true;
              break;
            }
            bool = false;
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pK
 * JD-Core Version:    0.7.0.1
 */