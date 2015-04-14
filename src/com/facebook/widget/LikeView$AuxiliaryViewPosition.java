package com.facebook.widget;

public enum LikeView$AuxiliaryViewPosition
{
  static AuxiliaryViewPosition DEFAULT = BOTTOM;
  private int intValue;
  private String stringValue;
  
  static
  {
    AuxiliaryViewPosition[] arrayOfAuxiliaryViewPosition = new AuxiliaryViewPosition[3];
    arrayOfAuxiliaryViewPosition[0] = BOTTOM;
    arrayOfAuxiliaryViewPosition[1] = INLINE;
    arrayOfAuxiliaryViewPosition[2] = TOP;
    $VALUES = arrayOfAuxiliaryViewPosition;
  }
  
  private LikeView$AuxiliaryViewPosition(String paramString, int paramInt)
  {
    this.stringValue = paramString;
    this.intValue = paramInt;
  }
  
  static AuxiliaryViewPosition fromInt(int paramInt)
  {
    AuxiliaryViewPosition[] arrayOfAuxiliaryViewPosition = values();
    int i = arrayOfAuxiliaryViewPosition.length;
    int j = 0;
    AuxiliaryViewPosition localAuxiliaryViewPosition;
    if (j < i)
    {
      localAuxiliaryViewPosition = arrayOfAuxiliaryViewPosition[j];
      if (localAuxiliaryViewPosition.getValue() != paramInt) {}
    }
    for (;;)
    {
      return localAuxiliaryViewPosition;
      j++;
      break;
      localAuxiliaryViewPosition = null;
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
 * Qualified Name:     com.facebook.widget.LikeView.AuxiliaryViewPosition
 * JD-Core Version:    0.7.0.1
 */