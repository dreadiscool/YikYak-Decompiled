package android.support.v4.media.routing;

import android.media.MediaRouter.RouteGroup;
import java.util.ArrayList;
import java.util.List;

public final class MediaRouterJellybean$RouteGroup
{
  public static List getGroupedRoutes(Object paramObject)
  {
    MediaRouter.RouteGroup localRouteGroup = (MediaRouter.RouteGroup)paramObject;
    int i = localRouteGroup.getRouteCount();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add(localRouteGroup.getRouteAt(j));
    }
    return localArrayList;
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.media.routing.MediaRouterJellybean.RouteGroup
 * JD-Core Version:    0.7.0.1
 */