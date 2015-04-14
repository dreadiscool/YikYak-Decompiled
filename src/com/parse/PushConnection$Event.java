package com.parse;

 enum PushConnection$Event
{
  static
  {
    CONNECTIVITY_CHANGED = new Event("CONNECTIVITY_CHANGED", 2);
    KEEP_ALIVE_ERROR = new Event("KEEP_ALIVE_ERROR", 3);
    READ_ERROR = new Event("READ_ERROR", 4);
    Event[] arrayOfEvent = new Event[5];
    arrayOfEvent[0] = START;
    arrayOfEvent[1] = STOP;
    arrayOfEvent[2] = CONNECTIVITY_CHANGED;
    arrayOfEvent[3] = KEEP_ALIVE_ERROR;
    arrayOfEvent[4] = READ_ERROR;
    $VALUES = arrayOfEvent;
  }
  
  private PushConnection$Event() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.PushConnection.Event
 * JD-Core Version:    0.7.0.1
 */