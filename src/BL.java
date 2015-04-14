import java.util.ArrayList;
import java.util.Iterator;

public class BL
{
  private ArrayList<BM> a = new ArrayList();
  private BN b;
  private String c;
  
  public BL(String paramString, BN paramBN, BM... paramVarArgs)
  {
    this.c = paramString;
    this.b = paramBN;
    int i;
    if (paramVarArgs.length > 0) {
      i = paramVarArgs.length;
    }
    for (int j = 0;; j++)
    {
      if (j >= i) {
        return;
      }
      BM localBM = paramVarArgs[j];
      this.a.add(localBM);
    }
  }
  
  public String a()
  {
    String str1 = this.c + " " + this.b;
    Iterator localIterator = this.a.iterator();
    String str2 = str1;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return str2;
      }
      BM localBM = (BM)localIterator.next();
      switch (b()[localBM.ordinal()])
      {
      default: 
        str2 = str2 + " " + localBM.toString();
        break;
      case 3: 
        str2 = str2 + " PRIMARY KEY";
        break;
      case 4: 
        str2 = str2 + " NOT NULL";
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BL
 * JD-Core Version:    0.7.0.1
 */