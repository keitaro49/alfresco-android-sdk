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
package org.alfresco.mobile.android.api.services.impl.cloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.alfresco.mobile.android.api.constants.CloudConstant;
import org.alfresco.mobile.android.api.exceptions.ErrorCodeRegistry;
import org.alfresco.mobile.android.api.model.ActivityEntry;
import org.alfresco.mobile.android.api.model.ListingContext;
import org.alfresco.mobile.android.api.model.PagingResult;
import org.alfresco.mobile.android.api.model.impl.ActivityEntryImpl;
import org.alfresco.mobile.android.api.model.impl.PagingResultImpl;
import org.alfresco.mobile.android.api.services.impl.AbstractActivityStreamService;
import org.alfresco.mobile.android.api.session.AlfrescoSession;
import org.alfresco.mobile.android.api.session.CloudSession;
import org.alfresco.mobile.android.api.utils.CloudUrlRegistry;
import org.alfresco.mobile.android.api.utils.PublicAPIResponse;
import org.apache.chemistry.opencmis.client.bindings.spi.http.HttpUtils;
import org.apache.chemistry.opencmis.commons.impl.UrlBuilder;

/**
 * Specific implementation of ActivityStreamService for Public Cloud API.
 * 
 * @author Jean Marie Pascal
 */
public class CloudActivityStreamServiceImpl extends AbstractActivityStreamService
{

    /**
     * Default Constructor. Only used inside ServiceRegistry.
     * 
     * @param repositorySession : Repository Session.
     */
    public CloudActivityStreamServiceImpl(AlfrescoSession repositorySession)
    {
        super(repositorySession);
    }

    /** {@inheritDoc} */
    protected UrlBuilder getUserActivitiesUrl(ListingContext listingContext)
    {
        String link = CloudUrlRegistry.getUserActivitiesUrl((CloudSession) session);
        UrlBuilder url = new UrlBuilder(link);
        if (listingContext != null)
        {
            url.addParameter(CloudConstant.MAX_ITEMS_VALUE, listingContext.getMaxItems());
            url.addParameter(CloudConstant.SKIP_COUNT_VALUE, listingContext.getSkipCount());
        }
        return url;
    }

    /** {@inheritDoc} */
    protected UrlBuilder getUserActivitiesUrl(String personIdentifier, ListingContext listingContext)
    {
        String link = CloudUrlRegistry.getUserActivitiesUrl((CloudSession) session, personIdentifier);
        UrlBuilder url = new UrlBuilder(link);
        if (listingContext != null)
        {
            url.addParameter(CloudConstant.MAX_ITEMS_VALUE, listingContext.getMaxItems());
            url.addParameter(CloudConstant.SKIP_COUNT_VALUE, listingContext.getSkipCount());
        }
        return url;
    }

    /** {@inheritDoc} */
    protected UrlBuilder getSiteActivitiesUrl(String siteIdentifier, ListingContext listingContext)
    {
        String link = CloudUrlRegistry.getSiteActivitiesUrl((CloudSession) session, siteIdentifier);
        UrlBuilder url = new UrlBuilder(link);
        if (listingContext != null)
        {
            url.addParameter(CloudConstant.MAX_ITEMS_VALUE, listingContext.getMaxItems());
            url.addParameter(CloudConstant.SKIP_COUNT_VALUE, listingContext.getSkipCount());
        }
        return url;
    }

    // ////////////////////////////////////////////////////////////////////////////////////
    // / INTERNAL
    // ////////////////////////////////////////////////////////////////////////////////////
    /**
     * Internal method to compute data from server and transform it as high
     * level object.
     * 
     * @param url : Alfresco REST API activity url
     * @param listingContext : listing context to apply to the paging result.
     * @return Paging Result of activity entry.
     */
    @SuppressWarnings("unchecked")
    protected PagingResult<ActivityEntry> computeActivities(UrlBuilder url, ListingContext listingContext)
    {
        // read and parse
        HttpUtils.Response resp = read(url, ErrorCodeRegistry.ACTIVITISTREAM_GENERIC);
        PublicAPIResponse response = new PublicAPIResponse(resp);

        List<ActivityEntry> result = new ArrayList<ActivityEntry>();
        Map<String, Object> data = null;
        for (Object entry : response.getEntries())
        {
            data = (Map<String, Object>) ((Map<String, Object>) entry).get(CloudConstant.ENTRY_VALUE);
            result.add(ActivityEntryImpl.parsePublicAPIJson(data));
        }

        return new PagingResultImpl<ActivityEntry>(result, response.getHasMoreItems(), response.getSize());
    }
}
