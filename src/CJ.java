import android.content.ContentValues;
import android.database.Cursor;

public class CJ
{
  @pp(a="display")
  boolean a;
  String b;
  String c;
  String d;
  
  public CJ(Cursor paramCursor)
  {
    if (paramCursor.getInt(paramCursor.getColumnIndex("display")) == i) {}
    for (;;)
    {
      this.a = i;
      this.b = paramCursor.getString(paramCursor.getColumnIndex("category"));
      this.c = paramCursor.getString(paramCursor.getColumnIndex("name"));
      this.d = paramCursor.getString(paramCursor.getColumnIndex("url"));
      return;
      i = 0;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public ContentValues b()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.a) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("display", Integer.valueOf(i));
      localContentValues.put("category", this.b);
      localContentValues.put("name", this.c);
      localContentValues.put("url", this.d);
      return localContentValues;
    }
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.d;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     CJ
 * JD-Core Version:    0.7.0.1
 */