import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class qw
  implements pn
{
  private final px a;
  private final oQ b;
  private final pK c;
  
  public qw(px parampx, oQ paramoQ, pK parampK)
  {
    this.a = parampx;
    this.b = paramoQ;
    this.c = parampK;
  }
  
  private String a(Field paramField)
  {
    pp localpp = (pp)paramField.getAnnotation(pp.class);
    if (localpp == null) {}
    for (String str = this.b.a(paramField);; str = localpp.a()) {
      return str;
    }
  }
  
  private Map<String, qz> a(oR paramoR, rn<?> paramrn, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap1 = new LinkedHashMap();
    if (paramClass.isInterface()) {}
    for (LinkedHashMap localLinkedHashMap2 = localLinkedHashMap1;; localLinkedHashMap2 = localLinkedHashMap1)
    {
      return localLinkedHashMap2;
      Type localType1 = paramrn.b();
      while (paramClass != Object.class)
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        int i = arrayOfField.length;
        int j = 0;
        if (j < i)
        {
          Field localField = arrayOfField[j];
          boolean bool1 = a(localField, true);
          boolean bool2 = a(localField, false);
          if ((!bool1) && (!bool2)) {}
          qz localqz2;
          do
          {
            j++;
            break;
            localField.setAccessible(true);
            Type localType2 = pt.a(paramrn.b(), paramClass, localField.getGenericType());
            qz localqz1 = a(paramoR, localField, a(localField), rn.a(localType2), bool1, bool2);
            localqz2 = (qz)localLinkedHashMap1.put(localqz1.g, localqz1);
          } while (localqz2 == null);
          throw new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + localqz2.g);
        }
        paramrn = rn.a(pt.a(paramrn.b(), paramClass, paramClass.getGenericSuperclass()));
        paramClass = paramrn.a();
      }
    }
  }
  
  private qz a(oR paramoR, Field paramField, String paramString, rn<?> paramrn, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new qx(this, paramString, paramBoolean1, paramBoolean2, paramoR, paramrn, paramField, pX.a(paramrn.a()));
  }
  
  public <T> pm<T> a(oR paramoR, rn<T> paramrn)
  {
    Object localObject = null;
    Class localClass = paramrn.a();
    if (!Object.class.isAssignableFrom(localClass)) {}
    for (;;)
    {
      return localObject;
      localObject = new qy(this.a.a(paramrn), a(paramoR, paramrn, localClass), null);
    }
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    if ((!this.c.a(paramField.getType(), paramBoolean)) && (!this.c.a(paramField, paramBoolean))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qw
 * JD-Core Version:    0.7.0.1
 */