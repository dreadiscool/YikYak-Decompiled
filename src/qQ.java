import java.net.URI;
import java.net.URISyntaxException;

final class qQ
  extends pm<URI>
{
  public URI a(ro paramro)
  {
    URI localURI = null;
    if (paramro.f() == rq.i) {
      paramro.j();
    }
    for (;;)
    {
      return localURI;
      try
      {
        String str = paramro.h();
        if ("null".equals(str)) {
          continue;
        }
        localURI = new URI(str);
      }
      catch (URISyntaxException localURISyntaxException)
      {
        throw new pc(localURISyntaxException);
      }
    }
  }
  
  public void a(rr paramrr, URI paramURI)
  {
    if (paramURI == null) {}
    for (String str = null;; str = paramURI.toASCIIString())
    {
      paramrr.b(str);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qQ
 * JD-Core Version:    0.7.0.1
 */