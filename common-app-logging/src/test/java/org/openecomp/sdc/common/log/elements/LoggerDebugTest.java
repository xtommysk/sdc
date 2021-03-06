package org.openecomp.sdc.common.log.elements;

/**
 * Created by dd4296 on 12/25/2017.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.onap.logging.ref.slf4j.ONAPLogConstants;
import org.openecomp.sdc.common.log.enums.LogLevel;
import org.openecomp.sdc.common.log.utils.LoggingThreadLocalsHolder;
import org.slf4j.Logger;
import org.slf4j.MDC;

import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.onap.logging.ref.slf4j.ONAPLogConstants.MDCs.RESPONSE_STATUS_CODE;
import static org.openecomp.sdc.common.log.api.ILogConfiguration.*;

@RunWith(MockitoJUnitRunner.class)
public class LoggerDebugTest {

    @Mock
    private Logger logger;

    private LoggerDebug debugLog;

     @Before
    public void init() {
        debugLog = new LoggerDebug(LogFieldsMdcHandler.getInstance(), logger);
        LoggingThreadLocalsHolder.setUuid(null);
        MDC.clear();
    }

    @Test
    public void whenNoFieldsIsPopulated_RequestedMdcFieldsAreEmpty() {
        debugLog.clear()
                .log(LogLevel.DEBUG, "some error code");
        assertNull(MDC.get(ONAPLogConstants.MDCs.REQUEST_ID));
    }

    @Test
    public void debugLogCheckValidationValidFieldsTest() {
        debugLog.clear()
                .startTimer()
                .setKeyRequestId("uuid")
                .log(LogLevel.DEBUG, "some error code");

        assertEquals(MDC.get(ONAPLogConstants.MDCs.REQUEST_ID), "uuid");
    }

    @Test
    public void whenOnlyDebugUUIDFieldsIsPopulated_ShouldReturnAssertTrue_onUUIDFieldCheck() {
        debugLog.clear()
                .setKeyRequestId("uuid")
                .log(LogLevel.DEBUG, "some error code");

        assertEquals("uuid", MDC.get(ONAPLogConstants.MDCs.REQUEST_ID));
    }

    @Test
    public void whenAllDebugFieldsArePopulated_ShouldReturnAssertTrue_onEachMACFieldCheck() throws UnknownHostException {
        debugLog.clear()
                .startTimer()
                .setKeyRequestId(ONAPLogConstants.MDCs.REQUEST_ID)
                .log(LogLevel.DEBUG, "some message");

        Assert.assertTrue(LogFieldsMdcHandler.getInstance().isMDCParamEmpty(MDC_END_TIMESTAMP));
        Assert.assertTrue(LogFieldsMdcHandler.getInstance().isMDCParamEmpty(MDC_ELAPSED_TIME));
        Assert.assertTrue(LogFieldsMdcHandler.getInstance().isMDCParamEmpty(RESPONSE_STATUS_CODE));
    }


    @Test
    public void validateMandatoryFields(){
        assertEquals(ONAPLogConstants.MDCs.REQUEST_ID, debugLog.checkMandatoryFieldsExistInMDC().trim());
    }

    @Test
    public void validateMandatoryFieldsWhenFieldIsSet(){
        debugLog.clear()
                .setKeyRequestId("1234");
        assertEquals("", debugLog.checkMandatoryFieldsExistInMDC());
    }
}
