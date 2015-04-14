import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

final class wZ
  implements Runnable
{
  wZ(wV paramwV, Activity paramActivity) {}
  
  public final void run()
  {
    this.a.i.O(this.b.getCallingPackage());
    Intent localIntent = this.b.getIntent();
    if (localIntent != null)
    {
      Uri localUri = localIntent.getData();
      if (localUri != null) {
        this.a.i.P(localUri.toString());
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wZ
 * JD-Core Version:    0.7.0.1
 */