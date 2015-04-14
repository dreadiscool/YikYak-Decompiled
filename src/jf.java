import java.io.IOException;

public class jf
  extends IOException
{
  jf(int paramInt1, int paramInt2)
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + paramInt1 + " limit " + paramInt2 + ").");
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     jf
 * JD-Core Version:    0.7.0.1
 */