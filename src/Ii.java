import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ii
{
  public static void a(String paramString)
  {
    if (Ik.a(paramString))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = "rotatePhotoToPortrait was called with a null or empty path!";
      Iq.c(Ii.class, arrayOfObject);
    }
    for (;;)
    {
      return;
      Iq.a("Rotating image at path: " + paramString, new Object[0]);
      Bitmap localBitmap1 = b(paramString);
      File localFile = new File(paramString);
      for (;;)
      {
        try
        {
          ExifInterface localExifInterface = new ExifInterface(localFile.getAbsolutePath());
          int i = localExifInterface.getAttributeInt("Orientation", 1);
          if ((i == 0) || (i == 1)) {
            break;
          }
          localMatrix = new Matrix();
          switch (i)
          {
          default: 
            break;
          case 2: 
            localMatrix.setScale(-1.0F, 1.0F);
          }
        }
        catch (IOException localIOException)
        {
          try
          {
            for (;;)
            {
              Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), localMatrix, true);
              try
              {
                localFile.delete();
                FileOutputStream localFileOutputStream = new FileOutputStream(new File(paramString));
                localBitmap2.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
              }
              catch (FileNotFoundException localFileNotFoundException)
              {
                localFileNotFoundException.printStackTrace();
              }
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            Matrix localMatrix;
            localOutOfMemoryError.printStackTrace();
          }
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
        break;
        localMatrix.setRotate(180.0F);
        continue;
        localMatrix.setRotate(180.0F);
        localMatrix.postScale(-1.0F, 1.0F);
        continue;
        localMatrix.setRotate(90.0F);
        localMatrix.postScale(-1.0F, 1.0F);
        continue;
        localMatrix.setRotate(90.0F);
        continue;
        localMatrix.setRotate(-90.0F);
        localMatrix.postScale(-1.0F, 1.0F);
        continue;
        localMatrix.setRotate(-90.0F);
      }
    }
  }
  
  public static Bitmap b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 5;
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    return BitmapFactory.decodeFile(paramString, localOptions);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Ii
 * JD-Core Version:    0.7.0.1
 */