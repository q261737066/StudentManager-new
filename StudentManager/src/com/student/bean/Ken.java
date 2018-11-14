/**
 *
 */
package com.student.bean;

/**
 *
 * studentのBeanクラス
 *
 * @author firstdevelop zhangyong
 *
 */
public class Ken {
	//id
	private int id;
	//県名
	private String kenname;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return kenname
	 */
	public String getKenname() {
		return kenname;
	}
	/**
	 * @param kenname セットする kenname
	 */
	public void setKenname(String kenname) {
		this.kenname = kenname;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((kenname == null) ? 0 : kenname.hashCode());
		return result;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ken other = (Ken) obj;
		if (id != other.id)
			return false;
		if (kenname == null) {
			if (other.kenname != null)
				return false;
		} else if (!kenname.equals(other.kenname))
			return false;
		return true;
	}
	/**
	 * @param id
	 * @param kenname
	 */
	public Ken(int id, String kenname) {
		this.id = id;
		this.kenname = kenname;
	}
	/**
	 *
	 */
	public Ken() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}


}
