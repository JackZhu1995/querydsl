/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.types;

/**
 * @author tiwe
 */
public class ConstantImpl<T> extends ExpressionBase<T> implements Constant<T> {

    // TODO : add cacheing for Numbers & Strings
    
    private static final long serialVersionUID = -3898138057967814118L;

    private final T constant;
    
    @SuppressWarnings("unchecked")
    public ConstantImpl(T constant){
        super((Class)constant.getClass());
        this.constant = constant;
    }
    
    @Override
    public T getConstant() {
        return constant;
    }

    @Override
    public <R, C> R accept(Visitor<R, C> v, C context) {
        return v.visit(this, context);
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }else if (o instanceof Constant<?>){
            return ((Constant<?>)o).getConstant().equals(constant);
        }else{
            return false;
        }
    }
    
    public int hashCode(){
        return constant.hashCode();
    }

}
