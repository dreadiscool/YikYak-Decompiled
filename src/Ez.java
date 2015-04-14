import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.yik.yak.ui.activity.YikYakDialog;

public class Ez
  implements View.OnClickListener
{
  public Ez(YikYakDialog paramYikYakDialog) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    if (YikYakDialog.a(this.a).getVisibility() == 0) {
      localIntent.putExtra("result", YikYakDialog.a(this.a).getText().toString());
    }
    if (YikYakDialog.b(this.a) != null) {
      localIntent.putExtra("value", YikYakDialog.b(this.a));
    }
    YikYakDialog.c(this.a);
    this.a.setResult(1, localIntent);
    YikYakDialog.d(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ez
 * JD-Core Version:    0.7.0.1
 */