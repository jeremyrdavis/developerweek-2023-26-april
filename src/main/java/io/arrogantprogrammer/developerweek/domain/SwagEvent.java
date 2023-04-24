package io.arrogantprogrammer.developerweek.domain;

public class SwagEvent{

    String tShirtSize;

    public SwagEvent() {
    }

    public SwagEvent(TShirtSize tShirtSize) {
        this.tShirtSize = tShirtSize.toString();
    }

    public String gettShirtSize() {
        return tShirtSize;
    }
}
