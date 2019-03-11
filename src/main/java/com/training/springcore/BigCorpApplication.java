package com.training.springcore;

import com.training.springcore.config.BigCorpApplicationConfig;
import com.training.springcore.model.ApplicationInfo;
import com.training.springcore.service.SiteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class BigCorpApplication {


    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();application.run();
    }

    public void run(){

        ApplicationContext context = new AnnotationConfigApplicationContext(BigCorpApplicationConfig.class);

        ApplicationInfo applicationInfo = (ApplicationInfo) context.getBean(ApplicationInfo.class);
        System.out.println(applicationInfo.toString()+"\n");

        SiteService siteService = (SiteService) context.getBean("siteService");
        System.out.println(siteService.findById("siteA"));
        siteService = (SiteService) context.getBean("siteService");
        System.out.println(siteService.findById("siteA"));


    }
}
