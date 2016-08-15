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

package org.openo.gso.servicemgr.dao.inf;

import java.util.List;

import org.openo.baseservice.remoteservice.exception.ServiceException;
import org.openo.gso.servicemgr.model.servicemo.ServicePackageMapping;

/**
 * Interface to operate database.<br/>
 * <p>
 * </p>
 * 
 * @author
 * @version GSO 0.5 2016/8/4
 */
public interface IServicePackageDao {

    /**
     * Insert relation instance.<br/>
     * 
     * @param packageMapping service package mapping data
     * @throws ServiceException when database exception or parameter is wrong
     * @since GSO 0.5
     */
    void insert(ServicePackageMapping packageMapping) throws ServiceException;

    /**
     * Delete relation instance by service ID.<br/>
     * 
     * @param serviceId service ID
     * @throws ServiceException when database exception or parameter is wrong
     * @since GSO 0.5
     */
    void delete(String serviceId) throws ServiceException;

    /**
     * Query all relation instances.<br/>
     * 
     * @return service instances
     * @throws ServiceException when database exception
     * @since GSO 0.5
     */
    List<ServicePackageMapping> queryAllMappings() throws ServiceException;
}
