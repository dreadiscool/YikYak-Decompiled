package com.parse;

import l;
import m;
import org.json.JSONObject;

class ParsePinningEventuallyQueue$13$1$2
  implements l<Void, m<Void>>
{
  ParsePinningEventuallyQueue$13$1$2(ParsePinningEventuallyQueue.13.1 param1, m paramm) {}
  
  public m<Void> then(m<Void> paramm)
  {
    Object localObject = this.val$saveTask.e();
    if (this.this$2.val$type == 1) {
      paramm = this.this$2.val$object.handleSaveEventuallyResultAsync((JSONObject)localObject, this.this$2.this$1.val$operationSet);
    }
    for (;;)
    {
      return paramm;
      if (this.this$2.val$type == 2) {
        paramm = this.this$2.val$object.handleDeleteEventuallyResultAsync(localObject);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ParsePinningEventuallyQueue.13.1.2
 * JD-Core Version:    0.7.0.1
 */