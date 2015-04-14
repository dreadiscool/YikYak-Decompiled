import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.yik.yak.ui.fragment.CommentFragment;
import java.io.IOException;

public class Fx
  implements yZ
{
  Handler a = new Handler(this.f.getActivity().getMainLooper());
  int b = 0;
  
  public Fx(CommentFragment paramCommentFragment, boolean paramBoolean1, CK paramCK, boolean paramBoolean2) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {}
    for (;;)
    {
      return;
      try
      {
        paramzF.h().f();
        this.a.post(new Fy(this));
      }
      catch (IOException localIOException) {}
    }
  }
  
  public void a(zz paramzz, IOException paramIOException) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fx
 * JD-Core Version:    0.7.0.1
 */