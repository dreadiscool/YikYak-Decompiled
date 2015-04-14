package android.support.v4.provider;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile
  extends DocumentFile
{
  private File mFile;
  
  RawDocumentFile(DocumentFile paramDocumentFile, File paramFile)
  {
    super(paramDocumentFile);
    this.mFile = paramFile;
  }
  
  private static boolean deleteContents(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    boolean bool = true;
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile = arrayOfFile[j];
        if (localFile.isDirectory()) {
          bool &= deleteContents(localFile);
        }
        if (!localFile.delete())
        {
          new StringBuilder().append("Failed to delete ").append(localFile).toString();
          bool = false;
        }
      }
    }
    return bool;
  }
  
  private static String getTypeForName(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    String str1;
    if (i >= 0)
    {
      String str2 = paramString.substring(i + 1).toLowerCase();
      str1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
      if (str1 == null) {}
    }
    for (;;)
    {
      return str1;
      str1 = "application/octet-stream";
    }
  }
  
  public boolean canRead()
  {
    return this.mFile.canRead();
  }
  
  public boolean canWrite()
  {
    return this.mFile.canWrite();
  }
  
  public DocumentFile createDirectory(String paramString)
  {
    File localFile = new File(this.mFile, paramString);
    if ((localFile.isDirectory()) || (localFile.mkdir())) {}
    for (RawDocumentFile localRawDocumentFile = new RawDocumentFile(this, localFile);; localRawDocumentFile = null) {
      return localRawDocumentFile;
    }
  }
  
  public DocumentFile createFile(String paramString1, String paramString2)
  {
    String str = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString1);
    if (str != null) {
      paramString2 = paramString2 + "." + str;
    }
    File localFile = new File(this.mFile, paramString2);
    try
    {
      localFile.createNewFile();
      localRawDocumentFile = new RawDocumentFile(this, localFile);
      return localRawDocumentFile;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        new StringBuilder().append("Failed to createFile: ").append(localIOException).toString();
        RawDocumentFile localRawDocumentFile = null;
      }
    }
  }
  
  public boolean delete()
  {
    deleteContents(this.mFile);
    return this.mFile.delete();
  }
  
  public boolean exists()
  {
    return this.mFile.exists();
  }
  
  public String getName()
  {
    return this.mFile.getName();
  }
  
  public String getType()
  {
    if (this.mFile.isDirectory()) {}
    for (String str = null;; str = getTypeForName(this.mFile.getName())) {
      return str;
    }
  }
  
  public Uri getUri()
  {
    return Uri.fromFile(this.mFile);
  }
  
  public boolean isDirectory()
  {
    return this.mFile.isDirectory();
  }
  
  public boolean isFile()
  {
    return this.mFile.isFile();
  }
  
  public long lastModified()
  {
    return this.mFile.lastModified();
  }
  
  public long length()
  {
    return this.mFile.length();
  }
  
  public DocumentFile[] listFiles()
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = this.mFile.listFiles();
    if (arrayOfFile != null)
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        localArrayList.add(new RawDocumentFile(this, arrayOfFile[j]));
      }
    }
    return (DocumentFile[])localArrayList.toArray(new DocumentFile[localArrayList.size()]);
  }
  
  public boolean renameTo(String paramString)
  {
    File localFile = new File(this.mFile.getParentFile(), paramString);
    if (this.mFile.renameTo(localFile)) {
      this.mFile = localFile;
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.provider.RawDocumentFile
 * JD-Core Version:    0.7.0.1
 */