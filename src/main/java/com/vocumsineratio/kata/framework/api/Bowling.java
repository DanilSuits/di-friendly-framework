package com.vocumsineratio.kata.framework.api;

/**
 * @author Danil Suits (danil@vast.com)
 */
public interface Bowling<T extends BowlingGame> {
    T game();

    void release(T game);
}
