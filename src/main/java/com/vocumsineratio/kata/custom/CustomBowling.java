/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */
package com.vocumsineratio.kata.custom;

import com.vocumsineratio.kata.framework.api.BowlingGame;
import com.vocumsineratio.kata.framework.api.Bowling;

/**
 * @author Danil Suits (danil@vast.com)
 */
public class CustomBowling implements Bowling<CustomBowlingGame> {
    @Override
    public CustomBowlingGame game() {
        return new CustomBowlingGame();
    }

    @Override
    public void release(CustomBowlingGame game) {
        // NoOp
    }
}
