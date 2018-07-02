package com.codingdojo.Functional;

import java.util.ArrayList;

public class FArray extends ArrayList{
    public void iterate(CallbackNull cb){
        for(int i=0;i<this.size();i++) cb.call(this.get(i));
    }

    public FArray filter(Callback cb){
        FArray list = new FArray();

        for(int i=0;i<this.size();i++)
            if(cb.call(this.get(i))) list.add(this.get(i));

        return list;
    }

    public FArray reduce(Callback cb){
        FArray list = new FArray();

        for(int i=0;i<this.size();i++)
            if(!cb.call(this.get(i))) list.add(this.get(i));

        return list;
    }

    public static void main(String[] args){
        FArray f = new FArray();
        f.add(10);
        f.add(20);
        f.add(30);
        f.add(40);
        f.add(50);

        f = f.filter((Object o)->(int)o > 20);
        f.iterate((Object i)->System.out.println(i));

        System.out.println("----------------------");

        f = f.reduce((Object o)->(int)o < 40);
        f.iterate((Object i)->System.out.println(i));
    }
}

