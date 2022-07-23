package com.wp.springbootactivity;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootActivityApplicationTests {

    @Autowired
    private RepositoryService repositoryService;


    /**
     * 通过npm部署流程
     */
    @Test
    public void initDeploymentBpmn(){
        String fileName = "bpmn/task_1.bpmn";
        Deployment testDeployment = repositoryService.createDeployment()
                .addClasspathResource(fileName)
                .name("测试流程部署")
                .deploy();
        System.out.println(testDeployment.getName());
    }


    public void getDeployments(){
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        if(list.size()>0){
            for (Deployment deployment : list) {
                System.out.println(deployment.getId());
                System.out.println(deployment.getName());
                System.out.println(deployment.getDeploymentTime());
                System.out.println(deployment.getKey());
                System.out.println(deployment.getTenantId());
            }
        }
    }

}
