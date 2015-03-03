package org.azkfw.document.database.xlsx;

import java.util.Date;

public final class WriterOption {

	/** システム名 */
	private String systemName;
	/** サブシステム名 */
	private String subSystemName;
	/** 作成者 */
	private String createUser;
	/** 作成日 */
	private Date createDate;
	/** 更新者 */
	private String updateUser;
	/** 更新日 */
	private Date updateDate;

	/**
	 * コンストラクタ
	 */
	public WriterOption() {
		systemName = null;
		subSystemName = null;
		createUser = null;
		createDate = null;
		updateUser = null;
		updateDate = null;
	}

	/**
	 * システム名を設定する。
	 * 
	 * @param name システム名
	 */
	public void setSystemName(final String name) {
		systemName = name;
	}

	/**
	 * システム名を取得する。
	 * 
	 * @return システム名
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * サブシステム名を設定する。
	 * 
	 * @param name サブシステム名
	 */
	public void setSubSystemName(final String name) {
		subSystemName = name;
	}

	/**
	 * サブシステム名を取得する。
	 * 
	 * @return サブシステム名
	 */
	public String getSubSystemName() {
		return subSystemName;
	}

	/**
	 * 作成者を設定する。
	 * 
	 * @param user 作成者S
	 */
	public void setCreateUser(final String user) {
		createUser = user;
	}

	/**
	 * 作成者を取得する。
	 * 
	 * @return 作成者
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 作成日を設定する。
	 * 
	 * @param date 作成日
	 */
	public void setCreateDate(final Date date) {
		createDate = date;
	}

	/**
	 * 作成日を取得する。
	 * 
	 * @return 作成日
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 更新者を設定する。
	 * 
	 * @param user 更新者
	 */
	public void setUpdateUser(final String user) {
		updateUser = user;
	}

	/**
	 * 更新者を取得する。
	 * 
	 * @return 更新者
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * 更新日を設定する。
	 * 
	 * @param user 更新日
	 */
	public void setUpdateDate(final Date date) {
		updateDate = date;
	}

	/**
	 * 更新日を取得する。
	 * 
	 * @return 更新日
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
}
