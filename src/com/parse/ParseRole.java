package com.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ParseClassName("_Role")
public class ParseRole
  extends ParseObject
{
  private static final Pattern NAME_PATTERN = Pattern.compile("^[0-9a-zA-Z_\\- ]+$");
  
  ParseRole() {}
  
  public ParseRole(String paramString)
  {
    this();
    setName(paramString);
  }
  
  public ParseRole(String paramString, ParseACL paramParseACL)
  {
    this(paramString);
    setACL(paramParseACL);
  }
  
  public static ParseQuery<ParseRole> getQuery()
  {
    return ParseQuery.getQuery(ParseRole.class);
  }
  
  public String getName()
  {
    return getString("name");
  }
  
  public ParseRelation<ParseRole> getRoles()
  {
    return getRelation("roles");
  }
  
  public ParseRelation<ParseUser> getUsers()
  {
    return getRelation("users");
  }
  
  public void put(String paramString, Object paramObject)
  {
    if ("name".equals(paramString))
    {
      if (getObjectId() != null) {
        throw new IllegalArgumentException("A role's name can only be set before it has been saved.");
      }
      if (!(paramObject instanceof String)) {
        throw new IllegalArgumentException("A role's name must be a String.");
      }
      if (!NAME_PATTERN.matcher((String)paramObject).matches()) {
        throw new IllegalArgumentException("A role's name can only contain alphanumeric characters, _, -, and spaces.");
      }
    }
    super.put(paramString, paramObject);
  }
  
  public void setName(String paramString)
  {
    put("name", paramString);
  }
  
  /* Error */
  protected void validateSave()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	com/parse/ParseRole:mutex	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 73	com/parse/ParseRole:getObjectId	()Ljava/lang/String;
    //   11: ifnonnull +25 -> 36
    //   14: aload_0
    //   15: invokevirtual 102	com/parse/ParseRole:getName	()Ljava/lang/String;
    //   18: ifnonnull +18 -> 36
    //   21: new 104	java/lang/IllegalStateException
    //   24: dup
    //   25: ldc 106
    //   27: invokespecial 107	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   30: athrow
    //   31: astore_2
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    //   36: aload_0
    //   37: invokespecial 109	com/parse/ParseObject:validateSave	()V
    //   40: aload_1
    //   41: monitorexit
    //   42: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	ParseRole
    //   4	37	1	localObject1	Object
    //   31	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	34	31	finally
    //   36	42	31	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseRole
 * JD-Core Version:    0.7.0.1
 */