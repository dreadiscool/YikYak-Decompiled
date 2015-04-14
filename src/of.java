import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class of
{
  private static final nU<hf> a = new nU(ot.a(), true);
  private final nD b;
  private final Map<String, nE> c;
  private final Map<String, nE> d;
  private final Map<String, nE> e;
  private final ow<oc, nU<hf>> f;
  private final ow<String, oj> g;
  private final Set<od> h;
  private final no i;
  private final Map<String, ok> j;
  private volatile String k;
  private int l;
  
  private String a()
  {
    if (this.l <= 1) {}
    StringBuilder localStringBuilder;
    for (String str = "";; str = localStringBuilder.toString())
    {
      return str;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.toString(this.l));
      for (int m = 2; m < this.l; m++) {
        localStringBuilder.append(' ');
      }
      localStringBuilder.append(": ");
    }
  }
  
  private nU<hf> a(hf paramhf, Set<String> paramSet, ou paramou)
  {
    nU localnU1;
    if (!paramhf.l) {
      localnU1 = new nU(paramhf, true);
    }
    for (;;)
    {
      return localnU1;
      switch (paramhf.a)
      {
      case 5: 
      case 6: 
      default: 
        nK.a("Unknown type: " + paramhf.a);
        localnU1 = a;
        break;
      case 2: 
        hf localhf3 = ob.a(paramhf);
        localhf3.c = new hf[paramhf.c.length];
        for (int i1 = 0;; i1++)
        {
          if (i1 >= paramhf.c.length) {
            break label189;
          }
          nU localnU5 = a(paramhf.c[i1], paramSet, paramou.a(i1));
          if (localnU5 == a)
          {
            localnU1 = a;
            break;
          }
          localhf3.c[i1] = ((hf)localnU5.a());
        }
        localnU1 = new nU(localhf3, false);
        break;
      case 3: 
        hf localhf2 = ob.a(paramhf);
        if (paramhf.d.length != paramhf.e.length)
        {
          nK.a("Invalid serving value: " + paramhf.toString());
          localnU1 = a;
        }
        else
        {
          localhf2.d = new hf[paramhf.d.length];
          localhf2.e = new hf[paramhf.d.length];
          for (int n = 0;; n++)
          {
            if (n >= paramhf.d.length) {
              break label401;
            }
            nU localnU3 = a(paramhf.d[n], paramSet, paramou.b(n));
            nU localnU4 = a(paramhf.e[n], paramSet, paramou.c(n));
            if ((localnU3 == a) || (localnU4 == a))
            {
              localnU1 = a;
              break;
            }
            localhf2.d[n] = ((hf)localnU3.a());
            localhf2.e[n] = ((hf)localnU4.a());
          }
          localnU1 = new nU(localhf2, false);
        }
        break;
      case 4: 
        if (paramSet.contains(paramhf.f))
        {
          nK.a("Macro cycle detected.  Current macro reference: " + paramhf.f + "." + "  Previous macro references: " + paramSet.toString() + ".");
          localnU1 = a;
        }
        else
        {
          paramSet.add(paramhf.f);
          localnU1 = ov.a(a(paramhf.f, paramSet, paramou.a()), paramhf.k);
          paramSet.remove(paramhf.f);
        }
        break;
      case 7: 
        label189:
        hf localhf1 = ob.a(paramhf);
        label401:
        localhf1.j = new hf[paramhf.j.length];
        for (int m = 0;; m++)
        {
          if (m >= paramhf.j.length) {
            break label625;
          }
          nU localnU2 = a(paramhf.j[m], paramSet, paramou.d(m));
          if (localnU2 == a)
          {
            localnU1 = a;
            break;
          }
          localhf1.j[m] = ((hf)localnU2.a());
        }
        label625:
        localnU1 = new nU(localhf1, false);
      }
    }
  }
  
  private nU<hf> a(String paramString, Set<String> paramSet, nM paramnM)
  {
    this.l = (1 + this.l);
    oj localoj = (oj)this.g.a(paramString);
    if ((localoj != null) && (!this.b.a()))
    {
      a(localoj.b(), paramSet);
      this.l = (-1 + this.l);
    }
    ok localok;
    for (nU localnU3 = localoj.a();; localnU3 = a)
    {
      return localnU3;
      localok = (ok)this.j.get(paramString);
      if (localok != null) {
        break;
      }
      nK.a(a() + "Invalid macro: " + paramString);
      this.l = (-1 + this.l);
    }
    nU localnU1 = a(paramString, localok.a(), localok.b(), localok.c(), localok.e(), localok.d(), paramSet, paramnM.b());
    if (((Set)localnU1.a()).isEmpty()) {}
    for (oc localoc = localok.f();; localoc = (oc)((Set)localnU1.a()).iterator().next())
    {
      if (localoc != null) {
        break label299;
      }
      this.l = (-1 + this.l);
      localnU3 = a;
      break;
      if (((Set)localnU1.a()).size() > 1) {
        nK.b(a() + "Multiple macros active for macroName " + paramString);
      }
    }
    label299:
    nU localnU2 = a(this.e, localoc, paramSet, paramnM.a());
    boolean bool;
    if ((localnU1.b()) && (localnU2.b()))
    {
      bool = true;
      label337:
      if (localnU2 != a) {
        break label404;
      }
    }
    label404:
    for (localnU3 = a;; localnU3 = new nU(localnU2.a(), bool))
    {
      hf localhf = localoc.b();
      if (localnU3.b()) {
        new oj(localnU3, localhf);
      }
      a(localhf, paramSet);
      this.l = (-1 + this.l);
      break;
      bool = false;
      break label337;
    }
  }
  
  private nU<hf> a(Map<String, nE> paramMap, oc paramoc, Set<String> paramSet, nX paramnX)
  {
    boolean bool1 = true;
    hf localhf = (hf)paramoc.a().get(hd.aL.toString());
    nU localnU1;
    if (localhf == null)
    {
      nK.a("No function id in properties");
      localnU1 = a;
    }
    nE localnE;
    HashMap localHashMap;
    boolean bool2;
    for (;;)
    {
      return localnU1;
      String str = localhf.g;
      localnE = (nE)paramMap.get(str);
      if (localnE == null)
      {
        nK.a(str + " has no backing implementation.");
        localnU1 = a;
      }
      else
      {
        localnU1 = (nU)this.f.a(paramoc);
        if ((localnU1 == null) || (this.b.a()))
        {
          localHashMap = new HashMap();
          Iterator localIterator = paramoc.a().entrySet().iterator();
          bool2 = bool1;
          if (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            nZ localnZ = paramnX.a((String)localEntry.getKey());
            nU localnU2 = a((hf)localEntry.getValue(), paramSet, localnZ.a((hf)localEntry.getValue()));
            if (localnU2 == a)
            {
              localnU1 = a;
            }
            else
            {
              if (localnU2.b()) {
                paramoc.a((String)localEntry.getKey(), (hf)localnU2.a());
              }
              for (boolean bool3 = bool2;; bool3 = false)
              {
                localHashMap.put(localEntry.getKey(), localnU2.a());
                bool2 = bool3;
                break;
              }
            }
          }
          else
          {
            if (localnE.a(localHashMap.keySet())) {
              break;
            }
            nK.a("Incorrect keys for function " + str + " required " + localnE.b() + " had " + localHashMap.keySet());
            localnU1 = a;
          }
        }
      }
    }
    if ((bool2) && (localnE.a())) {}
    for (;;)
    {
      localnU1 = new nU(localnE.a(localHashMap), bool1);
      break;
      bool1 = false;
    }
  }
  
  private nU<Set<oc>> a(Set<od> paramSet, Set<String> paramSet1, oi paramoi, oe paramoe)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Iterator localIterator = paramSet.iterator();
    boolean bool1 = true;
    if (localIterator.hasNext())
    {
      od localod = (od)localIterator.next();
      oa localoa = paramoe.a();
      nU localnU = a(localod, paramSet1, localoa);
      if (((Boolean)localnU.a()).booleanValue()) {
        paramoi.a(localod, localHashSet1, localHashSet2, localoa);
      }
      if ((bool1) && (localnU.b())) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    return new nU(localHashSet1, bool1);
  }
  
  private void a(hf paramhf, Set<String> paramSet)
  {
    if (paramhf == null) {}
    for (;;)
    {
      return;
      nU localnU = a(paramhf, paramSet, new nT());
      if (localnU != a)
      {
        Object localObject1 = ot.c((hf)localnU.a());
        if ((localObject1 instanceof Map))
        {
          Map localMap2 = (Map)localObject1;
          this.i.a(localMap2);
        }
        else if ((localObject1 instanceof List))
        {
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = localIterator.next();
            if ((localObject2 instanceof Map))
            {
              Map localMap1 = (Map)localObject2;
              this.i.a(localMap1);
            }
            else
            {
              nK.b("pushAfterEvaluate: value not a Map");
            }
          }
        }
        else
        {
          nK.b("pushAfterEvaluate: value not a Map or List");
        }
      }
    }
  }
  
  nU<Set<oc>> a(String paramString, Set<od> paramSet, Map<od, List<oc>> paramMap1, Map<od, List<String>> paramMap2, Map<od, List<oc>> paramMap3, Map<od, List<String>> paramMap4, Set<String> paramSet1, oe paramoe)
  {
    return a(paramSet, paramSet1, new og(this, paramMap1, paramMap2, paramMap3, paramMap4), paramoe);
  }
  
  nU<Set<oc>> a(Set<od> paramSet, oe paramoe)
  {
    return a(paramSet, new HashSet(), new oh(this), paramoe);
  }
  
  nU<Boolean> a(oc paramoc, Set<String> paramSet, nX paramnX)
  {
    nU localnU = a(this.d, paramoc, paramSet, paramnX);
    Boolean localBoolean = ot.b((hf)localnU.a());
    ot.c(localBoolean);
    return new nU(localBoolean, localnU.b());
  }
  
  nU<Boolean> a(od paramod, Set<String> paramSet, oa paramoa)
  {
    Iterator localIterator1 = paramod.b().iterator();
    boolean bool1 = true;
    nU localnU3;
    nU localnU1;
    if (localIterator1.hasNext())
    {
      localnU3 = a((oc)localIterator1.next(), paramSet, paramoa.a());
      if (((Boolean)localnU3.a()).booleanValue())
      {
        ot.c(Boolean.valueOf(false));
        localnU1 = new nU(Boolean.valueOf(false), localnU3.b());
      }
    }
    for (;;)
    {
      return localnU1;
      if ((bool1) && (localnU3.b())) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        break;
      }
      Iterator localIterator2 = paramod.a().iterator();
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label231;
        }
        nU localnU2 = a((oc)localIterator2.next(), paramSet, paramoa.b());
        if (!((Boolean)localnU2.a()).booleanValue())
        {
          ot.c(Boolean.valueOf(false));
          localnU1 = new nU(Boolean.valueOf(false), localnU2.b());
          break;
        }
        if ((bool1) && (localnU2.b())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      label231:
      ot.c(Boolean.valueOf(true));
      localnU1 = new nU(Boolean.valueOf(true), bool1);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      b(paramString);
      oB localoB = this.b.a(paramString).a();
      Iterator localIterator = ((Set)a(this.h, localoB.b()).a()).iterator();
      while (localIterator.hasNext())
      {
        oc localoc = (oc)localIterator.next();
        a(this.c, localoc, new HashSet(), localoB.a());
      }
      b(null);
    }
    finally {}
  }
  
  void b(String paramString)
  {
    try
    {
      this.k = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     of
 * JD-Core Version:    0.7.0.1
 */