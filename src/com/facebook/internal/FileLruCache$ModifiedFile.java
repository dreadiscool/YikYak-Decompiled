package com.facebook.internal;

import java.io.File;

final class FileLruCache$ModifiedFile
  implements Comparable<ModifiedFile>
{
  private static final int HASH_MULTIPLIER = 37;
  private static final int HASH_SEED = 29;
  private final File file;
  private final long modified;
  
  FileLruCache$ModifiedFile(File paramFile)
  {
    this.file = paramFile;
    this.modified = paramFile.lastModified();
  }
  
  public int compareTo(ModifiedFile paramModifiedFile)
  {
    int i;
    if (getModified() < paramModifiedFile.getModified()) {
      i = -1;
    }
    for (;;)
    {
      return i;
      if (getModified() > paramModifiedFile.getModified()) {
        i = 1;
      } else {
        i = getFile().compareTo(paramModifiedFile.getFile());
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof ModifiedFile)) && (compareTo((ModifiedFile)paramObject) == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  File getFile()
  {
    return this.file;
  }
  
  long getModified()
  {
    return this.modified;
  }
  
  public int hashCode()
  {
    return 37 * (1073 + this.file.hashCode()) + (int)(this.modified % 2147483647L);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.ModifiedFile
 * JD-Core Version:    0.7.0.1
 */