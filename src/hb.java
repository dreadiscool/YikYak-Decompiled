import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class hb
{
  static hb a;
  final BlockingQueue<Intent> b = new LinkedBlockingQueue();
  private Context c;
  private PendingIntent d;
  private Handler e = new hc(this, Looper.getMainLooper());
  private Messenger f = new Messenger(this.e);
  
  public static hb a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new hb();
        a.c = paramContext.getApplicationContext();
      }
      hb localhb = a;
      return localhb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(String... paramVarArgs)
  {
    String str = b(paramVarArgs);
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.setPackage("com.google.android.gms");
    localIntent.putExtra("google.messenger", this.f);
    a(localIntent);
    localIntent.putExtra("sender", str);
    this.c.startService(localIntent);
  }
  
  public String a(String... paramVarArgs)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      throw new IOException("MAIN_THREAD");
    }
    this.b.clear();
    c(paramVarArgs);
    Intent localIntent;
    try
    {
      localIntent = (Intent)this.b.poll(5000L, TimeUnit.MILLISECONDS);
      if (localIntent == null) {
        throw new IOException("SERVICE_NOT_AVAILABLE");
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException(localInterruptedException.getMessage());
    }
    String str1 = localIntent.getStringExtra("registration_id");
    if (str1 != null) {
      return str1;
    }
    localIntent.getStringExtra("error");
    String str2 = localIntent.getStringExtra("error");
    if (str2 != null) {
      throw new IOException(str2);
    }
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }
  
  void a(Intent paramIntent)
  {
    try
    {
      if (this.d == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.d = PendingIntent.getBroadcast(this.c, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.d);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  String b(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No senderIds");
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
    for (int i = 1; i < paramVarArgs.length; i++) {
      localStringBuilder.append(',').append(paramVarArgs[i]);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     hb
 * JD-Core Version:    0.7.0.1
 */