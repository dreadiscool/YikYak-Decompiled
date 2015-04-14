import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class GD
  extends ArrayAdapter<CG>
{
  final int a = Ik.a(10);
  final int b = Ik.a(20);
  final int c = Ik.a(40);
  final int d = Ik.a(45);
  final int e = Ik.a(60);
  final float f = Gz.e(this.h).getResources().getDimension(2131492993);
  final float g = Gz.e(this.h).getResources().getDimension(2131492995);
  private int i;
  
  public GD(Context paramContext, int paramInt, List<CG> paramList)
  {
    super(paramInt, paramList, localList);
    this.i = paramList;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CG localCG = (CG)getItem(paramInt);
    String str = localCG.b;
    if (paramView == null) {
      paramView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(this.i, paramViewGroup, false);
    }
    TextView localTextView = (TextView)paramView.findViewById(2131558785);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131558782);
    localImageView1.setVisibility(8);
    Button localButton = (Button)paramView.findViewById(2131558784);
    localButton.setVisibility(8);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131558783);
    localImageView2.setVisibility(8);
    if (localCG.a())
    {
      paramView.setBackgroundResource(2131427593);
      localTextView.setMaxLines(3);
      localTextView.setEllipsize(null);
      localTextView.setPadding(this.a, 0, 0, 0);
      localTextView.setTextColor(this.h.getResources().getColor(2131427594));
      localTextView.setTextSize(0, this.f);
      if (localCG.b.equals("My Peeks"))
      {
        localButton.bringToFront();
        localButton.setVisibility(0);
        localButton.setOnClickListener(new GE(this));
      }
    }
    for (;;)
    {
      localTextView.setText(str);
      return paramView;
      if (localCG.k)
      {
        localImageView1.setVisibility(0);
        localImageView1.setOnClickListener(new GF(this));
        paramView.setBackgroundResource(2131427656);
        localTextView.setMaxLines(3);
        localTextView.setEllipsize(null);
        localTextView.setPadding(this.d, 0, 0, 0);
        localTextView.setTextColor(this.h.getResources().getColor(2131427548));
        localTextView.setTextSize(0, this.g);
      }
      else
      {
        paramView.setBackgroundResource(2131427656);
        localTextView.setMaxLines(1);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setBackgroundResource(2130837822);
        localTextView.setTextColor(this.h.getResources().getColor(2131427596));
        localTextView.setTextSize(0, this.f);
        if (localCG.m)
        {
          localImageView2.setVisibility(0);
          localTextView.setPadding(this.b, 0, this.a, 0);
        }
        else
        {
          localImageView2.setVisibility(8);
          localTextView.setPadding(this.a, 0, this.a, 0);
        }
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     GD
 * JD-Core Version:    0.7.0.1
 */