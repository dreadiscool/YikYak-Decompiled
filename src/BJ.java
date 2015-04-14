import javax.security.auth.x500.X500Principal;

final class BJ
{
  private final String a;
  private final int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private char[] g;
  
  public BJ(X500Principal paramX500Principal)
  {
    this.a = paramX500Principal.getName("RFC2253");
    this.b = this.a.length();
  }
  
  private int a(int paramInt)
  {
    if (paramInt + 1 >= this.b) {
      throw new IllegalStateException("Malformed DN: " + this.a);
    }
    int i = this.g[paramInt];
    int j;
    int k;
    int m;
    if ((i >= 48) && (i <= 57))
    {
      j = i - 48;
      k = this.g[(paramInt + 1)];
      if ((k < 48) || (k > 57)) {
        break label172;
      }
      m = k - 48;
    }
    for (;;)
    {
      return m + (j << 4);
      if ((i >= 97) && (i <= 102))
      {
        j = i - 87;
        break;
      }
      if ((i >= 65) && (i <= 70))
      {
        j = i - 55;
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.a);
      label172:
      if ((k >= 97) && (k <= 102))
      {
        m = k - 87;
      }
      else
      {
        if ((k < 65) || (k > 70)) {
          break label220;
        }
        m = k - 55;
      }
    }
    label220:
    throw new IllegalStateException("Malformed DN: " + this.a);
  }
  
