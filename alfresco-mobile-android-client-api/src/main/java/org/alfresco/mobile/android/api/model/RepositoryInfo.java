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
package org.alfresco.mobile.android.api.model;

/**
 * The RepositoryInfo class provides information on the repository the session
 * is connected to, for example, repository version number, edition,
 * capabilities etc.
 * 
 * @author Jean Marie PASCAL
 */
public interface RepositoryInfo
{

    /**
     * Returns the unique identifier of the repository.
     */
    String getIdentifier();

    /**
     * Returns the name of the repository.
     */
    String getName();

    /**
     * Returns the description of the repository.
     */
    String getDescription();

    /**
     * Returns the full version string of the repository using the pattern:
     * major.minor.maintenance (build).
     */
    String getVersion();

    /**
     * Returns the major version of the repository, null if it could not be
     * determined.
     */
    Integer getMajorVersion();

    /**
     * Returns the minor version of the repository, null if it could not be
     * determined.
     */
    Integer getMinorVersion();

    /**
     * Returns the maintenance version of the repository, null if it could not
     * be determined.
     */
    Integer getMaintenanceVersion();

    /**
     * Returns the build number as string, null if it could not be determined.
     */
    String getBuildNumber();

    /**
     * Returns the edition of the repository i.e. Community or Enterprise or a
     * product name if it’s not an Alfresco repository.
     */
    String getEdition();

    /**
     * Returns an object representing the capabilities of the repository.
     */
    RepositoryCapabilities getCapabilities();

}
