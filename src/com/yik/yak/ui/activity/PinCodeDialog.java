package com.yik.yak.ui.activity;

import DA;
import DB;
import DC;
import DD;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PinCodeDialog
  extends Activity
{
  private Context a;
  private Vibrator b;
  private String c = "";
  private View.OnClickListener d = new DA(this);
  private String e = "";
  
  private void a()
  {
    DD localDD = new DD(this);
    new Handler().postDelayed(localDD, 250L);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getResources().getBoolean(2131361800)) {
      setRequestedOrientation(1);
    }
    requestWindowFeature(1);
    setContentView(2130903099);
    TextView localTextView = (TextView)findViewById(2131558585);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      localTextView.setText(localBundle.getString("title", getResources().getString(2131230958)));
      this.e = localBundle.getString("pin", "");
    }
    for (;;)
    {
      this.a = this;
      findViewById(2131558608).setOnClickListener(this.d);
      findViewById(2131558598).setOnClickListener(this.d);
      findViewById(2131558599).setOnClickListener(this.d);
      findViewById(2131558600).setOnClickListener(this.d);
      findViewById(2131558601).setOnClickListener(this.d);
      findViewById(2131558602).setOnClickListener(this.d);
      findViewById(2131558603).setOnClickListener(this.d);
      findViewById(2131558604).setOnClickListener(this.d);
      findViewById(2131558605).setOnClickListener(this.d);
      findViewById(2131558606).setOnClickListener(this.d);
      findViewById(2131558607).setOnClickListener(this.d);
      findViewById(2131558609).setOnClickListener(this.d);
      this.b = ((Vibrator)this.a.getSystemService("vibrator"));
      findViewById(2131558611).setOnClickListener(new DB(this));
      findViewById(2131558614);
      findViewById(2131558612);
      findViewById(2131558613).setOnClickListener(new DC(this));
      return;
      localTextView.setText(getResources().getString(2131230958));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.PinCodeDialog
 * JD-Core Version:    0.7.0.1
 */