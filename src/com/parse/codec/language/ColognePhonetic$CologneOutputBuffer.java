package com.parse.codec.language;

class ColognePhonetic$CologneOutputBuffer
  extends ColognePhonetic.CologneBuffer
{
  public ColognePhonetic$CologneOutputBuffer(ColognePhonetic paramColognePhonetic, int paramInt)
  {
    super(paramColognePhonetic, paramInt);
  }
  
  public void addRight(char paramChar)
  {
    this.data[this.length] = paramChar;
    this.length = (1 + this.length);
  }
  
  protected char[] copyData(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    System.arraycopy(this.data, paramInt1, arrayOfChar, 0, paramInt2);
    return arrayOfChar;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.ColognePhonetic.CologneOutputBuffer
 * JD-Core Version:    0.7.0.1
 */