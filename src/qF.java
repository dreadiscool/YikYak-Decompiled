import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

public final class qF
{
  public static final pm<StringBuffer> A = new qO();
  public static final pn B = a(StringBuffer.class, A);
  public static final pm<URL> C = new qP();
  public static final pn D = a(URL.class, C);
  public static final pm<URI> E = new qQ();
  public static final pn F = a(URI.class, E);
  public static final pm<InetAddress> G = new qS();
  public static final pn H = b(InetAddress.class, G);
  public static final pm<UUID> I = new qT();
  public static final pn J = a(UUID.class, I);
  public static final pn K = new qU();
  public static final pm<Calendar> L = new qW();
  public static final pn M = b(Calendar.class, GregorianCalendar.class, L);
  public static final pm<Locale> N = new qX();
  public static final pn O = a(Locale.class, N);
  public static final pm<pb> P = new qY();
  public static final pn Q = b(pb.class, P);
  public static final pn R = a();
  public static final pm<Class> a = new qG();
  public static final pn b = a(Class.class, a);
  public static final pm<BitSet> c = new qR();
  public static final pn d = a(BitSet.class, c);
  public static final pm<Boolean> e = new rc();
  public static final pm<Boolean> f = new rg();
  public static final pn g = a(Boolean.TYPE, Boolean.class, e);
  public static final pm<Number> h = new rh();
  public static final pn i = a(Byte.TYPE, Byte.class, h);
  public static final pm<Number> j = new ri();
  public static final pn k = a(Short.TYPE, Short.class, j);
  public static final pm<Number> l = new rj();
  public static final pn m = a(Integer.TYPE, Integer.class, l);
  public static final pm<Number> n = new rk();
  public static final pm<Number> o = new rl();
  public static final pm<Number> p = new qH();
  public static final pm<Number> q = new qI();
  public static final pn r = a(Number.class, q);
  public static final pm<Character> s = new qJ();
  public static final pn t = a(Character.TYPE, Character.class, s);
  public static final pm<String> u = new qK();
  public static final pm<BigDecimal> v = new qL();
  public static final pm<BigInteger> w = new qM();
  public static final pn x = a(String.class, u);
  public static final pm<StringBuilder> y = new qN();
  public static final pn z = a(StringBuilder.class, y);
  
  public static pn a()
  {
    return new qZ();
  }
  
  public static <TT> pn a(Class<TT> paramClass1, Class<TT> paramClass2, pm<? super TT> parampm)
  {
    return new rb(paramClass1, paramClass2, parampm);
  }
  
  public static <TT> pn a(Class<TT> paramClass, pm<TT> parampm)
  {
    return new ra(paramClass, parampm);
  }
  
  public static <TT> pn b(Class<TT> paramClass, Class<? extends TT> paramClass1, pm<? super TT> parampm)
  {
    return new rd(paramClass, paramClass1, parampm);
  }
  
  public static <TT> pn b(Class<TT> paramClass, pm<TT> parampm)
  {
    return new re(paramClass, parampm);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     qF
 * JD-Core Version:    0.7.0.1
 */