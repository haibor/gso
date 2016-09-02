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

package org.openo.gso.servicemgr.util.validate;

import java.util.List;
import java.util.Map;

import org.openo.baseservice.remoteservice.exception.ServiceException;
import org.openo.gso.servicemgr.exception.ErrorCode;
import org.openo.gso.servicemgr.exception.HttpCode;
import org.openo.gso.servicemgr.model.catalogmo.ParameterModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * <br/>
 * <p>
 * </p>
 * 
 * @author
 * @version GSO 0.5 2016/8/19
 */
public class ValidateUtil {

    /**
     * Log server.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateUtil.class);

    /**
     * Constructor<br/>
     * <p>
     * </p>
     * 
     * @since GSO 0.5
     */
    private ValidateUtil() {

    }

    /**
     * Assert String parameter.<br/>
     * 
     * @param param parameter data
     * @throws ServiceException when parameter is null or empty.
     * @since GSO 0.5
     */
    public static void assertStringNotNull(String param) throws ServiceException {
        if(StringUtils.hasLength(param)) {
            return;
        }

        LOGGER.error("Parameter is null or empty.");
        throw new ServiceException(ErrorCode.SVCMGR_SERVICEMGR_BAD_PARAM, HttpCode.BAD_REQUEST);
    }

    /**
     * Assert object is null.<br/>
     * 
     * @param object data object
     * @throws ServiceException when object is null.
     * @since GSO 0.5
     */
    public static void assertObjectNotNull(Object object) throws ServiceException {
        if(null == object) {
            LOGGER.error("Object is null.");
            throw new ServiceException(ErrorCode.SVCMGR_SERVICEMGR_BAD_PARAM, "Object is null.");
        }

    }

    /**
     * Validate whether parameter is fit with definition.<br/>
     * 
     * @param defineParams parameters which are defined in catalog
     * @param inputParams parameters which are from GUI
     * @throws ServiceException when parameter is not fit with definition
     * @since GSO 0.5
     */
    @SuppressWarnings("unchecked")
    public static void validate(List<ParameterModel> defineParams, Object inputParams) throws ServiceException {
        if(!(inputParams instanceof Map)) {
            LOGGER.error("The format of input parameters is wrong.");
            throw new ServiceException(ErrorCode.SVCMGR_SERVICEMGR_BAD_PARAM,
                    "The format of input parameters is wrong.");
        }

        // todo
    }
}
