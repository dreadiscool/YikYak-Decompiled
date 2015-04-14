package butterknife.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ViewInjection
{
  private final int id;
  private final LinkedHashMap<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>> listenerBindings = new LinkedHashMap();
  private final Set<ViewBinding> viewBindings = new LinkedHashSet();
  
  ViewInjection(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void addListenerBinding(ListenerClass paramListenerClass, ListenerMethod paramListenerMethod, ListenerBinding paramListenerBinding)
  {
    Map localMap = (Map)this.listenerBindings.get(paramListenerClass);
    Object localObject1;
    if (localMap == null)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      this.listenerBindings.put(paramListenerClass, localLinkedHashMap);
      localObject1 = localLinkedHashMap;
    }
    Set localSet;
    for (Object localObject2 = null;; localObject2 = localSet)
    {
      if (localObject2 == null)
      {
        localObject2 = new LinkedHashSet();
        ((Map)localObject1).put(paramListenerMethod, localObject2);
      }
      ((Set)localObject2).add(paramListenerBinding);
      return;
      localSet = (Set)localMap.get(paramListenerMethod);
      localObject1 = localMap;
    }
  }
  
  public void addViewBinding(ViewBinding paramViewBinding)
  {
    this.viewBindings.add(paramViewBinding);
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Map<ListenerClass, Map<ListenerMethod, Set<ListenerBinding>>> getListenerBindings()
  {
    return this.listenerBindings;
  }
  
  public List<Binding> getRequiredBindings()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.viewBindings.iterator();
    while (localIterator1.hasNext())
    {
      ViewBinding localViewBinding = (ViewBinding)localIterator1.next();
      if (localViewBinding.isRequired()) {
        localArrayList.add(localViewBinding);
      }
    }
    Iterator localIterator2 = this.listenerBindings.values().iterator();
    if (localIterator2.hasNext())
    {
      Iterator localIterator3 = ((Map)localIterator2.next()).values().iterator();
      while (localIterator3.hasNext())
      {
        Iterator localIterator4 = ((Set)localIterator3.next()).iterator();
        while (localIterator4.hasNext())
        {
          ListenerBinding localListenerBinding = (ListenerBinding)localIterator4.next();
          if (localListenerBinding.isRequired()) {
            localArrayList.add(localListenerBinding);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public Collection<ViewBinding> getViewBindings()
  {
    return this.viewBindings;
  }
  
  public boolean hasListenerBinding(ListenerClass paramListenerClass, ListenerMethod paramListenerMethod)
  {
    Map localMap = (Map)this.listenerBindings.get(paramListenerClass);
    if ((localMap != null) && (localMap.containsKey(paramListenerMethod))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.internal.ViewInjection
 * JD-Core Version:    0.7.0.1
 */