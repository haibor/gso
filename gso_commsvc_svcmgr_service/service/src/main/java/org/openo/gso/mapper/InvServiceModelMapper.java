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

package org.openo.gso.mapper;

import org.apache.ibatis.annotations.Param;
import org.openo.gso.model.servicemo.InvServiceModel;

/**
 * Mapping Class of inventory data operation.<br/>
 * <p>
 * </p>
 * 
 * @author
 * @version GSO 0.5 2016/9/19
 */
public interface InvServiceModelMapper extends InventoryMapper {

    /**
     * Insert service instance.<br/>
     * 
     * @param serviceModel service instance.
     * @since GSO 0.5
     */
    void insert(InvServiceModel serviceModel);

    /**
     * Delete service instance by service ID.<br/>
     * 
     * @param serviceId service ID
     * @since GSO 0.5
     */
    void delete(@Param("serviceId") String serviceId);
}
