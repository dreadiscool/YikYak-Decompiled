import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EI
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  protected Context a;
  protected HashMap<String, ArrayList<CJ>> b = new HashMap();
  protected LayoutInflater c;
  private EK d;
  
  public EI(Context paramContext, HashMap<String, ArrayList<CJ>> paramHashMap)
  {
    this.a = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.b = paramHashMap;
  }
  
  private int a()
  {
    return 2130903118;
  }
  
  private void a(CJ paramCJ)
  {
    if (this.d != null) {
      this.d.a(paramCJ);
    }
  }
  
  private int b()
  {
    return 2130903120;
  }
  
  private boolean b(int paramInt)
  {
    if ((a(paramInt) instanceof String)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Object a(int paramInt)
  {
    Iterator localIterator1 = this.b.keySet().iterator();
    int i = 0;
    Object localObject;
    if (localIterator1.hasNext())
    {
      localObject = (String)localIterator1.next();
      if (i != paramInt) {}
    }
    for (;;)
    {
      return localObject;
      i++;
      Iterator localIterator2 = ((ArrayList)this.b.get(localObject)).iterator();
      for (;;)
      {
        if (!localIterator2.hasNext()) {
          break label94;
        }
        localObject = (CJ)localIterator2.next();
        if (i == paramInt) {
          break;
        }
        i++;
      }
      label94:
      break;
      localObject = null;
    }
  }
  
  public void a(EK paramEK)
  {
    this.d = paramEK;
  }
  
  public int getItemCount()
  {
    Iterator localIterator = this.b.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      i += ((ArrayList)this.b.get(str)).size();
    }
    return i + this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (b(paramInt)) {}
    for (int i = 0;; i = 1) {
      return i;
    }
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof EJ)) {
      ((EJ)paramViewHolder).a((String)a(paramInt));
    }
    for (;;)
    {
      return;
      if ((paramViewHolder instanceof EL)) {
        ((EL)paramViewHolder).a((CJ)a(paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = new EJ(this, this.c.inflate(a(), paramViewGroup, false));
      continue;
      localObject = new EL(this, this.c.inflate(b(), paramViewGroup, false));
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EI
 * JD-Core Version:    0.7.0.1
 */