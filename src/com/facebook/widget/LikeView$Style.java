package com.facebook.widget;

public enum LikeView$Style
{
  static Style DEFAULT = STANDARD;
  private int intValue;
  private String stringValue;
  
  static
  {
    BUTTON = new Style("BUTTON", 1, "button", 1);
    BOX_COUNT = new Style("BOX_COUNT", 2, "box_count", 2);
    Style[] arrayOfStyle = new Style[3];
    arrayOfStyle[0] = STANDARD;
    arrayOfStyle[1] = BUTTON;
    arrayOfStyle[2] = BOX_COUNT;
    $VALUES = arrayOfStyle;
  }
  
  private LikeView$Style(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  static Style fromInt(int paramInt)
  {
    Style[] arrayOfStyle = values();
    int i = arrayOfStyle.length;
    int j = 0;
    Style localStyle;
    if (j < i)
    {
      localStyle = arrayOfStyle[j];
      if (localStyle.getValue() != paramInt) {}
    }
    for (;;)
    {
      return localStyle;
      j++;
      break;
      localStyle = null;
    }
  }
  
  private int getValue()
  {
    return this.intValue;
  }
  
  public String toString()
  {
    return this.stringValue;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.LikeView.Style
 * JD-Core Version:    0.7.0.1
 */