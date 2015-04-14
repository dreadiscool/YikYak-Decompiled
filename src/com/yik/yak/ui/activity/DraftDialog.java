package com.yik.yak.ui.activity;

import Dd;
import De;
import Df;
import Dg;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

public class DraftDialog
  extends Activity
{
  private void a()
  {
    Dg localDg = new Dg(this);
    new Handler().postDelayed(localDg, 250L);
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
    setContentView(2130903098);
    findViewById(2131558585);
    findViewById(2131558587).setOnClickListener(new Dd(this));
    findViewById(2131558591).setOnClickListener(new De(this));
    findViewById(2131558589).setOnClickListener(new Df(this));
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.DraftDialog
 * JD-Core Version:    0.7.0.1
 */