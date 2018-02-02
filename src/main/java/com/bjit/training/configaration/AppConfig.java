package com.bjit.training.configaration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.bjit.training.dao.UserDAOImpl;
@Configuration
public class AppConfig{
//	  @Bean
	    public ViewResolver getViewResolver(){
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	  
	
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/example");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("");
		return driverManagerDataSource;
	}

//	  @Bean
//		public DataSourceTransactionManager transactionManager(){
//			return new DataSourceTransactionManager(dataSource());
//		}
//	
//	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	    }
	  
		@Bean
		public UserDAOImpl userDAO(){
			UserDAOImpl userDAOImpl = new UserDAOImpl();
//			UserDAOImpl userDAOImpl = new UserDAOImpl() ;
//			
			userDAOImpl.setDataSource(dataSource());
////			foodDAOImpl.setRestaurantManager(restaurantManager());
			return userDAOImpl;
			
			 //return new UserDAOImpl(dataSource());
		}
	  
//		<bean id="transactionManager"
//				class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
//				<property name="dataSource" ref="dataSource" />
//			</bean> <!-- MySQL DB DataSource -->
//			<bean id="dataSource"
//				class="org.springframework.jdbc.datasource.DriverManagerDataSource">
//				<property name="driverClassName" value="com.mysql.jdbc.Driver" />
//				<property name="url" value="jdbc:mysql://localhost:3306/example" />
//				<property name="username" value="root" />
//				<property name="password" value="" />
//			</bean>
//			
//			<bean id="userDAO" class="package com.bjit.training.dao.UserDAOImpl">
//				<property name="dataSource" ref="dataSource"></property>
//			</bean>  
//			<bean id="userManager"
//				class="package com.bjit.training.service.UserServiceImpl">
//				<property name="customerDAO" ref="customerDAO"></property>
//			</bean>
			
			

}
