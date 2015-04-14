import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class ov
{
  static String a(String paramString)
  {
    return URLEncoder.encode(paramString, "UTF-8").replaceAll("\\+", "%20");
  }
  
  private static nU<hf> a(nU<hf> paramnU)
  {
    try
    {
      nU localnU = new nU(ot.c(a(ot.a((hf)paramnU.a()))), paramnU.b());
      paramnU = localnU;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        nK.a("Escape URI: unsupported encoding", localUnsupportedEncodingException);
      }
    }
    return paramnU;
  }
  
  private static nU<hf> a(nU<hf> paramnU, int paramInt)
  {
    if (!a((hf)paramnU.a())) {
      nK.a("Escaping can only be applied to strings.");
    }
    for (;;)
    {
      return paramnU;
      switch (paramInt)
      {
      default: 
        nK.a("Unsupported Value Escaping: " + paramInt);
        break;
      case 12: 
        paramnU = a(paramnU);
      }
    }
  }
  
  static nU<hf> a(nU<hf> paramnU, int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      paramnU = a(paramnU, paramVarArgs[j]);
    }
    return paramnU;
  }
  
  private static boolean a(hf paramhf)
  {
    return ot.c(paramhf) instanceof String;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ov
 * JD-Core Version:    0.7.0.1
 */