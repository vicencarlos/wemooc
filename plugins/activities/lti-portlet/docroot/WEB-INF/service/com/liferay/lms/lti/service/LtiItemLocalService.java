/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lms.lti.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the lti item local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Diego Renedo Delgado
 * @see LtiItemLocalServiceUtil
 * @see com.liferay.lms.lti.service.base.LtiItemLocalServiceBaseImpl
 * @see com.liferay.lms.lti.service.impl.LtiItemLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LtiItemLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LtiItemLocalServiceUtil} to access the lti item local service. Add custom service methods to {@link com.liferay.lms.lti.service.impl.LtiItemLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the lti item to the database. Also notifies the appropriate model listeners.
	*
	* @param ltiItem the lti item
	* @return the lti item that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.lti.model.LtiItem addLtiItem(
		com.liferay.lms.lti.model.LtiItem ltiItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new lti item with the primary key. Does not add the lti item to the database.
	*
	* @param ltiItemId the primary key for the new lti item
	* @return the new lti item
	*/
	public com.liferay.lms.lti.model.LtiItem createLtiItem(long ltiItemId);

	/**
	* Deletes the lti item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ltiItemId the primary key of the lti item
	* @return the lti item that was removed
	* @throws PortalException if a lti item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.lti.model.LtiItem deleteLtiItem(long ltiItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the lti item from the database. Also notifies the appropriate model listeners.
	*
	* @param ltiItem the lti item
	* @return the lti item that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.lti.model.LtiItem deleteLtiItem(
		com.liferay.lms.lti.model.LtiItem ltiItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.lms.lti.model.LtiItem fetchLtiItem(long ltiItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lti item with the primary key.
	*
	* @param ltiItemId the primary key of the lti item
	* @return the lti item
	* @throws PortalException if a lti item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.lms.lti.model.LtiItem getLtiItem(long ltiItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lti item with the UUID in the group.
	*
	* @param uuid the UUID of lti item
	* @param groupId the group id of the lti item
	* @return the lti item
	* @throws PortalException if a lti item with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.lms.lti.model.LtiItem getLtiItemByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lti items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lti items
	* @param end the upper bound of the range of lti items (not inclusive)
	* @return the range of lti items
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.lms.lti.model.LtiItem> getLtiItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lti items.
	*
	* @return the number of lti items
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLtiItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the lti item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ltiItem the lti item
	* @return the lti item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.lti.model.LtiItem updateLtiItem(
		com.liferay.lms.lti.model.LtiItem ltiItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the lti item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ltiItem the lti item
	* @param merge whether to merge the lti item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the lti item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.lms.lti.model.LtiItem updateLtiItem(
		com.liferay.lms.lti.model.LtiItem ltiItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.liferay.lms.lti.model.LtiItem create(long actId,
		java.lang.String url, java.lang.String secret);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.lms.lti.model.LtiItem fetchByactId(long actId);
}