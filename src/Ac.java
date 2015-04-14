import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

class Ac
  implements InvocationHandler
{
  private final List<String> a;
  private boolean b;
  private String c;
  
  public Ac(List<String> paramList)
  {
    this.a = paramList;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    Class localClass = paramMethod.getReturnType();
    if (paramArrayOfObject == null) {
      paramArrayOfObject = Ae.b;
    }
    Object localObject;
    if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
      localObject = Boolean.valueOf(true);
    }
    for (;;)
    {
      return localObject;
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.b = true;
        localObject = null;
      }
      else if ((str.equals("protocols")) && (paramArrayOfObject.length == 0))
      {
        localObject = this.a;
      }
      else if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof List)))
      {
        List localList = (List)paramArrayOfObject[0];
        int i = localList.size();
        for (int j = 0;; j++)
        {
          if (j >= i) {
            break label219;
          }
          if (this.a.contains(localList.get(j)))
          {
            localObject = (String)localList.get(j);
            this.c = ((String)localObject);
            break;
          }
        }
        label219:
        localObject = (String)this.a.get(0);
        this.c = ((String)localObject);
      }
      else if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramArrayOfObject.length == 1))
      {
        this.c = ((String)paramArrayOfObject[0]);
        localObject = null;
      }
      else
      {
        localObject = paramMethod.invoke(this, paramArrayOfObject);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ac
 * JD-Core Version:    0.7.0.1
 */