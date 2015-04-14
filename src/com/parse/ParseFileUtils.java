package com.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class ParseFileUtils
{
  private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
  public static final long ONE_KB = 1024L;
  public static final long ONE_MB = 1048576L;
  
  public static void cleanDirectory(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    int i = arrayOfFile.length;
    Object localObject = null;
    int j = 0;
    for (;;)
    {
      File localFile;
      if (j < i) {
        localFile = arrayOfFile[j];
      }
      try
      {
        forceDelete(localFile);
        label129:
        j++;
        continue;
        if (localObject != null) {
          throw localObject;
        }
      }
      catch (IOException localIOException)
      {
        break label129;
      }
    }
  }
  
  public static void copyFile(File paramFile1, File paramFile2)
  {
    copyFile(paramFile1, paramFile2, true);
  }
  
  public static void copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' exists but is a directory");
    }
    if (paramFile1.getCanonicalPath().equals(paramFile2.getCanonicalPath())) {
      throw new IOException("Source '" + paramFile1 + "' and destination '" + paramFile2 + "' are the same");
    }
    File localFile = paramFile2.getParentFile();
    if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
      throw new IOException("Destination '" + localFile + "' directory cannot be created");
    }
    if ((paramFile2.exists()) && (!paramFile2.canWrite())) {
      throw new IOException("Destination '" + paramFile2 + "' exists but is read-only");
    }
    doCopyFile(paramFile1, paramFile2, paramBoolean);
  }
  
  public static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      if (!isSymlink(paramFile)) {
        cleanDirectory(paramFile);
      }
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  public static boolean deleteQuietly(File paramFile)
  {
    boolean bool1 = false;
    if (paramFile == null) {}
    for (;;)
    {
      return bool1;
      try
      {
        if (paramFile.isDirectory()) {
          cleanDirectory(paramFile);
        }
        try
        {
          label19:
          boolean bool2 = paramFile.delete();
          bool1 = bool2;
        }
        catch (Exception localException2) {}
      }
      catch (Exception localException1)
      {
        break label19;
      }
    }
  }
  
  /* Error */
  private static void doCopyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 28	java/io/File:exists	()Z
    //   4: ifeq +42 -> 46
    //   7: aload_1
    //   8: invokevirtual 52	java/io/File:isDirectory	()Z
    //   11: ifeq +35 -> 46
    //   14: new 22	java/io/IOException
    //   17: dup
    //   18: new 32	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   25: ldc 107
    //   27: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: ldc 85
    //   36: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   45: athrow
    //   46: aconst_null
    //   47: astore_3
    //   48: aconst_null
    //   49: astore 4
    //   51: new 136	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 138	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore 5
    //   61: new 140	java/io/FileOutputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: astore 6
    //   71: aload 5
    //   73: invokevirtual 145	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   76: astore 10
    //   78: aload 6
    //   80: invokevirtual 146	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   83: astore 11
    //   85: aload 10
    //   87: invokevirtual 152	java/nio/channels/FileChannel:size	()J
    //   90: lstore 13
    //   92: lconst_0
    //   93: lstore 15
    //   95: goto +248 -> 343
    //   98: aload 11
    //   100: aload 10
    //   102: lload 15
    //   104: lload 22
    //   106: invokevirtual 156	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   109: lstore 24
    //   111: lload 24
    //   113: lconst_0
    //   114: lcmp
    //   115: ifne +99 -> 214
    //   118: aload 11
    //   120: invokestatic 162	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   123: aload 6
    //   125: invokestatic 165	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   128: aload 10
    //   130: invokestatic 162	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   133: aload 5
    //   135: invokestatic 168	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   138: aload_0
    //   139: invokevirtual 171	java/io/File:length	()J
    //   142: lstore 17
    //   144: aload_1
    //   145: invokevirtual 171	java/io/File:length	()J
    //   148: lstore 19
    //   150: lload 17
    //   152: lload 19
    //   154: lcmp
    //   155: ifeq +99 -> 254
    //   158: new 22	java/io/IOException
    //   161: dup
    //   162: new 32	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   169: ldc 173
    //   171: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: ldc 175
    //   180: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_1
    //   184: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: ldc 177
    //   189: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: lload 17
    //   194: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: ldc 182
    //   199: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: lload 19
    //   204: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokespecial 61	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   213: athrow
    //   214: lload 15
    //   216: lload 24
    //   218: ladd
    //   219: lstore 15
    //   221: goto +122 -> 343
    //   224: astore 7
    //   226: aconst_null
    //   227: astore 8
    //   229: aconst_null
    //   230: astore 9
    //   232: aload 9
    //   234: invokestatic 162	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   237: aload 4
    //   239: invokestatic 165	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   242: aload 8
    //   244: invokestatic 162	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   247: aload_3
    //   248: invokestatic 168	com/parse/ParseIOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   251: aload 7
    //   253: athrow
    //   254: iload_2
    //   255: ifeq +12 -> 267
    //   258: aload_1
    //   259: aload_0
    //   260: invokevirtual 185	java/io/File:lastModified	()J
    //   263: invokevirtual 189	java/io/File:setLastModified	(J)Z
    //   266: pop
    //   267: return
    //   268: astore 7
    //   270: aload 5
    //   272: astore_3
    //   273: aconst_null
    //   274: astore 9
    //   276: aconst_null
    //   277: astore 8
    //   279: goto -47 -> 232
    //   282: astore 7
    //   284: aload 6
    //   286: astore 4
    //   288: aload 5
    //   290: astore_3
    //   291: aconst_null
    //   292: astore 8
    //   294: aconst_null
    //   295: astore 9
    //   297: goto -65 -> 232
    //   300: astore 7
    //   302: aload 6
    //   304: astore 4
    //   306: aload 5
    //   308: astore_3
    //   309: aload 10
    //   311: astore 8
    //   313: aconst_null
    //   314: astore 9
    //   316: goto -84 -> 232
    //   319: astore 12
    //   321: aload 6
    //   323: astore 4
    //   325: aload 5
    //   327: astore_3
    //   328: aload 11
    //   330: astore 9
    //   332: aload 12
    //   334: astore 7
    //   336: aload 10
    //   338: astore 8
    //   340: goto -108 -> 232
    //   343: lload 15
    //   345: lload 13
    //   347: lcmp
    //   348: ifge -230 -> 118
    //   351: lload 13
    //   353: lload 15
    //   355: lsub
    //   356: lstore 22
    //   358: lload 22
    //   360: ldc2_w 7
    //   363: lcmp
    //   364: ifle -266 -> 98
    //   367: ldc2_w 7
    //   370: lstore 22
    //   372: goto -274 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	paramFile1	File
    //   0	375	1	paramFile2	File
    //   0	375	2	paramBoolean	boolean
    //   47	281	3	localObject1	Object
    //   49	275	4	localObject2	Object
    //   59	267	5	localFileInputStream	FileInputStream
    //   69	253	6	localFileOutputStream	FileOutputStream
    //   224	28	7	localObject3	Object
    //   268	1	7	localObject4	Object
    //   282	1	7	localObject5	Object
    //   300	1	7	localObject6	Object
    //   334	1	7	localObject7	Object
    //   227	112	8	localObject8	Object
    //   230	101	9	localObject9	Object
    //   76	261	10	localFileChannel1	java.nio.channels.FileChannel
    //   83	246	11	localFileChannel2	java.nio.channels.FileChannel
    //   319	14	12	localObject10	Object
    //   90	262	13	l1	long
    //   93	261	15	l2	long
    //   142	51	17	l3	long
    //   148	55	19	l4	long
    //   104	1	22	localObject11	Object
    //   356	15	22	l5	long
    //   109	108	24	l6	long
    // Exception table:
    //   from	to	target	type
    //   51	61	224	finally
    //   61	71	268	finally
    //   71	78	282	finally
    //   78	85	300	finally
    //   85	111	319	finally
  }
  
  public static void forceDelete(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static boolean isSymlink(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("File must not be null");
    }
    if (paramFile.getParent() == null) {
      if (!paramFile.getCanonicalFile().equals(paramFile.getAbsoluteFile())) {
        break label61;
      }
    }
    label61:
    for (boolean bool = false;; bool = true)
    {
      return bool;
      paramFile = new File(paramFile.getParentFile().getCanonicalFile(), paramFile.getName());
      break;
    }
  }
  
  public static void moveFile(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException("Source must not be null");
    }
    if (paramFile2 == null) {
      throw new NullPointerException("Destination must not be null");
    }
    if (!paramFile1.exists()) {
      throw new FileNotFoundException("Source '" + paramFile1 + "' does not exist");
    }
    if (paramFile1.isDirectory()) {
      throw new IOException("Source '" + paramFile1 + "' is a directory");
    }
    if (paramFile2.exists()) {
      throw new IOException("Destination '" + paramFile2 + "' already exists");
    }
    if (paramFile2.isDirectory()) {
      throw new IOException("Destination '" + paramFile2 + "' is a directory");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      copyFile(paramFile1, paramFile2);
      if (!paramFile1.delete())
      {
        deleteQuietly(paramFile2);
        throw new IOException("Failed to delete original file '" + paramFile1 + "' after copy to '" + paramFile2 + "'");
      }
    }
  }
  
  public static FileInputStream openInputStream(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("File '" + paramFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  public static byte[] readFileToByteArray(File paramFile)
  {
    FileInputStream localFileInputStream = null;
    try
    {
      localFileInputStream = openInputStream(paramFile);
      byte[] arrayOfByte = ParseIOUtils.toByteArray(localFileInputStream);
      return arrayOfByte;
    }
    finally
    {
      ParseIOUtils.closeQuietly(localFileInputStream);
    }
  }
  
  public static void writeByteArrayToFile(File paramFile, byte[] paramArrayOfByte)
  {
    FileOutputStream localFileOutputStream = null;
    try
    {
      localFileOutputStream = openOutputStream(paramFile);
      localFileOutputStream.write(paramArrayOfByte);
      return;
    }
    finally
    {
      ParseIOUtils.closeQuietly(localFileOutputStream);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseFileUtils
 * JD-Core Version:    0.7.0.1
 */