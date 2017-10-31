/*
 * Copyright (C) 2017 Didi
 *  
 *  
 * 
 * This script is firstly created at 2017-10-31.
 * 
 * To see more infomation,
 *    visit our official website http://home.didichuxing.com/.
 */
package site.jiaojie.test.thrift.demo;

import org.apache.thrift.TException;

/**
 *
 * @author jiaojie <jiaojie@didichuxing.com thomasjiao@vip.qq.com>
 */
public class HelloWorldImpl implements HelloWorldService.Iface {

    public HelloWorldImpl() {
    }

    @Override
    public String sayHello(String username) throws TException {
        String output = "hello, " + username;
        System.out.println(output);
        return output;
    }

}
