package butterknife.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class ViewInjector
{
  private final String className;
  private final String classPackage;
  private final Map<CollectionBinding, int[]> collectionBindings = new LinkedHashMap();
  private String parentInjector;
  private final String targetClass;
  private final Map<Integer, ViewInjection> viewIdMap = new LinkedHashMap();
  
  ViewInjector(String paramString1, String paramString2, String paramString3)
  {
    this.classPackage = paramString1;
    this.className = paramString2;
    this.targetClass = paramString3;
  }
  
  private void emitCollectionBinding(StringBuilder paramStringBuilder, CollectionBinding paramCollectionBinding, int[] paramArrayOfInt)
  {
    paramStringBuilder.append("    target.").append(paramCollectionBinding.getName()).append(" = ");
    int i;
    label92:
    StringBuilder localStringBuilder;
    switch (ViewInjector.1.$SwitchMap$butterknife$internal$CollectionBinding$Kind[paramCollectionBinding.getKind().ordinal()])
    {
    default: 
      throw new IllegalStateException("Unknown kind: " + paramCollectionBinding.getKind());
    case 1: 
      paramStringBuilder.append("Finder.arrayOf(");
      i = 0;
      if (i >= paramArrayOfInt.length) {
        break label205;
      }
      if (i > 0) {
        paramStringBuilder.append(',');
      }
      localStringBuilder = paramStringBuilder.append("\n        finder.<").append(paramCollectionBinding.getType()).append(">");
      if (!paramCollectionBinding.isRequired()) {
        break;
      }
    }
    for (String str = "findRequiredView";; str = "findOptionalView")
    {
      localStringBuilder.append(str).append("(source, ").append(paramArrayOfInt[i]).append(", \"");
      emitHumanDescription(paramStringBuilder, Collections.singleton(paramCollectionBinding));
      paramStringBuilder.append("\")");
      i++;
      break label92;
      paramStringBuilder.append("Finder.listOf(");
      break;
    }
    label205:
    paramStringBuilder.append("\n    );\n");
  }
  
  static void emitHumanDescription(StringBuilder paramStringBuilder, Collection<? extends Binding> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    int i;
    int j;
    switch (paramCollection.size())
    {
    default: 
      i = paramCollection.size();
      j = 0;
    case 1: 
      while (j < i)
      {
        if (j != 0) {
          paramStringBuilder.append(", ");
        }
        if (j == i - 1) {
          paramStringBuilder.append("and ");
        }
        paramStringBuilder.append(((Binding)localIterator.next()).getDescription());
        j++;
        continue;
        paramStringBuilder.append(((Binding)localIterator.next()).getDescription());
      }
    }
    for (;;)
    {
      return;
      paramStringBuilder.append(((Binding)localIterator.next()).getDescription()).append(" and ").append(((Binding)localIterator.next()).getDescription());
    }
  }
  
  private void emitInject(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("  @Override ").append("public void inject(final Finder finder, final T target, Object source) {\n");
    if (this.parentInjector != null) {
      paramStringBuilder.append("    super.inject(finder, target, source);\n\n");
    }
    paramStringBuilder.append("    View view;\n");
    Iterator localIterator1 = this.viewIdMap.values().iterator();
    while (localIterator1.hasNext()) {
      emitViewInjection(paramStringBuilder, (ViewInjection)localIterator1.next());
    }
    Iterator localIterator2 = this.collectionBindings.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      emitCollectionBinding(paramStringBuilder, (CollectionBinding)localEntry.getKey(), (int[])localEntry.getValue());
    }
    paramStringBuilder.append("  }\n");
  }
  
  private void emitListenerBindings(StringBuilder paramStringBuilder, ViewInjection paramViewInjection)
  {
    Map localMap1 = paramViewInjection.getListenerBindings();
    if (localMap1.isEmpty()) {
      return;
    }
    boolean bool = paramViewInjection.getRequiredBindings().isEmpty();
    if (bool) {
      paramStringBuilder.append("    if (view != null) {\n");
    }
    for (String str = "  ";; str = "")
    {
      Iterator localIterator1 = localMap1.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        ListenerClass localListenerClass = (ListenerClass)localEntry.getKey();
        Map localMap2 = (Map)localEntry.getValue();
        if (!"android.view.View".equals(localListenerClass.targetType())) {}
        for (int i = 1;; i = 0)
        {
          paramStringBuilder.append(str).append("    ");
          if (i == 0) {
            break label230;
          }
          paramStringBuilder.append("((").append(localListenerClass.targetType());
          if (localListenerClass.genericArguments() <= 0) {
            break label223;
          }
          paramStringBuilder.append('<');
          for (int i3 = 0; i3 < localListenerClass.genericArguments(); i3++)
          {
            if (i3 > 0) {
              paramStringBuilder.append(", ");
            }
            paramStringBuilder.append('?');
          }
        }
        paramStringBuilder.append('>');
        label223:
        paramStringBuilder.append(") ");
        label230:
        paramStringBuilder.append("view");
        if (i != 0) {
          paramStringBuilder.append(')');
        }
        paramStringBuilder.append('.').append(localListenerClass.setter()).append("(\n");
        paramStringBuilder.append(str).append("      new ").append(localListenerClass.type()).append("() {\n");
        Iterator localIterator2 = getListenerMethods(localListenerClass).iterator();
        while (localIterator2.hasNext())
        {
          ListenerMethod localListenerMethod = (ListenerMethod)localIterator2.next();
          paramStringBuilder.append(str).append("        @Override public ").append(localListenerMethod.returnType()).append(' ').append(localListenerMethod.name()).append("(\n");
          String[] arrayOfString1 = localListenerMethod.parameters();
          int j = 0;
          int k = arrayOfString1.length;
          while (j < k)
          {
            paramStringBuilder.append(str).append("          ").append(arrayOfString1[j]).append(" p").append(j);
            if (j < k - 1) {
              paramStringBuilder.append(',');
            }
            paramStringBuilder.append('\n');
            j++;
          }
          paramStringBuilder.append(str).append("        ) {\n");
          paramStringBuilder.append(str).append("          ");
          int m;
          Iterator localIterator3;
          if (!"void".equals(localListenerMethod.returnType()))
          {
            m = 1;
            if (m != 0) {
              paramStringBuilder.append("return ");
            }
            if (localMap2.containsKey(localListenerMethod)) {
              localIterator3 = ((Set)localMap2.get(localListenerMethod)).iterator();
            }
          }
          else
          {
            for (;;)
            {
              if (!localIterator3.hasNext()) {
                break label844;
              }
              ListenerBinding localListenerBinding = (ListenerBinding)localIterator3.next();
              paramStringBuilder.append("target.").append(localListenerBinding.getName()).append('(');
              List localList = localListenerBinding.getParameters();
              String[] arrayOfString2 = localListenerMethod.parameters();
              int n = localList.size();
              int i1 = 0;
              label620:
              if (i1 < n)
              {
                Parameter localParameter = (Parameter)localList.get(i1);
                int i2 = localParameter.getListenerPosition();
                if (localParameter.requiresCast(arrayOfString2[i2])) {
                  paramStringBuilder.append("finder.<").append(localParameter.getType()).append(">castParam(p").append(i2).append(", \"").append(localListenerMethod.name()).append("\", ").append(i2).append(", \"").append(localListenerBinding.getName()).append("\", ").append(i1).append(")");
                }
                for (;;)
                {
                  if (i1 < n - 1) {
                    paramStringBuilder.append(", ");
                  }
                  i1++;
                  break label620;
                  m = 0;
                  break;
                  paramStringBuilder.append('p').append(i2);
                }
              }
              paramStringBuilder.append(");");
              if (localIterator3.hasNext()) {
                paramStringBuilder.append("\n").append("          ");
              }
            }
          }
          if (m != 0) {
            paramStringBuilder.append(localListenerMethod.defaultReturn()).append(';');
          }
          label844:
          paramStringBuilder.append('\n');
          paramStringBuilder.append(str).append("        }\n");
        }
        paramStringBuilder.append(str).append("      });\n");
      }
      if (!bool) {
        break;
      }
      paramStringBuilder.append("    }\n");
      break;
    }
  }
  
  private void emitReset(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("  @Override public void reset(T target) {\n");
    if (this.parentInjector != null) {
      paramStringBuilder.append("    super.reset(target);\n\n");
    }
    Iterator localIterator1 = this.viewIdMap.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator3 = ((ViewInjection)localIterator1.next()).getViewBindings().iterator();
      while (localIterator3.hasNext())
      {
        ViewBinding localViewBinding = (ViewBinding)localIterator3.next();
        paramStringBuilder.append("    target.").append(localViewBinding.getName()).append(" = null;\n");
      }
    }
    Iterator localIterator2 = this.collectionBindings.keySet().iterator();
    while (localIterator2.hasNext())
    {
      CollectionBinding localCollectionBinding = (CollectionBinding)localIterator2.next();
      paramStringBuilder.append("    target.").append(localCollectionBinding.getName()).append(" = null;\n");
    }
    paramStringBuilder.append("  }\n");
  }
  
  private void emitViewBindings(StringBuilder paramStringBuilder, ViewInjection paramViewInjection)
  {
    Collection localCollection = paramViewInjection.getViewBindings();
    if (localCollection.isEmpty()) {}
    for (;;)
    {
      return;
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        ViewBinding localViewBinding = (ViewBinding)localIterator.next();
        paramStringBuilder.append("    target.").append(localViewBinding.getName()).append(" = ");
        if (localViewBinding.requiresCast())
        {
          paramStringBuilder.append("finder.castView(view").append(", ").append(paramViewInjection.getId()).append(", \"");
          emitHumanDescription(paramStringBuilder, localCollection);
          paramStringBuilder.append("\");\n");
        }
        else
        {
          paramStringBuilder.append("view;\n");
        }
      }
    }
  }
  
  private void emitViewInjection(StringBuilder paramStringBuilder, ViewInjection paramViewInjection)
  {
    paramStringBuilder.append("    view = ");
    List localList = paramViewInjection.getRequiredBindings();
    if (localList.isEmpty()) {
      paramStringBuilder.append("finder.findOptionalView(source, ").append(paramViewInjection.getId()).append(", null);\n");
    }
    for (;;)
    {
      emitViewBindings(paramStringBuilder, paramViewInjection);
      emitListenerBindings(paramStringBuilder, paramViewInjection);
      return;
      if (paramViewInjection.getId() == -1)
      {
        paramStringBuilder.append("target;\n");
      }
      else
      {
        paramStringBuilder.append("finder.findRequiredView(source, ").append(paramViewInjection.getId()).append(", \"");
        emitHumanDescription(paramStringBuilder, localList);
        paramStringBuilder.append("\");\n");
      }
    }
  }
  
  static List<ListenerMethod> getListenerMethods(ListenerClass paramListenerClass)
  {
    if (paramListenerClass.method().length == 1) {}
    ArrayList localArrayList;
    for (Object localObject = Arrays.asList(paramListenerClass.method());; localObject = localArrayList)
    {
      return localObject;
      for (;;)
      {
        int j;
        ListenerMethod localListenerMethod;
        try
        {
          localArrayList = new ArrayList();
          Class localClass = paramListenerClass.callbacks();
          Enum[] arrayOfEnum = (Enum[])localClass.getEnumConstants();
          int i = arrayOfEnum.length;
          j = 0;
          if (j >= i) {
            break;
          }
          Enum localEnum = arrayOfEnum[j];
          localListenerMethod = (ListenerMethod)localClass.getField(localEnum.name()).getAnnotation(ListenerMethod.class);
          if (localListenerMethod == null)
          {
            Object[] arrayOfObject = new Object[4];
            arrayOfObject[0] = localClass.getEnclosingClass().getSimpleName();
            arrayOfObject[1] = localClass.getSimpleName();
            arrayOfObject[2] = localEnum.name();
            arrayOfObject[3] = ListenerMethod.class.getSimpleName();
            throw new IllegalStateException(String.format("@%s's %s.%s missing @%s annotation.", arrayOfObject));
          }
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          throw new AssertionError(localNoSuchFieldException);
        }
        localArrayList.add(localListenerMethod);
        j++;
      }
    }
  }
  
  private ViewInjection getOrCreateViewInjection(int paramInt)
  {
    ViewInjection localViewInjection = (ViewInjection)this.viewIdMap.get(Integer.valueOf(paramInt));
    if (localViewInjection == null)
    {
      localViewInjection = new ViewInjection(paramInt);
      this.viewIdMap.put(Integer.valueOf(paramInt), localViewInjection);
    }
    return localViewInjection;
  }
  
  void addCollection(int[] paramArrayOfInt, CollectionBinding paramCollectionBinding)
  {
    this.collectionBindings.put(paramCollectionBinding, paramArrayOfInt);
  }
  
  boolean addListener(int paramInt, ListenerClass paramListenerClass, ListenerMethod paramListenerMethod, ListenerBinding paramListenerBinding)
  {
    ViewInjection localViewInjection = getOrCreateViewInjection(paramInt);
    if ((localViewInjection.hasListenerBinding(paramListenerClass, paramListenerMethod)) && (!"void".equals(paramListenerMethod.returnType()))) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      localViewInjection.addListenerBinding(paramListenerClass, paramListenerMethod, paramListenerBinding);
    }
  }
  
  void addView(int paramInt, ViewBinding paramViewBinding)
  {
    getOrCreateViewInjection(paramInt).addViewBinding(paramViewBinding);
  }
  
  String brewJava()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("// Generated code from Butter Knife. Do not modify!\n");
    localStringBuilder.append("package ").append(this.classPackage).append(";\n\n");
    localStringBuilder.append("import android.view.View;\n");
    localStringBuilder.append("import butterknife.ButterKnife.Finder;\n");
    if (this.parentInjector == null) {
      localStringBuilder.append("import butterknife.ButterKnife.Injector;\n");
    }
    localStringBuilder.append('\n');
    localStringBuilder.append("public class ").append(this.className);
    localStringBuilder.append("<T extends ").append(this.targetClass).append(">");
    if (this.parentInjector != null) {
      localStringBuilder.append(" extends ").append(this.parentInjector).append("<T>");
    }
    for (;;)
    {
      localStringBuilder.append(" {\n");
      emitInject(localStringBuilder);
      localStringBuilder.append('\n');
      emitReset(localStringBuilder);
      localStringBuilder.append("}\n");
      return localStringBuilder.toString();
      localStringBuilder.append(" implements Injector<T>");
    }
  }
  
  String getFqcn()
  {
    return this.classPackage + "." + this.className;
  }
  
  ViewInjection getViewInjection(int paramInt)
  {
    return (ViewInjection)this.viewIdMap.get(Integer.valueOf(paramInt));
  }
  
  void setParentInjector(String paramString)
  {
    this.parentInjector = paramString;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.internal.ViewInjector
 * JD-Core Version:    0.7.0.1
 */