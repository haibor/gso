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

package org.openo.gso.servicemgr.restproxy.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.type.TypeReference;
import org.openo.baseservice.remoteservice.exception.ServiceException;
import org.openo.baseservice.roa.util.restclient.RestfulResponse;
import org.openo.gso.servicemgr.model.catalogmo.OperationModel;
import org.openo.gso.servicemgr.model.catalogmo.ParameterModel;
import org.openo.gso.servicemgr.model.catalogmo.ServiceTemplateModel;
import org.openo.gso.servicemgr.restproxy.inf.ICatalogProxy;
import org.openo.gso.servicemgr.util.http.HttpUtil;
import org.openo.gso.servicemgr.util.http.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implement class of calling catalog rest interface.<br/>
 * <p>
 * </p>
 * 
 * @author
 * @version GSO 0.5 2016/8/12
 */
public class CatalogProxyImpl implements ICatalogProxy {

    /**
     * Log serve.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogProxyImpl.class);

    /**
     * Uri prefix of rest interface.
     */
    private static final String CATALOG_REST_URI_SERVICETEMPALTE = "/openoapi/catalog/v1/servicetemplates/";

    /**
     * Uri prefix of rest interface.
     */
    private static final String CATALOG_REST_URI_CSAR = "/openoapi/catalog/v1/csars/";

    /**
     * Operations field of uri.
     */
    private static final String URI_PATH_OPERATIONS = "operations";

    /**
     * parameters field of uri.
     */
    private static final String URI_PATH_PARAMETERS = "parameters";

    /**
     * nesting field of uri.
     */
    private static final String URI_PATH_NESTING = "nesting";

    /**
     * Identify for querying condition by node type.
     */
    private static final String URI_PATH_QUERYING_NODETYPEDS = "nodeTypeIds";

    /**
     * Forward flash in uri.
     */
    private static final String FORWARD_FLASH = "/";

    /**
     * Identify of input parameters.
     */
    private static final String TEMPLATE_INPUTS = "inputs";

    /**
     * package state.
     */
    private static final String PACKAGE_STATE_ONBOARDED = "onBoarded";

    /**
     * condition
     */
    private static final String URI_PATH_QUERY_ONBOARDSTATE = "onBoardState";

    /**
     * Query input parameters of service template.<br/>
     * 
     * @param templateId id of service template
     * @return input parameters
     * @throws ServiceException when catalog fails to query data.
     * @since GSO 0.5
     */
    /**
     * <br/>
     * 
     * @param templateId
     * @param request
     * @return
     * @throws ServiceException
     * @since GSO 0.5
     */
    @Override
    public List<ParameterModel> getParamsByTemplateId(String templateId, HttpServletRequest request)
            throws ServiceException {
        LOGGER.info("Get input parameters from catalog.");
        String url = new StringBuilder().append(CATALOG_REST_URI_SERVICETEMPALTE).append(templateId)
                .append(FORWARD_FLASH).append(URI_PATH_PARAMETERS).toString();

        Map<String, String> httpHeaders = new HashMap<String, String>();
        RestfulResponse response = HttpUtil.get(url, httpHeaders, request);
        ResponseUtils.checkResonseAndThrowException(response, "query parameters of service template.");

        return ResponseUtils.getDataModelFromRsp(response.getResponseContent(), TEMPLATE_INPUTS, ParameterModel.class);
    }

    /**
     * Query operation list of service template.<br/>
     * 
     * @param templateId id of service template.
     * @return operations
     * @throws ServiceException when catalog fails to query data.
     * @since GSO 0.5
     */
    @Override
    public List<OperationModel> getOperationsByTemplateId(String templateId, HttpServletRequest request)
            throws ServiceException {
        LOGGER.info("Get list of operations from catalog.");
        String url = new StringBuilder().append(CATALOG_REST_URI_SERVICETEMPALTE).append(templateId)
                .append(FORWARD_FLASH).append(URI_PATH_OPERATIONS).toString();

        Map<String, String> httpHeaders = new HashMap<String, String>();
        RestfulResponse response = HttpUtil.get(url, httpHeaders, request);
        ResponseUtils.checkResonseAndThrowException(response, "query operation list of service template.");

        return ResponseUtils.getDataModelFromRspList(response.getResponseContent(),
                new TypeReference<List<OperationModel>>() {});
    }

    /**
     * Query nesting service template.<br/>
     * 
     * @param nodeTypeId id of node type
     * @return service template data
     * @throws ServiceException when catalog fails to query data.
     * @since GSO 0.5
     */
    @Override
    public List<ServiceTemplateModel> getTemplateByNodeTypeId(String nodeTypeId, HttpServletRequest request)
            throws ServiceException {
        LOGGER.info("Get basic information of template by node type ID.");
        String url = new StringBuilder().append(CATALOG_REST_URI_SERVICETEMPALTE).append(URI_PATH_NESTING).toString();
        Map<String, String> httpHeaders = new HashMap<String, String>();
        httpHeaders.put(URI_PATH_QUERYING_NODETYPEDS, nodeTypeId);
        RestfulResponse response = HttpUtil.get(url, httpHeaders, request);
        ResponseUtils.checkResonseAndThrowException(response, "query service tempalte.");

        return ResponseUtils.getDataModelFromRspList(response.getResponseContent(),
                new TypeReference<List<ServiceTemplateModel>>() {});
    }

    /**
     * Delete GSAR package by ID.<br/>
     * 
     * @param csarId package ID
     * @param request http request
     * @throws ServiceException when fail to delete
     * @since GSO 0.5
     */
    @Override
    public void deleteGsarPackage(String csarId, HttpServletRequest request) throws ServiceException {
        LOGGER.info("Delete GSAR package.");
        String url = new StringBuilder().append(CATALOG_REST_URI_CSAR).append(csarId).toString();
        RestfulResponse response = HttpUtil.delete(url, request);
        ResponseUtils.checkResonseAndThrowException(response, "delete csar pacakge.");
    }

    /**
     * Update GSAR onBoard status.<br/>
     * 
     * @param csarId package ID
     * @param request http request
     * @throws ServiceException when fail to update
     * @since GSO 0.5
     */
    @Override
    public void updateGsarStatus(String csarId, HttpServletRequest request) throws ServiceException {
        LOGGER.info("Set GSAR status.");
        String url = new StringBuilder().append(CATALOG_REST_URI_CSAR).append(csarId).toString();
        Map<String, String> httpHeaders = new HashMap<String, String>();
        httpHeaders.put(URI_PATH_QUERY_ONBOARDSTATE, PACKAGE_STATE_ONBOARDED);
        RestfulResponse response = HttpUtil.put(url, httpHeaders, request);
        ResponseUtils.checkResonseAndThrowException(response, "update csar package state.");
    }
}
