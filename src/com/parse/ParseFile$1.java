package com.parse;

import java.io.File;
import l;
import m;

class ParseFile$1
  implements l<Void, Void>
{
  ParseFile$1(ParseFile paramParseFile, boolean paramBoolean) {}
  
  public Void then(m<Void> paramm)
  {
    if (((this.val$pinned) && (this.this$0.isPinned())) || ((!this.val$pinned) && (!this.this$0.isPinned()))) {}
    for (;;)
    {
      return null;
      File localFile1;
      if (this.val$pinned) {
        localFile1 = this.this$0.getCacheFile();
      }
      for (File localFile2 = this.this$0.getFilesFile(); localFile2 == null; localFile2 = this.this$0.getCacheFile())
      {
        throw new IllegalStateException("Unable to pin file before saving");
        localFile1 = this.this$0.getFilesFile();
      }
      if (localFile2.exists()) {
        ParseFileUtils.deleteQuietly(localFile2);
      }
      if ((this.val$pinned) && (this.this$0.data != null))
      {
        ParseFileUtils.writeByteArrayToFile(localFile2, this.this$0.data);
        if (localFile1.exists()) {
          ParseFileUtils.deleteQuietly(localFile1);
        }
      }
      else
      {
        if ((localFile1 == null) || (!localFile1.exists())) {
          throw new IllegalStateException("Unable to pin file before retrieving");
        }
        ParseFileUtils.moveFile(localFile1, localFile2);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFile.1
 * JD-Core Version:    0.7.0.1
 */