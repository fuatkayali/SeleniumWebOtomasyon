/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprojesiv2;

import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;		

public class TestBasla {				
			public static void main(String[] args) {									
            Result result = JUnitCore.runClasses(TestIcerik.class);					
			for (Failure failure : result.getFailures()) {							
              System.out.println(failure.toString());					
      }		
      System.out.println("Result=="+result.wasSuccessful());							
   }		
}      

