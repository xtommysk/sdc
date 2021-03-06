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

package org.openecomp.conflicts.types;

import org.openecomp.sdc.versioning.dao.types.Version;

import java.util.ArrayList;
import java.util.Collection;

public class ItemVersionConflict {
  private Conflict<Version> versionConflict;
  private Collection<ConflictInfo> elementConflicts = new ArrayList<>();

  public Conflict<Version> getVersionConflict() {
    return versionConflict;
  }

  public void setVersionConflict(Conflict<Version> versionConflict) {
    this.versionConflict = versionConflict;
  }

  public Collection<ConflictInfo> getElementConflicts() {
    return elementConflicts;
  }

  public void setElementConflicts(Collection<ConflictInfo> elementConflicts) {
    this.elementConflicts = elementConflicts;
  }

  public void addElementConflictInfo(ConflictInfo conflictInfo) {
    elementConflicts.add(conflictInfo);
  }
}
