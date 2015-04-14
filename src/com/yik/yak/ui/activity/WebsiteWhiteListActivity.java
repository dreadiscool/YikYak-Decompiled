package com.yik.yak.ui.activity;

import CJ;
import Cb;
import EI;
import EK;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;

public class WebsiteWhiteListActivity
  extends BaseYikYakActivity
  implements EK
{
  protected HashMap<String, ArrayList<CJ>> a = new HashMap();
  protected RecyclerView b;
  protected EI c;
  
  private void a()
  {
    setContentView(2130903072);
    this.b = ((RecyclerView)findViewById(2131558523));
    this.b.setLayoutManager(new LinearLayoutManager(this));
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, WebActivity.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("url", paramString2);
    localIntent.putExtra("shareEnabled", true);
    startActivityForResult(localIntent, 100);
  }
  
  private void b()
  {
    for (CJ localCJ : )
    {
      String str = localCJ.c();
      if (!this.a.containsKey(str)) {
        this.a.put(str, new ArrayList());
      }
      if (localCJ.a()) {
        ((ArrayList)this.a.get(str)).add(localCJ);
      }
    }
    this.c = new EI(this, this.a);
    this.b.setAdapter(this.c);
  }
  
  private void c()
  {
    this.c.a(this);
  }
  
  public void a(CJ paramCJ)
  {
    a(paramCJ.d(), paramCJ.e());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        break;
      case 100: 
        setResult(-1, paramIntent);
        finish();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    b();
    c();
    overridePendingTransition(2130968597, 2130968598);
  }
  
  protected void onPause()
  {
    super.onPause();
    overridePendingTransition(2130968597, 2130968598);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.yik.yak.ui.activity.WebsiteWhiteListActivity
 * JD-Core Version:    0.7.0.1
 */