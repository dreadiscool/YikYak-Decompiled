package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class a
  implements SafeParcelable
{
  public static final Parcelable.Creator<a> CREATOR = new b();
  final int CK;
  final int Gt;
  ParcelFileDescriptor KS;
  private Bitmap KT;
  private boolean KU;
  private File KV;
  
  a(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    this.CK = paramInt1;
    this.KS = paramParcelFileDescriptor;
    this.Gt = paramInt2;
    this.KT = null;
    this.KU = false;
  }
  
  public a(Bitmap paramBitmap)
  {
    this.CK = 1;
    this.KS = null;
    this.Gt = 0;
    this.KT = paramBitmap;
    this.KU = true;
  }
  
  private void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      label6:
      return;
    }
    catch (IOException localIOException)
    {
      break label6;
    }
  }
  
  /* Error */
  private java.io.FileOutputStream gU()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/google/android/gms/common/data/a:KV	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 59	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 61
    //   13: invokespecial 64	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 66
    //   19: ldc 68
    //   21: aload_0
    //   22: getfield 57	com/google/android/gms/common/data/a:KV	Ljava/io/File;
    //   25: invokestatic 74	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_2
    //   29: new 76	java/io/FileOutputStream
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_3
    //   38: aload_0
    //   39: aload_2
    //   40: ldc 80
    //   42: invokestatic 86	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 35	com/google/android/gms/common/data/a:KS	Landroid/os/ParcelFileDescriptor;
    //   48: aload_2
    //   49: invokevirtual 90	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_3
    //   54: areturn
    //   55: astore_1
    //   56: new 59	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 92
    //   62: aload_1
    //   63: invokespecial 95	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore 4
    //   69: new 59	java/lang/IllegalStateException
    //   72: dup
    //   73: ldc 97
    //   75: invokespecial 64	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   55	8	1	localIOException	IOException
    //   28	21	2	localFile	File
    //   37	17	3	localFileOutputStream	java.io.FileOutputStream
    //   67	1	4	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }
  
  public void a(File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("Cannot set null temp directory");
    }
    this.KV = paramFile;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap gT()
  {
    DataInputStream localDataInputStream;
    if (!this.KU) {
      localDataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.KS));
    }
    try
    {
      byte[] arrayOfByte = new byte[localDataInputStream.readInt()];
      int i = localDataInputStream.readInt();
      int j = localDataInputStream.readInt();
      Bitmap.Config localConfig = Bitmap.Config.valueOf(localDataInputStream.readUTF());
      localDataInputStream.read(arrayOfByte);
      a(localDataInputStream);
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
      localBitmap.copyPixelsFromBuffer(localByteBuffer);
      this.KT = localBitmap;
      this.KU = true;
      return this.KT;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not read from parcel file descriptor", localIOException);
    }
    finally
    {
      a(localDataInputStream);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    byte[] arrayOfByte;
    DataOutputStream localDataOutputStream;
    if (this.KS == null)
    {
      localBitmap = this.KT;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer(localByteBuffer);
      arrayOfByte = localByteBuffer.array();
      localDataOutputStream = new DataOutputStream(gU());
    }
    try
    {
      localDataOutputStream.writeInt(arrayOfByte.length);
      localDataOutputStream.writeInt(localBitmap.getWidth());
      localDataOutputStream.writeInt(localBitmap.getHeight());
      localDataOutputStream.writeUTF(localBitmap.getConfig().toString());
      localDataOutputStream.write(arrayOfByte);
      a(localDataOutputStream);
      b.a(this, paramParcel, paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException("Could not write into unlinked file", localIOException);
    }
    finally
    {
      a(localDataOutputStream);
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.a
 * JD-Core Version:    0.7.0.1
 */