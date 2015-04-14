package com.squareup.picasso;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Action$RequestWeakReference<T>
  extends WeakReference<T>
{
  final Action action;
  
  public Action$RequestWeakReference(Action paramAction, T paramT, ReferenceQueue<? super T> paramReferenceQueue)
  {
    super(paramT, paramReferenceQueue);
    this.action = paramAction;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Action.RequestWeakReference
 * JD-Core Version:    0.7.0.1
 */