package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter
  extends Filter
{
  CursorFilter.CursorFilterClient mClient;
  
  CursorFilter(CursorFilter.CursorFilterClient paramCursorFilterClient)
  {
    this.mClient = paramCursorFilterClient;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return this.mClient.convertToString((Cursor)paramObject);
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Cursor localCursor = this.mClient.runQueryOnBackgroundThread(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (localCursor != null) {
      localFilterResults.count = localCursor.getCount();
    }
    for (localFilterResults.values = localCursor;; localFilterResults.values = null)
    {
      return localFilterResults;
      localFilterResults.count = 0;
    }
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    Cursor localCursor = this.mClient.getCursor();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != localCursor)) {
      this.mClient.changeCursor((Cursor)paramFilterResults.values);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CursorFilter
 * JD-Core Version:    0.7.0.1
 */