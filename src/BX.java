import android.os.AsyncTask;
import java.lang.ref.WeakReference;

public abstract class BX<T, Params, Progress, Result>
  extends AsyncTask<Params, Progress, Result>
{
  private WeakReference<T> a;
  
  public BX(T paramT)
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
  
  protected void a(T paramT, Result paramResult) {}
  
  protected void a(T paramT, Progress... paramVarArgs)
  {
    super.onProgressUpdate(paramVarArgs);
  }
  
  protected abstract Result b(T paramT, Params... paramVarArgs);
  
  protected Result doInBackground(Params... paramVarArgs)
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (Object localObject2 = b(localObject1, paramVarArgs);; localObject2 = null) {
      return localObject2;
    }
  }
  
  protected void onPostExecute(Result paramResult)
  {
    super.onPostExecute(paramResult);
    Object localObject = a();
    if (localObject != null) {
      a(localObject, paramResult);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    a();
  }
  
  protected void onProgressUpdate(Progress... paramVarArgs)
  {
    super.onProgressUpdate(paramVarArgs);
    Object localObject = a();
    if (localObject != null) {
      a(localObject, paramVarArgs);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BX
 * JD-Core Version:    0.7.0.1
 */