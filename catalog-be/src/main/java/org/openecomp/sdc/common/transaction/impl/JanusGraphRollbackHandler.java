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

package org.openecomp.sdc.common.transaction.impl;

import org.openecomp.sdc.be.dao.janusgraph.JanusGraphGenericDao;
import org.openecomp.sdc.be.dao.janusgraph.JanusGraphOperationStatus;
import org.openecomp.sdc.common.transaction.api.RollbackHandler;
import org.openecomp.sdc.common.transaction.api.TransactionUtils.DBActionCodeEnum;
import org.openecomp.sdc.common.transaction.api.TransactionUtils.DBTypeEnum;

public class JanusGraphRollbackHandler extends RollbackHandler {

    private JanusGraphGenericDao janusGraphGenericDao;

    public JanusGraphRollbackHandler(Integer transactionId, String userId, String actionType, JanusGraphGenericDao janusGraphGenericDao) {
        super(transactionId, userId, actionType);
        this.janusGraphGenericDao = janusGraphGenericDao;
    }

    public DBTypeEnum getDBType() {
        return DBTypeEnum.JANUSGRAPH;
    }

    protected boolean isRollbackForPersistenceData() {
        return false;
    }

    public DBActionCodeEnum doNonPersistenceDataRollback() {
        DBActionCodeEnum result = DBActionCodeEnum.SUCCESS;
        JanusGraphOperationStatus janusGraphStatus = janusGraphGenericDao.rollback();
        if (janusGraphStatus != JanusGraphOperationStatus.OK) {
            result = DBActionCodeEnum.FAIL_GENERAL;
        }
        return result;
    }

}