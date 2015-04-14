import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yik.yak.ui.typeface.CustomTypefaceSpan;
import java.util.List;

public class EH
  extends ArrayAdapter<Cu>
{
  private int a;
  private Context b;
  
  public EH(Context paramContext, int paramInt, List<Cu> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.b = paramContext;
    this.a = paramInt;
  }
  
  private SpannableStringBuilder a(Cu paramCu, Typeface paramTypeface, int paramInt1, int paramInt2)
  {
    SpannableStringBuilder localSpannableStringBuilder;
    if (Ik.a(paramCu.f()))
    {
      String str2 = paramCu.c();
      localSpannableStringBuilder = new SpannableStringBuilder(str2);
      localSpannableStringBuilder.setSpan(new CustomTypefaceSpan(paramInt2, paramTypeface), 0, str2.length(), 33);
    }
    for (;;)
    {
      return localSpannableStringBuilder;
      String str1 = paramCu.f() + " \"" + paramCu.e() + "\"";
      int i = paramCu.f().length();
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      localSpannableStringBuilder.setSpan(new CustomTypefaceSpan(paramInt1, paramTypeface), 0, i, 33);
      localSpannableStringBuilder.setSpan(new CustomTypefaceSpan(paramInt2, paramTypeface), i + 1, str1.length(), 33);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Cu localCu = (Cu)getItem(paramInt);
    if (paramView == null) {
      paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.a, paramViewGroup, false);
    }
    if ((localCu.i().equals("new")) || (localCu.i().equals("unread"))) {
      paramView.setBackgroundResource(2130837794);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131558778);
      localImageView.setBackgroundResource(0);
      localImageView.setImageResource(localCu.g());
      ((TextView)paramView.findViewById(2131558780)).setText(a(localCu, Typeface.DEFAULT, this.b.getResources().getColor(localCu.h()), this.b.getResources().getColor(2131427588)));
      if (!Ik.a(localCu.d())) {
        ((TextView)paramView.findViewById(2131558779)).setText(Ik.a(localCu.d(), "GMT"));
      }
      return paramView;
      paramView.setBackgroundResource(2130837793);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EH
 * JD-Core Version:    0.7.0.1
 */