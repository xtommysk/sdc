/*
 * Copyright © 2018 European Support Limited
 *
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
 */
package org.openecomp.sdcrests.vendorlicense.rest.services;

import org.openecomp.sdcrests.uniquevalue.types.UniqueTypesProvider;

import java.util.Collections;
import java.util.Map;

import static org.openecomp.sdc.vendorlicense.VendorLicenseConstants.UniqueValues.VENDOR_NAME;

public class VlmUniqueTypeProvider implements UniqueTypesProvider {

  private static final Map<String, String> uniqueTypes =
      Collections.singletonMap("VlmName", VENDOR_NAME);

  @Override
  public Map<String, String> listUniqueTypes() {
    return uniqueTypes;
  }
}
