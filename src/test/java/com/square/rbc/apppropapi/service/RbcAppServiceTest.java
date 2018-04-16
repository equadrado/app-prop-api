package com.square.rbc.apppropapi.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.BDDMockito.given;

import com.square.rbc.apppropapi.dto.AppVersionDTO;
import com.square.rbc.apppropapi.exception.InvalidPathParameterException;
import com.square.rbc.apppropapi.exception.ObjectNotFoundException;
import com.square.rbc.apppropapi.model.AppVersion;
import com.square.rbc.apppropapi.model.RbcApp;
import com.square.rbc.apppropapi.repository.RbcAppRepository;

/**
 * 
 * @author equadrado
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
public class RbcAppServiceTest {

	@MockBean
	RbcAppRepository rbcAppRepositoryMock;
	
	@Autowired
	RbcAppService rbcAppService;
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test(expected = InvalidPathParameterException.class)
	public void testFinbByIdValueNotSupported() throws Exception {
		long id = 0;

		List<AppVersion> appVerListMock = new ArrayList<AppVersion>();
		appVerListMock.add(new AppVersion());

		Optional<RbcApp> rbcAppMock = Optional.of(new RbcApp());
		
		rbcAppMock.get().setId(0L);
		rbcAppMock.get().setName("RBC App Mock");
		rbcAppMock.get().setDescription("App Description");
		rbcAppMock.get().setAppVersions(appVerListMock);

		given(rbcAppRepositoryMock.findById(id)).willReturn(rbcAppMock);
		RbcApp rbcApp = rbcAppService.findById(id);

		assertNull(rbcApp);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testFinbByIdValueSupported() throws Exception {
		long id = 1;

		List<AppVersion> appVerListMock = new ArrayList<AppVersion>();
		appVerListMock.add(new AppVersion());

		Optional<RbcApp> rbcAppMock = Optional.of(new RbcApp());
		
		rbcAppMock.get().setId(1L);
		rbcAppMock.get().setName("RBC App Mock");
		rbcAppMock.get().setDescription("App Description");
		rbcAppMock.get().setAppVersions(appVerListMock);

		given(rbcAppRepositoryMock.findById(id)).willReturn(rbcAppMock);
		RbcApp rbcApp = rbcAppService.findById(id);

		assertNotNull(rbcApp);
	}

}
