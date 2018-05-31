/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */
package com.vocumsineratio.kata.framework.test;

/**
 * @author Danil Suits (danil@vast.com)
 */
public abstract class Framework {
    public static <Z> Z module(Class<Z> impl) {
        try {
            return impl.newInstance();
        } catch (InstantiationException e) {
            throw new AssertionError(e);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
