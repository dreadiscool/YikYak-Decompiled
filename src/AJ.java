import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class AJ
  implements AL
{
  private static final List<LE> a;
  private static final List<LE> b;
  private final Ax c;
  private final Br d;
  private BD e;
  
  static
  {
    LE[] arrayOfLE1 = new LE[5];
    arrayOfLE1[0] = LE.a("connection");
    arrayOfLE1[1] = LE.a("host");
    arrayOfLE1[2] = LE.a("keep-alive");
    arrayOfLE1[3] = LE.a("proxy-connection");
    arrayOfLE1[4] = LE.a("transfer-encoding");
    a = Ae.a(arrayOfLE1);
    LE[] arrayOfLE2 = new LE[8];
    arrayOfLE2[0] = LE.a("connection");
    arrayOfLE2[1] = LE.a("host");
    arrayOfLE2[2] = LE.a("keep-alive");
    arrayOfLE2[3] = LE.a("proxy-connection");
    arrayOfLE2[4] = LE.a("te");
    arrayOfLE2[5] = LE.a("transfer-encoding");
    arrayOfLE2[6] = LE.a("encoding");
    arrayOfLE2[7] = LE.a("upgrade");
    b = Ae.a(arrayOfLE2);
  }
  
  public AJ(Ax paramAx, Br paramBr)
  {
    this.c = paramAx;
    this.d = paramBr;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }
  
  public static List<AT> a(zz paramzz, zy paramzy, String paramString)
  {
    zo localzo = paramzz.e();
    ArrayList localArrayList = new ArrayList(10 + localzo.a());
    localArrayList.add(new AT(AT.b, paramzz.d()));
    localArrayList.add(new AT(AT.c, AG.a(paramzz.a())));
    String str1 = Ax.a(paramzz.a());
    LinkedHashSet localLinkedHashSet;
    int j;
    label166:
    LE localLE;
    String str2;
    if (zy.c == paramzy)
    {
      localArrayList.add(new AT(AT.g, paramString));
      localArrayList.add(new AT(AT.f, str1));
      localArrayList.add(new AT(AT.d, paramzz.a().getProtocol()));
      localLinkedHashSet = new LinkedHashSet();
      int i = localzo.a();
      j = 0;
      if (j >= i) {
        break label440;
      }
      localLE = LE.a(localzo.a(j).toLowerCase(Locale.US));
      str2 = localzo.b(j);
      if (!a(paramzy, localLE)) {
        break label251;
      }
    }
    label438:
    for (;;)
    {
      j++;
      break label166;
      if (zy.d == paramzy)
      {
        localArrayList.add(new AT(AT.e, str1));
        break;
      }
      throw new AssertionError();
      label251:
      if ((!localLE.equals(AT.b)) && (!localLE.equals(AT.c)) && (!localLE.equals(AT.d)) && (!localLE.equals(AT.e)) && (!localLE.equals(AT.f)) && (!localLE.equals(AT.g))) {
        if (localLinkedHashSet.add(localLE)) {
          localArrayList.add(new AT(localLE, str2));
        } else {
          for (int k = 0;; k++)
          {
            if (k >= localArrayList.size()) {
              break label438;
            }
            if (((AT)localArrayList.get(k)).h.equals(localLE))
            {
              localArrayList.set(k, new AT(localLE, a(((AT)localArrayList.get(k)).i.a(), str2)));
              break;
            }
          }
        }
      }
    }
    label440:
    return localArrayList;
  }
  
  public static zH a(List<AT> paramList, zy paramzy)
  {
    Object localObject1 = null;
    Object localObject2 = "HTTP/1.1";
    zq localzq = new zq();
    localzq.b(AD.d, paramzy.toString());
    int i = paramList.size();
    int j = 0;
    while (j < i)
    {
      LE localLE = ((AT)paramList.get(j)).h;
      String str = ((AT)paramList.get(j)).i.a();
      Object localObject3 = localObject2;
      int k = 0;
      if (k < str.length())
      {
        int m = str.indexOf(0, k);
        if (m == -1) {
          m = str.length();
        }
        Object localObject4 = str.substring(k, m);
        if (localLE.equals(AT.a)) {}
        for (;;)
        {
          int n = m + 1;
          localObject1 = localObject4;
          k = n;
          break;
          if (localLE.equals(AT.g))
          {
            localObject3 = localObject4;
            localObject4 = localObject1;
          }
          else
          {
            if (!a(paramzy, localLE)) {
              localzq.a(localLE.a(), (String)localObject4);
            }
            localObject4 = localObject1;
          }
        }
      }
      j++;
      localObject2 = localObject3;
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    AK localAK = AK.a((String)localObject2 + " " + localObject1);
    return new zH().a(paramzy).a(localAK.b).a(localAK.c).a(localzq.a());
  }
  
  private static boolean a(zy paramzy, LE paramLE)
  {
    if (paramzy == zy.c) {}
    for (boolean bool = a.contains(paramLE);; bool = b.contains(paramLE))
    {
      return bool;
      if (paramzy != zy.d) {
        break;
      }
    }
    throw new AssertionError(paramzy);
  }
  
  public LU a(zz paramzz, long paramLong)
  {
    return this.e.g();
  }
  
  public zI a(zF paramzF)
  {
    return new AF(paramzF.g(), LK.a(this.e.f()));
  }
  
  public void a()
  {
    this.e.g().close();
  }
  
  public void a(AH paramAH)
  {
    paramAH.a(this.e.g());
  }
  
  public void a(Ax paramAx)
  {
    if (this.e != null) {
      this.e.a(AP.l);
    }
  }
  
  public void a(zz paramzz)
  {
    if (this.e != null) {}
    for (;;)
    {
      return;
      this.c.b();
      boolean bool = this.c.c();
      String str = AG.a(this.c.i().l());
      this.e = this.d.a(a(paramzz, this.d.a(), str), bool, true);
      this.e.e().a(this.c.a.b(), TimeUnit.MILLISECONDS);
    }
  }
  
  public zH b()
  {
    return a(this.e.d(), this.d.a());
  }
  
  public void c() {}
  
  public boolean d()
  {
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AJ
 * JD-Core Version:    0.7.0.1
 */