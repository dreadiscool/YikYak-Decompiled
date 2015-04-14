package com.parse;

import java.io.File;
import java.util.Comparator;

final class Parse$4
  implements Comparator<File>
{
  public int compare(File paramFile1, File paramFile2)
  {
    int i = Long.valueOf(paramFile1.lastModified()).compareTo(Long.valueOf(paramFile2.lastModified()));
    if (i != 0) {}
    for (;;)
    {
      return i;
      i = paramFile1.getName().compareTo(paramFile2.getName());
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.Parse.4
 * JD-Core Version:    0.7.0.1
 */