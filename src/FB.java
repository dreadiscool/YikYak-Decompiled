import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FB
  extends Fa
{
  private View b;
  private Context c = null;
  private CM d;
  private String[] e;
  
  public void a()
  {
    String str1 = ((EditText)this.b.findViewById(2131558638)).getText().toString();
    Object localObject = ((Spinner)this.b.findViewById(2131558639)).getSelectedItem();
    if (localObject == null) {
      Toast.makeText(getActivity(), "You must enter a category first.", 0).show();
    }
    for (;;)
    {
      return;
      String str2 = localObject.toString();
      long l = ((Spinner)this.b.findViewById(2131558639)).getSelectedItemId();
      String str3 = ((EditText)this.b.findViewById(2131558640)).getText().toString();
      if (str3.length() == 0)
      {
        Toast.makeText(this.c, "You must enter a comment first.", 0).show();
        continue;
      }
      if ((str1.length() != 0) && (!Patterns.EMAIL_ADDRESS.matcher(str1).matches()))
      {
        Toast.makeText(this.c, "You must either enter a valid email or leave it blank.", 0).show();
        continue;
      }
      if ((str2.length() == 0) || (str2.equalsIgnoreCase("Select category")))
      {
        Toast.makeText(this.c, "Please select a category.", 0).show();
        continue;
      }
      If.a().c(str2);
      this.b.findViewById(2131558640).clearFocus();
      try
      {
        ((InputMethodManager)this.c.getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindowToken(), 0);
        if (l == 6L)
        {
          str4 = str3 + this.d.e();
          TreeMap localTreeMap = new TreeMap();
          localTreeMap.put("userID", ApplicationConfig.getYakkerID());
          localTreeMap.put("email", str1);
          localTreeMap.put("category", str2);
          localTreeMap.put("message", str4);
          String str5 = UrlHelper.b(CR.f(), "contactUs", localTreeMap, null);
          zC localzC = zC.a(zt.a("application/x-www-form-urlencoded"), (String)localTreeMap.get("RequestBody:body"));
          zz localzz = new zB().a(localzC).a(str5).b();
          UrlHelper.a(true).a(localzz).a(new FE(this));
          Toast.makeText(this.c, "You have contacted Yik Yak", 1).show();
          getFragmentManager().popBackStackImmediate();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          String str4 = str3;
        }
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(2131755010, paramMenu);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.b = paramLayoutInflater.inflate(2130903104, paramViewGroup, false);
    this.c = this.b.getContext();
    this.d = CM.a(this.c);
    this.e = getResources().getStringArray(2131296257);
    ((LinearLayout)this.b.findViewById(2131558636)).setOnClickListener(new FC(this));
    TextView localTextView = (TextView)this.b.findViewById(2131558637);
    localTextView.setLinksClickable(true);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    Linkify.addLinks(localTextView, Patterns.WEB_URL, "com.yik.yak.faq:");
    ((EditText)this.b.findViewById(2131558638)).requestFocus();
    this.b.findViewById(2131558640);
    FF localFF = new FF(this.c, 2130903074, Arrays.asList(getResources().getStringArray(2131296256)), null);
    localFF.setDropDownViewResource(17367049);
    Spinner localSpinner = (Spinner)this.b.findViewById(2131558639);
    localSpinner.setAdapter(localFF);
    localSpinner.setSelection(-1);
    localSpinner.setOnItemSelectedListener(new FD(this));
    setHasOptionsMenu(true);
    return this.b;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (boolean bool = super.onOptionsItemSelected(paramMenuItem);; bool = true)
    {
      return bool;
      a();
    }
  }
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     FB

 * JD-Core Version:    0.7.0.1

 */