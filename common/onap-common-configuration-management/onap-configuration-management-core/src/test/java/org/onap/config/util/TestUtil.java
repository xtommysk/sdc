/*
 * Copyright © 2016-2018 European Support Limited
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

package org.onap.config.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.onap.config.api.Configuration;
import org.onap.config.api.ConfigurationManager;

/**
 * Created by sheetalm on 10/13/2016.
 */
public class TestUtil {

    public final static String jsonSchemaLoc = System.getProperty("user.home")+"/TestResources/";
    public static FileWriter fileWriter ;

    public static void writeFile(String data) throws IOException {
        File dir = new File(jsonSchemaLoc);
        dir.mkdirs();
        File file = new File(jsonSchemaLoc+"/GeneratorsList.json");
        file.createNewFile();
        fileWriter = new FileWriter(file);
        fileWriter.write(data);
        fileWriter.close();
    }

    public static void cleanUp() throws Exception {
        String data = "{name:\"SCM\"}";
        TestUtil.writeFile(data);
    }

    public static void validateConfiguraton(String nameSpace) {
        Configuration config = ConfigurationManager.lookup();

        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_NAME_MAXLENGTH ), "14");

        // First value from list is picked from Merge properties
        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_MAXSIZE ), "1048576");

        List<String> expectedExtList = new ArrayList<String>();
        expectedExtList.add("pdf");
        expectedExtList.add("zip");
        expectedExtList.add("xml");
        expectedExtList.add("pdf");
        expectedExtList.add("tgz");
        expectedExtList.add("xls");
        List<String> extList = config.getAsStringValues(nameSpace, ConfigTestConstant.ARTIFACT_EXT);
        Assert.assertEquals(expectedExtList, extList);

        List<String> expectedEncList = new ArrayList<String>();
        expectedEncList.add("Base64");
        expectedEncList.add("MD5");
        List<String> encList = config.getAsStringValues(nameSpace, ConfigTestConstant.ARTIFACT_ENC);
        Assert.assertEquals(expectedEncList, encList);

        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_NAME_UPPER ), "a-zA-Z_0-9");
        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_NAME_LOWER ), "a-zA-Z");
        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_STATUS ), "deleted");

        List<String> expectedLocList = new ArrayList<String>();
        expectedLocList.add("/opt/spool");
        expectedLocList.add(System.getProperty("user.home")+"/asdc");
        List<String> locList = config.getAsStringValues(nameSpace, ConfigTestConstant.ARTIFACT_LOC);
        Assert.assertEquals(expectedLocList, locList);

        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_JSON_SCHEMA ), "@GeneratorList.json");

        Assert.assertEquals("@"+getenv(ConfigTestConstant.PATH)+"/myschema.json",config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_XML_SCHEMA));

        List<String> artifactConsumer = config.getAsStringValues(nameSpace, ConfigTestConstant.ARTIFACT_CONSUMER );
        Assert.assertEquals(config.getAsStringValues(nameSpace, ConfigTestConstant.ARTIFACT_CONSUMER_APPC ), artifactConsumer);

        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_NAME_MINLENGTH ), "6");
        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_MANDATORY_NAME ), "true");
        Assert.assertEquals(config.getAsString(nameSpace, ConfigTestConstant.ARTIFACT_ENCODED ), "true");
    }

    /**
     * This to make the behavior of tests consistent with "env:X" in configuration files
     * when environment variable X is not defined.
     */
    public static String getenv(String name) {
        String value = System.getenv(name);
        return value == null ? "" : value;
    }
}
