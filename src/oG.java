import java.util.Arrays;

class oG
{
  final String a;
  final byte[] b;
  
  oG(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
  }
  
  public String toString()
  {
    return "KeyAndSerialized: key = " + this.a + " serialized hash = " + Arrays.hashCode(this.b);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     oG
 * JD-Core Version:    0.7.0.1
 */