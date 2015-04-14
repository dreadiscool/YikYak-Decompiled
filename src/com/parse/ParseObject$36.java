package com.parse;

import k;

class ParseObject$36
  extends ParseTraverser
{
  ParseObject$36(ParseObject paramParseObject, k paramk) {}
  
  protected boolean visit(Object paramObject)
  {
    if (((paramObject instanceof ParseObject)) && (((ParseObject)paramObject).getObjectId() == null)) {
      this.val$result.a(Boolean.valueOf(false));
    }
    return ((Boolean)this.val$result.a()).booleanValue();
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseObject.36
 * JD-Core Version:    0.7.0.1
 */