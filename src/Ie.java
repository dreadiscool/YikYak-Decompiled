import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.yik.yak.ui.widget.YikYakWidget;
import com.yik.yak.ui.widget.YikYakWidgetConfigureActivity;

public class Ie
  implements View.OnClickListener
{
  public Ie(YikYakWidgetConfigureActivity paramYikYakWidgetConfigureActivity) {}
  
  public void onClick(View paramView)
  {
    YikYakWidgetConfigureActivity localYikYakWidgetConfigureActivity = this.a;
    String str = this.a.c.getText().toString();
    YikYakWidgetConfigureActivity.a(localYikYakWidgetConfigureActivity, this.a.a, str);
    YikYakWidget.a(localYikYakWidgetConfigureActivity, AppWidgetManager.getInstance(localYikYakWidgetConfigureActivity), this.a.a);
    Intent localIntent = new Intent();
    localIntent.putExtra("appWidgetId", this.a.a);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ie
 * JD-Core Version:    0.7.0.1
 */