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

package com.liferay.lmssa.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.lmssa.model.ActManAudit;
import com.liferay.lmssa.service.ActManAuditLocalService;
import com.liferay.lmssa.service.ActManAuditService;
import com.liferay.lmssa.service.LearningActivityTryDeletedLocalService;
import com.liferay.lmssa.service.LearningActivityTryDeletedService;
import com.liferay.lmssa.service.persistence.ActManAuditPersistence;
import com.liferay.lmssa.service.persistence.LearningActivityTryDeletedPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the act man audit local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.lmssa.service.impl.ActManAuditLocalServiceImpl}.
 * </p>
 *
 * @author TLS
 * @see com.liferay.lmssa.service.impl.ActManAuditLocalServiceImpl
 * @see com.liferay.lmssa.service.ActManAuditLocalServiceUtil
 * @generated
 */
public abstract class ActManAuditLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ActManAuditLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.lmssa.service.ActManAuditLocalServiceUtil} to access the act man audit local service.
	 */

	/**
	 * Adds the act man audit to the database. Also notifies the appropriate model listeners.
	 *
	 * @param actManAudit the act man audit
	 * @return the act man audit that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ActManAudit addActManAudit(ActManAudit actManAudit)
		throws SystemException {
		actManAudit.setNew(true);

		return actManAuditPersistence.update(actManAudit, false);
	}

	/**
	 * Creates a new act man audit with the primary key. Does not add the act man audit to the database.
	 *
	 * @param actManAuditId the primary key for the new act man audit
	 * @return the new act man audit
	 */
	public ActManAudit createActManAudit(long actManAuditId) {
		return actManAuditPersistence.create(actManAuditId);
	}

	/**
	 * Deletes the act man audit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actManAuditId the primary key of the act man audit
	 * @return the act man audit that was removed
	 * @throws PortalException if a act man audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public ActManAudit deleteActManAudit(long actManAuditId)
		throws PortalException, SystemException {
		return actManAuditPersistence.remove(actManAuditId);
	}

	/**
	 * Deletes the act man audit from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actManAudit the act man audit
	 * @return the act man audit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public ActManAudit deleteActManAudit(ActManAudit actManAudit)
		throws SystemException {
		return actManAuditPersistence.remove(actManAudit);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ActManAudit.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return actManAuditPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return actManAuditPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return actManAuditPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return actManAuditPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public ActManAudit fetchActManAudit(long actManAuditId)
		throws SystemException {
		return actManAuditPersistence.fetchByPrimaryKey(actManAuditId);
	}

	/**
	 * Returns the act man audit with the primary key.
	 *
	 * @param actManAuditId the primary key of the act man audit
	 * @return the act man audit
	 * @throws PortalException if a act man audit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ActManAudit getActManAudit(long actManAuditId)
		throws PortalException, SystemException {
		return actManAuditPersistence.findByPrimaryKey(actManAuditId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return actManAuditPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the act man audit with the UUID in the group.
	 *
	 * @param uuid the UUID of act man audit
	 * @param groupId the group id of the act man audit
	 * @return the act man audit
	 * @throws PortalException if a act man audit with the UUID in the group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ActManAudit getActManAuditByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return actManAuditPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the act man audits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of act man audits
	 * @param end the upper bound of the range of act man audits (not inclusive)
	 * @return the range of act man audits
	 * @throws SystemException if a system exception occurred
	 */
	public List<ActManAudit> getActManAudits(int start, int end)
		throws SystemException {
		return actManAuditPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of act man audits.
	 *
	 * @return the number of act man audits
	 * @throws SystemException if a system exception occurred
	 */
	public int getActManAuditsCount() throws SystemException {
		return actManAuditPersistence.countAll();
	}

	/**
	 * Updates the act man audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param actManAudit the act man audit
	 * @return the act man audit that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ActManAudit updateActManAudit(ActManAudit actManAudit)
		throws SystemException {
		return updateActManAudit(actManAudit, true);
	}

	/**
	 * Updates the act man audit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param actManAudit the act man audit
	 * @param merge whether to merge the act man audit with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the act man audit that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ActManAudit updateActManAudit(ActManAudit actManAudit, boolean merge)
		throws SystemException {
		actManAudit.setNew(false);

		return actManAuditPersistence.update(actManAudit, merge);
	}

	/**
	 * Returns the act man audit local service.
	 *
	 * @return the act man audit local service
	 */
	public ActManAuditLocalService getActManAuditLocalService() {
		return actManAuditLocalService;
	}

	/**
	 * Sets the act man audit local service.
	 *
	 * @param actManAuditLocalService the act man audit local service
	 */
	public void setActManAuditLocalService(
		ActManAuditLocalService actManAuditLocalService) {
		this.actManAuditLocalService = actManAuditLocalService;
	}

	/**
	 * Returns the act man audit remote service.
	 *
	 * @return the act man audit remote service
	 */
	public ActManAuditService getActManAuditService() {
		return actManAuditService;
	}

	/**
	 * Sets the act man audit remote service.
	 *
	 * @param actManAuditService the act man audit remote service
	 */
	public void setActManAuditService(ActManAuditService actManAuditService) {
		this.actManAuditService = actManAuditService;
	}

	/**
	 * Returns the act man audit persistence.
	 *
	 * @return the act man audit persistence
	 */
	public ActManAuditPersistence getActManAuditPersistence() {
		return actManAuditPersistence;
	}

	/**
	 * Sets the act man audit persistence.
	 *
	 * @param actManAuditPersistence the act man audit persistence
	 */
	public void setActManAuditPersistence(
		ActManAuditPersistence actManAuditPersistence) {
		this.actManAuditPersistence = actManAuditPersistence;
	}

	/**
	 * Returns the learning activity try deleted local service.
	 *
	 * @return the learning activity try deleted local service
	 */
	public LearningActivityTryDeletedLocalService getLearningActivityTryDeletedLocalService() {
		return learningActivityTryDeletedLocalService;
	}

	/**
	 * Sets the learning activity try deleted local service.
	 *
	 * @param learningActivityTryDeletedLocalService the learning activity try deleted local service
	 */
	public void setLearningActivityTryDeletedLocalService(
		LearningActivityTryDeletedLocalService learningActivityTryDeletedLocalService) {
		this.learningActivityTryDeletedLocalService = learningActivityTryDeletedLocalService;
	}

	/**
	 * Returns the learning activity try deleted remote service.
	 *
	 * @return the learning activity try deleted remote service
	 */
	public LearningActivityTryDeletedService getLearningActivityTryDeletedService() {
		return learningActivityTryDeletedService;
	}

	/**
	 * Sets the learning activity try deleted remote service.
	 *
	 * @param learningActivityTryDeletedService the learning activity try deleted remote service
	 */
	public void setLearningActivityTryDeletedService(
		LearningActivityTryDeletedService learningActivityTryDeletedService) {
		this.learningActivityTryDeletedService = learningActivityTryDeletedService;
	}

	/**
	 * Returns the learning activity try deleted persistence.
	 *
	 * @return the learning activity try deleted persistence
	 */
	public LearningActivityTryDeletedPersistence getLearningActivityTryDeletedPersistence() {
		return learningActivityTryDeletedPersistence;
	}

	/**
	 * Sets the learning activity try deleted persistence.
	 *
	 * @param learningActivityTryDeletedPersistence the learning activity try deleted persistence
	 */
	public void setLearningActivityTryDeletedPersistence(
		LearningActivityTryDeletedPersistence learningActivityTryDeletedPersistence) {
		this.learningActivityTryDeletedPersistence = learningActivityTryDeletedPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.lmssa.model.ActManAudit",
			actManAuditLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.lmssa.model.ActManAudit");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return ActManAudit.class;
	}

	protected String getModelClassName() {
		return ActManAudit.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = actManAuditPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ActManAuditLocalService.class)
	protected ActManAuditLocalService actManAuditLocalService;
	@BeanReference(type = ActManAuditService.class)
	protected ActManAuditService actManAuditService;
	@BeanReference(type = ActManAuditPersistence.class)
	protected ActManAuditPersistence actManAuditPersistence;
	@BeanReference(type = LearningActivityTryDeletedLocalService.class)
	protected LearningActivityTryDeletedLocalService learningActivityTryDeletedLocalService;
	@BeanReference(type = LearningActivityTryDeletedService.class)
	protected LearningActivityTryDeletedService learningActivityTryDeletedService;
	@BeanReference(type = LearningActivityTryDeletedPersistence.class)
	protected LearningActivityTryDeletedPersistence learningActivityTryDeletedPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ActManAuditLocalServiceClpInvoker _clpInvoker = new ActManAuditLocalServiceClpInvoker();
}