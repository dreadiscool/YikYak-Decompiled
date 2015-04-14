package com.parse;

 enum ManifestInfo$ManifestCheckResult
{
  static
  {
    ManifestCheckResult[] arrayOfManifestCheckResult = new ManifestCheckResult[3];
    arrayOfManifestCheckResult[0] = HAS_ALL_DECLARATIONS;
    arrayOfManifestCheckResult[1] = MISSING_OPTIONAL_DECLARATIONS;
    arrayOfManifestCheckResult[2] = MISSING_REQUIRED_DECLARATIONS;
    $VALUES = arrayOfManifestCheckResult;
  }
  
  private ManifestInfo$ManifestCheckResult() {}
}


/* Location:           C:\Users\dreadiscool\Desktop\tools\classes-dex2jar.jar
 * Qualified Name:     com.parse.ManifestInfo.ManifestCheckResult
 * JD-Core Version:    0.7.0.1
 */