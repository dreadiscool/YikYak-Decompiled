package com.facebook.widget;

import android.app.Activity;
import android.content.res.TypedArray;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import com.facebook.AppEventsLogger;
import com.facebook.Request;
import com.facebook.Session;
import com.facebook.android.R.id;
import com.facebook.android.R.layout;
import com.facebook.android.R.string;
import com.facebook.android.R.styleable;
import com.facebook.internal.Utility;
import com.facebook.model.GraphPlace;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;

public class PlacePickerFragment
  extends PickerFragment<GraphPlace>
{
  private static final String CATEGORY = "category";
  public static final int DEFAULT_RADIUS_IN_METERS = 1000;
  public static final int DEFAULT_RESULTS_LIMIT = 100;
  private static final String ID = "id";
  private static final String LOCATION = "location";
  public static final String LOCATION_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.Location";
  private static final String NAME = "name";
  public static final String RADIUS_IN_METERS_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.RadiusInMeters";
  public static final String RESULTS_LIMIT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ResultsLimit";
  public static final String SEARCH_TEXT_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.SearchText";
  public static final String SHOW_SEARCH_BOX_BUNDLE_KEY = "com.facebook.widget.PlacePickerFragment.ShowSearchBox";
  private static final String TAG = "PlacePickerFragment";
  private static final String WERE_HERE_COUNT = "were_here_count";
  private static final int searchTextTimerDelayInMilliseconds = 2000;
  private boolean hasSearchTextChangedSinceLastQuery;
  private Location location;
  private int radiusInMeters = 1000;
  private int resultsLimit = 100;
  private EditText searchBox;
  private String searchText;
  private Timer searchTextTimer;
  private boolean showSearchBox = true;
  
  public PlacePickerFragment()
  {
    this(null);
  }
  
  public PlacePickerFragment(Bundle paramBundle)
  {
    super(GraphPlace.class, R.layout.com_facebook_placepickerfragment, paramBundle);
    setPlacePickerSettingsFromBundle(paramBundle);
  }
  
  private Request createRequest(Location paramLocation, int paramInt1, int paramInt2, String paramString, Set<String> paramSet, Session paramSession)
  {
    Request localRequest = Request.newPlacesSearchRequest(paramSession, paramLocation, paramInt1, paramInt2, paramString, null);
    HashSet localHashSet = new HashSet(paramSet);
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "id";
    arrayOfString[1] = "name";
    arrayOfString[2] = "location";
    arrayOfString[3] = "category";
    arrayOfString[4] = "were_here_count";
    localHashSet.addAll(Arrays.asList(arrayOfString));
    String str = this.adapter.getPictureFieldSpecifier();
    if (str != null) {
      localHashSet.add(str);
    }
    Bundle localBundle = localRequest.getParameters();
    localBundle.putString("fields", TextUtils.join(",", localHashSet));
    localRequest.setParameters(localBundle);
    return localRequest;
  }
  
  private Timer createSearchTextTimer()
  {
    Timer localTimer = new Timer();
    localTimer.schedule(new PlacePickerFragment.2(this), 0L, 2000L);
    return localTimer;
  }
  
  private void onSearchTextTimerTriggered()
  {
    if (this.hasSearchTextChangedSinceLastQuery) {
      new Handler(Looper.getMainLooper()).post(new PlacePickerFragment.3(this));
    }
    for (;;)
    {
      return;
      this.searchTextTimer.cancel();
      this.searchTextTimer = null;
    }
  }
  
  private void setPlacePickerSettingsFromBundle(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      setRadiusInMeters(paramBundle.getInt("com.facebook.widget.PlacePickerFragment.RadiusInMeters", this.radiusInMeters));
      setResultsLimit(paramBundle.getInt("com.facebook.widget.PlacePickerFragment.ResultsLimit", this.resultsLimit));
      if (paramBundle.containsKey("com.facebook.widget.PlacePickerFragment.SearchText")) {
        setSearchText(paramBundle.getString("com.facebook.widget.PlacePickerFragment.SearchText"));
      }
      if (paramBundle.containsKey("com.facebook.widget.PlacePickerFragment.Location")) {
        setLocation((Location)paramBundle.getParcelable("com.facebook.widget.PlacePickerFragment.Location"));
      }
      this.showSearchBox = paramBundle.getBoolean("com.facebook.widget.PlacePickerFragment.ShowSearchBox", this.showSearchBox);
    }
  }
  
  PickerFragment<GraphPlace>.PickerFragmentAdapter<GraphPlace> createAdapter()
  {
    PlacePickerFragment.1 local1 = new PlacePickerFragment.1(this, getActivity());
    local1.setShowCheckbox(false);
    local1.setShowPicture(getShowPictures());
    return local1;
  }
  
  PickerFragment<GraphPlace>.LoadingStrategy createLoadingStrategy()
  {
    return new PlacePickerFragment.AsNeededLoadingStrategy(this, null);
  }
  
  PickerFragment<GraphPlace>.SelectionStrategy createSelectionStrategy()
  {
    return new PickerFragment.SingleSelectionStrategy(this);
  }
  
  String getDefaultTitleText()
  {
    return getString(R.string.com_facebook_nearby);
  }
  
  public Location getLocation()
  {
    return this.location;
  }
  
  public int getRadiusInMeters()
  {
    return this.radiusInMeters;
  }
  
  Request getRequestForLoadData(Session paramSession)
  {
    return createRequest(this.location, this.radiusInMeters, this.resultsLimit, this.searchText, this.extraFields, paramSession);
  }
  
  public int getResultsLimit()
  {
    return this.resultsLimit;
  }
  
  public String getSearchText()
  {
    return this.searchText;
  }
  
  public GraphPlace getSelection()
  {
    List localList = getSelectedGraphObjects();
    if ((localList != null) && (!localList.isEmpty())) {}
    for (GraphPlace localGraphPlace = (GraphPlace)localList.iterator().next();; localGraphPlace = null) {
      return localGraphPlace;
    }
  }
  
  void logAppEvents(boolean paramBoolean)
  {
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(getActivity(), getSession());
    Bundle localBundle = new Bundle();
    String str;
    if (paramBoolean)
    {
      str = "Completed";
      localBundle.putString("fb_dialog_outcome", str);
      if (getSelection() == null) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("num_places_picked", i);
      localAppEventsLogger.logSdkEvent("fb_place_picker_usage", null, localBundle);
      return;
      str = "Unknown";
      break;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (this.searchBox != null) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(this.searchBox, 1);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.searchBox != null) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.searchBox.getWindowToken(), 0);
    }
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    TypedArray localTypedArray = paramActivity.obtainStyledAttributes(paramAttributeSet, R.styleable.com_facebook_place_picker_fragment);
    setRadiusInMeters(localTypedArray.getInt(R.styleable.com_facebook_place_picker_fragment_radius_in_meters, this.radiusInMeters));
    setResultsLimit(localTypedArray.getInt(R.styleable.com_facebook_place_picker_fragment_results_limit, this.resultsLimit));
    if (localTypedArray.hasValue(R.styleable.com_facebook_place_picker_fragment_results_limit)) {
      setSearchText(localTypedArray.getString(R.styleable.com_facebook_place_picker_fragment_search_text));
    }
    this.showSearchBox = localTypedArray.getBoolean(R.styleable.com_facebook_place_picker_fragment_show_search_box, this.showSearchBox);
    localTypedArray.recycle();
  }
  
  void onLoadingData()
  {
    this.hasSearchTextChangedSinceLastQuery = false;
  }
  
  public void onSearchBoxTextChanged(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) && (Utility.stringsEqualOrEmpty(this.searchText, paramString))) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString)) {
        paramString = null;
      }
      this.searchText = paramString;
      this.hasSearchTextChangedSinceLastQuery = true;
      if (this.searchTextTimer == null) {
        this.searchTextTimer = createSearchTextTimer();
      }
    }
  }
  
  void saveSettingsToBundle(Bundle paramBundle)
  {
    super.saveSettingsToBundle(paramBundle);
    paramBundle.putInt("com.facebook.widget.PlacePickerFragment.RadiusInMeters", this.radiusInMeters);
    paramBundle.putInt("com.facebook.widget.PlacePickerFragment.ResultsLimit", this.resultsLimit);
    paramBundle.putString("com.facebook.widget.PlacePickerFragment.SearchText", this.searchText);
    paramBundle.putParcelable("com.facebook.widget.PlacePickerFragment.Location", this.location);
    paramBundle.putBoolean("com.facebook.widget.PlacePickerFragment.ShowSearchBox", this.showSearchBox);
  }
  
  public void setLocation(Location paramLocation)
  {
    this.location = paramLocation;
  }
  
  public void setRadiusInMeters(int paramInt)
  {
    this.radiusInMeters = paramInt;
  }
  
  public void setResultsLimit(int paramInt)
  {
    this.resultsLimit = paramInt;
  }
  
  public void setSearchText(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    this.searchText = paramString;
    if (this.searchBox != null) {
      this.searchBox.setText(paramString);
    }
  }
  
  public void setSettingsFromBundle(Bundle paramBundle)
  {
    super.setSettingsFromBundle(paramBundle);
    setPlacePickerSettingsFromBundle(paramBundle);
  }
  
  void setupViews(ViewGroup paramViewGroup)
  {
    if (this.showSearchBox)
    {
      ListView localListView = (ListView)paramViewGroup.findViewById(R.id.com_facebook_picker_list_view);
      localListView.addHeaderView(getActivity().getLayoutInflater().inflate(R.layout.com_facebook_picker_search_box, localListView, false), null, false);
      this.searchBox = ((EditText)paramViewGroup.findViewById(R.id.com_facebook_picker_search_text));
      this.searchBox.addTextChangedListener(new PlacePickerFragment.SearchTextWatcher(this, null));
      if (!TextUtils.isEmpty(this.searchText)) {
        this.searchBox.setText(this.searchText);
      }
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.PlacePickerFragment
 * JD-Core Version:    0.7.0.1
 */