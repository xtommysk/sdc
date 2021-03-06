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

package org.openecomp.sdc.be.resources.data.auditing.model;

public class DistributionTopicData {
    private String statusTopic;
    private String notificationTopic;

    private DistributionTopicData() {
    }

    public String getStatusTopic() {
        return statusTopic;
    }

    public String getNotificationTopic() {
        return notificationTopic;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private final DistributionTopicData instance;

        public Builder() {
            instance = new DistributionTopicData();
        }

        public Builder statusTopic(String statusTopic) {
            this.instance.statusTopic = statusTopic;
            return this;
        }

        public Builder notificationTopic(String notificationTopic) {
            this.instance.notificationTopic = notificationTopic;
            return this;
        }

        public DistributionTopicData build() {
            return instance;
        }

    }
}
