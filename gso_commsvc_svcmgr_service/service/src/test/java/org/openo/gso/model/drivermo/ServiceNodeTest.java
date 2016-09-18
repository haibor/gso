/*
 * Copyright 2016 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openo.gso.model.drivermo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class ServiceNodeTest {

    ServiceNode node = new ServiceNode();
    @Test
    public void testGetNodeType() {
        node.getNodeType();
    }

    @Test
    public void testSetNodeType() {
        node.setNodeType("vnf");
    }

    @Test
    public void testGetStNodeParam() {
        node.getInputParameters();
    }

    @Test
    public void testSetStNodeParam() {
        Map<String, String> map = new HashMap<String, String>();
        node.setInputParameters(map);
    }

}
