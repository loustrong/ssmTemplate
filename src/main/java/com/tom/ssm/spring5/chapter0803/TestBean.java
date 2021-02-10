package com.tom.ssm.spring5.chapter0803;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * @descriptions: TestBean
 * @author: Tom
 * @date: 2021/2/9 上午 09:54
 * @version: 1.0
 */
public class TestBean implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("execute the setResourceLoader method.");
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader(){
        return this.resourceLoader;
    }
}
