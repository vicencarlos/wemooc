/**
 * Copyright (c)2013 Telefonica Learning Services. All rights reserved.
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

package com.liferay.lms.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the LearningActivity service. Represents a row in the &quot;Lms_LearningActivity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.lms.model.impl.LearningActivityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.lms.model.impl.LearningActivityImpl}.
 * </p>
 *
 * @author TLS
 * @see LearningActivity
 * @see com.liferay.lms.model.impl.LearningActivityImpl
 * @see com.liferay.lms.model.impl.LearningActivityModelImpl
 * @generated
 */
public interface LearningActivityModel extends BaseModel<LearningActivity>,
	GroupedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a learning activity model instance should use the {@link LearningActivity} interface instead.
	 */

	/**
	 * Returns the primary key of this learning activity.
	 *
	 * @return the primary key of this learning activity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this learning activity.
	 *
	 * @param primaryKey the primary key of this learning activity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this learning activity.
	 *
	 * @return the uuid of this learning activity
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this learning activity.
	 *
	 * @param uuid the uuid of this learning activity
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the act ID of this learning activity.
	 *
	 * @return the act ID of this learning activity
	 */
	public long getActId();

	/**
	 * Sets the act ID of this learning activity.
	 *
	 * @param actId the act ID of this learning activity
	 */
	public void setActId(long actId);

	/**
	 * Returns the company ID of this learning activity.
	 *
	 * @return the company ID of this learning activity
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this learning activity.
	 *
	 * @param companyId the company ID of this learning activity
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this learning activity.
	 *
	 * @return the user ID of this learning activity
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this learning activity.
	 *
	 * @param userId the user ID of this learning activity
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this learning activity.
	 *
	 * @return the user uuid of this learning activity
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this learning activity.
	 *
	 * @param userUuid the user uuid of this learning activity
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this learning activity.
	 *
	 * @return the group ID of this learning activity
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this learning activity.
	 *
	 * @param groupId the group ID of this learning activity
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user name of this learning activity.
	 *
	 * @return the user name of this learning activity
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this learning activity.
	 *
	 * @param userName the user name of this learning activity
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this learning activity.
	 *
	 * @return the create date of this learning activity
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this learning activity.
	 *
	 * @param createDate the create date of this learning activity
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this learning activity.
	 *
	 * @return the modified date of this learning activity
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this learning activity.
	 *
	 * @param modifiedDate the modified date of this learning activity
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this learning activity.
	 *
	 * @return the status of this learning activity
	 */
	public int getStatus();

	/**
	 * Sets the status of this learning activity.
	 *
	 * @param status the status of this learning activity
	 */
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this learning activity.
	 *
	 * @return the status by user ID of this learning activity
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this learning activity.
	 *
	 * @param statusByUserId the status by user ID of this learning activity
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this learning activity.
	 *
	 * @return the status by user uuid of this learning activity
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this learning activity.
	 *
	 * @param statusByUserUuid the status by user uuid of this learning activity
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this learning activity.
	 *
	 * @return the status by user name of this learning activity
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this learning activity.
	 *
	 * @param statusByUserName the status by user name of this learning activity
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this learning activity.
	 *
	 * @return the status date of this learning activity
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this learning activity.
	 *
	 * @param statusDate the status date of this learning activity
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this learning activity.
	 *
	 * @return the title of this learning activity
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this learning activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this learning activity
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this learning activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this learning activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this learning activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this learning activity
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this learning activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this learning activity
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this learning activity.
	 *
	 * @return the locales and localized titles of this learning activity
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this learning activity.
	 *
	 * @param title the title of this learning activity
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this learning activity in the language.
	 *
	 * @param title the localized title of this learning activity
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this learning activity in the language, and sets the default locale.
	 *
	 * @param title the localized title of this learning activity
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this learning activity from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this learning activity
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this learning activity from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this learning activity
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this learning activity.
	 *
	 * @return the description of this learning activity
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this learning activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this learning activity
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this learning activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this learning activity. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this learning activity in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this learning activity
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this learning activity in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this learning activity
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this learning activity.
	 *
	 * @return the locales and localized descriptions of this learning activity
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this learning activity.
	 *
	 * @param description the description of this learning activity
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this learning activity in the language.
	 *
	 * @param description the localized description of this learning activity
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this learning activity in the language, and sets the default locale.
	 *
	 * @param description the localized description of this learning activity
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this learning activity from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this learning activity
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this learning activity from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this learning activity
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the type ID of this learning activity.
	 *
	 * @return the type ID of this learning activity
	 */
	public int getTypeId();

	/**
	 * Sets the type ID of this learning activity.
	 *
	 * @param typeId the type ID of this learning activity
	 */
	public void setTypeId(int typeId);

	/**
	 * Returns the startdate of this learning activity.
	 *
	 * @return the startdate of this learning activity
	 */
	public Date getStartdate();

	/**
	 * Sets the startdate of this learning activity.
	 *
	 * @param startdate the startdate of this learning activity
	 */
	public void setStartdate(Date startdate);

	/**
	 * Returns the enddate of this learning activity.
	 *
	 * @return the enddate of this learning activity
	 */
	public Date getEnddate();

	/**
	 * Sets the enddate of this learning activity.
	 *
	 * @param enddate the enddate of this learning activity
	 */
	public void setEnddate(Date enddate);

	/**
	 * Returns the precedence of this learning activity.
	 *
	 * @return the precedence of this learning activity
	 */
	public long getPrecedence();

	/**
	 * Sets the precedence of this learning activity.
	 *
	 * @param precedence the precedence of this learning activity
	 */
	public void setPrecedence(long precedence);

	/**
	 * Returns the tries of this learning activity.
	 *
	 * @return the tries of this learning activity
	 */
	public long getTries();

	/**
	 * Sets the tries of this learning activity.
	 *
	 * @param tries the tries of this learning activity
	 */
	public void setTries(long tries);

	/**
	 * Returns the passpuntuation of this learning activity.
	 *
	 * @return the passpuntuation of this learning activity
	 */
	public int getPasspuntuation();

	/**
	 * Sets the passpuntuation of this learning activity.
	 *
	 * @param passpuntuation the passpuntuation of this learning activity
	 */
	public void setPasspuntuation(int passpuntuation);

	/**
	 * Returns the priority of this learning activity.
	 *
	 * @return the priority of this learning activity
	 */
	public long getPriority();

	/**
	 * Sets the priority of this learning activity.
	 *
	 * @param priority the priority of this learning activity
	 */
	public void setPriority(long priority);

	/**
	 * Returns the module ID of this learning activity.
	 *
	 * @return the module ID of this learning activity
	 */
	public long getModuleId();

	/**
	 * Sets the module ID of this learning activity.
	 *
	 * @param moduleId the module ID of this learning activity
	 */
	public void setModuleId(long moduleId);

	/**
	 * Returns the extracontent of this learning activity.
	 *
	 * @return the extracontent of this learning activity
	 */
	@AutoEscape
	public String getExtracontent();

	/**
	 * Sets the extracontent of this learning activity.
	 *
	 * @param extracontent the extracontent of this learning activity
	 */
	public void setExtracontent(String extracontent);

	/**
	 * Returns the feedback correct of this learning activity.
	 *
	 * @return the feedback correct of this learning activity
	 */
	@AutoEscape
	public String getFeedbackCorrect();

	/**
	 * Sets the feedback correct of this learning activity.
	 *
	 * @param feedbackCorrect the feedback correct of this learning activity
	 */
	public void setFeedbackCorrect(String feedbackCorrect);

	/**
	 * Returns the feedback no correct of this learning activity.
	 *
	 * @return the feedback no correct of this learning activity
	 */
	@AutoEscape
	public String getFeedbackNoCorrect();

	/**
	 * Sets the feedback no correct of this learning activity.
	 *
	 * @param feedbackNoCorrect the feedback no correct of this learning activity
	 */
	public void setFeedbackNoCorrect(String feedbackNoCorrect);

	/**
	 * Returns the weightinmodule of this learning activity.
	 *
	 * @return the weightinmodule of this learning activity
	 */
	public long getWeightinmodule();

	/**
	 * Sets the weightinmodule of this learning activity.
	 *
	 * @param weightinmodule the weightinmodule of this learning activity
	 */
	public void setWeightinmodule(long weightinmodule);

	/**
	 * @deprecated Renamed to {@link #isApproved()}
	 */
	public boolean getApproved();

	/**
	 * Returns <code>true</code> if this learning activity is approved.
	 *
	 * @return <code>true</code> if this learning activity is approved; <code>false</code> otherwise
	 */
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this learning activity is denied.
	 *
	 * @return <code>true</code> if this learning activity is denied; <code>false</code> otherwise
	 */
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this learning activity is a draft.
	 *
	 * @return <code>true</code> if this learning activity is a draft; <code>false</code> otherwise
	 */
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this learning activity is expired.
	 *
	 * @return <code>true</code> if this learning activity is expired; <code>false</code> otherwise
	 */
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this learning activity is inactive.
	 *
	 * @return <code>true</code> if this learning activity is inactive; <code>false</code> otherwise
	 */
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this learning activity is incomplete.
	 *
	 * @return <code>true</code> if this learning activity is incomplete; <code>false</code> otherwise
	 */
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this learning activity is pending.
	 *
	 * @return <code>true</code> if this learning activity is pending; <code>false</code> otherwise
	 */
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this learning activity is scheduled.
	 *
	 * @return <code>true</code> if this learning activity is scheduled; <code>false</code> otherwise
	 */
	public boolean isScheduled();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	public Object clone();

	public int compareTo(LearningActivity learningActivity);

	public int hashCode();

	public CacheModel<LearningActivity> toCacheModel();

	public LearningActivity toEscapedModel();

	public String toString();

	public String toXmlString();
}