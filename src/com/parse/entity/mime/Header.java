package com.parse.entity.mime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Header
  implements Iterable<MinimalField>
{
  private final Map<String, List<MinimalField>> fieldMap = new HashMap();
  private final List<MinimalField> fields = new LinkedList();
  
  public void addField(MinimalField paramMinimalField)
  {
    if (paramMinimalField == null) {}
    for (;;)
    {
      return;
      String str = paramMinimalField.getName().toLowerCase(Locale.US);
      Object localObject = (List)this.fieldMap.get(str);
      if (localObject == null)
      {
        localObject = new LinkedList();
        this.fieldMap.put(str, localObject);
      }
      ((List)localObject).add(paramMinimalField);
      this.fields.add(paramMinimalField);
    }
  }
  
  public MinimalField getField(String paramString)
  {
    MinimalField localMinimalField;
    if (paramString == null) {
      localMinimalField = null;
    }
    for (;;)
    {
      return localMinimalField;
      String str = paramString.toLowerCase(Locale.US);
      List localList = (List)this.fieldMap.get(str);
      if ((localList != null) && (!localList.isEmpty())) {
        localMinimalField = (MinimalField)localList.get(0);
      } else {
        localMinimalField = null;
      }
    }
  }
  
  public List<MinimalField> getFields()
  {
    return new ArrayList(this.fields);
  }
  
  public List<MinimalField> getFields(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      String str = paramString.toLowerCase(Locale.US);
      List localList = (List)this.fieldMap.get(str);
      if ((localList == null) || (localList.isEmpty())) {
        localObject = Collections.emptyList();
      } else {
        localObject = new ArrayList(localList);
      }
    }
  }
  
  public Iterator<MinimalField> iterator()
  {
    return Collections.unmodifiableList(this.fields).iterator();
  }
  
  public int removeFields(String paramString)
  {
    int i;
    if (paramString == null) {
      i = 0;
    }
    for (;;)
    {
      return i;
      String str = paramString.toLowerCase(Locale.US);
      List localList = (List)this.fieldMap.remove(str);
      if ((localList == null) || (localList.isEmpty()))
      {
        i = 0;
      }
      else
      {
        this.fields.removeAll(localList);
        i = localList.size();
      }
    }
  }
  
  public void setField(MinimalField paramMinimalField)
  {
    if (paramMinimalField == null) {}
    for (;;)
    {
      return;
      String str = paramMinimalField.getName().toLowerCase(Locale.US);
      List localList = (List)this.fieldMap.get(str);
      if ((localList == null) || (localList.isEmpty()))
      {
        addField(paramMinimalField);
      }
      else
      {
        localList.clear();
        localList.add(paramMinimalField);
        Iterator localIterator = this.fields.iterator();
        int i = 0;
        int j = -1;
        while (localIterator.hasNext())
        {
          if (((MinimalField)localIterator.next()).getName().equalsIgnoreCase(paramMinimalField.getName()))
          {
            localIterator.remove();
            if (j == -1) {
              j = i;
            }
          }
          i++;
        }
        this.fields.add(j, paramMinimalField);
      }
    }
  }
  
  public String toString()
  {
    return this.fields.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.entity.mime.Header
 * JD-Core Version:    0.7.0.1
 */