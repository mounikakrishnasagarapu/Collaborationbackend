
package com.niit.collaborationbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaborationbackend.dao.BlogDAO;
import com.niit.collaborationbackend.dao.BlogLikesDAO;
import com.niit.collaborationbackend.dao.ForumCommentDAO;
import com.niit.collaborationbackend.dao.ForumDAO;
import com.niit.collaborationbackend.dao.FriendDAO;
import com.niit.collaborationbackend.dao.JobDAO;
import com.niit.collaborationbackend.dao.UsersDAO;
import com.niit.collaborationbackend.daoimpl.BlogDAOImpl;
import com.niit.collaborationbackend.daoimpl.BlogLikesDAOImpl;
import com.niit.collaborationbackend.daoimpl.ForumCommentDAOImpl;
import com.niit.collaborationbackend.daoimpl.ForumDAOImpl;
import com.niit.collaborationbackend.daoimpl.FriendDAOImpl;
import com.niit.collaborationbackend.daoimpl.JobDAOImpl;
import com.niit.collaborationbackend.daoimpl.UsersDAOImpl;
import com.niit.collaborationbackend.model.Blog;
import com.niit.collaborationbackend.model.BlogLikes;
import com.niit.collaborationbackend.model.Forum;
import com.niit.collaborationbackend.model.ForumComment;
import com.niit.collaborationbackend.model.Friend;
import com.niit.collaborationbackend.model.Job;
import com.niit.collaborationbackend.model.Users;



@Configuration
@ComponentScan("com.niit.collaborationbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("mounika");
		dataSource.setPassword("mounika");
		System.out.println("Datasource");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClasses(Users.class);
		sessionBuilder.addAnnotatedClasses(Blog.class);
		sessionBuilder.addAnnotatedClasses(Friend.class);
		sessionBuilder.addAnnotatedClasses(Job.class);
		sessionBuilder.addAnnotatedClasses(Forum.class);
		sessionBuilder.addAnnotatedClasses(ForumComment.class);
		sessionBuilder.addAnnotatedClasses(BlogLikes.class);

        	System.out.println("Session");
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}

	
	@Autowired
	@Bean(name = "usersDAO")
	public UsersDAO getUsersDao(SessionFactory sessionFactory) {
		System.out.println("Usr is doen");
			return new UsersDAOImpl(sessionFactory);
		
	}
	@Autowired
	@Bean(name = "blogDAO")
	public BlogDAO getBlogDao(SessionFactory sessionFactory) {
		System.out.println("blog is done");
			return new BlogDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "friendDAO")
	public FriendDAO getFriendDao(SessionFactory sessionFactory) {
		System.out.println("Friend is done");
			return new FriendDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "jobDAO")
	public JobDAO getJobDao(SessionFactory sessionFactory) {
		System.out.println("Job is done");
			return new JobDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "forumDAO")
	public ForumDAO getForumDao(SessionFactory sessionFactory) {
		System.out.println("Forum is done");
			return new ForumDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "forumCommentDAO")
	public ForumCommentDAO getForumCommentDao(SessionFactory sessionFactory) {
		System.out.println("Forum Comment is done");
			return new ForumCommentDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "blogLikesDAO")
	public BlogLikesDAO getBlogLikesDao(SessionFactory sessionFactory) {
		System.out.println("BlogLikes is done");
			return new BlogLikesDAOImpl(sessionFactory);
	}
}
