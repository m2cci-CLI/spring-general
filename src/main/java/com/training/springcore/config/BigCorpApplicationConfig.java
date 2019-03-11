package com.training.springcore.config;

import com.training.springcore.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Set;

@ComponentScan("com.training.springcore")
@Configuration
@EnableAspectJAutoProxy
public class BigCorpApplicationConfig {


}
