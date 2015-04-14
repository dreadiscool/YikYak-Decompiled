import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

class EL
  extends RecyclerView.ViewHolder
{
  private ImageView b;
  private TextView c;
  
  public EL(EI paramEI, View paramView)
  {
    super(paramView);
    this.b = ((ImageView)paramView.findViewById(2131558754));
    this.c = ((TextView)paramView.findViewById(2131558755));
  }
  
  public void a(CJ paramCJ)
  {
    this.itemView.setOnClickListener(new EM(this, paramCJ));
    Picasso.with(this.a.a).load(paramCJ.e() + "/favicon.ico").into(this.b);
    this.c.setText(paramCJ.d());
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EL
 * JD-Core Version:    0.7.0.1
 */