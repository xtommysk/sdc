/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2019 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

package org.openecomp.sdc.be.servlets;

import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.junit.Test;
import org.openecomp.sdc.be.components.impl.ComponentInstanceBusinessLogic;
import org.openecomp.sdc.be.components.impl.GroupBusinessLogic;
import org.openecomp.sdc.be.components.impl.ProductBusinessLogic;
import org.openecomp.sdc.be.impl.ComponentsUtils;
import org.openecomp.sdc.be.user.UserBusinessLogic;

public class ProductServletTest {

	private ProductServlet createTestSubject() {
		UserBusinessLogic userBusinessLogic = mock(UserBusinessLogic.class);
		ProductBusinessLogic productBusinessLogic = mock(ProductBusinessLogic.class);
		ComponentsUtils componentsUtils = mock(ComponentsUtils.class);

		return new ProductServlet(userBusinessLogic, productBusinessLogic, componentsUtils);
	}

	
	@Test
	public void testCreateProduct() throws Exception {
		ProductServlet testSubject;
		String data = "";
		HttpServletRequest request = null;
		String userId = "";
		Response result;

		// default test
		testSubject = createTestSubject();
	}

	
	@Test
	public void testGetProductById() throws Exception {
		ProductServlet testSubject;
		String productId = "";
		HttpServletRequest request = null;
		String userId = "";
		Response result;

		// default test
		testSubject = createTestSubject();
	}

	
	@Test
	public void testGetServiceByNameAndVersion() throws Exception {
		ProductServlet testSubject;
		String productName = "";
		String productVersion = "";
		HttpServletRequest request = null;
		String userId = "";
		Response result;

		// default test
		testSubject = createTestSubject();
	}

	
	@Test
	public void testDeleteProduct() throws Exception {
		ProductServlet testSubject;
		String productId = "";
		HttpServletRequest request = null;
		Response result;

		// default test
		testSubject = createTestSubject();
	}

	
	@Test
	public void testUpdateProductMetadata() throws Exception {
		ProductServlet testSubject;
		String productId = "";
		String data = "";
		HttpServletRequest request = null;
		String userId = "";
		Response result;

		// default test
		testSubject = createTestSubject();
	}

	
	@Test
	public void testValidateServiceName() throws Exception {
		ProductServlet testSubject;
		String productName = "";
		HttpServletRequest request = null;
		String userId = "";
		Response result;

		// default test
		testSubject = createTestSubject();
	}
}
