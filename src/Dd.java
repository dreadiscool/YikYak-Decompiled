import android.view.View;
import android.view.View.OnClickListener;
import com.yik.yak.ui.activity.DraftDialog;

public class Dd
  implements View.OnClickListener
{
  public Dd(DraftDialog paramDraftDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(1);
    DraftDialog.a(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Dd
 * JD-Core Version:    0.7.0.1
 */