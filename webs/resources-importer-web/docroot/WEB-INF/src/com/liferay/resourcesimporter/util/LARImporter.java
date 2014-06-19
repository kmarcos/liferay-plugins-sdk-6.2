/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.resourcesimporter.util;

import com.liferay.portal.kernel.lar.PortletDataHandlerKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan Park
 * @author Raymond Augé
 */
public class LARImporter extends BaseImporter {


	public void importResources() throws Exception {
		if (_privateLARInputStream != null) {
			LayoutLocalServiceUtil.importLayouts(
				userId, groupId, true, getParameterMap(),
				_privateLARInputStream);
		}

		if (_publicLARInputStream != null) {
			LayoutLocalServiceUtil.importLayouts(
				userId, groupId, false, getParameterMap(),
				_publicLARInputStream);
		}
	}

	public void setLARFile(File file) {
		try {
			setPublicLARInputStream(
				new BufferedInputStream(new FileInputStream(file)));
		}
		catch (FileNotFoundException fnfe) {
			_log.error(fnfe, fnfe);
		}
	}

	public void setLARInputStream(InputStream inputStream) {
		setPublicLARInputStream(inputStream);
	}

	public void setPrivateLARInputStream(InputStream privateLARInputStream) {
		_privateLARInputStream = privateLARInputStream;
	}

	public void setPublicLARInputStream(InputStream publicLARInputStream) {
		_publicLARInputStream = publicLARInputStream;
	}

	protected Map<String, String[]> getParameterMap() {
		Map<String, String[]> parameters = new HashMap<String, String[]>();

		parameters.put(
			PortletDataHandlerKeys.CATEGORIES,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.DELETE_MISSING_LAYOUTS,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.DELETE_PORTLET_DATA,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.LAYOUT_SET_PROTOTYPE_LINK_ENABLED,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.LAYOUT_SET_SETTINGS,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.LAYOUTS_IMPORT_MODE,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.LOGO,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PERMISSIONS,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLET_ARCHIVED_SETUPS,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLET_CONFIGURATION,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLET_CONFIGURATION_ALL,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLET_DATA,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLET_DATA_ALL,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLET_SETUP_ALL,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLET_USER_PREFERENCES,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PORTLETS_MERGE_MODE,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PUBLIC_LAYOUT_PERMISSIONS,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.PUBLISH_TO_REMOTE,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.THEME_REFERENCE,
			new String[] {Boolean.TRUE.toString()});
		parameters.put(
			PortletDataHandlerKeys.USER_ID_STRATEGY,
			new String[] {Boolean.TRUE.toString()});

		return parameters;
	}

	private static Log _log = LogFactoryUtil.getLog(LARImporter.class);

	private InputStream _privateLARInputStream;
	private InputStream _publicLARInputStream;

}