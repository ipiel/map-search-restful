package com.example;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapSearchRestfulApplicationTests {

	@Mock
	ServletRegistrationBean registration;
	@Mock
	SpringApplication springapplication;

	@InjectMocks
	private MapSearchRestfulApplication application;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnServletRegistrationBean() {
		ServletRegistrationBean returnvalue;
		returnvalue = application.h2servletRegistration();

		assertThat(returnvalue, instanceOf(ServletRegistrationBean.class));
	}

	@Test
	public void shouldAddUrlMappingsWithConsole() {
		application.h2servletRegistration();

		verify(registration, times(1)).addUrlMappings("/console/*");
	}
}
