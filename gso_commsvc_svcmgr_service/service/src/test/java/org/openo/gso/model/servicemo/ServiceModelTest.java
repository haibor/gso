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

package org.openo.gso.model.servicemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openo.gso.model.servicemo.ServiceModel;
import org.openo.gso.model.servicemo.ServicePackageMapping;
import org.openo.gso.model.servicemo.ServiceParameter;

/**
 * <br/>
 * <p>
 * </p>
 * 
 * @author
 * @version GSO 0.5 2016/8/3
 */
public class ServiceModelTest {

    @Test
    public void test() {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setServiceId("2");
        serviceModel.setName("testSucceed");
        serviceModel.setDescription("des");
        serviceModel.setActiveStatus("active");
        serviceModel.setStatus("createdSucceed");
        serviceModel.setCreator("tester");
        serviceModel.setCreateAt(Long.valueOf(123456));
        ServiceParameter parameter = new ServiceParameter();
        List<ServiceParameter> lstParam = new LinkedList<ServiceParameter>();
        lstParam.add(parameter);
        serviceModel.setParameters(lstParam);

        ServicePackageMapping servicePackage = new ServicePackageMapping();
        servicePackage.setServiceDefId("12345");
        servicePackage.setServiceId("2");
        servicePackage.setTemplateId("123456");
        servicePackage.setTemplateName("gso");
        serviceModel.setServicePackage(servicePackage);

        assertEquals("2", serviceModel.getServiceId());
        assertEquals("testSucceed", serviceModel.getName());
        assertEquals("des", serviceModel.getDescription());
        assertEquals("active", serviceModel.getActiveStatus());
        assertEquals("createdSucceed", serviceModel.getStatus());
        assertEquals("tester", serviceModel.getCreator());
        assertEquals(String.valueOf(123456), String.valueOf(serviceModel.getCreateAt()));

        assertTrue(serviceModel.getServicePackage().equals(servicePackage));
        Assert.assertNotNull(serviceModel.getParameters());
    }

}
