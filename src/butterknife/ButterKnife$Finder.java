package butterknife;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import java.util.List;

public enum ButterKnife$Finder
{
  static
  {
    ACTIVITY = new ButterKnife.Finder.2("ACTIVITY", 1);
    DIALOG = new ButterKnife.Finder.3("DIALOG", 2);
    Finder[] arrayOfFinder = new Finder[3];
    arrayOfFinder[0] = VIEW;
    arrayOfFinder[1] = ACTIVITY;
    arrayOfFinder[2] = DIALOG;
    $VALUES = arrayOfFinder;
  }
  
  private ButterKnife$Finder() {}
  
  public static <T> T[] arrayOf(T... paramVarArgs)
  {
    return paramVarArgs;
  }
  
  public static <T> List<T> listOf(T... paramVarArgs)
  {
    return new ImmutableList(paramVarArgs);
  }
  
  public <T> T castParam(Object paramObject, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    return paramObject;
  }
  
  public <T> T castView(View paramView, int paramInt, String paramString)
  {
    return paramView;
  }
  
  public <T> T findOptionalView(Object paramObject, int paramInt, String paramString)
  {
    return castView(findView(paramObject, paramInt), paramInt, paramString);
  }
  
  public <T> T findRequiredView(Object paramObject, int paramInt, String paramString)
  {
    Object localObject = findOptionalView(paramObject, paramInt, paramString);
    if (localObject == null)
    {
      String str = getContext(paramObject).getResources().getResourceEntryName(paramInt);
      throw new IllegalStateException("Required view '" + str + "' with ID " + paramInt + " for " + paramString + " was not found. If this view is optional add '@Optional' annotation.");
    }
    return localObject;
  }
  
  protected abstract View findView(Object paramObject, int paramInt);
  
  protected abstract Context getContext(Object paramObject);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife.Finder
 * JD-Core Version:    0.7.0.1
 */