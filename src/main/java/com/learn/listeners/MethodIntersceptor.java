package com.learn.listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import utility.ExcelDataUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodIntersceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {


        List<Map<String, String>> excellist = ExcelDataUtils.readExceldata("Run");
        List<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i < methods.size(); i++) {

            for (int j = 0; j < excellist.size(); j++) {


                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(excellist.get(j).get("TestcaseName")) && excellist.get(j).get("Execute").equalsIgnoreCase("Yes")) {
                  //  methods.get(i).getMethod().setInvocationCount(Integer.parseInt(excellist.get(j).get("InvocationCount")));
                    result.add(methods.get(i));
                }


            }
        }



        return result;
    }
}
