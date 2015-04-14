package com.facebook.widget;

public enum LikeView$HorizontalAlignment
{
  static HorizontalAlignment DEFAULT = CENTER;
  private int intValue;
  private String stringValue;
  
  static
  {
    HorizontalAlignment[] arrayOfHorizontalAlignment = new HorizontalAlignment[3];
    arrayOfHorizontalAlignment[0] = CENTER;
    arrayOfHorizontalAlignment[1] = LEFT;
    arrayOfHorizontalAlignment[2] = RIGHT;
    $VALUES = arrayOfHorizontalAlignment;
  }
  
  private LikeView$HorizontalAlignment(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  static HorizontalAlignment fromInt(int paramInt)
  {
    HorizontalAlignment[] arrayOfHorizontalAlignment = values();
    int i = arrayOfHorizontalAlignment.length;
    int j = 0;
    HorizontalAlignment localHorizontalAlignment;
    if (j < i)
    {
      localHorizontalAlignment = arrayOfHorizontalAlignment[j];
      if (localHorizontalAlignment.getValue() != paramInt) {}
    }
    for (;;)
    {
      return localHorizontalAlignment;
      j++;
      break;
      localHorizontalAlignment = null;
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
 * Qualified Name:     com.facebook.widget.LikeView.HorizontalAlignment
 * JD-Core Version:    0.7.0.1
 */