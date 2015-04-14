import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.os.AsyncTask;

class um
  extends AsyncTask<Void, Void, Void>
{
  private final un a;
  private final Activity b;
  private Bitmap c;
  private int d;
  
  public um(Activity paramActivity, un paramun)
  {
    this.b = paramActivity;
    this.a = paramun;
    this.d = -16777216;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (this.c != null) {}
    try
    {
      vT.a(this.c, 20);
      new Canvas(this.c).drawColor(uk.a(), PorterDuff.Mode.SRC_ATOP);
      return null;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        this.c = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        this.c = null;
      }
    }
  }
  
  protected void a(Void paramVoid)
  {
    this.a.a(this.c, this.d);
  }
  
  protected void onPreExecute()
  {
    this.c = vQ.a(this.b, 2, 2, true);
    this.d = vQ.a(this.c);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     um
 * JD-Core Version:    0.7.0.1
 */