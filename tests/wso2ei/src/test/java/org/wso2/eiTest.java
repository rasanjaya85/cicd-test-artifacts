/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2;

/********** Test class for EI ***********/

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

///**
// * This class tests the HelloWorld Rest endpoint
// */
//
public class eiTest {
    @Test public void testEndpoint() throws InterruptedException {
        HttpClient client = new HttpClient();
        String deployedAPI = "/helloworld";
        int statusCode = -1;
        String uri = System.getProperty("endpoint") + deployedAPI;
        System.out.println(uri);
        TimeUnit.MINUTES.sleep(5);
        HttpMethod method = new GetMethod(uri);
        try {
            statusCode = client.executeMethod(method);
        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e){
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }
}