package com.facebook.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphObjectException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import com.facebook.model.GraphObjectList;
import com.facebook.model.OpenGraphAction;
import com.facebook.model.OpenGraphObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class FacebookDialog$OpenGraphDialogBuilderBase<CONCRETE extends OpenGraphDialogBuilderBase<?>>
  extends FacebookDialog.Builder<CONCRETE>
{
  private OpenGraphAction action;
  private String actionType;
  private boolean dataErrorsFatal;
  private String previewPropertyName;
  
  public FacebookDialog$OpenGraphDialogBuilderBase(Activity paramActivity, OpenGraphAction paramOpenGraphAction, String paramString)
  {
    super(paramActivity);
    Validate.notNull(paramOpenGraphAction, "action");
    Validate.notNullOrEmpty(paramOpenGraphAction.getType(), "action.getType()");
    Validate.notNullOrEmpty(paramString, "previewPropertyName");
    if (paramOpenGraphAction.getProperty(paramString) == null) {
      throw new IllegalArgumentException("A property named \"" + paramString + "\" was not found on the action.  The name of " + "the preview property must match the name of an action property.");
    }
    this.action = paramOpenGraphAction;
    this.actionType = paramOpenGraphAction.getType();
    this.previewPropertyName = paramString;
  }
  
  @Deprecated
  public FacebookDialog$OpenGraphDialogBuilderBase(Activity paramActivity, OpenGraphAction paramOpenGraphAction, String paramString1, String paramString2)
  {
    super(paramActivity);
    Validate.notNull(paramOpenGraphAction, "action");
    Validate.notNullOrEmpty(paramString1, "actionType");
    Validate.notNullOrEmpty(paramString2, "previewPropertyName");
    if (paramOpenGraphAction.getProperty(paramString2) == null) {
      throw new IllegalArgumentException("A property named \"" + paramString2 + "\" was not found on the action.  The name of " + "the preview property must match the name of an action property.");
    }
    String str = paramOpenGraphAction.getType();
    if ((!Utility.isNullOrEmpty(str)) && (!str.equals(paramString1))) {
      throw new IllegalArgumentException("'actionType' must match the type of 'action' if it is specified. Consider using OpenGraphDialogBuilderBase(Activity activity, OpenGraphAction action, String previewPropertyName) instead.");
    }
    this.action = paramOpenGraphAction;
    this.actionType = paramString1;
    this.previewPropertyName = paramString2;
  }
  
  private JSONObject flattenChildrenOfGraphObject(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.toString());
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!str.equalsIgnoreCase("image")) {
          localJSONObject.put(str, flattenObject(localJSONObject.get(str)));
        }
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new FacebookException(localJSONException);
    }
  }
  
  private Object flattenObject(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      if ((paramObject instanceof JSONObject))
      {
        JSONObject localJSONObject = (JSONObject)paramObject;
        if (!localJSONObject.optBoolean("fbsdk:create_object")) {
          if (localJSONObject.has("id")) {
            paramObject = localJSONObject.getString("id");
          } else if (localJSONObject.has("url")) {
            paramObject = localJSONObject.getString("url");
          }
        }
      }
      else if ((paramObject instanceof JSONArray))
      {
        JSONArray localJSONArray1 = (JSONArray)paramObject;
        JSONArray localJSONArray2 = new JSONArray();
        int i = localJSONArray1.length();
        for (int j = 0; j < i; j++) {
          localJSONArray2.put(flattenObject(localJSONArray1.get(j)));
        }
        paramObject = localJSONArray2;
      }
    }
  }
  
  private void updateActionAttachmentUrls(List<String> paramList, boolean paramBoolean)
  {
    List localList = this.action.getImage();
    if (localList == null) {}
    for (Object localObject = new ArrayList(paramList.size());; localObject = localList)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("url", str);
          if (paramBoolean) {
            localJSONObject.put("user_generated", true);
          }
          ((List)localObject).add(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          throw new FacebookException("Unable to attach images", localJSONException);
        }
      }
      this.action.setImage((List)localObject);
      return;
    }
  }
  
  protected Bundle getMethodArguments()
  {
    Bundle localBundle = new Bundle();
    putExtra(localBundle, "PREVIEW_PROPERTY_NAME", this.previewPropertyName);
    putExtra(localBundle, "ACTION_TYPE", this.actionType);
    localBundle.putBoolean("DATA_FAILURES_FATAL", this.dataErrorsFatal);
    putExtra(localBundle, "ACTION", flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
    return localBundle;
  }
  
  protected Bundle setBundleExtras(Bundle paramBundle)
  {
    putExtra(paramBundle, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", this.previewPropertyName);
    putExtra(paramBundle, "com.facebook.platform.extra.ACTION_TYPE", this.actionType);
    paramBundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", this.dataErrorsFatal);
    putExtra(paramBundle, "com.facebook.platform.extra.ACTION", flattenChildrenOfGraphObject(this.action.getInnerJSONObject()).toString());
    return paramBundle;
  }
  
  public CONCRETE setDataErrorsFatal(boolean paramBoolean)
  {
    this.dataErrorsFatal = paramBoolean;
    return this;
  }
  
  public CONCRETE setImageAttachmentFilesForAction(List<File> paramList)
  {
    return setImageAttachmentFilesForAction(paramList, false);
  }
  
  public CONCRETE setImageAttachmentFilesForAction(List<File> paramList, boolean paramBoolean)
  {
    Validate.containsNoNulls(paramList, "bitmapFiles");
    if (this.action == null) {
      throw new FacebookException("Can not set attachments prior to setting action.");
    }
    updateActionAttachmentUrls(addImageAttachmentFiles(paramList), paramBoolean);
    return this;
  }
  
  public CONCRETE setImageAttachmentFilesForObject(String paramString, List<File> paramList)
  {
    return setImageAttachmentFilesForObject(paramString, paramList, false);
  }
  
  public CONCRETE setImageAttachmentFilesForObject(String paramString, List<File> paramList, boolean paramBoolean)
  {
    Validate.notNull(paramString, "objectProperty");
    Validate.containsNoNulls(paramList, "bitmapFiles");
    if (this.action == null) {
      throw new FacebookException("Can not set attachments prior to setting action.");
    }
    updateObjectAttachmentUrls(paramString, addImageAttachmentFiles(paramList), paramBoolean);
    return this;
  }
  
  public CONCRETE setImageAttachmentsForAction(List<Bitmap> paramList)
  {
    return setImageAttachmentsForAction(paramList, false);
  }
  
  public CONCRETE setImageAttachmentsForAction(List<Bitmap> paramList, boolean paramBoolean)
  {
    Validate.containsNoNulls(paramList, "bitmaps");
    if (this.action == null) {
      throw new FacebookException("Can not set attachments prior to setting action.");
    }
    updateActionAttachmentUrls(addImageAttachments(paramList), paramBoolean);
    return this;
  }
  
  public CONCRETE setImageAttachmentsForObject(String paramString, List<Bitmap> paramList)
  {
    return setImageAttachmentsForObject(paramString, paramList, false);
  }
  
  public CONCRETE setImageAttachmentsForObject(String paramString, List<Bitmap> paramList, boolean paramBoolean)
  {
    Validate.notNull(paramString, "objectProperty");
    Validate.containsNoNulls(paramList, "bitmaps");
    if (this.action == null) {
      throw new FacebookException("Can not set attachments prior to setting action.");
    }
    updateObjectAttachmentUrls(paramString, addImageAttachments(paramList), paramBoolean);
    return this;
  }
  
  void updateObjectAttachmentUrls(String paramString, List<String> paramList, boolean paramBoolean)
  {
    OpenGraphObject localOpenGraphObject;
    try
    {
      localOpenGraphObject = (OpenGraphObject)this.action.getPropertyAs(paramString, OpenGraphObject.class);
      if (localOpenGraphObject == null) {
        throw new IllegalArgumentException("Action does not contain a property '" + paramString + "'");
      }
    }
    catch (FacebookGraphObjectException localFacebookGraphObjectException)
    {
      throw new IllegalArgumentException("Property '" + paramString + "' is not a graph object");
    }
    if (!localOpenGraphObject.getCreateObject()) {
      throw new IllegalArgumentException("The Open Graph object in '" + paramString + "' is not marked for creation");
    }
    GraphObjectList localGraphObjectList1 = localOpenGraphObject.getImage();
    if (localGraphObjectList1 == null) {}
    for (GraphObjectList localGraphObjectList2 = GraphObject.Factory.createList(GraphObject.class);; localGraphObjectList2 = localGraphObjectList1)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        GraphObject localGraphObject = GraphObject.Factory.create();
        localGraphObject.setProperty("url", str);
        if (paramBoolean) {
          localGraphObject.setProperty("user_generated", Boolean.valueOf(true));
        }
        localGraphObjectList2.add(localGraphObject);
      }
      localOpenGraphObject.setImage(localGraphObjectList2);
      return;
    }
  }
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.facebook.widget.FacebookDialog.OpenGraphDialogBuilderBase
 * JD-Core Version:    0.7.0.1
 */