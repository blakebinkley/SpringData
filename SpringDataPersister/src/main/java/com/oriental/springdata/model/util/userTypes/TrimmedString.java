package com.oriental.springdata.model.util.userTypes;

import java.io.Serializable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class TrimmedString implements UserType {

    /**
     *
     */
    public TrimmedString() {
		super();
	}

    /**
     *
     * @return
     */
    public int[] sqlTypes() {
		return new int[] { Types.CHAR };
	}

    /**
     *
     * @return
     */
    public Class returnedClass() {
		return String.class;
	}

    /**
     *
     * @param x
     * @param y
     * @return
     * @throws org.hibernate.HibernateException
     */
    public boolean equals(Object x, Object y) throws HibernateException {
		return (x == y) || (x != null && y != null && (x.equals(y)));
	}

    /**
     *
     * @param rs
     * @param names
     * @param owner
     * @return
     * @throws org.hibernate.HibernateException
     * @throws java.sql.SQLException
     */
    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		String val = rs.getString(names[0]);
		if (val == null)
			return "";
		return val.trim();
		/* Add nullable columns */
		/*
		 * public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
		 * throws HibernateException, SQLException { String val =
		 * rs.getString(names[0]); if (null == val) return(null);
		 * 
		 * return val.trim(); }
		 */
	}

    /**
     *
     * @param st
     * @param value
     * @param index
     * @throws org.hibernate.HibernateException
     * @throws java.sql.SQLException
     */
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		st.setString(index, (String) value);
	}

    /**
     *
     * @param value
     * @return
     * @throws org.hibernate.HibernateException
     */
    public Object deepCopy(Object value) throws HibernateException {
		if (value == null)
			return null;
		return new String((String) value);
	}

    /**
     *
     * @return
     */
    public boolean isMutable() {
		return false;
	}

    /**
     *
     * @param x
     * @return
     * @throws org.hibernate.HibernateException
     */
    @Override
	public int hashCode(Object x) throws HibernateException {
		assert (x != null);
		return x.hashCode();
	}

	/**
     *
     * @param original
     * @param target
     * @param owner
     * @return
     * @throws org.hibernate.HibernateException
     */
    @Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

    /**
     *
     * @param value
     * @return
     * @throws org.hibernate.HibernateException
     */
    @Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

    /**
     *
     * @param cached
     * @param owner
     * @return
     * @throws org.hibernate.HibernateException
     */
    @Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}
}