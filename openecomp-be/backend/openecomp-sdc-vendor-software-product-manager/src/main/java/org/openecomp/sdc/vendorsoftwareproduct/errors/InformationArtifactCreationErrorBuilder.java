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

package org.openecomp.sdc.vendorsoftwareproduct.errors;

import org.openecomp.sdc.common.errors.ErrorCategory;
import org.openecomp.sdc.common.errors.ErrorCode;

import static org.openecomp.sdc.vendorsoftwareproduct.errors.VendorSoftwareProductErrorCodes.HEAT_PACKAGE_FILE_CREATION;


/**
 * Created by Talio on 11/24/2016.
 */
public class InformationArtifactCreationErrorBuilder {
  private static final String INFO_ARTIFACT_FILE_CREATION_ERROR_MSG =
      "Error while trying to information artifact file for vendor software product with Id %s.";
  private final ErrorCode.ErrorCodeBuilder builder = new ErrorCode.ErrorCodeBuilder();

  public InformationArtifactCreationErrorBuilder(String vendorSoftwareProductId) {
    builder.withId(HEAT_PACKAGE_FILE_CREATION);
    builder.withCategory(ErrorCategory.SYSTEM);
    builder
        .withMessage(String.format(INFO_ARTIFACT_FILE_CREATION_ERROR_MSG, vendorSoftwareProductId));
  }

  public ErrorCode build() {
    return builder.build();
  }
}