package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.CollapsibleActionView;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements CollapsibleActionView
{
  private static final boolean DBG = false;
  static final SearchView.AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER;
  private static final String IME_OPTION_NO_MICROPHONE = "nm";
  private static final boolean IS_AT_LEAST_FROYO = false;
  private static final String LOG_TAG = "SearchView";
  private Bundle mAppSearchData;
  private boolean mClearingFocus;
  private final ImageView mCloseButton;
  private int mCollapsedImeOptions;
  private final View mDropDownAnchor;
  private boolean mExpandedInActionView;
  private boolean mIconified;
  private boolean mIconifiedByDefault;
  private int mMaxWidth;
  private CharSequence mOldQueryText;
  private final View.OnClickListener mOnClickListener = new SearchView.7(this);
  private SearchView.OnCloseListener mOnCloseListener;
  private final TextView.OnEditorActionListener mOnEditorActionListener = new SearchView.9(this);
  private final AdapterView.OnItemClickListener mOnItemClickListener = new SearchView.10(this);
  private final AdapterView.OnItemSelectedListener mOnItemSelectedListener = new SearchView.11(this);
  private SearchView.OnQueryTextListener mOnQueryChangeListener;
  private View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
  private View.OnClickListener mOnSearchClickListener;
  private SearchView.OnSuggestionListener mOnSuggestionListener;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache = new WeakHashMap();
  private CharSequence mQueryHint;
  private boolean mQueryRefinement;
  private final SearchView.SearchAutoComplete mQueryTextView;
  private Runnable mReleaseCursorRunnable = new SearchView.3(this);
  private final ImageView mSearchButton;
  private final View mSearchEditFrame;
  private final ImageView mSearchHintIcon;
  private final int mSearchIconResId;
  private final View mSearchPlate;
  private SearchableInfo mSearchable;
  private Runnable mShowImeRunnable = new SearchView.1(this);
  private final View mSubmitArea;
  private final ImageView mSubmitButton;
  private boolean mSubmitButtonEnabled;
  private final int mSuggestionCommitIconResId;
  private final int mSuggestionRowLayout;
  private CursorAdapter mSuggestionsAdapter;
  View.OnKeyListener mTextKeyListener = new SearchView.8(this);
  private TextWatcher mTextWatcher = new SearchView.12(this);
  private final TintManager mTintManager;
  private final Runnable mUpdateDrawableStateRunnable = new SearchView.2(this);
  private CharSequence mUserQuery;
  private final Intent mVoiceAppSearchIntent;
  private final ImageView mVoiceButton;
  private boolean mVoiceButtonEnabled;
  private final Intent mVoiceWebSearchIntent;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 8) {}
    for (boolean bool = true;; bool = false)
    {
      IS_AT_LEAST_FROYO = bool;
      HIDDEN_METHOD_INVOKER = new SearchView.AutoCompleteTextViewReflector();
      return;
    }
  }
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.SearchView, paramInt, 0);
    this.mTintManager = localTintTypedArray.getTintManager();
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(localTintTypedArray.getResourceId(R.styleable.SearchView_layout, 0), this, true);
    this.mQueryTextView = ((SearchView.SearchAutoComplete)findViewById(R.id.search_src_text));
    this.mQueryTextView.setSearchView(this);
    this.mSearchEditFrame = findViewById(R.id.search_edit_frame);
    this.mSearchPlate = findViewById(R.id.search_plate);
    this.mSubmitArea = findViewById(R.id.submit_area);
    this.mSearchButton = ((ImageView)findViewById(R.id.search_button));
    this.mSubmitButton = ((ImageView)findViewById(R.id.search_go_btn));
    this.mCloseButton = ((ImageView)findViewById(R.id.search_close_btn));
    this.mVoiceButton = ((ImageView)findViewById(R.id.search_voice_btn));
    this.mSearchHintIcon = ((ImageView)findViewById(R.id.search_mag_icon));
    this.mSearchPlate.setBackgroundDrawable(localTintTypedArray.getDrawable(R.styleable.SearchView_queryBackground));
    this.mSubmitArea.setBackgroundDrawable(localTintTypedArray.getDrawable(R.styleable.SearchView_submitBackground));
    this.mSearchIconResId = localTintTypedArray.getResourceId(R.styleable.SearchView_searchIcon, 0);
    this.mSearchButton.setImageResource(this.mSearchIconResId);
    this.mSubmitButton.setImageDrawable(localTintTypedArray.getDrawable(R.styleable.SearchView_goIcon));
    this.mCloseButton.setImageDrawable(localTintTypedArray.getDrawable(R.styleable.SearchView_closeIcon));
    this.mVoiceButton.setImageDrawable(localTintTypedArray.getDrawable(R.styleable.SearchView_voiceIcon));
    this.mSearchHintIcon.setImageDrawable(localTintTypedArray.getDrawable(R.styleable.SearchView_searchIcon));
    this.mSuggestionRowLayout = localTintTypedArray.getResourceId(R.styleable.SearchView_suggestionRowLayout, 0);
    this.mSuggestionCommitIconResId = localTintTypedArray.getResourceId(R.styleable.SearchView_commitIcon, 0);
    this.mSearchButton.setOnClickListener(this.mOnClickListener);
    this.mCloseButton.setOnClickListener(this.mOnClickListener);
    this.mSubmitButton.setOnClickListener(this.mOnClickListener);
    this.mVoiceButton.setOnClickListener(this.mOnClickListener);
    this.mQueryTextView.setOnClickListener(this.mOnClickListener);
    this.mQueryTextView.addTextChangedListener(this.mTextWatcher);
    this.mQueryTextView.setOnEditorActionListener(this.mOnEditorActionListener);
    this.mQueryTextView.setOnItemClickListener(this.mOnItemClickListener);
    this.mQueryTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
    this.mQueryTextView.setOnKeyListener(this.mTextKeyListener);
    this.mQueryTextView.setOnFocusChangeListener(new SearchView.4(this));
    setIconifiedByDefault(localTintTypedArray.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
    int i = localTintTypedArray.getDimensionPixelSize(R.styleable.SearchView_android_maxWidth, -1);
    if (i != -1) {
      setMaxWidth(i);
    }
    CharSequence localCharSequence = localTintTypedArray.getText(R.styleable.SearchView_queryHint);
    if (!TextUtils.isEmpty(localCharSequence)) {
      setQueryHint(localCharSequence);
    }
    int j = localTintTypedArray.getInt(R.styleable.SearchView_android_imeOptions, -1);
    if (j != -1) {
      setImeOptions(j);
    }
    int k = localTintTypedArray.getInt(R.styleable.SearchView_android_inputType, -1);
    if (k != -1) {
      setInputType(k);
    }
    setFocusable(localTintTypedArray.getBoolean(R.styleable.SearchView_android_focusable, true));
    localTintTypedArray.recycle();
    this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
    this.mVoiceWebSearchIntent.addFlags(268435456);
    this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.mVoiceAppSearchIntent.addFlags(268435456);
    this.mDropDownAnchor = findViewById(this.mQueryTextView.getDropDownAnchor());
    if (this.mDropDownAnchor != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label802;
      }
      addOnLayoutChangeListenerToDropDownAnchorSDK11();
    }
    for (;;)
    {
      updateViewsVisibility(this.mIconifiedByDefault);
      updateQueryHint();
      return;
      label802:
      addOnLayoutChangeListenerToDropDownAnchorBase();
    }
  }
  
  private void addOnLayoutChangeListenerToDropDownAnchorBase()
  {
    this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new SearchView.6(this));
  }
  
  @TargetApi(11)
  private void addOnLayoutChangeListenerToDropDownAnchorSDK11()
  {
    this.mDropDownAnchor.addOnLayoutChangeListener(new SearchView.5(this));
  }
  
  private void adjustDropDownSizeAndPosition()
  {
    int i;
    Rect localRect;
    int j;
    if (this.mDropDownAnchor.getWidth() > 1)
    {
      Resources localResources = getContext().getResources();
      i = this.mSearchPlate.getPaddingLeft();
      localRect = new Rect();
      boolean bool = ViewUtils.isLayoutRtl(this);
      if (!this.mIconifiedByDefault) {
        break label132;
      }
      j = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
      this.mQueryTextView.getDropDownBackground().getPadding(localRect);
      if (!bool) {
        break label138;
      }
    }
    label132:
    label138:
    for (int k = -localRect.left;; k = i - (j + localRect.left))
    {
      this.mQueryTextView.setDropDownHorizontalOffset(k);
      int m = j + (this.mDropDownAnchor.getWidth() + localRect.left + localRect.right) - i;
      this.mQueryTextView.setDropDownWidth(m);
      return;
      j = 0;
      break;
    }
  }
  
  private Intent createIntent(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    Intent localIntent = new Intent(paramString1);
    localIntent.addFlags(268435456);
    if (paramUri != null) {
      localIntent.setData(paramUri);
    }
    localIntent.putExtra("user_query", this.mUserQuery);
    if (paramString3 != null) {
      localIntent.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      localIntent.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.mAppSearchData != null) {
      localIntent.putExtra("app_data", this.mAppSearchData);
    }
    if (paramInt != 0)
    {
      localIntent.putExtra("action_key", paramInt);
      localIntent.putExtra("action_msg", paramString4);
    }
    if (IS_AT_LEAST_FROYO) {
      localIntent.setComponent(this.mSearchable.getSearchActivity());
    }
    return localIntent;
  }
  
  private Intent createIntentFromSuggestion(Cursor paramCursor, int paramInt, String paramString)
  {
    Intent localIntent;
    try
    {
      str1 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_action");
      if ((str1 == null) && (Build.VERSION.SDK_INT >= 8))
      {
        str1 = this.mSearchable.getSuggestIntentAction();
        break label220;
        str2 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data");
        if ((IS_AT_LEAST_FROYO) && (str2 == null)) {
          str2 = this.mSearchable.getSuggestIntentData();
        }
        if (str2 == null) {
          break label233;
        }
        String str4 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data_id");
        if (str4 == null) {
          break label233;
        }
        str2 = str2 + "/" + Uri.encode(str4);
        break label233;
        for (;;)
        {
          String str3 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_query");
          localIntent = createIntent(str1, (Uri)localObject, SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_extra_data"), str3, paramInt, paramString);
          break;
          Uri localUri = Uri.parse(str2);
          localObject = localUri;
        }
      }
    }
    catch (RuntimeException localRuntimeException1)
    {
      for (;;)
      {
        String str1;
        String str2;
        Object localObject;
        try
        {
          int j = paramCursor.getPosition();
          i = j;
        }
        catch (RuntimeException localRuntimeException2)
        {
          int i = -1;
          continue;
        }
        new StringBuilder().append("Search suggestions cursor at row ").append(i).append(" returned exception.").toString();
        localIntent = null;
        break;
        label220:
        if (str1 == null)
        {
          str1 = "android.intent.action.SEARCH";
          continue;
          label233:
          if (str2 == null) {
            localObject = null;
          }
        }
      }
    }
    return localIntent;
  }
  
  @TargetApi(8)
  private Intent createVoiceAppSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    String str1 = null;
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Intent localIntent1 = new Intent("android.intent.action.SEARCH");
    localIntent1.setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, localIntent1, 1073741824);
    Bundle localBundle = new Bundle();
    if (this.mAppSearchData != null) {
      localBundle.putParcelable("app_data", this.mAppSearchData);
    }
    Intent localIntent2 = new Intent(paramIntent);
    String str2 = "free_form";
    String str4;
    String str3;
    label154:
    String str5;
    int i;
    if (Build.VERSION.SDK_INT >= 8)
    {
      Resources localResources = getResources();
      if (paramSearchableInfo.getVoiceLanguageModeId() != 0) {
        str2 = localResources.getString(paramSearchableInfo.getVoiceLanguageModeId());
      }
      if (paramSearchableInfo.getVoicePromptTextId() != 0)
      {
        str4 = localResources.getString(paramSearchableInfo.getVoicePromptTextId());
        if (paramSearchableInfo.getVoiceLanguageId() != 0)
        {
          str3 = localResources.getString(paramSearchableInfo.getVoiceLanguageId());
          if (paramSearchableInfo.getVoiceMaxResults() != 0)
          {
            int j = paramSearchableInfo.getVoiceMaxResults();
            str5 = str2;
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      localIntent2.putExtra("android.speech.extra.LANGUAGE_MODEL", str5);
      localIntent2.putExtra("android.speech.extra.PROMPT", str4);
      localIntent2.putExtra("android.speech.extra.LANGUAGE", str3);
      localIntent2.putExtra("android.speech.extra.MAX_RESULTS", i);
      if (localComponentName == null) {}
      for (;;)
      {
        localIntent2.putExtra("calling_package", str1);
        localIntent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
        localIntent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
        return localIntent2;
        str1 = localComponentName.flattenToShortString();
      }
      str5 = str2;
      i = 1;
      continue;
      str3 = null;
      break label154;
      str4 = null;
      break;
      str3 = null;
      str4 = null;
      str5 = str2;
      i = 1;
    }
  }
  
  @TargetApi(8)
  private Intent createVoiceWebSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    if (localComponentName == null) {}
    for (String str = null;; str = localComponentName.flattenToShortString())
    {
      localIntent.putExtra("calling_package", str);
      return localIntent;
    }
  }
  
  private void dismissSuggestions()
  {
    this.mQueryTextView.dismissDropDown();
  }
  
  private void forceSuggestionQuery()
  {
    HIDDEN_METHOD_INVOKER.doBeforeTextChanged(this.mQueryTextView);
    HIDDEN_METHOD_INVOKER.doAfterTextChanged(this.mQueryTextView);
  }
  
  private CharSequence getDecoratedHint(CharSequence paramCharSequence)
  {
    if (!this.mIconifiedByDefault) {}
    for (;;)
    {
      return paramCharSequence;
      Drawable localDrawable = this.mTintManager.getDrawable(this.mSearchIconResId);
      int i = (int)(1.25D * this.mQueryTextView.getTextSize());
      localDrawable.setBounds(0, 0, i, i);
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.setSpan(new ImageSpan(localDrawable), 1, 2, 33);
      paramCharSequence = localSpannableStringBuilder;
    }
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  @TargetApi(8)
  private boolean hasVoiceSearch()
  {
    boolean bool = false;
    Intent localIntent;
    if ((this.mSearchable != null) && (this.mSearchable.getVoiceSearchEnabled()))
    {
      localIntent = null;
      if (!this.mSearchable.getVoiceSearchLaunchWebSearch()) {
        break label61;
      }
      localIntent = this.mVoiceWebSearchIntent;
    }
    for (;;)
    {
      if ((localIntent != null) && (getContext().getPackageManager().resolveActivity(localIntent, 65536) != null)) {
        bool = true;
      }
      return bool;
      label61:
      if (this.mSearchable.getVoiceSearchLaunchRecognizer()) {
        localIntent = this.mVoiceAppSearchIntent;
      }
    }
  }
  
  static boolean isLandscapeMode(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean isSubmitAreaEnabled()
  {
    if (((this.mSubmitButtonEnabled) || (this.mVoiceButtonEnabled)) && (!isIconified())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void launchIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      try
      {
        getContext().startActivity(paramIntent);
      }
      catch (RuntimeException localRuntimeException)
      {
        new StringBuilder().append("Failed launch activity: ").append(paramIntent).toString();
      }
    }
  }
  
  private void launchQuerySearch(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = createIntent("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(localIntent);
  }
  
  private boolean launchSuggestion(int paramInt1, int paramInt2, String paramString)
  {
    Cursor localCursor = this.mSuggestionsAdapter.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt1))) {
      launchIntent(createIntentFromSuggestion(localCursor, paramInt2, paramString));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void onCloseClicked()
  {
    if (TextUtils.isEmpty(this.mQueryTextView.getText())) {
      if ((this.mIconifiedByDefault) && ((this.mOnCloseListener == null) || (!this.mOnCloseListener.onClose())))
      {
        clearFocus();
        updateViewsVisibility(true);
      }
    }
    for (;;)
    {
      return;
      this.mQueryTextView.setText("");
      this.mQueryTextView.requestFocus();
      setImeVisibility(true);
    }
  }
  
  private boolean onItemClicked(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = false;
    if ((this.mOnSuggestionListener == null) || (!this.mOnSuggestionListener.onSuggestionClick(paramInt1)))
    {
      launchSuggestion(paramInt1, 0, null);
      setImeVisibility(false);
      dismissSuggestions();
      bool = true;
    }
    return bool;
  }
  
  private boolean onItemSelected(int paramInt)
  {
    if ((this.mOnSuggestionListener == null) || (!this.mOnSuggestionListener.onSuggestionSelect(paramInt))) {
      rewriteQueryFromSuggestion(paramInt);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void onSearchClicked()
  {
    updateViewsVisibility(false);
    this.mQueryTextView.requestFocus();
    setImeVisibility(true);
    if (this.mOnSearchClickListener != null) {
      this.mOnSearchClickListener.onClick(this);
    }
  }
  
  private void onSubmitQuery()
  {
    Editable localEditable = this.mQueryTextView.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0) && ((this.mOnQueryChangeListener == null) || (!this.mOnQueryChangeListener.onQueryTextSubmit(localEditable.toString()))))
    {
      if (this.mSearchable != null) {
        launchQuerySearch(0, null, localEditable.toString());
      }
      setImeVisibility(false);
      dismissSuggestions();
    }
  }
  
  private boolean onSuggestionsKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (this.mSearchable == null) {}
    for (;;)
    {
      return bool;
      if ((this.mSuggestionsAdapter != null) && (paramKeyEvent.getAction() == 0) && (KeyEventCompat.hasNoModifiers(paramKeyEvent))) {
        if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61))
        {
          bool = onItemClicked(this.mQueryTextView.getListSelection(), 0, null);
        }
        else
        {
          if ((paramInt == 21) || (paramInt == 22))
          {
            if (paramInt == 21) {}
            for (int i = 0;; i = this.mQueryTextView.length())
            {
              this.mQueryTextView.setSelection(i);
              this.mQueryTextView.setListSelection(0);
              this.mQueryTextView.clearListSelection();
              HIDDEN_METHOD_INVOKER.ensureImeVisible(this.mQueryTextView, true);
              bool = true;
              break;
            }
          }
          if ((paramInt != 19) || (this.mQueryTextView.getListSelection() != 0)) {}
        }
      }
    }
  }
  
  private void onTextChanged(CharSequence paramCharSequence)
  {
    boolean bool1 = true;
    Editable localEditable = this.mQueryTextView.getText();
    this.mUserQuery = localEditable;
    boolean bool2;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool2 = bool1;
      updateSubmitButton(bool2);
      if (bool2) {
        break label100;
      }
    }
    for (;;)
    {
      updateVoiceButton(bool1);
      updateCloseButton();
      updateSubmitArea();
      if ((this.mOnQueryChangeListener != null) && (!TextUtils.equals(paramCharSequence, this.mOldQueryText))) {
        this.mOnQueryChangeListener.onQueryTextChange(paramCharSequence.toString());
      }
      this.mOldQueryText = paramCharSequence.toString();
      return;
      bool2 = false;
      break;
      label100:
      bool1 = false;
    }
  }
  
  @TargetApi(8)
  private void onVoiceClicked()
  {
    if (this.mSearchable == null) {}
    for (;;)
    {
      return;
      SearchableInfo localSearchableInfo = this.mSearchable;
      try
      {
        if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
        {
          Intent localIntent2 = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, localSearchableInfo);
          getContext().startActivity(localIntent2);
        }
        else if (localSearchableInfo.getVoiceSearchLaunchRecognizer())
        {
          Intent localIntent1 = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, localSearchableInfo);
          getContext().startActivity(localIntent1);
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException) {}
    }
  }
  
  private void postUpdateFocusedState()
  {
    post(this.mUpdateDrawableStateRunnable);
  }
  
  private void rewriteQueryFromSuggestion(int paramInt)
  {
    Editable localEditable = this.mQueryTextView.getText();
    Cursor localCursor = this.mSuggestionsAdapter.getCursor();
    if (localCursor == null) {}
    for (;;)
    {
      return;
      if (localCursor.moveToPosition(paramInt))
      {
        CharSequence localCharSequence = this.mSuggestionsAdapter.convertToString(localCursor);
        if (localCharSequence != null) {
          setQuery(localCharSequence);
        } else {
          setQuery(localEditable);
        }
      }
      else
      {
        setQuery(localEditable);
      }
    }
  }
  
  private void setImeVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      post(this.mShowImeRunnable);
    }
    for (;;)
    {
      return;
      removeCallbacks(this.mShowImeRunnable);
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      }
    }
  }
  
  private void setQuery(CharSequence paramCharSequence)
  {
    this.mQueryTextView.setText(paramCharSequence);
    SearchView.SearchAutoComplete localSearchAutoComplete = this.mQueryTextView;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  private void updateCloseButton()
  {
    int i = 1;
    int j = 0;
    int k;
    label37:
    label47:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.mQueryTextView.getText()))
    {
      k = i;
      if ((k == 0) && ((!this.mIconifiedByDefault) || (this.mExpandedInActionView))) {
        break label85;
      }
      ImageView localImageView = this.mCloseButton;
      if (i == 0) {
        break label90;
      }
      localImageView.setVisibility(j);
      localDrawable = this.mCloseButton.getDrawable();
      if (k == 0) {
        break label96;
      }
    }
    label85:
    label90:
    label96:
    for (int[] arrayOfInt = ENABLED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      localDrawable.setState(arrayOfInt);
      return;
      k = 0;
      break;
      i = 0;
      break label37;
      j = 8;
      break label47;
    }
  }
  
  private void updateFocusedState()
  {
    boolean bool = this.mQueryTextView.hasFocus();
    Drawable localDrawable1 = this.mSearchPlate.getBackground();
    int[] arrayOfInt1;
    Drawable localDrawable2;
    if (bool)
    {
      arrayOfInt1 = ENABLED_FOCUSED_STATE_SET;
      localDrawable1.setState(arrayOfInt1);
      localDrawable2 = this.mSubmitArea.getBackground();
      if (!bool) {
        break label68;
      }
    }
    label68:
    for (int[] arrayOfInt2 = ENABLED_FOCUSED_STATE_SET;; arrayOfInt2 = EMPTY_STATE_SET)
    {
      localDrawable2.setState(arrayOfInt2);
      invalidate();
      return;
      arrayOfInt1 = EMPTY_STATE_SET;
      break;
    }
  }
  
  private void updateQueryHint()
  {
    if (this.mQueryHint != null) {
      this.mQueryTextView.setHint(getDecoratedHint(this.mQueryHint));
    }
    for (;;)
    {
      return;
      if ((IS_AT_LEAST_FROYO) && (this.mSearchable != null))
      {
        String str = null;
        int i = this.mSearchable.getHintId();
        if (i != 0) {
          str = getContext().getString(i);
        }
        if (str != null) {
          this.mQueryTextView.setHint(getDecoratedHint(str));
        }
      }
      else
      {
        this.mQueryTextView.setHint(getDecoratedHint(""));
      }
    }
  }
  
  @TargetApi(8)
  private void updateSearchAutoComplete()
  {
    int i = 1;
    this.mQueryTextView.setThreshold(this.mSearchable.getSuggestThreshold());
    this.mQueryTextView.setImeOptions(this.mSearchable.getImeOptions());
    int j = this.mSearchable.getInputType();
    if ((j & 0xF) == i)
    {
      j &= 0xFFFEFFFF;
      if (this.mSearchable.getSuggestAuthority() != null) {
        j = 0x80000 | j | 0x10000;
      }
    }
    this.mQueryTextView.setInputType(j);
    if (this.mSuggestionsAdapter != null) {
      this.mSuggestionsAdapter.changeCursor(null);
    }
    if (this.mSearchable.getSuggestAuthority() != null)
    {
      this.mSuggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
      this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
      SuggestionsAdapter localSuggestionsAdapter = (SuggestionsAdapter)this.mSuggestionsAdapter;
      if (this.mQueryRefinement) {
        i = 2;
      }
      localSuggestionsAdapter.setQueryRefinement(i);
    }
  }
  
  private void updateSubmitArea()
  {
    int i = 8;
    if ((isSubmitAreaEnabled()) && ((this.mSubmitButton.getVisibility() == 0) || (this.mVoiceButton.getVisibility() == 0))) {
      i = 0;
    }
    this.mSubmitArea.setVisibility(i);
  }
  
  private void updateSubmitButton(boolean paramBoolean)
  {
    int i = 8;
    if ((this.mSubmitButtonEnabled) && (isSubmitAreaEnabled()) && (hasFocus()) && ((paramBoolean) || (!this.mVoiceButtonEnabled))) {
      i = 0;
    }
    this.mSubmitButton.setVisibility(i);
  }
  
  private void updateViewsVisibility(boolean paramBoolean)
  {
    boolean bool1 = true;
    int i = 8;
    this.mIconified = paramBoolean;
    int j;
    boolean bool2;
    label33:
    int k;
    if (paramBoolean)
    {
      j = 0;
      if (TextUtils.isEmpty(this.mQueryTextView.getText())) {
        break label112;
      }
      bool2 = bool1;
      this.mSearchButton.setVisibility(j);
      updateSubmitButton(bool2);
      View localView = this.mSearchEditFrame;
      if (!paramBoolean) {
        break label118;
      }
      k = i;
      label61:
      localView.setVisibility(k);
      ImageView localImageView = this.mSearchHintIcon;
      if (!this.mIconifiedByDefault) {
        break label124;
      }
      label81:
      localImageView.setVisibility(i);
      updateCloseButton();
      if (bool2) {
        break label129;
      }
    }
    for (;;)
    {
      updateVoiceButton(bool1);
      updateSubmitArea();
      return;
      j = i;
      break;
      label112:
      bool2 = false;
      break label33;
      label118:
      k = 0;
      break label61;
      label124:
      i = 0;
      break label81;
      label129:
      bool1 = false;
    }
  }
  
  private void updateVoiceButton(boolean paramBoolean)
  {
    int i;
    if ((this.mVoiceButtonEnabled) && (!isIconified()) && (paramBoolean))
    {
      i = 0;
      this.mSubmitButton.setVisibility(8);
    }
    for (;;)
    {
      this.mVoiceButton.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  public void clearFocus()
  {
    this.mClearingFocus = true;
    setImeVisibility(false);
    super.clearFocus();
    this.mQueryTextView.clearFocus();
    this.mClearingFocus = false;
  }
  
  public int getImeOptions()
  {
    return this.mQueryTextView.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.mQueryTextView.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.mQueryTextView.getText();
  }
  
  public CharSequence getQueryHint()
  {
    Object localObject = null;
    if (this.mQueryHint != null) {
      localObject = this.mQueryHint;
    }
    for (;;)
    {
      return localObject;
      if ((IS_AT_LEAST_FROYO) && (this.mSearchable != null))
      {
        int i = this.mSearchable.getHintId();
        if (i != 0) {
          localObject = getContext().getString(i);
        }
      }
    }
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.mSuggestionCommitIconResId;
  }
  
  int getSuggestionRowLayout()
  {
    return this.mSuggestionRowLayout;
  }
  
  public CursorAdapter getSuggestionsAdapter()
  {
    return this.mSuggestionsAdapter;
  }
  
  public boolean isIconfiedByDefault()
  {
    return this.mIconifiedByDefault;
  }
  
  public boolean isIconified()
  {
    return this.mIconified;
  }
  
  public boolean isQueryRefinementEnabled()
  {
    return this.mQueryRefinement;
  }
  
  public boolean isSubmitButtonEnabled()
  {
    return this.mSubmitButtonEnabled;
  }
  
  public void onActionViewCollapsed()
  {
    setQuery("", false);
    clearFocus();
    updateViewsVisibility(true);
    this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions);
    this.mExpandedInActionView = false;
  }
  
  public void onActionViewExpanded()
  {
    if (this.mExpandedInActionView) {}
    for (;;)
    {
      return;
      this.mExpandedInActionView = true;
      this.mCollapsedImeOptions = this.mQueryTextView.getImeOptions();
      this.mQueryTextView.setImeOptions(0x2000000 | this.mCollapsedImeOptions);
      this.mQueryTextView.setText("");
      setIconified(false);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mUpdateDrawableStateRunnable);
    post(this.mReleaseCursorRunnable);
    super.onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isIconified())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    switch (i)
    {
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), paramInt2);
      break;
      if (this.mMaxWidth > 0)
      {
        j = Math.min(this.mMaxWidth, j);
      }
      else
      {
        j = Math.min(getPreferredWidth(), j);
        continue;
        if (this.mMaxWidth > 0)
        {
          j = Math.min(this.mMaxWidth, j);
          continue;
          if (this.mMaxWidth > 0) {
            j = this.mMaxWidth;
          } else {
            j = getPreferredWidth();
          }
        }
      }
    }
  }
  
  void onQueryRefine(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }
  
  void onTextFocusChanged()
  {
    updateViewsVisibility(isIconified());
    postUpdateFocusedState();
    if (this.mQueryTextView.hasFocus()) {
      forceSuggestionQuery();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    postUpdateFocusedState();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    boolean bool1 = false;
    if (this.mClearingFocus) {}
    for (;;)
    {
      return bool1;
      if (isFocusable()) {
        if (!isIconified())
        {
          boolean bool2 = this.mQueryTextView.requestFocus(paramInt, paramRect);
          if (bool2) {
            updateViewsVisibility(false);
          }
          bool1 = bool2;
        }
        else
        {
          bool1 = super.requestFocus(paramInt, paramRect);
        }
      }
    }
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.mAppSearchData = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean) {
      onCloseClicked();
    }
    for (;;)
    {
      return;
      onSearchClicked();
    }
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.mIconifiedByDefault == paramBoolean) {}
    for (;;)
    {
      return;
      this.mIconifiedByDefault = paramBoolean;
      updateViewsVisibility(paramBoolean);
      updateQueryHint();
    }
  }
  
  public void setImeOptions(int paramInt)
  {
    this.mQueryTextView.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.mQueryTextView.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(SearchView.OnCloseListener paramOnCloseListener)
  {
    this.mOnCloseListener = paramOnCloseListener;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mOnQueryTextFocusChangeListener = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(SearchView.OnQueryTextListener paramOnQueryTextListener)
  {
    this.mOnQueryChangeListener = paramOnQueryTextListener;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnSearchClickListener = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(SearchView.OnSuggestionListener paramOnSuggestionListener)
  {
    this.mOnSuggestionListener = paramOnSuggestionListener;
  }
  
  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.mQueryTextView.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      this.mQueryTextView.setSelection(this.mQueryTextView.length());
      this.mUserQuery = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence))) {
      onSubmitQuery();
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.mQueryHint = paramCharSequence;
    updateQueryHint();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.mQueryRefinement = paramBoolean;
    SuggestionsAdapter localSuggestionsAdapter;
    if ((this.mSuggestionsAdapter instanceof SuggestionsAdapter))
    {
      localSuggestionsAdapter = (SuggestionsAdapter)this.mSuggestionsAdapter;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localSuggestionsAdapter.setQueryRefinement(i);
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.mSearchable = paramSearchableInfo;
    if (this.mSearchable != null)
    {
      if (IS_AT_LEAST_FROYO) {
        updateSearchAutoComplete();
      }
      updateQueryHint();
    }
    if ((IS_AT_LEAST_FROYO) && (hasVoiceSearch())) {}
    for (boolean bool = true;; bool = false)
    {
      this.mVoiceButtonEnabled = bool;
      if (this.mVoiceButtonEnabled) {
        this.mQueryTextView.setPrivateImeOptions("nm");
      }
      updateViewsVisibility(isIconified());
      return;
    }
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.mSubmitButtonEnabled = paramBoolean;
    updateViewsVisibility(isIconified());
  }
  
  public void setSuggestionsAdapter(CursorAdapter paramCursorAdapter)
  {
    this.mSuggestionsAdapter = paramCursorAdapter;
    this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */