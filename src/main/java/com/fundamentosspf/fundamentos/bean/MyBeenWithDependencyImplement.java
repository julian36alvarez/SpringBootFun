package com.fundamentosspf.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeenWithDependencyImplement implements  MyBeenWithDependency{
    private MyOperation myOperation;
    Log LOGGER = LogFactory.getLog(MyBeenWithDependencyImplement.class);

    public MyBeenWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("we are in printWithDependency");
        int numero = 1;
        LOGGER.debug("the number send with parameter to dpendency is:" + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementtacion de un bean con dependencia");
    }
}
