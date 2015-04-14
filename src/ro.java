import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class ro
  implements Closeable
{
  private static final char[] a = ")]}'\n".toCharArray();
  private final Reader b;
  private boolean c = false;
  private final char[] d = new char[1024];
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private long j;
  private int k;
  private String l;
  private int[] m = new int[32];
  private int n = 0;
  
  static
  {
    pM.a = new rp();
  }
  
  public ro(Reader paramReader)
  {
    int[] arrayOfInt = this.m;
    int i1 = this.n;
    this.n = (i1 + 1);
    arrayOfInt[i1] = 6;
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    this.b = paramReader;
  }
  
  private void a(int paramInt)
  {
    if (this.n == this.m.length)
    {
      int[] arrayOfInt2 = new int[2 * this.n];
      System.arraycopy(this.m, 0, arrayOfInt2, 0, this.n);
      this.m = arrayOfInt2;
    }
    int[] arrayOfInt1 = this.m;
    int i1 = this.n;
    this.n = (i1 + 1);
    arrayOfInt1[i1] = paramInt;
  }
  
  private boolean a(char paramChar)
  {
    switch (paramChar)
    {
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      w();
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool = false;
    while ((this.e + paramString.length() <= this.f) || (b(paramString.length()))) {
      if (this.d[this.e] == '\n')
      {
        this.g = (1 + this.g);
        this.h = (1 + this.e);
        this.e = (1 + this.e);
      }
      else
      {
        for (int i1 = 0;; i1++)
        {
          if (i1 >= paramString.length()) {
            break label111;
          }
          if (this.d[(i1 + this.e)] != paramString.charAt(i1)) {
            break;
          }
        }
        label111:
        bool = true;
      }
    }
    return bool;
  }
  
  private int b(boolean paramBoolean)
  {
    char[] arrayOfChar = this.d;
    int i1 = this.e;
    int i2 = this.f;
    for (;;)
    {
      int i3;
      int i4;
      int i5;
      if (i1 == i2)
      {
        this.e = i1;
        if (!b(1))
        {
          if (paramBoolean) {
            throw new EOFException("End of input at line " + u() + " column " + v());
          }
        }
        else
        {
          i1 = this.e;
          i2 = this.f;
        }
      }
      else
      {
        i3 = i1 + 1;
        i4 = arrayOfChar[i1];
        if (i4 == 10)
        {
          this.g = (1 + this.g);
          this.h = i3;
          i1 = i3;
          continue;
        }
        if ((i4 == 32) || (i4 == 13)) {
          break label388;
        }
        if (i4 == 9)
        {
          i1 = i3;
          continue;
        }
        if (i4 == 47)
        {
          this.e = i3;
          if (i3 == i2)
          {
            this.e = (-1 + this.e);
            boolean bool = b(2);
            this.e = (1 + this.e);
            if (!bool) {
              i5 = i4;
            }
          }
        }
      }
      for (;;)
      {
        return i5;
        w();
        switch (arrayOfChar[this.e])
        {
        default: 
          i5 = i4;
          break;
        case '*': 
          this.e = (1 + this.e);
          if (!a("*/")) {
            throw b("Unterminated comment");
          }
          i1 = 2 + this.e;
          i2 = this.f;
          break;
        case '/': 
          this.e = (1 + this.e);
          x();
          i1 = this.e;
          i2 = this.f;
          break;
          if (i4 == 35)
          {
            this.e = i3;
            w();
            x();
            i1 = this.e;
            i2 = this.f;
            break;
          }
          this.e = i3;
          i5 = i4;
          continue;
          i5 = -1;
        }
      }
      label388:
      i1 = i3;
    }
  }
  
  private IOException b(String paramString)
  {
    throw new rs(paramString + " at line " + u() + " column " + v());
  }
  
  private String b(char paramChar)
  {
    char[] arrayOfChar = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    do
    {
      int i1 = this.e;
      int i2 = this.f;
      int i3 = i1;
      if (i3 < i2)
      {
        int i4 = i3 + 1;
        char c1 = arrayOfChar[i3];
        if (c1 == paramChar)
        {
          this.e = i4;
          localStringBuilder.append(arrayOfChar, i1, -1 + (i4 - i1));
          return localStringBuilder.toString();
        }
        if (c1 == '\\')
        {
          this.e = i4;
          localStringBuilder.append(arrayOfChar, i1, -1 + (i4 - i1));
          localStringBuilder.append(y());
          i1 = this.e;
          i2 = this.f;
          i4 = i1;
        }
        for (;;)
        {
          i3 = i4;
          break;
          if (c1 == '\n')
          {
            this.g = (1 + this.g);
            this.h = i4;
          }
        }
      }
      localStringBuilder.append(arrayOfChar, i1, i3 - i1);
      this.e = i3;
    } while (b(1));
    throw b("Unterminated string");
  }
  
  private boolean b(int paramInt)
  {
    boolean bool = false;
    char[] arrayOfChar = this.d;
    this.h -= this.e;
    if (this.f != this.e)
    {
      this.f -= this.e;
      System.arraycopy(arrayOfChar, this.e, arrayOfChar, 0, this.f);
    }
    for (;;)
    {
      this.e = 0;
      do
      {
        int i1 = this.b.read(arrayOfChar, this.f, arrayOfChar.length - this.f);
        if (i1 == -1) {
          break;
        }
        this.f = (i1 + this.f);
        if ((this.g == 0) && (this.h == 0) && (this.f > 0) && (arrayOfChar[0] == 65279))
        {
          this.e = (1 + this.e);
          this.h = (1 + this.h);
          paramInt++;
        }
      } while (this.f < paramInt);
      bool = true;
      return bool;
      this.f = 0;
    }
  }
  
  private void c(char paramChar)
  {
    char[] arrayOfChar = this.d;
    do
    {
      int i1 = this.e;
      int i2 = this.f;
      int i3 = i1;
      if (i3 < i2)
      {
        int i4 = i3 + 1;
        char c1 = arrayOfChar[i3];
        if (c1 == paramChar)
        {
          this.e = i4;
          return;
        }
        if (c1 == '\\')
        {
          this.e = i4;
          y();
          i4 = this.e;
          i2 = this.f;
        }
        for (;;)
        {
          i3 = i4;
          break;
          if (c1 == '\n')
          {
            this.g = (1 + this.g);
            this.h = i4;
          }
        }
      }
      this.e = i3;
    } while (b(1));
    throw b("Unterminated string");
  }
  
  private int o()
  {
    int i1 = 4;
    int i2 = this.m[(-1 + this.n)];
    if (i2 == 1)
    {
      this.m[(-1 + this.n)] = 2;
      label33:
      switch (b(true))
      {
      default: 
        this.e = (-1 + this.e);
        if (this.n == 1) {
          w();
        }
        i1 = q();
        if (i1 == 0) {
          break;
        }
      }
    }
    for (;;)
    {
      return i1;
      if (i2 == 2)
      {
        switch (b(true))
        {
        case 44: 
        default: 
          throw b("Unterminated array");
        case 93: 
          this.i = i1;
          break;
        case 59: 
          w();
          break;
        }
      }
      else
      {
        int i3;
        if ((i2 == 3) || (i2 == 5))
        {
          this.m[(-1 + this.n)] = i1;
          if (i2 == 5) {
            switch (b(true))
            {
            default: 
              throw b("Unterminated object");
            case 125: 
              this.i = 2;
              i1 = 2;
              break;
            case 59: 
              w();
            }
          } else {
            i3 = b(true);
          }
        }
        else
        {
          switch (i3)
          {
          default: 
            w();
            this.e = (-1 + this.e);
            if (a((char)i3))
            {
              i1 = 14;
              this.i = i1;
            }
            break;
          case 34: 
            i1 = 13;
            this.i = i1;
            break;
          case 39: 
            w();
            i1 = 12;
            this.i = i1;
            break;
          case 125: 
            if (i2 != 5)
            {
              this.i = 2;
              i1 = 2;
            }
            else
            {
              throw b("Expected name");
              throw b("Expected name");
              if (i2 == i1)
              {
                this.m[(-1 + this.n)] = 5;
                switch (b(true))
                {
                case 58: 
                case 59: 
                case 60: 
                default: 
                  throw b("Expected ':'");
                }
                w();
                if (((this.e >= this.f) && (!b(1))) || (this.d[this.e] != '>')) {
                  break label33;
                }
                this.e = (1 + this.e);
                break label33;
              }
              if (i2 == 6)
              {
                if (this.c) {
                  z();
                }
                this.m[(-1 + this.n)] = 7;
                break label33;
              }
              if (i2 == 7)
              {
                if (b(false) == -1)
                {
                  i1 = 17;
                  this.i = i1;
                  continue;
                }
                w();
                this.e = (-1 + this.e);
                break label33;
              }
              if (i2 != 8) {
                break label33;
              }
              throw new IllegalStateException("JsonReader is closed");
              if (i2 == 1)
              {
                this.i = i1;
              }
              else if ((i2 == 1) || (i2 == 2))
              {
                w();
                this.e = (-1 + this.e);
                this.i = 7;
                i1 = 7;
              }
              else
              {
                throw b("Unexpected value");
                w();
                i1 = 8;
                this.i = i1;
                continue;
                if (this.n == 1) {
                  w();
                }
                i1 = 9;
                this.i = i1;
                continue;
                i1 = 3;
                this.i = i1;
                continue;
                this.i = 1;
                i1 = 1;
                continue;
                i1 = r();
                if (i1 == 0)
                {
                  if (!a(this.d[this.e])) {
                    throw b("Expected value");
                  }
                  w();
                  i1 = 10;
                  this.i = i1;
                }
              }
            }
            break;
          }
        }
      }
    }
  }
  
  private int q()
  {
    int i1 = this.d[this.e];
    String str1;
    String str2;
    int i2;
    int i3;
    int i4;
    if ((i1 == 116) || (i1 == 84))
    {
      str1 = "true";
      str2 = "TRUE";
      i2 = 5;
      i3 = str1.length();
      i4 = 1;
      label40:
      if (i4 >= i3) {
        break label182;
      }
      if ((i4 + this.e < this.f) || (b(i4 + 1))) {
        break label134;
      }
      i2 = 0;
    }
    for (;;)
    {
      return i2;
      if ((i1 == 102) || (i1 == 70))
      {
        str1 = "false";
        str2 = "FALSE";
        i2 = 6;
        break;
      }
      if ((i1 == 110) || (i1 == 78))
      {
        str1 = "null";
        str2 = "NULL";
        i2 = 7;
        break;
      }
      i2 = 0;
      continue;
      label134:
      int i5 = this.d[(i4 + this.e)];
      if ((i5 != str1.charAt(i4)) && (i5 != str2.charAt(i4)))
      {
        i2 = 0;
      }
      else
      {
        i4++;
        break label40;
        label182:
        if (((i3 + this.e < this.f) || (b(i3 + 1))) && (a(this.d[(i3 + this.e)])))
        {
          i2 = 0;
        }
        else
        {
          this.e = (i3 + this.e);
          this.i = i2;
        }
      }
    }
  }
  
  private int r()
  {
    char[] arrayOfChar = this.d;
    int i1 = this.e;
    int i2 = this.f;
    long l1 = 0L;
    int i3 = 0;
    int i4 = 1;
    int i5 = 0;
    int i6 = 0;
    int i7 = i2;
    int i8 = i1;
    int i9;
    if (i8 + i6 == i7) {
      if (i6 == arrayOfChar.length) {
        i9 = 0;
      }
    }
    label56:
    label100:
    char c1;
    for (;;)
    {
      return i9;
      if (!b(i6 + 1)) {}
      do
      {
        if ((i5 != 2) || (i4 == 0) || ((l1 == -9223372036854775808L) && (i3 == 0))) {
          break label571;
        }
        if (i3 == 0) {
          break label563;
        }
        this.j = l1;
        this.e = (i6 + this.e);
        i9 = 15;
        this.i = i9;
        break;
        i8 = this.e;
        i7 = this.f;
        c1 = arrayOfChar[(i8 + i6)];
        switch (c1)
        {
        default: 
          if ((c1 >= '0') && (c1 <= '9')) {
            break label382;
          }
        }
      } while (!a(c1));
      i9 = 0;
    }
    int i10;
    int i12;
    int i11;
    if (i5 == 0)
    {
      i10 = 1;
      int i13 = i4;
      i12 = 1;
      i11 = i13;
    }
    for (;;)
    {
      i6++;
      i3 = i12;
      i4 = i11;
      i5 = i10;
      break;
      if (i5 == 5)
      {
        i10 = 6;
        i11 = i4;
        i12 = i3;
      }
      else
      {
        i9 = 0;
        break label56;
        if (i5 == 5)
        {
          i10 = 6;
          i11 = i4;
          i12 = i3;
        }
        else
        {
          i9 = 0;
          break label56;
          if ((i5 == 2) || (i5 == 4))
          {
            i10 = 5;
            i11 = i4;
            i12 = i3;
          }
          else
          {
            i9 = 0;
            break label56;
            label563:
            label571:
            if (i5 == 2)
            {
              i10 = 3;
              i11 = i4;
              i12 = i3;
            }
            else
            {
              i9 = 0;
              break label56;
              label382:
              if ((i5 == 1) || (i5 == 0))
              {
                l1 = -(c1 - '0');
                i10 = 2;
                i11 = i4;
                i12 = i3;
              }
              else
              {
                if (i5 == 2)
                {
                  if (l1 == 0L)
                  {
                    i9 = 0;
                    break label56;
                  }
                  long l2 = 10L * l1 - (c1 - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1))) {}
                  for (int i14 = 1;; i14 = 0)
                  {
                    int i15 = i14 & i4;
                    i12 = i3;
                    l1 = l2;
                    int i16 = i5;
                    i11 = i15;
                    i10 = i16;
                    break;
                  }
                }
                if (i5 == 3)
                {
                  i10 = 4;
                  i11 = i4;
                  i12 = i3;
                }
                else
                {
                  if ((i5 == 5) || (i5 == 6))
                  {
                    i10 = 7;
                    i11 = i4;
                    i12 = i3;
                    continue;
                    l1 = -l1;
                    break label100;
                    if ((i5 == 2) || (i5 == 4) || (i5 == 7))
                    {
                      this.k = i6;
                      i9 = 16;
                      this.i = i9;
                      break label56;
                    }
                    i9 = 0;
                    break label56;
                  }
                  i10 = i5;
                  i11 = i4;
                  i12 = i3;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String s()
  {
    StringBuilder localStringBuilder = null;
    int i1 = 0;
    for (;;)
    {
      if (i1 + this.e < this.f)
      {
        switch (this.d[(i1 + this.e)])
        {
        default: 
          i1++;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          w();
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label178:
          if (localStringBuilder != null) {}
          break;
        }
      }
      else
      {
        for (String str = new String(this.d, this.e, i1);; str = localStringBuilder.toString())
        {
          this.e = (i1 + this.e);
          return str;
          if (i1 < this.d.length)
          {
            if (!b(i1 + 1)) {
              break label178;
            }
            break;
          }
          if (localStringBuilder == null) {
            localStringBuilder = new StringBuilder();
          }
          localStringBuilder.append(this.d, this.e, i1);
          this.e = (i1 + this.e);
          if (b(1)) {
            break label307;
          }
          i1 = 0;
          break label178;
          localStringBuilder.append(this.d, this.e, i1);
        }
        label307:
        i1 = 0;
      }
    }
  }
  
  private void t()
  {
    int i1 = 0;
    while (i1 + this.e < this.f) {
      switch (this.d[(i1 + this.e)])
      {
      default: 
        i1++;
        break;
      case '#': 
      case '/': 
      case ';': 
      case '=': 
      case '\\': 
        w();
      case '\t': 
      case '\n': 
      case '\f': 
      case '\r': 
      case ' ': 
      case ',': 
      case ':': 
      case '[': 
      case ']': 
      case '{': 
      case '}': 
        this.e = (i1 + this.e);
      }
    }
    for (;;)
    {
      return;
      this.e = (i1 + this.e);
      if (b(1)) {
        break;
      }
    }
  }
  
  private int u()
  {
    return 1 + this.g;
  }
  
  private int v()
  {
    return 1 + (this.e - this.h);
  }
  
  private void w()
  {
    if (!this.c) {
      throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void x()
  {
    int i2;
    if ((this.e < this.f) || (b(1)))
    {
      char[] arrayOfChar = this.d;
      int i1 = this.e;
      this.e = (i1 + 1);
      i2 = arrayOfChar[i1];
      if (i2 != 10) {
        break label65;
      }
      this.g = (1 + this.g);
      this.h = this.e;
    }
    for (;;)
    {
      return;
      label65:
      if (i2 != 13) {
        break;
      }
    }
  }
  
  private char y()
  {
    if ((this.e == this.f) && (!b(1))) {
      throw b("Unterminated escape sequence");
    }
    char[] arrayOfChar = this.d;
    int i1 = this.e;
    this.e = (i1 + 1);
    char c1 = arrayOfChar[i1];
    switch (c1)
    {
    }
    for (;;)
    {
      return c1;
      if ((4 + this.e > this.f) && (!b(4))) {
        throw b("Unterminated escape sequence");
      }
      int i3 = this.e;
      int i4 = i3 + 4;
      c1 = '\000';
      int i5 = i3;
      if (i5 < i4)
      {
        int i6 = this.d[i5];
        int i7 = (char)(c1 << '\004');
        if ((i6 >= 48) && (i6 <= 57)) {
          i2 = i7 + (i6 + -48);
        }
        for (;;)
        {
          i5++;
          break;
          if ((i6 >= 97) && (i6 <= 102))
          {
            i2 = i7 + (10 + (i6 + -97));
          }
          else
          {
            if ((i6 < 65) || (i6 > 70)) {
              break label273;
            }
            i2 = i7 + (10 + (i6 + -65));
          }
        }
        label273:
        throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
      }
      this.e = (4 + this.e);
      continue;
      int i2 = 9;
      continue;
      i2 = 8;
      continue;
      i2 = 10;
      continue;
      i2 = 13;
      continue;
      i2 = 12;
      continue;
      this.g = (1 + this.g);
      this.h = this.e;
    }
  }
  
  private void z()
  {
    b(true);
    this.e = (-1 + this.e);
    if ((this.e + a.length > this.f) && (!b(a.length))) {}
    for (;;)
    {
      return;
      for (int i1 = 0;; i1++)
      {
        if (i1 >= a.length) {
          break label80;
        }
        if (this.d[(i1 + this.e)] != a[i1]) {
          break;
        }
      }
      label80:
      this.e += a.length;
    }
  }
  
  public void a()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    if (i1 == 3)
    {
      a(1);
      this.i = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + u() + " column " + v());
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    if (i1 == 4)
    {
      this.n = (-1 + this.n);
      this.i = 0;
      return;
    }
    throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + u() + " column " + v());
  }
  
  public void c()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    if (i1 == 1)
    {
      a(3);
      this.i = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + u() + " column " + v());
  }
  
  public void close()
  {
    this.i = 0;
    this.m[0] = 8;
    this.n = 1;
    this.b.close();
  }
  
  public void d()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    if (i1 == 2)
    {
      this.n = (-1 + this.n);
      this.i = 0;
      return;
    }
    throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + u() + " column " + v());
  }
  
  public boolean e()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    if ((i1 != 2) && (i1 != 4)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public rq f()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    rq localrq;
    switch (i1)
    {
    default: 
      throw new AssertionError();
    case 1: 
      localrq = rq.c;
    }
    for (;;)
    {
      return localrq;
      localrq = rq.d;
      continue;
      localrq = rq.a;
      continue;
      localrq = rq.b;
      continue;
      localrq = rq.e;
      continue;
      localrq = rq.h;
      continue;
      localrq = rq.i;
      continue;
      localrq = rq.f;
      continue;
      localrq = rq.g;
      continue;
      localrq = rq.j;
    }
  }
  
  public String g()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    String str;
    if (i1 == 14) {
      str = s();
    }
    for (;;)
    {
      this.i = 0;
      return str;
      if (i1 == 12)
      {
        str = b('\'');
      }
      else
      {
        if (i1 != 13) {
          break;
        }
        str = b('"');
      }
    }
    throw new IllegalStateException("Expected a name but was " + f() + " at line " + u() + " column " + v());
  }
  
  public String h()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    String str;
    if (i1 == 10) {
      str = s();
    }
    for (;;)
    {
      this.i = 0;
      return str;
      if (i1 == 8)
      {
        str = b('\'');
      }
      else if (i1 == 9)
      {
        str = b('"');
      }
      else if (i1 == 11)
      {
        str = this.l;
        this.l = null;
      }
      else if (i1 == 15)
      {
        str = Long.toString(this.j);
      }
      else
      {
        if (i1 != 16) {
          break;
        }
        str = new String(this.d, this.e, this.k);
        this.e += this.k;
      }
    }
    throw new IllegalStateException("Expected a string but was " + f() + " at line " + u() + " column " + v());
  }
  
  public boolean i()
  {
    boolean bool = false;
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    if (i1 == 5)
    {
      this.i = 0;
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (i1 != 6) {
        break;
      }
      this.i = 0;
    }
    throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + u() + " column " + v());
  }
  
  public void j()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    if (i1 == 7)
    {
      this.i = 0;
      return;
    }
    throw new IllegalStateException("Expected null but was " + f() + " at line " + u() + " column " + v());
  }
  
  public double k()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    double d1;
    if (i1 == 15)
    {
      this.i = 0;
      d1 = this.j;
    }
    for (;;)
    {
      return d1;
      if (i1 == 16)
      {
        this.l = new String(this.d, this.e, this.k);
        this.e += this.k;
      }
      do
      {
        for (;;)
        {
          this.i = 11;
          d1 = Double.parseDouble(this.l);
          if ((this.c) || ((!Double.isNaN(d1)) && (!Double.isInfinite(d1)))) {
            break label279;
          }
          throw new rs("JSON forbids NaN and infinities: " + d1 + " at line " + u() + " column " + v());
          if ((i1 == 8) || (i1 == 9))
          {
            if (i1 == 8) {}
            for (char c1 = '\'';; c1 = '"')
            {
              this.l = b(c1);
              break;
            }
          }
          if (i1 != 10) {
            break;
          }
          this.l = s();
        }
      } while (i1 == 11);
      throw new IllegalStateException("Expected a double but was " + f() + " at line " + u() + " column " + v());
      label279:
      this.l = null;
      this.i = 0;
    }
  }
  
  public long l()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    long l1;
    if (i1 == 15)
    {
      this.i = 0;
      l1 = this.j;
    }
    for (;;)
    {
      return l1;
      if (i1 == 16)
      {
        this.l = new String(this.d, this.e, this.k);
        this.e += this.k;
        label76:
        this.i = 11;
        double d1 = Double.parseDouble(this.l);
        l1 = d1;
        if (l1 != d1) {
          throw new NumberFormatException("Expected a long but was " + this.l + " at line " + u() + " column " + v());
        }
      }
      else
      {
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8) {}
          for (char c1 = '\'';; c1 = '"')
          {
            for (;;)
            {
              this.l = b(c1);
              try
              {
                l1 = Long.parseLong(this.l);
                this.i = 0;
              }
              catch (NumberFormatException localNumberFormatException) {}
            }
            break label76;
          }
        }
        throw new IllegalStateException("Expected a long but was " + f() + " at line " + u() + " column " + v());
      }
      this.l = null;
      this.i = 0;
    }
  }
  
  public int m()
  {
    int i1 = this.i;
    if (i1 == 0) {
      i1 = o();
    }
    int i2;
    if (i1 == 15)
    {
      i2 = (int)this.j;
      if (this.j != i2) {
        throw new NumberFormatException("Expected an int but was " + this.j + " at line " + u() + " column " + v());
      }
    }
    for (this.i = 0;; this.i = 0)
    {
      return i2;
      if (i1 == 16)
      {
        this.l = new String(this.d, this.e, this.k);
        this.e += this.k;
        label143:
        this.i = 11;
        double d1 = Double.parseDouble(this.l);
        i2 = (int)d1;
        if (i2 != d1) {
          throw new NumberFormatException("Expected an int but was " + this.l + " at line " + u() + " column " + v());
        }
      }
      else
      {
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8) {}
          for (char c1 = '\'';; c1 = '"')
          {
            for (;;)
            {
              this.l = b(c1);
              try
              {
                i2 = Integer.parseInt(this.l);
                this.i = 0;
              }
              catch (NumberFormatException localNumberFormatException) {}
            }
            break label143;
          }
        }
        throw new IllegalStateException("Expected an int but was " + f() + " at line " + u() + " column " + v());
      }
      this.l = null;
    }
  }
  
  public void n()
  {
    int i1 = 0;
    int i2 = this.i;
    if (i2 == 0) {
      i2 = o();
    }
    if (i2 == 3)
    {
      a(1);
      i1++;
    }
    for (;;)
    {
      this.i = 0;
      if (i1 != 0) {
        break;
      }
      return;
      if (i2 == 1)
      {
        a(3);
        i1++;
      }
      else if (i2 == 4)
      {
        this.n = (-1 + this.n);
        i1--;
      }
      else if (i2 == 2)
      {
        this.n = (-1 + this.n);
        i1--;
      }
      else if ((i2 == 14) || (i2 == 10))
      {
        t();
      }
      else if ((i2 == 8) || (i2 == 12))
      {
        c('\'');
      }
      else if ((i2 == 9) || (i2 == 13))
      {
        c('"');
      }
      else if (i2 == 16)
      {
        this.e += this.k;
      }
    }
  }
  
  public final boolean p()
  {
    return this.c;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " at line " + u() + " column " + v();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     ro
 * JD-Core Version:    0.7.0.1
 */