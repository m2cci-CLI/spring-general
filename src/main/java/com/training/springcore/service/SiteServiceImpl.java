package com.training.springcore.service;

import com.training.springcore.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Service("siteService")
@Component
public class SiteServiceImpl  implements SiteService{

    private CaptorService captorService;

    @Autowired
    private ResourceLoader resourceLoader;

    public SiteServiceImpl(){

    }


    @Autowired
    public SiteServiceImpl(CaptorService captorService){
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
    }

    @Override
    @Monitored
    public Site findById(String siteId) {
        System.out.println("Appel de findById :" + this);
        if (siteId == null) {
            return null;
        }

        Site site = new Site("capteur de position");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }

    @Override
    public void readFile(String path){
        Resource resource = resourceLoader.getResource(path);

        try(InputStream stream = resource.getInputStream()){
            Scanner scan = new Scanner(stream).useDelimiter("\\n");
            while(scan.hasNext()){
                System.out.println(scan.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
