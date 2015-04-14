package com.parse;

import java.io.File;
import java.io.FilenameFilter;

final class Parse$3
  implements FilenameFilter
{
  Parse$3(String paramString) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(this.val$suffix);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Parse.3
 * JD-Core Version:    0.7.0.1
 */