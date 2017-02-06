package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiControllerTests {

	@Mock
	PoiDao poiDao;
	@Mock
	Model model;

	@InjectMocks
	private PoiController poicontroller;

	private Poi[] dataArray = { new Poi("A", 1.0, 2.0), new Poi("B", 1.1, 1.9), new Poi("C", 1.2, 1.8),
			new Poi("D", 1.3, 1.7), new Poi("E", 1.4, 1.6) };
	private List<Poi> dataList;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		dataList = new ArrayList<Poi>(Arrays.asList(dataArray));
	}

	@Test
	public void shouldReturnCountOfPoi() {
		when(poiDao.count()).thenReturn((long) dataList.size());

		long returnvalue;
		returnvalue = poicontroller.count(model);

		long expected = dataList.size();
		assertEquals(returnvalue, expected);
	}

	@Test
	public void shouldReturnAllListOfPoiWhenParametersAreNull() {
		when(poiDao.findAll()).thenReturn(dataList);

		List<Poi> returnvalue;
		returnvalue = poicontroller.list(model, null, null, null, null);

		List<Poi> expected = new ArrayList<Poi>(Arrays.asList(dataArray));
		assertThat(returnvalue, is(expected));
	}

	@Test
	public void shouldReturnListOfPoiInRectangleWhenParametersAreGiven() {
		when(poiDao.findAll()).thenReturn(dataList);

		List<Poi> returnvalue;
		returnvalue = poicontroller.list(model, "1.1", "1.3", "1.7", "1.9");

		List<Poi> expected = new ArrayList<Poi>(Arrays.asList(dataArray[1], dataArray[2], dataArray[3]));
		assertThat(returnvalue, is(expected));
	}
}
