package com.facebook;

 enum TestSession$Mode
{
  static
  {
    Mode[] arrayOfMode = new Mode[2];
    arrayOfMode[0] = PRIVATE;
    arrayOfMode[1] = SHARED;
    $VALUES = arrayOfMode;
  }
  
  private TestSession$Mode() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.TestSession.Mode
 * JD-Core Version:    0.7.0.1
 */