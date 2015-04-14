package com.facebook.internal;

import java.io.File;

class FileLruCache$2
  implements Runnable
{
  FileLruCache$2(FileLruCache paramFileLruCache, File[] paramArrayOfFile) {}
  
  public void run()
  {
    File[] arrayOfFile = this.val$filesToDelete;
    int i = arrayOfFile.length;
    for (int j = 0; j < i; j++) {
      arrayOfFile[j].delete();
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.internal.FileLruCache.2
 * JD-Core Version:    0.7.0.1
 */