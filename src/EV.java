import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import java.util.ArrayList;

public abstract class EV<E>
  extends RecyclerView.ViewHolder
  implements View.OnCreateContextMenuListener
{
  protected EN adapter;
  protected E item;
  private View view;
  
  public EV(EN paramEN, View paramView)
  {
    super(paramView);
    this.adapter = paramEN;
    this.view = paramView;
  }
  
  public void bindView(E paramE)
  {
    this.item = paramE;
    onBindView(paramE);
    if (getAdapter().isContextMenuEnabled()) {
      this.view.setOnCreateContextMenuListener(this);
    }
    for (;;)
    {
      return;
      this.view.setOnCreateContextMenuListener(null);
    }
  }
  
  public void broadcastClick()
  {
    getAdapter().broadcastClick(this, getView(), getData().indexOf(getItem()));
  }
  
  public EN getAdapter()
  {
    return this.adapter;
  }
  
  public int getColor(int paramInt)
  {
    return getContext().getResources().getColor(paramInt);
  }
  
  public Context getContext()
  {
    return getView().getContext();
  }
  
  public ArrayList<E> getData()
  {
    return this.adapter.getData();
  }
  
  protected Drawable getDrawable(int paramInt)
  {
    return getContext().getResources().getDrawable(paramInt);
  }
  
  public E getItem()
  {
    return this.item;
  }
  
  public String getString(int paramInt)
  {
    return getContext().getString(paramInt);
  }
  
  public View getView()
  {
    return this.view;
  }
  
  public abstract void onBindView(E paramE);
  
  public boolean onClick(View paramView)
  {
    if ((getAdapter().isContextMenuEnabled()) && (getAdapter().shouldContextMenuShowOnSingleClick())) {
      paramView.showContextMenu();
    }
    return false;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {}
  
  public boolean onDoubleClick(View paramView)
  {
    return false;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EV
 * JD-Core Version:    0.7.0.1
 */