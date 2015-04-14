package com.yik.yak.ui.widget;

import Ie;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class YikYakWidgetConfigureActivity
  extends Activity
{
  public int a = 0;
  View.OnClickListener b = new Ie(this);
  public EditText c;
  
  static String a(Context paramContext, int paramInt)
  {
    String str = paramContext.getSharedPreferences("com.yik.yak.ui.widget.YikYakWidget", 0).getString("appwidget_" + paramInt, null);
    if (str != null) {}
    for (;;)
    {
      return str;
      str = paramContext.getString(2131230799);
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("com.yik.yak.ui.widget.YikYakWidget", 0).edit();
    localEditor.putString("appwidget_" + paramInt, paramString);
    localEditor.commit();
  }
  
  static void b(Context paramContext, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("com.yik.yak.ui.widget.YikYakWidget", 0).edit();
    localEditor.remove("appwidget_" + paramInt);
    localEditor.commit();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(0);
    setContentView(2130903144);
    this.c = ((EditText)findViewById(2131558810));
    findViewById(2131558811).setOnClickListener(this.b);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      this.a = localBundle.getInt("appWidgetId", 0);
    }
    if (this.a == 0) {
      finish();
    }
    for (;;)
    {
      return;
      this.c.setText(a(this, this.a));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.widget.YikYakWidgetConfigureActivity
 * JD-Core Version:    0.7.0.1
 */