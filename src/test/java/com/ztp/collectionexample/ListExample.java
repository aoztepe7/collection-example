package com.ztp.collectionexample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

@RunWith(MockitoJUnitRunner.class)
public class ListExample {

    @Test
    public void listAdding() {
        List<String> exampleList = getDummyList(3);

        Assert.assertEquals(3,exampleList.size());
    }

    @Test
    public void listAddAll() {
        List<String> exampleList = getDummyList(3);

        List<String> finalList = new ArrayList<>();
        finalList.addAll(exampleList);

        Assert.assertEquals("0. Entry",finalList.get(0));
    }

    @Test
    public void removeAll() {
        List<String> exampleList = getDummyList(3);
        exampleList.clear();

        Assert.assertEquals(0,exampleList.size());
    }

    @Test
    public void equals_Success() {
        List<String> exampleList = getDummyList(3);
        List<String> exampleList1 = getDummyList(3);
        boolean result = exampleList.equals(exampleList1);

        Assert.assertTrue(result);
    }

    @Test
    public void equals_Fail() {
        List<String> exampleList = getDummyList(3);
        List<String> exampleList1 = new ArrayList<>();

        boolean result = exampleList.equals(exampleList1);

        Assert.assertFalse(result);
    }

    @Test
    public void listHashCode() {
        List<String> exampleList = getDummyList(3);

        Assert.assertEquals(-1662991666,exampleList.hashCode());
    }

    @Test
    public void getIndex() {
        List<String> exampleList = getDummyList(3);

        Assert.assertEquals("1. Entry",exampleList.get(1));
    }

    @Test
    public void isEmptyFalse() {
        List<String> exampleList = getDummyList(3);

        Assert.assertFalse(exampleList.isEmpty());
    }

    @Test
    public void isEmptyTrue() {
        List<String> exampleList = new ArrayList<>();

        Assert.assertTrue(exampleList.isEmpty());
    }

    @Test
    public void lastIndexOfSpecified() {
        List<String> exampleList = getDummyList(3);

        Assert.assertEquals(0,exampleList.lastIndexOf("0. Entry"));
    }

    @Test
    public void lastIndexOfWrong() {
        List<String> exampleList = getDummyList(3);

        Assert.assertEquals(-1,exampleList.lastIndexOf("3. Entry"));
    }

    @Test
    public void containsTrue() {
        List<String> exampleList = getDummyList(3);

        boolean result = exampleList.contains("0. Entry");

        Assert.assertTrue(result);
    }

    @Test
    public void containsFalse() {
        List<String> exampleList = getDummyList(3);

        boolean result = exampleList.contains("3. Entry");

        Assert.assertFalse(result);
    }

    @Test
    public void containsAllTrue() {
        List<String> exampleList = getDummyList(3);
        List<String> copyList = new ArrayList<>();
        copyList.add("2. Entry");
        copyList.add("1. Entry");
        copyList.add("0. Entry");

        boolean result = exampleList.containsAll(copyList);

        Assert.assertTrue(result);
    }

    @Test
    public void containsAllFalse() {
        List<String> exampleList = getDummyList(3);
        List<String> copyList = new ArrayList<>();
        copyList.add("2. Entry");
        copyList.add("1. Entry");
        copyList.add("3. Entry");

        boolean result = exampleList.containsAll(copyList);

        Assert.assertFalse(result);
    }

    @Test
    public void intIndex() {
        List<String> exampleList = getDummyList(3);

        int result = exampleList.indexOf("2. Entry");

        Assert.assertEquals(2,result);
    }

    @Test
    public void removeWithIndex() {
        List<String> exampleList = getDummyList(3);

        exampleList.remove(2);

        Assert.assertEquals(2,exampleList.size());
        Assert.assertEquals(-1,exampleList.lastIndexOf("2. Entry"));
    }

    @Test
    public void removeWithObject() {
        List<String> exampleList = getDummyList(3);

        exampleList.remove("1. Entry");

        Assert.assertEquals(2,exampleList.size());
        Assert.assertEquals(-1,exampleList.lastIndexOf("1. Entry"));
    }

    @Test
    public void removeWithObjectWithDuplicateValues() {
        List<String> exampleList = new ArrayList<>();
        exampleList.add("1");
        exampleList.add("1");
        exampleList.add("2");
        exampleList.add("3");

        exampleList.remove("1");

        Assert.assertEquals(3,exampleList.size());
        Assert.assertEquals(0,exampleList.lastIndexOf("1"));
    }

    @Test
    public void listRemoveAll() {
        List<String> exampleList = getDummyList(3);
        List<String> removeList = getDummyList(3);

        exampleList.removeAll(removeList);

        Assert.assertEquals(0,exampleList.size());
    }

    @Test
    public void replaceAll() {
        List<String> exampleList = getDummyList(3);

        Collections.replaceAll(exampleList,"0. Entry","Replaced Entry");

        Assert.assertEquals("Replaced Entry",exampleList.get(0));
        Assert.assertEquals(-1,exampleList.lastIndexOf("0. Entry"));
    }

    @Test
    public void retainAll() {
        List<String> exampleList = getDummyList(3);
        List<String> exampleList2 = new ArrayList<>();
        exampleList2.add("1. Entry");
        exampleList2.add("4. Entry");
        exampleList2.add("5. Entry");

        exampleList2.retainAll(exampleList);

        Assert.assertEquals(1,exampleList2.size());
        Assert.assertEquals("1. Entry",exampleList2.get(0));
        Assert.assertEquals(-1,exampleList2.lastIndexOf("4. Entry"));
    }

    @Test
    public void listSet() {
        List<String> exampleList = getDummyList(3);
        exampleList.set(0,"Added Entry");

        Assert.assertEquals(3,exampleList.size());
        Assert.assertEquals("Added Entry",exampleList.get(0));
        Assert.assertEquals(-1,exampleList.lastIndexOf("0. Entry"));
    }

    @Test
    public void sortList() {
        List<String> exampleList = getDummyList(3);
        exampleList.set(0,"Added Entry");

        Collections.sort(exampleList);

        Assert.assertEquals("1. Entry",exampleList.get(0));
        Assert.assertEquals("Added Entry",exampleList.get(2));
    }

    @Test
    public void subList() {
        List<String> exampleList = getDummyList(3);
        List<String> subList = exampleList.subList(0,1);

        Assert.assertEquals(1,subList.size());
        Assert.assertEquals("0. Entry",subList.get(0));
    }

    @Test
    public void spliterator() {
        List<String> exampleList = getDummyList(3);
        Spliterator<String> spliterator = exampleList.spliterator();

        spliterator.forEachRemaining(System.out::println);
    }



    private List<String> getDummyList(int count){
        List<String> exampleList = new ArrayList<>();
        for(int i = 0;i<count;i++){
            exampleList.add(i+". Entry");
        }
        return exampleList;
    }
}