  private String a()
  {
    while ((this.c < this.b) && (this.g[this.c] == ' ')) {
      this.c = (1 + this.c);
    }
    if (this.c == this.b) {}
    for (String str = null;; str = new String(this.g, this.d, this.e - this.d))
    {
      return str;
      this.d = this.c;
      for (this.c = (1 + this.c); (this.c < this.b) && (this.g[this.c] != '=') && (this.g[this.c] != ' '); this.c = (1 + this.c)) {}
      if (this.c >= this.b) {
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
      }
      this.e = this.c;
      if (this.g[this.c] == ' ')
      {
        while ((this.c < this.b) && (this.g[this.c] != '=') && (this.g[this.c] == ' ')) {
          this.c = (1 + this.c);
        }
        if ((this.g[this.c] != '=') || (this.c == this.b)) {
          throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
      }
      for (this.c = (1 + this.c); (this.c < this.b) && (this.g[this.c] == ' '); this.c = (1 + this.c)) {}
      if ((this.e - this.d > 4) && (this.g[(3 + this.d)] == '.') && ((this.g[this.d] == 'O') || (this.g[this.d] == 'o')) && ((this.g[(1 + this.d)] == 'I') || (this.g[(1 + this.d)] == 'i')) && ((this.g[(2 + this.d)] == 'D') || (this.g[(2 + this.d)] == 'd'))) {
        this.d = (4 + this.d);
      }
    }
  }
  
  private String b()
  {
    this.c = (1 + this.c);
    this.d = this.c;
    this.e = this.d;
    if (this.c == this.b) {
      throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }
    if (this.g[this.c] == '"') {
      for (this.c = (1 + this.c); (this.c < this.b) && (this.g[this.c] == ' '); this.c = (1 + this.c)) {}
    }
    if (this.g[this.c] == '\\') {
      this.g[this.e] = e();
    }
    for (;;)
    {
      this.c = (1 + this.c);
      this.e = (1 + this.e);
      break;
      this.g[this.e] = this.g[this.c];
    }
    return new String(this.g, this.d, this.e - this.d);
  }
  
  private String c()
  {
    if (4 + this.c >= this.b) {
      throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }
    this.d = this.c;
    int i;
    for (this.c = (1 + this.c);; this.c = (1 + this.c))
    {
      if ((this.c == this.b) || (this.g[this.c] == '+') || (this.g[this.c] == ',') || (this.g[this.c] == ';')) {
        this.e = this.c;
      }
      for (;;)
      {
        i = this.e - this.d;
        if ((i >= 5) && ((i & 0x1) != 0)) {
          break label310;
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
        if (this.g[this.c] != ' ') {
          break;
        }
        this.e = this.c;
        for (this.c = (1 + this.c); (this.c < this.b) && (this.g[this.c] == ' '); this.c = (1 + this.c)) {}
      }
      if ((this.g[this.c] >= 'A') && (this.g[this.c] <= 'F'))
      {
        char[] arrayOfChar = this.g;
        int m = this.c;
        arrayOfChar[m] = ((char)(' ' + arrayOfChar[m]));
      }
    }
    label310:
    byte[] arrayOfByte = new byte[i / 2];
    int j = 0;
    int k = 1 + this.d;
    while (j < arrayOfByte.length)
    {
      arrayOfByte[j] = ((byte)a(k));
      k += 2;
      j++;
    }
    return new String(this.g, this.d, i);
  }
  
  private String d()
  {
    this.d = this.c;
    this.e = this.c;
    String str;
    if (this.c >= this.b) {
      str = new String(this.g, this.d, this.e - this.d);
    }
    for (;;)
    {
      return str;
      switch (this.g[this.c])
      {
      default: 
        char[] arrayOfChar4 = this.g;
        int m = this.e;
        this.e = (m + 1);
        arrayOfChar4[m] = this.g[this.c];
        this.c = (1 + this.c);
        break;
      case '+': 
      case ',': 
      case ';': 
        str = new String(this.g, this.d, this.e - this.d);
        break;
      case '\\': 
        char[] arrayOfChar3 = this.g;
        int k = this.e;
        this.e = (k + 1);
        arrayOfChar3[k] = e();
        this.c = (1 + this.c);
        break;
      case ' ': 
        this.f = this.e;
        this.c = (1 + this.c);
        char[] arrayOfChar1 = this.g;
        int i = this.e;
        this.e = (i + 1);
        arrayOfChar1[i] = ' ';
        while ((this.c < this.b) && (this.g[this.c] == ' '))
        {
          char[] arrayOfChar2 = this.g;
          int j = this.e;
          this.e = (j + 1);
          arrayOfChar2[j] = ' ';
          this.c = (1 + this.c);
        }
        if ((this.c != this.b) && (this.g[this.c] != ',') && (this.g[this.c] != '+') && (this.g[this.c] != ';')) {
          break;
        }
        str = new String(this.g, this.d, this.f - this.d);
      }
    }
  }
  
  private char e()
  {
    this.c = (1 + this.c);
    if (this.c == this.b) {
      throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }
    switch (this.g[this.c])
    {
    }
    for (char c1 = f();; c1 = this.g[this.c]) {
      return c1;
    }
  }
  
  private char f()
  {
    int i = a(this.c);
    this.c = (1 + this.c);
    char c1;
    if (i < 128) {
      c1 = (char)i;
    }
    for (;;)
    {
      return c1;
      if ((i >= 192) && (i <= 247))
      {
        int j;
        int k;
        label60:
        int m;
        if (i <= 223)
        {
          j = 1;
          k = i & 0x1F;
          m = k;
        }
        for (int n = 0;; n++)
        {
          if (n >= j) {
            break label210;
          }
          this.c = (1 + this.c);
          if ((this.c == this.b) || (this.g[this.c] != '\\'))
          {
            c1 = '?';
            break;
            if (i <= 239)
            {
              j = 2;
              k = i & 0xF;
              break label60;
            }
            j = 3;
            k = i & 0x7;
            break label60;
          }
          this.c = (1 + this.c);
          int i1 = a(this.c);
          this.c = (1 + this.c);
          if ((i1 & 0xC0) != 128)
          {
            c1 = '?';
            break;
          }
          m = (m << 6) + (i1 & 0x3F);
        }
        label210:
        c1 = (char)m;
      }
      else
      {
        c1 = '?';
      }
    }
  }
  
  public String a(String paramString)
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
    this.g = this.a.toCharArray();
    String str1 = a();
    if (str1 == null) {}
    for (String str2 = null;; str2 = null)
    {
      return str2;
      str2 = "";
      if (this.c != this.b) {
        break;
      }
    }
    switch (this.g[this.c])
    {
    default: 
      str2 = d();
    }
    while (!paramString.equalsIgnoreCase(str1))
    {
      if (this.c < this.b) {
        break label169;
      }
      str2 = null;
      break;
      str2 = b();
      continue;
      str2 = c();
    }
    label169:
    if ((this.g[this.c] == ',') || (this.g[this.c] == ';')) {}
    while (this.g[this.c] == '+')
    {
      this.c = (1 + this.c);
      str1 = a();
      if (str1 != null) {
        break;
      }
      throw new IllegalStateException("Malformed DN: " + this.a);
    }
    throw new IllegalStateException("Malformed DN: " + this.a);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     BJ
 * JD-Core Version:    0.7.0.1
 */