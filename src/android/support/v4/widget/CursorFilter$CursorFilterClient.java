package android.support.v4.widget;

import android.database.Cursor;

abstract interface CursorFilter$CursorFilterClient
{
  public abstract void changeCursor(Cursor paramCursor);
  
  public abstract CharSequence convertToString(Cursor paramCursor);
  
  public abstract Cursor getCursor();
  
  public abstract Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence);
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CursorFilter.CursorFilterClient
 * JD-Core Version:    0.7.0.1
 */