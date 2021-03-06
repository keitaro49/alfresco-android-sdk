/*******************************************************************************
 * Copyright (C) 2005-2012 Alfresco Software Limited.
 * 
 * This file is part of the Alfresco Mobile SDK.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 ******************************************************************************/
package org.alfresco.mobile.android.api.constants;

/**
 * Provides all constant for creating an OAuth context.
 * 
 * @author Jean Marie Pascal
 */
public interface OAuthConstant
{
    /** Entry Point to get initiate Authentication against Cloud API. */
    String AUTHORIZE_URL = "https://api.alfresco.com/auth/oauth/versions/2/authorize";

    /** Entry Point to get OAuth Authentication Token against Cloud API. */
    String TOKEN_URL = "https://api.alfresco.com/auth/oauth/versions/2/token";

    /** Cloud API hostname. */
    String CLOUD_URL = "https://api.alfresco.com";
}
