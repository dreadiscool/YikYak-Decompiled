import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class pt
{
  static final Type[] a = new Type[0];
  
  private static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++) {
      if (paramObject.equals(paramArrayOfObject[i])) {
        return i;
      }
    }
    throw new NoSuchElementException();
  }
  
  private static Class<?> a(TypeVariable<?> paramTypeVariable)
  {
    GenericDeclaration localGenericDeclaration = paramTypeVariable.getGenericDeclaration();
    if ((localGenericDeclaration instanceof Class)) {}
    for (Class localClass = (Class)localGenericDeclaration;; localClass = null) {
      return localClass;
    }
  }
  
  public static GenericArrayType a(Type paramType)
  {
    return new pu(paramType);
  }
  
  public static ParameterizedType a(Type paramType1, Type paramType2, Type... paramVarArgs)
  {
    return new pv(paramType1, paramType2, paramVarArgs);
  }
  
  public static Type a(Type paramType, Class<?> paramClass)
  {
    Type localType = b(paramType, paramClass, Collection.class);
    if ((localType instanceof WildcardType)) {
      localType = ((WildcardType)localType).getUpperBounds()[0];
    }
    if ((localType instanceof ParameterizedType)) {}
    for (Object localObject = ((ParameterizedType)localType).getActualTypeArguments()[0];; localObject = Object.class) {
      return localObject;
    }
  }
  
  static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1) {}
    for (;;)
    {
      return paramType;
      if (paramClass2.isInterface())
      {
        Class[] arrayOfClass = paramClass1.getInterfaces();
        int i = 0;
        int j = arrayOfClass.length;
        for (;;)
        {
          if (i >= j) {
            break label93;
          }
          if (arrayOfClass[i] == paramClass2)
          {
            paramType = paramClass1.getGenericInterfaces()[i];
            break;
          }
          if (paramClass2.isAssignableFrom(arrayOfClass[i]))
          {
            paramType = a(paramClass1.getGenericInterfaces()[i], arrayOfClass[i], paramClass2);
            break;
          }
          i++;
        }
      }
      label93:
      if (!paramClass1.isInterface()) {
        for (;;)
        {
          if (paramClass1 == Object.class) {
            break label150;
          }
          Class localClass = paramClass1.getSuperclass();
          if (localClass == paramClass2)
          {
            paramType = paramClass1.getGenericSuperclass();
            break;
          }
          if (paramClass2.isAssignableFrom(localClass))
          {
            paramType = a(paramClass1.getGenericSuperclass(), localClass, paramClass2);
            break;
          }
          paramClass1 = localClass;
        }
      }
      label150:
      paramType = paramClass2;
    }
  }
  
  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    Object localObject = paramType2;
    Type localType9;
    if ((localObject instanceof TypeVariable))
    {
      TypeVariable localTypeVariable = (TypeVariable)localObject;
      localType9 = a(paramType1, paramClass, localTypeVariable);
      if (localType9 == localTypeVariable) {
        localObject = localType9;
      }
    }
    for (;;)
    {
      return localObject;
      localObject = localType9;
      break;
      if (((localObject instanceof Class)) && (((Class)localObject).isArray()))
      {
        localObject = (Class)localObject;
        Class localClass = ((Class)localObject).getComponentType();
        Type localType8 = a(paramType1, paramClass, localClass);
        if (localClass != localType8) {
          localObject = a(localType8);
        }
      }
      else if ((localObject instanceof GenericArrayType))
      {
        localObject = (GenericArrayType)localObject;
        Type localType6 = ((GenericArrayType)localObject).getGenericComponentType();
        Type localType7 = a(paramType1, paramClass, localType6);
        if (localType6 != localType7) {
          localObject = a(localType7);
        }
      }
      else if ((localObject instanceof ParameterizedType))
      {
        localObject = (ParameterizedType)localObject;
        Type localType3 = ((ParameterizedType)localObject).getOwnerType();
        Type localType4 = a(paramType1, paramClass, localType3);
        if (localType4 != localType3) {}
        int k;
        Type[] arrayOfType4;
        for (int i = 1;; i = 0)
        {
          Type[] arrayOfType3 = ((ParameterizedType)localObject).getActualTypeArguments();
          int j = arrayOfType3.length;
          k = i;
          arrayOfType4 = arrayOfType3;
          for (int m = 0; m < j; m++)
          {
            Type localType5 = a(paramType1, paramClass, arrayOfType4[m]);
            if (localType5 != arrayOfType4[m])
            {
              if (k == 0)
              {
                arrayOfType4 = (Type[])arrayOfType4.clone();
                k = 1;
              }
              arrayOfType4[m] = localType5;
            }
          }
        }
        if (k != 0) {
          localObject = a(localType4, ((ParameterizedType)localObject).getRawType(), arrayOfType4);
        }
      }
      else if ((localObject instanceof WildcardType))
      {
        localObject = (WildcardType)localObject;
        Type[] arrayOfType1 = ((WildcardType)localObject).getLowerBounds();
        Type[] arrayOfType2 = ((WildcardType)localObject).getUpperBounds();
        if (arrayOfType1.length == 1)
        {
          Type localType2 = a(paramType1, paramClass, arrayOfType1[0]);
          if (localType2 != arrayOfType1[0]) {
            localObject = c(localType2);
          }
        }
        else if (arrayOfType2.length == 1)
        {
          Type localType1 = a(paramType1, paramClass, arrayOfType2[0]);
          if (localType1 != arrayOfType2[0]) {
            localObject = b(localType1);
          }
        }
      }
    }
  }
  
  static Type a(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = a(paramTypeVariable);
    if (localClass == null) {}
    for (;;)
    {
      return paramTypeVariable;
      Type localType = a(paramType, paramClass, localClass);
      if ((localType instanceof ParameterizedType))
      {
        int i = a(localClass.getTypeParameters(), paramTypeVariable);
        paramTypeVariable = ((ParameterizedType)localType).getActualTypeArguments()[i];
      }
    }
  }
  
  static boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Type paramType1, Type paramType2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramType1 == paramType2) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool2;
          if ((paramType1 instanceof Class))
          {
            bool2 = paramType1.equals(paramType2);
          }
          else if ((paramType1 instanceof ParameterizedType))
          {
            if ((paramType2 instanceof ParameterizedType))
            {
              ParameterizedType localParameterizedType1 = (ParameterizedType)paramType1;
              ParameterizedType localParameterizedType2 = (ParameterizedType)paramType2;
              if ((a(localParameterizedType1.getOwnerType(), localParameterizedType2.getOwnerType())) && (localParameterizedType1.getRawType().equals(localParameterizedType2.getRawType())) && (Arrays.equals(localParameterizedType1.getActualTypeArguments(), localParameterizedType2.getActualTypeArguments()))) {}
              for (;;)
              {
                bool2 = bool1;
                break;
                bool1 = false;
              }
            }
          }
          else
          {
            if (!(paramType1 instanceof GenericArrayType)) {
              break;
            }
            if ((paramType2 instanceof GenericArrayType))
            {
              GenericArrayType localGenericArrayType1 = (GenericArrayType)paramType1;
              GenericArrayType localGenericArrayType2 = (GenericArrayType)paramType2;
              bool2 = a(localGenericArrayType1.getGenericComponentType(), localGenericArrayType2.getGenericComponentType());
            }
          }
        }
        if (!(paramType1 instanceof WildcardType)) {
          break;
        }
      } while (!(paramType2 instanceof WildcardType));
      WildcardType localWildcardType1 = (WildcardType)paramType1;
      WildcardType localWildcardType2 = (WildcardType)paramType2;
      if ((Arrays.equals(localWildcardType1.getUpperBounds(), localWildcardType2.getUpperBounds())) && (Arrays.equals(localWildcardType1.getLowerBounds(), localWildcardType2.getLowerBounds()))) {}
      for (;;)
      {
        bool2 = bool1;
        break;
        bool1 = false;
      }
    } while ((!(paramType1 instanceof TypeVariable)) || (!(paramType2 instanceof TypeVariable)));
    TypeVariable localTypeVariable1 = (TypeVariable)paramType1;
    TypeVariable localTypeVariable2 = (TypeVariable)paramType2;
    if ((localTypeVariable1.getGenericDeclaration() == localTypeVariable2.getGenericDeclaration()) && (localTypeVariable1.getName().equals(localTypeVariable2.getName()))) {}
    for (;;)
    {
      bool2 = bool1;
      break;
      bool1 = false;
    }
  }
  
  private static int b(Object paramObject)
  {
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0) {
      return i;
    }
  }
  
  static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    ps.a(paramClass2.isAssignableFrom(paramClass1));
    return a(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
  }
  
  public static WildcardType b(Type paramType)
  {
    Type[] arrayOfType = new Type[1];
    arrayOfType[0] = paramType;
    return new pw(arrayOfType, a);
  }
  
  public static Type[] b(Type paramType, Class<?> paramClass)
  {
    Type[] arrayOfType;
    if (paramType == Properties.class)
    {
      arrayOfType = new Type[2];
      arrayOfType[0] = String.class;
      arrayOfType[1] = String.class;
    }
    for (;;)
    {
      return arrayOfType;
      Type localType = b(paramType, paramClass, Map.class);
      if ((localType instanceof ParameterizedType))
      {
        arrayOfType = ((ParameterizedType)localType).getActualTypeArguments();
      }
      else
      {
        arrayOfType = new Type[2];
        arrayOfType[0] = Object.class;
        arrayOfType[1] = Object.class;
      }
    }
  }
  
  public static WildcardType c(Type paramType)
  {
    Type[] arrayOfType1 = new Type[1];
    arrayOfType1[0] = Object.class;
    Type[] arrayOfType2 = new Type[1];
    arrayOfType2[0] = paramType;
    return new pw(arrayOfType1, arrayOfType2);
  }
  
  public static Type d(Type paramType)
  {
    Class localClass;
    Object localObject2;
    Object localObject1;
    if ((paramType instanceof Class))
    {
      localClass = (Class)paramType;
      if (localClass.isArray())
      {
        localObject2 = new pu(d(localClass.getComponentType()));
        localObject1 = (Type)localObject2;
      }
    }
    for (;;)
    {
      return localObject1;
      localObject2 = localClass;
      break;
      if ((paramType instanceof ParameterizedType))
      {
        ParameterizedType localParameterizedType = (ParameterizedType)paramType;
        localObject1 = new pv(localParameterizedType.getOwnerType(), localParameterizedType.getRawType(), localParameterizedType.getActualTypeArguments());
      }
      else if ((paramType instanceof GenericArrayType))
      {
        localObject1 = new pu(((GenericArrayType)paramType).getGenericComponentType());
      }
      else if ((paramType instanceof WildcardType))
      {
        WildcardType localWildcardType = (WildcardType)paramType;
        localObject1 = new pw(localWildcardType.getUpperBounds(), localWildcardType.getLowerBounds());
      }
      else
      {
        localObject1 = paramType;
      }
    }
  }
  
  public static Class<?> e(Type paramType)
  {
    Object localObject;
    if ((paramType instanceof Class)) {
      localObject = (Class)paramType;
    }
    for (;;)
    {
      return localObject;
      if ((paramType instanceof ParameterizedType))
      {
        Type localType = ((ParameterizedType)paramType).getRawType();
        ps.a(localType instanceof Class);
        localObject = (Class)localType;
      }
      else if ((paramType instanceof GenericArrayType))
      {
        localObject = Array.newInstance(e(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
      }
      else if ((paramType instanceof TypeVariable))
      {
        localObject = Object.class;
      }
      else
      {
        if (!(paramType instanceof WildcardType)) {
          break;
        }
        localObject = e(((WildcardType)paramType).getUpperBounds()[0]);
      }
    }
    if (paramType == null) {}
    for (String str = "null";; str = paramType.getClass().getName()) {
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
    }
  }
  
  public static String f(Type paramType)
  {
    if ((paramType instanceof Class)) {}
    for (String str = ((Class)paramType).getName();; str = paramType.toString()) {
      return str;
    }
  }
  
  public static Type g(Type paramType)
  {
    if ((paramType instanceof GenericArrayType)) {}
    for (Object localObject = ((GenericArrayType)paramType).getGenericComponentType();; localObject = ((Class)paramType).getComponentType()) {
      return localObject;
    }
  }
  
  private static void i(Type paramType)
  {
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive())) {}
    for (boolean bool = true;; bool = false)
    {
      ps.a(bool);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     pt
 * JD-Core Version:    0.7.0.1
 */