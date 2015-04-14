import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ScrollView;
import android.widget.TextView;

class N
  implements Runnable
{
  N(G paramG, Activity paramActivity, R paramR, as paramas, Lg paramLg) {}
  
  public void run()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.a);
    O localO = new O(this);
    float f = this.a.getResources().getDisplayMetrics().density;
    int i = G.a(this.e, f, 5);
    TextView localTextView = new TextView(this.a);
    localTextView.setAutoLinkMask(15);
    localTextView.setText(this.c.b());
    localTextView.setTextAppearance(this.a, 16973892);
    localTextView.setPadding(i, i, i, i);
    localTextView.setFocusable(false);
    ScrollView localScrollView = new ScrollView(this.a);
    localScrollView.setPadding(G.a(this.e, f, 14), G.a(this.e, f, 2), G.a(this.e, f, 10), G.a(this.e, f, 12));
    localScrollView.addView(localTextView);
    localBuilder.setView(localScrollView).setTitle(this.c.a()).setCancelable(false).setNeutralButton(this.c.c(), localO);
    if (this.d.d)
    {
      P localP = new P(this);
      localBuilder.setNegativeButton(this.c.e(), localP);
    }
    if (this.d.f)
    {
      Q localQ = new Q(this);
      localBuilder.setPositiveButton(this.c.d(), localQ);
    }
    localBuilder.show();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     N
 * JD-Core Version:    0.7.0.1
 */