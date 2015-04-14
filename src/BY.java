import android.os.Handler.Callback;
import android.os.Message;
import java.lang.ref.WeakReference;

public abstract class BY<T>
  implements Handler.Callback
{
  private WeakReference<T> a;
  
  public BY(T paramT)
  {
    this.a = new WeakReference(paramT);
  }
  
  public T a()
  {
    if (this.a != null) {}
    for (Object localObject = this.a.get();; localObject = null) {
      return localObject;
    }
  }
  
  public abstract boolean a(T paramT, Message paramMessage);
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = a();
    if (localObject != null) {}
    for (boolean bool = a(localObject, paramMessage);; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BY
 * JD-Core Version:    0.7.0.1
 */