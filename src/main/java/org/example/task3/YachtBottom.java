package org.example.task3;

//этот код вообще не тестировался.
public class YachtBottom {
    private YachtBottomState state;

    public YachtBottom(){
        state = YachtBottomState.DOWN;
    }

    public void BottomsUp(){
        state = YachtBottomState.UP;
    }

    public void BottomsDown(){
        state = YachtBottomState.DOWN;
    }

    public boolean isDowned() {
        return state == YachtBottomState.DOWN;
    }

}
