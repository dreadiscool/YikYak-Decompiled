import java.util.zip.Inflater;

class Bj
  extends Inflater
{
  Bj(Bh paramBh) {}
  
  public int inflate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = super.inflate(paramArrayOfByte, paramInt1, paramInt2);
    if ((i == 0) && (needsDictionary()))
    {
      setDictionary(Bo.a);
      i = super.inflate(paramArrayOfByte, paramInt1, paramInt2);
    }
    return i;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bj
 * JD-Core Version:    0.7.0.1
 */