/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openo.gso.restproxy.impl;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.openo.baseservice.roa.util.restclient.RestfulResponse;
import org.openo.gso.commsvc.common.Exception.ApplicationException;
import org.openo.gso.exception.HttpCode;
import org.openo.gso.util.http.HttpUtil;

import mockit.Mock;
import mockit.MockUp;

/**
 * <br/>
 * <p>
 * </p>
 * 
 * @author
 * @version GSO 0.5 2016/8/31
 */
public class WorkflowProxyImplTest {

    @Test
    public void test() throws ApplicationException {
        WorkflowProxyImpl proxy = new WorkflowProxyImpl();
        new MockUp<HttpUtil>() {

            @Mock
            public RestfulResponse post(final String url, Object sendObj, HttpServletRequest httpRequest)
                    throws ApplicationException {
                RestfulResponse response = new RestfulResponse();
                response.setStatus(HttpCode.RESPOND_OK);
                response.setResponseJson("responseString");
                return response;
            }
        };
        proxy.startWorkFlow("sendBody", null);
    }

}
