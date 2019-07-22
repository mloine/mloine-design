package com.mloine.design.pipelineMode;

/**
 * 自定义管道实现
 */
public class MyPipeline implements Pipeline {

    protected Valve first;

    protected  Valve basic;

    public Valve getFirst() {
        return first;
    }

    public Valve getBasic() {
        return basic;
    }

    public void setBasic(Valve v) {
        basic = v;
    }

    public void addValue(Valve v) {
        if(first == null){
            first = v;
            v.setNext(basic);
        }else{
            Valve current = first;
            while(current != null){
                if(current.getNext() == basic){
                    current.setNext(v);
                    v.setNext(basic);
                }
                current = current.getNext();
            }
        }
    }
}
