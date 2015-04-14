package butterknife.internal;

import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnItemSelected;
import butterknife.OnLongClick;
import butterknife.OnPageChange;
import butterknife.OnTextChanged;
import butterknife.OnTouch;
import butterknife.Optional;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

public final class ButterKnifeProcessor
  extends AbstractProcessor
{
  public static final String ANDROID_PREFIX = "android.";
  public static final String JAVA_PREFIX = "java.";
  private static final List<Class<? extends Annotation>> LISTENERS;
  private static final String LIST_TYPE;
  public static final String SUFFIX = "$$ViewInjector";
  static final String VIEW_TYPE = "android.view.View";
  private Elements elementUtils;
  private Filer filer;
  private Types typeUtils;
  
  static
  {
    if (!ButterKnifeProcessor.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LIST_TYPE = List.class.getCanonicalName();
      Class[] arrayOfClass = new Class[11];
      arrayOfClass[0] = OnCheckedChanged.class;
      arrayOfClass[1] = OnClick.class;
      arrayOfClass[2] = OnEditorAction.class;
      arrayOfClass[3] = OnFocusChange.class;
      arrayOfClass[4] = OnItemClick.class;
      arrayOfClass[5] = OnItemLongClick.class;
      arrayOfClass[6] = OnItemSelected.class;
      arrayOfClass[7] = OnLongClick.class;
      arrayOfClass[8] = OnPageChange.class;
      arrayOfClass[9] = OnTextChanged.class;
      arrayOfClass[10] = OnTouch.class;
      LISTENERS = Arrays.asList(arrayOfClass);
      return;
    }
  }
  
  private String doubleErasure(TypeMirror paramTypeMirror)
  {
    String str = this.typeUtils.erasure(paramTypeMirror).toString();
    int i = str.indexOf('<');
    if (i != -1) {
      str = str.substring(0, i);
    }
    return str;
  }
  
  private void error(Element paramElement, String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length > 0) {
      paramString = String.format(paramString, paramVarArgs);
    }
    this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, paramString, paramElement);
  }
  
  private void findAndParseListener(RoundEnvironment paramRoundEnvironment, Class<? extends Annotation> paramClass, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
  {
    Iterator localIterator = paramRoundEnvironment.getElementsAnnotatedWith(paramClass).iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      try
      {
        parseListenerAnnotation(paramClass, localElement, paramMap, paramSet);
      }
      catch (Exception localException)
      {
        StringWriter localStringWriter = new StringWriter();
        localException.printStackTrace(new PrintWriter(localStringWriter));
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramClass.getSimpleName();
        arrayOfObject[1] = localStringWriter.toString();
        error(localElement, "Unable to generate view injector for @%s.\n\n%s", arrayOfObject);
      }
    }
  }
  
  private Map<TypeElement, ViewInjector> findAndParseTargets(RoundEnvironment paramRoundEnvironment)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator1 = paramRoundEnvironment.getElementsAnnotatedWith(InjectView.class).iterator();
    while (localIterator1.hasNext())
    {
      Element localElement2 = (Element)localIterator1.next();
      try
      {
        parseInjectView(localElement2, localLinkedHashMap, localLinkedHashSet);
      }
      catch (Exception localException2)
      {
        StringWriter localStringWriter2 = new StringWriter();
        localException2.printStackTrace(new PrintWriter(localStringWriter2));
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localStringWriter2;
        error(localElement2, "Unable to generate view injector for @InjectView.\n\n%s", arrayOfObject2);
      }
    }
    Iterator localIterator2 = paramRoundEnvironment.getElementsAnnotatedWith(InjectViews.class).iterator();
    while (localIterator2.hasNext())
    {
      Element localElement1 = (Element)localIterator2.next();
      try
      {
        parseInjectViews(localElement1, localLinkedHashMap, localLinkedHashSet);
      }
      catch (Exception localException1)
      {
        StringWriter localStringWriter1 = new StringWriter();
        localException1.printStackTrace(new PrintWriter(localStringWriter1));
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = localStringWriter1;
        error(localElement1, "Unable to generate view injector for @InjectViews.\n\n%s", arrayOfObject1);
      }
    }
    Iterator localIterator3 = LISTENERS.iterator();
    while (localIterator3.hasNext()) {
      findAndParseListener(paramRoundEnvironment, (Class)localIterator3.next(), localLinkedHashMap, localLinkedHashSet);
    }
    Iterator localIterator4 = localLinkedHashMap.entrySet().iterator();
    while (localIterator4.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator4.next();
      String str = findParentFqcn((TypeElement)localEntry.getKey(), localLinkedHashSet);
      if (str != null) {
        ((ViewInjector)localEntry.getValue()).setParentInjector(str + "$$ViewInjector");
      }
    }
    return localLinkedHashMap;
  }
  
  private static Integer findDuplicate(int[] paramArrayOfInt)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    int i = paramArrayOfInt.length;
    int j = 0;
    int k;
    if (j < i)
    {
      k = paramArrayOfInt[j];
      if (localLinkedHashSet.add(Integer.valueOf(k))) {}
    }
    for (Integer localInteger = Integer.valueOf(k);; localInteger = null)
    {
      return localInteger;
      j++;
      break;
    }
  }
  
  private String findParentFqcn(TypeElement paramTypeElement, Set<String> paramSet)
  {
    for (;;)
    {
      TypeMirror localTypeMirror = paramTypeElement.getSuperclass();
      if (localTypeMirror.getKind() == TypeKind.NONE) {}
      TypeElement localTypeElement;
      String str1;
      for (String str2 = null;; str2 = str1 + "." + getClassName(localTypeElement, str1))
      {
        return str2;
        localTypeElement = (TypeElement)((DeclaredType)localTypeMirror).asElement();
        if (!paramSet.contains(localTypeElement.toString())) {
          break;
        }
        str1 = getPackageName(localTypeElement);
      }
      paramTypeElement = localTypeElement;
    }
  }
  
  private static String getClassName(TypeElement paramTypeElement, String paramString)
  {
    int i = 1 + paramString.length();
    return paramTypeElement.getQualifiedName().toString().substring(i).replace('.', '$');
  }
  
  private ViewInjector getOrCreateTargetClass(Map<TypeElement, ViewInjector> paramMap, TypeElement paramTypeElement)
  {
    ViewInjector localViewInjector = (ViewInjector)paramMap.get(paramTypeElement);
    if (localViewInjector == null)
    {
      String str1 = paramTypeElement.getQualifiedName().toString();
      String str2 = getPackageName(paramTypeElement);
      localViewInjector = new ViewInjector(str2, getClassName(paramTypeElement, str2) + "$$ViewInjector", str1);
      paramMap.put(paramTypeElement, localViewInjector);
    }
    return localViewInjector;
  }
  
  private String getPackageName(TypeElement paramTypeElement)
  {
    return this.elementUtils.getPackageOf(paramTypeElement).getQualifiedName().toString();
  }
  
  private boolean isBindingInWrongPackage(Class<? extends Annotation> paramClass, Element paramElement)
  {
    String str = ((TypeElement)paramElement.getEnclosingElement()).getQualifiedName().toString();
    boolean bool;
    if (str.startsWith("android."))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramClass.getSimpleName();
      arrayOfObject2[1] = str;
      error(paramElement, "@%s-annotated class incorrectly in Android framework package. (%s)", arrayOfObject2);
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (str.startsWith("java."))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = paramClass.getSimpleName();
        arrayOfObject1[1] = str;
        error(paramElement, "@%s-annotated class incorrectly in Java framework package. (%s)", arrayOfObject1);
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  private boolean isInaccessibleViaGeneratedCode(Class<? extends Annotation> paramClass, String paramString, Element paramElement)
  {
    boolean bool1 = true;
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    Set localSet = paramElement.getModifiers();
    if ((localSet.contains(Modifier.PRIVATE)) || (localSet.contains(Modifier.STATIC)))
    {
      Object[] arrayOfObject1 = new Object[4];
      arrayOfObject1[0] = paramClass.getSimpleName();
      arrayOfObject1[bool1] = paramString;
      arrayOfObject1[2] = localTypeElement.getQualifiedName();
      arrayOfObject1[3] = paramElement.getSimpleName();
      error(paramElement, "@%s %s must not be private or static. (%s.%s)", arrayOfObject1);
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (localTypeElement.getKind() != ElementKind.CLASS)
      {
        Object[] arrayOfObject3 = new Object[4];
        arrayOfObject3[0] = paramClass.getSimpleName();
        arrayOfObject3[bool1] = paramString;
        arrayOfObject3[2] = localTypeElement.getQualifiedName();
        arrayOfObject3[3] = paramElement.getSimpleName();
        error(localTypeElement, "@%s %s may only be contained in classes. (%s.%s)", arrayOfObject3);
        bool2 = bool1;
      }
      if (localTypeElement.getModifiers().contains(Modifier.PRIVATE))
      {
        Object[] arrayOfObject2 = new Object[4];
        arrayOfObject2[0] = paramClass.getSimpleName();
        arrayOfObject2[bool1] = paramString;
        arrayOfObject2[2] = localTypeElement.getQualifiedName();
        arrayOfObject2[3] = paramElement.getSimpleName();
        error(localTypeElement, "@%s %s may not be contained in private classes. (%s.%s)", arrayOfObject2);
      }
      for (;;)
      {
        return bool1;
        bool1 = bool2;
      }
    }
  }
  
  private boolean isInterface(TypeMirror paramTypeMirror)
  {
    boolean bool = false;
    if (!(paramTypeMirror instanceof DeclaredType)) {}
    for (;;)
    {
      return bool;
      if (((DeclaredType)paramTypeMirror).asElement().getKind() == ElementKind.INTERFACE) {
        bool = true;
      }
    }
  }
  
  private boolean isSubtypeOfType(TypeMirror paramTypeMirror, String paramString)
  {
    boolean bool = false;
    if (paramString.equals(paramTypeMirror.toString())) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((paramTypeMirror instanceof DeclaredType))
      {
        DeclaredType localDeclaredType = (DeclaredType)paramTypeMirror;
        List localList = localDeclaredType.getTypeArguments();
        if (localList.size() > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder(localDeclaredType.asElement().toString());
          localStringBuilder.append('<');
          for (int i = 0; i < localList.size(); i++)
          {
            if (i > 0) {
              localStringBuilder.append(',');
            }
            localStringBuilder.append('?');
          }
          localStringBuilder.append('>');
          if (localStringBuilder.toString().equals(paramString))
          {
            bool = true;
            continue;
          }
        }
        Element localElement = localDeclaredType.asElement();
        if ((localElement instanceof TypeElement))
        {
          TypeElement localTypeElement = (TypeElement)localElement;
          if (isSubtypeOfType(localTypeElement.getSuperclass(), paramString))
          {
            bool = true;
          }
          else
          {
            Iterator localIterator = localTypeElement.getInterfaces().iterator();
            if (localIterator.hasNext())
            {
              if (!isSubtypeOfType((TypeMirror)localIterator.next(), paramString)) {
                break;
              }
              bool = true;
            }
          }
        }
      }
    }
  }
  
  private void parseInjectView(Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
  {
    boolean bool1 = true;
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    TypeMirror localTypeMirror1 = paramElement.asType();
    if ((localTypeMirror1 instanceof TypeVariable)) {}
    for (TypeMirror localTypeMirror2 = ((TypeVariable)localTypeMirror1).getUpperBound();; localTypeMirror2 = localTypeMirror1)
    {
      if ((!isSubtypeOfType(localTypeMirror2, "android.view.View")) && (!isInterface(localTypeMirror2)))
      {
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = localTypeElement.getQualifiedName();
        arrayOfObject3[bool1] = paramElement.getSimpleName();
        error(paramElement, "@InjectView fields must extend from View or be an interface. (%s.%s)", arrayOfObject3);
      }
      for (boolean bool2 = bool1;; bool2 = false)
      {
        boolean bool3 = bool2 | isInaccessibleViaGeneratedCode(InjectView.class, "fields", paramElement) | isBindingInWrongPackage(InjectView.class, paramElement);
        if (paramElement.getAnnotation(InjectViews.class) != null)
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = localTypeElement.getQualifiedName();
          arrayOfObject2[bool1] = paramElement.getSimpleName();
          error(paramElement, "Only one of @InjectView and @InjectViews is allowed. (%s.%s)", arrayOfObject2);
          bool3 = bool1;
        }
        if (bool3) {}
        int i;
        for (;;)
        {
          return;
          i = ((InjectView)paramElement.getAnnotation(InjectView.class)).value();
          ViewInjector localViewInjector = (ViewInjector)paramMap.get(localTypeElement);
          if (localViewInjector == null) {
            break;
          }
          ViewInjection localViewInjection = localViewInjector.getViewInjection(i);
          if (localViewInjection == null) {
            break;
          }
          Iterator localIterator = localViewInjection.getViewBindings().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ViewBinding localViewBinding = (ViewBinding)localIterator.next();
          Object[] arrayOfObject1 = new Object[4];
          arrayOfObject1[0] = Integer.valueOf(i);
          arrayOfObject1[bool1] = localViewBinding.getName();
          arrayOfObject1[2] = localTypeElement.getQualifiedName();
          arrayOfObject1[3] = paramElement.getSimpleName();
          error(paramElement, "Attempt to use @InjectView for an already injected ID %d on '%s'. (%s.%s)", arrayOfObject1);
        }
        String str1 = paramElement.getSimpleName().toString();
        String str2 = localTypeMirror2.toString();
        if (paramElement.getAnnotation(Optional.class) == null) {}
        for (;;)
        {
          getOrCreateTargetClass(paramMap, localTypeElement).addView(i, new ViewBinding(str1, str2, bool1));
          paramSet.add(localTypeElement.toString());
          break;
          bool1 = false;
        }
      }
    }
  }
  
  private void parseInjectViews(Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
  {
    Object localObject = null;
    int i = 1;
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    TypeMirror localTypeMirror1 = paramElement.asType();
    String str1 = doubleErasure(localTypeMirror1);
    TypeMirror localTypeMirror2;
    int k;
    if (localTypeMirror1.getKind() == TypeKind.ARRAY)
    {
      localTypeMirror2 = ((ArrayType)localTypeMirror1).getComponentType();
      localObject = CollectionBinding.Kind.ARRAY;
      k = 0;
      if (!(localTypeMirror2 instanceof TypeVariable)) {
        break label561;
      }
    }
    label417:
    label561:
    for (TypeMirror localTypeMirror3 = ((TypeVariable)localTypeMirror2).getUpperBound();; localTypeMirror3 = localTypeMirror2)
    {
      if ((localTypeMirror3 != null) && (!isSubtypeOfType(localTypeMirror3, "android.view.View")) && (!isInterface(localTypeMirror3)))
      {
        Object[] arrayOfObject4 = new Object[2];
        arrayOfObject4[0] = localTypeElement.getQualifiedName();
        arrayOfObject4[i] = paramElement.getSimpleName();
        error(paramElement, "@InjectViews type must extend from View or be an interface. (%s.%s)", arrayOfObject4);
        k = i;
      }
      if ((k | isInaccessibleViaGeneratedCode(InjectViews.class, "fields", paramElement) | isBindingInWrongPackage(InjectViews.class, paramElement)) != 0) {}
      String str2;
      int[] arrayOfInt;
      for (;;)
      {
        return;
        if (LIST_TYPE.equals(str1))
        {
          List localList = ((DeclaredType)localTypeMirror1).getTypeArguments();
          if (localList.size() != i)
          {
            Object[] arrayOfObject5 = new Object[2];
            arrayOfObject5[0] = localTypeElement.getQualifiedName();
            arrayOfObject5[i] = paramElement.getSimpleName();
            error(paramElement, "@InjectViews List must have a generic component. (%s.%s)", arrayOfObject5);
            localTypeMirror2 = null;
          }
          int n;
          for (int m = i;; n = 0)
          {
            CollectionBinding.Kind localKind = CollectionBinding.Kind.LIST;
            k = m;
            localObject = localKind;
            break;
            localTypeMirror2 = (TypeMirror)localList.get(0);
          }
        }
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = localTypeElement.getQualifiedName();
        arrayOfObject1[i] = paramElement.getSimpleName();
        error(paramElement, "@InjectViews must be a List or array. (%s.%s)", arrayOfObject1);
        localTypeMirror2 = null;
        k = i;
        break;
        str2 = paramElement.getSimpleName().toString();
        arrayOfInt = ((InjectViews)paramElement.getAnnotation(InjectViews.class)).value();
        if (arrayOfInt.length != 0) {
          break label417;
        }
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = localTypeElement.getQualifiedName();
        arrayOfObject3[i] = paramElement.getSimpleName();
        error(paramElement, "@InjectViews must specify at least one ID. (%s.%s)", arrayOfObject3);
      }
      Integer localInteger = findDuplicate(arrayOfInt);
      if (localInteger != null)
      {
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = localInteger;
        arrayOfObject2[i] = localTypeElement.getQualifiedName();
        arrayOfObject2[2] = paramElement.getSimpleName();
        error(paramElement, "@InjectViews annotation contains duplicate ID %d. (%s.%s)", arrayOfObject2);
      }
      assert (localTypeMirror3 != null);
      String str3 = localTypeMirror3.toString();
      if (paramElement.getAnnotation(Optional.class) == null) {}
      for (;;)
      {
        getOrCreateTargetClass(paramMap, localTypeElement).addCollection(arrayOfInt, new CollectionBinding(str2, str3, (CollectionBinding.Kind)localObject, i));
        paramSet.add(localTypeElement.toString());
        break;
        int j = 0;
      }
    }
  }
  
  private void parseListenerAnnotation(Class<? extends Annotation> paramClass, Element paramElement, Map<TypeElement, ViewInjector> paramMap, Set<String> paramSet)
  {
    if ((!(paramElement instanceof ExecutableElement)) || (paramElement.getKind() != ElementKind.METHOD))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramClass.getSimpleName();
      throw new IllegalStateException(String.format("@%s annotation must be on a method.", arrayOfObject1));
    }
    ExecutableElement localExecutableElement = (ExecutableElement)paramElement;
    TypeElement localTypeElement = (TypeElement)paramElement.getEnclosingElement();
    Annotation localAnnotation = paramElement.getAnnotation(paramClass);
    Method localMethod = paramClass.getDeclaredMethod("value", new Class[0]);
    if (localMethod.getReturnType() != [I.class)
    {
      Object[] arrayOfObject13 = new Object[1];
      arrayOfObject13[0] = paramClass;
      throw new IllegalStateException(String.format("@%s annotation value() type not int[].", arrayOfObject13));
    }
    int[] arrayOfInt = (int[])localMethod.invoke(localAnnotation, new Object[0]);
    String str1 = localExecutableElement.getSimpleName().toString();
    boolean bool1;
    boolean bool2;
    if (paramElement.getAnnotation(Optional.class) == null)
    {
      bool1 = true;
      bool2 = isInaccessibleViaGeneratedCode(paramClass, "methods", paramElement) | isBindingInWrongPackage(paramClass, paramElement);
      Integer localInteger = findDuplicate(arrayOfInt);
      if (localInteger == null) {
        break label1642;
      }
      Object[] arrayOfObject12 = new Object[4];
      arrayOfObject12[0] = paramClass.getSimpleName();
      arrayOfObject12[1] = localInteger;
      arrayOfObject12[2] = localTypeElement.getQualifiedName();
      arrayOfObject12[3] = paramElement.getSimpleName();
      error(paramElement, "@%s annotation for method contains duplicate ID %d. (%s.%s)", arrayOfObject12);
    }
    label404:
    label1481:
    label1628:
    label1635:
    label1642:
    for (int i = 1;; i = bool2)
    {
      ListenerClass localListenerClass = (ListenerClass)paramClass.getAnnotation(ListenerClass.class);
      if (localListenerClass == null)
      {
        Object[] arrayOfObject11 = new Object[2];
        arrayOfObject11[0] = ListenerClass.class.getSimpleName();
        arrayOfObject11[1] = paramClass.getSimpleName();
        throw new IllegalStateException(String.format("No @%s defined on @%s.", arrayOfObject11));
        bool1 = false;
        break;
      }
      int j = arrayOfInt.length;
      int k = 0;
      int m = i;
      int i8;
      int i9;
      if (k < j)
      {
        i8 = arrayOfInt[k];
        if (i8 != -1) {
          break label1635;
        }
        if (arrayOfInt.length == 1)
        {
          if (bool1) {
            break label1628;
          }
          Object[] arrayOfObject10 = new Object[2];
          arrayOfObject10[0] = localTypeElement.getQualifiedName();
          arrayOfObject10[1] = paramElement.getSimpleName();
          error(paramElement, "ID free injection must not be annotated with @Optional. (%s.%s)", arrayOfObject10);
          i9 = 1;
          String str3 = localListenerClass.targetType();
          if ((!isSubtypeOfType(localTypeElement.asType(), str3)) && (!isInterface(localTypeElement.asType())))
          {
            Object[] arrayOfObject9 = new Object[4];
            arrayOfObject9[0] = paramClass.getSimpleName();
            arrayOfObject9[1] = str3;
            arrayOfObject9[2] = localTypeElement.getQualifiedName();
            arrayOfObject9[3] = paramElement.getSimpleName();
            error(paramElement, "@%s annotation without an ID may only be used with an object of type \"%s\" or an interface. (%s.%s)", arrayOfObject9);
            i9 = 1;
          }
        }
      }
      for (;;)
      {
        k++;
        m = i9;
        break;
        Object[] arrayOfObject8 = new Object[4];
        arrayOfObject8[0] = paramClass.getSimpleName();
        arrayOfObject8[1] = Integer.valueOf(i8);
        arrayOfObject8[2] = localTypeElement.getQualifiedName();
        arrayOfObject8[3] = paramElement.getSimpleName();
        error(paramElement, "@%s annotation contains invalid ID %d. (%s.%s)", arrayOfObject8);
        i9 = 1;
        continue;
        ListenerMethod[] arrayOfListenerMethod = localListenerClass.method();
        if (arrayOfListenerMethod.length > 1)
        {
          Object[] arrayOfObject7 = new Object[1];
          arrayOfObject7[0] = paramClass.getSimpleName();
          throw new IllegalStateException(String.format("Multiple listener methods specified on @%s.", arrayOfObject7));
        }
        ListenerMethod localListenerMethod;
        if (arrayOfListenerMethod.length == 1)
        {
          if (localListenerClass.callbacks() != ListenerClass.NONE.class)
          {
            Object[] arrayOfObject6 = new Object[1];
            arrayOfObject6[0] = paramClass.getSimpleName();
            throw new IllegalStateException(String.format("Both method() and callback() defined on @%s.", arrayOfObject6));
          }
          localListenerMethod = arrayOfListenerMethod[0];
        }
        List localList;
        Enum localEnum;
        do
        {
          localList = localExecutableElement.getParameters();
          if (localList.size() > localListenerMethod.parameters().length)
          {
            Object[] arrayOfObject5 = new Object[4];
            arrayOfObject5[0] = paramClass.getSimpleName();
            arrayOfObject5[1] = Integer.valueOf(localListenerMethod.parameters().length);
            arrayOfObject5[2] = localTypeElement.getQualifiedName();
            arrayOfObject5[3] = paramElement.getSimpleName();
            error(paramElement, "@%s methods can have at most %s parameter(s). (%s.%s)", arrayOfObject5);
            m = 1;
          }
          TypeMirror localTypeMirror1 = localExecutableElement.getReturnType();
          if ((localTypeMirror1 instanceof TypeVariable)) {
            localTypeMirror1 = ((TypeVariable)localTypeMirror1).getUpperBound();
          }
          if (!localTypeMirror1.toString().equals(localListenerMethod.returnType()))
          {
            Object[] arrayOfObject4 = new Object[4];
            arrayOfObject4[0] = paramClass.getSimpleName();
            arrayOfObject4[1] = localListenerMethod.returnType();
            arrayOfObject4[2] = localTypeElement.getQualifiedName();
            arrayOfObject4[3] = paramElement.getSimpleName();
            error(paramElement, "@%s methods must have a '%s' return type. (%s.%s)", arrayOfObject4);
            m = 1;
          }
          if (m == 0) {
            break;
          }
          return;
          localEnum = (Enum)paramClass.getDeclaredMethod("callback", new Class[0]).invoke(localAnnotation, new Object[0]);
          localListenerMethod = (ListenerMethod)localEnum.getDeclaringClass().getField(localEnum.name()).getAnnotation(ListenerMethod.class);
        } while (localListenerMethod != null);
        Object[] arrayOfObject2 = new Object[4];
        arrayOfObject2[0] = ListenerMethod.class.getSimpleName();
        arrayOfObject2[1] = paramClass.getSimpleName();
        arrayOfObject2[2] = localEnum.getDeclaringClass().getSimpleName();
        arrayOfObject2[3] = localEnum.name();
        throw new IllegalStateException(String.format("No @%s defined on @%s's %s.%s.", arrayOfObject2));
        Parameter[] arrayOfParameter1 = Parameter.NONE;
        Parameter[] arrayOfParameter3;
        if (!localList.isEmpty())
        {
          arrayOfParameter3 = new Parameter[localList.size()];
          BitSet localBitSet = new BitSet(localList.size());
          String[] arrayOfString1 = localListenerMethod.parameters();
          for (int i3 = 0;; i3++)
          {
            if (i3 >= localList.size()) {
              break label1481;
            }
            TypeMirror localTypeMirror2 = ((VariableElement)localList.get(i3)).asType();
            if ((localTypeMirror2 instanceof TypeVariable)) {
              localTypeMirror2 = ((TypeVariable)localTypeMirror2).getUpperBound();
            }
            int i4 = 0;
            if (i4 < arrayOfString1.length)
            {
              if (localBitSet.get(i4)) {}
              while ((!isSubtypeOfType(localTypeMirror2, arrayOfString1[i4])) && (!isInterface(localTypeMirror2)))
              {
                i4++;
                break;
              }
              Parameter localParameter2 = new Parameter(i4, localTypeMirror2.toString());
              arrayOfParameter3[i3] = localParameter2;
              localBitSet.set(i4);
            }
            if (arrayOfParameter3[i3] == null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unable to match @").append(paramClass.getSimpleName()).append(" method arguments. (").append(localTypeElement.getQualifiedName()).append('.').append(paramElement.getSimpleName()).append(')');
              int i5 = 0;
              if (i5 < arrayOfParameter3.length)
              {
                Parameter localParameter1 = arrayOfParameter3[i5];
                localStringBuilder.append("\n\n  Parameter #").append(i5 + 1).append(": ").append(((VariableElement)localList.get(i5)).asType().toString()).append("\n    ");
                if (localParameter1 == null) {
                  localStringBuilder.append("did not match any listener parameters");
                }
                for (;;)
                {
                  i5++;
                  break;
                  localStringBuilder.append("matched listener parameter #").append(1 + localParameter1.getListenerPosition()).append(": ").append(localParameter1.getType());
                }
              }
              localStringBuilder.append("\n\nMethods may have up to ").append(localListenerMethod.parameters().length).append(" parameter(s):\n");
              for (String str2 : localListenerMethod.parameters()) {
                localStringBuilder.append("\n  ").append(str2);
              }
              localStringBuilder.append("\n\nThese may be listed in any order but will be searched for from top to bottom.");
              error(localExecutableElement, localStringBuilder.toString(), new Object[0]);
              break;
            }
          }
        }
        for (Parameter[] arrayOfParameter2 = arrayOfParameter3;; arrayOfParameter2 = arrayOfParameter1)
        {
          ListenerBinding localListenerBinding = new ListenerBinding(str1, Arrays.asList(arrayOfParameter2), bool1);
          ViewInjector localViewInjector = getOrCreateTargetClass(paramMap, localTypeElement);
          int n = arrayOfInt.length;
          for (int i1 = 0;; i1++)
          {
            if (i1 >= n) {
              break label1605;
            }
            int i2 = arrayOfInt[i1];
            if (!localViewInjector.addListener(i2, localListenerClass, localListenerMethod, localListenerBinding))
            {
              Object[] arrayOfObject3 = new Object[3];
              arrayOfObject3[0] = Integer.valueOf(i2);
              arrayOfObject3[1] = localTypeElement.getQualifiedName();
              arrayOfObject3[2] = paramElement.getSimpleName();
              error(paramElement, "Multiple listener methods with return value specified for ID %d. (%s.%s)", arrayOfObject3);
              break;
            }
          }
          paramSet.add(localTypeElement.toString());
          break;
        }
        i9 = m;
        break label404;
        i9 = m;
      }
    }
  }
  
  public Set<String> getSupportedAnnotationTypes()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.add(InjectView.class.getCanonicalName());
    localLinkedHashSet.add(InjectViews.class.getCanonicalName());
    Iterator localIterator = LISTENERS.iterator();
    while (localIterator.hasNext()) {
      localLinkedHashSet.add(((Class)localIterator.next()).getCanonicalName());
    }
    return localLinkedHashSet;
  }
  
  public SourceVersion getSupportedSourceVersion()
  {
    return SourceVersion.latestSupported();
  }
  
  public void init(ProcessingEnvironment paramProcessingEnvironment)
  {
    try
    {
      super.init(paramProcessingEnvironment);
      this.elementUtils = paramProcessingEnvironment.getElementUtils();
      this.typeUtils = paramProcessingEnvironment.getTypeUtils();
      this.filer = paramProcessingEnvironment.getFiler();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean process(Set<? extends TypeElement> paramSet, RoundEnvironment paramRoundEnvironment)
  {
    Iterator localIterator = findAndParseTargets(paramRoundEnvironment).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      TypeElement localTypeElement = (TypeElement)localEntry.getKey();
      ViewInjector localViewInjector = (ViewInjector)localEntry.getValue();
      try
      {
        Filer localFiler = this.filer;
        String str = localViewInjector.getFqcn();
        Element[] arrayOfElement = new Element[1];
        arrayOfElement[0] = localTypeElement;
        Writer localWriter = localFiler.createSourceFile(str, arrayOfElement).openWriter();
        localWriter.write(localViewInjector.brewJava());
        localWriter.flush();
        localWriter.close();
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localTypeElement;
        arrayOfObject[1] = localIOException.getMessage();
        error(localTypeElement, "Unable to write injector for type %s: %s", arrayOfObject);
      }
    }
    return true;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.internal.ButterKnifeProcessor
 * JD-Core Version:    0.7.0.1
 */