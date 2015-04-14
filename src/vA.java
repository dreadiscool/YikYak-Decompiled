import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.List;

public class vA
  implements ListAdapter
{
  private final List<String> a;
  private final LayoutInflater b;
  
  public vA(List<String> paramList, LayoutInflater paramLayoutInflater)
  {
    this.a = paramList;
    this.b = paramLayoutInflater;
  }
  
  public String a(int paramInt)
  {
    return (String)this.a.get(paramInt);
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i;
    if (paramInt == 0) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (paramInt == -1 + this.a.size()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = -1;
    if (paramView == null) {
      switch (getItemViewType(paramInt))
      {
      }
    }
    for (;;)
    {
      paramView = this.b.inflate(i, paramViewGroup, false);
      ((TextView)paramView.findViewById(tn.com_mixpanel_android_multiple_choice_answer_text)).setText((String)this.a.get(paramInt));
      return paramView;
      i = to.com_mixpanel_android_first_choice_answer;
      continue;
      i = to.com_mixpanel_android_last_choice_answer;
      continue;
      i = to.com_mixpanel_android_middle_choice_answer;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     vA
 * JD-Core Version:    0.7.0.1
 */