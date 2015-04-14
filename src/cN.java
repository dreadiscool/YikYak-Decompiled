public class cN
{
  public static xQ a(cO paramcO, float paramFloat, xQ paramxQ)
  {
    return a(paramcO, paramFloat, paramxQ, new cM[0]);
  }
  
  public static xQ a(cO paramcO, float paramFloat, xQ paramxQ, cM... paramVarArgs)
  {
    cL localcL = paramcO.a(paramFloat);
    if (paramVarArgs != null) {
      localcL.a(paramVarArgs);
    }
    paramxQ.a(localcL);
    return paramxQ;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     cN
 * JD-Core Version:    0.7.0.1
 */