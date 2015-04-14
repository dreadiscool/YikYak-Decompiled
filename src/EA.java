import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.yik.yak.ui.activity.YikYakDialog;

public class EA
  implements View.OnClickListener
{
  public EA(YikYakDialog paramYikYakDialog) {}
  
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
    this.a.setResult(0, localIntent);
    YikYakDialog.d(this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EA
 * JD-Core Version:    0.7.0.1
 */