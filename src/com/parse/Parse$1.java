package com.parse;

final class Parse$1
  extends Thread
{
  Parse$1(String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    Parse.getEventuallyQueue();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Parse.1
 * JD-Core Version:    0.7.0.1
 */