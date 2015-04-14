package com.yik.yak.ui.activity;

import EA;
import EB;
import Ez;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YikYakDialog
  extends Activity
{
  private EditText a = null;
  private String b = null;
  
  private void a()
  {
    EB localEB = new EB(this);
    new Handler().postDelayed(localEB, 250L);
  }
  
  private void b()
  {
    try
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(findViewById(16908290).getRootView().getWindowToken(), 0);
      label26:
      return;
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getResources().getBoolean(2131361800)) {
      setRequestedOrientation(1);
    }
    requestWindowFeature(1);
    getWindow().setBackgroundDrawableResource(17170445);
    setFinishOnTouchOutside(false);
    setContentView(2130903102);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      setTitle(localBundle.getString("title", "Dialog"));
      this.a = ((EditText)findViewById(2131558626));
      if (!localBundle.containsKey("editText")) {
        break label341;
      }
      this.a.setVisibility(0);
      this.a.setText(localBundle.getString("editText", ""));
      this.a.setSelection(this.a.getText().length());
    }
    for (;;)
    {
      if (localBundle.containsKey("value")) {
        this.b = localBundle.getString("value", "");
      }
      ((TextView)findViewById(2131558585)).setText(localBundle.getString("title", "Dialog"));
      TextView localTextView = (TextView)findViewById(2131558625);
      localTextView.setText(localBundle.getString("message", "Message"));
      if ((localBundle.containsKey("align")) && (localBundle.getString("align", "").equals("left"))) {
        localTextView.setGravity(8388627);
      }
      ((TextView)findViewById(2131558628)).setText(localBundle.getString("okText", "OK"));
      ((TextView)findViewById(2131558627)).setText(localBundle.getString("cancelText", "CANCEL"));
      ((LinearLayout)findViewById(2131558630)).setOnClickListener(new Ez(this));
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131558629);
      localLinearLayout.setOnClickListener(new EA(this));
      if (localBundle.containsKey("okOnly")) {
        localLinearLayout.setVisibility(8);
      }
      for (;;)
      {
        return;
        a();
      }
      label341:
      this.a.setVisibility(8);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.YikYakDialog
 * JD-Core Version:    0.7.0.1
 */