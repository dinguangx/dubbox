/**
 * Copyright 1999-2014 dangdang.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.rpc.protocol.rest;

import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResourceFactory;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * We don't support propertyInjector here since the resource impl should be singleton in dubbo
 *
 * @author lishen
 */
public class DubboResourceFactory implements ResourceFactory {

    private Object resourceInstance;
    private Class scannableClass;
//    private PropertyInjector propertyInjector;
//    private String context = null;

    public DubboResourceFactory(Object resourceInstance, Class scannableClass) {
        this.resourceInstance = resourceInstance;
        this.scannableClass = scannableClass;
    }

//    public PropertyInjector getPropertyInjector() {
//        return propertyInjector;
//    }

    public Object createResource(HttpRequest request, HttpResponse response,
                                 ResteasyProviderFactory factory) {
        return resourceInstance;
    }

    public Class<?> getScannableClass() {
        return scannableClass;
    }

    public void registered(ResteasyProviderFactory factory) {
//        this.propertyInjector = factory.getInjectorFactory().createPropertyInjector(getScannableClass(), factory);
    }

    public void requestFinished(HttpRequest request, HttpResponse response,
                                Object resource) {
    }

    public void unregistered() {
    }

//    public void setContext(String context) {
//        this.context = context;
//    }
//
//    public String getContext() {
//        return context;
//    }
}