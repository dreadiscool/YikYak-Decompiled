import android.util.Log;

public class IB
  implements IO
{
  private int a;
  
  public IB()
  {
    this.a = 4;
  }
  
  public IB(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, false);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBoolean) || (a(paramString1, paramInt))) {
      Log.println(paramInt, paramString1, paramString2);
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (this.a <= paramInt) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     IB
 * JD-Core Version:    0.7.0.1
 */