package com.parse;

import l;
import m;

final class ParseUser$16
  implements l<Void, m<ParseUser>>
{
  ParseUser$16(l paraml, ParseUser paramParseUser) {}
  
  public m<ParseUser> then(m<Void> paramm)
  {
    m localm;
    if ((paramm.d()) && ((paramm.f() instanceof ParseException)) && (((ParseException)paramm.f()).getCode() == 208)) {
      localm = m.a(null).b(this.val$logInWithTask);
    }
    for (;;)
    {
      return localm;
      if (paramm.c()) {
        localm = m.h();
      } else {
        localm = m.a(this.val$user);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.16
 * JD-Core Version:    0.7.0.1
 */