/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property. All rights reserved.
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

package org.onap.sdc.backend.ci.tests.datatypes;

import org.openecomp.sdc.be.model.User;

public class UserCredentials extends User {

	// private String userName;
	private String password;

	public UserCredentials(String userId, String password, String firstname, String lastname, String role) {
		super();
		setUserId(userId);
		// this.userName = userName;
		this.password = password;
		setFirstName(firstname);
		setLastName(lastname);
		setRole(role);
	}

	public UserCredentials() {
		super();
	}

	// public String getUserName() {
	// return userName;
	// }
	// public void setUserName(String userName) {
	// this.userName = userName;
	// }
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
