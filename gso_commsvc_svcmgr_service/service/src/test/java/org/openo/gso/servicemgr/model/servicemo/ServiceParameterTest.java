/*
 * Copyright (c) 2016, Huawei Technologies Co., Ltd.
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

package org.openo.gso.servicemgr.model.servicemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test ServiceParameter.<br/>
 * <p>
 * </p>
 * 
 * @author
 * @version GSO 0.5 2016/8/31
 */
public class ServiceParameterTest {

    @Test
    public void test() {
        ServiceParameter model = new ServiceParameter();
        model.setName("name");
        model.setServiceId("serviceId");
        model.setType("type");
        model.setValue("value");

        Assert.assertNotNull(model.getName());
        Assert.assertNotNull(model.getServiceId());
        Assert.assertNotNull(model.getType());
        Assert.assertNotNull(model.getValue());
    }

}
