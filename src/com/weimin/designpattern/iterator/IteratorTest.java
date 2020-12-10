package com.weimin.designpattern.iterator;

import java.util.Iterator;

/**
 * @Author weimin
 * @Date 2020/10/9 0009 14:29
 */
public class IteratorTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Iterator iterator = animal.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Animal implements Iterable{

    static String[] strings = new String[]{
            "lion","tiger","cat","dog","pig","bird"
    };


    int index = -1;
    @Override
    public Iterator iterator() {
        return new AnimalIterator();
    }

    // 对数组进行遍历
    class AnimalIterator implements Iterator {

        @Override
        public boolean hasNext() {
            if(index>=strings.length-1){
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            return strings[++index];
        }
    }
}

