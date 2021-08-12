package com.fundamentosspf.fundamentos.bean;

public class MyBeenWithDependencyImplement implements  MyBeenWithDependency{
    private MyOperation myOperation;

    public MyBeenWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementtacion de un bean con dependencia");
    }
}
