import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class Bo
  implements BI
{
  static final byte[] a;
  
  static
  {
    try
    {
      a = "������\007options������\004head������\004post������\003put������\006delete������\005trace������\006accept������\016accept-charset������\017accept-encoding������\017accept-language������\raccept-ranges������\003age������\005allow������\rauthorization������\rcache-control������\nconnection������\fcontent-base������\020content-encoding������\020content-language������\016content-length������\020content-location������\013content-md5������\rcontent-range������\fcontent-type������\004date������\004etag������\006expect������\007expires������\004from������\004host������\bif-match������\021if-modified-since������\rif-none-match������\bif-range������\023if-unmodified-since������\rlast-modified������\blocation������\fmax-forwards������\006pragma������\022proxy-authenticate������\023proxy-authorization������\005range������\007referer������\013retry-after������\006server������\002te������\007trailer������\021transfer-encoding������\007upgrade������\nuser-agent������\004vary������\003via������\007warning������\020www-authenticate������\006method������\003get������\006status������\006200 OK������\007version������\bHTTP/1.1������\003url������\006public������\nset-cookie������\nkeep-alive������\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Ae.d.name());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError();
    }
  }
  
  public AQ a(LD paramLD, boolean paramBoolean)
  {
    return new Bp(paramLD, paramBoolean);
  }
  
  public AS a(LC paramLC, boolean paramBoolean)
  {
    return new Bq(paramLC, paramBoolean);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     Bo
 * JD-Core Version:    0.7.0.1
 */