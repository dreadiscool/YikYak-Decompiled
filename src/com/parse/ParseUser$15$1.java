package com.parse;

import l;
import m;

class ParseUser$15$1
  implements l<Void, m<ParseUser>>
{
  ParseUser$15$1(ParseUser.15 param15) {}
  
  /* Error */
  public m<ParseUser> then(m<Void> paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   4: getfield 27	com/parse/ParseUser$15:val$user	Lcom/parse/ParseUser;
    //   7: getfield 33	com/parse/ParseUser:mutex	Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: monitorenter
    //   13: aload_1
    //   14: invokevirtual 39	m:d	()Z
    //   17: ifeq +78 -> 95
    //   20: aload_0
    //   21: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   24: getfield 27	com/parse/ParseUser$15:val$user	Lcom/parse/ParseUser;
    //   27: invokestatic 43	com/parse/ParseUser:access$700	(Lcom/parse/ParseUser;)Lorg/json/JSONObject;
    //   30: aload_0
    //   31: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   34: getfield 47	com/parse/ParseUser$15:val$authType	Ljava/lang/String;
    //   37: invokevirtual 53	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   40: pop
    //   41: aload_0
    //   42: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   45: getfield 27	com/parse/ParseUser$15:val$user	Lcom/parse/ParseUser;
    //   48: invokestatic 57	com/parse/ParseUser:access$800	(Lcom/parse/ParseUser;)Ljava/util/Set;
    //   51: aload_0
    //   52: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   55: getfield 47	com/parse/ParseUser$15:val$authType	Ljava/lang/String;
    //   58: invokeinterface 62 2 0
    //   63: pop
    //   64: aload_0
    //   65: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   68: getfield 27	com/parse/ParseUser$15:val$user	Lcom/parse/ParseUser;
    //   71: aload_0
    //   72: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   75: getfield 66	com/parse/ParseUser$15:val$oldAnonymousData	Lorg/json/JSONObject;
    //   78: invokestatic 70	com/parse/ParseUser:access$1100	(Lcom/parse/ParseUser;Lorg/json/JSONObject;)V
    //   81: aload_1
    //   82: invokevirtual 74	m:f	()Ljava/lang/Exception;
    //   85: invokestatic 78	m:a	(Ljava/lang/Exception;)Lm;
    //   88: astore 4
    //   90: aload_2
    //   91: monitorexit
    //   92: goto +39 -> 131
    //   95: aload_1
    //   96: invokevirtual 81	m:c	()Z
    //   99: ifeq +18 -> 117
    //   102: invokestatic 85	m:h	()Lm;
    //   105: astore 4
    //   107: aload_2
    //   108: monitorexit
    //   109: goto +22 -> 131
    //   112: astore_3
    //   113: aload_2
    //   114: monitorexit
    //   115: aload_3
    //   116: athrow
    //   117: aload_0
    //   118: getfield 13	com/parse/ParseUser$15$1:this$0	Lcom/parse/ParseUser$15;
    //   121: getfield 27	com/parse/ParseUser$15:val$user	Lcom/parse/ParseUser;
    //   124: invokestatic 88	m:a	(Ljava/lang/Object;)Lm;
    //   127: astore 4
    //   129: aload_2
    //   130: monitorexit
    //   131: aload 4
    //   133: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	1
    //   0	134	1	paramm	m<Void>
    //   10	120	2	localObject1	Object
    //   112	4	3	localObject2	Object
    //   88	44	4	localm	m
    // Exception table:
    //   from	to	target	type
    //   13	115	112	finally
    //   117	131	112	finally
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParseUser.15.1
 * JD-Core Version:    0.7.0.1
 */