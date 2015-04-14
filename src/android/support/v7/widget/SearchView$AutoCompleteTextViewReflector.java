package android.support.v7.widget;

import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

class SearchView$AutoCompleteTextViewReflector
{
  private Method doAfterTextChanged;
  private Method doBeforeTextChanged;
  private Method ensureImeVisible;
  private Method showSoftInputUnchecked;
  
  SearchView$AutoCompleteTextViewReflector()
  {
    try
    {
      this.doBeforeTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      this.doBeforeTextChanged.setAccessible(true);
      try
      {
        label27:
        this.doAfterTextChanged = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        this.doAfterTextChanged.setAccessible(true);
        try
        {
          label50:
          Class[] arrayOfClass2 = new Class[1];
          arrayOfClass2[0] = Boolean.TYPE;
          this.ensureImeVisible = AutoCompleteTextView.class.getMethod("ensureImeVisible", arrayOfClass2);
          this.ensureImeVisible.setAccessible(true);
          try
          {
            label84:
            Class[] arrayOfClass1 = new Class[2];
            arrayOfClass1[0] = Integer.TYPE;
            arrayOfClass1[1] = ResultReceiver.class;
            this.showSoftInputUnchecked = InputMethodManager.class.getMethod("showSoftInputUnchecked", arrayOfClass1);
            this.showSoftInputUnchecked.setAccessible(true);
            label124:
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException4)
          {
            break label124;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          break label84;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label50;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      break label27;
    }
  }
  
  void doAfterTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.doAfterTextChanged != null) {}
    try
    {
      this.doAfterTextChanged.invoke(paramAutoCompleteTextView, new Object[0]);
      label20:
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  void doBeforeTextChanged(AutoCompleteTextView paramAutoCompleteTextView)
  {
    if (this.doBeforeTextChanged != null) {}
    try
    {
      this.doBeforeTextChanged.invoke(paramAutoCompleteTextView, new Object[0]);
      label20:
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  void ensureImeVisible(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean)
  {
    if (this.ensureImeVisible != null) {}
    try
    {
      Method localMethod = this.ensureImeVisible;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(paramAutoCompleteTextView, arrayOfObject);
      label36:
      return;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  void showSoftInputUnchecked(InputMethodManager paramInputMethodManager, View paramView, int paramInt)
  {
    if (this.showSoftInputUnchecked != null) {}
    for (;;)
    {
      try
      {
        Method localMethod = this.showSoftInputUnchecked;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        arrayOfObject[1] = null;
        localMethod.invoke(paramInputMethodManager, arrayOfObject);
        return;
      }
      catch (Exception localException) {}
      paramInputMethodManager.showSoftInput(paramView, paramInt);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView.AutoCompleteTextViewReflector
 * JD-Core Version:    0.7.0.1
 */