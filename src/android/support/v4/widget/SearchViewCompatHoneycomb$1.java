package android.support.v4.widget;

import android.widget.SearchView.OnQueryTextListener;

final class SearchViewCompatHoneycomb$1
  implements SearchView.OnQueryTextListener
{
  SearchViewCompatHoneycomb$1(SearchViewCompatHoneycomb.OnQueryTextListenerCompatBridge paramOnQueryTextListenerCompatBridge) {}
  
  public boolean onQueryTextChange(String paramString)
  {
    return this.val$listener.onQueryTextChange(paramString);
  }
  
  public boolean onQueryTextSubmit(String paramString)
  {
    return this.val$listener.onQueryTextSubmit(paramString);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SearchViewCompatHoneycomb.1
 * JD-Core Version:    0.7.0.1
 */