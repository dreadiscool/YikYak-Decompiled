import android.content.Intent;
import android.net.Uri;
import com.yik.yak.ui.activity.SendAYak;
import java.io.File;
import java.util.UUID;

public class DV
  implements Runnable
{
  public DV(SendAYak paramSendAYak) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    SendAYak.a(this.a, UUID.randomUUID().toString());
    File localFile1 = new File(Ik.a());
    File localFile2 = null;
    if (localIntent.resolveActivity(this.a.getPackageManager()) != null) {}
    try
    {
      localFile2 = File.createTempFile(SendAYak.b(this.a), ".jpg", localFile1);
      SendAYak.b(this.a, localFile2.getAbsolutePath());
      if (localFile2 != null)
      {
        localIntent.putExtra("output", Uri.fromFile(localFile2));
        this.a.startActivityForResult(localIntent, 2004);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     DV
 * JD-Core Version:    0.7.0.1
 */