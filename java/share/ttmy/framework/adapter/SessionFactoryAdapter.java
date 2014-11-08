package ttmy.framework.adapter;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

public class SessionFactoryAdapter implements SessionFactory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Reference getReference() throws NamingException {
		return null;
	}

	@Override
	public void close() throws HibernateException {
	}

	@Override
	public boolean containsFetchProfileDefinition(String arg0) {
		return false;
	}

	@Override
	public void evict(Class arg0) throws HibernateException {
	}

	@Override
	public void evict(Class arg0, Serializable arg1) throws HibernateException {
	}

	@Override
	public void evictCollection(String arg0) throws HibernateException {
	}

	@Override
	public void evictCollection(String arg0, Serializable arg1) throws HibernateException {
	}

	@Override
	public void evictEntity(String arg0) throws HibernateException {
	}

	@Override
	public void evictEntity(String arg0, Serializable arg1) throws HibernateException {
	}

	@Override
	public void evictQueries() throws HibernateException {
	}

	@Override
	public void evictQueries(String arg0) throws HibernateException {
	}

	@Override
	public Map<String, ClassMetadata> getAllClassMetadata() {
		return null;
	}

	@Override
	public Map getAllCollectionMetadata() {
		return null;
	}

	@Override
	public Cache getCache() {
		return null;
	}

	@Override
	public ClassMetadata getClassMetadata(Class arg0) {
		return null;
	}

	@Override
	public ClassMetadata getClassMetadata(String arg0) {
		return null;
	}

	@Override
	public CollectionMetadata getCollectionMetadata(String arg0) {
		return null;
	}

	@Override
	public Session getCurrentSession() throws HibernateException {
		return null;
	}

	@Override
	public Set getDefinedFilterNames() {
		return null;
	}

	@Override
	public FilterDefinition getFilterDefinition(String arg0) throws HibernateException {
		return null;
	}

	@Override
	public SessionFactoryOptions getSessionFactoryOptions() {
		return null;
	}

	@Override
	public Statistics getStatistics() {
		return null;
	}

	@Override
	public TypeHelper getTypeHelper() {
		return null;
	}

	@Override
	public boolean isClosed() {
		return false;
	}

	@Override
	public Session openSession() throws HibernateException {
		return null;
	}

	@Override
	public StatelessSession openStatelessSession() {
		return null;
	}

	@Override
	public StatelessSession openStatelessSession(Connection arg0) {
		return null;
	}

	@Override
	public SessionBuilder withOptions() {
		return null;
	}

	@Override
	public StatelessSessionBuilder withStatelessOptions() {
		return null;
	}

}
