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

package org.openecomp.sdc.be.datatypes.elements;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.util.Map;

public class MapGroupsDataDefinitionTest {

	private MapGroupsDataDefinition createTestSubject() {
		return new MapGroupsDataDefinition();
	}
	
	@Test
	public void testConstructors() throws Exception {
		MapGroupsDataDefinition testSubject;
		Map<String, GroupInstanceDataDefinition> result;

		// default test
		new MapGroupsDataDefinition(new HashedMap());
		new MapGroupsDataDefinition(new MapDataDefinition<>(), "");
	}
	
	@Test
	public void testGetMapToscaDataDefinition() throws Exception {
		MapGroupsDataDefinition testSubject;
		Map<String, GroupInstanceDataDefinition> result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getMapToscaDataDefinition();
	}

	@Test
	public void testSetMapToscaDataDefinition() throws Exception {
		MapGroupsDataDefinition testSubject;
		Map<String, GroupInstanceDataDefinition> mapToscaDataDefinition = null;

		// default test
		testSubject = createTestSubject();
		testSubject.setMapToscaDataDefinition(mapToscaDataDefinition);
	}

	@Test
	public void testGetParentName() throws Exception {
		MapGroupsDataDefinition testSubject;
		String result;

		// default test
		testSubject = createTestSubject();
		result = testSubject.getParentName();
	}

	@Test
	public void testSetParentName() throws Exception {
		MapGroupsDataDefinition testSubject;
		String parentName = "";

		// default test
		testSubject = createTestSubject();
		testSubject.setParentName(parentName);
	}
}
