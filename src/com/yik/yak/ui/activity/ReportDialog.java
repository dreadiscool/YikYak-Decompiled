package com.yik.yak.ui.activity;

import DI;
import DK;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ReportDialog
  extends Activity
{
  @InjectView(2131558623)
  protected CheckBox blockYakkerCheckBox;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getResources().getBoolean(2131361800)) {
      setRequestedOrientation(1);
    }
    requestWindowFeature(1);
    getWindow().setBackgroundDrawableResource(17170445);
    setFinishOnTouchOutside(false);
    setContentView(2130903100);
    ButterKnife.inject(this);
    findViewById(2131558591).setOnClickListener(new DI(this));
  }
  
  @OnClick({2131558615, 2131558617, 2131558619, 2131558621})
  public void onReportClick(View paramView)
  {
    String str = paramView.getTag().toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("result", str);
    localIntent.putExtra("KEY_SHOULD_BLOCK_YAKKER", this.blockYakkerCheckBox.isChecked());
    setResult(1, localIntent);
    DK localDK = new DK(this);
    new Handler().postDelayed(localDK, 250L);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.ReportDialog
 * JD-Core Version:    0.7.0.1
 */