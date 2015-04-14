import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class EN<T extends EV, K>
  extends RecyclerView.Adapter<T>
{
  private Context context;
  private ArrayList<K> data = new ArrayList();
  public LayoutInflater layoutInflater;
  private EP listener;
  protected boolean mIsContextMenuEnabled = true;
  protected boolean mShouldContextMenuShowOnSingleClick = false;
  
  public EN(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EN(Context paramContext, ArrayList<K> paramArrayList)
  {
    this.context = paramContext;
    this.layoutInflater = LayoutInflater.from(paramContext);
    setData(paramArrayList);
  }
  
  public void assignClickListener(T paramT, View paramView, int paramInt)
  {
    paramView.setOnClickListener(new EO(this, paramT, paramView, paramInt));
  }
  
  public void broadcastClick(T paramT, View paramView, int paramInt)
  {
    if ((!paramT.onClick(paramView)) && (this.listener != null)) {
      this.listener.a(paramT, this, paramInt);
    }
  }
  
  public T buildViewHolderInstance(Constructor<? extends EV> paramConstructor, View paramView, int paramInt)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this;
    arrayOfObject[1] = paramView;
    return (EV)paramConstructor.newInstance(arrayOfObject);
  }
  
  public Constructor<? extends EV> getConstructor(Class<? extends EV> paramClass)
  {
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = EN.class;
      arrayOfClass[1] = View.class;
      Constructor localConstructor2 = paramClass.getConstructor(arrayOfClass);
      localConstructor1 = localConstructor2;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
        Constructor localConstructor1 = null;
      }
    }
    return localConstructor1;
  }
  
  protected Context getContext()
  {
    return this.context;
  }
  
  public ArrayList<K> getData()
  {
    return this.data;
  }
  
  public K getItem(int paramInt)
  {
    return this.data.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.data.size();
  }
  
  public abstract int getLayoutId();
  
  public EP getListener()
  {
    return this.listener;
  }
  
  public abstract Class getViewHolderClass();
  
  public boolean isContextMenuEnabled()
  {
    return this.mIsContextMenuEnabled;
  }
  
  public void onBindViewHolder(T paramT, int paramInt)
  {
    assignClickListener(paramT, paramT.getView(), paramInt);
    paramT.bindView(getItem(paramInt));
  }
  
  public T onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.layoutInflater.inflate(getLayoutId(), paramViewGroup, false);
    Constructor localConstructor = getConstructor(getViewHolderClass());
    try
    {
      EV localEV2 = buildViewHolderInstance(localConstructor, localView, paramInt);
      localEV1 = localEV2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
        EV localEV1 = null;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localInstantiationException.printStackTrace();
      }
    }
    return localEV1;
  }
  
  public void setContextMenuEnabled(boolean paramBoolean)
  {
    this.mIsContextMenuEnabled = paramBoolean;
    notifyDataSetChanged();
  }
  
  public void setData(ArrayList<K> paramArrayList)
  {
    if (paramArrayList == null) {
      paramArrayList = new ArrayList();
    }
    this.data = paramArrayList;
  }
  
  public void setOnItemClickListener(EP paramEP)
  {
    this.listener = paramEP;
  }
  
  public void setShouldContextMenuShowOnSingleClick(boolean paramBoolean)
  {
    this.mShouldContextMenuShowOnSingleClick = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean shouldContextMenuShowOnSingleClick()
  {
    return this.mShouldContextMenuShowOnSingleClick;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     EN
 * JD-Core Version:    0.7.0.1
 */