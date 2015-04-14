import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.yik.yak.ui.fragment.CommentFragment;
import java.io.IOException;
import org.json.JSONObject;

public class Ft
  implements yZ
{
  Handler a = new Handler(this.c.getActivity().getMainLooper());
  
  public Ft(CommentFragment paramCommentFragment, boolean paramBoolean) {}
  
  public void a(zF paramzF)
  {
    if ((this.c.getActivity() == null) || (!this.c.isAdded())) {}
    for (;;)
    {
      return;
      if (!paramzF.d()) {
        CommentFragment.a(this.c, null);
      } else {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramzF.h().f());
          this.a.post(new Fu(this, localJSONObject));
        }
        catch (Exception localException)
        {
          CommentFragment.a(this.c, null);
        }
      }
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    if ((this.c.getActivity() == null) || (!this.c.isAdded())) {}
    for (;;)
    {
      return;
      this.a.post(new Fw(this));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ft
 * JD-Core Version:    0.7.0.1
 */