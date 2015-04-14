import java.util.ArrayList;
import java.util.Iterator;

public abstract class BO
{
  private static final String a = BO.class.getSimpleName();
  private ArrayList<BL> b = new ArrayList();
  
  public BO()
  {
    c();
  }
  
  private void c()
  {
    ArrayList localArrayList = this.b;
    BN localBN = BN.c;
    BM[] arrayOfBM = new BM[3];
    arrayOfBM[0] = BM.c;
    arrayOfBM[1] = BM.a;
    arrayOfBM[2] = BM.d;
    localArrayList.add(new BL("_id", localBN, arrayOfBM));
    b();
    this.b.add(new BL("CreatedAt", BN.b, new BM[0]));
    this.b.add(new BL("UpdatedAt", BN.b, new BM[0]));
  }
  
  public String a()
  {
    String str1 = getClass().getSimpleName();
    Iterator localIterator;
    String str2;
    if (this.b.size() != 1) {
      if (this.b.size() > 1)
      {
        localIterator = this.b.iterator();
        str2 = "";
        if (localIterator.hasNext()) {}
      }
    }
    for (;;)
    {
      String str3 = "CREATE TABLE " + str1 + "(" + str2 + ");";
      new StringBuilder("Final SQL: ").append(str3).toString();
      for (;;)
      {
        return str3;
        BL localBL = (BL)localIterator.next();
        if (this.b.indexOf(localBL) == -1 + this.b.size())
        {
          str2 = str2 + localBL.a();
          break;
        }
        str2 = str2 + localBL.a() + ", ";
        break;
        new StringBuilder("There are no columns for table ").append(str1).append("! Did you forget to add columns?").toString();
        str3 = null;
      }
      str2 = "";
    }
  }
  
  protected void a(BL paramBL)
  {
    this.b.add(paramBL);
  }
  
  protected abstract void b();
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BO
 * JD-Core Version:    0.7.0.1
 */