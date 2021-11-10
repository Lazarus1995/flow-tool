package com.sinoiov.zczhgl.flowable.service;

import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.engine.*;
import org.flowable.validation.ProcessValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 注入flowable engine的service。flowable框架主要通过以下service进行控制
 * @author: qu
 * @date: 2021.05.19.15:40
 */

@Component
public class FlowService {
    @Resource
    protected RepositoryService repositoryService;

    @Resource
    protected RuntimeService runtimeService;

    @Resource
    protected IdentityService identityService;

    @Resource
    protected TaskService taskService;

//    @Resource
//    protected FormService formService;

    @Resource
    protected HistoryService historyService;

    @Resource
    protected ManagementService managementService;

//    @Autowired
//    protected ModelService modelService;



//    @Resource
//    protected ProcessValidatorFactory processValidatorFactory;

    @Qualifier("processEngine")
    @Resource
    protected ProcessEngine processEngine;
}
