import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.LinkedList;

public abstract class gM<T extends gL>
{
  private T a;
  private Bundle b;
  private LinkedList<gT> c;
  private final gY<T> d = new gN(this);
  
  private void a(int paramInt)
  {
    while ((!this.c.isEmpty()) && (((gT)this.c.getLast()).a() >= paramInt)) {
      this.c.removeLast();
    }
  }
  
  private void a(Bundle paramBundle, gT paramgT)
  {
    if (this.a != null)
    {
      paramgT.a(this.a);
      return;
    }
    if (this.c == null) {
      this.c = new LinkedList();
    }
    this.c.add(paramgT);
    if (paramBundle != null)
    {
      if (this.b != null) {
        break label78;
      }
      this.b = ((Bundle)paramBundle.clone());
    }
    for (;;)
    {
      a(this.d);
      break;
      label78:
      this.b.putAll(paramBundle);
    }
  }
  
  public static void b(FrameLayout paramFrameLayout)
  {
    Context localContext = paramFrameLayout.getContext();
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(localContext);
    String str1 = GooglePlayServicesUtil.b(localContext, i);
    String str2 = GooglePlayServicesUtil.c(localContext, i);
    LinearLayout localLinearLayout = new LinearLayout(paramFrameLayout.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramFrameLayout.addView(localLinearLayout);
    TextView localTextView = new TextView(paramFrameLayout.getContext());
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    localTextView.setText(str1);
    localLinearLayout.addView(localTextView);
    if (str2 != null)
    {
      Button localButton = new Button(localContext);
      localButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      localButton.setText(str2);
      localLinearLayout.addView(localButton);
      localButton.setOnClickListener(new gR(localContext, i));
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramLayoutInflater.getContext());
    a(paramBundle, new gQ(this, localFrameLayout, paramLayoutInflater, paramViewGroup, paramBundle));
    if (this.a == null) {
      a(localFrameLayout);
    }
    return localFrameLayout;
  }
  
  public T a()
  {
    return this.a;
  }
  
  public void a(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
  {
    a(paramBundle2, new gO(this, paramActivity, paramBundle1, paramBundle2));
  }
  
  public void a(Bundle paramBundle)
  {
    a(paramBundle, new gP(this, paramBundle));
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    b(paramFrameLayout);
  }
  
  protected abstract void a(gY<T> paramgY);
  
  public void b()
  {
    a(null, new gS(this));
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.b(paramBundle);
    }
    for (;;)
    {
      return;
      if (this.b != null) {
        paramBundle.putAll(this.b);
      }
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.b();
    }
    for (;;)
    {
      return;
      a(5);
    }
  }
  
  public void d()
  {
    if (this.a != null) {
      this.a.c();
    }
    for (;;)
    {
      return;
      a(2);
    }
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.d();
    }
    for (;;)
    {
      return;
      a(1);
    }
  }
  
  public void f()
  {
    if (this.a != null) {
      this.a.e();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     gM
 * JD-Core Version:    0.7.0.1
 */