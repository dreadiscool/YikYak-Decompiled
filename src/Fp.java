import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.yik.yak.ui.fragment.CommentFragment;
import java.io.IOException;

public class Fp
  implements yZ
{
  Handler a = new Handler(this.c.getActivity().getMainLooper());
  int b = 0;
  
  public Fp(CommentFragment paramCommentFragment) {}
  
  public void a(zF paramzF)
  {
    if (!paramzF.d()) {}
    for (;;)
    {
      return;
      try
      {
        paramzF.h().f();
        this.a.post(new Fq(this));
      }
      catch (IOException localIOException) {}
    }
  }
  
  public void a(zz paramzz, IOException paramIOException)
  {
    this.a.post(new Fr(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Fp
 * JD-Core Version:    0.7.0.1
 */