import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class wK
  extends wM
{
  private final Map<TextView, TextWatcher> a = new HashMap();
  
  public wK(List<wr> paramList, String paramString, wN paramwN)
  {
    super(paramList, paramString, paramwN, true);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getKey()).removeTextChangedListener((TextWatcher)localEntry.getValue());
    }
    this.a.clear();
  }
  
  public void a(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      TextView localTextView = (TextView)paramView;
      wL localwL = new wL(this, localTextView);
      TextWatcher localTextWatcher = (TextWatcher)this.a.get(localTextView);
      if (localTextWatcher != null) {
        localTextView.removeTextChangedListener(localTextWatcher);
      }
      localTextView.addTextChangedListener(localwL);
      this.a.put(localTextView, localwL);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     wK
 * JD-Core Version:    0.7.0.1
 */