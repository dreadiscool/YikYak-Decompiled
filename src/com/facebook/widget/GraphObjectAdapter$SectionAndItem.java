package com.facebook.widget;

import com.facebook.model.GraphObject;

public class GraphObjectAdapter$SectionAndItem<T extends GraphObject>
{
  public T graphObject;
  public String sectionKey;
  
  public GraphObjectAdapter$SectionAndItem(String paramString, T paramT)
  {
    this.sectionKey = paramString;
    this.graphObject = paramT;
  }
  
  public GraphObjectAdapter.SectionAndItem.Type getType()
  {
    GraphObjectAdapter.SectionAndItem.Type localType;
    if (this.sectionKey == null) {
      localType = GraphObjectAdapter.SectionAndItem.Type.ACTIVITY_CIRCLE;
    }
    for (;;)
    {
      return localType;
      if (this.graphObject == null) {
        localType = GraphObjectAdapter.SectionAndItem.Type.SECTION_HEADER;
      } else {
        localType = GraphObjectAdapter.SectionAndItem.Type.GRAPH_OBJECT;
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.GraphObjectAdapter.SectionAndItem
 * JD-Core Version:    0.7.0.1
 */