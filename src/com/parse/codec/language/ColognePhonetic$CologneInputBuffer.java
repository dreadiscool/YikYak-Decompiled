package com.parse.codec.language;

class ColognePhonetic$CologneInputBuffer
  extends ColognePhonetic.CologneBuffer
{
  public ColognePhonetic$CologneInputBuffer(ColognePhonetic paramColognePhonetic, char[] paramArrayOfChar)
  {
    super(paramColognePhonetic, paramArrayOfChar);
  }
  
  public void addLeft(char paramChar)
  {
    this.length = (1 + this.length);
    this.data[getNextPos()] = paramChar;
  }
  
  protected char[] copyData(int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    System.arraycopy(this.data, paramInt1 + (this.data.length - this.length), arrayOfChar, 0, paramInt2);
    return arrayOfChar;
  }
  
  public char getNextChar()
  {
    return this.data[getNextPos()];
  }
  
  protected int getNextPos()
  {
    return this.data.length - this.length;
  }
  
  public char removeNext()
  {
    char c = getNextChar();
    this.length = (-1 + this.length);
    return c;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.codec.language.ColognePhonetic.CologneInputBuffer
 * JD-Core Version:    0.7.0.1
 */