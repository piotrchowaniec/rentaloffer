package com.microservices.rentaloffer;

/**
 * @author <a href="mailto:piotr.chowaniec@fingo.info">FINGO - Piotr Chowaniec</a>
 */
public class Solution {

    public Solution( String advice ) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "Solution [advice=" + advice + "]";
    }

    private String advice;

}
