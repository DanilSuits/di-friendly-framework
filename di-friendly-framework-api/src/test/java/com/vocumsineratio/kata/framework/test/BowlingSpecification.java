/**
 * Copyright Vast 2018. All Rights Reserved.
 * <p/>
 * http://www.vast.com
 */
package com.vocumsineratio.kata.framework.test;

import com.vocumsineratio.kata.framework.api.Bowling;
import com.vocumsineratio.kata.framework.api.BowlingGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Danil Suits (danil@vast.com)
 */
public abstract class BowlingSpecification {
    private final Class<? extends Bowling> bowling;

    protected BowlingSpecification(Class<? extends Bowling> bowling) {
        this.bowling = bowling;
    }

    private final Bowling bowling() {
        return Framework.module(bowling);
    }

    @Test
    public final void simpleBowlingTest() {
        Bowling bowling = bowling();

        BowlingGame game = bowling.game();
        int score = game.score(1, 2, 3);
        bowling.release(game);

        Assertions.assertTrue(score >= 0);
    }

    @Test
    public final void wrappedBowlingTest() {
        class Handle implements AutoCloseable {
            final Bowling bowling;
            final BowlingGame game;

            Handle(Bowling bowling, BowlingGame game) {
                this.bowling = bowling;
                this.game = game;
            }

            @Override
            public void close() {
                bowling.release(game);
            }
        }

        Bowling bowling = bowling();

        BowlingGame game = bowling.game();

        try (Handle handle = new Handle(bowling, game)) {
            int score = game.score(1, 2, 3);
            Assertions.assertTrue(score >= 0);
        }
    }

    @Test
    public final void decoratedBowlingTest() {
        class Decorator implements BowlingGame, AutoCloseable {
            final Bowling bowling;
            final BowlingGame game;

            Decorator(Bowling bowling, BowlingGame game) {
                this.bowling = bowling;
                this.game = game;
            }

            @Override
            public int score(int... rolls) {
                return game.score(rolls);
            }

            @Override
            public void close() {
                bowling.release(game);
            }
        }

        Bowling bowling = bowling();
        try (Decorator game = new Decorator(bowling, bowling.game())) {
            int score = game.score(1, 2, 3);
            Assertions.assertTrue(score >= 0);
        }
    }

    @Test
    public final void alternativeBowlingTest() {
        Bowling bowling = bowling();

        BowlingGame game = bowling.game();
        int score = game.score(1, 2, 3);
        bowling.release(game);

        Assertions.assertTrue(score >= 0);
    }
}
