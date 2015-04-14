import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

final class AV
{
  private static final AT[] a;
  private static final Map<LE, Integer> b = c();
  
  static
  {
    AT[] arrayOfAT = new AT[61];
    arrayOfAT[0] = new AT(AT.e, "");
    arrayOfAT[1] = new AT(AT.b, "GET");
    arrayOfAT[2] = new AT(AT.b, "POST");
    arrayOfAT[3] = new AT(AT.c, "/");
    arrayOfAT[4] = new AT(AT.c, "/index.html");
    arrayOfAT[5] = new AT(AT.d, "http");
    arrayOfAT[6] = new AT(AT.d, "https");
    arrayOfAT[7] = new AT(AT.a, "200");
    arrayOfAT[8] = new AT(AT.a, "204");
    arrayOfAT[9] = new AT(AT.a, "206");
    arrayOfAT[10] = new AT(AT.a, "304");
    arrayOfAT[11] = new AT(AT.a, "400");
    arrayOfAT[12] = new AT(AT.a, "404");
    arrayOfAT[13] = new AT(AT.a, "500");
    arrayOfAT[14] = new AT("accept-charset", "");
    arrayOfAT[15] = new AT("accept-encoding", "gzip, deflate");
    arrayOfAT[16] = new AT("accept-language", "");
    arrayOfAT[17] = new AT("accept-ranges", "");
    arrayOfAT[18] = new AT("accept", "");
    arrayOfAT[19] = new AT("access-control-allow-origin", "");
    arrayOfAT[20] = new AT("age", "");
    arrayOfAT[21] = new AT("allow", "");
    arrayOfAT[22] = new AT("authorization", "");
    arrayOfAT[23] = new AT("cache-control", "");
    arrayOfAT[24] = new AT("content-disposition", "");
    arrayOfAT[25] = new AT("content-encoding", "");
    arrayOfAT[26] = new AT("content-language", "");
    arrayOfAT[27] = new AT("content-length", "");
    arrayOfAT[28] = new AT("content-location", "");
    arrayOfAT[29] = new AT("content-range", "");
    arrayOfAT[30] = new AT("content-type", "");
    arrayOfAT[31] = new AT("cookie", "");
    arrayOfAT[32] = new AT("date", "");
    arrayOfAT[33] = new AT("etag", "");
    arrayOfAT[34] = new AT("expect", "");
    arrayOfAT[35] = new AT("expires", "");
    arrayOfAT[36] = new AT("from", "");
    arrayOfAT[37] = new AT("host", "");
    arrayOfAT[38] = new AT("if-match", "");
    arrayOfAT[39] = new AT("if-modified-since", "");
    arrayOfAT[40] = new AT("if-none-match", "");
    arrayOfAT[41] = new AT("if-range", "");
    arrayOfAT[42] = new AT("if-unmodified-since", "");
    arrayOfAT[43] = new AT("last-modified", "");
    arrayOfAT[44] = new AT("link", "");
    arrayOfAT[45] = new AT("location", "");
    arrayOfAT[46] = new AT("max-forwards", "");
    arrayOfAT[47] = new AT("proxy-authenticate", "");
    arrayOfAT[48] = new AT("proxy-authorization", "");
    arrayOfAT[49] = new AT("range", "");
    arrayOfAT[50] = new AT("referer", "");
    arrayOfAT[51] = new AT("refresh", "");
    arrayOfAT[52] = new AT("retry-after", "");
    arrayOfAT[53] = new AT("server", "");
    arrayOfAT[54] = new AT("set-cookie", "");
    arrayOfAT[55] = new AT("strict-transport-security", "");
    arrayOfAT[56] = new AT("transfer-encoding", "");
    arrayOfAT[57] = new AT("user-agent", "");
    arrayOfAT[58] = new AT("vary", "");
    arrayOfAT[59] = new AT("via", "");
    arrayOfAT[60] = new AT("www-authenticate", "");
    a = arrayOfAT;
  }
  
  private static LE b(LE paramLE)
  {
    int i = 0;
    int j = paramLE.e();
    while (i < j)
    {
      int k = paramLE.a(i);
      if ((k >= 65) && (k <= 90)) {
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramLE.a());
      }
      i++;
    }
    return paramLE;
  }
  
  private static Map<LE, Integer> c()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(a.length);
    for (int i = 0; i < a.length; i++) {
      if (!localLinkedHashMap.containsKey(a[i].h)) {
        localLinkedHashMap.put(a[i].h, Integer.valueOf(i));
      }
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     AV
 * JD-Core Version:    0.7.0.1
 */