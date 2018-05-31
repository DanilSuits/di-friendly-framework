/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */
package com.vocumsineratio.kata.custom;

import com.vocumsineratio.kata.framework.api.BowlingGame;

/**
 * @author Danil Suits (danil@vast.com)
 */
class CustomBowlingGame implements BowlingGame {
    @Override
    public int score(int... rolls) {
        // https://xkcd.com/221/
        return 4;
    }
}
