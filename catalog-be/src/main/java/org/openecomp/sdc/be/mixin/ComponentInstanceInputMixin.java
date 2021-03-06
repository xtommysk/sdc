/*-
 * ============LICENSE_START=======================================================
 * SDC
 * ================================================================================
 * Copyright (C) 2020 AT&T Intellectual Property. All rights reserved.
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

package org.openecomp.sdc.be.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openecomp.sdc.be.datatypes.elements.PropertyRule;
import org.openecomp.sdc.be.model.ComponentInstanceInput;
import org.openecomp.sdc.be.view.MixinTarget;

import java.util.List;

@MixinTarget(target = ComponentInstanceInput.class)
public abstract class ComponentInstanceInputMixin extends InputDefinitionMixin{
    @JsonProperty
    abstract String getComponentInstanceId();
    @JsonProperty
    abstract String getComponentInstanceName();
    @JsonProperty
    abstract List<String> getPath();
    @JsonProperty
    abstract List<PropertyRule> getRules();
    @JsonProperty
    abstract String getValueUniqueUid();
}
