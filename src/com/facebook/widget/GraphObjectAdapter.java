package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.FacebookException;
import com.facebook.android.R.drawable;
import com.facebook.android.R.id;
import com.facebook.android.R.layout;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageResponse;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

class GraphObjectAdapter<T extends GraphObject>
  extends BaseAdapter
  implements SectionIndexer
{
  private static final int ACTIVITY_CIRCLE_VIEW_TYPE = 2;
  private static final int DISPLAY_SECTIONS_THRESHOLD = 1;
  private static final int GRAPH_OBJECT_VIEW_TYPE = 1;
  private static final int HEADER_VIEW_TYPE = 0;
  private static final String ID = "id";
  private static final int MAX_PREFETCHED_PICTURES = 20;
  private static final String NAME = "name";
  private static final String PICTURE = "picture";
  private Context context;
  private GraphObjectCursor<T> cursor;
  private GraphObjectAdapter.DataNeededListener dataNeededListener;
  private boolean displaySections;
  private GraphObjectAdapter.Filter<T> filter;
  private Map<String, T> graphObjectsById = new HashMap();
  private Map<String, ArrayList<T>> graphObjectsBySection = new HashMap();
  private String groupByField;
  private final LayoutInflater inflater;
  private GraphObjectAdapter.OnErrorListener onErrorListener;
  private final Map<String, ImageRequest> pendingRequests = new HashMap();
  private Map<String, ImageResponse> prefetchedPictureCache = new HashMap();
  private ArrayList<String> prefetchedProfilePictureIds = new ArrayList();
  private List<String> sectionKeys = new ArrayList();
  private boolean showCheckbox;
  private boolean showPicture;
  private List<String> sortFields;
  
  static
  {
    if (!GraphObjectAdapter.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public GraphObjectAdapter(Context paramContext)
  {
    this.context = paramContext;
    this.inflater = LayoutInflater.from(paramContext);
  }
  
  private void callOnErrorListener(Exception paramException)
  {
    if (this.onErrorListener != null) {
      if ((paramException instanceof FacebookException)) {
        break label38;
      }
    }
    label38:
    for (Object localObject = new FacebookException(paramException);; localObject = paramException)
    {
      this.onErrorListener.onError(this, (FacebookException)localObject);
      return;
    }
  }
  
  private static int compareGraphObjects(GraphObject paramGraphObject1, GraphObject paramGraphObject2, Collection<String> paramCollection, Collator paramCollator)
  {
    Iterator localIterator = paramCollection.iterator();
    String str2;
    String str3;
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break label112;
      }
      String str1 = (String)localIterator.next();
      str2 = (String)paramGraphObject1.getProperty(str1);
      str3 = (String)paramGraphObject2.getProperty(str1);
      if ((str2 == null) || (str3 == null)) {
        break;
      }
      i = paramCollator.compare(str2, str3);
    } while (i == 0);
    for (;;)
    {
      return i;
      if ((str2 == null) && (str3 == null)) {
        break;
      }
      if (str2 == null)
      {
        i = -1;
      }
      else
      {
        i = 1;
        continue;
        label112:
        i = 0;
      }
    }
  }
  
  private void downloadProfilePicture(String paramString, URI paramURI, ImageView paramImageView)
  {
    if (paramURI == null) {}
    label108:
    for (;;)
    {
      return;
      if (paramImageView == null) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (paramURI.equals(paramImageView.getTag()))) {
          break label108;
        }
        if (i == 0)
        {
          paramImageView.setTag(paramString);
          paramImageView.setImageResource(getDefaultPicture());
        }
        ImageRequest localImageRequest = new ImageRequest.Builder(this.context.getApplicationContext(), paramURI).setCallerTag(this).setCallback(new GraphObjectAdapter.2(this, paramString, paramImageView)).build();
        this.pendingRequests.put(paramString, localImageRequest);
        ImageDownloader.downloadAsync(localImageRequest);
        break;
      }
    }
  }
  
  private View getActivityCircleView(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.inflater.inflate(R.layout.com_facebook_picker_activity_circle_row, null);
    }
    ((ProgressBar)paramView.findViewById(R.id.com_facebook_picker_row_activity_circle)).setVisibility(0);
    return paramView;
  }
  
  private void processImageResponse(ImageResponse paramImageResponse, String paramString, ImageView paramImageView)
  {
    this.pendingRequests.remove(paramString);
    if (paramImageResponse.getError() != null) {
      callOnErrorListener(paramImageResponse.getError());
    }
    if (paramImageView == null) {
      if (paramImageResponse.getBitmap() != null)
      {
        if (this.prefetchedPictureCache.size() >= 20)
        {
          String str = (String)this.prefetchedProfilePictureIds.remove(0);
          this.prefetchedPictureCache.remove(str);
        }
        this.prefetchedPictureCache.put(paramString, paramImageResponse);
      }
    }
    for (;;)
    {
      return;
      if (paramString.equals(paramImageView.getTag()))
      {
        Exception localException = paramImageResponse.getError();
        Bitmap localBitmap = paramImageResponse.getBitmap();
        if ((localException == null) && (localBitmap != null))
        {
          paramImageView.setImageBitmap(localBitmap);
          paramImageView.setTag(paramImageResponse.getRequest().getImageUri());
        }
      }
    }
  }
  
  private void rebuildSections()
  {
    boolean bool = false;
    this.sectionKeys = new ArrayList();
    this.graphObjectsBySection = new HashMap();
    this.graphObjectsById = new HashMap();
    this.displaySections = false;
    if ((this.cursor == null) || (this.cursor.getCount() == 0)) {
      return;
    }
    this.cursor.moveToFirst();
    int j;
    for (int i = 0;; i = j)
    {
      GraphObject localGraphObject = this.cursor.getGraphObject();
      if (!filterIncludesItem(localGraphObject)) {
        j = i;
      }
      for (;;)
      {
        if (!this.cursor.moveToNext())
        {
          if (this.sortFields != null)
          {
            Collator localCollator = Collator.getInstance();
            Iterator localIterator = this.graphObjectsBySection.values().iterator();
            for (;;)
            {
              if (localIterator.hasNext())
              {
                Collections.sort((List)localIterator.next(), new GraphObjectAdapter.1(this, localCollator));
                continue;
                j = i + 1;
                String str = getSectionKeyOfGraphObject(localGraphObject);
                if (!this.graphObjectsBySection.containsKey(str))
                {
                  this.sectionKeys.add(str);
                  this.graphObjectsBySection.put(str, new ArrayList());
                }
                ((List)this.graphObjectsBySection.get(str)).add(localGraphObject);
                this.graphObjectsById.put(getIdOfGraphObject(localGraphObject), localGraphObject);
                break;
              }
            }
          }
          Collections.sort(this.sectionKeys, Collator.getInstance());
          if ((this.sectionKeys.size() > 1) && (j > 1)) {
            bool = true;
          }
          this.displaySections = bool;
          break;
        }
      }
    }
  }
  
  private boolean shouldShowActivityCircleCell()
  {
    if ((this.cursor != null) && (this.cursor.areMoreObjectsAvailable()) && (this.dataNeededListener != null) && (!isEmpty())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.displaySections;
  }
  
  public boolean changeCursor(GraphObjectCursor<T> paramGraphObjectCursor)
  {
    if (this.cursor == paramGraphObjectCursor) {}
    for (boolean bool = false;; bool = true)
    {
      return bool;
      if (this.cursor != null) {
        this.cursor.close();
      }
      this.cursor = paramGraphObjectCursor;
      rebuildAndNotify();
    }
  }
  
  protected View createGraphObjectView(T paramT)
  {
    View localView = this.inflater.inflate(getGraphObjectRowLayoutId(paramT), null);
    ViewStub localViewStub1 = (ViewStub)localView.findViewById(R.id.com_facebook_picker_checkbox_stub);
    ViewStub localViewStub2;
    if (localViewStub1 != null)
    {
      if (!getShowCheckbox()) {
        localViewStub1.setVisibility(8);
      }
    }
    else
    {
      localViewStub2 = (ViewStub)localView.findViewById(R.id.com_facebook_picker_profile_pic_stub);
      if (getShowPicture()) {
        break label85;
      }
      localViewStub2.setVisibility(8);
    }
    for (;;)
    {
      return localView;
      updateCheckboxState((CheckBox)localViewStub1.inflate(), false);
      break;
      label85:
      ((ImageView)localViewStub2.inflate()).setVisibility(0);
    }
  }
  
  boolean filterIncludesItem(T paramT)
  {
    if ((this.filter == null) || (this.filter.includeItem(paramT))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.sectionKeys.size() == 0) {}
    for (;;)
    {
      return i;
      if (this.displaySections) {
        i = this.sectionKeys.size();
      }
      Iterator localIterator = this.graphObjectsBySection.values().iterator();
      int j = i;
      while (localIterator.hasNext()) {
        j += ((List)localIterator.next()).size();
      }
      if (shouldShowActivityCircleCell()) {
        j++;
      }
      i = j;
    }
  }
  
  public GraphObjectCursor<T> getCursor()
  {
    return this.cursor;
  }
  
  public GraphObjectAdapter.DataNeededListener getDataNeededListener()
  {
    return this.dataNeededListener;
  }
  
  protected int getDefaultPicture()
  {
    return R.drawable.com_facebook_profile_default_icon;
  }
  
  GraphObjectAdapter.Filter<T> getFilter()
  {
    return this.filter;
  }
  
  protected int getGraphObjectRowLayoutId(T paramT)
  {
    return R.layout.com_facebook_picker_list_row;
  }
  
  protected View getGraphObjectView(T paramT, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = createGraphObjectView(paramT);
    }
    populateGraphObjectView(paramView, paramT);
    return paramView;
  }
  
  public List<T> getGraphObjectsById(Collection<String> paramCollection)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(paramCollection);
    ArrayList localArrayList = new ArrayList(localHashSet.size());
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GraphObject localGraphObject = (GraphObject)this.graphObjectsById.get(str);
      if (localGraphObject != null) {
        localArrayList.add(localGraphObject);
      }
    }
    return localArrayList;
  }
  
  public String getGroupByField()
  {
    return this.groupByField;
  }
  
  String getIdOfGraphObject(T paramT)
  {
    if (paramT.asMap().containsKey("id"))
    {
      Object localObject = paramT.getProperty("id");
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
    }
    throw new FacebookException("Received an object without an ID.");
  }
  
  public Object getItem(int paramInt)
  {
    GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
    if (localSectionAndItem.getType() == GraphObjectAdapter.SectionAndItem.Type.GRAPH_OBJECT) {}
    for (GraphObject localGraphObject = localSectionAndItem.graphObject;; localGraphObject = null) {
      return localGraphObject;
    }
  }
  
  public long getItemId(int paramInt)
  {
    GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
    String str;
    if ((localSectionAndItem != null) && (localSectionAndItem.graphObject != null))
    {
      str = getIdOfGraphObject(localSectionAndItem.graphObject);
      if (str == null) {}
    }
    for (;;)
    {
      try
      {
        long l2 = Long.parseLong(str);
        l1 = l2;
        return l1;
      }
      catch (NumberFormatException localNumberFormatException) {}
      long l1 = 0L;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
    int i;
    switch (GraphObjectAdapter.3.$SwitchMap$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type[localSectionAndItem.getType().ordinal()])
    {
    default: 
      throw new FacebookException("Unexpected type of section and item.");
    case 1: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public GraphObjectAdapter.OnErrorListener getOnErrorListener()
  {
    return this.onErrorListener;
  }
  
  String getPictureFieldSpecifier()
  {
    ImageView localImageView = (ImageView)createGraphObjectView(null).findViewById(R.id.com_facebook_picker_image);
    if (localImageView == null) {}
    Locale localLocale;
    Object[] arrayOfObject;
    for (String str = null;; str = String.format(localLocale, "picture.height(%d).width(%d)", arrayOfObject))
    {
      return str;
      ViewGroup.LayoutParams localLayoutParams = localImageView.getLayoutParams();
      localLocale = Locale.US;
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(localLayoutParams.height);
      arrayOfObject[1] = Integer.valueOf(localLayoutParams.width);
    }
  }
  
  protected URI getPictureUriOfGraphObject(T paramT)
  {
    Object localObject = paramT.getProperty("picture");
    String str;
    if ((localObject instanceof String)) {
      str = (String)localObject;
    }
    for (;;)
    {
      if (str != null) {}
      for (;;)
      {
        try
        {
          localURI = new URI(str);
          return localURI;
        }
        catch (URISyntaxException localURISyntaxException) {}
        if (!(localObject instanceof JSONObject)) {
          break label94;
        }
        GraphObjectAdapter.ItemPictureData localItemPictureData = ((GraphObjectAdapter.ItemPicture)GraphObject.Factory.create((JSONObject)localObject).cast(GraphObjectAdapter.ItemPicture.class)).getData();
        if (localItemPictureData == null) {
          break label94;
        }
        str = localItemPictureData.getUrl();
        break;
        URI localURI = null;
      }
      label94:
      str = null;
    }
  }
  
  int getPosition(String paramString, T paramT)
  {
    int i = 0;
    Iterator localIterator1 = this.sectionKeys.iterator();
    int j = 0;
    String str;
    if (localIterator1.hasNext())
    {
      str = (String)localIterator1.next();
      if (this.displaySections) {
        j++;
      }
      if (!str.equals(paramString)) {}
    }
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        j = -1;
      }
      for (;;)
      {
        return j;
        j += ((ArrayList)this.graphObjectsBySection.get(str)).size();
        break;
        if (paramT == null)
        {
          if (this.displaySections) {
            i = 1;
          }
          j -= i;
        }
        else
        {
          Iterator localIterator2 = ((ArrayList)this.graphObjectsBySection.get(paramString)).iterator();
          for (;;)
          {
            if (!localIterator2.hasNext()) {
              break label170;
            }
            if (GraphObject.Factory.hasSameId((GraphObject)localIterator2.next(), paramT)) {
              break;
            }
            j++;
          }
          label170:
          j = -1;
        }
      }
    }
  }
  
  public int getPositionForSection(int paramInt)
  {
    int i = 0;
    if (this.displaySections)
    {
      int j = Math.max(0, Math.min(paramInt, -1 + this.sectionKeys.size()));
      if (j < this.sectionKeys.size()) {
        i = getPosition((String)this.sectionKeys.get(j), null);
      }
    }
    return i;
  }
  
  GraphObjectAdapter.SectionAndItem<T> getSectionAndItem(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2;
    if (this.sectionKeys.size() == 0)
    {
      localObject2 = null;
      return localObject2;
    }
    GraphObject localGraphObject;
    if (!this.displaySections)
    {
      String str2 = (String)this.sectionKeys.get(0);
      List localList2 = (List)this.graphObjectsBySection.get(str2);
      if ((paramInt >= 0) && (paramInt < localList2.size()))
      {
        localGraphObject = (GraphObject)((ArrayList)this.graphObjectsBySection.get(str2)).get(paramInt);
        localObject1 = str2;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = new GraphObjectAdapter.SectionAndItem(localObject1, localGraphObject);
        break;
        assert ((this.dataNeededListener != null) && (this.cursor.areMoreObjectsAvailable()));
        localObject2 = new GraphObjectAdapter.SectionAndItem(null, null);
        break;
        Iterator localIterator = this.sectionKeys.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label286;
          }
          String str1 = (String)localIterator.next();
          int i = paramInt - 1;
          if (paramInt == 0)
          {
            localGraphObject = null;
            localObject1 = str1;
            break;
          }
          List localList1 = (List)this.graphObjectsBySection.get(str1);
          if (i < localList1.size())
          {
            localGraphObject = (GraphObject)localList1.get(i);
            localObject1 = str1;
            break;
          }
          paramInt = i - localList1.size();
        }
      }
      throw new IndexOutOfBoundsException("position");
      label286:
      localGraphObject = null;
    }
  }
  
  public int getSectionForPosition(int paramInt)
  {
    int i = 0;
    GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
    if ((localSectionAndItem != null) && (localSectionAndItem.getType() != GraphObjectAdapter.SectionAndItem.Type.ACTIVITY_CIRCLE)) {
      i = Math.max(0, Math.min(this.sectionKeys.indexOf(localSectionAndItem.sectionKey), -1 + this.sectionKeys.size()));
    }
    return i;
  }
  
  protected View getSectionHeaderView(String paramString, View paramView, ViewGroup paramViewGroup)
  {
    TextView localTextView1 = (TextView)paramView;
    if (localTextView1 == null) {}
    for (TextView localTextView2 = (TextView)this.inflater.inflate(R.layout.com_facebook_picker_list_section_header, null);; localTextView2 = localTextView1)
    {
      localTextView2.setText(paramString);
      return localTextView2;
    }
  }
  
  protected String getSectionKeyOfGraphObject(T paramT)
  {
    String str = null;
    if (this.groupByField != null)
    {
      str = (String)paramT.getProperty(this.groupByField);
      if ((str != null) && (str.length() > 0)) {
        str = str.substring(0, 1).toUpperCase();
      }
    }
    if (str != null) {}
    for (;;)
    {
      return str;
      str = "";
    }
  }
  
  public Object[] getSections()
  {
    if (this.displaySections) {}
    for (Object[] arrayOfObject = this.sectionKeys.toArray();; arrayOfObject = new Object[0]) {
      return arrayOfObject;
    }
  }
  
  public boolean getShowCheckbox()
  {
    return this.showCheckbox;
  }
  
  public boolean getShowPicture()
  {
    return this.showPicture;
  }
  
  public List<String> getSortFields()
  {
    return this.sortFields;
  }
  
  protected CharSequence getSubTitleOfGraphObject(T paramT)
  {
    return null;
  }
  
  protected CharSequence getTitleOfGraphObject(T paramT)
  {
    return (String)paramT.getProperty("name");
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GraphObjectAdapter.SectionAndItem localSectionAndItem = getSectionAndItem(paramInt);
    View localView;
    switch (GraphObjectAdapter.3.$SwitchMap$com$facebook$widget$GraphObjectAdapter$SectionAndItem$Type[localSectionAndItem.getType().ordinal()])
    {
    default: 
      throw new FacebookException("Unexpected type of section and item.");
    case 1: 
      localView = getSectionHeaderView(localSectionAndItem.sectionKey, paramView, paramViewGroup);
    }
    for (;;)
    {
      return localView;
      localView = getGraphObjectView(localSectionAndItem.graphObject, paramView, paramViewGroup);
      continue;
      assert ((this.cursor.areMoreObjectsAvailable()) && (this.dataNeededListener != null));
      this.dataNeededListener.onDataNeeded();
      localView = getActivityCircleView(paramView, paramViewGroup);
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isEmpty()
  {
    if (this.sectionKeys.size() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (getSectionAndItem(paramInt).getType() == GraphObjectAdapter.SectionAndItem.Type.GRAPH_OBJECT) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean isGraphObjectSelected(String paramString)
  {
    return false;
  }
  
  protected void populateGraphObjectView(View paramView, T paramT)
  {
    String str = getIdOfGraphObject(paramT);
    paramView.setTag(str);
    CharSequence localCharSequence1 = getTitleOfGraphObject(paramT);
    TextView localTextView1 = (TextView)paramView.findViewById(R.id.com_facebook_picker_title);
    if (localTextView1 != null) {
      localTextView1.setText(localCharSequence1, TextView.BufferType.SPANNABLE);
    }
    CharSequence localCharSequence2 = getSubTitleOfGraphObject(paramT);
    TextView localTextView2 = (TextView)paramView.findViewById(R.id.picker_subtitle);
    URI localURI;
    ImageView localImageView;
    if (localTextView2 != null)
    {
      if (localCharSequence2 != null)
      {
        localTextView2.setText(localCharSequence2, TextView.BufferType.SPANNABLE);
        localTextView2.setVisibility(0);
      }
    }
    else
    {
      if (getShowCheckbox()) {
        updateCheckboxState((CheckBox)paramView.findViewById(R.id.com_facebook_picker_checkbox), isGraphObjectSelected(str));
      }
      if (getShowPicture())
      {
        localURI = getPictureUriOfGraphObject(paramT);
        if (localURI != null)
        {
          localImageView = (ImageView)paramView.findViewById(R.id.com_facebook_picker_image);
          if (!this.prefetchedPictureCache.containsKey(str)) {
            break label209;
          }
          ImageResponse localImageResponse = (ImageResponse)this.prefetchedPictureCache.get(str);
          localImageView.setImageBitmap(localImageResponse.getBitmap());
          localImageView.setTag(localImageResponse.getRequest().getImageUri());
        }
      }
    }
    for (;;)
    {
      return;
      localTextView2.setVisibility(8);
      break;
      label209:
      downloadProfilePicture(str, localURI, localImageView);
    }
  }
  
  public void prioritizeViewRange(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt1) || (this.sectionKeys.size() == 0)) {}
    for (;;)
    {
      return;
      for (int i = paramInt2; i >= 0; i--)
      {
        GraphObjectAdapter.SectionAndItem localSectionAndItem3 = getSectionAndItem(i);
        if (localSectionAndItem3.graphObject != null)
        {
          String str2 = getIdOfGraphObject(localSectionAndItem3.graphObject);
          ImageRequest localImageRequest = (ImageRequest)this.pendingRequests.get(str2);
          if (localImageRequest != null) {
            ImageDownloader.prioritizeRequest(localImageRequest);
          }
        }
      }
      int j = Math.max(0, paramInt1 - paramInt3);
      int k = Math.min(paramInt2 + paramInt3, -1 + getCount());
      ArrayList localArrayList = new ArrayList();
      while (j < paramInt1)
      {
        GraphObjectAdapter.SectionAndItem localSectionAndItem2 = getSectionAndItem(j);
        if (localSectionAndItem2.graphObject != null) {
          localArrayList.add(localSectionAndItem2.graphObject);
        }
        j++;
      }
      for (int m = paramInt2 + 1; m <= k; m++)
      {
        GraphObjectAdapter.SectionAndItem localSectionAndItem1 = getSectionAndItem(m);
        if (localSectionAndItem1.graphObject != null) {
          localArrayList.add(localSectionAndItem1.graphObject);
        }
      }
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        GraphObject localGraphObject = (GraphObject)localIterator.next();
        URI localURI = getPictureUriOfGraphObject(localGraphObject);
        String str1 = getIdOfGraphObject(localGraphObject);
        boolean bool = this.prefetchedProfilePictureIds.remove(str1);
        this.prefetchedProfilePictureIds.add(str1);
        if (!bool) {
          downloadProfilePicture(str1, localURI, null);
        }
      }
    }
  }
  
  public void rebuildAndNotify()
  {
    rebuildSections();
    notifyDataSetChanged();
  }
  
  public void setDataNeededListener(GraphObjectAdapter.DataNeededListener paramDataNeededListener)
  {
    this.dataNeededListener = paramDataNeededListener;
  }
  
  void setFilter(GraphObjectAdapter.Filter<T> paramFilter)
  {
    this.filter = paramFilter;
  }
  
  public void setGroupByField(String paramString)
  {
    this.groupByField = paramString;
  }
  
  public void setOnErrorListener(GraphObjectAdapter.OnErrorListener paramOnErrorListener)
  {
    this.onErrorListener = paramOnErrorListener;
  }
  
  public void setShowCheckbox(boolean paramBoolean)
  {
    this.showCheckbox = paramBoolean;
  }
  
  public void setShowPicture(boolean paramBoolean)
  {
    this.showPicture = paramBoolean;
  }
  
  public void setSortFields(List<String> paramList)
  {
    this.sortFields = paramList;
  }
  
  void updateCheckboxState(CheckBox paramCheckBox, boolean paramBoolean) {}
}



/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar

 * Qualified Name:     com.facebook.widget.GraphObjectAdapter

 * JD-Core Version:    0.7.0.1

 */